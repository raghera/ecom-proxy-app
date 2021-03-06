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
public class GetTransactions6_pt4_IT {

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


        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getDiscountPromoText() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPackageId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getContentId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricingText1() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricingText2() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getUsageTime() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAccessDuration() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getCustomResourceBalances() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isPreOrder() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTaxRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTaxCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getDescription() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getStandardRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExpiryDate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isZeroCostIgnore() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceBalances() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricingModelTier() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isArchived() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isBasePricePoint() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getStartDate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isActive() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPackageIdentifier() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getServiceIdentifier() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isTrial() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAccessDevice() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAlternativeRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isAlignWithExternal() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getGracePeriod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getRetryFrequency() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getSuspensionPeriod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getFairUsageLimit() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isVolumeType() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isOriginal() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers().length ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getBalances() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getBalances()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isRecurring() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getKey() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPricingModel() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getTier() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getMonthEndSubscription() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isHistoric() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getFixedRecurrence() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isReceipting() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getReceiptingAttribute() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getOrder() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPaymentHandler() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getNonMatchAllUserGroups().length ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isPromo() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isSubmitToPaymentHandler() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isSuppressToPaymentHandler() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName1() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName2() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText1() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText2() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getRecurrenceDay() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getGlid() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPricepointIdLink() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isPreview() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getInteractiveFlag() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isForcedPurchase() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getFixedExpiryDate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isReserveOnly() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getMinSubPeriod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPenaltyCharges() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getCancellation() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getProtectedFk() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getmPricingText1() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getmPricingText2() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isNonRecurring() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isEvent() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isEvent()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isToken() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getDescription() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isResource() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExtensionPeriod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isTariff() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isHideForPurchaseOptions() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTax().getName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTax().getKey() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getNetRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getChannel() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getMultiUsageMode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getNetworkCodeMatchMethod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isPreRatePriceGross() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPreRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPaymentInformation() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getContentName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAssetID() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPremiumLevel() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getReserveOnlyFlag() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getSupplierId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getDeviceType() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getUserGroups().length ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getUserGroup() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPaymentType() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getEventDateTime() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getEventUnits() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPromoCodes().length ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getBearerIds().length ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPromoCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getDuration() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getChargingMethod() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getBearer() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isInteractive() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isIncludeUnavailable() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExpressFlag() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isExpressFlag() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isCancellationUsage() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTierName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPromoPrecode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getUniquePromoCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPromoUniqueCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getNextCycleDiscount() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getHasHistoricPricePointFlag() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isIsForRenewal() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTaxRateAsDouble() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAffiliateID() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getTariff() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAggregatorId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isForcePurchaseFlow() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getReceipientMsisdn() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getProductCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getMerchantName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getInvoiceText() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isReIssueEnabled() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isReIssueFlagPresent() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getShortPackageId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getHistoryStartDate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getVendorId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isIsForNextPaymentAmount() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getRenewalPreRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getContentCategory() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPartnerUrl() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPartnerContactInfo() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPartnerEmail() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPartnerName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getSubRenewalPricepointId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getLinkPricepointId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getSubPurchaseTransactionTrial() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier1() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier2() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier3() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPartnerId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getAccessChannel() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getPurchaseChannel() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getDeviceID() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getLocal() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getMsisdn() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getLanguageCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getActiveSubscriptions() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getCsrId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExternalField1() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExternalField2() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getExternalTransId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getLanguageLocale() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getTaxCode() ).as(" usageTrans.getSubscription().getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageTrans.getSubscription().getPackage().getDescription() ).as(" usageTrans.getSubscription().getPackage().getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().isGoodwillCredit() ).as(" usageTrans.getSubscription().getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPriceModels() ).as(" usageTrans.getSubscription().getPackage().getPriceModels()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getFullPackagePricepointId() ).as(" usageTrans.getSubscription().getPackage().getFullPackagePricepointId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// java.lang.Character
        softly.assertThat(usageTrans.getSubscription().getPackage().getSimplePackageId() ).as(" usageTrans.getSubscription().getPackage().getSimplePackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageTrans.getSubscription().getPackage().getNotificationCategory() ).as(" usageTrans.getSubscription().getPackage().getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getKey() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" usageTrans.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray().length ).as(" usageTrans.getSubscription().getPackage().getServiceArray().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getName() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getName()" ).isEqualTo("Alternative Payment Service");
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getKey() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getId() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getId()" ).isEqualTo("sAlt");
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getDisplayName() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getDisplayName()" ).isEqualTo("sAlt (Alternative Payment Service)");
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getUrl() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText1() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText2() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isDefaultService() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isDefaultService()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getUsageId() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceCategory() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getDealName() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getDealName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValue() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValue() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getContentItem() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductCategory() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isVolumeService() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isVolumeService()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductFk() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProductFk()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getHasExpress() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getHasExpress()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceClass() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceClass()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getChargeableBy() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isMicroService() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].ismRefundable() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isUseRateCard() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getInternalPartner() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricePoint() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getTaxCode() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getTaxCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getContentCategory() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getDescription() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isRefundable() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getSalesModel() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].isReserveOnly() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceType() ).as(" usageTrans.getSubscription().getPackage().getServiceArray()[0].getServiceType()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().isEventPackage() ).as(" usageTrans.getSubscription().getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isRecurringPackage() ).as(" usageTrans.getSubscription().getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPackageType() ).as(" usageTrans.getSubscription().getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(usageTrans.getSubscription().getPackage().getNonRefundableDescription() ).as(" usageTrans.getSubscription().getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().isRefundable() ).as(" usageTrans.getSubscription().getPackage().isRefundable()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isCalendarPackage() ).as(" usageTrans.getSubscription().getPackage().isCalendarPackage()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getProtectedType() ).as(" usageTrans.getSubscription().getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getDynamicProtectedValue() ).as(" usageTrans.getSubscription().getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPurchaseMethod() ).as(" usageTrans.getSubscription().getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getKpiPackageProductCategory() ).as(" usageTrans.getSubscription().getPackage().getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getKpiPackageType() ).as(" usageTrans.getSubscription().getPackage().getKpiPackageType()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricingModels().length ).as(" usageTrans.getSubscription().getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isExpressPurchase() ).as(" usageTrans.getSubscription().getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isRecieptingFlag() ).as(" usageTrans.getSubscription().getPackage().isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isPricePointOrder() ).as(" usageTrans.getSubscription().getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isSuperPackage() ).as(" usageTrans.getSubscription().getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isRevenueShareByUsage() ).as(" usageTrans.getSubscription().getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isDynamicDefault() ).as(" usageTrans.getSubscription().getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getACEPackage() ).as(" usageTrans.getSubscription().getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isUpSell() ).as(" usageTrans.getSubscription().getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().getLogoId() ).as(" usageTrans.getSubscription().getPackage().getLogoId()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().getPartnerInfo() ).as(" usageTrans.getSubscription().getPackage().getPartnerInfo()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getIsPackageModel() ).as(" usageTrans.getSubscription().getPackage().getIsPackageModel()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isParentPackage() ).as(" usageTrans.getSubscription().getPackage().isParentPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getChildPackages() ).as(" usageTrans.getSubscription().getPackage().getChildPackages()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getServicesNotInPackageFairUsagePolicyList() ).as(" usageTrans.getSubscription().getPackage().getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().isHasParentSub() ).as(" usageTrans.getSubscription().getPackage().isHasParentSub()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getParentSubId() ).as(" usageTrans.getSubscription().getPackage().getParentSubId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().isHasParentSubSuspendedResProv() ).as(" usageTrans.getSubscription().getPackage().isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getParentSubStatus() ).as(" usageTrans.getSubscription().getPackage().getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isDisallowCancellations() ).as(" usageTrans.getSubscription().getPackage().isDisallowCancellations()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getSalesModel() ).as(" usageTrans.getSubscription().getPackage().getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPackageClass() ).as(" usageTrans.getSubscription().getPackage().getPackageClass()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().isDataVoiceTariffInclusive() ).as(" usageTrans.getSubscription().getPackage().isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getNominalValue() ).as(" usageTrans.getSubscription().getPackage().getNominalValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isUseBeingDeprovisionedStatus() ).as(" usageTrans.getSubscription().getPackage().isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getDisallowDuplicateSubPurchase() ).as(" usageTrans.getSubscription().getPackage().getDisallowDuplicateSubPurchase()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getNoActivePricepoints() ).as(" usageTrans.getSubscription().getPackage().getNoActivePricepoints()" ).isEqualTo(2) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isHasBalanceImpactsWithDate() ).as(" usageTrans.getSubscription().getPackage().isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isHasPricePointsWithDate() ).as(" usageTrans.getSubscription().getPackage().isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isHasPromosWithDate() ).as(" usageTrans.getSubscription().getPackage().isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isHasTaxRateWithDate() ).as(" usageTrans.getSubscription().getPackage().isHasTaxRateWithDate()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPromoCodeMap() ).as(" usageTrans.getSubscription().getPackage().getPromoCodeMap()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPromoCodeMapSize() ).as(" usageTrans.getSubscription().getPackage().getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getActiveStatusAsString() ).as(" usageTrans.getSubscription().getPackage().getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(usageTrans.getSubscription().getPackage().isUseRateCardService() ).as(" usageTrans.getSubscription().getPackage().isUseRateCardService()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getRateCardServiceId() ).as(" usageTrans.getSubscription().getPackage().getRateCardServiceId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().isUserGroupCalendarPricePointPackage() ).as(" usageTrans.getSubscription().getPackage().isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isUpsellDiscountProrated() ).as(" usageTrans.getSubscription().getPackage().isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isDisallowPrerate() ).as(" usageTrans.getSubscription().getPackage().isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPackage().getServiceNames().length ).as(" usageTrans.getSubscription().getPackage().getServiceNames().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getDefaultPartnerProvisioningId() ).as(" usageTrans.getSubscription().getPackage().getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getUserGroupComparisonAtRenewal() ).as(" usageTrans.getSubscription().getPackage().getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
        softly.assertThat(usageTrans.getSubscription().getPackage().isActive() ).as(" usageTrans.getSubscription().getPackage().isActive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isDefault() ).as(" usageTrans.getSubscription().getPackage().isDefault()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().isOriginal() ).as(" usageTrans.getSubscription().getPackage().isOriginal()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPackage().isReserveOnly() ).as(" usageTrans.getSubscription().getPackage().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricingModel() ).as(" usageTrans.getSubscription().getPackage().getPricingModel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getCountry() ).as(" usageTrans.getSubscription().getCountry()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isPromotional() ).as(" usageTrans.getSubscription().isPromotional()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPromotionalExpiryDate() ).as(" usageTrans.getSubscription().getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getStatus() ).as(" usageTrans.getSubscription().getStatus()" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getExternalSubId() ).as(" usageTrans.getSubscription().getExternalSubId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getOptions() ).as(" usageTrans.getSubscription().getOptions()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackageId() ).as(" usageTrans.getSubscription().getPackageId()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().getName() ).as(" usageTrans.getSubscription().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().isToken() ).as(" usageTrans.getSubscription().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().isUsageToken() ).as(" usageTrans.getSubscription().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().isPayToken() ).as(" usageTrans.getSubscription().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().getResourceSymbol() ).as(" usageTrans.getSubscription().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().getCode() ).as(" usageTrans.getSubscription().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().getDescription() ).as(" usageTrans.getSubscription().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().getCountryId() ).as(" usageTrans.getSubscription().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().isResource() ).as(" usageTrans.getSubscription().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().isCurrency() ).as(" usageTrans.getSubscription().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResource().getResourceName() ).as(" usageTrans.getSubscription().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getKey() ).as(" usageTrans.getSubscription().getPricePoint().getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getId() ).as(" usageTrans.getSubscription().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getRate() ).as(" usageTrans.getSubscription().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isDiscount() ).as(" usageTrans.getSubscription().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getDiscountPromoText() ).as(" usageTrans.getSubscription().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPackageId() ).as(" usageTrans.getSubscription().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getContentId() ).as(" usageTrans.getSubscription().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricingText1() ).as(" usageTrans.getSubscription().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricingText2() ).as(" usageTrans.getSubscription().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getUsageTime() ).as(" usageTrans.getSubscription().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAccessDuration() ).as(" usageTrans.getSubscription().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getCustomResourceBalances() ).as(" usageTrans.getSubscription().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isPreOrder() ).as(" usageTrans.getSubscription().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTaxRate() ).as(" usageTrans.getSubscription().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTaxCode() ).as(" usageTrans.getSubscription().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getLinkedByTrialPricepoint() ).as(" usageTrans.getSubscription().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getDescription() ).as(" usageTrans.getSubscription().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getStandardRate() ).as(" usageTrans.getSubscription().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExpiryDate() ).as(" usageTrans.getSubscription().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isZeroCostIgnore() ).as(" usageTrans.getSubscription().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceBalances() ).as(" usageTrans.getSubscription().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricingModelTier() ).as(" usageTrans.getSubscription().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isArchived() ).as(" usageTrans.getSubscription().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isBasePricePoint() ).as(" usageTrans.getSubscription().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getStartDate() ).as(" usageTrans.getSubscription().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isActive() ).as(" usageTrans.getSubscription().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPackageIdentifier() ).as(" usageTrans.getSubscription().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getServiceIdentifier() ).as(" usageTrans.getSubscription().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isTrial() ).as(" usageTrans.getSubscription().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAccessDevice() ).as(" usageTrans.getSubscription().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAlternativeRate() ).as(" usageTrans.getSubscription().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isAlignWithExternal() ).as(" usageTrans.getSubscription().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getGracePeriod() ).as(" usageTrans.getSubscription().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getRetryFrequency() ).as(" usageTrans.getSubscription().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getSuspensionPeriod() ).as(" usageTrans.getSubscription().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" usageTrans.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTranslatedPricingText() ).as(" usageTrans.getSubscription().getPricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getFairUsageLimit() ).as(" usageTrans.getSubscription().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isVolumeType() ).as(" usageTrans.getSubscription().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isOriginal() ).as(" usageTrans.getSubscription().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers().length ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getKey() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getTier() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getBalances() ).as(" usageTrans.getSubscription().getPricePoint().getBalances()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isRecurring() ).as(" usageTrans.getSubscription().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageTrans.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().getKey() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().getPricingModel() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().getTier() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" usageTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getMonthEndSubscription() ).as(" usageTrans.getSubscription().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isHistoric() ).as(" usageTrans.getSubscription().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getFixedRecurrence() ).as(" usageTrans.getSubscription().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isFixedRecurringPricePoint() ).as(" usageTrans.getSubscription().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isReceipting() ).as(" usageTrans.getSubscription().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getReceiptingAttribute() ).as(" usageTrans.getSubscription().getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getOrder() ).as(" usageTrans.getSubscription().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPaymentHandler() ).as(" usageTrans.getSubscription().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getNonMatchAllUserGroups().length ).as(" usageTrans.getSubscription().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isPromo() ).as(" usageTrans.getSubscription().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isSubmitToPaymentHandler() ).as(" usageTrans.getSubscription().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isSuppressToPaymentHandler() ).as(" usageTrans.getSubscription().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricingTextTemplateName1() ).as(" usageTrans.getSubscription().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricingTextTemplateName2() ).as(" usageTrans.getSubscription().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTranslatedPricingText1() ).as(" usageTrans.getSubscription().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTranslatedPricingText2() ).as(" usageTrans.getSubscription().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getRecurrenceDay() ).as(" usageTrans.getSubscription().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getBalanceImpacts().length ).as(" usageTrans.getSubscription().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getGlid() ).as(" usageTrans.getSubscription().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPricepointIdLink() ).as(" usageTrans.getSubscription().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isPreview() ).as(" usageTrans.getSubscription().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getInteractiveFlag() ).as(" usageTrans.getSubscription().getPricePoint().getInteractiveFlag()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isForcedPurchase() ).as(" usageTrans.getSubscription().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isSubscriptionDuplicate() ).as(" usageTrans.getSubscription().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getFixedExpiryDate() ).as(" usageTrans.getSubscription().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isReserveOnly() ).as(" usageTrans.getSubscription().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getMinSubPeriod() ).as(" usageTrans.getSubscription().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPenaltyCharges() ).as(" usageTrans.getSubscription().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getCancellation() ).as(" usageTrans.getSubscription().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getProtectedFk() ).as(" usageTrans.getSubscription().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getmPricingText1() ).as(" usageTrans.getSubscription().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getmPricingText2() ).as(" usageTrans.getSubscription().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isNonRecurring() ).as(" usageTrans.getSubscription().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isEvent() ).as(" usageTrans.getSubscription().getPricePoint().isEvent()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().getName() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().isToken() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().isUsageToken() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().isPayToken() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().getResourceSymbol() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().getCode() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().getDescription() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().getCountryId() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().isResource() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().isCurrency() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getResourceField().getResourceName() ).as(" usageTrans.getSubscription().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getStandardRateWithoutTax() ).as(" usageTrans.getSubscription().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getFairUsagePeriod() ).as(" usageTrans.getSubscription().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getFairUsagePeriodUnit() ).as(" usageTrans.getSubscription().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExtensionPeriod() ).as(" usageTrans.getSubscription().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isIncludeServiceForPackageFUP() ).as(" usageTrans.getSubscription().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isFairUsagePolicyEnabled() ).as(" usageTrans.getSubscription().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isTariff() ).as(" usageTrans.getSubscription().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isHideForPurchaseOptions() ).as(" usageTrans.getSubscription().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTax().getName() ).as(" usageTrans.getSubscription().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTax().getKey() ).as(" usageTrans.getSubscription().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTax().getTaxRate() ).as(" usageTrans.getSubscription().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTax().getTaxCode() ).as(" usageTrans.getSubscription().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getNetRate() ).as(" usageTrans.getSubscription().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isAlwaysValidateMsisdn() ).as(" usageTrans.getSubscription().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getChannel() ).as(" usageTrans.getSubscription().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getMultiUsageMode() ).as(" usageTrans.getSubscription().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getNetworkCodeMatchMethod() ).as(" usageTrans.getSubscription().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isPreRatePriceGross() ).as(" usageTrans.getSubscription().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPreRate() ).as(" usageTrans.getSubscription().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPaymentInformation() ).as(" usageTrans.getSubscription().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getContentName() ).as(" usageTrans.getSubscription().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAssetID() ).as(" usageTrans.getSubscription().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPremiumLevel() ).as(" usageTrans.getSubscription().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getReserveOnlyFlag() ).as(" usageTrans.getSubscription().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getSupplierId() ).as(" usageTrans.getSubscription().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getDeviceType() ).as(" usageTrans.getSubscription().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getUserGroups().length ).as(" usageTrans.getSubscription().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getUserGroup() ).as(" usageTrans.getSubscription().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPaymentType() ).as(" usageTrans.getSubscription().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getEventDateTime() ).as(" usageTrans.getSubscription().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getEventUnits() ).as(" usageTrans.getSubscription().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPromoCodes().length ).as(" usageTrans.getSubscription().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getBearerIds().length ).as(" usageTrans.getSubscription().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPromoCode() ).as(" usageTrans.getSubscription().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getDuration() ).as(" usageTrans.getSubscription().getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getChargingMethod() ).as(" usageTrans.getSubscription().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getBearer() ).as(" usageTrans.getSubscription().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isInteractive() ).as(" usageTrans.getSubscription().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isIncludeUnavailable() ).as(" usageTrans.getSubscription().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExpressFlag() ).as(" usageTrans.getSubscription().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isExpressFlag() ).as(" usageTrans.getSubscription().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isCancellationUsage() ).as(" usageTrans.getSubscription().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTierName() ).as(" usageTrans.getSubscription().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPromoPrecode() ).as(" usageTrans.getSubscription().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getUniquePromoCode() ).as(" usageTrans.getSubscription().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPromoUniqueCode() ).as(" usageTrans.getSubscription().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getNextCycleDiscount() ).as(" usageTrans.getSubscription().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getHasHistoricPricePointFlag() ).as(" usageTrans.getSubscription().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isIsForRenewal() ).as(" usageTrans.getSubscription().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTaxRateAsDouble() ).as(" usageTrans.getSubscription().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAffiliateID() ).as(" usageTrans.getSubscription().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getTariff() ).as(" usageTrans.getSubscription().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAggregatorId() ).as(" usageTrans.getSubscription().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isForcePurchaseFlow() ).as(" usageTrans.getSubscription().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getReceipientMsisdn() ).as(" usageTrans.getSubscription().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getProductCode() ).as(" usageTrans.getSubscription().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getMerchantName() ).as(" usageTrans.getSubscription().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getInvoiceText() ).as(" usageTrans.getSubscription().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isReIssueEnabled() ).as(" usageTrans.getSubscription().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isReIssueFlagPresent() ).as(" usageTrans.getSubscription().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getShortPackageId() ).as(" usageTrans.getSubscription().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getHistoryStartDate() ).as(" usageTrans.getSubscription().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getVendorId() ).as(" usageTrans.getSubscription().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isIsForNextPaymentAmount() ).as(" usageTrans.getSubscription().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getRenewalPreRate() ).as(" usageTrans.getSubscription().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" usageTrans.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getContentCategory() ).as(" usageTrans.getSubscription().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPartnerUrl() ).as(" usageTrans.getSubscription().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPartnerContactInfo() ).as(" usageTrans.getSubscription().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPartnerEmail() ).as(" usageTrans.getSubscription().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPartnerName() ).as(" usageTrans.getSubscription().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getSubRenewalPricepointId() ).as(" usageTrans.getSubscription().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getLinkPricepointId() ).as(" usageTrans.getSubscription().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getSubPurchaseTransactionTrial() ).as(" usageTrans.getSubscription().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" usageTrans.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" usageTrans.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExtIdentifier1() ).as(" usageTrans.getSubscription().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExtIdentifier2() ).as(" usageTrans.getSubscription().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExtIdentifier3() ).as(" usageTrans.getSubscription().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPartnerId() ).as(" usageTrans.getSubscription().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getAccessChannel() ).as(" usageTrans.getSubscription().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getPurchaseChannel() ).as(" usageTrans.getSubscription().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getDeviceID() ).as(" usageTrans.getSubscription().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getLocal() ).as(" usageTrans.getSubscription().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getMsisdn() ).as(" usageTrans.getSubscription().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getLanguageCode() ).as(" usageTrans.getSubscription().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getActiveSubscriptions() ).as(" usageTrans.getSubscription().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getCsrId() ).as(" usageTrans.getSubscription().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExternalField1() ).as(" usageTrans.getSubscription().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExternalField2() ).as(" usageTrans.getSubscription().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getExternalTransId() ).as(" usageTrans.getSubscription().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPricePoint().getLanguageLocale() ).as(" usageTrans.getSubscription().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPaymentType() ).as(" usageTrans.getSubscription().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageTrans.getSubscription().getMerchantName() ).as(" usageTrans.getSubscription().getMerchantName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRenewalPreRate() ).as(" usageTrans.getSubscription().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getExtIdentifier1() ).as(" usageTrans.getSubscription().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getExtIdentifier2() ).as(" usageTrans.getSubscription().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getExtIdentifier3() ).as(" usageTrans.getSubscription().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getMsisdn() ).as(" usageTrans.getSubscription().getMsisdn()" ).isEqualTo("2054932550");
        softly.assertThat(usageTrans.getSubscription().getCsrId() ).as(" usageTrans.getSubscription().getCsrId()" ).isEqualTo("test");
        softly.assertThat(usageTrans.getSubscription().getSubscriptionId() ).as(" usageTrans.getSubscription().getSubscriptionId()" ).isEqualTo("8470");
        softly.assertThat(usageTrans.getSubscription().getAccount() ).as(" usageTrans.getSubscription().getAccount()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isInactiveOrClosed() ).as(" usageTrans.getSubscription().isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isFailed() ).as(" usageTrans.getSubscription().isFailed()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isBeingProvisioned() ).as(" usageTrans.getSubscription().isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isReserved() ).as(" usageTrans.getSubscription().isReserved()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getLinkedPtID() ).as(" usageTrans.getSubscription().getLinkedPtID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isPreOrdered() ).as(" usageTrans.getSubscription().isPreOrdered()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getContentPaymentType() ).as(" usageTrans.getSubscription().getContentPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageTrans.getSubscription().getPurchaseDeviceType() ).as(" usageTrans.getSubscription().getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getNextCyclePercentDiscount() ).as(" usageTrans.getSubscription().getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getNextPaymentAmount() ).as(" usageTrans.getSubscription().getNextPaymentAmount()" ).isEqualTo(new Double(10.0)) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getServiceIds().length ).as(" usageTrans.getSubscription().getServiceIds().length" ).isEqualTo(1) ;
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getChannel() ).as(" usageTrans.getSubscription().getRatingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getMultiUsageMode() ).as(" usageTrans.getSubscription().getRatingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod() ).as(" usageTrans.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isPreRatePriceGross() ).as(" usageTrans.getSubscription().getRatingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPreRate() ).as(" usageTrans.getSubscription().getRatingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPaymentInformation() ).as(" usageTrans.getSubscription().getRatingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getContentName() ).as(" usageTrans.getSubscription().getRatingAttributes().getContentName()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getAssetID() ).as(" usageTrans.getSubscription().getRatingAttributes().getAssetID()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPremiumLevel() ).as(" usageTrans.getSubscription().getRatingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getReserveOnlyFlag() ).as(" usageTrans.getSubscription().getRatingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getSupplierId() ).as(" usageTrans.getSubscription().getRatingAttributes().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getDeviceType() ).as(" usageTrans.getSubscription().getRatingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getUserGroups().length ).as(" usageTrans.getSubscription().getRatingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getUserGroup() ).as(" usageTrans.getSubscription().getRatingAttributes().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPaymentType() ).as(" usageTrans.getSubscription().getRatingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getEventDateTime() ).as(" usageTrans.getSubscription().getRatingAttributes().getEventDateTime()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getEventUnits() ).as(" usageTrans.getSubscription().getRatingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPromoCodes().length ).as(" usageTrans.getSubscription().getRatingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getBearerIds().length ).as(" usageTrans.getSubscription().getRatingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPromoCode() ).as(" usageTrans.getSubscription().getRatingAttributes().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getDuration() ).as(" usageTrans.getSubscription().getRatingAttributes().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getChargingMethod() ).as(" usageTrans.getSubscription().getRatingAttributes().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getBearer() ).as(" usageTrans.getSubscription().getRatingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isInteractive() ).as(" usageTrans.getSubscription().getRatingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isIncludeUnavailable() ).as(" usageTrans.getSubscription().getRatingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExpressFlag() ).as(" usageTrans.getSubscription().getRatingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isExpressFlag() ).as(" usageTrans.getSubscription().getRatingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isPreOrder() ).as(" usageTrans.getSubscription().getRatingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isCancellationUsage() ).as(" usageTrans.getSubscription().getRatingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getTierName() ).as(" usageTrans.getSubscription().getRatingAttributes().getTierName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPromoPrecode() ).as(" usageTrans.getSubscription().getRatingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getUniquePromoCode() ).as(" usageTrans.getSubscription().getRatingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPromoUniqueCode() ).as(" usageTrans.getSubscription().getRatingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getNextCycleDiscount() ).as(" usageTrans.getSubscription().getRatingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag() ).as(" usageTrans.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isIsForRenewal() ).as(" usageTrans.getSubscription().getRatingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getTaxRate() ).as(" usageTrans.getSubscription().getRatingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getTaxRateAsDouble() ).as(" usageTrans.getSubscription().getRatingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getAffiliateID() ).as(" usageTrans.getSubscription().getRatingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getTariff() ).as(" usageTrans.getSubscription().getRatingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getAggregatorId() ).as(" usageTrans.getSubscription().getRatingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isForcePurchaseFlow() ).as(" usageTrans.getSubscription().getRatingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getReceipientMsisdn() ).as(" usageTrans.getSubscription().getRatingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getProductCode() ).as(" usageTrans.getSubscription().getRatingAttributes().getProductCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getMerchantName() ).as(" usageTrans.getSubscription().getRatingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getInvoiceText() ).as(" usageTrans.getSubscription().getRatingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isReIssueEnabled() ).as(" usageTrans.getSubscription().getRatingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isReIssueFlagPresent() ).as(" usageTrans.getSubscription().getRatingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getShortPackageId() ).as(" usageTrans.getSubscription().getRatingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getTaxCode() ).as(" usageTrans.getSubscription().getRatingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getHistoryStartDate() ).as(" usageTrans.getSubscription().getRatingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getVendorId() ).as(" usageTrans.getSubscription().getRatingAttributes().getVendorId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isIsForNextPaymentAmount() ).as(" usageTrans.getSubscription().getRatingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getRenewalPreRate() ).as(" usageTrans.getSubscription().getRatingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag() ).as(" usageTrans.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getContentCategory() ).as(" usageTrans.getSubscription().getRatingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPartnerUrl() ).as(" usageTrans.getSubscription().getRatingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPartnerContactInfo() ).as(" usageTrans.getSubscription().getRatingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPartnerEmail() ).as(" usageTrans.getSubscription().getRatingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPartnerName() ).as(" usageTrans.getSubscription().getRatingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint() ).as(" usageTrans.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getSubRenewalPricepointId() ).as(" usageTrans.getSubscription().getRatingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getLinkPricepointId() ).as(" usageTrans.getSubscription().getRatingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial() ).as(" usageTrans.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints() ).as(" usageTrans.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" usageTrans.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExtIdentifier1() ).as(" usageTrans.getSubscription().getRatingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExtIdentifier2() ).as(" usageTrans.getSubscription().getRatingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExtIdentifier3() ).as(" usageTrans.getSubscription().getRatingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPartnerId() ).as(" usageTrans.getSubscription().getRatingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getAccessChannel() ).as(" usageTrans.getSubscription().getRatingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getPurchaseChannel() ).as(" usageTrans.getSubscription().getRatingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getDeviceID() ).as(" usageTrans.getSubscription().getRatingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getLocal() ).as(" usageTrans.getSubscription().getRatingAttributes().getLocal()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getMsisdn() ).as(" usageTrans.getSubscription().getRatingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getLanguageCode() ).as(" usageTrans.getSubscription().getRatingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getActiveSubscriptions() ).as(" usageTrans.getSubscription().getRatingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getCsrId() ).as(" usageTrans.getSubscription().getRatingAttributes().getCsrId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExternalField1() ).as(" usageTrans.getSubscription().getRatingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExternalField2() ).as(" usageTrans.getSubscription().getRatingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getExternalTransId() ).as(" usageTrans.getSubscription().getRatingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRatingAttributes().getLanguageLocale() ).as(" usageTrans.getSubscription().getRatingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPaymentTransactionId() ).as(" usageTrans.getSubscription().getPaymentTransactionId()" ).isEqualTo(new Long(9158)) ;
        softly.assertThat(usageTrans.getSubscription().getNonRefundDescription() ).as(" usageTrans.getSubscription().getNonRefundDescription()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getInteractiveUsageFlag() ).as(" usageTrans.getSubscription().getInteractiveUsageFlag()" ).isEqualTo(2) ;
        softly.assertThat(usageTrans.getSubscription().isFirstUsage() ).as(" usageTrans.getSubscription().isFirstUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isSubscriptionUsed() ).as(" usageTrans.getSubscription().isSubscriptionUsed()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getCurrentNoOfOccurences() ).as(" usageTrans.getSubscription().getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageTrans.getSubscription().getPenaltyCharge() ).as(" usageTrans.getSubscription().getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().isMinSubscriptionPeriodElapsed() ).as(" usageTrans.getSubscription().isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().isUnderGracePeriod() ).as(" usageTrans.getSubscription().isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getBatchRetryDate() ).as(" usageTrans.getSubscription().getBatchRetryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getOverdueExpiryDate() ).as(" usageTrans.getSubscription().getOverdueExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getLastExpiryDate() ).as(" usageTrans.getSubscription().getLastExpiryDate()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isWasRecurringTrial() ).as(" usageTrans.getSubscription().isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getParentPackageID() ).as(" usageTrans.getSubscription().getParentPackageID()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPreviousStatus() ).as(" usageTrans.getSubscription().getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().isParentAlsoPurchased() ).as(" usageTrans.getSubscription().isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isProvisionOnUsageSuccess() ).as(" usageTrans.getSubscription().isProvisionOnUsageSuccess()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getLastUsageTransactionIdForSameContent() ).as(" usageTrans.getSubscription().getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageTrans.getSubscription().getSpId() ).as(" usageTrans.getSubscription().getSpId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPartnerTaxRate() ).as(" usageTrans.getSubscription().getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(usageTrans.getSubscription().getCountryId() ).as(" usageTrans.getSubscription().getCountryId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isWasRecurringPromoCode() ).as(" usageTrans.getSubscription().isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getLastPaymentTransaction() ).as(" usageTrans.getSubscription().getLastPaymentTransaction()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getB2BPartner() ).as(" usageTrans.getSubscription().getB2BPartner()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getSubscription().getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().isRenewalPreRateGross() ).as(" usageTrans.getSubscription().isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getNextPricePointId() ).as(" usageTrans.getSubscription().getNextPricePointId()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getLastPaymentTransactionAmount() ).as(" usageTrans.getSubscription().getLastPaymentTransactionAmount()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getLastToLastPaymentTransactionAmount() ).as(" usageTrans.getSubscription().getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getSubscription().isPricePointChangeOnRenewal() ).as(" usageTrans.getSubscription().isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getOldSubscriptionId() ).as(" usageTrans.getSubscription().getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageTrans.getSubscription().getOldMsisdn() ).as(" usageTrans.getSubscription().getOldMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isProvisionable() ).as(" usageTrans.getSubscription().isProvisionable()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getFuturePricePointRenewals() ).as(" usageTrans.getSubscription().getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getSubscription().getNextCyclePercentValue() ).as(" usageTrans.getSubscription().getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSubscription().getLockId() ).as(" usageTrans.getSubscription().getLockId()" ).isEqualTo(new Long(1)) ;
        softly.assertThat(usageTrans.getSubscription().getPartnerId() ).as(" usageTrans.getSubscription().getPartnerId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getSubscriptionIdLong() ).as(" usageTrans.getSubscription().getSubscriptionIdLong()" ).isEqualTo(new Long(8470)) ;
//check size of array!
        softly.assertThat(usageTrans.getSubscription().getResourceBalances().length ).as(" usageTrans.getSubscription().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().getName() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().getName()" ).isEqualTo("SINGLE_1100035");
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().isToken() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().isUsageToken() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().isPayToken() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().getCode() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().getDescription() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("MULTIPLE_1100035");
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().getCountryId() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().isResource() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().isCurrency() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getResource().getResourceName() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getThreshold() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getPackageId() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getSubscriptionId() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getSubscriptionId()" ).isEqualTo("8470");
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getSubscription() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getBalance() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageTrans.getSubscription().getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageTrans.getSubscription().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(8470)) ;
        softly.assertThat(usageTrans.getSubscription().isRefundable() ).as(" usageTrans.getSubscription().isRefundable()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isSuperPackage() ).as(" usageTrans.getSubscription().isSuperPackage()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackageClass() ).as(" usageTrans.getSubscription().getPackageClass()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isArchived() ).as(" usageTrans.getSubscription().isArchived()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isActive() ).as(" usageTrans.getSubscription().isActive()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().isDefault() ).as(" usageTrans.getSubscription().isDefault()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().isRecurring() ).as(" usageTrans.getSubscription().isRecurring()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getExtensionPeriod() ).as(" usageTrans.getSubscription().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getMicroServiceSubList() ).as(" usageTrans.getSubscription().getMicroServiceSubList()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().isSuspended() ).as(" usageTrans.getSubscription().isSuspended()" ).isFalse() ;
        softly.assertThat(usageTrans.getDescription() ).as(" usageTrans.getDescription()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getStandardRate() ).as(" usageTrans.getStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSpId() ).as(" usageTrans.getSpId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getChargingResource().getName() ).as(" usageTrans.getChargingResource().getName()" ).isEqualTo("SINGLE_1100035");
        softly.assertThat(usageTrans.getChargingResource().isToken() ).as(" usageTrans.getChargingResource().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getChargingResource().isUsageToken() ).as(" usageTrans.getChargingResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getChargingResource().isPayToken() ).as(" usageTrans.getChargingResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getChargingResource().getResourceSymbol() ).as(" usageTrans.getChargingResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageTrans.getChargingResource().getCode() ).as(" usageTrans.getChargingResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageTrans.getChargingResource().getDescription() ).as(" usageTrans.getChargingResource().getDescription()" ).isNull();
        softly.assertThat(usageTrans.getChargingResource().getCountryId() ).as(" usageTrans.getChargingResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getChargingResource().isResource() ).as(" usageTrans.getChargingResource().isResource()" ).isTrue() ;
        softly.assertThat(usageTrans.getChargingResource().isCurrency() ).as(" usageTrans.getChargingResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageTrans.getChargingResource().getResourceName() ).as(" usageTrans.getChargingResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageTrans.getParentTransactionIdLong() ).as(" usageTrans.getParentTransactionIdLong()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageTrans.getReIssue() ).as(" usageTrans.getReIssue()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getLocalPurchaseDate() ).as(" usageTrans.getLocalPurchaseDate()" ).isNull();
        softly.assertThat(usageTrans.getLocalPurchaseDateCal() ).as(" usageTrans.getLocalPurchaseDateCal()" ).isNull();
        softly.assertThat(usageTrans.getPurchaseRate() ).as(" usageTrans.getPurchaseRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageTrans.getPurchaseNetRate() ).as(" usageTrans.getPurchaseNetRate()" ).isEqualTo(new Double(1.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getPurchaseCurrency().getName() ).as(" usageTrans.getPurchaseCurrency().getName()" ).isEqualTo("SINGLE_1100035");
        softly.assertThat(usageTrans.getPurchaseCurrency().isToken() ).as(" usageTrans.getPurchaseCurrency().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getPurchaseCurrency().isUsageToken() ).as(" usageTrans.getPurchaseCurrency().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getPurchaseCurrency().isPayToken() ).as(" usageTrans.getPurchaseCurrency().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getPurchaseCurrency().getResourceSymbol() ).as(" usageTrans.getPurchaseCurrency().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageTrans.getPurchaseCurrency().getCode() ).as(" usageTrans.getPurchaseCurrency().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageTrans.getPurchaseCurrency().getDescription() ).as(" usageTrans.getPurchaseCurrency().getDescription()" ).isNull();
        softly.assertThat(usageTrans.getPurchaseCurrency().getCountryId() ).as(" usageTrans.getPurchaseCurrency().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getPurchaseCurrency().isResource() ).as(" usageTrans.getPurchaseCurrency().isResource()" ).isTrue() ;
        softly.assertThat(usageTrans.getPurchaseCurrency().isCurrency() ).as(" usageTrans.getPurchaseCurrency().isCurrency()" ).isFalse() ;
        softly.assertThat(usageTrans.getPurchaseCurrency().getResourceName() ).as(" usageTrans.getPurchaseCurrency().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageTrans.getNextCycleDiscountPercent() ).as(" usageTrans.getNextCycleDiscountPercent()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getRefundEnlargementDate() ).as(" usageTrans.getRefundEnlargementDate()" ).isNull();
        softly.assertThat(usageTrans.getRefundPaymentTransactionId() ).as(" usageTrans.getRefundPaymentTransactionId()" ).isNull();
        softly.assertThat(usageTrans.getRefundPaymentTransactionIdLong() ).as(" usageTrans.getRefundPaymentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageTrans.getRefundable() ).as(" usageTrans.getRefundable()" ).isTrue() ;
        softly.assertThat(usageTrans.getModificationInfo() ).as(" usageTrans.getModificationInfo()" ).isNull();
        softly.assertThat(usageTrans.getClientId() ).as(" usageTrans.getClientId()" ).isEqualTo("test");
        softly.assertThat(usageTrans.getHostId() ).as(" usageTrans.getHostId()" ).isEqualTo("Ravis-MacBook-Pro.local");
        softly.assertThat(usageTrans.getNextCycleDiscountValue() ).as(" usageTrans.getNextCycleDiscountValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getContentDescription() ).as(" usageTrans.getContentDescription()" ).isNull();
        softly.assertThat(usageTrans.getAssetId() ).as(" usageTrans.getAssetId()" ).isNull();
        softly.assertThat(usageTrans.getBalanceImpact() ).as(" usageTrans.getBalanceImpact()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubRecords() ).as(" usageTrans.getSubRecords()" ).isNull();
        softly.assertThat(usageTrans.getDeviceId() ).as(" usageTrans.getDeviceId()" ).isNull();
        softly.assertThat(usageTrans.getSuitabilityDecision() ).as(" usageTrans.getSuitabilityDecision()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.isContainsReIssueService() ).as(" usageTrans.isContainsReIssueService()" ).isFalse() ;
        softly.assertThat(usageTrans.getIsPrepay() ).as(" usageTrans.getIsPrepay()" ).isNull();
        softly.assertThat(usageTrans.getModifyTransactionId() ).as(" usageTrans.getModifyTransactionId()" ).isNull();
        softly.assertThat(usageTrans.getChildSpId() ).as(" usageTrans.getChildSpId()" ).isNull();
        softly.assertThat(usageTrans.getSpType() ).as(" usageTrans.getSpType()" ).isNull();
        softly.assertThat(usageTrans.isRefundTransaction() ).as(" usageTrans.isRefundTransaction()" ).isFalse() ;
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(usageTrans.getTransactionIdLong() ).as(" usageTrans.getTransactionIdLong()" ).isNotNull() ;
        softly.assertThat(usageTrans.getParentTransactionId() ).as(" usageTrans.getParentTransactionId()" ).isNull();
        softly.assertThat(usageTrans.getExternalField1() ).as(" usageTrans.getExternalField1()" ).isNull();
        softly.assertThat(usageTrans.getExternalField2() ).as(" usageTrans.getExternalField2()" ).isNull();
        softly.assertThat(usageTrans.getExternalTransId() ).as(" usageTrans.getExternalTransId()" ).isNull();
        softly.assertThat(usageTrans.getPartnerId() ).as(" usageTrans.getPartnerId()" ).isNull();
        softly.assertThat(usageTrans.isZeroCostIgnore() ).as(" usageTrans.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscriptionIdLong() ).as(" usageTrans.getSubscriptionIdLong()" ).isNotNull() ;
        softly.assertThat(usageTrans.getResourceBalances() ).as(" usageTrans.getResourceBalances()" ).isNull();
        softly.assertThat(usageTrans.getAuthCode() ).as(" usageTrans.getAuthCode()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getNonRefundableDescription() ).as(" usageTrans.getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.isRefundable() ).as(" usageTrans.isRefundable()" ).isTrue() ;
        softly.assertThat(usageTrans.getAccessDevice() ).as(" usageTrans.getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.isSuccess() ).as(" usageTrans.isSuccess()" ).isTrue() ;
        softly.assertThat(usageTrans.getTransactionId() ).as(" usageTrans.getTransactionId()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getPaymentErrorId() ).as(" usageTrans.getPaymentErrorId()" ).isNull();
        softly.assertThat(usageTrans.getPaymentErrorDescription() ).as(" usageTrans.getPaymentErrorDescription()" ).isNull();
        softly.assertThat(usageTrans.getPaymentStatus() ).as(" usageTrans.getPaymentStatus()" ).isEqualTo(101) ;
        softly.assertThat(usageTrans.getTaxAmount() ).as(" usageTrans.getTaxAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getPaymentInfo() ).as(" usageTrans.getPaymentInfo()" ).isNull();
        softly.assertThat(usageTrans.getReason() ).as(" usageTrans.getReason()" ).isNull();

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }
    }

}
