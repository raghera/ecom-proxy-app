package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.RefundAttributes;
import com.vizzavi.ecommerce.business.charging.RefundAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.RefundTxn;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getCustcareApi;
import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getSelfcareApi;
import static org.junit.Assert.*;

/**
 * Tests to check Transactions are retrieved correctly
 */
public class GetSubscriptions2_modifyAndRefundTransactionIT {

    @Test
    public void shouldGetSubsciptions2WithModifyTransactionRecord() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*", new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        final PurchaseAuthorization auth2 = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "2PP_P001__X__package:2PP_P001_TAX_999_999_999_999_999_*_*_false_false", new PurchaseAttributes());
        assertNotNull(auth2);
        assertTrue("Auth2 response is false", auth2.isSuccess());

        //Do a modify subscriptions request to get a modify transaction in the response.
        boolean modifyResult = getSelfcareApi(Locale.UK)
                .modifySubscriptionChargingMethod("test",msisdn, 0, auth.getPackageSubscriptionId(), 2, "csrId", "test-reason");
        assertTrue(modifyResult);

        SubscriptionFilterImpl filter = new SubscriptionFilterImpl();
        filter.setIncludeModifyTxns(true);
        filter.setTransactionsNotRequired("no");
        final Subscription[] subscriptions = getSelfcareApi(Locale.UK).getSubscriptions("test", msisdn, 0, new SubscriptionFilterImpl());
        assertNotNull(subscriptions);
        assertTrue("Size= " + subscriptions.length, subscriptions.length > 0);
        assertEquals("Size= " + subscriptions.length, subscriptions.length, 2);

        List<Subscription> subscriptionList =
                Arrays.asList(subscriptions).stream().
                        filter(subscription ->
                                subscription.getPackage().getSimplePackageId().equals("pAlt"))
                        .collect(Collectors.toList());

        assertEquals(1, subscriptionList.size());

        assertNotNull(subscriptionList.get(0).getModifyTransactions());
        assertEquals(1, subscriptionList.get(0).getModifyTransactions().size());
    }

    /**
     * Currently this test just checks that there are no errors given this refund use case.
     * The refund is not currently possible by clients of the EPA.
     * @throws Exception
     */
    @Test
    public void shouldGetSubsciptions2WithRefundTransactionRecord() throws Exception {
        //Refund Transaction test
        final String msisdn = String.valueOf(new Random().nextInt());


        String packageId = "CM004";  // one of the few packages that is refundable
        String packagePricepointId = "CM004__X__package:CM004_TAX_2_2_10010_999_*_*";
        PurchaseAttributes purchaseAttributes = new PurchaseAttributes();
        Calendar cal = Calendar.getInstance(Locale.UK);

        // purchase - create first payment transaction
        PurchaseAuthorization purchaseAuth = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackage("test", msisdn, packagePricepointId, purchaseAttributes);
        assertNotNull(purchaseAuth);
        assertTrue("Asserted purchaseAuth is success but wasn't: MSISDN: " + msisdn + "; purchaseAuth: " + purchaseAuth, purchaseAuth.isSuccess());

        // renew - create second payment transaction for same package
        PurchaseAuthorization renewAuth = EcomApiFactory.getPurchaseApi(Locale.UK)
                .renewPurchasePackageMsisdn("test", msisdn, purchaseAuth.getSubscriptionIds()[0], purchaseAttributes);
        assertNotNull(renewAuth);
        assertTrue("Asserted renewAuth is success but wasn't: MSISDN: " + msisdn + "; renewAuth: " + renewAuth, renewAuth.isSuccess());

        final String refundTransactionId = renewAuth.getTransactionId();

        RefundAuthorization refundAuth = getCustcareApi(Locale.UK)
                .refundTransactionMonetary("test", msisdn, refundTransactionId, 1.0, null, new RefundAttributes());

        assertNotNull(refundAuth);
        assertTrue(refundAuth.isSuccess());
        System.out.println("refundTransactionId: " + refundAuth.getTransactionId());

        final Subscription[] subscriptions = getSelfcareApi(Locale.UK).getSubscriptions("test", msisdn, 0, new SubscriptionFilterImpl());
        assertNotNull(subscriptions);

        assertEquals(1, subscriptions.length);
        Subscription sub1 = subscriptions[0];

        List<RefundTxn> refundTran1 = sub1.getRefundTransactions();
        System.out.println(refundTran1.size());
        //Currently RefundTransactions are not being returned.
    }

}
