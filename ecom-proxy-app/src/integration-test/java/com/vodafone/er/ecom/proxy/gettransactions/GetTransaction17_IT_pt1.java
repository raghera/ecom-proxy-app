package com.vodafone.er.ecom.proxy.gettransactions;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vizzavi.ecommerce.business.selfcare.TransactionFilter;
import com.vodafone.global.er.subscriptionmanagement.TransactionFilterImpl;
import org.assertj.core.api.SoftAssertions;
import org.junit.Ignore;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Ravi Aghera
 */
public class GetTransaction17_IT_pt1 {

    private SoftAssertions softly = new SoftAssertions();

    @Ignore(value = "Ignored because this cannot be translated to Decoupling")
//    @Test
    public void getTransaction17() throws EcommerceException {

        final String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";
        String serviceId = "sAlt";

        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertTrue(auth.isSuccess());
        final UsageAuthorization uAuth = EcomApiFactory.getChargingApi(Locale.UK).usageAuthRateCharge("test", msisdn, serviceId, new UsageAttributes());
        assertTrue(uAuth.isSuccess());

        TransactionFilter filter = new TransactionFilterImpl();
        filter.setTransactionIdLong(auth.getTransactionIdLong());
        Transaction transaction = EcomApiFactory.getSelfcareApi(Locale.UK)
                .getTransaction("test", filter);
        assertNotNull(transaction);

        System.out.println("PurchaseTrans: " + transaction.getType());

        assertEquals(auth.getTransactionIdLong(), transaction.getTransactionIdLong());


// com.vizzavi.ecommerce.business.selfcare.TransactionType
        softly.assertThat(transaction.getType().getType() ).as(" transaction.getType().getType()" ).isEqualTo("PAYMENT_PACKAGE_TRANSACTION");
        softly.assertThat(transaction.getType().isGoodwillCredit() ).as(" transaction.getType().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(transaction.getType().getResourceName() ).as(" transaction.getType().getResourceName()" ).isEqualTo("PAYMENT_PACKAGE_TRANSACTION");
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(transaction.getType().isPaymentContent() ).as(" transaction.getType().isPaymentContent()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRefundCash() ).as(" transaction.getType().isRefundCash()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRefundDiscount() ).as(" transaction.getType().isRefundDiscount()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRefundEnlargement() ).as(" transaction.getType().isRefundEnlargement()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRefundNonCash() ).as(" transaction.getType().isRefundNonCash()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRefund() ).as(" transaction.getType().isRefund()" ).isFalse() ;
        softly.assertThat(transaction.getType().isPackagePayment() ).as(" transaction.getType().isPackagePayment()" ).isTrue() ;
        softly.assertThat(transaction.getType().isNewPackagePayment() ).as(" transaction.getType().isNewPackagePayment()" ).isTrue() ;
        softly.assertThat(transaction.getType().isSubscription() ).as(" transaction.getType().isSubscription()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModification() ).as(" transaction.getType().isModification()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRecurringPayment() ).as(" transaction.getType().isRecurringPayment()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRenewalPayment() ).as(" transaction.getType().isRenewalPayment()" ).isFalse() ;
        softly.assertThat(transaction.getType().isRecurOrRenew() ).as(" transaction.getType().isRecurOrRenew()" ).isFalse() ;
        softly.assertThat(transaction.getType().isDunningTransaction() ).as(" transaction.getType().isDunningTransaction()" ).isFalse() ;
        softly.assertThat(transaction.getType().isCreditRefundTransaction() ).as(" transaction.getType().isCreditRefundTransaction()" ).isFalse() ;
        softly.assertThat(transaction.getType().isAccountModification() ).as(" transaction.getType().isAccountModification()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifyMsisdn() ).as(" transaction.getType().isModifyMsisdn()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifyInactivateSubscription() ).as(" transaction.getType().isModifyInactivateSubscription()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifyChargingMethod() ).as(" transaction.getType().isModifyChargingMethod()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifySubscription() ).as(" transaction.getType().isModifySubscription()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifyUserGroups() ).as(" transaction.getType().isModifyUserGroups()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifyBAN() ).as(" transaction.getType().isModifyBAN()" ).isFalse() ;
        softly.assertThat(transaction.getType().isModifyInactivateSubPromoCode() ).as(" transaction.getType().isModifyInactivateSubPromoCode()" ).isFalse() ;
        softly.assertThat(transaction.getParentTransactionId() ).as(" transaction.getParentTransactionId()" ).isNull();
        softly.assertThat(transaction.getExternalField1() ).as(" transaction.getExternalField1()" ).isNull();
        softly.assertThat(transaction.getExternalField2() ).as(" transaction.getExternalField2()" ).isNull();
        softly.assertThat(transaction.getExternalTransId() ).as(" transaction.getExternalTransId()" ).isNull();
        softly.assertThat(transaction.getPartnerId() ).as(" transaction.getPartnerId()" ).isNull();
        softly.assertThat(transaction.isZeroCostIgnore() ).as(" transaction.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(transaction.getSubscriptionIdLong() ).as(" transaction.getSubscriptionIdLong()" ).isEqualTo(new Long(8542)) ;
        softly.assertThat(transaction.getContentName() ).as(" transaction.getContentName()" ).isNull();
        softly.assertThat(transaction.getAssetID() ).as(" transaction.getAssetID()" ).isNull();
        softly.assertThat(transaction.getPaymentType() ).as(" transaction.getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(transaction.getEventUnits() ).as(" transaction.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getBearer() ).as(" transaction.getBearer()" ).isEqualTo("*");
        softly.assertThat(transaction.getExpressFlag() ).as(" transaction.getExpressFlag()" ).isFalse() ;
        softly.assertThat(transaction.getTierName() ).as(" transaction.getTierName()" ).isNull();
        softly.assertThat(transaction.getPromoPrecode() ).as(" transaction.getPromoPrecode()" ).isNull();
        softly.assertThat(transaction.getPromoUniqueCode() ).as(" transaction.getPromoUniqueCode()" ).isNull();
        softly.assertThat(transaction.getNextCycleDiscount() ).as(" transaction.getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getTaxRate() ).as(" transaction.getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(transaction.getAffiliateID() ).as(" transaction.getAffiliateID()" ).isNull();
        softly.assertThat(transaction.getAggregatorId() ).as(" transaction.getAggregatorId()" ).isNull();
        softly.assertThat(transaction.getReceipientMsisdn() ).as(" transaction.getReceipientMsisdn()" ).isNull();
        softly.assertThat(transaction.getProductCode() ).as(" transaction.getProductCode()" ).isNull();
        softly.assertThat(transaction.getMerchantName() ).as(" transaction.getMerchantName()" ).isNull();
        softly.assertThat(transaction.getInvoiceText() ).as(" transaction.getInvoiceText()" ).isNull();
        softly.assertThat(transaction.getContentCategory() ).as(" transaction.getContentCategory()" ).isNull();
        softly.assertThat(transaction.getAccessChannel() ).as(" transaction.getAccessChannel()" ).isNull();
        softly.assertThat(transaction.getPurchaseChannel() ).as(" transaction.getPurchaseChannel()" ).isNull();
        softly.assertThat(transaction.getDeviceID() ).as(" transaction.getDeviceID()" ).isNull();
        softly.assertThat(transaction.getMsisdn() ).as(" transaction.getMsisdn()" ).isNull();
        softly.assertThat(transaction.getCsrId() ).as(" transaction.getCsrId()" ).isEqualTo("test");
//check size of array!
        softly.assertThat(transaction.getResourceBalances().length ).as(" transaction.getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(transaction.getResourceBalances()[0].getResource().getName() ).as(" transaction.getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(transaction.getResourceBalances()[0].getResource().isCurrency() ).as(" transaction.getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(transaction.getResourceBalances()[0].getResource().isResource() ).as(" transaction.getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(transaction.getResourceBalances()[0].getResource().isToken() ).as(" transaction.getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(transaction.getResourceBalances()[0].getResource().isUsageToken() ).as(" transaction.getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(transaction.getResourceBalances()[0].getResource().isPayToken() ).as(" transaction.getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(transaction.getResourceBalances()[0].getResource().getResourceSymbol() ).as(" transaction.getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(transaction.getResourceBalances()[0].getResource().getCode() ).as(" transaction.getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(transaction.getResourceBalances()[0].getResource().getDescription() ).as(" transaction.getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(transaction.getResourceBalances()[0].getResource().getResourceName() ).as(" transaction.getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(transaction.getResourceBalances()[0].getResource().getCountryId() ).as(" transaction.getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getResourceBalances()[0].getSubscriptionIdLong() ).as(" transaction.getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(transaction.getResourceBalances()[0].getBalance() ).as(" transaction.getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(transaction.getResourceBalances()[0].getPackageId() ).as(" transaction.getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(transaction.getResourceBalances()[0].getSubscriptionId() ).as(" transaction.getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(transaction.getResourceBalances()[0].getOldestSubscriptionId() ).as(" transaction.getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(transaction.getResourceBalances()[0].getSubscription() ).as(" transaction.getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(transaction.getResourceBalances()[0].getThreshold() ).as(" transaction.getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getAuthCode() ).as(" transaction.getAuthCode()" ).isEqualTo("P00007/9216Z 1474458481603");
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(transaction.getMatchingAttributes().getChannel() ).as(" transaction.getMatchingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getMatchingAttributes().getPartnerId() ).as(" transaction.getMatchingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getMultiUsageMode() ).as(" transaction.getMatchingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getMatchingAttributes().getNetworkCodeMatchMethod() ).as(" transaction.getMatchingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getMatchingAttributes().isPreRatePriceGross() ).as(" transaction.getMatchingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getPreRate() ).as(" transaction.getMatchingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(transaction.getMatchingAttributes().getPaymentInformation() ).as(" transaction.getMatchingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getContentName() ).as(" transaction.getMatchingAttributes().getContentName()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getAssetID() ).as(" transaction.getMatchingAttributes().getAssetID()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPremiumLevel() ).as(" transaction.getMatchingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getMatchingAttributes().getReserveOnlyFlag() ).as(" transaction.getMatchingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getMatchingAttributes().getSupplierId() ).as(" transaction.getMatchingAttributes().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(transaction.getMatchingAttributes().getDeviceType() ).as(" transaction.getMatchingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(transaction.getMatchingAttributes().getUserGroups().length ).as(" transaction.getMatchingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getMatchingAttributes().getUserGroup() ).as(" transaction.getMatchingAttributes().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(transaction.getMatchingAttributes().getPaymentType() ).as(" transaction.getMatchingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(transaction.getMatchingAttributes().getEventUnits() ).as(" transaction.getMatchingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(transaction.getMatchingAttributes().getPromoCodes().length ).as(" transaction.getMatchingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(transaction.getMatchingAttributes().getBearerIds().length ).as(" transaction.getMatchingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getMatchingAttributes().getPromoCode() ).as(" transaction.getMatchingAttributes().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(transaction.getMatchingAttributes().getDuration() ).as(" transaction.getMatchingAttributes().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(transaction.getMatchingAttributes().getChargingMethod() ).as(" transaction.getMatchingAttributes().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(transaction.getMatchingAttributes().getBearer() ).as(" transaction.getMatchingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(transaction.getMatchingAttributes().isInteractive() ).as(" transaction.getMatchingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(transaction.getMatchingAttributes().isIncludeUnavailable() ).as(" transaction.getMatchingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getExpressFlag() ).as(" transaction.getMatchingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().isExpressFlag() ).as(" transaction.getMatchingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().isPreOrder() ).as(" transaction.getMatchingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().isCancellationUsage() ).as(" transaction.getMatchingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getTierName() ).as(" transaction.getMatchingAttributes().getTierName()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPromoPrecode() ).as(" transaction.getMatchingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getUniquePromoCode() ).as(" transaction.getMatchingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPromoUniqueCode() ).as(" transaction.getMatchingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getNextCycleDiscount() ).as(" transaction.getMatchingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getMatchingAttributes().getHasHistoricPricePointFlag() ).as(" transaction.getMatchingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().isIsForRenewal() ).as(" transaction.getMatchingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getTaxRate() ).as(" transaction.getMatchingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(transaction.getMatchingAttributes().getTaxRateAsDouble() ).as(" transaction.getMatchingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getAffiliateID() ).as(" transaction.getMatchingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getTariff() ).as(" transaction.getMatchingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(transaction.getMatchingAttributes().getAggregatorId() ).as(" transaction.getMatchingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().isForcePurchaseFlow() ).as(" transaction.getMatchingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getReceipientMsisdn() ).as(" transaction.getMatchingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getProductCode() ).as(" transaction.getMatchingAttributes().getProductCode()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getMerchantName() ).as(" transaction.getMatchingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getInvoiceText() ).as(" transaction.getMatchingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().isReIssueEnabled() ).as(" transaction.getMatchingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().isReIssueFlagPresent() ).as(" transaction.getMatchingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getShortPackageId() ).as(" transaction.getMatchingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getTaxCode() ).as(" transaction.getMatchingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(transaction.getMatchingAttributes().getHistoryStartDate() ).as(" transaction.getMatchingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getVendorId() ).as(" transaction.getMatchingAttributes().getVendorId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().isIsForNextPaymentAmount() ).as(" transaction.getMatchingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getRenewalPreRate() ).as(" transaction.getMatchingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(transaction.getMatchingAttributes().isOverrideDisallowPreRateFlag() ).as(" transaction.getMatchingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getContentCategory() ).as(" transaction.getMatchingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPartnerUrl() ).as(" transaction.getMatchingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPartnerContactInfo() ).as(" transaction.getMatchingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPartnerEmail() ).as(" transaction.getMatchingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPartnerName() ).as(" transaction.getMatchingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" transaction.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(transaction.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" transaction.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(transaction.getMatchingAttributes().getLinkedByTrialPricepoint() ).as(" transaction.getMatchingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getSubRenewalPricepointId() ).as(" transaction.getMatchingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getLinkPricepointId() ).as(" transaction.getMatchingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getSubPurchaseTransactionTrial() ).as(" transaction.getMatchingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getDiscardHiddenInactivePricepoints() ).as(" transaction.getMatchingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" transaction.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(transaction.getMatchingAttributes().getExtIdentifier1() ).as(" transaction.getMatchingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getExtIdentifier2() ).as(" transaction.getMatchingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getExtIdentifier3() ).as(" transaction.getMatchingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getLanguageLocale() ).as(" transaction.getMatchingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getExternalField1() ).as(" transaction.getMatchingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getExternalField2() ).as(" transaction.getMatchingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getExternalTransId() ).as(" transaction.getMatchingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getAccessChannel() ).as(" transaction.getMatchingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getPurchaseChannel() ).as(" transaction.getMatchingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getDeviceID() ).as(" transaction.getMatchingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getLocal() ).as(" transaction.getMatchingAttributes().getLocal()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getMsisdn() ).as(" transaction.getMatchingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getLanguageCode() ).as(" transaction.getMatchingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getActiveSubscriptions() ).as(" transaction.getMatchingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(transaction.getMatchingAttributes().getCsrId() ).as(" transaction.getMatchingAttributes().getCsrId()" ).isNull();
        softly.assertThat(transaction.getPackageId() ).as(" transaction.getPackageId()" ).isNull();
        softly.assertThat(transaction.getRateIdentifier() ).as(" transaction.getRateIdentifier()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(transaction.getUsageTime() ).as(" transaction.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getAccessDevice() ).as(" transaction.getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getSubscriptionId() ).as(" transaction.getSubscriptionId()" ).isEqualTo("8542");
// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//check size of array!
        softly.assertThat(transaction.getSubscription().getPurchasedServices().length ).as(" transaction.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getId() ).as(" transaction.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(5075)) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" transaction.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" transaction.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" transaction.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" transaction.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" transaction.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" transaction.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" transaction.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" transaction.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getStatus() ).as(" transaction.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" transaction.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" transaction.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//check size of array!
        softly.assertThat(transaction.getSubscription().getPurchasedServices().length ).as(" transaction.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getId() ).as(" transaction.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(5075)) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" transaction.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" transaction.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" transaction.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" transaction.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" transaction.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" transaction.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" transaction.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" transaction.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getStatus() ).as(" transaction.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" transaction.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
        softly.assertThat(transaction.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" transaction.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(transaction.getSubscription().getPackage().getName() ).as(" transaction.getSubscription().getPackage().getName()" ).isEqualTo("2 Usage Alternative Payment Pkg");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(transaction.getSubscription().getPackage().getResource().getName() ).as(" transaction.getSubscription().getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(transaction.getSubscription().getPackage().getResource().isCurrency() ).as(" transaction.getSubscription().getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getResource().isResource() ).as(" transaction.getSubscription().getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getResource().isToken() ).as(" transaction.getSubscription().getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getResource().isUsageToken() ).as(" transaction.getSubscription().getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getResource().isPayToken() ).as(" transaction.getSubscription().getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getResource().getResourceSymbol() ).as(" transaction.getSubscription().getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(transaction.getSubscription().getPackage().getResource().getCode() ).as(" transaction.getSubscription().getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(transaction.getSubscription().getPackage().getResource().getDescription() ).as(" transaction.getSubscription().getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(transaction.getSubscription().getPackage().getResource().getResourceName() ).as(" transaction.getSubscription().getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(transaction.getSubscription().getPackage().getResource().getCountryId() ).as(" transaction.getSubscription().getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getKey() ).as(" transaction.getSubscription().getPackage().getKey()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPriority() ).as(" transaction.getSubscription().getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getId() ).as(" transaction.getSubscription().getPackage().getId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().getName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().isCurrency() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().isResource() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().isToken() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().isUsageToken() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().isPayToken() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().getCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().getDescription() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().getResourceName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResource().getCountryId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getKey() ).as(" transaction.getSubscription().getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isZeroCostIgnore() ).as(" transaction.getSubscription().getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getStartDate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isActive() ).as(" transaction.getSubscription().getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isPreOrder() ).as(" transaction.getSubscription().getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTaxRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTaxCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" transaction.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExpiryDate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceBalances() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isDiscount() ).as(" transaction.getSubscription().getPackage().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getDiscountPromoText() ).as(" transaction.getSubscription().getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPackageId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getContentId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricingText1() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricingText2() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getUsageTime() ).as(" transaction.getSubscription().getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAccessDuration() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getCustomResourceBalances() ).as(" transaction.getSubscription().getPackage().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricingModelTier() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isArchived() ).as(" transaction.getSubscription().getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isBasePricePoint() ).as(" transaction.getSubscription().getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAccessDevice() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAlternativeRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length ).as(" transaction.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isTrial() ).as(" transaction.getSubscription().getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getGlid() ).as(" transaction.getSubscription().getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricepointIdLink() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isPreview() ).as(" transaction.getSubscription().getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getInteractiveFlag() ).as(" transaction.getSubscription().getPackage().getPricePoint().getInteractiveFlag()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isForcedPurchase() ).as(" transaction.getSubscription().getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" transaction.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getFixedExpiryDate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isReserveOnly() ).as(" transaction.getSubscription().getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getMinSubPeriod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPenaltyCharges() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getCancellation() ).as(" transaction.getSubscription().getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getMonthEndSubscription() ).as(" transaction.getSubscription().getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isHistoric() ).as(" transaction.getSubscription().getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getFixedRecurrence() ).as(" transaction.getSubscription().getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" transaction.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isReceipting() ).as(" transaction.getSubscription().getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getReceiptingAttribute() ).as(" transaction.getSubscription().getPackage().getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getOrder() ).as(" transaction.getSubscription().getPackage().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPaymentHandler() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getNonMatchAllUserGroups().length ).as(" transaction.getSubscription().getPackage().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isPromo() ).as(" transaction.getSubscription().getPackage().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isSubmitToPaymentHandler() ).as(" transaction.getSubscription().getPackage().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isSuppressToPaymentHandler() ).as(" transaction.getSubscription().getPackage().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName1() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName2() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTranslatedPricingText1() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTranslatedPricingText2() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getRecurrenceDay() ).as(" transaction.getSubscription().getPackage().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isAlignWithExternal() ).as(" transaction.getSubscription().getPackage().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getGracePeriod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getRetryFrequency() ).as(" transaction.getSubscription().getPackage().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getSuspensionPeriod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" transaction.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTranslatedPricingText() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getFairUsageLimit() ).as(" transaction.getSubscription().getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getFairUsagePeriod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit() ).as(" transaction.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExtensionPeriod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP() ).as(" transaction.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled() ).as(" transaction.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isTariff() ).as(" transaction.getSubscription().getPackage().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isHideForPurchaseOptions() ).as(" transaction.getSubscription().getPackage().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTax().getName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTax().getKey() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTax().getTaxRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTax().getTaxCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getBalances() ).as(" transaction.getSubscription().getPackage().getPricePoint().getBalances()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isRecurring() ).as(" transaction.getSubscription().getPackage().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" transaction.getSubscription().getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getKey() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getKey()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPricingModel() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getTier() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPackageIdentifier() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getServiceIdentifier() ).as(" transaction.getSubscription().getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().getName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().isResource() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().isToken() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().getCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().getDescription() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" transaction.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isVolumeType() ).as(" transaction.getSubscription().getPackage().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isOriginal() ).as(" transaction.getSubscription().getPackage().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers().length ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getProtectedFk() ).as(" transaction.getSubscription().getPackage().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getmPricingText1() ).as(" transaction.getSubscription().getPackage().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getmPricingText2() ).as(" transaction.getSubscription().getPackage().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isNonRecurring() ).as(" transaction.getSubscription().getPackage().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isEvent() ).as(" transaction.getSubscription().getPackage().getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getDescription() ).as(" transaction.getSubscription().getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getStandardRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getNetRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" transaction.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getChannel() ).as(" transaction.getSubscription().getPackage().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPartnerId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getMultiUsageMode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getNetworkCodeMatchMethod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isPreRatePriceGross() ).as(" transaction.getSubscription().getPackage().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPreRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPaymentInformation() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getContentName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAssetID() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPremiumLevel() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getReserveOnlyFlag() ).as(" transaction.getSubscription().getPackage().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getSupplierId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getDeviceType() ).as(" transaction.getSubscription().getPackage().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getUserGroups().length ).as(" transaction.getSubscription().getPackage().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getUserGroup() ).as(" transaction.getSubscription().getPackage().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPaymentType() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getEventDateTime() ).as(" transaction.getSubscription().getPackage().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getEventUnits() ).as(" transaction.getSubscription().getPackage().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPromoCodes().length ).as(" transaction.getSubscription().getPackage().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getBearerIds().length ).as(" transaction.getSubscription().getPackage().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPromoCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getDuration() ).as(" transaction.getSubscription().getPackage().getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getChargingMethod() ).as(" transaction.getSubscription().getPackage().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getBearer() ).as(" transaction.getSubscription().getPackage().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isInteractive() ).as(" transaction.getSubscription().getPackage().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isIncludeUnavailable() ).as(" transaction.getSubscription().getPackage().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExpressFlag() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isExpressFlag() ).as(" transaction.getSubscription().getPackage().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isCancellationUsage() ).as(" transaction.getSubscription().getPackage().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTierName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPromoPrecode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getUniquePromoCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPromoUniqueCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getNextCycleDiscount() ).as(" transaction.getSubscription().getPackage().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getHasHistoricPricePointFlag() ).as(" transaction.getSubscription().getPackage().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isIsForRenewal() ).as(" transaction.getSubscription().getPackage().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTaxRateAsDouble() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAffiliateID() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getTariff() ).as(" transaction.getSubscription().getPackage().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAggregatorId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isForcePurchaseFlow() ).as(" transaction.getSubscription().getPackage().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getReceipientMsisdn() ).as(" transaction.getSubscription().getPackage().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getProductCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getMerchantName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getInvoiceText() ).as(" transaction.getSubscription().getPackage().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isReIssueEnabled() ).as(" transaction.getSubscription().getPackage().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isReIssueFlagPresent() ).as(" transaction.getSubscription().getPackage().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getShortPackageId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getHistoryStartDate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getVendorId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isIsForNextPaymentAmount() ).as(" transaction.getSubscription().getPackage().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getRenewalPreRate() ).as(" transaction.getSubscription().getPackage().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" transaction.getSubscription().getPackage().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getContentCategory() ).as(" transaction.getSubscription().getPackage().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPartnerUrl() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPartnerContactInfo() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPartnerEmail() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPartnerName() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" transaction.getSubscription().getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getSubRenewalPricepointId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getLinkPricepointId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getSubPurchaseTransactionTrial() ).as(" transaction.getSubscription().getPackage().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" transaction.getSubscription().getPackage().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" transaction.getSubscription().getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExtIdentifier1() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExtIdentifier2() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExtIdentifier3() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getLanguageLocale() ).as(" transaction.getSubscription().getPackage().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExternalField1() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExternalField2() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getExternalTransId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getAccessChannel() ).as(" transaction.getSubscription().getPackage().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getPurchaseChannel() ).as(" transaction.getSubscription().getPackage().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getDeviceID() ).as(" transaction.getSubscription().getPackage().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getLocal() ).as(" transaction.getSubscription().getPackage().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getMsisdn() ).as(" transaction.getSubscription().getPackage().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getLanguageCode() ).as(" transaction.getSubscription().getPackage().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getActiveSubscriptions() ).as(" transaction.getSubscription().getPackage().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getPricePoint().getCsrId() ).as(" transaction.getSubscription().getPackage().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().isActive() ).as(" transaction.getSubscription().getPackage().isActive()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getTaxCode() ).as(" transaction.getSubscription().getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(transaction.getSubscription().getPackage().getPricingText1() ).as(" transaction.getSubscription().getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPricingText2() ).as(" transaction.getSubscription().getPackage().getPricingText2()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().isReserveOnly() ).as(" transaction.getSubscription().getPackage().isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().isOriginal() ).as(" transaction.getSubscription().getPackage().isOriginal()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPricingModel() ).as(" transaction.getSubscription().getPackage().getPricingModel()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getDescription() ).as(" transaction.getSubscription().getPackage().getDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getUrl() ).as(" transaction.getSubscription().getPackage().getUrl()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getRate() ).as(" transaction.getSubscription().getPackage().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(transaction.getSubscription().getPackage().isGoodwillCredit() ).as(" transaction.getSubscription().getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPriceModels() ).as(" transaction.getSubscription().getPackage().getPriceModels()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getFullPackagePricepointId() ).as(" transaction.getSubscription().getPackage().getFullPackagePricepointId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// java.lang.Character
        softly.assertThat(transaction.getSubscription().getPackage().getSimplePackageId() ).as(" transaction.getSubscription().getPackage().getSimplePackageId()" ).isEqualTo("pAlt");
        softly.assertThat(transaction.getSubscription().getPackage().getNotificationCategory() ).as(" transaction.getSubscription().getPackage().getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getKey() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getCategory()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" transaction.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray().length ).as(" transaction.getSubscription().getPackage().getServiceArray().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getName() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getName()" ).isEqualTo("Alternative Payment Service");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getKey() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getId() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getId()" ).isEqualTo("sAlt");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getDisplayName() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getDisplayName()" ).isEqualTo("sAlt (Alternative Payment Service)");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPricePoint() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getTaxCode() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getTaxCode()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getContentCategory() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPricingText1() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPricingText2() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isReserveOnly() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isDefaultService() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isDefaultService()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getUsageId() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getServiceCategory() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getDealName() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getDealName()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getIndirectValue() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPromoValue() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getContentItem() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProductCategory() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isVolumeService() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isVolumeService()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProductFk() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProductFk()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getHasExpress() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getHasExpress()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getServiceClass() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getServiceClass()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getChargeableBy() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isMicroService() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].ismRefundable() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isUseRateCard() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getInternalPartner() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getDescription() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getUrl() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isRefundable() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getSalesModel() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getServiceArray()[0].getServiceType() ).as(" transaction.getSubscription().getPackage().getServiceArray()[0].getServiceType()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().isEventPackage() ).as(" transaction.getSubscription().getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isRecurringPackage() ).as(" transaction.getSubscription().getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getPackageType() ).as(" transaction.getSubscription().getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(transaction.getSubscription().getPackage().getNonRefundableDescription() ).as(" transaction.getSubscription().getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().isRefundable() ).as(" transaction.getSubscription().getPackage().isRefundable()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isCalendarPackage() ).as(" transaction.getSubscription().getPackage().isCalendarPackage()" ).isTrue() ;
        softly.assertThat(transaction.getSubscription().getPackage().getProtectedType() ).as(" transaction.getSubscription().getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getDynamicProtectedValue() ).as(" transaction.getSubscription().getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getPurchaseMethod() ).as(" transaction.getSubscription().getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(transaction.getSubscription().getPackage().getKpiPackageProductCategory() ).as(" transaction.getSubscription().getPackage().getKpiPackageProductCategory()" ).isNull();
        softly.assertThat(transaction.getSubscription().getPackage().getKpiPackageType() ).as(" transaction.getSubscription().getPackage().getKpiPackageType()" ).isNull();
//check size of array!
        softly.assertThat(transaction.getSubscription().getPackage().getPricingModels().length ).as(" transaction.getSubscription().getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(transaction.getSubscription().getPackage().isExpressPurchase() ).as(" transaction.getSubscription().getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isRecieptingFlag() ).as(" transaction.getSubscription().getPackage().isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isPricePointOrder() ).as(" transaction.getSubscription().getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isSuperPackage() ).as(" transaction.getSubscription().getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isRevenueShareByUsage() ).as(" transaction.getSubscription().getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isDynamicDefault() ).as(" transaction.getSubscription().getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().getACEPackage() ).as(" transaction.getSubscription().getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(transaction.getSubscription().getPackage().isUpSell() ).as(" transaction.getSubscription().getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(transaction.getSubscription().getPackage().getLogoId() ).as(" transaction.getSubscription().getPackage().getLogoId()" ).isNull();

        softly.assertAll();

    }
}
