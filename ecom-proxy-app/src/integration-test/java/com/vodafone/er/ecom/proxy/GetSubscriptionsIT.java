package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.*;

public class GetSubscriptionsIT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void testGetSubsciptions2() throws Exception {

        final String msisdn = String.valueOf(new Random().nextInt());

        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*", new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        final PurchaseAuthorization auth2 = EcomApiFactory.getPurchaseApi(Locale.UK)
                .purchasePackageMsisdn("test", msisdn, "2PP_P001__X__package:2PP_P001_TAX_999_999_999_999_999_*_*_false_false", new PurchaseAttributes());
        assertNotNull(auth2);
        assertTrue("Auth2 response is false", auth2.isSuccess());

        SubscriptionFilterImpl filter = new SubscriptionFilterImpl();
        filter.setTransactionsNotRequired("no");
        final Subscription[] subscriptions = EcomApiFactory.getSelfcareApi(Locale.UK).getSubscriptions("test", msisdn, 0, new SubscriptionFilterImpl());
        assertNotNull(subscriptions);
        assertTrue("Size= " + subscriptions.length, subscriptions.length > 0);
        assertEquals("Size= " + subscriptions.length, subscriptions.length, 2);

//        assertTrue(subscriptions[0] instanceof Subsc);

        Subscription subscription1 = subscriptions[0];
        Subscription subscription2 = subscriptions[1];

