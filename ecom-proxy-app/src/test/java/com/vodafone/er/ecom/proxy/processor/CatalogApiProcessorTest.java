package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.catalog.PricePoints;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.exception.EpaErrorMessageEnum;
import com.vodafone.er.ecom.proxy.exception.EpaServiceException;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import com.vodafone.global.er.util.CatalogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogServiceDataBuilder.aCatalogService;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.aPricePoint;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CatalogUtil.class)
public class CatalogApiProcessorTest {

    @Mock
    private CatalogApiService catalogApiService;

    @InjectMocks
    private CatalogApiProcessor catalogApiProcessor;

    @Test
    public void shouldProcessPackageFully() {

        String msisdn = "" + new Random().nextLong();
        CatalogPackage pack = CatalogPackageDataBuilder.aCatalogPackage();
        CatalogService[] serviceArray = pack.getServiceArray();
        assertEquals(1, serviceArray.length);
        CatalogService serviceToReturn = aCatalogService();
        PricePoint servicePpToReturn = aPricePoint();
        PricePoint packPpToReturn = aPricePoint();
        packPpToReturn.setTaxCode("TestTax");
        packPpToReturn.setTariff("TestTariff");

        when(catalogApiService.getCatalogService(Locale.UK, pack.getServiceArray()[0].getId()))
                .thenReturn(serviceToReturn);
        when(catalogApiService.getPricePoint(Locale.UK, serviceToReturn.getPricePoints().get(0).getId()))
                .thenReturn(servicePpToReturn);
        when(catalogApiService.getPricePoint(Locale.UK, pack.getPricePoints().get(0).getId()))
                .thenReturn(packPpToReturn);

        catalogApiProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(pack))
                .build());

        InOrder inOrder = inOrder(catalogApiService);
        inOrder.verify(catalogApiService).getCatalogService(Locale.UK, pack.getServiceArray()[0].getId());
        inOrder.verify(catalogApiService).getPricePoint(Locale.UK, serviceToReturn.getPricePoints().get(0).getId());
        inOrder.verify(catalogApiService).getPricePoint(Locale.UK, pack.getPricePoints().get(0).getId());

        //Check that the returned objects are the ones you get
        assertEquals(serviceToReturn.getPricePoints(), pack.getServiceArray()[0].getPricePoints());

        //Each service pricepoint should have correct pack and service ids populated
        pack.getServiceArray()[0].getPricePoints().forEach(servPp -> {
            assertEquals(pack.getSimplePackageId(), servPp.getPackageId());
            assertEquals(pack.getServiceArray()[0].getId(), servPp.getContentId());
            assertEquals(servicePpToReturn.getTaxCode(), servPp.getTaxCode());
            assertEquals(servicePpToReturn.getTariff(), servPp.getTariff());
        });

        //Test Package pricepoints
        pack.getPricePoints().forEach(packPp -> {
            assertEquals(pack.getSimplePackageId(), packPp.getPackageId());
            assertEquals(packPpToReturn.getTaxCode(), packPp.getTaxCode());
            assertEquals(packPpToReturn.getTariff(), packPp.getTariff());
        });
        //TODO test balance impacts in it's own test

    }

    @Test
    public void shouldNotProcessPackageWhenEmptyResponseList() {
        String msisdn = "" + new Random().nextLong();
        catalogApiProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList())
                .build());

        verifyZeroInteractions(catalogApiService);
    }

    @Test
    public void shouldHandleNoServicePricePoints() {

        String msisdn = "" + new Random().nextLong();
        CatalogPackage pack = CatalogPackageDataBuilder.aCatalogPackage();
        CatalogService[] serviceArray = pack.getServiceArray();
        assertEquals(1, serviceArray.length);
        CatalogService serviceToReturn = mock(CatalogService.class);
        PricePoint servicePpToReturn = aPricePoint();
        PricePoint packPpToReturn = aPricePoint();
        servicePpToReturn.setId("ServicePpId");

        when(catalogApiService.getCatalogService(Locale.UK, pack.getServiceArray()[0].getId()))
                .thenReturn(serviceToReturn);
        when(serviceToReturn.getPricePoints()).thenReturn(new PricePoints());
        when(catalogApiService.getPricePoint(Locale.UK, pack.getPricePoints().get(0).getId()))
                .thenReturn(packPpToReturn);

        catalogApiProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(pack))
                .build());

        InOrder inOrder = inOrder(catalogApiService);
        inOrder.verify(catalogApiService).getCatalogService(Locale.UK, pack.getServiceArray()[0].getId());
        verify(catalogApiService, times(0)).getPricePoint(any(Locale.class), eq(servicePpToReturn.getId()));
        inOrder.verify(catalogApiService).getPricePoint(Locale.UK, pack.getPricePoints().get(0).getId());

        //Check that the returned objects are the ones you get
        assertEquals(serviceToReturn.getPricePoints(), pack.getServiceArray()[0].getPricePoints());

    }

    @Test(expected = EpaServiceException.class)
    public void shouldPropogateEcommerceExceptionFromServiceCall() {

        String msisdn = "" + new Random().nextLong();
        CatalogPackage pack = CatalogPackageDataBuilder.aCatalogPackage();
        CatalogService[] serviceArray = pack.getServiceArray();
        assertEquals(1, serviceArray.length);
        PricePoint servicePpToReturn = aPricePoint();
        servicePpToReturn.setId("ServicePpId");

        when(catalogApiService.getCatalogService(Locale.UK, pack.getServiceArray()[0].getId()))
                .thenThrow(new EpaServiceException(EpaErrorMessageEnum.ERROR_FROM_CORE, new EcommerceException("Test-Exception")));

        catalogApiProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(pack))
                .build());
    }

    @Test
    public void shouldProcessCatalogServiceFully() {
        String msisdn = "" + new Random().nextLong();
        CatalogService service = aCatalogService();

        PowerMockito.mockStatic(CatalogUtil.class);
        PowerMockito.when(CatalogUtil.getPackageIdFromServicePricepoint(anyString()))
                .thenReturn("test-package-id");
        PowerMockito.when(CatalogUtil.getTaxCodeFromPricePointId(anyString()))
                .thenReturn("test-TAX-code");

        catalogApiProcessor.process(new RequestResult.Builder<List<CatalogService>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(service))
                .build());

        //Verify static
        PowerMockito.verifyStatic(times(1));
        CatalogUtil.getPackageIdFromServicePricepoint(anyString());
        PowerMockito.verifyStatic(times(1));
        CatalogUtil.getTaxCodeFromPricePointId(anyString());

        service.getPricePoints().forEach(pricePoint -> {
            assertEquals("test-TAX-code", pricePoint.getTaxCode());
            assertEquals("test-package-id", pricePoint.getPackageId());
            assertEquals(service.getId(), pricePoint.getContentId());
        });
    }

    @Test
    public void shouldNotProcessWhenNoResponse() {

        String msisdn = "" + new Random().nextLong();
        catalogApiProcessor.process(new RequestResult.Builder<List<CatalogService>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList())
                .build());

        PowerMockito.verifyStatic();
        PowerMockito.verifyZeroInteractions(CatalogUtil.class);

    }

    @Test
    public void shouldProcessPricePointSuccessfully() {
        String msisdn = "" + new Random().nextLong();
        PricePoint pricePoint = aPricePoint();
        pricePoint.setTaxCode(null);

        PowerMockito.mockStatic(CatalogUtil.class);
        PowerMockito.when(CatalogUtil.getTaxCodeFromPricePointId(anyString())).thenReturn("test-TAX-code");

        catalogApiProcessor.process(new RequestResult.Builder<List<PricePoint>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(pricePoint))
                .build());

        PowerMockito.verifyStatic(times(1));
        CatalogUtil.getTaxCodeFromPricePointId(anyString());

        assertEquals("test-TAX-code", pricePoint.getTaxCode());

    }

    @Test
    public void shouldNotProcessPricePointWhenEmptyResponse() {
        String msisdn = "" + new Random().nextLong();

        catalogApiProcessor.process(new RequestResult.Builder<List<PricePoint>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList())
                .build());

        PowerMockito.verifyStatic();
        PowerMockito.verifyZeroInteractions(CatalogUtil.class);
    }
}
