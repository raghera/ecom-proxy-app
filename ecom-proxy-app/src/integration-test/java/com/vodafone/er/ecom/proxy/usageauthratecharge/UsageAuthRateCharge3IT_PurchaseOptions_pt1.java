package com.vodafone.er.ecom.proxy.usageauthratecharge;

import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.enums.EcomAppEnum.CLIENT_ID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 *
 * UsageAuthRateCharge with a Purchase Options response
 */
public class UsageAuthRateCharge3IT_PurchaseOptions_pt1 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageAuthRateCharge_noValidPackageResponse() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        final ChargingApi chargingApi = EcomApiFactory.getChargingApi(Locale.UK);
        UsageAuthorization usageAuth = chargingApi.usageAuthRateCharge(CLIENT_ID.getValue(), msisdn, "sAlt", new UsageAttributes());
        assertNotNull(usageAuth);
        assertFalse(usageAuth.isSuccess());

        softly.assertThat(usageAuth.getEventUnits() ).as(" usageAuth.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getStartDate() ).as(" usageAuth.getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResource() ).as(" usageAuth.getServicePricePoint().getResource()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getKey() ).as(" usageAuth.getServicePricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getId() ).as(" usageAuth.getServicePricePoint().getId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isPreOrder() ).as(" usageAuth.getServicePricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxRate() ).as(" usageAuth.getServicePricePoint().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxCode() ).as(" usageAuth.getServicePricePoint().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getServicePricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getRate() ).as(" usageAuth.getServicePricePoint().getRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getStandardRate() ).as(" usageAuth.getServicePricePoint().getStandardRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isDiscount() ).as(" usageAuth.getServicePricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getDiscountPromoText() ).as(" usageAuth.getServicePricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getDiscountPromoText() ).as(" usageAuth.getServicePricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getPackageId() ).as(" usageAuth.getServicePricePoint().getPackageId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().getContentId() ).as(" usageAuth.getServicePricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().getPricingText1() ).as(" usageAuth.getServicePricePoint().getPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingText2() ).as(" usageAuth.getServicePricePoint().getPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getUsageTime() ).as(" usageAuth.getServicePricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAccessDuration() ).as(" usageAuth.getServicePricePoint().getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isZeroCostIgnore() ).as(" usageAuth.getServicePricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingModelTier() ).as(" usageAuth.getServicePricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isArchived() ).as(" usageAuth.getServicePricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isBasePricePoint() ).as(" usageAuth.getServicePricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAccessDevice() ).as(" usageAuth.getServicePricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAlternativeRate() ).as(" usageAuth.getServicePricePoint().getAlternativeRate()" ).isEqualTo(new Double(-9999.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts().length ).as(" usageAuth.getServicePricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().size()).as("usageAuth.getServicePricePoint().getBalanceImpactList().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getBalanceImpactList().size() >= 0);
        softly.assertThat(usageAuth.getServicePricePoint().isTrial() ).as(" usageAuth.getServicePricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getGlid() ).as(" usageAuth.getServicePricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getGlid() ).as(" usageAuth.getServicePricePoint().getGlid()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getExpiryDate() ).as(" usageAuth.getServicePricePoint().getExpiryDate()" ).isNull();
// java.util.HashMap
        softly.assertThat(usageAuth.getServicePricePoint().getPricepointIdLink() ).as(" usageAuth.getServicePricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isPreview() ).as(" usageAuth.getServicePricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getInteractiveFlag() ).as(" usageAuth.getServicePricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getServicePricePoint().isForcedPurchase() ).as(" usageAuth.getServicePricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getServicePricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getFixedExpiryDate() ).as(" usageAuth.getServicePricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isReserveOnly() ).as(" usageAuth.getServicePricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getMinSubPeriod() ).as(" usageAuth.getServicePricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPenaltyCharges() ).as(" usageAuth.getServicePricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCancellation() ).as(" usageAuth.getServicePricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getMonthEndSubscription() ).as(" usageAuth.getServicePricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getServicePricePoint().isHistoric() ).as(" usageAuth.getServicePricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getFixedRecurrence() ).as(" usageAuth.getServicePricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isFixedRecurringPricePoint() ).as(" usageAuth.getServicePricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isReceipting() ).as(" usageAuth.getServicePricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getReceiptingAttribute() ).as(" usageAuth.getServicePricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getServicePricePoint().getOrder() ).as(" usageAuth.getServicePricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPaymentHandler() ).as(" usageAuth.getServicePricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getNonMatchAllUserGroups().length ).as(" usageAuth.getServicePricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().isPromo() ).as(" usageAuth.getServicePricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isSubmitToPaymentHandler() ).as(" usageAuth.getServicePricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isSuppressToPaymentHandler() ).as(" usageAuth.getServicePricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricingTextTemplateName1() ).as(" usageAuth.getServicePricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingTextTemplateName2() ).as(" usageAuth.getServicePricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getTranslatedPricingText1() ).as(" usageAuth.getServicePricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getTranslatedPricingText2() ).as(" usageAuth.getServicePricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getRecurrenceDay() ).as(" usageAuth.getServicePricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricingTextList1() ).as(" usageAuth.getServicePricePoint().getPricingTextList1()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingTextList2() ).as(" usageAuth.getServicePricePoint().getPricingTextList2()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isAlignWithExternal() ).as(" usageAuth.getServicePricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getGracePeriod() ).as(" usageAuth.getServicePricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getRetryFrequency() ).as(" usageAuth.getServicePricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getSuspensionPeriod() ).as(" usageAuth.getServicePricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTranslatedPricingText() ).as(" usageAuth.getServicePricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getFairUsageLimit() ).as(" usageAuth.getServicePricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getFairUsagePeriod() ).as(" usageAuth.getServicePricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getFairUsagePeriodUnit() ).as(" usageAuth.getServicePricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getServicePricePoint().getExtensionPeriod() ).as(" usageAuth.getServicePricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().isIncludeServiceForPackageFUP() ).as(" usageAuth.getServicePricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isFairUsagePolicyEnabled() ).as(" usageAuth.getServicePricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isTariff() ).as(" usageAuth.getServicePricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isHideForPurchaseOptions() ).as(" usageAuth.getServicePricePoint().isHideForPurchaseOptions()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances() ).as(" usageAuth.getServicePricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getTax() ).as(" usageAuth.getServicePricePoint().getTax()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances() ).as(" usageAuth.getServicePricePoint().getBalances()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isRecurring() ).as(" usageAuth.getServicePricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getServicePricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size() >= 0);
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPricingModel() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getTier() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getTier()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().isDefaultPPT() ).as(" usageAuth.getServicePricePoint().getPricePointTier().isDefaultPPT()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getAllBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getAllBalanceImpacts().size() >= 0);
        softly.assertThat(usageAuth.getServicePricePoint().getPackageIdentifier() ).as(" usageAuth.getServicePricePoint().getPackageIdentifier()" ).isEqualTo("package:*_*_999_999_999_999_998__*__false_false_*");
        softly.assertThat(usageAuth.getServicePricePoint().getServiceIdentifier() ).as(" usageAuth.getServicePricePoint().getServiceIdentifier()" ).isEqualTo("content:*_*_*_998_999_*_999_999");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceField() ).as(" usageAuth.getServicePricePoint().getResourceField()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getStandardRateWithoutTax() ).as(" usageAuth.getServicePricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isVolumeType() ).as(" usageAuth.getServicePricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isOriginal() ).as(" usageAuth.getServicePricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers().length ).as(" usageAuth.getServicePricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 0);
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getTier() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getTier()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getProtectedFk() ).as(" usageAuth.getServicePricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText1() ).as(" usageAuth.getServicePricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText1() ).as(" usageAuth.getServicePricePoint().getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText2() ).as(" usageAuth.getServicePricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText2() ).as(" usageAuth.getServicePricePoint().getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().isNonRecurring() ).as(" usageAuth.getServicePricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isEvent() ).as(" usageAuth.getServicePricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getStartDate() ).as(" usageAuth.getServicePricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getDescription() ).as(" usageAuth.getServicePricePoint().getDescription()" ).isEqualTo("Default (event) , PromoCode ");
        softly.assertThat(usageAuth.getServicePricePoint().isActive() ).as(" usageAuth.getServicePricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getNetRate() ).as(" usageAuth.getServicePricePoint().getNetRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getServicePricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getChannel() ).as(" usageAuth.getServicePricePoint().getChannel()" ).isEqualTo(998) ;
        softly.assertThat(usageAuth.getServicePricePoint().getMultiUsageMode() ).as(" usageAuth.getServicePricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getNetworkCodeMatchMethod() ).as(" usageAuth.getServicePricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().isPreRatePriceGross() ).as(" usageAuth.getServicePricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPreRate() ).as(" usageAuth.getServicePricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPaymentInformation() ).as(" usageAuth.getServicePricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getContentName() ).as(" usageAuth.getServicePricePoint().getContentName()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAssetID() ).as(" usageAuth.getServicePricePoint().getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPremiumLevel() ).as(" usageAuth.getServicePricePoint().getPremiumLevel()" ).isEqualTo(998) ;
        softly.assertThat(usageAuth.getServicePricePoint().getReserveOnlyFlag() ).as(" usageAuth.getServicePricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getSupplierId() ).as(" usageAuth.getServicePricePoint().getSupplierId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getSupplierId() ).as(" usageAuth.getServicePricePoint().getSupplierId()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getDeviceType() ).as(" usageAuth.getServicePricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getUserGroups().length ).as(" usageAuth.getServicePricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getUserGroup() ).as(" usageAuth.getServicePricePoint().getUserGroup()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getUserGroup() ).as(" usageAuth.getServicePricePoint().getUserGroup()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getPaymentType() ).as(" usageAuth.getServicePricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getEventDateTime() ).as(" usageAuth.getServicePricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getEventUnits() ).as(" usageAuth.getServicePricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getPromoCodes().length ).as(" usageAuth.getServicePricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBearerIds().length ).as(" usageAuth.getServicePricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPromoCode() ).as(" usageAuth.getServicePricePoint().getPromoCode()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getPromoCode() ).as(" usageAuth.getServicePricePoint().getPromoCode()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getDuration() ).as(" usageAuth.getServicePricePoint().getDuration()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getChargingMethod() ).as(" usageAuth.getServicePricePoint().getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBearer() ).as(" usageAuth.getServicePricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().isInteractive() ).as(" usageAuth.getServicePricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().isIncludeUnavailable() ).as(" usageAuth.getServicePricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getExpressFlag() ).as(" usageAuth.getServicePricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isExpressFlag() ).as(" usageAuth.getServicePricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isCancellationUsage() ).as(" usageAuth.getServicePricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTierName() ).as(" usageAuth.getServicePricePoint().getTierName()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPromoPrecode() ).as(" usageAuth.getServicePricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getUniquePromoCode() ).as(" usageAuth.getServicePricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPromoUniqueCode() ).as(" usageAuth.getServicePricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getNextCycleDiscount() ).as(" usageAuth.getServicePricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getHasHistoricPricePointFlag() ).as(" usageAuth.getServicePricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isIsForRenewal() ).as(" usageAuth.getServicePricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxRateAsDouble() ).as(" usageAuth.getServicePricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAffiliateID() ).as(" usageAuth.getServicePricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPartnerId() ).as(" usageAuth.getServicePricePoint().getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getTariff() ).as(" usageAuth.getServicePricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().getAggregatorId() ).as(" usageAuth.getServicePricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isForcePurchaseFlow() ).as(" usageAuth.getServicePricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getReceipientMsisdn() ).as(" usageAuth.getServicePricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getProductCode() ).as(" usageAuth.getServicePricePoint().getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getMerchantName() ).as(" usageAuth.getServicePricePoint().getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getInvoiceText() ).as(" usageAuth.getServicePricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isReIssueEnabled() ).as(" usageAuth.getServicePricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isReIssueFlagPresent() ).as(" usageAuth.getServicePricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getShortPackageId() ).as(" usageAuth.getServicePricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getHistoryStartDate() ).as(" usageAuth.getServicePricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getVendorId() ).as(" usageAuth.getServicePricePoint().getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isIsForNextPaymentAmount() ).as(" usageAuth.getServicePricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getRenewalPreRate() ).as(" usageAuth.getServicePricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isOverrideDisallowPreRateFlag() ).as(" usageAuth.getServicePricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getContentCategory() ).as(" usageAuth.getServicePricePoint().getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPartnerUrl() ).as(" usageAuth.getServicePricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPartnerContactInfo() ).as(" usageAuth.getServicePricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPartnerEmail() ).as(" usageAuth.getServicePricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPartnerName() ).as(" usageAuth.getServicePricePoint().getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getServicePricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getServicePricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getSubRenewalPricepointId() ).as(" usageAuth.getServicePricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getLinkPricepointId() ).as(" usageAuth.getServicePricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getSubPurchaseTransactionTrial() ).as(" usageAuth.getServicePricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getServicePricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getServicePricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getExtIdentifier1() ).as(" usageAuth.getServicePricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getExtIdentifier2() ).as(" usageAuth.getServicePricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getExtIdentifier3() ).as(" usageAuth.getServicePricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAccessChannel() ).as(" usageAuth.getServicePricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPurchaseChannel() ).as(" usageAuth.getServicePricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getDeviceID() ).as(" usageAuth.getServicePricePoint().getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getLocal() ).as(" usageAuth.getServicePricePoint().getLocal()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getMsisdn() ).as(" usageAuth.getServicePricePoint().getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getLanguageLocale() ).as(" usageAuth.getServicePricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getLanguageCode() ).as(" usageAuth.getServicePricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getExternalField1() ).as(" usageAuth.getServicePricePoint().getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getExternalField2() ).as(" usageAuth.getServicePricePoint().getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getExternalTransId() ).as(" usageAuth.getServicePricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getActiveSubscriptions() ).as(" usageAuth.getServicePricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCsrId() ).as(" usageAuth.getServicePricePoint().getCsrId()" ).isNull();
        softly.assertThat(usageAuth.getSubscriptionStatus() ).as(" usageAuth.getSubscriptionStatus()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getIsPreordered() ).as(" usageAuth.getIsPreordered()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.isSuccessfulExpressPurchase() ).as(" usageAuth.isSuccessfulExpressPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubResourceBalances() ).as(" usageAuth.getSubResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.isBasedOnMultiplePackages() ).as(" usageAuth.isBasedOnMultiplePackages()" ).isFalse() ;
        softly.assertThat(usageAuth.getParentTransactionId() ).as(" usageAuth.getParentTransactionId()" ).isNull();
        softly.assertThat(usageAuth.getParentTransactionIdLong() ).as(" usageAuth.getParentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.isFirstUsage() ).as(" usageAuth.isFirstUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getReIssue() ).as(" usageAuth.getReIssue()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getIsValidatedAccount() ).as(" usageAuth.getIsValidatedAccount()" ).isNull();
        softly.assertThat(usageAuth.isAuthorized() ).as(" usageAuth.isAuthorized()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage() ).as(" usageAuth.getPackage()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getResource().getName() ).as(" usageAuth.getResource().getName()" ).isNull();
        softly.assertThat(usageAuth.getResource().isCurrency() ).as(" usageAuth.getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isResource() ).as(" usageAuth.getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getResource().getCountryId() ).as(" usageAuth.getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getResource().getResourceName() ).as(" usageAuth.getResource().getResourceName()" ).isEqualTo("ChargingResource_0");
        softly.assertThat(usageAuth.getResource().isToken() ).as(" usageAuth.getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isUsageToken() ).as(" usageAuth.getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isPayToken() ).as(" usageAuth.getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().getResourceSymbol() ).as(" usageAuth.getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_0");
        softly.assertThat(usageAuth.getResource().getCode() ).as(" usageAuth.getResource().getCode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getResource().getDescription() ).as(" usageAuth.getResource().getDescription()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
        softly.assertThat(usageAuth.getPricePoint().getResource() ).as(" usageAuth.getPricePoint().getResource()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getKey() ).as(" usageAuth.getPricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getId() ).as(" usageAuth.getPricePoint().getId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isPreOrder() ).as(" usageAuth.getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getTaxRate() ).as(" usageAuth.getPricePoint().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getTaxCode() ).as(" usageAuth.getPricePoint().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getRate() ).as(" usageAuth.getPricePoint().getRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getStandardRate() ).as(" usageAuth.getPricePoint().getStandardRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isDiscount() ).as(" usageAuth.getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getPackageId() ).as(" usageAuth.getPricePoint().getPackageId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricePoint().getContentId() ).as(" usageAuth.getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricePoint().getPricingText1() ).as(" usageAuth.getPricePoint().getPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricingText2() ).as(" usageAuth.getPricePoint().getPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getUsageTime() ).as(" usageAuth.getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPricePoint().getAccessDuration() ).as(" usageAuth.getPricePoint().getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isZeroCostIgnore() ).as(" usageAuth.getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricingModelTier() ).as(" usageAuth.getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isArchived() ).as(" usageAuth.getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isBasePricePoint() ).as(" usageAuth.getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getAccessDevice() ).as(" usageAuth.getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPricePoint().getAlternativeRate() ).as(" usageAuth.getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(-9999.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts().length ).as(" usageAuth.getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
//check size of list!
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().size()).as("usageAuth.getPricePoint().getBalanceImpactList().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPricePoint().getBalanceImpactList().size() >= 0);
        softly.assertThat(usageAuth.getPricePoint().isTrial() ).as(" usageAuth.getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getGlid() ).as(" usageAuth.getPricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getGlid() ).as(" usageAuth.getPricePoint().getGlid()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getExpiryDate() ).as(" usageAuth.getPricePoint().getExpiryDate()" ).isNull();
// java.util.HashMap
        softly.assertThat(usageAuth.getPricePoint().getPricepointIdLink() ).as(" usageAuth.getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isPreview() ).as(" usageAuth.getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getInteractiveFlag() ).as(" usageAuth.getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPricePoint().isForcedPurchase() ).as(" usageAuth.getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getFixedExpiryDate() ).as(" usageAuth.getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isReserveOnly() ).as(" usageAuth.getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getMinSubPeriod() ).as(" usageAuth.getPricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().getPenaltyCharges() ).as(" usageAuth.getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getCancellation() ).as(" usageAuth.getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getMonthEndSubscription() ).as(" usageAuth.getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPricePoint().isHistoric() ).as(" usageAuth.getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getFixedRecurrence() ).as(" usageAuth.getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPricePoint().isFixedRecurringPricePoint() ).as(" usageAuth.getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isReceipting() ).as(" usageAuth.getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getReceiptingAttribute() ).as(" usageAuth.getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPricePoint().getOrder() ).as(" usageAuth.getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getPaymentHandler() ).as(" usageAuth.getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getNonMatchAllUserGroups().length ).as(" usageAuth.getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().isPromo() ).as(" usageAuth.getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isSubmitToPaymentHandler() ).as(" usageAuth.getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isSuppressToPaymentHandler() ).as(" usageAuth.getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getPricingTextTemplateName1() ).as(" usageAuth.getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricingTextTemplateName2() ).as(" usageAuth.getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getTranslatedPricingText1() ).as(" usageAuth.getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getTranslatedPricingText2() ).as(" usageAuth.getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getRecurrenceDay() ).as(" usageAuth.getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().getPricingTextList1() ).as(" usageAuth.getPricePoint().getPricingTextList1()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricingTextList2() ).as(" usageAuth.getPricePoint().getPricingTextList2()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isAlignWithExternal() ).as(" usageAuth.getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getGracePeriod() ).as(" usageAuth.getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getRetryFrequency() ).as(" usageAuth.getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getSuspensionPeriod() ).as(" usageAuth.getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getTranslatedPricingText() ).as(" usageAuth.getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getFairUsageLimit() ).as(" usageAuth.getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().getFairUsagePeriod() ).as(" usageAuth.getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().getFairUsagePeriodUnit() ).as(" usageAuth.getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPricePoint().getExtensionPeriod() ).as(" usageAuth.getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().isIncludeServiceForPackageFUP() ).as(" usageAuth.getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isFairUsagePolicyEnabled() ).as(" usageAuth.getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isTariff() ).as(" usageAuth.getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isHideForPurchaseOptions() ).as(" usageAuth.getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances() ).as(" usageAuth.getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getTax() ).as(" usageAuth.getPricePoint().getTax()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getBalances() ).as(" usageAuth.getPricePoint().getBalances()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isRecurring() ).as(" usageAuth.getPricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getKey() ).as(" usageAuth.getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 0);
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getPricingModel() ).as(" usageAuth.getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getTier() ).as(" usageAuth.getPricePoint().getPricePointTier().getTier()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().isDefaultPPT() ).as(" usageAuth.getPricePoint().getPricePointTier().isDefaultPPT()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPricePoint().getAllBalanceImpacts().size()).as("usageAuth.getPricePoint().getAllBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPricePoint().getAllBalanceImpacts().size() >= 0);
        softly.assertThat(usageAuth.getPricePoint().getPackageIdentifier() ).as(" usageAuth.getPricePoint().getPackageIdentifier()" ).isEqualTo("package:*_*_999_999_999_999_998__*__false_false_*");
        softly.assertThat(usageAuth.getPricePoint().getServiceIdentifier() ).as(" usageAuth.getPricePoint().getServiceIdentifier()" ).isEqualTo("content:*_*_*_998_999_*_999_999");
        softly.assertThat(usageAuth.getPricePoint().getResourceField() ).as(" usageAuth.getPricePoint().getResourceField()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getStandardRateWithoutTax() ).as(" usageAuth.getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isVolumeType() ).as(" usageAuth.getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isOriginal() ).as(" usageAuth.getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers().length ).as(" usageAuth.getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getKey() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 0);
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getTier() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].getTier()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getProtectedFk() ).as(" usageAuth.getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getmPricingText1() ).as(" usageAuth.getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getmPricingText1() ).as(" usageAuth.getPricePoint().getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getmPricingText2() ).as(" usageAuth.getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getmPricingText2() ).as(" usageAuth.getPricePoint().getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().isNonRecurring() ).as(" usageAuth.getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isEvent() ).as(" usageAuth.getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getStartDate() ).as(" usageAuth.getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getDescription() ).as(" usageAuth.getPricePoint().getDescription()" ).isEqualTo("Default (event) , PromoCode ");
        softly.assertThat(usageAuth.getPricePoint().isActive() ).as(" usageAuth.getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getNetRate() ).as(" usageAuth.getPricePoint().getNetRate()" ).isEqualTo(new Double(-9999.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getChannel() ).as(" usageAuth.getPricePoint().getChannel()" ).isEqualTo(998) ;
        softly.assertThat(usageAuth.getPricePoint().getMultiUsageMode() ).as(" usageAuth.getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getNetworkCodeMatchMethod() ).as(" usageAuth.getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().isPreRatePriceGross() ).as(" usageAuth.getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getPreRate() ).as(" usageAuth.getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getPaymentInformation() ).as(" usageAuth.getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getContentName() ).as(" usageAuth.getPricePoint().getContentName()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getAssetID() ).as(" usageAuth.getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPremiumLevel() ).as(" usageAuth.getPricePoint().getPremiumLevel()" ).isEqualTo(998) ;
        softly.assertThat(usageAuth.getPricePoint().getReserveOnlyFlag() ).as(" usageAuth.getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getSupplierId() ).as(" usageAuth.getPricePoint().getSupplierId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getSupplierId() ).as(" usageAuth.getPricePoint().getSupplierId()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getDeviceType() ).as(" usageAuth.getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getUserGroups().length ).as(" usageAuth.getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPricePoint().getUserGroup() ).as(" usageAuth.getPricePoint().getUserGroup()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getUserGroup() ).as(" usageAuth.getPricePoint().getUserGroup()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getPaymentType() ).as(" usageAuth.getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPricePoint().getEventDateTime() ).as(" usageAuth.getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getEventUnits() ).as(" usageAuth.getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getPromoCodes().length ).as(" usageAuth.getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getBearerIds().length ).as(" usageAuth.getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPricePoint().getPromoCode() ).as(" usageAuth.getPricePoint().getPromoCode()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getPromoCode() ).as(" usageAuth.getPricePoint().getPromoCode()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getDuration() ).as(" usageAuth.getPricePoint().getDuration()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPricePoint().getChargingMethod() ).as(" usageAuth.getPricePoint().getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPricePoint().getBearer() ).as(" usageAuth.getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricePoint().isInteractive() ).as(" usageAuth.getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().isIncludeUnavailable() ).as(" usageAuth.getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getExpressFlag() ).as(" usageAuth.getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isExpressFlag() ).as(" usageAuth.getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isCancellationUsage() ).as(" usageAuth.getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getTierName() ).as(" usageAuth.getPricePoint().getTierName()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPromoPrecode() ).as(" usageAuth.getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getUniquePromoCode() ).as(" usageAuth.getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPromoUniqueCode() ).as(" usageAuth.getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getNextCycleDiscount() ).as(" usageAuth.getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getHasHistoricPricePointFlag() ).as(" usageAuth.getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isIsForRenewal() ).as(" usageAuth.getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getTaxRateAsDouble() ).as(" usageAuth.getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getAffiliateID() ).as(" usageAuth.getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPartnerId() ).as(" usageAuth.getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getTariff() ).as(" usageAuth.getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricePoint().getAggregatorId() ).as(" usageAuth.getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isForcePurchaseFlow() ).as(" usageAuth.getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getReceipientMsisdn() ).as(" usageAuth.getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getProductCode() ).as(" usageAuth.getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getMerchantName() ).as(" usageAuth.getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getInvoiceText() ).as(" usageAuth.getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isReIssueEnabled() ).as(" usageAuth.getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isReIssueFlagPresent() ).as(" usageAuth.getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getShortPackageId() ).as(" usageAuth.getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getHistoryStartDate() ).as(" usageAuth.getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getVendorId() ).as(" usageAuth.getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isIsForNextPaymentAmount() ).as(" usageAuth.getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getRenewalPreRate() ).as(" usageAuth.getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isOverrideDisallowPreRateFlag() ).as(" usageAuth.getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getContentCategory() ).as(" usageAuth.getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPartnerUrl() ).as(" usageAuth.getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPartnerContactInfo() ).as(" usageAuth.getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPartnerEmail() ).as(" usageAuth.getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPartnerName() ).as(" usageAuth.getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPricePoint().getSubRenewalPricepointId() ).as(" usageAuth.getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getLinkPricepointId() ).as(" usageAuth.getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getSubPurchaseTransactionTrial() ).as(" usageAuth.getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getExtIdentifier1() ).as(" usageAuth.getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getExtIdentifier2() ).as(" usageAuth.getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getExtIdentifier3() ).as(" usageAuth.getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getAccessChannel() ).as(" usageAuth.getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPurchaseChannel() ).as(" usageAuth.getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getDeviceID() ).as(" usageAuth.getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getLocal() ).as(" usageAuth.getPricePoint().getLocal()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getMsisdn() ).as(" usageAuth.getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getLanguageLocale() ).as(" usageAuth.getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getLanguageCode() ).as(" usageAuth.getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getExternalField1() ).as(" usageAuth.getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getExternalField2() ).as(" usageAuth.getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getExternalTransId() ).as(" usageAuth.getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getActiveSubscriptions() ).as(" usageAuth.getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getCsrId() ).as(" usageAuth.getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(usageAuth.getContentName() ).as(" usageAuth.getContentName()" ).isNull();
        softly.assertThat(usageAuth.isInteractive() ).as(" usageAuth.isInteractive()" ).isFalse() ;
        softly.assertThat(usageAuth.getPartnerId() ).as(" usageAuth.getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getErrorId() ).as(" usageAuth.getErrorId()" ).isNull();
        softly.assertThat(usageAuth.getErrorDescription() ).as(" usageAuth.getErrorDescription()" ).isNull();
        softly.assertThat(usageAuth.getSubscription() ).as(" usageAuth.getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getActiveSubscriptions() ).as(" usageAuth.getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.isServiceSubmit() ).as(" usageAuth.isServiceSubmit()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackageSubscriptionId() ).as(" usageAuth.getPackageSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.isReservedOnly() ).as(" usageAuth.isReservedOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.isCharged() ).as(" usageAuth.isCharged()" ).isFalse() ;
        softly.assertThat(usageAuth.getUserResourceBalance() ).as(" usageAuth.getUserResourceBalance()" ).isNull();
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(usageAuth.getReasonCode().getName() ).as(" usageAuth.getReasonCode().getName()" ).isEqualTo("NO VALID PACKAGE");
        softly.assertThat(usageAuth.getReasonCode().getSubCode() ).as(" usageAuth.getReasonCode().getSubCode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getReasonCode().getResourceName() ).as(" usageAuth.getReasonCode().getResourceName()" ).isEqualTo("ReasonCode_41");
        softly.assertThat(usageAuth.getReasonCode().getCode() ).as(" usageAuth.getReasonCode().getCode()" ).isEqualTo(41) ;
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(usageAuth.getSubReasonCode().getName() ).as(" usageAuth.getSubReasonCode().getName()" ).isEqualTo("ACTIVE SUBSCRIPTION NOT FOUND");
        softly.assertThat(usageAuth.getSubReasonCode().getSubCode() ).as(" usageAuth.getSubReasonCode().getSubCode()" ).isEqualTo(-2) ;
        softly.assertThat(usageAuth.getSubReasonCode().getResourceName() ).as(" usageAuth.getSubReasonCode().getResourceName()" ).isEqualTo("ReasonCode_41");
        softly.assertThat(usageAuth.getSubReasonCode().getCode() ).as(" usageAuth.getSubReasonCode().getCode()" ).isEqualTo(41) ;
        softly.assertThat(usageAuth.getPaymentErrorId() ).as(" usageAuth.getPaymentErrorId()" ).isNull();
        softly.assertThat(usageAuth.getPaymentErrorDescription() ).as(" usageAuth.getPaymentErrorDescription()" ).isNull();
        softly.assertThat(usageAuth.getPaymentId() ).as(" usageAuth.getPaymentId()" ).isNull();
        softly.assertThat(usageAuth.getEventReservationId() ).as(" usageAuth.getEventReservationId()" ).isNull();
        softly.assertThat(usageAuth.getPackageSubscriptionIdLong() ).as(" usageAuth.getPackageSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getTransactionId() ).as(" usageAuth.getTransactionId()" ).isNull();
        softly.assertThat(usageAuth.getTransactionIdLong() ).as(" usageAuth.getTransactionIdLong()" ).isEqualTo(new Long(-2)) ;
        softly.assertThat(usageAuth.getAuthCode() ).as(" usageAuth.getAuthCode()" ).isNull();
        softly.assertThat(usageAuth.getPaymentStatus() ).as(" usageAuth.getPaymentStatus()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPaymentStatusEnum() ).as(" usageAuth.getPaymentStatusEnum()" ).isNull();
// com.vizzavi.ecommerce.business.common.ResponseStatus
        softly.assertThat(usageAuth.getStatusEnum().getName() ).as(" usageAuth.getStatusEnum().getName()" ).isEqualTo("ACCEPTED");
        softly.assertThat(usageAuth.getStatusEnum().getId() ).as(" usageAuth.getStatusEnum().getId()" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getStatusEnum().isError() ).as(" usageAuth.getStatusEnum().isError()" ).isFalse() ;
        softly.assertThat(usageAuth.getStatusEnum().isFailed() ).as(" usageAuth.getStatusEnum().isFailed()" ).isFalse() ;
        softly.assertThat(usageAuth.getStatusEnum().isDenied() ).as(" usageAuth.getStatusEnum().isDenied()" ).isFalse() ;
        softly.assertThat(usageAuth.getStatusEnum().isRejected() ).as(" usageAuth.getStatusEnum().isRejected()" ).isFalse() ;
        softly.assertThat(usageAuth.getStatusEnum().isAccepted() ).as(" usageAuth.getStatusEnum().isAccepted()" ).isTrue() ;
        softly.assertThat(usageAuth.getTaxAmount() ).as(" usageAuth.getTaxAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getAuthorized() ).as(" usageAuth.getAuthorized()" ).isFalse() ;
        softly.assertThat(usageAuth.getPaymentInfo() ).as(" usageAuth.getPaymentInfo()" ).isNull();
        softly.assertThat(usageAuth.getReceiptingCreditBalanceImpact() ).as(" usageAuth.getReceiptingCreditBalanceImpact()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getReceiptingUsageTypeAttribute() ).as(" usageAuth.getReceiptingUsageTypeAttribute()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getSubscriptionIds() ).as(" usageAuth.getSubscriptionIds()" ).isNull();
        softly.assertThat(usageAuth.getSubscriptionIdsLong() ).as(" usageAuth.getSubscriptionIdsLong()" ).isNull();
        softly.assertThat(usageAuth.getMicroServiceSubList() ).as(" usageAuth.getMicroServiceSubList()" ).isNull();
        softly.assertThat(usageAuth.getValidMicroServiceSub() ).as(" usageAuth.getValidMicroServiceSub()" ).isNull();
        softly.assertThat(usageAuth.isValid() ).as(" usageAuth.isValid()" ).isFalse() ;
        softly.assertThat(usageAuth.getTaxRate() ).as(" usageAuth.getTaxRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getTaxCode() ).as(" usageAuth.getTaxCode()" ).isNull();
        softly.assertThat(usageAuth.getRate() ).as(" usageAuth.getRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getStandardRate() ).as(" usageAuth.getStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getAlternativeTaxCode() ).as(" usageAuth.getAlternativeTaxCode()" ).isNull();
        softly.assertThat(usageAuth.getAlternativeTaxRate() ).as(" usageAuth.getAlternativeTaxRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getAlternativeTaxAmount() ).as(" usageAuth.getAlternativeTaxAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getNetStandardRate() ).as(" usageAuth.getNetStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getRatingSystemId() ).as(" usageAuth.getRatingSystemId()" ).isNull();
        softly.assertThat(usageAuth.getRatingSystemVersion() ).as(" usageAuth.getRatingSystemVersion()" ).isNull();
        softly.assertThat(usageAuth.isDiscount() ).as(" usageAuth.isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getDiscountPromoText() ).as(" usageAuth.getDiscountPromoText()" ).isNull();
        softly.assertThat(usageAuth.isAlternativePaymentMethod() ).as(" usageAuth.isAlternativePaymentMethod()" ).isFalse() ;
        softly.assertThat(usageAuth.getMatchingAttributes() ).as(" usageAuth.getMatchingAttributes()" ).isNull();
        softly.assertThat(usageAuth.getInputAttributes() ).as(" usageAuth.getInputAttributes()" ).isNull();
        softly.assertThat(usageAuth.getDiscountPercentage() ).as(" usageAuth.getDiscountPercentage()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackageId() ).as(" usageAuth.getPackageId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getContentId() ).as(" usageAuth.getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricingText1() ).as(" usageAuth.getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricingText1() ).as(" usageAuth.getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricingText2() ).as(" usageAuth.getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricingText2() ).as(" usageAuth.getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getUndiscountedStandardRate() ).as(" usageAuth.getUndiscountedStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getAlternativeCurrencyId() ).as(" usageAuth.getAlternativeCurrencyId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getAlternativeNetRate() ).as(" usageAuth.getAlternativeNetRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getRateIdentifier() ).as(" usageAuth.getRateIdentifier()" ).isNull();
        softly.assertThat(usageAuth.getRateIdentifiers() ).as(" usageAuth.getRateIdentifiers()" ).isNull();
        softly.assertThat(usageAuth.getUsageTime() ).as(" usageAuth.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getAccessDuration() ).as(" usageAuth.getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPricePointId() ).as(" usageAuth.getPricePointId()" ).isNull();
        softly.assertThat(usageAuth.isUniquePromoCode() ).as(" usageAuth.isUniquePromoCode()" ).isFalse() ;
        softly.assertThat(usageAuth.isZeroCostIgnore() ).as(" usageAuth.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageAuth.getCustomResourceBalances() ).as(" usageAuth.getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getDescription() ).as(" usageAuth.getDescription()" ).isNull();
        softly.assertThat(usageAuth.getNetRate() ).as(" usageAuth.getNetRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.isAlwaysValidateMsisdn() ).as(" usageAuth.isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.isSuccess() ).as(" usageAuth.isSuccess()" ).isFalse() ;
        softly.assertThat(usageAuth.getCurrencyId() ).as(" usageAuth.getCurrencyId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getTimestamp() ).as(" usageAuth.getTimestamp()" ).isNull();



    }

}
