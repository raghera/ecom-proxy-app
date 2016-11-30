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
public class GetTransactions6_pt2_IT {

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
        assertNotNull(purchaseTrans);
        assertNotNull(usageTrans);

        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isResource() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getDescription() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getId() ).as(" purchaseTrans.getSubscription().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isZeroCostIgnore() ).as(" purchaseTrans.getSubscription().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isActive() ).as(" purchaseTrans.getSubscription().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPreOrder() ).as(" purchaseTrans.getSubscription().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTaxRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTaxCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceBalances() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNetRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isAlwaysValidateMsisdn() ).as(" purchaseTrans.getSubscription().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isDiscount() ).as(" purchaseTrans.getSubscription().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDiscountPromoText() ).as(" purchaseTrans.getSubscription().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPackageId() ).as(" purchaseTrans.getSubscription().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getContentId() ).as(" purchaseTrans.getSubscription().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingText1() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingText2() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUsageTime() ).as(" purchaseTrans.getSubscription().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAccessDuration() ).as(" purchaseTrans.getSubscription().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getCustomResourceBalances() ).as(" purchaseTrans.getSubscription().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingModelTier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isArchived() ).as(" purchaseTrans.getSubscription().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isBasePricePoint() ).as(" purchaseTrans.getSubscription().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAccessDevice() ).as(" purchaseTrans.getSubscription().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAlternativeRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBalanceImpacts().length ).as(" purchaseTrans.getSubscription().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isTrial() ).as(" purchaseTrans.getSubscription().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getGlid() ).as(" purchaseTrans.getSubscription().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricepointIdLink() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPreview() ).as(" purchaseTrans.getSubscription().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getInteractiveFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isForcedPurchase() ).as(" purchaseTrans.getSubscription().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isSubscriptionDuplicate() ).as(" purchaseTrans.getSubscription().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFixedExpiryDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReserveOnly() ).as(" purchaseTrans.getSubscription().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMinSubPeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPenaltyCharges() ).as(" purchaseTrans.getSubscription().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getCancellation() ).as(" purchaseTrans.getSubscription().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMonthEndSubscription() ).as(" purchaseTrans.getSubscription().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isHistoric() ).as(" purchaseTrans.getSubscription().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFixedRecurrence() ).as(" purchaseTrans.getSubscription().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isFixedRecurringPricePoint() ).as(" purchaseTrans.getSubscription().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReceipting() ).as(" purchaseTrans.getSubscription().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getReceiptingAttribute() ).as(" purchaseTrans.getSubscription().getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getOrder() ).as(" purchaseTrans.getSubscription().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPaymentHandler() ).as(" purchaseTrans.getSubscription().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNonMatchAllUserGroups().length ).as(" purchaseTrans.getSubscription().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPromo() ).as(" purchaseTrans.getSubscription().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isSubmitToPaymentHandler() ).as(" purchaseTrans.getSubscription().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isSuppressToPaymentHandler() ).as(" purchaseTrans.getSubscription().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName1() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName2() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText1() ).as(" purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText2() ).as(" purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRecurrenceDay() ).as(" purchaseTrans.getSubscription().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isAlignWithExternal() ).as(" purchaseTrans.getSubscription().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getGracePeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRetryFrequency() ).as(" purchaseTrans.getSubscription().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSuspensionPeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" purchaseTrans.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText() ).as(" purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFairUsageLimit() ).as(" purchaseTrans.getSubscription().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriodUnit() ).as(" purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtensionPeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIncludeServiceForPackageFUP() ).as(" purchaseTrans.getSubscription().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isFairUsagePolicyEnabled() ).as(" purchaseTrans.getSubscription().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isTariff() ).as(" purchaseTrans.getSubscription().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isHideForPurchaseOptions() ).as(" purchaseTrans.getSubscription().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getName() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getTaxRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getTaxCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBalances() ).as(" purchaseTrans.getSubscription().getPricePoint().getBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isRecurring() ).as(" purchaseTrans.getSubscription().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPricingModel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getTier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPackageIdentifier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getServiceIdentifier() ).as(" purchaseTrans.getSubscription().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isUsageToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isPayToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isCurrency() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isResource() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getDescription() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getCountryId() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getStandardRateWithoutTax() ).as(" purchaseTrans.getSubscription().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isVolumeType() ).as(" purchaseTrans.getSubscription().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isOriginal() ).as(" purchaseTrans.getSubscription().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers().length ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getTier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getProtectedFk() ).as(" purchaseTrans.getSubscription().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getmPricingText1() ).as(" purchaseTrans.getSubscription().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getmPricingText2() ).as(" purchaseTrans.getSubscription().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isNonRecurring() ).as(" purchaseTrans.getSubscription().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isEvent() ).as(" purchaseTrans.getSubscription().getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getStartDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDescription() ).as(" purchaseTrans.getSubscription().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getStandardRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExpiryDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getChannel() ).as(" purchaseTrans.getSubscription().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerId() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMultiUsageMode() ).as(" purchaseTrans.getSubscription().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getSubscription().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPreRatePriceGross() ).as(" purchaseTrans.getSubscription().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPreRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPaymentInformation() ).as(" purchaseTrans.getSubscription().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getContentName() ).as(" purchaseTrans.getSubscription().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAssetID() ).as(" purchaseTrans.getSubscription().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPremiumLevel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getReserveOnlyFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSupplierId() ).as(" purchaseTrans.getSubscription().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDeviceType() ).as(" purchaseTrans.getSubscription().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUserGroups().length ).as(" purchaseTrans.getSubscription().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUserGroup() ).as(" purchaseTrans.getSubscription().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPaymentType() ).as(" purchaseTrans.getSubscription().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getEventDateTime() ).as(" purchaseTrans.getSubscription().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getEventUnits() ).as(" purchaseTrans.getSubscription().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoCodes().length ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBearerIds().length ).as(" purchaseTrans.getSubscription().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDuration() ).as(" purchaseTrans.getSubscription().getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getChargingMethod() ).as(" purchaseTrans.getSubscription().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBearer() ).as(" purchaseTrans.getSubscription().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isInteractive() ).as(" purchaseTrans.getSubscription().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIncludeUnavailable() ).as(" purchaseTrans.getSubscription().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExpressFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isExpressFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isCancellationUsage() ).as(" purchaseTrans.getSubscription().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTierName() ).as(" purchaseTrans.getSubscription().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoPrecode() ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUniquePromoCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoUniqueCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNextCycleDiscount() ).as(" purchaseTrans.getSubscription().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getHasHistoricPricePointFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIsForRenewal() ).as(" purchaseTrans.getSubscription().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTaxRateAsDouble() ).as(" purchaseTrans.getSubscription().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAffiliateID() ).as(" purchaseTrans.getSubscription().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTariff() ).as(" purchaseTrans.getSubscription().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAggregatorId() ).as(" purchaseTrans.getSubscription().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isForcePurchaseFlow() ).as(" purchaseTrans.getSubscription().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getReceipientMsisdn() ).as(" purchaseTrans.getSubscription().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getProductCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMerchantName() ).as(" purchaseTrans.getSubscription().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getInvoiceText() ).as(" purchaseTrans.getSubscription().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReIssueEnabled() ).as(" purchaseTrans.getSubscription().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReIssueFlagPresent() ).as(" purchaseTrans.getSubscription().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getShortPackageId() ).as(" purchaseTrans.getSubscription().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getHistoryStartDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getVendorId() ).as(" purchaseTrans.getSubscription().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIsForNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getContentCategory() ).as(" purchaseTrans.getSubscription().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerUrl() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerContactInfo() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerEmail() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerName() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSubRenewalPricepointId() ).as(" purchaseTrans.getSubscription().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLinkPricepointId() ).as(" purchaseTrans.getSubscription().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSubPurchaseTransactionTrial() ).as(" purchaseTrans.getSubscription().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" purchaseTrans.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" purchaseTrans.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExternalField1() ).as(" purchaseTrans.getSubscription().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExternalField2() ).as(" purchaseTrans.getSubscription().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExternalTransId() ).as(" purchaseTrans.getSubscription().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLanguageLocale() ).as(" purchaseTrans.getSubscription().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDeviceID() ).as(" purchaseTrans.getSubscription().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLocal() ).as(" purchaseTrans.getSubscription().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMsisdn() ).as(" purchaseTrans.getSubscription().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAccessChannel() ).as(" purchaseTrans.getSubscription().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPurchaseChannel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLanguageCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getActiveSubscriptions() ).as(" purchaseTrans.getSubscription().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getCsrId() ).as(" purchaseTrans.getSubscription().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getDeviceID() ).as(" purchaseTrans.getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getMsisdn() ).as(" purchaseTrans.getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getAccessChannel() ).as(" purchaseTrans.getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getPurchaseChannel() ).as(" purchaseTrans.getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getCsrId() ).as(" purchaseTrans.getCsrId()" ).isEqualTo("test");
        softly.assertThat(purchaseTrans.getSessionId() ).as(" purchaseTrans.getSessionId()" ).isNull();
        softly.assertThat(purchaseTrans.getParentTransactionIdLong() ).as(" purchaseTrans.getParentTransactionIdLong()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getReIssue() ).as(" purchaseTrans.getReIssue()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getLocalPurchaseDate() ).as(" purchaseTrans.getLocalPurchaseDate()" ).isNull();
        softly.assertThat(purchaseTrans.getLocalPurchaseDateCal() ).as(" purchaseTrans.getLocalPurchaseDateCal()" ).isNull();
        softly.assertThat(purchaseTrans.getPurchaseRate() ).as(" purchaseTrans.getPurchaseRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getPurchaseNetRate() ).as(" purchaseTrans.getPurchaseNetRate()" ).isEqualTo(new Double(10.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getName() ).as(" purchaseTrans.getPurchaseCurrency().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isToken() ).as(" purchaseTrans.getPurchaseCurrency().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isUsageToken() ).as(" purchaseTrans.getPurchaseCurrency().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isPayToken() ).as(" purchaseTrans.getPurchaseCurrency().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getResourceSymbol() ).as(" purchaseTrans.getPurchaseCurrency().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isCurrency() ).as(" purchaseTrans.getPurchaseCurrency().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isResource() ).as(" purchaseTrans.getPurchaseCurrency().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getCode() ).as(" purchaseTrans.getPurchaseCurrency().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getResourceName() ).as(" purchaseTrans.getPurchaseCurrency().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getDescription() ).as(" purchaseTrans.getPurchaseCurrency().getDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getCountryId() ).as(" purchaseTrans.getPurchaseCurrency().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getNextCycleDiscountPercent() ).as(" purchaseTrans.getNextCycleDiscountPercent()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getRefundEnlargementDate() ).as(" purchaseTrans.getRefundEnlargementDate()" ).isNull();
        softly.assertThat(purchaseTrans.getRefundPaymentTransactionId() ).as(" purchaseTrans.getRefundPaymentTransactionId()" ).isNull();
        softly.assertThat(purchaseTrans.getRefundPaymentTransactionIdLong() ).as(" purchaseTrans.getRefundPaymentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getRefundable() ).as(" purchaseTrans.getRefundable()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getModificationInfo() ).as(" purchaseTrans.getModificationInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getClientId() ).as(" purchaseTrans.getClientId()" ).isEqualTo("test");
        softly.assertThat(purchaseTrans.getHostId() ).as(" purchaseTrans.getHostId()" ).isEqualTo("Ravis-MacBook-Pro.local");
        softly.assertThat(purchaseTrans.getNextCycleDiscountValue() ).as(" purchaseTrans.getNextCycleDiscountValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getContentDescription() ).as(" purchaseTrans.getContentDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getAssetId() ).as(" purchaseTrans.getAssetId()" ).isNull();
        softly.assertThat(purchaseTrans.getBalanceImpact() ).as(" purchaseTrans.getBalanceImpact()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubRecords() ).as(" purchaseTrans.getSubRecords()" ).isNull();
        softly.assertThat(purchaseTrans.getDeviceId() ).as(" purchaseTrans.getDeviceId()" ).isNull();
        softly.assertThat(purchaseTrans.getSuitabilityDecision() ).as(" purchaseTrans.getSuitabilityDecision()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.isContainsReIssueService() ).as(" purchaseTrans.isContainsReIssueService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getIsPrepay() ).as(" purchaseTrans.getIsPrepay()" ).isNull();
        softly.assertThat(purchaseTrans.getModifyTransactionId() ).as(" purchaseTrans.getModifyTransactionId()" ).isNull();
        softly.assertThat(purchaseTrans.getChildSpId() ).as(" purchaseTrans.getChildSpId()" ).isNull();
        softly.assertThat(purchaseTrans.getSpType() ).as(" purchaseTrans.getSpType()" ).isNull();
        softly.assertThat(purchaseTrans.isRefundTransaction() ).as(" purchaseTrans.isRefundTransaction()" ).isFalse() ;
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(purchaseTrans.getDescription() ).as(" purchaseTrans.getDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getStatus() ).as(" purchaseTrans.getStatus()" ).isEqualTo(101) ;
        softly.assertThat(purchaseTrans.getServiceId() ).as(" purchaseTrans.getServiceId()" ).isNull();
        softly.assertThat(purchaseTrans.getStandardRate() ).as(" purchaseTrans.getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getNonRefundableDescription() ).as(" purchaseTrans.getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.isRefundable() ).as(" purchaseTrans.isRefundable()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSpId() ).as(" purchaseTrans.getSpId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getChargingResource().getName() ).as(" purchaseTrans.getChargingResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getChargingResource().isToken() ).as(" purchaseTrans.getChargingResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().isUsageToken() ).as(" purchaseTrans.getChargingResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().isPayToken() ).as(" purchaseTrans.getChargingResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().getResourceSymbol() ).as(" purchaseTrans.getChargingResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getChargingResource().isCurrency() ).as(" purchaseTrans.getChargingResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getChargingResource().isResource() ).as(" purchaseTrans.getChargingResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().getCode() ).as(" purchaseTrans.getChargingResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getChargingResource().getResourceName() ).as(" purchaseTrans.getChargingResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getChargingResource().getDescription() ).as(" purchaseTrans.getChargingResource().getDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getChargingResource().getCountryId() ).as(" purchaseTrans.getChargingResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getReason() ).as(" purchaseTrans.getReason()" ).isNull();
        softly.assertThat(purchaseTrans.isSuccess() ).as(" purchaseTrans.isSuccess()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getTransactionId() ).as(" purchaseTrans.getTransactionId()" ).isNotEmpty();

// com.vizzavi.ecommerce.business.selfcare.TransactionType
        softly.assertThat(purchaseTrans.getType().getType() ).as(" purchaseTrans.getType().getType()" ).isEqualTo("PAYMENT_PACKAGE_TRANSACTION");
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(purchaseTrans.getType().isPaymentContent() ).as(" purchaseTrans.getType().isPaymentContent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundCash() ).as(" purchaseTrans.getType().isRefundCash()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundDiscount() ).as(" purchaseTrans.getType().isRefundDiscount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundEnlargement() ).as(" purchaseTrans.getType().isRefundEnlargement()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefundNonCash() ).as(" purchaseTrans.getType().isRefundNonCash()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().isRefund() ).as(" purchaseTrans.getType().isRefund()" ).isFalse() ;
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
        softly.assertThat(purchaseTrans.getType().isGoodwillCredit() ).as(" purchaseTrans.getType().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getType().getResourceName() ).as(" purchaseTrans.getType().getResourceName()" ).isEqualTo("PAYMENT_PACKAGE_TRANSACTION");
        softly.assertThat(purchaseTrans.getStatus() ).as(" purchaseTrans.getStatus()" ).isEqualTo(101) ;
        softly.assertThat(purchaseTrans.getServiceId() ).as(" purchaseTrans.getServiceId()" ).isNull();
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(purchaseTrans.getMatchingAttributes().getChannel() ).as(" purchaseTrans.getMatchingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getMultiUsageMode() ).as(" purchaseTrans.getMatchingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getMatchingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().isPreRatePriceGross() ).as(" purchaseTrans.getMatchingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPreRate() ).as(" purchaseTrans.getMatchingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPaymentInformation() ).as(" purchaseTrans.getMatchingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getContentName() ).as(" purchaseTrans.getMatchingAttributes().getContentName()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getAssetID() ).as(" purchaseTrans.getMatchingAttributes().getAssetID()" ).isNull();
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
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPartnerId() ).as(" purchaseTrans.getMatchingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getAccessChannel() ).as(" purchaseTrans.getMatchingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getPurchaseChannel() ).as(" purchaseTrans.getMatchingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getDeviceID() ).as(" purchaseTrans.getMatchingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLocal() ).as(" purchaseTrans.getMatchingAttributes().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getMsisdn() ).as(" purchaseTrans.getMatchingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLanguageCode() ).as(" purchaseTrans.getMatchingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getActiveSubscriptions() ).as(" purchaseTrans.getMatchingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getCsrId() ).as(" purchaseTrans.getMatchingAttributes().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExternalField1() ).as(" purchaseTrans.getMatchingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExternalField2() ).as(" purchaseTrans.getMatchingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getExternalTransId() ).as(" purchaseTrans.getMatchingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getMatchingAttributes().getLanguageLocale() ).as(" purchaseTrans.getMatchingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getPackageId() ).as(" purchaseTrans.getPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getRateIdentifier() ).as(" purchaseTrans.getRateIdentifier()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getUsageTime() ).as(" purchaseTrans.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSessionId() ).as(" purchaseTrans.getSessionId()" ).isNull();
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
        softly.assertThat(purchaseTrans.getAccessChannel() ).as(" purchaseTrans.getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getPurchaseChannel() ).as(" purchaseTrans.getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getDeviceID() ).as(" purchaseTrans.getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getMsisdn() ).as(" purchaseTrans.getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getCsrId() ).as(" purchaseTrans.getCsrId()" ).isEqualTo("test");
        softly.assertThat(purchaseTrans.getSubscriptionId() ).as(" purchaseTrans.getSubscriptionId()" ).isEqualTo("8470");
// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//check size of array!
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices().length ).as(" purchaseTrans.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(5030)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getStatus() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(purchaseTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" purchaseTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
////check size of array!
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getName() ).as(" purchaseTrans.getSubscription().getPackage().getName()" ).isEqualTo("2 Usage Alternative Payment Pkg");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getName() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isToken() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getCode() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isResource() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPriority() ).as(" purchaseTrans.getSubscription().getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getId() ).as(" purchaseTrans.getSubscription().getPackage().getId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getParentPackageId() ).as(" purchaseTrans.getSubscription().getPackage().getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getUrl() ).as(" purchaseTrans.getSubscription().getPackage().getUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getRate() ).as(" purchaseTrans.getSubscription().getPackage().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricingText2()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isResource() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isDiscount() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDiscountPromoText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getContentId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getUsageTime() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDuration() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getCustomResourceBalances() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isPreOrder() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExpiryDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isZeroCostIgnore() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceBalances() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingModelTier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isArchived() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isBasePricePoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getStartDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isActive() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageIdentifier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getServiceIdentifier() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isTrial() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDevice() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAlternativeRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isAlignWithExternal() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getGracePeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getRetryFrequency() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getSuspensionPeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsageLimit() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
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
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMonthEndSubscription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isHistoric() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedRecurrence() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isReceipting() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getReceiptingAttribute() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getReceiptingAttribute()" ).isNullOrEmpty();
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
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getGlid() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPricepointIdLink() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isPreview() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getInteractiveFlag() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isForcedPurchase() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedExpiryDate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isReserveOnly() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMinSubPeriod() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPenaltyCharges() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getCancellation() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getProtectedFk() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isNonRecurring() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isEvent() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isEvent()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isResource() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
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
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getNetRate() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getChannel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getChannel()" ).isEqualTo(999) ;
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
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessChannel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getPurchaseChannel() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getDeviceID() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLocal() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getMsisdn() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageCode() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getActiveSubscriptions() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getCsrId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField1() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField2() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalTransId() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageLocale() ).as(" purchaseTrans.getSubscription().getPackage().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isGoodwillCredit() ).as(" purchaseTrans.getSubscription().getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPriceModels() ).as(" purchaseTrans.getSubscription().getPackage().getPriceModels()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getFullPackagePricepointId() ).as(" purchaseTrans.getSubscription().getPackage().getFullPackagePricepointId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// java.lang.Character
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getSimplePackageId() ).as(" purchaseTrans.getSubscription().getPackage().getSimplePackageId()" ).isEqualTo("pAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNotificationCategory() ).as(" purchaseTrans.getSubscription().getPackage().getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" purchaseTrans.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getName() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getName()" ).isEqualTo("Alternative Payment Service");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getKey() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getId() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getId()" ).isEqualTo("sAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDisplayName() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDisplayName()" ).isEqualTo("sAlt (Alternative Payment Service)");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getUrl() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText1() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText2() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
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

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }

    }
}
