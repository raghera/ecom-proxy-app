package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.common.ResponseStatus;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getCustcareApi;
import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getSelfcareApi;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Copy of the Core Head Ecom Regression Test
 */
public class AdHocTests {

    PurchaseApi mPurchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
    SelfcareApi mSelfcareApi = getSelfcareApi(Locale.UK);
    ChargingApi mChargingApi = EcomApiFactory.getChargingApi(Locale.UK);
    CustcareApi mCustcareApi = getCustcareApi(Locale.UK);
    CatalogApi mCatalogApi = EcomApiFactory.getCatalogApi(Locale.UK);


    PurchaseApi purchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
    SelfcareApi selfcareApi = getSelfcareApi(Locale.UK);
    ChargingApi chargingApi = EcomApiFactory.getChargingApi(Locale.UK);
    CustcareApi custcareApi = getCustcareApi(Locale.UK);
    CatalogApi catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);

    String clientId = "AdhocTestClient";

    public AdHocTests() throws EcommerceException {
    }

    @Test
    public void simpleGetPackage2() throws Exception {

        //Refund Transaction test
        final String msisdn = String.valueOf(new Random().nextInt());
        String refundTransactionId = "";

//        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK)
//                .purchasePackageMsisdn("test", msisdn, "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*", new PurchaseAttributes());
//        assertNotNull(auth);
//        assertTrue("Auth response is false", auth.isSuccess());
//
//        final PurchaseAuthorization auth2 = EcomApiFactory.getPurchaseApi(Locale.UK)
//                .purchasePackageMsisdn("test", msisdn, "2PP_P001__X__package:2PP_P001_TAX_999_999_999_999_999_*_*_false_false", new PurchaseAttributes());
//        assertNotNull(auth2);
//        assertTrue("Auth2 response is false", auth2.isSuccess());
//
//        RefundAuthorization refundAuth = getCustcareApi(Locale.UK)
//                .refundTransactionMonetary("test", msisdn, refundTransactionId, 1.0, null, new RefundAttributes());

        String packageId = "CM004";  // one of the few packages that is refundable
        String packagePricepointId = "CM004__X__package:CM004_TAX_2_2_10010_999_*_*";
        PurchaseAttributes purchaseAttributes = new PurchaseAttributes();
        Calendar cal = Calendar.getInstance(Locale.UK);

        // purchase - create first payment transaction
        PurchaseAuthorization purchaseAuth = purchaseApi.purchasePackage(clientId, msisdn, packagePricepointId, purchaseAttributes);
        assertNotNull(purchaseAuth);
        assertTrue("Asserted purchaseAuth is success but wasn't: MSISDN: " + msisdn + "; purchaseAuth: " + purchaseAuth, purchaseAuth.isSuccess());

        // renew - create second payment transaction for same package
        PurchaseAuthorization renewAuth = purchaseApi.renewPurchasePackageMsisdn(clientId, msisdn, purchaseAuth.getSubscriptionIds()[0], purchaseAttributes);
        assertNotNull(renewAuth);
        assertTrue("Asserted renewAuth is success but wasn't: MSISDN: " + msisdn + "; renewAuth: " + renewAuth, renewAuth.isSuccess());

        refundTransactionId = renewAuth.getTransactionId();

        RefundAuthorization refundAuth = getCustcareApi(Locale.UK)
                .refundTransactionMonetary("test", msisdn, refundTransactionId, 1.0, null, new RefundAttributes());

        assertNotNull(refundAuth);
        assertTrue(refundAuth.isSuccess());
        System.out.println("TransactionId: " + refundAuth.getTransactionId());

        final Subscription[] subscriptions = getSelfcareApi(Locale.UK).getSubscriptions("test", msisdn, 0, new SubscriptionFilterImpl());
        assertNotNull(subscriptions);

        System.out.println("SubscriptionId: " + subscriptions[0].getRefundTransactions());

    }

    @Test
    public void getServiceIdFromPricePointId() {
        String serviceId1 = "content:BP001_TAX_B001_999_999_*_999_999";
        String serviceId2 = "content:BP001_*_B001_999_999_*_999_999";

        getServiceIdFromPpId(serviceId1);
        getServiceIdFromPpId(serviceId2);

    }
    public void getServiceIdFromPpId(String ppId) {
//            PaymentTxn txn = new PaymentTxn();
//            List<RefundTxn> txns = new ArrayList<>();
//            if (paymentTxns==null || paymentTxns.isEmpty())
//                return txns;
//            for (PaymentTxn txn: paymentTxns)       {
//                    txns.addAll(txn.getRefundTransactions());
//            }
    }

    @Test
    public void testValidateMsisdnAllUserGroupsAccepted() throws Exception
    {
        String msisdn = "88887772P" + System.currentTimeMillis();
        System.out.println("*************************************************************************************");
        System.out.println("********************************testValidateMsisdnAllUserGroupsAccepted************************************");
        System.out.println("********************************MUST BE RUN WITH DEMO VALIDATION HANDLER************************************");

        //Validate the account
        ValidateMsisdnAttributes validateAttributes = new ValidateMsisdnAttributes();
        validateAttributes.setServiceId("s1");
        validateAttributes.setPartnerId("partner1");
        validateAttributes.setVendorId("vendor1");

        AccountValidationAuthorization accountValidation = custcareApi.validateMsisdnAccount(msisdn, validateAttributes);
        assertNotNull(accountValidation);
        assertTrue(ResponseStatus.isAccepted(accountValidation.getStatus()));
        assertTrue(accountValidation.getBan().equals("BAN_"+msisdn));
        assertTrue(accountValidation.getUserGroups() != null);
        assertTrue(accountValidation.getUserGroups().length == 3);
        boolean vipFound = false;
        boolean directorFound = false;
        boolean adultFound = false;
        for (int i=0; i<3; i++) {
            if (accountValidation.getUserGroups()[i].equals("vip")) {
                vipFound = true;
            }
            if (accountValidation.getUserGroups()[i].equals("director")) {
                directorFound = true;
            }
            if (accountValidation.getUserGroups()[i].equals("adult")) {
                adultFound = true;
            }
        }
        assertTrue(vipFound);
        assertTrue(directorFound);
        assertTrue(adultFound);
        System.out.println("ACCOUNT VALIDATION ALL UGS= " + accountValidation);
    }

    @Test
    public void testUserGroup() throws Exception {
        UserGroup userGroup = new UserGroup();
        userGroup.setName("director");

        userGroup.hashCode();


    }

}
