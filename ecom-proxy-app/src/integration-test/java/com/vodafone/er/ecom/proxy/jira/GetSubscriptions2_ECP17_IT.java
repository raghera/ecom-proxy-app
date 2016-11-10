package com.vodafone.er.ecom.proxy.jira;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.DeviceType;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getSelfcareApi;
import static org.junit.Assert.*;

/**
 * Created by Ravi Aghera
 */
public class GetSubscriptions2_ECP17_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void shouldGetSubsciptions2_Active() throws Exception {

        final String msisdn = String.valueOf(new Random().nextInt());

        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*", new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        final PurchaseAuthorization auth2 = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "2PP_P001__X__package:2PP_P001_TAX_999_999_999_999_999_*_*_false_false", new PurchaseAttributes());
        assertNotNull(auth2);
        assertTrue("Auth2 response is false", auth2.isSuccess());

        SubscriptionFilter filter = EcomApiFactory.getSubscriptionFilter();
        filter.setAscendingOrder(false);
        filter.setMaxEvents(100);
        filter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
        Subscription[] all = getSelfcareApi(Locale.UK).getSubscriptions("demo", msisdn, DeviceType.WAP, filter);

        assertNotNull(all);
        assertEquals(2, all.length);

    }


    @Test
    public void shouldGetSubsciptions2BeingProvisioned() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "pPROV01__X__package:pPROV01_TAX_3_2_10010_999_*", new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        SubscriptionFilter filter = EcomApiFactory.getSubscriptionFilter();
        filter.setSubscriptionStatus(SubscriptionStatus.BEING_PROVISIONED);
        filter.setAscendingOrder(false);
        filter.setMaxEvents(100);

        Subscription[] all = getSelfcareApi(Locale.UK).getSubscriptions("demo",msisdn, DeviceType.WAP, filter );
        assertNotNull(all);
        assertEquals(1, all.length);
    }


}