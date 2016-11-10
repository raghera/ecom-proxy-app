package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.provision.ProvisionApi;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vizzavi.ecommerce.business.selfcare.ServiceStatus.BEING_PROVISIONED;
import static com.vizzavi.ecommerce.business.selfcare.ServiceStatus.PROVISION_DELAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by Ravi Aghera
 */
public class UpdateServiceStatus_IT {

    @Test
    public void testUpdateServiceStatus1() throws Exception {

        final String msisdn = String.valueOf(new Random().nextInt());
        String provisionalPackageId = "pPROV02__X__package:pPROV02_TAX_3_1002_10010_999_*";

        //Purchase
        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, provisionalPackageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());
        assertThat(auth).as("PurchaseAuth is null ").isNotNull();

        //getSubscriptions
        Subscription[] subscriptions = EcomApiFactory.getSelfcareApi(Locale.UK).getSubscriptions("test", msisdn, 0, new SubscriptionFilterImpl());
        assertNotNull(subscriptions);
        assertEquals("Size= " + subscriptions.length, subscriptions.length, 1);

        System.out.println("Response size=" + subscriptions.length);

        //provision call
        final String serviceId = "cPROVggg/";
        long subId = subscriptions[0].getSubscriptionIdLong();
        final String provisionId = serviceId + subId;
        System.out.println("provisionId: " + provisionId);

        final ProvisionApi provisionApi = EcomApiFactory.getProvisionApi(Locale.UK);
        boolean result = provisionApi.updateServiceStatus(provisionId, BEING_PROVISIONED, PROVISION_DELAY);

        assertThat(result).as("provisionApi.updateServiceStatus()").isTrue();

    }

}
