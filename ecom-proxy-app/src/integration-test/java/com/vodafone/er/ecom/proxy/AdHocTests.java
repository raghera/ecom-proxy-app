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
