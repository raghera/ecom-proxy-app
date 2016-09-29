package com.vodafone.er.ecom.proxy.usagecomplete;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class UsageComplete4IT_pt1 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageComplete() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        final String packageId = "2PP_P002__X__package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false";

        final PurchaseAuthorization auth =
                EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());

        final UsageAuthorization result = EcomApiFactory.getChargingApi(Locale.UK)
                .usageComplete("test-client-id", auth.getEventReservationId(), 1);

        softly.assertThat(result.getEventUnits() ).as(" result.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getIsPreordered() ).as(" result.getIsPreordered()" ).isEqualTo(0) ;
        softly.assertThat(result.getStartDate() ).as(" result.getStartDate()" ).isNull();
        softly.assertThat(result.getIsValidatedAccount() ).as(" result.getIsValidatedAccount()" ).isNull();
        softly.assertThat(result.isFirstUsage() ).as(" result.isFirstUsage()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
        softly.assertThat(result.getServicePricePoint().getResource() ).as(" result.getServicePricePoint().getResource()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getKey() ).as(" result.getServicePricePoint().getKey()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getId() ).as(" result.getServicePricePoint().getId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getGracePeriod() ).as(" result.getServicePricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getNetRate() ).as(" result.getServicePricePoint().getNetRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getServicePricePoint().isAlwaysValidateMsisdn() ).as(" result.getServicePricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getCustomResourceBalances() ).as(" result.getServicePricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getRetryFrequency() ).as(" result.getServicePricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getSuspensionPeriod() ).as(" result.getServicePricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" result.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(result.getServicePricePoint().getTranslatedPricingText() ).as(" result.getServicePricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getFairUsageLimit() ).as(" result.getServicePricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().getFairUsagePeriod() ).as(" result.getServicePricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().getFairUsagePeriodUnit() ).as(" result.getServicePricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(result.getServicePricePoint().getExtensionPeriod() ).as(" result.getServicePricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(result.getServicePricePoint().isIncludeServiceForPackageFUP() ).as(" result.getServicePricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isFairUsagePolicyEnabled() ).as(" result.getServicePricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isVolumeType() ).as(" result.getServicePricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isOriginal() ).as(" result.getServicePricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(result.getServicePricePoint().getPricePointTiers().length ).as(" result.getServicePricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getKey() ).as(" result.getServicePricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("result.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 0);
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" result.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" result.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getPricingModel() ).as(" result.getServicePricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getTier() ).as(" result.getServicePricePoint().getPricePointTiers()[0].getTier()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" result.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" result.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isPreOrder() ).as(" result.getServicePricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getTaxRate() ).as(" result.getServicePricePoint().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getServicePricePoint().getTaxCode() ).as(" result.getServicePricePoint().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getLinkedByTrialPricepoint() ).as(" result.getServicePricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isDiscount() ).as(" result.getServicePricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getDiscountPromoText() ).as(" result.getServicePricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(result.getServicePricePoint().getPackageId() ).as(" result.getServicePricePoint().getPackageId()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getContentId() ).as(" result.getServicePricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getPricingText1() ).as(" result.getServicePricePoint().getPricingText1()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricingText2() ).as(" result.getServicePricePoint().getPricingText2()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getUsageTime() ).as(" result.getServicePricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(result.getServicePricePoint().getAccessDuration() ).as(" result.getServicePricePoint().getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getServicePricePoint().getPricingModelTier() ).as(" result.getServicePricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isArchived() ).as(" result.getServicePricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isBasePricePoint() ).as(" result.getServicePricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getAccessDevice() ).as(" result.getServicePricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(result.getServicePricePoint().getAlternativeRate() ).as(" result.getServicePricePoint().getAlternativeRate()" ).isEqualTo(new Double(-9999.0)) ;
//check size of array!
        softly.assertThat(result.getServicePricePoint().getBalanceImpacts().length ).as(" result.getServicePricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(result.getServicePricePoint().isActive() ).as(" result.getServicePricePoint().isActive()" ).isTrue() ;
        softly.assertThat(result.getServicePricePoint().getStartDate() ).as(" result.getServicePricePoint().getStartDate()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getRate() ).as(" result.getServicePricePoint().getRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getServicePricePoint().getExpiryDate() ).as(" result.getServicePricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isTrial() ).as(" result.getServicePricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getGlid() ).as(" result.getServicePricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(result.getServicePricePoint().getPricepointIdLink() ).as(" result.getServicePricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isPreview() ).as(" result.getServicePricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getInteractiveFlag() ).as(" result.getServicePricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(result.getServicePricePoint().isForcedPurchase() ).as(" result.getServicePricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isSubscriptionDuplicate() ).as(" result.getServicePricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(result.getServicePricePoint().getFixedExpiryDate() ).as(" result.getServicePricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isReserveOnly() ).as(" result.getServicePricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getMinSubPeriod() ).as(" result.getServicePricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().getPenaltyCharges() ).as(" result.getServicePricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getServicePricePoint().getCancellation() ).as(" result.getServicePricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getMonthEndSubscription() ).as(" result.getServicePricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(result.getServicePricePoint().isHistoric() ).as(" result.getServicePricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getFixedRecurrence() ).as(" result.getServicePricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(result.getServicePricePoint().isFixedRecurringPricePoint() ).as(" result.getServicePricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isReceipting() ).as(" result.getServicePricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getReceiptingAttribute() ).as(" result.getServicePricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(result.getServicePricePoint().getOrder() ).as(" result.getServicePricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(result.getServicePricePoint().getPaymentHandler() ).as(" result.getServicePricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(result.getServicePricePoint().getNonMatchAllUserGroups().length ).as(" result.getServicePricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(result.getServicePricePoint().isPromo() ).as(" result.getServicePricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isSubmitToPaymentHandler() ).as(" result.getServicePricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isSuppressToPaymentHandler() ).as(" result.getServicePricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getPricingTextTemplateName1() ).as(" result.getServicePricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricingTextTemplateName2() ).as(" result.getServicePricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getTranslatedPricingText1() ).as(" result.getServicePricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getTranslatedPricingText2() ).as(" result.getServicePricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getRecurrenceDay() ).as(" result.getServicePricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().getPricingTextList1() ).as(" result.getServicePricePoint().getPricingTextList1()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricingTextList2() ).as(" result.getServicePricePoint().getPricingTextList2()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isAlignWithExternal() ).as(" result.getServicePricePoint().isAlignWithExternal()" ).isFalse() ;
//check size of list!
        softly.assertThat(result.getServicePricePoint().getAllBalanceImpacts().size()).as("result.getServicePricePoint().getAllBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getServicePricePoint().getAllBalanceImpacts().size() >= 0);
        softly.assertThat(result.getServicePricePoint().getPackageIdentifier() ).as(" result.getServicePricePoint().getPackageIdentifier()" ).isEqualTo("package:*_*_999_999_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(result.getServicePricePoint().getServiceIdentifier() ).as(" result.getServicePricePoint().getServiceIdentifier()" ).isEqualTo("content:*_*_*_999_10010_*_999_999");
        softly.assertThat(result.getServicePricePoint().getResourceField() ).as(" result.getServicePricePoint().getResourceField()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getStandardRateWithoutTax() ).as(" result.getServicePricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getServicePricePoint().getProtectedFk() ).as(" result.getServicePricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getmPricingText1() ).as(" result.getServicePricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(result.getServicePricePoint().getmPricingText2() ).as(" result.getServicePricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(result.getServicePricePoint().isNonRecurring() ).as(" result.getServicePricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isZeroCostIgnore() ).as(" result.getServicePricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getDescription() ).as(" result.getServicePricePoint().getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(result.getServicePricePoint().isTariff() ).as(" result.getServicePricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isHideForPurchaseOptions() ).as(" result.getServicePricePoint().isHideForPurchaseOptions()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getTax() ).as(" result.getServicePricePoint().getTax()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getBalances() ).as(" result.getServicePricePoint().getBalances()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isRecurring() ).as(" result.getServicePricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getRenewalsUntilLinkedPricepoint() ).as(" result.getServicePricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getKey() ).as(" result.getServicePricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()).as("result.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getServicePricePoint().getPricePointTier().getBalanceImpacts().size() >= 0);
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getPromotionalPrice() ).as(" result.getServicePricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getPromotionalPricingText() ).as(" result.getServicePricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getPricingModel() ).as(" result.getServicePricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getTier() ).as(" result.getServicePricePoint().getPricePointTier().getTier()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPricePointTier().isDefaultPPT() ).as(" result.getServicePricePoint().getPricePointTier().isDefaultPPT()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" result.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isEvent() ).as(" result.getServicePricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getStandardRate() ).as(" result.getServicePricePoint().getStandardRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getServicePricePoint().getResourceBalances() ).as(" result.getServicePricePoint().getResourceBalances()" ).isNull();
//check size of list!
        softly.assertThat(result.getServicePricePoint().getBalanceImpactList().size()).as("result.getServicePricePoint().getBalanceImpactList().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getServicePricePoint().getBalanceImpactList().size() >= 0);
        softly.assertThat(result.getServicePricePoint().getChannel() ).as(" result.getServicePricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(result.getServicePricePoint().getMultiUsageMode() ).as(" result.getServicePricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(result.getServicePricePoint().getNetworkCodeMatchMethod() ).as(" result.getServicePricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().isPreRatePriceGross() ).as(" result.getServicePricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getPreRate() ).as(" result.getServicePricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getServicePricePoint().getPaymentInformation() ).as(" result.getServicePricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getContentName() ).as(" result.getServicePricePoint().getContentName()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getAssetID() ).as(" result.getServicePricePoint().getAssetID()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPremiumLevel() ).as(" result.getServicePricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(result.getServicePricePoint().getReserveOnlyFlag() ).as(" result.getServicePricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(result.getServicePricePoint().getSupplierId() ).as(" result.getServicePricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getDeviceType() ).as(" result.getServicePricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(result.getServicePricePoint().getUserGroups().length ).as(" result.getServicePricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(result.getServicePricePoint().getUserGroup() ).as(" result.getServicePricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getPaymentType() ).as(" result.getServicePricePoint().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(result.getServicePricePoint().getEventUnits() ).as(" result.getServicePricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(result.getServicePricePoint().getPromoCodes().length ).as(" result.getServicePricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(result.getServicePricePoint().getBearerIds().length ).as(" result.getServicePricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(result.getServicePricePoint().getPromoCode() ).as(" result.getServicePricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getDuration() ).as(" result.getServicePricePoint().getDuration()" ).isEqualTo(999) ;
        softly.assertThat(result.getServicePricePoint().getChargingMethod() ).as(" result.getServicePricePoint().getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(result.getServicePricePoint().getBearer() ).as(" result.getServicePricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().isInteractive() ).as(" result.getServicePricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(result.getServicePricePoint().isIncludeUnavailable() ).as(" result.getServicePricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getExpressFlag() ).as(" result.getServicePricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isExpressFlag() ).as(" result.getServicePricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isCancellationUsage() ).as(" result.getServicePricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getTierName() ).as(" result.getServicePricePoint().getTierName()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPromoPrecode() ).as(" result.getServicePricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getUniquePromoCode() ).as(" result.getServicePricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPromoUniqueCode() ).as(" result.getServicePricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getNextCycleDiscount() ).as(" result.getServicePricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getServicePricePoint().getHasHistoricPricePointFlag() ).as(" result.getServicePricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isIsForRenewal() ).as(" result.getServicePricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getTaxRateAsDouble() ).as(" result.getServicePricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getAffiliateID() ).as(" result.getServicePricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPartnerId() ).as(" result.getServicePricePoint().getPartnerId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getTariff() ).as(" result.getServicePricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(result.getServicePricePoint().getAggregatorId() ).as(" result.getServicePricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isForcePurchaseFlow() ).as(" result.getServicePricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getReceipientMsisdn() ).as(" result.getServicePricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getProductCode() ).as(" result.getServicePricePoint().getProductCode()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getMerchantName() ).as(" result.getServicePricePoint().getMerchantName()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getInvoiceText() ).as(" result.getServicePricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isReIssueEnabled() ).as(" result.getServicePricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isReIssueFlagPresent() ).as(" result.getServicePricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getShortPackageId() ).as(" result.getServicePricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getHistoryStartDate() ).as(" result.getServicePricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getVendorId() ).as(" result.getServicePricePoint().getVendorId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().isIsForNextPaymentAmount() ).as(" result.getServicePricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getRenewalPreRate() ).as(" result.getServicePricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getServicePricePoint().isOverrideDisallowPreRateFlag() ).as(" result.getServicePricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getContentCategory() ).as(" result.getServicePricePoint().getContentCategory()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPartnerUrl() ).as(" result.getServicePricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPartnerContactInfo() ).as(" result.getServicePricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPartnerEmail() ).as(" result.getServicePricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPartnerName() ).as(" result.getServicePricePoint().getPartnerName()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" result.getServicePricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getServicePricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(result.getServicePricePoint().getSubRenewalPricepointId() ).as(" result.getServicePricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getLinkPricepointId() ).as(" result.getServicePricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getSubPurchaseTransactionTrial() ).as(" result.getServicePricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getDiscardHiddenInactivePricepoints() ).as(" result.getServicePricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" result.getServicePricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(result.getServicePricePoint().getExtIdentifier1() ).as(" result.getServicePricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getExtIdentifier2() ).as(" result.getServicePricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getExtIdentifier3() ).as(" result.getServicePricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getAccessChannel() ).as(" result.getServicePricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getPurchaseChannel() ).as(" result.getServicePricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getDeviceID() ).as(" result.getServicePricePoint().getDeviceID()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getLocal() ).as(" result.getServicePricePoint().getLocal()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getMsisdn() ).as(" result.getServicePricePoint().getMsisdn()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getLanguageLocale() ).as(" result.getServicePricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getLanguageCode() ).as(" result.getServicePricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getExternalField1() ).as(" result.getServicePricePoint().getExternalField1()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getExternalField2() ).as(" result.getServicePricePoint().getExternalField2()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getExternalTransId() ).as(" result.getServicePricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getActiveSubscriptions() ).as(" result.getServicePricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(result.getServicePricePoint().getCsrId() ).as(" result.getServicePricePoint().getCsrId()" ).isNull();
        softly.assertThat(result.getSubscriptionStatus() ).as(" result.getSubscriptionStatus()" ).isEqualTo(0) ;
        softly.assertThat(result.isSuccessfulExpressPurchase() ).as(" result.isSuccessfulExpressPurchase()" ).isFalse() ;
        softly.assertThat(result.getSubResourceBalances() ).as(" result.getSubResourceBalances()" ).isNull();
        softly.assertThat(result.isBasedOnMultiplePackages() ).as(" result.isBasedOnMultiplePackages()" ).isFalse() ;
        softly.assertThat(result.getParentTransactionId() ).as(" result.getParentTransactionId()" ).isNull();
        softly.assertThat(result.getParentTransactionIdLong() ).as(" result.getParentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(result.getReIssue() ).as(" result.getReIssue()" ).isEqualTo(0) ;
        softly.assertThat(result.isAuthorized() ).as(" result.isAuthorized()" ).isTrue() ;
        softly.assertThat(result.getPackage() ).as(" result.getPackage()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(result.getResource().getName() ).as(" result.getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(result.getResource().isCurrency() ).as(" result.getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(result.getResource().getCode() ).as(" result.getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(result.getResource().getResourceName() ).as(" result.getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(result.getResource().getDescription() ).as(" result.getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(result.getResource().getCountryId() ).as(" result.getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(result.getResource().isToken() ).as(" result.getResource().isToken()" ).isFalse() ;
        softly.assertThat(result.getResource().isUsageToken() ).as(" result.getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(result.getResource().isPayToken() ).as(" result.getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(result.getResource().getResourceSymbol() ).as(" result.getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(result.getResource().isResource() ).as(" result.getResource().isResource()" ).isFalse() ;
        softly.assertThat(result.getActiveSubscriptions() ).as(" result.getActiveSubscriptions()" ).isNull();
        softly.assertThat(result.getValidMicroServiceSub() ).as(" result.getValidMicroServiceSub()" ).isNull();
        softly.assertThat(result.getContentName() ).as(" result.getContentName()" ).isNull();
        softly.assertThat(result.isInteractive() ).as(" result.isInteractive()" ).isFalse() ;
        softly.assertThat(result.getPartnerId() ).as(" result.getPartnerId()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
        softly.assertThat(result.getPricePoint().getResource() ).as(" result.getPricePoint().getResource()" ).isNull();
        softly.assertThat(result.getPricePoint().getKey() ).as(" result.getPricePoint().getKey()" ).isNull();
        softly.assertThat(result.getPricePoint().getId() ).as(" result.getPricePoint().getId()" ).isNull();
        softly.assertThat(result.getPricePoint().getGracePeriod() ).as(" result.getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(result.getPricePoint().getNetRate() ).as(" result.getPricePoint().getNetRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getPricePoint().isAlwaysValidateMsisdn() ).as(" result.getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getCustomResourceBalances() ).as(" result.getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(result.getPricePoint().getRetryFrequency() ).as(" result.getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(result.getPricePoint().getSuspensionPeriod() ).as(" result.getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(result.getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" result.getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().getTranslatedPricingText() ).as(" result.getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(result.getPricePoint().getFairUsageLimit() ).as(" result.getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().getFairUsagePeriod() ).as(" result.getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().getFairUsagePeriodUnit() ).as(" result.getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(result.getPricePoint().getExtensionPeriod() ).as(" result.getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(result.getPricePoint().isIncludeServiceForPackageFUP() ).as(" result.getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isFairUsagePolicyEnabled() ).as(" result.getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isVolumeType() ).as(" result.getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isOriginal() ).as(" result.getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(result.getPricePoint().getPricePointTiers().length ).as(" result.getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getKey() ).as(" result.getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 0);
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" result.getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" result.getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getTier() ).as(" result.getPricePoint().getPricePointTiers()[0].getTier()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" result.getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(result.getPricePoint().isPreOrder() ).as(" result.getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getTaxRate() ).as(" result.getPricePoint().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getPricePoint().getTaxCode() ).as(" result.getPricePoint().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getLinkedByTrialPricepoint() ).as(" result.getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isDiscount() ).as(" result.getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getDiscountPromoText() ).as(" result.getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getPackageId() ).as(" result.getPricePoint().getPackageId()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getContentId() ).as(" result.getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getPricingText1() ).as(" result.getPricePoint().getPricingText1()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricingText2() ).as(" result.getPricePoint().getPricingText2()" ).isNull();
        softly.assertThat(result.getPricePoint().getUsageTime() ).as(" result.getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(result.getPricePoint().getAccessDuration() ).as(" result.getPricePoint().getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getPricePoint().getPricingModelTier() ).as(" result.getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(result.getPricePoint().isArchived() ).as(" result.getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isBasePricePoint() ).as(" result.getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getAccessDevice() ).as(" result.getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getAlternativeRate() ).as(" result.getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(-9999.0)) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getBalanceImpacts().length ).as(" result.getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(result.getPricePoint().isActive() ).as(" result.getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().getStartDate() ).as(" result.getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(result.getPricePoint().getRate() ).as(" result.getPricePoint().getRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getPricePoint().getExpiryDate() ).as(" result.getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(result.getPricePoint().isTrial() ).as(" result.getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getGlid() ).as(" result.getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(result.getPricePoint().getPricepointIdLink() ).as(" result.getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(result.getPricePoint().isPreview() ).as(" result.getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getInteractiveFlag() ).as(" result.getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(result.getPricePoint().isForcedPurchase() ).as(" result.getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isSubscriptionDuplicate() ).as(" result.getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().getFixedExpiryDate() ).as(" result.getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(result.getPricePoint().isReserveOnly() ).as(" result.getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getMinSubPeriod() ).as(" result.getPricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().getPenaltyCharges() ).as(" result.getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getPricePoint().getCancellation() ).as(" result.getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getMonthEndSubscription() ).as(" result.getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(result.getPricePoint().isHistoric() ).as(" result.getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getFixedRecurrence() ).as(" result.getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(result.getPricePoint().isFixedRecurringPricePoint() ).as(" result.getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isReceipting() ).as(" result.getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getReceiptingAttribute() ).as(" result.getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(result.getPricePoint().getOrder() ).as(" result.getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(result.getPricePoint().getPaymentHandler() ).as(" result.getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(result.getPricePoint().getNonMatchAllUserGroups().length ).as(" result.getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(result.getPricePoint().isPromo() ).as(" result.getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isSubmitToPaymentHandler() ).as(" result.getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isSuppressToPaymentHandler() ).as(" result.getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getPricingTextTemplateName1() ).as(" result.getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricingTextTemplateName2() ).as(" result.getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(result.getPricePoint().getTranslatedPricingText1() ).as(" result.getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(result.getPricePoint().getTranslatedPricingText2() ).as(" result.getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(result.getPricePoint().getRecurrenceDay() ).as(" result.getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().getPricingTextList1() ).as(" result.getPricePoint().getPricingTextList1()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricingTextList2() ).as(" result.getPricePoint().getPricingTextList2()" ).isNull();
        softly.assertThat(result.getPricePoint().isAlignWithExternal() ).as(" result.getPricePoint().isAlignWithExternal()" ).isFalse() ;
//check size of list!
        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().size()).as("result.getPricePoint().getAllBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getPricePoint().getAllBalanceImpacts().size() >= 0);
        softly.assertThat(result.getPricePoint().getPackageIdentifier() ).as(" result.getPricePoint().getPackageIdentifier()" ).isEqualTo("package:*_*_999_999_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(result.getPricePoint().getServiceIdentifier() ).as(" result.getPricePoint().getServiceIdentifier()" ).isEqualTo("content:*_*_*_999_10010_*_999_999");
        softly.assertThat(result.getPricePoint().getResourceField() ).as(" result.getPricePoint().getResourceField()" ).isNull();
        softly.assertThat(result.getPricePoint().getStandardRateWithoutTax() ).as(" result.getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getPricePoint().getProtectedFk() ).as(" result.getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(result.getPricePoint().getmPricingText1() ).as(" result.getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getmPricingText2() ).as(" result.getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().isNonRecurring() ).as(" result.getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isZeroCostIgnore() ).as(" result.getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getDescription() ).as(" result.getPricePoint().getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(result.getPricePoint().isTariff() ).as(" result.getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isHideForPurchaseOptions() ).as(" result.getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getTax() ).as(" result.getPricePoint().getTax()" ).isNull();
        softly.assertThat(result.getPricePoint().getBalances() ).as(" result.getPricePoint().getBalances()" ).isNull();
        softly.assertThat(result.getPricePoint().isRecurring() ).as(" result.getPricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" result.getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(result.getPricePoint().getPricePointTier().getKey() ).as(" result.getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("result.getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 0);
        softly.assertThat(result.getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" result.getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" result.getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTier().getPricingModel() ).as(" result.getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTier().getTier() ).as(" result.getPricePoint().getPricePointTier().getTier()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricePointTier().isDefaultPPT() ).as(" result.getPricePoint().getPricePointTier().isDefaultPPT()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" result.getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(result.getPricePoint().isEvent() ).as(" result.getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getStandardRate() ).as(" result.getPricePoint().getStandardRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(result.getPricePoint().getResourceBalances() ).as(" result.getPricePoint().getResourceBalances()" ).isNull();
//check size of list!
        softly.assertThat(result.getPricePoint().getBalanceImpactList().size()).as("result.getPricePoint().getBalanceImpactList().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getPricePoint().getBalanceImpactList().size() >= 0);
        softly.assertThat(result.getPricePoint().getChannel() ).as(" result.getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getMultiUsageMode() ).as(" result.getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(result.getPricePoint().getNetworkCodeMatchMethod() ).as(" result.getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().isPreRatePriceGross() ).as(" result.getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getPreRate() ).as(" result.getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getPricePoint().getPaymentInformation() ).as(" result.getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(result.getPricePoint().getContentName() ).as(" result.getPricePoint().getContentName()" ).isNull();
        softly.assertThat(result.getPricePoint().getAssetID() ).as(" result.getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(result.getPricePoint().getPremiumLevel() ).as(" result.getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getReserveOnlyFlag() ).as(" result.getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(result.getPricePoint().getSupplierId() ).as(" result.getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getDeviceType() ).as(" result.getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getUserGroups().length ).as(" result.getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(result.getPricePoint().getUserGroup() ).as(" result.getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getPaymentType() ).as(" result.getPricePoint().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(result.getPricePoint().getEventUnits() ).as(" result.getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getPromoCodes().length ).as(" result.getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getBearerIds().length ).as(" result.getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(result.getPricePoint().getPromoCode() ).as(" result.getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getDuration() ).as(" result.getPricePoint().getDuration()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getChargingMethod() ).as(" result.getPricePoint().getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getBearer() ).as(" result.getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().isInteractive() ).as(" result.getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().isIncludeUnavailable() ).as(" result.getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getExpressFlag() ).as(" result.getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isExpressFlag() ).as(" result.getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isCancellationUsage() ).as(" result.getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getTierName() ).as(" result.getPricePoint().getTierName()" ).isNull();
        softly.assertThat(result.getPricePoint().getPromoPrecode() ).as(" result.getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(result.getPricePoint().getUniquePromoCode() ).as(" result.getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(result.getPricePoint().getPromoUniqueCode() ).as(" result.getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(result.getPricePoint().getNextCycleDiscount() ).as(" result.getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getPricePoint().getHasHistoricPricePointFlag() ).as(" result.getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isIsForRenewal() ).as(" result.getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getTaxRateAsDouble() ).as(" result.getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(result.getPricePoint().getAffiliateID() ).as(" result.getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(result.getPricePoint().getPartnerId() ).as(" result.getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(result.getPricePoint().getTariff() ).as(" result.getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getAggregatorId() ).as(" result.getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(result.getPricePoint().isForcePurchaseFlow() ).as(" result.getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getReceipientMsisdn() ).as(" result.getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(result.getPricePoint().getProductCode() ).as(" result.getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(result.getPricePoint().getMerchantName() ).as(" result.getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(result.getPricePoint().getInvoiceText() ).as(" result.getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(result.getPricePoint().isReIssueEnabled() ).as(" result.getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isReIssueFlagPresent() ).as(" result.getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getShortPackageId() ).as(" result.getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(result.getPricePoint().getHistoryStartDate() ).as(" result.getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(result.getPricePoint().getVendorId() ).as(" result.getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(result.getPricePoint().isIsForNextPaymentAmount() ).as(" result.getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getRenewalPreRate() ).as(" result.getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getPricePoint().isOverrideDisallowPreRateFlag() ).as(" result.getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getContentCategory() ).as(" result.getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(result.getPricePoint().getPartnerUrl() ).as(" result.getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(result.getPricePoint().getPartnerContactInfo() ).as(" result.getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(result.getPricePoint().getPartnerEmail() ).as(" result.getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(result.getPricePoint().getPartnerName() ).as(" result.getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(result.getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" result.getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(result.getPricePoint().getSubRenewalPricepointId() ).as(" result.getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(result.getPricePoint().getLinkPricepointId() ).as(" result.getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(result.getPricePoint().getSubPurchaseTransactionTrial() ).as(" result.getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" result.getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" result.getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getExtIdentifier1() ).as(" result.getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(result.getPricePoint().getExtIdentifier2() ).as(" result.getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(result.getPricePoint().getExtIdentifier3() ).as(" result.getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(result.getPricePoint().getAccessChannel() ).as(" result.getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(result.getPricePoint().getPurchaseChannel() ).as(" result.getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(result.getPricePoint().getDeviceID() ).as(" result.getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(result.getPricePoint().getLocal() ).as(" result.getPricePoint().getLocal()" ).isNull();
        softly.assertThat(result.getPricePoint().getMsisdn() ).as(" result.getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(result.getPricePoint().getLanguageLocale() ).as(" result.getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(result.getPricePoint().getLanguageCode() ).as(" result.getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(result.getPricePoint().getExternalField1() ).as(" result.getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(result.getPricePoint().getExternalField2() ).as(" result.getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(result.getPricePoint().getExternalTransId() ).as(" result.getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(result.getPricePoint().getActiveSubscriptions() ).as(" result.getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(result.getPricePoint().getCsrId() ).as(" result.getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(result.getErrorId() ).as(" result.getErrorId()" ).isNull();
        softly.assertThat(result.getErrorDescription() ).as(" result.getErrorDescription()" ).isNull();
// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//check size of array!
//        softly.assertThat(result.getSubscription().getPurchasedServices().length ).as(" result.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getId() ).as(" result.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(684)) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" result.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" result.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" result.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" result.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" result.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getStatus() ).as(" result.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" result.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("2PP_S001");
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" result.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" result.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" result.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" result.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPurchasedServices().length ).as(" result.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getId() ).as(" result.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(684)) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" result.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" result.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" result.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" result.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" result.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getStatus() ).as(" result.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" result.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("2PP_S001");
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" result.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" result.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" result.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(result.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" result.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.CatalogPackage

        //TODO THERE IS NO PACKAGE RETURNED AT ALL
        softly.assertThat(result.getSubscription().getPackage()).as("result.getSubscription().getPackage()" ).isNotNull();

//        softly.assertThat(result.getSubscription().getPackage().getName() ).as(" result.getSubscription().getPackage().getName()" ).isEqualTo("2Ph P 1Ph U");
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getResource().getName() ).as(" result.getSubscription().getPackage().getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getResource().isCurrency() ).as(" result.getSubscription().getPackage().getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getResource().getCode() ).as(" result.getSubscription().getPackage().getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getResource().getResourceName() ).as(" result.getSubscription().getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getResource().getDescription() ).as(" result.getSubscription().getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getResource().getCountryId() ).as(" result.getSubscription().getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getResource().isToken() ).as(" result.getSubscription().getPackage().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getResource().isPayToken() ).as(" result.getSubscription().getPackage().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getResource().isResource() ).as(" result.getSubscription().getPackage().getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getKey() ).as(" result.getSubscription().getPackage().getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPriority() ).as(" result.getSubscription().getPackage().getPriority()" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getId() ).as(" result.getSubscription().getPackage().getId()" ).isEqualTo("2PP_P002__X__package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false");
////check size of list!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().size()).as("result.getSubscription().getPackage().getPricePoints().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPackage().getPricePoints().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getId()" ).isEqualTo("package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getGracePeriod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getGracePeriod()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getNetRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getCustomResourceBalances() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getCustomResourceBalances()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getRetryFrequency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getRetryFrequency()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getSuspensionPeriod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTranslatedPricingText() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTranslatedPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getFairUsageLimit() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getFairUsagePeriod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExtensionPeriod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isVolumeType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isVolumeType()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isOriginal() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isOriginal()" ).isFalse() ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getKey()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()).as("result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPricingModel() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPricingModel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getTier() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isPreOrder() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isPreOrder()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTaxRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTaxCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isDiscount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isDiscount()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getDiscountPromoText() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPackageId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPackageId()" ).isEqualTo("2PP_P002");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getContentId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getContentId()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricingText1() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricingText2() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getUsageTime() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAccessDuration() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricingModelTier() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricingModelTier()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isArchived() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isArchived()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isBasePricePoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAccessDevice() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAlternativeRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(2.35)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isActive() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isActive()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getStartDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getRate()" ).isEqualTo(new Double(2.35)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExpiryDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExpiryDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isTrial() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isTrial()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getGlid() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricepointIdLink() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricepointIdLink()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isPreview() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isPreview()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getInteractiveFlag() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getInteractiveFlag()" ).isEqualTo("NONE");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isForcedPurchase() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isSubscriptionDuplicate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isSubscriptionDuplicate()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getFixedExpiryDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isReserveOnly() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getMinSubPeriod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPenaltyCharges() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getCancellation() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getCancellation()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getMonthEndSubscription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isHistoric() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isHistoric()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getFixedRecurrence() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isReceipting() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isReceipting()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getReceiptingAttribute() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getReceiptingAttribute()" ).isEqualTo("NULL");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getOrder() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPaymentHandler() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isPromo() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isPromo()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricingTextTemplateName1() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricingTextTemplateName1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricingTextTemplateName2() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricingTextTemplateName2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTranslatedPricingText1() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTranslatedPricingText2() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getRecurrenceDay() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
//// java.util.HashMap
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isAlignWithExternal() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
////check size of list!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().size()).as("result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPackageIdentifier() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:2PP_P002_TAX_999_999_999_999_999_*_*_*_false_false_*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getServiceIdentifier() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:2PP_P002_TAX_*_999_999_*_999_999");
//// com.vizzavi.ecommerce.business.common.ChargingResource
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getName()" ).isEqualTo("GBP");
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isCurrency()" ).isTrue() ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getCode()" ).isEqualTo(826) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getCountryId()" ).isEqualTo(0) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isToken()" ).isFalse() ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isUsageToken()" ).isFalse() ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isPayToken()" ).isFalse() ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getStandardRateWithoutTax() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getStandardRateWithoutTax()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getProtectedFk() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getProtectedFk()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getmPricingText1() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getmPricingText1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getmPricingText2() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getmPricingText2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isNonRecurring() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isNonRecurring()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isZeroCostIgnore() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getDescription()" ).isEqualTo("Default (event) ");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isTariff() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isTariff()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isHideForPurchaseOptions() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
//// com.vizzavi.ecommerce.business.catalog.Tax
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getKey()" ).isNull();
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
//////check size of list!
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().size()).as("result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
//////if the list is smaller than expected we can't continue, so do a hard assert
////        assertTrue(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).value() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(1).value() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(2).value() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
////        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getBalance() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isRecurring() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isRecurring()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
//// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPrice() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingText() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPricingModel() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPricingModel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getTier() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().isDefaultPPT() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isEvent() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isEvent()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getStandardRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(2.35)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().size()).as("result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getChannel() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getChannel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getMultiUsageMode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getMultiUsageMode()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getNetworkCodeMatchMethod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isPreRatePriceGross() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isPreRatePriceGross()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPreRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPaymentInformation() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPaymentInformation()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getContentName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getContentName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAssetID() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAssetID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPremiumLevel() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPremiumLevel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getReserveOnlyFlag() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getReserveOnlyFlag()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getSupplierId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getSupplierId()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getDeviceType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getDeviceType()" ).isEqualTo(999) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getUserGroups().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getUserGroups().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getUserGroup() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getUserGroup()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPaymentType() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPaymentType()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getEventDateTime() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getEventDateTime()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getEventUnits() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPromoCodes().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPromoCodes().length" ).isEqualTo(1) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBearerIds().length ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBearerIds().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPromoCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPromoCode()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getDuration() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getDuration()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getChargingMethod() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getChargingMethod()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getBearer() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getBearer()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isInteractive() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isInteractive()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isIncludeUnavailable() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isIncludeUnavailable()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExpressFlag() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isExpressFlag() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isCancellationUsage() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isCancellationUsage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTierName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTierName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPromoPrecode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPromoPrecode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getUniquePromoCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getUniquePromoCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPromoUniqueCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPromoUniqueCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getNextCycleDiscount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getHasHistoricPricePointFlag() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getHasHistoricPricePointFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isIsForRenewal() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isIsForRenewal()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTaxRateAsDouble() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTaxRateAsDouble()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAffiliateID() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAffiliateID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPartnerId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPartnerId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getTariff() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getTariff()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAggregatorId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAggregatorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isForcePurchaseFlow() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isForcePurchaseFlow()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getReceipientMsisdn() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getReceipientMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getProductCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getProductCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getMerchantName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getMerchantName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getInvoiceText() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getInvoiceText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isReIssueEnabled() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isReIssueEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isReIssueFlagPresent() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isReIssueFlagPresent()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getShortPackageId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getShortPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getHistoryStartDate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getHistoryStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getVendorId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getVendorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isIsForNextPaymentAmount() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isIsForNextPaymentAmount()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getRenewalPreRate() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isOverrideDisallowPreRateFlag() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isOverrideDisallowPreRateFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getContentCategory() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getContentCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPartnerUrl() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPartnerUrl()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPartnerContactInfo() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPartnerContactInfo()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPartnerEmail() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPartnerEmail()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPartnerName() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPartnerName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getSubRenewalPricepointId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getSubRenewalPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getLinkPricepointId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getLinkPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getSubPurchaseTransactionTrial() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getSubPurchaseTransactionTrial()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getDiscardHiddenInactivePricepoints() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExtIdentifier1() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExtIdentifier1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExtIdentifier2() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExtIdentifier2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExtIdentifier3() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExtIdentifier3()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getAccessChannel() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getAccessChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getPurchaseChannel() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getPurchaseChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getDeviceID() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getDeviceID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getLocal() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getLocal()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getMsisdn() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getLanguageLocale() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getLanguageLocale()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getLanguageCode() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getLanguageCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExternalField1() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExternalField1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExternalField2() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExternalField2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getExternalTransId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getExternalTransId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getActiveSubscriptions() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getActiveSubscriptions()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoints().get(0).getCsrId() ).as(" result.getSubscription().getPackage().getPricePoints().get(0).getCsrId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().isOriginal() ).as(" result.getSubscription().getPackage().isOriginal()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getTaxCode() ).as(" result.getSubscription().getPackage().getTaxCode()" ).isEqualTo("TAX");
//        softly.assertThat(result.getSubscription().getPackage().getPricingText1() ).as(" result.getSubscription().getPackage().getPricingText1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPricingText2() ).as(" result.getSubscription().getPackage().getPricingText2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().isGoodwillCredit() ).as(" result.getSubscription().getPackage().isGoodwillCredit()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPriceModels() ).as(" result.getSubscription().getPackage().getPriceModels()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getFullPackagePricepointId() ).as(" result.getSubscription().getPackage().getFullPackagePricepointId()" ).isEqualTo("2PP_P002__X__package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false");
//// java.lang.Character
//        softly.assertThat(result.getSubscription().getPackage().getSimplePackageId() ).as(" result.getSubscription().getPackage().getSimplePackageId()" ).isEqualTo("2PP_P002");
//        softly.assertThat(result.getSubscription().getPackage().getNotificationCategory() ).as(" result.getSubscription().getPackage().getNotificationCategory()" ).isNull();
//// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getKey() ).as(" result.getSubscription().getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" result.getSubscription().getPackage().getPaymentContent().getCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" result.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" result.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" result.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" result.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" result.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" result.getSubscription().getPackage().getPaymentContent().getDescription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getProtectedType() ).as(" result.getSubscription().getPackage().getProtectedType()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getDynamicProtectedValue() ).as(" result.getSubscription().getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getPurchaseMethod() ).as(" result.getSubscription().getPackage().getPurchaseMethod()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getKpiPackageProductCategory() ).as(" result.getSubscription().getPackage().getKpiPackageProductCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getKpiPackageType() ).as(" result.getSubscription().getPackage().getKpiPackageType()" ).isNull();
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricingModels().length ).as(" result.getSubscription().getPackage().getPricingModels().length" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().isExpressPurchase() ).as(" result.getSubscription().getPackage().isExpressPurchase()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().isRecieptingFlag() ).as(" result.getSubscription().getPackage().isRecieptingFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().isPricePointOrder() ).as(" result.getSubscription().getPackage().isPricePointOrder()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().isSuperPackage() ).as(" result.getSubscription().getPackage().isSuperPackage()" ).isFalse() ;
//// com.vizzavi.ecommerce.business.catalog.PricePoint
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getKey() ).as(" result.getSubscription().getPackage().getPricePoint().getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getId() ).as(" result.getSubscription().getPackage().getPricePoint().getId()" ).isEqualTo("package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getGracePeriod() ).as(" result.getSubscription().getPackage().getPricePoint().getGracePeriod()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getNetRate() ).as(" result.getSubscription().getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" result.getSubscription().getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getCustomResourceBalances() ).as(" result.getSubscription().getPackage().getPricePoint().getCustomResourceBalances()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getRetryFrequency() ).as(" result.getSubscription().getPackage().getPricePoint().getRetryFrequency()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getSuspensionPeriod() ).as(" result.getSubscription().getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" result.getSubscription().getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getTranslatedPricingText() ).as(" result.getSubscription().getPackage().getPricePoint().getTranslatedPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getFairUsageLimit() ).as(" result.getSubscription().getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getFairUsagePeriod() ).as(" result.getSubscription().getPackage().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit() ).as(" result.getSubscription().getPackage().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getExtensionPeriod() ).as(" result.getSubscription().getPackage().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP() ).as(" result.getSubscription().getPackage().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled() ).as(" result.getSubscription().getPackage().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isVolumeType() ).as(" result.getSubscription().getPackage().getPricePoint().isVolumeType()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isOriginal() ).as(" result.getSubscription().getPackage().getPricePoint().isOriginal()" ).isFalse() ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers().length ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" result.getSubscription().getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getPricePoint().isPreOrder() ).as(" result.getSubscription().getPackage().getPricePoint().isPreOrder()" ).isFalse() ;


        softly.assertAll();


    }

}