        //TODO no purchasesServices being returned.  Can populate these if required but may need a change in ER
        softly.assertThat(subscription1.getPurchasedServices()).as(" subscription1.getPurchasedServices()" ).isNotNull();
/*      softly.assertThat(subscription1.getPurchasedServices()[0].getId() ).as(" subscription1.getPurchasedServices()[0].getId()" ).isEqualTo(new Long(19)) ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getServiceId() ).as(" subscription1.getPurchasedServices()[0].getServiceId()" ).isEqualTo("2PP_S001");
        softly.assertThat(subscription1.getPurchasedServices()[0].getProvStatus() ).as(" subscription1.getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getLastProvisionUpdate() ).as(" subscription1.getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getStatus() ).as(" subscription1.getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getSubscription() ).as(" subscription1.getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getServiceClass() ).as(" subscription1.getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getUpdateTimeStamp() ).as(" subscription1.getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getNonRefundDescription() ).as(" subscription1.getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getCountryId() ).as(" subscription1.getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getProvisioningTag() ).as(" subscription1.getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(subscription1.getPurchasedServices()[0].isProvisionOnUsage() ).as(" subscription1.getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getId() ).as(" subscription1.getPurchasedServices()[0].getId()" ).isEqualTo(new Long(19)) ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getServiceId() ).as(" subscription1.getPurchasedServices()[0].getServiceId()" ).isEqualTo("2PP_S001");
        softly.assertThat(subscription1.getPurchasedServices()[0].getProvStatus() ).as(" subscription1.getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getLastProvisionUpdate() ).as(" subscription1.getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getStatus() ).as(" subscription1.getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(subscription1.getPurchasedServices()[0].getSubscription() ).as(" subscription1.getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getServiceClass() ).as(" subscription1.getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getUpdateTimeStamp() ).as(" subscription1.getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getNonRefundDescription() ).as(" subscription1.getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getCountryId() ).as(" subscription1.getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(subscription1.getPurchasedServices()[0].getProvisioningTag() ).as(" subscription1.getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(subscription1.getPurchasedServices()[0].isProvisionOnUsage() ).as(" subscription1.getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;

        */
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(subscription1.getCountry() ).as(" subscription1.getCountry()" ).isNull();
        softly.assertThat(subscription1.getSubscriptionId() ).as(" subscription1.getSubscriptionId()" ).isEqualTo("33");
        softly.assertThat(subscription1.getPackageClass() ).as(" subscription1.getPackageClass()" ).isNull();
        softly.assertThat(subscription1.getPackageId() ).as(" subscription1.getPackageId()" ).isNull();
        softly.assertThat(subscription1.getPartnerId() ).as(" subscription1.getPartnerId()" ).isNull();
        softly.assertThat(subscription1.isActive() ).as(" subscription1.isActive()" ).isTrue() ;
        softly.assertThat(subscription1.getExtensionPeriod() ).as(" subscription1.getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(subscription1.isArchived() ).as(" subscription1.isArchived()" ).isFalse() ;
// java.util.Date
        softly.assertThat(subscription1.isRecurring() ).as(" subscription1.isRecurring()" ).isFalse() ;
// java.util.Date
// com.vizzavi.ecommerce.business.catalog.PricePoint
        softly.assertThat(subscription1.isPromotional() ).as(" subscription1.isPromotional()" ).isFalse() ;
        softly.assertThat(subscription1.getPromotionalExpiryDate() ).as(" subscription1.getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(subscription1.getStatus() ).as(" subscription1.getStatus()" ).isEqualTo(1) ;
        softly.assertThat(subscription1.getExternalSubId() ).as(" subscription1.getExternalSubId()" ).isNull();
        softly.assertThat(subscription1.getResourceBalances() ).as(" subscription1.getResourceBalances()" ).isNull();
        softly.assertThat(subscription1.getMicroServiceSubList() ).as(" subscription1.getMicroServiceSubList()" ).isNull();
        softly.assertThat(subscription1.isRefundable() ).as(" subscription1.isRefundable()" ).isFalse() ;
        softly.assertThat(subscription1.isSuperPackage() ).as(" subscription1.isSuperPackage()" ).isFalse() ;
        softly.assertThat(subscription1.isSuspended() ).as(" subscription1.isSuspended()" ).isFalse() ;
        softly.assertThat(subscription1.getPaymentType() ).as(" subscription1.getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(subscription1.isDefault() ).as(" subscription1.isDefault()" ).isFalse() ;
        softly.assertThat(subscription1.getMerchantName() ).as(" subscription1.getMerchantName()" ).isNull();
        softly.assertThat(subscription1.getRenewalPreRate() ).as(" subscription1.getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(subscription1.getExtIdentifier1() ).as(" subscription1.getExtIdentifier1()" ).isNull();
        softly.assertThat(subscription1.getExtIdentifier2() ).as(" subscription1.getExtIdentifier2()" ).isNull();
        softly.assertThat(subscription1.getExtIdentifier3() ).as(" subscription1.getExtIdentifier3()" ).isNull();
//        softly.assertThat(subscription1.getOptions() ).as(" subscription1.getOptions()" ).isNull(); //TODO Options.getPaymentId is null so NPE
        softly.assertThat(subscription1.getSubscriptionIdLong() ).as(" subscription1.getSubscriptionIdLong()" ).isEqualTo(new Long(33)) ;
        softly.assertThat(subscription1.getMsisdn() ).as(" subscription1.getMsisdn()" ).isEqualTo("-1546597348");
        softly.assertThat(subscription1.getCsrId() ).as(" subscription1.getCsrId()" ).isNull();
        softly.assertThat(subscription1.getAccount() ).as(" subscription1.getAccount()" ).isNull();
// java.util.Date
// java.util.Date
        softly.assertThat(subscription1.isInactiveOrClosed() ).as(" subscription1.isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(subscription1.isFailed() ).as(" subscription1.isFailed()" ).isFalse() ;
        softly.assertThat(subscription1.isBeingProvisioned() ).as(" subscription1.isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(subscription1.isReserved() ).as(" subscription1.isReserved()" ).isFalse() ;
        softly.assertThat(subscription1.getLinkedPtID() ).as(" subscription1.getLinkedPtID()" ).isNull();
        softly.assertThat(subscription1.isPreOrdered() ).as(" subscription1.isPreOrdered()" ).isFalse() ;
        softly.assertThat(subscription1.getContentPaymentType() ).as(" subscription1.getContentPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(subscription1.getPurchaseDeviceType() ).as(" subscription1.getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(subscription1.getNextCyclePercentDiscount() ).as(" subscription1.getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(subscription1.getNextPaymentAmount() ).as(" subscription1.getNextPaymentAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(subscription1.getResourceBalancesList() ).as(" subscription1.getResourceBalancesList()" ).isNull();
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(subscription1.getPaymentTransactionId() ).as(" subscription1.getPaymentTransactionId()" ).isNotNull() ;
        softly.assertThat(subscription1.getNonRefundDescription() ).as(" subscription1.getNonRefundDescription()" ).isEqualTo("Sorry, the package is not refundable, because at least one of its service is not refundable!");
        softly.assertThat(subscription1.getInteractiveUsageFlag() ).as(" subscription1.getInteractiveUsageFlag()" ).isEqualTo(1) ;
        softly.assertThat(subscription1.isFirstUsage() ).as(" subscription1.isFirstUsage()" ).isTrue() ;
        softly.assertThat(subscription1.isSubscriptionUsed() ).as(" subscription1.isSubscriptionUsed()" ).isFalse() ;
        softly.assertThat(subscription1.getCurrentNoOfOccurences() ).as(" subscription1.getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
// java.util.Date
        softly.assertThat(subscription1.getPenaltyCharge() ).as(" subscription1.getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(subscription1.isMinSubscriptionPeriodElapsed() ).as(" subscription1.isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(subscription1.isUnderGracePeriod() ).as(" subscription1.isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(subscription1.getBatchRetryDate() ).as(" subscription1.getBatchRetryDate()" ).isNull();
        softly.assertThat(subscription1.getOverdueExpiryDate() ).as(" subscription1.getOverdueExpiryDate()" ).isNull();
        softly.assertThat(subscription1.getLastExpiryDate() ).as(" subscription1.getLastExpiryDate()" ).isNull();
        softly.assertThat(subscription1.isWasRecurringTrial() ).as(" subscription1.isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(subscription1.getParentPackageID() ).as(" subscription1.getParentPackageID()" ).isNull();
// com.vizzavi.ecommerce.business.selfcare.TransactionType

        //TODO No Transactions being returned even when property set to no
        softly.assertThat(subscription1.getTransactions().size()).as(" subscription1.getTransactions().get(0).getSubscriptionId()" ).isNotEqualTo(0);

//        softly.assertThat(subscription1.getTransactions().get(0).getSubscriptionId() ).as(" subscription1.getTransactions().get(0).getSubscriptionId()" ).isEqualTo("33");
//        softly.assertThat(subscription1.getTransactions().get(0).getServiceId() ).as(" subscription1.getTransactions().get(0).getServiceId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getClientId() ).as(" subscription1.getTransactions().get(0).getClientId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPackageId() ).as(" subscription1.getTransactions().get(0).getPackageId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPartnerId() ).as(" subscription1.getTransactions().get(0).getPartnerId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getAccessDevice() ).as(" subscription1.getTransactions().get(0).getAccessDevice()" ).isEqualTo(0) ;
//        softly.assertThat(subscription1.getTransactions().get(0).isZeroCostIgnore() ).as(" subscription1.getTransactions().get(0).isZeroCostIgnore()" ).isFalse() ;
//        softly.assertThat(subscription1.getTransactions().get(0).getMatchingAttributes() ).as(" subscription1.getTransactions().get(0).getMatchingAttributes()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getRateIdentifier() ).as(" subscription1.getTransactions().get(0).getRateIdentifier()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getUsageTime() ).as(" subscription1.getTransactions().get(0).getUsageTime()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getStatus() ).as(" subscription1.getTransactions().get(0).getStatus()" ).isEqualTo(101) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getResourceBalances() ).as(" subscription1.getTransactions().get(0).getResourceBalances()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getAuthCode() ).as(" subscription1.getTransactions().get(0).getAuthCode()" ).isEqualTo("P00007/19Z 1469110782338");
//        softly.assertThat(subscription1.getTransactions().get(0).getStandardRate() ).as(" subscription1.getTransactions().get(0).getStandardRate()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getPaymentErrorId() ).as(" subscription1.getTransactions().get(0).getPaymentErrorId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPaymentErrorDescription() ).as(" subscription1.getTransactions().get(0).getPaymentErrorDescription()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getTransactionId() ).as(" subscription1.getTransactions().get(0).getTransactionId()" ).isEqualTo("19");
//        softly.assertThat(subscription1.getTransactions().get(0).getTransactionIdLong() ).as(" subscription1.getTransactions().get(0).getTransactionIdLong()" ).isEqualTo(new Long(19)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getPaymentStatus() ).as(" subscription1.getTransactions().get(0).getPaymentStatus()" ).isEqualTo(0) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getTaxAmount() ).as(" subscription1.getTransactions().get(0).getTaxAmount()" ).isEqualTo(new Double(0.35)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getPaymentInfo() ).as(" subscription1.getTransactions().get(0).getPaymentInfo()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getNonRefundableDescription() ).as(" subscription1.getTransactions().get(0).getNonRefundableDescription()" ).isNullOrEmpty();
//        softly.assertThat(subscription1.getTransactions().get(0).getNonRefundableDescription() ).as(" subscription1.getTransactions().get(0).getNonRefundableDescription()" ).isEqualTo("");
//        softly.assertThat(subscription1.getTransactions().get(0).isRefundable() ).as(" subscription1.getTransactions().get(0).isRefundable()" ).isTrue() ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(subscription1.getTransactions().get(0).getReason() ).as(" subscription1.getTransactions().get(0).getReason()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).isSuccess() ).as(" subscription1.getTransactions().get(0).isSuccess()" ).isTrue() ;
//        softly.assertThat(subscription1.getTransactions().get(0).getContentName() ).as(" subscription1.getTransactions().get(0).getContentName()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getAssetID() ).as(" subscription1.getTransactions().get(0).getAssetID()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPaymentType() ).as(" subscription1.getTransactions().get(0).getPaymentType()" ).isEqualTo(0) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getEventDateTime() ).as(" subscription1.getTransactions().get(0).getEventDateTime()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getEventUnits() ).as(" subscription1.getTransactions().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getBearer() ).as(" subscription1.getTransactions().get(0).getBearer()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getExpressFlag() ).as(" subscription1.getTransactions().get(0).getExpressFlag()" ).isFalse() ;
//        softly.assertThat(subscription1.getTransactions().get(0).getTierName() ).as(" subscription1.getTransactions().get(0).getTierName()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPromoPrecode() ).as(" subscription1.getTransactions().get(0).getPromoPrecode()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPromoUniqueCode() ).as(" subscription1.getTransactions().get(0).getPromoUniqueCode()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getNextCycleDiscount() ).as(" subscription1.getTransactions().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//        softly.assertThat(subscription1.getTransactions().get(0).getDescription() ).as(" subscription1.getTransactions().get(0).getDescription()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getTaxRate() ).as(" subscription1.getTransactions().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getProductCode() ).as(" subscription1.getTransactions().get(0).getProductCode()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getMerchantName() ).as(" subscription1.getTransactions().get(0).getMerchantName()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getInvoiceText() ).as(" subscription1.getTransactions().get(0).getInvoiceText()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getAggregatorId() ).as(" subscription1.getTransactions().get(0).getAggregatorId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getReceipientMsisdn() ).as(" subscription1.getTransactions().get(0).getReceipientMsisdn()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getAffiliateID() ).as(" subscription1.getTransactions().get(0).getAffiliateID()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getContentCategory() ).as(" subscription1.getTransactions().get(0).getContentCategory()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getSubscriptionIdLong() ).as(" subscription1.getTransactions().get(0).getSubscriptionIdLong()" ).isEqualTo(new Long(33)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getAccessChannel() ).as(" subscription1.getTransactions().get(0).getAccessChannel()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPurchaseChannel() ).as(" subscription1.getTransactions().get(0).getPurchaseChannel()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getDeviceID() ).as(" subscription1.getTransactions().get(0).getDeviceID()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getMsisdn() ).as(" subscription1.getTransactions().get(0).getMsisdn()" ).isEqualTo("-1546597348");
//        softly.assertThat(subscription1.getTransactions().get(0).getExternalField1() ).as(" subscription1.getTransactions().get(0).getExternalField1()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getExternalField2() ).as(" subscription1.getTransactions().get(0).getExternalField2()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getExternalTransId() ).as(" subscription1.getTransactions().get(0).getExternalTransId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getCsrId() ).as(" subscription1.getTransactions().get(0).getCsrId()" ).isEqualTo("test");
//        softly.assertThat(subscription1.getTransactions().get(0).getLocalPurchaseDate() ).as(" subscription1.getTransactions().get(0).getLocalPurchaseDate()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getLocalPurchaseDateCal() ).as(" subscription1.getTransactions().get(0).getLocalPurchaseDateCal()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getPurchaseRate() ).as(" subscription1.getTransactions().get(0).getPurchaseRate()" ).isEqualTo(new Double(2.35)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getPurchaseNetRate() ).as(" subscription1.getTransactions().get(0).getPurchaseNetRate()" ).isEqualTo(new Double(2.0)) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(subscription1.getTransactions().get(0).getNextCycleDiscountPercent() ).as(" subscription1.getTransactions().get(0).getNextCycleDiscountPercent()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getRefundEnlargementDate() ).as(" subscription1.getTransactions().get(0).getRefundEnlargementDate()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getRefundPaymentTransactionId() ).as(" subscription1.getTransactions().get(0).getRefundPaymentTransactionId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getRefundPaymentTransactionIdLong() ).as(" subscription1.getTransactions().get(0).getRefundPaymentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getRefundable() ).as(" subscription1.getTransactions().get(0).getRefundable()" ).isTrue() ;
//        softly.assertThat(subscription1.getTransactions().get(0).getModificationInfo() ).as(" subscription1.getTransactions().get(0).getModificationInfo()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getHostId() ).as(" subscription1.getTransactions().get(0).getHostId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getNextCycleDiscountValue() ).as(" subscription1.getTransactions().get(0).getNextCycleDiscountValue()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getContentDescription() ).as(" subscription1.getTransactions().get(0).getContentDescription()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getSessionId() ).as(" subscription1.getTransactions().get(0).getSessionId()" ).isNullOrEmpty();
//        softly.assertThat(subscription1.getTransactions().get(0).getSessionId() ).as(" subscription1.getTransactions().get(0).getSessionId()" ).isEqualTo("");
//        softly.assertThat(subscription1.getTransactions().get(0).getAssetId() ).as(" subscription1.getTransactions().get(0).getAssetId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getBalanceImpact() ).as(" subscription1.getTransactions().get(0).getBalanceImpact()" ).isEqualTo(0) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getSubRecords() ).as(" subscription1.getTransactions().get(0).getSubRecords()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getDeviceId() ).as(" subscription1.getTransactions().get(0).getDeviceId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getSuitabilityDecision() ).as(" subscription1.getTransactions().get(0).getSuitabilityDecision()" ).isEqualTo(0) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getParentTransactionId() ).as(" subscription1.getTransactions().get(0).getParentTransactionId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getParentTransactionIdLong() ).as(" subscription1.getTransactions().get(0).getParentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(subscription1.getTransactions().get(0).getSubPeriodStart() ).as(" subscription1.getTransactions().get(0).getSubPeriodStart()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getSubPeriodEnd() ).as(" subscription1.getTransactions().get(0).getSubPeriodEnd()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getReIssue() ).as(" subscription1.getTransactions().get(0).getReIssue()" ).isEqualTo(0) ;
//        softly.assertThat(subscription1.getTransactions().get(0).isContainsReIssueService() ).as(" subscription1.getTransactions().get(0).isContainsReIssueService()" ).isFalse() ;
//        softly.assertThat(subscription1.getTransactions().get(0).getIsPrepay() ).as(" subscription1.getTransactions().get(0).getIsPrepay()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getModifyTransactionId() ).as(" subscription1.getTransactions().get(0).getModifyTransactionId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getChildSpId() ).as(" subscription1.getTransactions().get(0).getChildSpId()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).getSpType() ).as(" subscription1.getTransactions().get(0).getSpType()" ).isNull();
//        softly.assertThat(subscription1.getTransactions().get(0).isRefundTransaction() ).as(" subscription1.getTransactions().get(0).isRefundTransaction()" ).isFalse() ;
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
// java.sql.Timestamp
// java.sql.Timestamp
//        softly.assertThat(subscription1.getTransactions().get(0).getSpId() ).as(" subscription1.getTransactions().get(0).getSpId()" ).isNull();

        softly.assertThat(subscription1.getPreviousStatus() ).as(" subscription1.getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(subscription1.isParentAlsoPurchased() ).as(" subscription1.isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(subscription1.isProvisionOnUsageSuccess() ).as(" subscription1.isProvisionOnUsageSuccess()" ).isFalse() ;
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.GregorianCalendar
// java.util.GregorianCalendar
        softly.assertThat(subscription1.getLastUsageTransactionIdForSameContent() ).as(" subscription1.getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(subscription1.getSpId() ).as(" subscription1.getSpId()" ).isNull();
        softly.assertThat(subscription1.getPartnerTaxRate() ).as(" subscription1.getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;

        //TODO Country is correctly returned as null so this test is not required.
//      softly.assertThat(subscription1.getCountryId() ).as(" subscription1.getCountryId()" ).isNull();
        softly.assertThat(subscription1.isWasRecurringPromoCode() ).as(" subscription1.isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(subscription1.getLastPaymentTransaction() ).as(" subscription1.getLastPaymentTransaction()" ).isNull();
        softly.assertThat(subscription1.getB2BPartner() ).as(" subscription1.getB2BPartner()" ).isNull();
        softly.assertThat(subscription1.getRenewalCounterToLinkedPricepoint() ).as(" subscription1.getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(subscription1.isRenewalPreRateGross() ).as(" subscription1.isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(subscription1.getNextPricePointId() ).as(" subscription1.getNextPricePointId()" ).isNull();
        softly.assertThat(subscription1.getLastPaymentTransactionAmount() ).as(" subscription1.getLastPaymentTransactionAmount()" ).isEqualTo(new Double(2.35)) ;
        softly.assertThat(subscription1.getLastToLastPaymentTransactionAmount() ).as(" subscription1.getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(subscription1.isPricePointChangeOnRenewal() ).as(" subscription1.isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(subscription1.getOldSubscriptionId() ).as(" subscription1.getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(subscription1.getOldMsisdn() ).as(" subscription1.getOldMsisdn()" ).isNull();
        softly.assertThat(subscription1.isProvisionable() ).as(" subscription1.isProvisionable()" ).isFalse() ;
        softly.assertThat(subscription1.getFuturePricePointRenewals() ).as(" subscription1.getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(subscription1.getPurcServiceList() ).as(" subscription1.getPurcServiceList()" ).isNull();
        softly.assertThat(subscription1.getNextCyclePercentValue() ).as(" subscription1.getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(subscription1.getLockId() ).as(" subscription1.getLockId()" ).isEqualTo(new Long(0)) ;

//TODO Purchased Services are not populated
/*        softly.assertThat(subscription2.getPurchasedServices()[0].getId() ).as(" subscription2.getPurchasedServices()[0].getId()" ).isEqualTo(new Long(18)) ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getServiceId() ).as(" subscription2.getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
        softly.assertThat(subscription2.getPurchasedServices()[0].getProvStatus() ).as(" subscription2.getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getLastProvisionUpdate() ).as(" subscription2.getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getStatus() ).as(" subscription2.getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getSubscription() ).as(" subscription2.getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getServiceClass() ).as(" subscription2.getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getUpdateTimeStamp() ).as(" subscription2.getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getNonRefundDescription() ).as(" subscription2.getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getCountryId() ).as(" subscription2.getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getProvisioningTag() ).as(" subscription2.getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(subscription2.getPurchasedServices()[0].isProvisionOnUsage() ).as(" subscription2.getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getId() ).as(" subscription2.getPurchasedServices()[0].getId()" ).isEqualTo(new Long(18)) ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getServiceId() ).as(" subscription2.getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
        softly.assertThat(subscription2.getPurchasedServices()[0].getProvStatus() ).as(" subscription2.getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getLastProvisionUpdate() ).as(" subscription2.getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getStatus() ).as(" subscription2.getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(subscription2.getPurchasedServices()[0].getSubscription() ).as(" subscription2.getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getServiceClass() ).as(" subscription2.getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getUpdateTimeStamp() ).as(" subscription2.getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getNonRefundDescription() ).as(" subscription2.getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getCountryId() ).as(" subscription2.getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(subscription2.getPurchasedServices()[0].getProvisioningTag() ).as(" subscription2.getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(subscription2.getPurchasedServices()[0].isProvisionOnUsage() ).as(" subscription2.getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;

        */


// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(subscription2.getCountry() ).as(" subscription2.getCountry()" ).isNull();
        softly.assertThat(subscription2.getSubscriptionId() ).as(" subscription2.getSubscriptionId()" ).isEqualTo("32");
        softly.assertThat(subscription2.getPackageClass() ).as(" subscription2.getPackageClass()" ).isNull();
        softly.assertThat(subscription2.getPackageId() ).as(" subscription2.getPackageId()" ).isNull();
        softly.assertThat(subscription2.getPartnerId() ).as(" subscription2.getPartnerId()" ).isNull();
        softly.assertThat(subscription2.isActive() ).as(" subscription2.isActive()" ).isTrue() ;
        softly.assertThat(subscription2.getExtensionPeriod() ).as(" subscription2.getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(subscription2.isArchived() ).as(" subscription2.isArchived()" ).isFalse() ;
// java.util.Date
        softly.assertThat(subscription2.isRecurring() ).as(" subscription2.isRecurring()" ).isTrue() ;
// java.util.Date
// com.vizzavi.ecommerce.business.catalog.PricePoint
        softly.assertThat(subscription2.isPromotional() ).as(" subscription2.isPromotional()" ).isFalse() ;
        softly.assertThat(subscription2.getPromotionalExpiryDate() ).as(" subscription2.getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(subscription2.getStatus() ).as(" subscription2.getStatus()" ).isEqualTo(1) ;
        softly.assertThat(subscription2.getExternalSubId() ).as(" subscription2.getExternalSubId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(subscription2.getResourceBalances()[0].getSubscriptionId() ).as(" subscription2.getResourceBalances()[0].getSubscriptionId()" ).isEqualTo("32");
        softly.assertThat(subscription2.getResourceBalances()[0].getPackageId() ).as(" subscription2.getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(subscription2.getResourceBalances()[0].getBalance() ).as(" subscription2.getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(subscription2.getResourceBalances()[0].getSubscription() ).as(" subscription2.getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(subscription2.getResourceBalances()[0].getThreshold() ).as(" subscription2.getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(subscription2.getResourceBalances()[0].getSubscriptionIdLong() ).as(" subscription2.getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(32)) ;
        softly.assertThat(subscription2.getResourceBalances()[0].getOldestSubscriptionId() ).as(" subscription2.getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(subscription2.getMicroServiceSubList() ).as(" subscription2.getMicroServiceSubList()" ).isNull();
        softly.assertThat(subscription2.isRefundable() ).as(" subscription2.isRefundable()" ).isFalse() ;
        softly.assertThat(subscription2.isSuperPackage() ).as(" subscription2.isSuperPackage()" ).isFalse() ;
        softly.assertThat(subscription2.isSuspended() ).as(" subscription2.isSuspended()" ).isFalse() ;
        softly.assertThat(subscription2.getPaymentType() ).as(" subscription2.getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(subscription2.isDefault() ).as(" subscription2.isDefault()" ).isFalse() ;
        softly.assertThat(subscription2.getMerchantName() ).as(" subscription2.getMerchantName()" ).isNull();
        softly.assertThat(subscription2.getRenewalPreRate() ).as(" subscription2.getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(subscription2.getExtIdentifier1() ).as(" subscription2.getExtIdentifier1()" ).isNull();
        softly.assertThat(subscription2.getExtIdentifier2() ).as(" subscription2.getExtIdentifier2()" ).isNull();
        softly.assertThat(subscription2.getExtIdentifier3() ).as(" subscription2.getExtIdentifier3()" ).isNull();
//        softly.assertThat(subscription2.getOptions() ).as(" subscription2.getOptions()" ).isNull(); TODO getPaymentId throws NPE
        softly.assertThat(subscription2.getSubscriptionIdLong() ).as(" subscription2.getSubscriptionIdLong()" ).isEqualTo(new Long(32)) ;
        softly.assertThat(subscription2.getMsisdn() ).as(" subscription2.getMsisdn()" ).isEqualTo("-1546597348");
        softly.assertThat(subscription2.getCsrId() ).as(" subscription2.getCsrId()" ).isEqualTo("test");
        softly.assertThat(subscription2.getAccount() ).as(" subscription2.getAccount()" ).isNull();
// java.util.Date
// java.util.Date
        softly.assertThat(subscription2.isInactiveOrClosed() ).as(" subscription2.isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(subscription2.isFailed() ).as(" subscription2.isFailed()" ).isFalse() ;
        softly.assertThat(subscription2.isBeingProvisioned() ).as(" subscription2.isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(subscription2.isReserved() ).as(" subscription2.isReserved()" ).isFalse() ;
        softly.assertThat(subscription2.getLinkedPtID() ).as(" subscription2.getLinkedPtID()" ).isNull();
        softly.assertThat(subscription2.isPreOrdered() ).as(" subscription2.isPreOrdered()" ).isFalse() ;
        softly.assertThat(subscription2.getContentPaymentType() ).as(" subscription2.getContentPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(subscription2.getPurchaseDeviceType() ).as(" subscription2.getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(subscription2.getNextCyclePercentDiscount() ).as(" subscription2.getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(subscription2.getNextPaymentAmount() ).as(" subscription2.getNextPaymentAmount()" ).isEqualTo(new Double(10.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getSubscriptionId() ).as(" subscription2.getResourceBalancesList().get(0).getSubscriptionId()" ).isEqualTo("32");
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getPackageId() ).as(" subscription2.getResourceBalancesList().get(0).getPackageId()" ).isNull();
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getBalance() ).as(" subscription2.getResourceBalancesList().get(0).getBalance()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getSubscription() ).as(" subscription2.getResourceBalancesList().get(0).getSubscription()" ).isNull();
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getThreshold() ).as(" subscription2.getResourceBalancesList().get(0).getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getSubscriptionIdLong() ).as(" subscription2.getResourceBalancesList().get(0).getSubscriptionIdLong()" ).isEqualTo(new Long(32)) ;
        softly.assertThat(subscription2.getResourceBalancesList().get(0).getOldestSubscriptionId() ).as(" subscription2.getResourceBalancesList().get(0).getOldestSubscriptionId()" ).isNull();
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(subscription2.getPaymentTransactionId() ).as(" subscription2.getPaymentTransactionId()" ).isNotNull() ;
        softly.assertThat(subscription2.getNonRefundDescription() ).as(" subscription2.getNonRefundDescription()" ).isNull();
        softly.assertThat(subscription2.getInteractiveUsageFlag() ).as(" subscription2.getInteractiveUsageFlag()" ).isEqualTo(1) ;
        softly.assertThat(subscription2.isFirstUsage() ).as(" subscription2.isFirstUsage()" ).isTrue() ;
        softly.assertThat(subscription2.isSubscriptionUsed() ).as(" subscription2.isSubscriptionUsed()" ).isFalse() ;
        softly.assertThat(subscription2.getCurrentNoOfOccurences() ).as(" subscription2.getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
// java.util.Date
        softly.assertThat(subscription2.getPenaltyCharge() ).as(" subscription2.getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(subscription2.isMinSubscriptionPeriodElapsed() ).as(" subscription2.isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(subscription2.isUnderGracePeriod() ).as(" subscription2.isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(subscription2.getBatchRetryDate() ).as(" subscription2.getBatchRetryDate()" ).isNull();
        softly.assertThat(subscription2.getOverdueExpiryDate() ).as(" subscription2.getOverdueExpiryDate()" ).isNull();
        softly.assertThat(subscription2.getLastExpiryDate() ).as(" subscription2.getLastExpiryDate()" ).isNull();
        softly.assertThat(subscription2.isWasRecurringTrial() ).as(" subscription2.isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(subscription2.getParentPackageID() ).as(" subscription2.getParentPackageID()" ).isNull();
// com.vizzavi.ecommerce.business.selfcare.TransactionType

        //TODO Transactions are not being returned

        softly.assertThat(subscription2.getTransactions().size()).as(" subscription2.getTransactions().get(0).getSubscriptionId()" ).isNotEqualTo(0);

//        softly.assertThat(subscription2.getTransactions().get(0).getSubscriptionId() ).as(" subscription2.getTransactions().get(0).getSubscriptionId()" ).isEqualTo("32");
//        softly.assertThat(subscription2.getTransactions().get(0).getServiceId() ).as(" subscription2.getTransactions().get(0).getServiceId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getClientId() ).as(" subscription2.getTransactions().get(0).getClientId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPackageId() ).as(" subscription2.getTransactions().get(0).getPackageId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPartnerId() ).as(" subscription2.getTransactions().get(0).getPartnerId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getAccessDevice() ).as(" subscription2.getTransactions().get(0).getAccessDevice()" ).isEqualTo(0) ;
//        softly.assertThat(subscription2.getTransactions().get(0).isZeroCostIgnore() ).as(" subscription2.getTransactions().get(0).isZeroCostIgnore()" ).isFalse() ;
//        softly.assertThat(subscription2.getTransactions().get(0).getMatchingAttributes() ).as(" subscription2.getTransactions().get(0).getMatchingAttributes()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getRateIdentifier() ).as(" subscription2.getTransactions().get(0).getRateIdentifier()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getUsageTime() ).as(" subscription2.getTransactions().get(0).getUsageTime()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getStatus() ).as(" subscription2.getTransactions().get(0).getStatus()" ).isEqualTo(101) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getResourceBalances() ).as(" subscription2.getTransactions().get(0).getResourceBalances()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getAuthCode() ).as(" subscription2.getTransactions().get(0).getAuthCode()" ).isEqualTo("P00007/18Z 1469110780944");
//        softly.assertThat(subscription2.getTransactions().get(0).getStandardRate() ).as(" subscription2.getTransactions().get(0).getStandardRate()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getPaymentErrorId() ).as(" subscription2.getTransactions().get(0).getPaymentErrorId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPaymentErrorDescription() ).as(" subscription2.getTransactions().get(0).getPaymentErrorDescription()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getTransactionId() ).as(" subscription2.getTransactions().get(0).getTransactionId()" ).isEqualTo("18");
//        softly.assertThat(subscription2.getTransactions().get(0).getTransactionIdLong() ).as(" subscription2.getTransactions().get(0).getTransactionIdLong()" ).isEqualTo(new Long(18)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getPaymentStatus() ).as(" subscription2.getTransactions().get(0).getPaymentStatus()" ).isEqualTo(0) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getTaxAmount() ).as(" subscription2.getTransactions().get(0).getTaxAmount()" ).isEqualTo(new Double(1.75)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getPaymentInfo() ).as(" subscription2.getTransactions().get(0).getPaymentInfo()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getNonRefundableDescription() ).as(" subscription2.getTransactions().get(0).getNonRefundableDescription()" ).isNullOrEmpty();
//        softly.assertThat(subscription2.getTransactions().get(0).getNonRefundableDescription() ).as(" subscription2.getTransactions().get(0).getNonRefundableDescription()" ).isEqualTo("");
//        softly.assertThat(subscription2.getTransactions().get(0).isRefundable() ).as(" subscription2.getTransactions().get(0).isRefundable()" ).isTrue() ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(subscription2.getTransactions().get(0).getReason() ).as(" subscription2.getTransactions().get(0).getReason()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).isSuccess() ).as(" subscription2.getTransactions().get(0).isSuccess()" ).isTrue() ;
//        softly.assertThat(subscription2.getTransactions().get(0).getContentName() ).as(" subscription2.getTransactions().get(0).getContentName()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getAssetID() ).as(" subscription2.getTransactions().get(0).getAssetID()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPaymentType() ).as(" subscription2.getTransactions().get(0).getPaymentType()" ).isEqualTo(0) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getEventDateTime() ).as(" subscription2.getTransactions().get(0).getEventDateTime()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getEventUnits() ).as(" subscription2.getTransactions().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getBearer() ).as(" subscription2.getTransactions().get(0).getBearer()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getExpressFlag() ).as(" subscription2.getTransactions().get(0).getExpressFlag()" ).isFalse() ;
//        softly.assertThat(subscription2.getTransactions().get(0).getTierName() ).as(" subscription2.getTransactions().get(0).getTierName()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPromoPrecode() ).as(" subscription2.getTransactions().get(0).getPromoPrecode()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPromoUniqueCode() ).as(" subscription2.getTransactions().get(0).getPromoUniqueCode()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getNextCycleDiscount() ).as(" subscription2.getTransactions().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//        softly.assertThat(subscription2.getTransactions().get(0).getDescription() ).as(" subscription2.getTransactions().get(0).getDescription()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getTaxRate() ).as(" subscription2.getTransactions().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getProductCode() ).as(" subscription2.getTransactions().get(0).getProductCode()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getMerchantName() ).as(" subscription2.getTransactions().get(0).getMerchantName()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getInvoiceText() ).as(" subscription2.getTransactions().get(0).getInvoiceText()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getAggregatorId() ).as(" subscription2.getTransactions().get(0).getAggregatorId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getReceipientMsisdn() ).as(" subscription2.getTransactions().get(0).getReceipientMsisdn()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getAffiliateID() ).as(" subscription2.getTransactions().get(0).getAffiliateID()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getContentCategory() ).as(" subscription2.getTransactions().get(0).getContentCategory()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getSubscriptionIdLong() ).as(" subscription2.getTransactions().get(0).getSubscriptionIdLong()" ).isEqualTo(new Long(32)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getAccessChannel() ).as(" subscription2.getTransactions().get(0).getAccessChannel()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPurchaseChannel() ).as(" subscription2.getTransactions().get(0).getPurchaseChannel()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getDeviceID() ).as(" subscription2.getTransactions().get(0).getDeviceID()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getMsisdn() ).as(" subscription2.getTransactions().get(0).getMsisdn()" ).isEqualTo("-1546597348");
//        softly.assertThat(subscription2.getTransactions().get(0).getExternalField1() ).as(" subscription2.getTransactions().get(0).getExternalField1()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getExternalField2() ).as(" subscription2.getTransactions().get(0).getExternalField2()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getExternalTransId() ).as(" subscription2.getTransactions().get(0).getExternalTransId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getCsrId() ).as(" subscription2.getTransactions().get(0).getCsrId()" ).isEqualTo("test");
//        softly.assertThat(subscription2.getTransactions().get(0).getLocalPurchaseDate() ).as(" subscription2.getTransactions().get(0).getLocalPurchaseDate()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getLocalPurchaseDateCal() ).as(" subscription2.getTransactions().get(0).getLocalPurchaseDateCal()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getPurchaseRate() ).as(" subscription2.getTransactions().get(0).getPurchaseRate()" ).isEqualTo(new Double(11.75)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getPurchaseNetRate() ).as(" subscription2.getTransactions().get(0).getPurchaseNetRate()" ).isEqualTo(new Double(10.0)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getNextCycleDiscountPercent() ).as(" subscription2.getTransactions().get(0).getNextCycleDiscountPercent()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getRefundEnlargementDate() ).as(" subscription2.getTransactions().get(0).getRefundEnlargementDate()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getRefundPaymentTransactionId() ).as(" subscription2.getTransactions().get(0).getRefundPaymentTransactionId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getRefundPaymentTransactionIdLong() ).as(" subscription2.getTransactions().get(0).getRefundPaymentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getRefundable() ).as(" subscription2.getTransactions().get(0).getRefundable()" ).isTrue() ;
//        softly.assertThat(subscription2.getTransactions().get(0).getModificationInfo() ).as(" subscription2.getTransactions().get(0).getModificationInfo()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getHostId() ).as(" subscription2.getTransactions().get(0).getHostId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getNextCycleDiscountValue() ).as(" subscription2.getTransactions().get(0).getNextCycleDiscountValue()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getContentDescription() ).as(" subscription2.getTransactions().get(0).getContentDescription()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getSessionId() ).as(" subscription2.getTransactions().get(0).getSessionId()" ).isNullOrEmpty();
//        softly.assertThat(subscription2.getTransactions().get(0).getSessionId() ).as(" subscription2.getTransactions().get(0).getSessionId()" ).isEqualTo("");
//        softly.assertThat(subscription2.getTransactions().get(0).getAssetId() ).as(" subscription2.getTransactions().get(0).getAssetId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getBalanceImpact() ).as(" subscription2.getTransactions().get(0).getBalanceImpact()" ).isEqualTo(0) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getSubRecords() ).as(" subscription2.getTransactions().get(0).getSubRecords()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getDeviceId() ).as(" subscription2.getTransactions().get(0).getDeviceId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getSuitabilityDecision() ).as(" subscription2.getTransactions().get(0).getSuitabilityDecision()" ).isEqualTo(0) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getParentTransactionId() ).as(" subscription2.getTransactions().get(0).getParentTransactionId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getParentTransactionIdLong() ).as(" subscription2.getTransactions().get(0).getParentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(subscription2.getTransactions().get(0).getSubPeriodStart() ).as(" subscription2.getTransactions().get(0).getSubPeriodStart()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getSubPeriodEnd() ).as(" subscription2.getTransactions().get(0).getSubPeriodEnd()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getReIssue() ).as(" subscription2.getTransactions().get(0).getReIssue()" ).isEqualTo(0) ;
//        softly.assertThat(subscription2.getTransactions().get(0).isContainsReIssueService() ).as(" subscription2.getTransactions().get(0).isContainsReIssueService()" ).isFalse() ;
//        softly.assertThat(subscription2.getTransactions().get(0).getIsPrepay() ).as(" subscription2.getTransactions().get(0).getIsPrepay()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getModifyTransactionId() ).as(" subscription2.getTransactions().get(0).getModifyTransactionId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getChildSpId() ).as(" subscription2.getTransactions().get(0).getChildSpId()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).getSpType() ).as(" subscription2.getTransactions().get(0).getSpType()" ).isNull();
//        softly.assertThat(subscription2.getTransactions().get(0).isRefundTransaction() ).as(" subscription2.getTransactions().get(0).isRefundTransaction()" ).isFalse() ;
//        softly.assertThat(subscription2.getTransactions().get(0).getSpId() ).as(" subscription2.getTransactions().get(0).getSpId()" ).isNull();
        softly.assertThat(subscription2.getPreviousStatus() ).as(" subscription2.getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(subscription2.isParentAlsoPurchased() ).as(" subscription2.isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(subscription2.isProvisionOnUsageSuccess() ).as(" subscription2.isProvisionOnUsageSuccess()" ).isFalse() ;
        softly.assertThat(subscription2.getLastUsageTransactionIdForSameContent() ).as(" subscription2.getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(subscription2.getSpId() ).as(" subscription2.getSpId()" ).isNull();
        softly.assertThat(subscription2.getPartnerTaxRate() ).as(" subscription2.getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;

        //TODO Test not required
//        softly.assertThat(subscription2.getCountryId() ).as(" subscription2.getCountryId()" ).isNull();
        softly.assertThat(subscription2.isWasRecurringPromoCode() ).as(" subscription2.isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(subscription2.getLastPaymentTransaction() ).as(" subscription2.getLastPaymentTransaction()" ).isNull();
        softly.assertThat(subscription2.getB2BPartner() ).as(" subscription2.getB2BPartner()" ).isNull();
        softly.assertThat(subscription2.getRenewalCounterToLinkedPricepoint() ).as(" subscription2.getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(subscription2.isRenewalPreRateGross() ).as(" subscription2.isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(subscription2.getNextPricePointId() ).as(" subscription2.getNextPricePointId()" ).isNull();
        softly.assertThat(subscription2.getLastPaymentTransactionAmount() ).as(" subscription2.getLastPaymentTransactionAmount()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(subscription2.getLastToLastPaymentTransactionAmount() ).as(" subscription2.getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(subscription2.isPricePointChangeOnRenewal() ).as(" subscription2.isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(subscription2.getOldSubscriptionId() ).as(" subscription2.getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(subscription2.getOldMsisdn() ).as(" subscription2.getOldMsisdn()" ).isNull();
        softly.assertThat(subscription2.isProvisionable() ).as(" subscription2.isProvisionable()" ).isFalse() ;
        softly.assertThat(subscription2.getFuturePricePointRenewals() ).as(" subscription2.getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(subscription2.getPurcServiceList() ).as(" subscription2.getPurcServiceList()" ).isNull();
        softly.assertThat(subscription2.getNextCyclePercentValue() ).as(" subscription2.getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(subscription2.getLockId() ).as(" subscription2.getLockId()" ).isEqualTo(new Long(0)) ;

        softly.assertAll();


    }

}
