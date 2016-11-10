//package com.vodafone.er.ecom.proxy.service;
//
//import com.vizzavi.ecommerce.business.catalog.CatalogApi;
//import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
//import com.vizzavi.ecommerce.business.catalog.PricePoint;
//import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import java.util.Locale;
//
//import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.aCatalogPackage;
//import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.*;
//
///**
// * Created by Ravi Aghera
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(DecouplingApiFactory.class)
//public class CatalogApiPackageTest {
//
//
//    private static final String serviceId = "test-service-id";
//
//    //SUT
//    private CatalogApiService processor;
//
//    @Mock
//    private CatalogApi catalogApi;
//    @Mock
//    private DecouplingApiFactory decouplingApiFactory;
//
//    @Before
//    @Ignore
//    public void setUp() {
//        processor = new CatalogApiService();
//
//        PowerMockito.mockStatic(DecouplingApiFactory.class);
//        PowerMockito.when(DecouplingApiFactory.getCatalogApi(Locale.UK, CLIENT_ID.value()))
//                .thenReturn(catalogApi);
//
//        MockitoAnnotations.initMocks(processor);
//    }
//
//    @Ignore
//    public void shouldProcessCatalogPackageSuccess() {
//        //given
//        final CatalogPackage pack = aCatalogPackage();
//        final CatalogPackage expectedPack = aCatalogPackage();
//        expectedPack.getPricePoints().get(0).setTaxCode("TAX");
////        expectedPack.getServices().get(0).getPricePoints().get(0).setTaxCode("TAX");
////        expectedPack.setTaxCode("TAX");
//        PricePoint ppt = pack.getPricePoints().get(0);
//
//        when(catalogApi.getPackage(pack.getId())).thenReturn(pack);
////        when(catalogApi.getService(pack.getServices().get(0).getId())).thenReturn(pack.getServices().get(0));
//        when(catalogApi.getPricePoint(pack.getPricePoints().get(0).getId())).thenReturn(ppt);
////        when(catalogApi.getPricePoint(pack.getServices().get(0).getPricePoints().get(0).getId())).thenReturn(ppt);
//
//        //when
//        CatalogPackage result = processor.getCatalogPackage(Locale.UK, pack.getId());
//
//        //then
//        assertNotNull(result);
//        assertEquals(expectedPack.getId(), result.getSimplePackageId());
//        assertThat(result).as("CatalogPackage fields ought to be the same").isEqualToIgnoringGivenFields(expectedPack, "mServices", "mPricePoints");
////        assertThat(result.getServices().get(0)).isEqualToIgnoringGivenFields(expectedPack.getServices().get(0), "mPricePoints");
//
//        assertThat(result.getPricePoints().get(0))
//                .as("Pricepoints")
//                .isEqualToIgnoringGivenFields(expectedPack.getPricePoints().get(0),
//                        "mBalances", "mPricePointTier", "mMultiUsageMode", "mNetworkCodeMatchMethod", "mRefuseUsageWhenProvisioning");
//        verify(catalogApi).getService(anyString());
//        verify(catalogApi, times(2)).getPricePoint(anyString());//1 service & 1 package
//
//    }
//
//
//
//
//
//}
