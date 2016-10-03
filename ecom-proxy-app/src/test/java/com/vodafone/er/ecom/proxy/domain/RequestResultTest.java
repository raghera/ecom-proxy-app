package com.vodafone.er.ecom.proxy.domain;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vodafone.er.ecom.proxy.processor.CatalogApiProcessor;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import org.junit.Test;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.*;

/**
 * Created by Ravi Aghera
 */
public class RequestResultTest {

    private String msisdn = "" + new Random().nextLong();

    @Test
    public void shouldCreateCatalogPackageList() {
        RequestResult<List<CatalogPackage>> result = new RequestResult
                .Builder<List<CatalogPackage>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(new CatalogPackage()))
                .build();

        assertNotNull(result);
        assertEquals(Locale.UK, result.getLocale());
        assertTrue(result.getMsisdn().isPresent());
        assertEquals(msisdn, result.getMsisdn().get());
        assertEquals(1, result.getResponse().size());
        assertNotNull(result.getResponse().get(0));
    }

    @Test
    public void shouldCallCatalogPackageProcessor() {
        RequestResult<List<CatalogPackage>> result = new RequestResult
                .Builder<List<CatalogPackage>>()
                .locale(Locale.UK)
                .msisdn(msisdn)
                .response(newArrayList(new CatalogPackage()))
                .build();

//        RequestResult<List<UsageAuthorization>> result2 = new RequestResult
//                .Builder<List<UsageAuthorization>>()
//                .locale(Locale.UK)
//                .msisdn(msisdn)
//                .response(newArrayList(new UsageAuthorization()))
//                .build();
//
//        RequestResult<List<UsageAuthorization>> result3 = new RequestResult
//                .Builder<List<PurchaseAuthorization>>()
//                .locale(Locale.UK)
//                .msisdn(msisdn)
//                .response(newArrayList(new PurchaseAuthorization()))
//                .build();

//        PostProcessor<RequestResult<List<UsageAuthorization>>> processor1 =
//                new ChargingApiProcessor<>();

        PostProcessor<RequestResult<List<CatalogPackage>>> processor2 =
                new CatalogApiProcessor<>();

//        PostProcessor<RequestResult<List<PurchaseAuthorization>>> processor3 =
//                new PurchaseApiProcessor<>();


//        pr.process(Locale.UK, msisdn, result);

        processor2.process(result);
//        processor1.process(result2);

//        processor2.process(Locale.UK, msisdn, result);

    }
}
