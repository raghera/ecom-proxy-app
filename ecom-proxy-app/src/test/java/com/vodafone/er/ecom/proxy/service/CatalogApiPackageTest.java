package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.generated.CatalogApiStub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Locale;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.aCatalogPackage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DecouplingApiFactory.class)
public class CatalogApiPackageTest {


    private static final String serviceId = "test-service-id";

    //SUT
    private CatalogApiService processor;

    @Mock
    private CatalogApi catalogApi;
    @Mock
    private DecouplingApiFactory decouplingApiFactory;

    @Before
    public void setUp() {
        processor = new CatalogApiService();

        PowerMockito.mockStatic(DecouplingApiFactory.class);
        PowerMockito.when(DecouplingApiFactory.getCatalogApi(any(Locale.class), anyString()))
                .thenReturn(new CatalogApiStub(Locale.UK));

        MockitoAnnotations.initMocks(processor);
    }

    @Test
    public void shouldProcessCatalogPackageSuccess() {
        //given
        final CatalogPackage catalogPackage = aCatalogPackage();
        final CatalogPackage expected = aCatalogPackage();
        expected.setTaxCode("TAX");

        CatalogPackage resultPackage = new CatalogPackage();
        resultPackage.setId("pAlt");
        CatalogService resultService = new CatalogService();
        resultService.setId(serviceId);
        PricePoint resultPackagePp = new PricePoint();
        resultPackagePp.setId("pAlt");
        CatalogService serviceResponse = new CatalogService();
        resultPackage.setServices(newArrayList(resultService));
        PricePoint servicePp = new PricePoint();
//        PricePoint packagePp = new PricePoint();
        serviceResponse.setId(serviceId);

        when(catalogApi.getPackage(catalogPackage.getId())).thenReturn(catalogPackage);
        when(catalogApi.getService(serviceId)).thenReturn(catalogPackage.getServices().get(0));
        when(catalogApi.getPricePoint(anyString())).thenReturn(catalogPackage.getPricePoints().get(0));

        //when
        CatalogPackage result = processor.getCatalogPackage(Locale.UK, "pAlt");

        //then
        assertNotNull(result);
        assertEquals(result.getSimplePackageId(), "pAlt");
        verify(catalogApi).getService(serviceId);
        verify(catalogApi, times(3)).getPricePoint(anyString());

    }





}
