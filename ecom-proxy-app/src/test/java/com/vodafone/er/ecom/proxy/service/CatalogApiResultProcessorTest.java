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

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DecouplingApiFactory.class)
public class CatalogApiResultProcessorTest {


    //SUT
    private CatalogApiResultProcessor processor;

    @Mock
    private CatalogApi catalogApi;
    @Mock
    private DecouplingApiFactory decouplingApiFactory;

    @Before
    public void setUp() {

        PowerMockito.mockStatic(DecouplingApiFactory.class);
        PowerMockito.when(DecouplingApiFactory.getCatalogApi(any(Locale.class), anyString()))
                .thenReturn(new CatalogApiStub(Locale.UK));

        processor = new CatalogApiResultProcessor(Locale.UK, "ecom-client-id");

        MockitoAnnotations.initMocks(processor);
    }

    @Test
    public void shouldProcessCatalogPackageSuccess() {

        //given
        final String serviceId = "test-service-id";
        CatalogPackage catalogPackage = new CatalogPackage();
        CatalogService serviceResponse = new CatalogService();
        PricePoint servicePp = new PricePoint();
        PricePoint packagePp = new PricePoint();
        serviceResponse.setId(serviceId);

        when(catalogApi.getService(serviceId)).thenReturn(serviceResponse);
        when(catalogApi.getPricePoint(anyString())).thenReturn(servicePp);

        //when
        processor.processCatalogPackage(catalogPackage);

        //then

        verify(catalogApi).getService(serviceId);
        verify(catalogApi, times(3)).getPricePoint(anyString());




    }




}
