package com.vodafone.er.ecom.proxy.gettransactions;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vodafone.global.er.subscriptionmanagement.TransactionFilterImpl;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class GetTransactions6_pt1_IT {


    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void getTransactions16() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";
        String serviceId = "sAlt";

        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertTrue(auth.isSuccess());
        String transId1 = auth.getTransactionId();

        final UsageAuthorization uAuth = EcomApiFactory.getChargingApi(Locale.UK).usageAuthRateCharge("test", msisdn, serviceId, new UsageAttributes());
        String transId2 = uAuth.getTransactionId();

        Transaction[] transactions = EcomApiFactory.getSelfcareApi(Locale.UK).getTransactions("test", msisdn, 0, new TransactionFilterImpl());
        assertNotNull(transactions);
        assertEquals(2, transactions.length);

        Transaction purchaseTrans = null;
        Transaction usageTrans = null;

        //purchaseTransaction first
        for (Transaction trans : transactions) {
            if(trans.getTransactionId().equals(transId1)) {
                purchaseTrans = trans;
            }
            if(trans.getTransactionId().equals(transId2)) {
                usageTrans = trans;
            }
        }

// com.vizzavi.ecommerce.business.selfcare.TransactionType
        softly.assertThat(purchaseTrans.getType().getType() ).as(" purchaseTrans.getType().getType()" ).isEqualTo("PAYMENT_PACKAGE_TRANSACTION");
        softly.assertThat(purchaseTrans.getType().getResourceName() ).as(" purchaseTrans.getType().getResourceName()" ).isEqualTo("PAYMENT_PACKAGE_TRANSACTION");
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(purchaseTrans.getType().isPaymentContent() ).as(" purchaseTrans.getType().isPaymentContent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundCash() ).as(" purchaseTrans.getType().isRefundCash()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundDiscount() ).as(" purchaseTrans.getType().isRefundDiscount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundEnlargement() ).as(" purchaseTrans.getType().isRefundEnlargement()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundNonCash() ).as(" purchaseTrans.getType().isRefundNonCash()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefund() ).as(" purchaseTrans.getType().isRefund()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isGoodwillCredit() ).as(" purchaseTrans.getType().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isPackagePayment() ).as(" purchaseTrans.getType().isPackagePayment()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getType().isNewPackagePayment() ).as(" purchaseTrans.getType().isNewPackagePayment()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getType().isSubscription() ).as(" purchaseTrans.getType().isSubscription()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModification() ).as(" purchaseTrans.getType().isModification()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRecurringPayment() ).as(" purchaseTrans.getType().isRecurringPayment()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRenewalPayment() ).as(" purchaseTrans.getType().isRenewalPayment()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRecurOrRenew() ).as(" purchaseTrans.getType().isRecurOrRenew()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isDunningTransaction() ).as(" purchaseTrans.getType().isDunningTransaction()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isCreditRefundTransaction() ).as(" purchaseTrans.getType().isCreditRefundTransaction()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isAccountModification() ).as(" purchaseTrans.getType().isAccountModification()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifyMsisdn() ).as(" purchaseTrans.getType().isModifyMsisdn()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifyInactivateSubscription() ).as(" purchaseTrans.getType().isModifyInactivateSubscription()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifyChargingMethod() ).as(" purchaseTrans.getType().isModifyChargingMethod()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifySubscription() ).as(" purchaseTrans.getType().isModifySubscription()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifyUserGroups() ).as(" purchaseTrans.getType().isModifyUserGroups()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifyBAN() ).as(" purchaseTrans.getType().isModifyBAN()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isModifyInactivateSubPromoCode() ).as(" purchaseTrans.getType().isModifyInactivateSubPromoCode()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPaymentErrorId() ).as(" purchaseTrans.getPaymentErrorId()" ).isEqualTo("OK");
        softly.assertThat(purchaseTrans.getPaymentErrorDescription() ).as(" purchaseTrans.getPaymentErrorDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getPaymentStatus() ).as(" purchaseTrans.getPaymentStatus()" ).isEqualTo(101) ;
        softly.assertThat(purchaseTrans.getTransactionIdLong() ).as(" purchaseTrans.getTransactionIdLong()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getParentTransactionId() ).as(" purchaseTrans.getParentTransactionId()" ).isNull();
        softly.assertThat(purchaseTrans.getExternalField1() ).as(" purchaseTrans.getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getExternalField2() ).as(" purchaseTrans.getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getExternalTransId() ).as(" purchaseTrans.getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getPartnerId() ).as(" purchaseTrans.getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.isZeroCostIgnore() ).as(" purchaseTrans.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscriptionIdLong() ).as(" purchaseTrans.getSubscriptionIdLong()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getContentName() ).as(" purchaseTrans.getContentName()" ).isNull();
        softly.assertThat(purchaseTrans.getAssetID() ).as(" purchaseTrans.getAssetID()" ).isNull();
        softly.assertThat(purchaseTrans.getPaymentType() ).as(" purchaseTrans.getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getEventUnits() ).as(" purchaseTrans.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getBearer() ).as(" purchaseTrans.getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getExpressFlag() ).as(" purchaseTrans.getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getTierName() ).as(" purchaseTrans.getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getPromoPrecode() ).as(" purchaseTrans.getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getPromoUniqueCode() ).as(" purchaseTrans.getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getNextCycleDiscount() ).as(" purchaseTrans.getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getTaxRate() ).as(" purchaseTrans.getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(purchaseTrans.getAffiliateID() ).as(" purchaseTrans.getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getAggregatorId() ).as(" purchaseTrans.getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getReceipientMsisdn() ).as(" purchaseTrans.getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getProductCode() ).as(" purchaseTrans.getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getMerchantName() ).as(" purchaseTrans.getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getInvoiceText() ).as(" purchaseTrans.getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getContentCategory() ).as(" purchaseTrans.getContentCategory()" ).isNull();
//check size of array!
        softly.assertThat(purchaseTrans.getResourceBalances() ).as(" purchaseTrans.getResourceBalances().length" ).isNotNull() ;
//        softly.assertThat(purchaseTrans.getResourceBalances().length ).as(" purchaseTrans.getResourceBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getName() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isToken() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isUsageToken() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isPayToken() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getResourceSymbol() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isCurrency() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isResource() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getCode() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getResourceName() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getDescription() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getDescription()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getCountryId() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getSubscriptionIdLong() ).as(" purchaseTrans.getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getPackageId() ).as(" purchaseTrans.getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getSubscriptionId() ).as(" purchaseTrans.getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getOldestSubscriptionId() ).as(" purchaseTrans.getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getSubscription() ).as(" purchaseTrans.getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getBalance() ).as(" purchaseTrans.getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getThreshold() ).as(" purchaseTrans.getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getTaxAmount() ).as(" purchaseTrans.getTaxAmount()" ).isEqualTo(new Double(1.75)) ;
        softly.assertThat(purchaseTrans.getPaymentInfo() ).as(" purchaseTrans.getPaymentInfo()" ).isEqualTo("This is payment info from Pay Auth handler");
        softly.assertThat(purchaseTrans.getAuthCode() ).as(" purchaseTrans.getAuthCode()" ).isEqualTo("P00007/9106Z 1474381427873");
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(purchaseTrans.getMatchingAttributes().getChannel() ).as(" purchaseTrans.getMatchingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPartnerId() ).as(" purchaseTrans.getMatchingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getMultiUsageMode() ).as(" purchaseTrans.getMatchingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getMatchingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isPreRatePriceGross() ).as(" purchaseTrans.getMatchingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPreRate() ).as(" purchaseTrans.getMatchingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPaymentInformation() ).as(" purchaseTrans.getMatchingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getContentName() ).as(" purchaseTrans.getMatchingAttributes().getContentName()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getAssetID() ).as(" purchaseTrans.getMatchingAttributes().getAssetID()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPremiumLevel() ).as(" purchaseTrans.getMatchingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getReserveOnlyFlag() ).as(" purchaseTrans.getMatchingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getSupplierId() ).as(" purchaseTrans.getMatchingAttributes().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getMatchingAttributes().getDeviceType() ).as(" purchaseTrans.getMatchingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(purchaseTrans.getMatchingAttributes().getUserGroups().length ).as(" purchaseTrans.getMatchingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getUserGroup() ).as(" purchaseTrans.getMatchingAttributes().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPaymentType() ).as(" purchaseTrans.getMatchingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getEventUnits() ).as(" purchaseTrans.getMatchingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPromoCodes().length ).as(" purchaseTrans.getMatchingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(purchaseTrans.getMatchingAttributes().getBearerIds().length ).as(" purchaseTrans.getMatchingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPromoCode() ).as(" purchaseTrans.getMatchingAttributes().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getMatchingAttributes().getDuration() ).as(" purchaseTrans.getMatchingAttributes().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getChargingMethod() ).as(" purchaseTrans.getMatchingAttributes().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getBearer() ).as(" purchaseTrans.getMatchingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getMatchingAttributes().isInteractive() ).as(" purchaseTrans.getMatchingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isIncludeUnavailable() ).as(" purchaseTrans.getMatchingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExpressFlag() ).as(" purchaseTrans.getMatchingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isExpressFlag() ).as(" purchaseTrans.getMatchingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isPreOrder() ).as(" purchaseTrans.getMatchingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isCancellationUsage() ).as(" purchaseTrans.getMatchingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getTierName() ).as(" purchaseTrans.getMatchingAttributes().getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPromoPrecode() ).as(" purchaseTrans.getMatchingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getUniquePromoCode() ).as(" purchaseTrans.getMatchingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPromoUniqueCode() ).as(" purchaseTrans.getMatchingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getNextCycleDiscount() ).as(" purchaseTrans.getMatchingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getHasHistoricPricePointFlag() ).as(" purchaseTrans.getMatchingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isIsForRenewal() ).as(" purchaseTrans.getMatchingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getTaxRate() ).as(" purchaseTrans.getMatchingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getTaxRateAsDouble() ).as(" purchaseTrans.getMatchingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getAffiliateID() ).as(" purchaseTrans.getMatchingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getTariff() ).as(" purchaseTrans.getMatchingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getMatchingAttributes().getAggregatorId() ).as(" purchaseTrans.getMatchingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().isForcePurchaseFlow() ).as(" purchaseTrans.getMatchingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getReceipientMsisdn() ).as(" purchaseTrans.getMatchingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getProductCode() ).as(" purchaseTrans.getMatchingAttributes().getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getMerchantName() ).as(" purchaseTrans.getMatchingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getInvoiceText() ).as(" purchaseTrans.getMatchingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().isReIssueEnabled() ).as(" purchaseTrans.getMatchingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isReIssueFlagPresent() ).as(" purchaseTrans.getMatchingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getShortPackageId() ).as(" purchaseTrans.getMatchingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getTaxCode() ).as(" purchaseTrans.getMatchingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getMatchingAttributes().getHistoryStartDate() ).as(" purchaseTrans.getMatchingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getVendorId() ).as(" purchaseTrans.getMatchingAttributes().getVendorId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().isIsForNextPaymentAmount() ).as(" purchaseTrans.getMatchingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getRenewalPreRate() ).as(" purchaseTrans.getMatchingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isOverrideDisallowPreRateFlag() ).as(" purchaseTrans.getMatchingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getContentCategory() ).as(" purchaseTrans.getMatchingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPartnerUrl() ).as(" purchaseTrans.getMatchingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPartnerContactInfo() ).as(" purchaseTrans.getMatchingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPartnerEmail() ).as(" purchaseTrans.getMatchingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPartnerName() ).as(" purchaseTrans.getMatchingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getMatchingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getSubRenewalPricepointId() ).as(" purchaseTrans.getMatchingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLinkPricepointId() ).as(" purchaseTrans.getMatchingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getSubPurchaseTransactionTrial() ).as(" purchaseTrans.getMatchingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getDiscardHiddenInactivePricepoints() ).as(" purchaseTrans.getMatchingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" purchaseTrans.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExtIdentifier1() ).as(" purchaseTrans.getMatchingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExtIdentifier2() ).as(" purchaseTrans.getMatchingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExtIdentifier3() ).as(" purchaseTrans.getMatchingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExternalField1() ).as(" purchaseTrans.getMatchingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExternalField2() ).as(" purchaseTrans.getMatchingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExternalTransId() ).as(" purchaseTrans.getMatchingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLanguageLocale() ).as(" purchaseTrans.getMatchingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getDeviceID() ).as(" purchaseTrans.getMatchingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLocal() ).as(" purchaseTrans.getMatchingAttributes().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getMsisdn() ).as(" purchaseTrans.getMatchingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getAccessChannel() ).as(" purchaseTrans.getMatchingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPurchaseChannel() ).as(" purchaseTrans.getMatchingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLanguageCode() ).as(" purchaseTrans.getMatchingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getActiveSubscriptions() ).as(" purchaseTrans.getMatchingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getCsrId() ).as(" purchaseTrans.getMatchingAttributes().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getPackageId() ).as(" purchaseTrans.getPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getRateIdentifier() ).as(" purchaseTrans.getRateIdentifier()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getUsageTime() ).as(" purchaseTrans.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getAccessDevice() ).as(" purchaseTrans.getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscriptionId() ).as(" purchaseTrans.getSubscriptionId()" ).isNotEmpty();
// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//check size of array!
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices().length ).as(" purchaseTrans.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(5004)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getStatus() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
////check size of array!
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices().length ).as(" purchaseTrans.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(5004)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getStatus() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getName() ).as(" purchaseTrans.getSubscription().getPackage().getName()" ).isEqualTo("2 Usage Alternative Payment Pkg");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getName() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isToken() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isResource() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getCode() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPriority() ).as(" purchaseTrans.getSubscription().getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getId() ).as(" purchaseTrans.getSubscription().getPackage().getId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isActive() ).as(" purchaseTrans.getSubscription().getPackage().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getRate() ).as(" purchaseTrans.getSubscription().getPackage().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getUrl() ).as(" purchaseTrans.getSubscription().getPackage().getUrl()" ).isNull();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isReserveOnly() ).as(" purchaseTrans.getSubscription().getPackage().isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isOriginal() ).as(" purchaseTrans.getSubscription().getPackage().isOriginal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingModel() ).as(" purchaseTrans.getSubscription().getPackage().getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDefault() ).as(" purchaseTrans.getSubscription().getPackage().isDefault()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getParentPackageId() ).as(" purchaseTrans.getSubscription().getPackage().getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isGoodwillCredit() ).as(" purchaseTrans.getSubscription().getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPriceModels() ).as(" purchaseTrans.getSubscription().getPackage().getPriceModels()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getFullPackagePricepointId() ).as(" purchaseTrans.getSubscription().getPackage().getFullPackagePricepointId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// java.lang.Character
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getSimplePackageId() ).as(" purchaseTrans.getSubscription().getPackage().getSimplePackageId()" ).isEqualTo("pAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNotificationCategory() ).as(" purchaseTrans.getSubscription().getPackage().getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getDescription()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getName() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getName()" ).isEqualTo("Alternative Payment Service");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getKey() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getId() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getId()" ).isEqualTo("sAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDisplayName() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDisplayName()" ).isEqualTo("sAlt (Alternative Payment Service)");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getTaxCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getUrl() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReserveOnly() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceType() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceType()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isRefundable() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSalesModel() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isDefaultService() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isDefaultService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getUsageId() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDealName() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDealName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValue() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValue() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentItem() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isVolumeService() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isVolumeService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductFk() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProductFk()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHasExpress() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHasExpress()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceClass() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceClass()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getChargeableBy() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isMicroService() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismRefundable() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUseRateCard() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getInternalPartner() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricePoint() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isEventPackage() ).as(" purchaseTrans.getSubscription().getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRecurringPackage() ).as(" purchaseTrans.getSubscription().getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPackageType() ).as(" purchaseTrans.getSubscription().getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNonRefundableDescription() ).as(" purchaseTrans.getSubscription().getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRefundable() ).as(" purchaseTrans.getSubscription().getPackage().isRefundable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isCalendarPackage() ).as(" purchaseTrans.getSubscription().getPackage().isCalendarPackage()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getProtectedType() ).as(" purchaseTrans.getSubscription().getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDynamicProtectedValue() ).as(" purchaseTrans.getSubscription().getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPurchaseMethod() ).as(" purchaseTrans.getSubscription().getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getKpiPackageProductCategory() ).as(" purchaseTrans.getSubscription().getPackage().getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getKpiPackageType() ).as(" purchaseTrans.getSubscription().getPackage().getKpiPackageType()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingModels().length ).as(" purchaseTrans.getSubscription().getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isExpressPurchase() ).as(" purchaseTrans.getSubscription().getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRecieptingFlag() ).as(" purchaseTrans.getSubscription().getPackage().isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isPricePointOrder() ).as(" purchaseTrans.getSubscription().getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isSuperPackage() ).as(" purchaseTrans.getSubscription().getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRevenueShareByUsage() ).as(" purchaseTrans.getSubscription().getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDynamicDefault() ).as(" purchaseTrans.getSubscription().getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getACEPackage() ).as(" purchaseTrans.getSubscription().getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUpSell() ).as(" purchaseTrans.getSubscription().getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getLogoId() ).as(" purchaseTrans.getSubscription().getPackage().getLogoId()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPartnerInfo() ).as(" purchaseTrans.getSubscription().getPackage().getPartnerInfo()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getIsPackageModel() ).as(" purchaseTrans.getSubscription().getPackage().getIsPackageModel()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isParentPackage() ).as(" purchaseTrans.getSubscription().getPackage().isParentPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getChildPackages() ).as(" purchaseTrans.getSubscription().getPackage().getChildPackages()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServicesNotInPackageFairUsagePolicyList() ).as(" purchaseTrans.getSubscription().getPackage().getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasParentSub() ).as(" purchaseTrans.getSubscription().getPackage().isHasParentSub()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getParentSubId() ).as(" purchaseTrans.getSubscription().getPackage().getParentSubId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasParentSubSuspendedResProv() ).as(" purchaseTrans.getSubscription().getPackage().isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getParentSubStatus() ).as(" purchaseTrans.getSubscription().getPackage().getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDisallowCancellations() ).as(" purchaseTrans.getSubscription().getPackage().isDisallowCancellations()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getSalesModel() ).as(" purchaseTrans.getSubscription().getPackage().getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPackageClass() ).as(" purchaseTrans.getSubscription().getPackage().getPackageClass()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDataVoiceTariffInclusive() ).as(" purchaseTrans.getSubscription().getPackage().isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNominalValue() ).as(" purchaseTrans.getSubscription().getPackage().getNominalValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUseBeingDeprovisionedStatus() ).as(" purchaseTrans.getSubscription().getPackage().isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDisallowDuplicateSubPurchase() ).as(" purchaseTrans.getSubscription().getPackage().getDisallowDuplicateSubPurchase()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNoActivePricepoints() ).as(" purchaseTrans.getSubscription().getPackage().getNoActivePricepoints()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasBalanceImpactsWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasPricePointsWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasPromosWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasTaxRateWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasTaxRateWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPromoCodeMap() ).as(" purchaseTrans.getSubscription().getPackage().getPromoCodeMap()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPromoCodeMapSize() ).as(" purchaseTrans.getSubscription().getPackage().getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getActiveStatusAsString() ).as(" purchaseTrans.getSubscription().getPackage().getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUseRateCardService() ).as(" purchaseTrans.getSubscription().getPackage().isUseRateCardService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getRateCardServiceId() ).as(" purchaseTrans.getSubscription().getPackage().getRateCardServiceId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUserGroupCalendarPricePointPackage() ).as(" purchaseTrans.getSubscription().getPackage().isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUpsellDiscountProrated() ).as(" purchaseTrans.getSubscription().getPackage().isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDisallowPrerate() ).as(" purchaseTrans.getSubscription().getPackage().isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceNames().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceNames().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDefaultPartnerProvisioningId() ).as(" purchaseTrans.getSubscription().getPackage().getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getUserGroupComparisonAtRenewal() ).as(" purchaseTrans.getSubscription().getPackage().getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isResource() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isZeroCostIgnore() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isActive() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isPreOrder() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceBalances() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getNetRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isDiscount() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDiscountPromoText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getContentId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getUsageTime() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDuration() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getCustomResourceBalances() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingModelTier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isArchived() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isBasePricePoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDevice() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAlternativeRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isTrial() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getGlid() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricepointIdLink() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isPreview() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getInteractiveFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isForcedPurchase() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedExpiryDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isReserveOnly() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMinSubPeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPenaltyCharges() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getCancellation() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMonthEndSubscription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isHistoric() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedRecurrence() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isReceipting() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getReceiptingAttribute() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getOrder() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPaymentHandler() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getNonMatchAllUserGroups().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isPromo() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isSubmitToPaymentHandler() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isSuppressToPaymentHandler() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRecurrenceDay() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isAlignWithExternal() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getGracePeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRetryFrequency() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getSuspensionPeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsageLimit() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExtensionPeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isTariff() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isHideForPurchaseOptions() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getBalances() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isRecurring() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPricingModel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getTier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageIdentifier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getServiceIdentifier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isResource() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isVolumeType() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isOriginal() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getProtectedFk() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isNonRecurring() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isEvent() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getStartDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExpiryDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getChannel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMultiUsageMode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isPreRatePriceGross() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPreRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPaymentInformation() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getContentName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAssetID() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPremiumLevel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getReserveOnlyFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getSupplierId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDeviceType() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getUserGroups().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getUserGroup() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPaymentType() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getEventDateTime() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getEventUnits() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoCodes().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getBearerIds().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDuration() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getChargingMethod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getBearer() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isInteractive() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isIncludeUnavailable() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExpressFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isExpressFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isCancellationUsage() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTierName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoPrecode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getUniquePromoCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoUniqueCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getNextCycleDiscount() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getHasHistoricPricePointFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isIsForRenewal() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxRateAsDouble() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAffiliateID() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTariff() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAggregatorId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isForcePurchaseFlow() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getReceipientMsisdn() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getProductCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMerchantName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getInvoiceText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isReIssueEnabled() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isReIssueFlagPresent() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getShortPackageId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getHistoryStartDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getVendorId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isIsForNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getContentCategory() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerUrl() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerContactInfo() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerEmail() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getSubRenewalPricepointId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLinkPricepointId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getSubPurchaseTransactionTrial() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalTransId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageLocale() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDeviceID() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLocal() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMsisdn() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessChannel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPurchaseChannel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getActiveSubscriptions() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getCsrId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getCountry() ).as(" purchaseTrans.getSubscription().getCountry()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPartnerId() ).as(" purchaseTrans.getSubscription().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getSubscriptionIdLong() ).as(" purchaseTrans.getSubscription().getSubscriptionIdLong()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getSubscription().isActive() ).as(" purchaseTrans.getSubscription().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPaymentType() ).as(" purchaseTrans.getSubscription().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getSubscription().getMerchantName() ).as(" purchaseTrans.getSubscription().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getExtIdentifier3()" ).isNull();
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances().length ).as(" purchaseTrans.getSubscription().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getName() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getName()" ).isEqualTo("SINGLE_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isToken() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isResource() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCode() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getDescription() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("MULTIPLE_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionIdLong() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionIdLong()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getPackageId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionId()" ).isNotEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getOldestSubscriptionId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getSubscription() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getBalance() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getThreshold() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getMicroServiceSubList() ).as(" purchaseTrans.getSubscription().getMicroServiceSubList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackageId() ).as(" purchaseTrans.getSubscription().getPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getOptions() ).as(" purchaseTrans.getSubscription().getOptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isArchived() ).as(" purchaseTrans.getSubscription().isArchived()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getExtensionPeriod() ).as(" purchaseTrans.getSubscription().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().isRecurring() ).as(" purchaseTrans.getSubscription().isRecurring()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getSubscriptionId() ).as(" purchaseTrans.getSubscription().getSubscriptionId()" ).isNotEmpty();
        softly.assertThat(purchaseTrans.getSubscription().isDefault() ).as(" purchaseTrans.getSubscription().isDefault()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getMsisdn() ).as(" purchaseTrans.getSubscription().getMsisdn()" ).isEqualTo("-1289763512");
        softly.assertThat(purchaseTrans.getSubscription().getCsrId() ).as(" purchaseTrans.getSubscription().getCsrId()" ).isEqualTo("test");
        softly.assertThat(purchaseTrans.getSubscription().isPromotional() ).as(" purchaseTrans.getSubscription().isPromotional()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPromotionalExpiryDate() ).as(" purchaseTrans.getSubscription().getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getStatus() ).as(" purchaseTrans.getSubscription().getStatus()" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getExternalSubId() ).as(" purchaseTrans.getSubscription().getExternalSubId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isRefundable() ).as(" purchaseTrans.getSubscription().isRefundable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isSuperPackage() ).as(" purchaseTrans.getSubscription().isSuperPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackageClass() ).as(" purchaseTrans.getSubscription().getPackageClass()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getAccount() ).as(" purchaseTrans.getSubscription().getAccount()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isInactiveOrClosed() ).as(" purchaseTrans.getSubscription().isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isFailed() ).as(" purchaseTrans.getSubscription().isFailed()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isBeingProvisioned() ).as(" purchaseTrans.getSubscription().isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isReserved() ).as(" purchaseTrans.getSubscription().isReserved()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getLinkedPtID() ).as(" purchaseTrans.getSubscription().getLinkedPtID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isPreOrdered() ).as(" purchaseTrans.getSubscription().isPreOrdered()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getContentPaymentType() ).as(" purchaseTrans.getSubscription().getContentPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getSubscription().getPurchaseDeviceType() ).as(" purchaseTrans.getSubscription().getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getNextCyclePercentDiscount() ).as(" purchaseTrans.getSubscription().getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getNextPaymentAmount()" ).isEqualTo(new Double(10.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getServiceIds().length ).as(" purchaseTrans.getSubscription().getServiceIds().length" ).isEqualTo(1) ;
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getChannel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getMultiUsageMode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isPreRatePriceGross() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPreRate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPaymentInformation() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getContentName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getContentName()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAssetID() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAssetID()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPremiumLevel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getReserveOnlyFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSupplierId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDeviceType() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getUserGroups().length ).as(" purchaseTrans.getSubscription().getRatingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getUserGroup() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPaymentType() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getEventDateTime() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getEventDateTime()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getEventUnits() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoCodes().length ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getBearerIds().length ).as(" purchaseTrans.getSubscription().getRatingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDuration() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getChargingMethod() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getBearer() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isInteractive() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isIncludeUnavailable() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExpressFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isExpressFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isPreOrder() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isCancellationUsage() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTierName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoPrecode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getUniquePromoCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoUniqueCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getNextCycleDiscount() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isIsForRenewal() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTaxRate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTaxRateAsDouble() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAffiliateID() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTariff() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAggregatorId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isForcePurchaseFlow() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getReceipientMsisdn() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getProductCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getMerchantName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getInvoiceText() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isReIssueEnabled() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isReIssueFlagPresent() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getShortPackageId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTaxCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getHistoryStartDate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getVendorId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getVendorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isIsForNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getContentCategory() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerUrl() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerContactInfo() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerEmail() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalPricepointId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLinkPricepointId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExternalField1() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExternalField2() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExternalTransId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLanguageLocale() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDeviceID() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLocal() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getMsisdn() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAccessChannel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPurchaseChannel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLanguageCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getActiveSubscriptions() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getCsrId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPaymentTransactionId() ).as(" purchaseTrans.getSubscription().getPaymentTransactionId()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getSubscription().getNonRefundDescription() ).as(" purchaseTrans.getSubscription().getNonRefundDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getInteractiveUsageFlag() ).as(" purchaseTrans.getSubscription().getInteractiveUsageFlag()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().isFirstUsage() ).as(" purchaseTrans.getSubscription().isFirstUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isSubscriptionUsed() ).as(" purchaseTrans.getSubscription().isSubscriptionUsed()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getCurrentNoOfOccurences() ).as(" purchaseTrans.getSubscription().getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPenaltyCharge() ).as(" purchaseTrans.getSubscription().getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().isMinSubscriptionPeriodElapsed() ).as(" purchaseTrans.getSubscription().isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().isUnderGracePeriod() ).as(" purchaseTrans.getSubscription().isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getBatchRetryDate() ).as(" purchaseTrans.getSubscription().getBatchRetryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getOverdueExpiryDate() ).as(" purchaseTrans.getSubscription().getOverdueExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getLastExpiryDate() ).as(" purchaseTrans.getSubscription().getLastExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isWasRecurringTrial() ).as(" purchaseTrans.getSubscription().isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getParentPackageID() ).as(" purchaseTrans.getSubscription().getParentPackageID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPreviousStatus() ).as(" purchaseTrans.getSubscription().getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().isParentAlsoPurchased() ).as(" purchaseTrans.getSubscription().isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isProvisionOnUsageSuccess() ).as(" purchaseTrans.getSubscription().isProvisionOnUsageSuccess()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getLastUsageTransactionIdForSameContent() ).as(" purchaseTrans.getSubscription().getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getSpId() ).as(" purchaseTrans.getSubscription().getSpId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPartnerTaxRate() ).as(" purchaseTrans.getSubscription().getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getCountryId() ).as(" purchaseTrans.getSubscription().getCountryId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isWasRecurringPromoCode() ).as(" purchaseTrans.getSubscription().isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getLastPaymentTransaction() ).as(" purchaseTrans.getSubscription().getLastPaymentTransaction()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getB2BPartner() ).as(" purchaseTrans.getSubscription().getB2BPartner()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().isRenewalPreRateGross() ).as(" purchaseTrans.getSubscription().isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getNextPricePointId() ).as(" purchaseTrans.getSubscription().getNextPricePointId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getLastPaymentTransactionAmount() ).as(" purchaseTrans.getSubscription().getLastPaymentTransactionAmount()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getLastToLastPaymentTransactionAmount() ).as(" purchaseTrans.getSubscription().getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().isPricePointChangeOnRenewal() ).as(" purchaseTrans.getSubscription().isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getOldSubscriptionId() ).as(" purchaseTrans.getSubscription().getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getOldMsisdn() ).as(" purchaseTrans.getSubscription().getOldMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isProvisionable() ).as(" purchaseTrans.getSubscription().isProvisionable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getFuturePricePointRenewals() ).as(" purchaseTrans.getSubscription().getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getNextCyclePercentValue() ).as(" purchaseTrans.getSubscription().getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getLockId() ).as(" purchaseTrans.getSubscription().getLockId()" ).isEqualTo(new Long(1)) ;
        softly.assertThat(purchaseTrans.getSubscription().isSuspended() ).as(" purchaseTrans.getSubscription().isSuspended()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }

    }

}
