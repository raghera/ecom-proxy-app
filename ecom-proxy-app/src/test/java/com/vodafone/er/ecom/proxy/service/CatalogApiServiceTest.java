package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Ravi Aghera
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DecouplingApiFactory.class)
public class CatalogApiServiceTest {


    //SUT
    private CatalogApiService processor;

    @Mock
    private CatalogApi catalogApi;
    @Mock
    private DecouplingApiFactory decouplingApiFactory;

    @Before
    public void setUp() {

//        PowerMockito.mockStatic(DecouplingApiFactory.class);
//        PowerMockito.when(DecouplingApiFactory.getCatalogApi(any(Locale.class), anyString()))
//                .thenReturn(new CatalogApiStub(Locale.UK));
//
//        processor = new CatalogApiService(Locale.UK, "ecom-client-id");
//
//        MockitoAnnotations.initMocks(processor);
    }

    @Test
    @Ignore //TODO - incomplete test currently.  Find a better way to create test objects
    public void shouldProcessCatalogPackageSuccess() {
/*
        //given
        final String serviceId = "test-service-id";
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

        when(catalogApi.getService(serviceId)).thenReturn(serviceResponse);
        when(catalogApi.getPricePoint(anyString())).thenReturn(servicePp);

        //when
        CatalogPackage result = processor.processCatalogPackage(resultPackage);

        //then
        assertNotNull(result);
        assertEquals(result.getSimplePackageId(), "pAlt");
        verify(catalogApi).getService(serviceId);
        verify(catalogApi, times(3)).getPricePoint(anyString());
*/
    }





}
