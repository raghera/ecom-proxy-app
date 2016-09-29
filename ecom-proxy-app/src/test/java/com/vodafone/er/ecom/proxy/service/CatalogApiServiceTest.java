package com.vodafone.er.ecom.proxy.service;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.CatalogApiProcessor;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import com.vodafone.global.er.business.catalog.BasePrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.BasePricesDataBuilder.aBasePrice;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.aCatalogPackage;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogServiceDataBuilder.aCatalogService;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.aPricePoint;
import static com.vodafone.er.ecom.proxy.data.builder.RequestResultDataBuilder.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class CatalogApiServiceTest {

    @Mock
    private PostProcessor<RequestResult<List<?>>> postProcessor;
    @Mock
    private ErApiManager erApiManager;
    @Mock
    private CatalogApi catalogApi;
    @Mock
    private CatalogApiProcessor catalogApiProcessor;

    @InjectMocks
    private CatalogApiService catalogApiService;

    @Test
    public void shouldCallGetPackageSuccessfully() {
        String packageId = "packageId_X";
        List<CatalogPackage> catalogPackages = newArrayList(aCatalogPackage());

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getPackage(packageId)).thenReturn(catalogPackages.get(0));
        when(postProcessor.process(any(RequestResult.class))).thenReturn(
                aCatalogPackageRequestResult(Locale.UK, "123", catalogPackages));

        CatalogPackage result = catalogApiService.getCatalogPackage(Locale.UK, packageId);
        assertNotNull(result);
        assertEquals(aCatalogPackage().getSimplePackageId(), result.getSimplePackageId());

        InOrder inOrder = inOrder(erApiManager, catalogApi, postProcessor);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getPackage(packageId);
        inOrder.verify(postProcessor).process(any(RequestResult.class));
        verifyNoMoreInteractions(erApiManager, catalogApi, postProcessor);
    }

    @Test
    public void shouldNotCallPostProcessWhenNullPackageReturned() {
        String packageId = "packageId_X";
        List<CatalogPackage> catalogPackages = newArrayList(aCatalogPackage());

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getPackage(packageId)).thenReturn(null);
        when(postProcessor.process(any(RequestResult.class))).thenReturn(
                aCatalogPackageRequestResult(Locale.UK, "123", catalogPackages));

        CatalogPackage result = catalogApiService.getCatalogPackage(Locale.UK, packageId);
        assertNull(result);

        InOrder inOrder = inOrder(erApiManager, catalogApi, postProcessor);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getPackage(packageId);
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, catalogApi);
    }

    @Test
    public void shouldCallGetServiceSuccessfully() {
        String serviceId = "serviceId_X";
        List<CatalogService> catalogServices = newArrayList(aCatalogService());

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getService(serviceId)).thenReturn(catalogServices.get(0));
        when(postProcessor.process(any(RequestResult.class))).thenReturn(
                aCatalogServiceRequestResult(Locale.UK, "123", catalogServices));

        CatalogService result = catalogApiService.getCatalogService(Locale.UK, serviceId);
        assertNotNull(result);
        assertThat(result).isEqualToComparingFieldByField(catalogServices.get(0));

        InOrder inOrder = inOrder(erApiManager, catalogApi, postProcessor);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getService(serviceId);
        inOrder.verify(postProcessor).process(any(RequestResult.class));
        verifyNoMoreInteractions(erApiManager, catalogApi, postProcessor);
    }

    @Test
    public void shouldNotCallPostProcessWhenNullServiceReturned() {
        String serviceId = "serviceId_X";

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getService(serviceId)).thenReturn(null);

        CatalogService result = catalogApiService.getCatalogService(Locale.UK, serviceId);
        assertNull(result);

        InOrder inOrder = inOrder(erApiManager, catalogApi);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getService(serviceId);
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, catalogApi);
    }

    @Test
    public void shouldCallGetPricePointSuccessfully() {
        String ppId = "pricepoint_X";
        List<PricePoint> pricePoints = newArrayList(aPricePoint());

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getPricePoint(ppId)).thenReturn(pricePoints.get(0));
        when(postProcessor.process(any(RequestResult.class))).thenReturn(
                aPricePointRequestResult(Locale.UK, "123", pricePoints));

        PricePoint result = catalogApiService.getPricePoint(Locale.UK, ppId);
        assertNotNull(result);
        assertThat(result).isEqualToComparingFieldByField(pricePoints.get(0));

        InOrder inOrder = inOrder(erApiManager, catalogApi, postProcessor);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getPricePoint(ppId);
        inOrder.verify(postProcessor).process(any(RequestResult.class));
        verifyNoMoreInteractions(erApiManager, catalogApi, postProcessor);
    }

    @Test
    public void shouldNotCallPostProcessWhenNullPricePointReturned() {
        String ppId = "pricepoint_X";

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getPricePoint(ppId)).thenReturn(null);

        PricePoint result = catalogApiService.getPricePoint(Locale.UK, ppId);
        assertNull(result);

        InOrder inOrder = inOrder(erApiManager, catalogApi);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getPricePoint(ppId);
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, catalogApi);
    }

    @Test
    public void shouldCallFPWSSuccessfully() {
        String msisdn = String.valueOf(new Random().nextLong());
        PurchaseAttributes attributes = new PurchaseAttributes();
        List<CatalogService> catalogServices = newArrayList(aCatalogService());
        List<CatalogPackage> catalogPackages = newArrayList(aCatalogPackage());

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.findPackagesWithService(msisdn, catalogServices.get(0), attributes))
                .thenReturn(catalogPackages.toArray(new CatalogPackage[catalogPackages.size()]));
        when(catalogApiProcessor.process(any(RequestResult.class)))
                .thenReturn(aCatalogPackageRequestResult(Locale.UK, "123", catalogPackages));

        CatalogPackage[] result = catalogApiService.findPackageWithService(Locale.UK, msisdn, catalogServices.get(0), new PurchaseAttributes());

        assertNotNull(result);
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualToComparingFieldByField(catalogPackages.get(0));

        InOrder inOrder = inOrder(erApiManager, catalogApi, catalogApiProcessor);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).findPackagesWithService(msisdn, catalogServices.get(0), attributes);
        inOrder.verify(catalogApiProcessor).postProcessFindPackagesWithService(Locale.UK, catalogPackages);
        verifyNoMoreInteractions(erApiManager, catalogApi, catalogApiProcessor, postProcessor);
    }

    @Test
    public void shouldNotCallPostProcessWhenEmptyFPWSReturned() {
        String msisdn = String.valueOf(new Random().nextLong());
        PurchaseAttributes attributes = new PurchaseAttributes();
        List<CatalogService> catalogServices = newArrayList(aCatalogService());
        List<CatalogPackage> catalogPackages = newArrayList(aCatalogPackage());

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.findPackagesWithService(msisdn, catalogServices.get(0), attributes))
                .thenReturn(catalogPackages.toArray(new CatalogPackage[catalogPackages.size()]));
        when(catalogApiProcessor.process(any(RequestResult.class)))
                .thenReturn(aCatalogPackageRequestResult(Locale.UK, "123", catalogPackages));

        CatalogPackage[] result =
                catalogApiService.findPackageWithService(Locale.UK, msisdn, catalogServices.get(0), new PurchaseAttributes());

        assertNotNull(result);
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualToComparingFieldByField(catalogPackages.get(0));

        InOrder inOrder = inOrder(erApiManager, catalogApi, catalogApiProcessor);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).findPackagesWithService(msisdn, catalogServices.get(0), attributes);
        inOrder.verify(catalogApiProcessor).postProcessFindPackagesWithService(Locale.UK, catalogPackages);
        verifyZeroInteractions(postProcessor, catalogApiProcessor);
        verifyNoMoreInteractions(erApiManager, catalogApi);
    }

    @Test
    public void shouldGetBasePrices() throws Exception {
        List<BasePrice> basePrices = Lists.newArrayList(aBasePrice());
        String[] serviceIds = new String[]{"Service1, Service2"};

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getBasePrices(serviceIds))
                .thenReturn(basePrices.toArray(new BasePrice[basePrices.size()]));

        BasePrice[] result = catalogApiService.getBasePrices(Locale.UK, serviceIds);
        assertNotNull(result);
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualToComparingFieldByField(basePrices.get(0));

        InOrder inOrder = inOrder(erApiManager, catalogApi);
        inOrder.verify(erApiManager).getCatalogApi(Locale.UK);
        inOrder.verify(catalogApi).getBasePrices(serviceIds);
        verifyNoMoreInteractions(erApiManager, catalogApi);

    }

    @Test
    public void shouldGetPackages() {
        List<CatalogPackage> catalogPackages = CatalogPackageDataBuilder.aCatalogPackageList(5);

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getPackages())
                .thenReturn(catalogPackages.toArray(new CatalogPackage[catalogPackages.size()]));

        CatalogPackage [] result = catalogApiService.getPackages(Locale.UK);
        assertNotNull(result);
        assertThat(result.length).isEqualTo(5);

        //TODO Add verifications

    }

    public void shouldGetVersion() {

        String version = "priceplanVersion2000";

        when(erApiManager.getCatalogApi(Locale.UK)).thenReturn(catalogApi);
        when(catalogApi.getVersion()).thenReturn(version);

        String result = catalogApiService.getVersion(Locale.UK);
        assertNotNull(version);
        assertThat(result).isEqualTo(version);

        //TODO Add verifications

    }

}



