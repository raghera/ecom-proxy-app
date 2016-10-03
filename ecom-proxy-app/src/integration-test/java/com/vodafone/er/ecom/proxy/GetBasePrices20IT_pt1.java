package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vodafone.global.er.business.catalog.BasePrice;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Ravi Aghera
 */
public class GetBasePrices20IT_pt1 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void getBasesPrices() throws Exception {
        String serviceId = "c001";

        final BasePrice [] results = EcomApiFactory.getCatalogApi(Locale.UK)
                .getBasePrices(new String [] {serviceId });
        assertNotNull(results);
        assertEquals(1, results.length);

        BasePrice result = results[0];

// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getResource().getName() ).as(" result.getPricePoint().getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getResource().getResourceName() ).as(" result.getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getResource().isToken() ).as(" result.getPricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResource().isUsageToken() ).as(" result.getPricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResource().isPayToken() ).as(" result.getPricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResource().getResourceSymbol() ).as(" result.getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getResource().getDescription() ).as(" result.getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getResource().isCurrency() ).as(" result.getPricePoint().getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getResource().isResource() ).as(" result.getPricePoint().getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResource().getCountryId() ).as(" result.getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getResource().getCode() ).as(" result.getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(result.getPricePoint().getKey() ).as(" result.getPricePoint().getKey()" ).isNull();
        softly.assertThat(result.getPricePoint().getId() ).as(" result.getPricePoint().getId()" ).isEqualTo("package:pPreSignOn1_TAX_1_2_8_999_999_999_*_*_*_false_false");
        softly.assertThat(result.getPricePoint().isActive() ).as(" result.getPricePoint().isActive()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getDescription() ).as(" result.getPricePoint().getDescription()" ).isEqualTo("Non-recurring 1 day");
        softly.assertThat(result.getPricePoint().getRate() ).as(" result.getPricePoint().getRate()" ).isEqualTo(new Double(1.185)) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getResourceBalances() ).as(" result.getPricePoint().getResourceBalances()" ).isNotNull() ;
//        softly.assertThat(result.getPricePoint().getResourceBalances().length ).as(" result.getPricePoint().getResourceBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" result.getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getBalance() ).as(" result.getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getPackageId() ).as(" result.getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" result.getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" result.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" result.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getThreshold() ).as(" result.getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getResourceBalances()[0].getSubscription() ).as(" result.getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(result.getPricePoint().getStandardRate() ).as(" result.getPricePoint().getStandardRate()" ).isEqualTo(new Double(1.185)) ;
        softly.assertThat(result.getPricePoint().getNetRate() ).as(" result.getPricePoint().getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(result.getPricePoint().isAlwaysValidateMsisdn() ).as(" result.getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isDiscount() ).as(" result.getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getDiscountPromoText() ).as(" result.getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getPackageId() ).as(" result.getPricePoint().getPackageId()" ).isEqualTo("pPreSignOn1");
        softly.assertThat(result.getPricePoint().getContentId() ).as(" result.getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getPricingText1() ).as(" result.getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getPricingText2() ).as(" result.getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getUsageTime() ).as(" result.getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(result.getPricePoint().getAccessDuration() ).as(" result.getPricePoint().getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getPricePoint().isZeroCostIgnore() ).as(" result.getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getCustomResourceBalances() ).as(" result.getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(result.getPricePoint().getPricingModelTier() ).as(" result.getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(result.getPricePoint().isArchived() ).as(" result.getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isBasePricePoint() ).as(" result.getPricePoint().isBasePricePoint()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().getAccessDevice() ).as(" result.getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getAlternativeRate() ).as(" result.getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(1.185)) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getBalanceImpacts().length ).as(" result.getPricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].getName() ).as(" result.getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" result.getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].isToken() ).as(" result.getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" result.getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" result.getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" result.getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" result.getPricePoint().getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" result.getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].isResource() ).as(" result.getPricePoint().getBalanceImpacts()[0].isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" result.getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpacts()[0].getCode() ).as(" result.getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
//check size of list!
        softly.assertThat(result.getPricePoint().getBalanceImpactList().size()).as("result.getPricePoint().getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getPricePoint().getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getId() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getType() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" result.getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" result.getPricePoint().getBalanceImpactList().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" result.getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(result.getPricePoint().isTrial() ).as(" result.getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getGlid() ).as(" result.getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(result.getPricePoint().getPricepointIdLink() ).as(" result.getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().isPreview() ).as(" result.getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getInteractiveFlag() ).as(" result.getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(result.getPricePoint().isForcedPurchase() ).as(" result.getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isSubscriptionDuplicate() ).as(" result.getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().getFixedExpiryDate() ).as(" result.getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(result.getPricePoint().isReserveOnly() ).as(" result.getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getMinSubPeriod() ).as(" result.getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
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
        softly.assertThat(result.getPricePoint().getPricingTextTemplateName1() ).as(" result.getPricePoint().getPricingTextTemplateName1()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getPricingTextTemplateName2() ).as(" result.getPricePoint().getPricingTextTemplateName2()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getTranslatedPricingText1() ).as(" result.getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(result.getPricePoint().getTranslatedPricingText2() ).as(" result.getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(result.getPricePoint().getRecurrenceDay() ).as(" result.getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(result.getPricePoint().isAlignWithExternal() ).as(" result.getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getGracePeriod() ).as(" result.getPricePoint().getGracePeriod()" ).isNull();
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
        softly.assertThat(result.getPricePoint().isTariff() ).as(" result.getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isHideForPurchaseOptions() ).as(" result.getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(result.getPricePoint().getTax().getName() ).as(" result.getPricePoint().getTax().getName()" ).isEqualTo("TAX_1");
//        softly.assertThat(result.getPricePoint().getTax().getKey() ).as(" result.getPricePoint().getTax().getKey()" ).isNull();
////check size of list!
//        softly.assertThat(result.getPricePoint().getTax().getTaxRates().size()).as("result.getPricePoint().getTax().getTaxRates().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getPricePoint().getTax().getTaxRates().size() >= 1);
//        softly.assertThat(result.getPricePoint().getTax().getTaxRates().get(0).value() ).as(" result.getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.185)) ;
//        softly.assertThat(result.getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" result.getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getPricePoint().getTax().getTaxRates().get(0).getEndDate() ).as(" result.getPricePoint().getTax().getTaxRates().get(0).getEndDate()" ).isNull();
//        softly.assertThat(result.getPricePoint().getTax().getTaxRate() ).as(" result.getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.185)) ;
//        softly.assertThat(result.getPricePoint().getTax().getTaxCode() ).as(" result.getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX_1");
//check size of array!
//        softly.assertThat(result.getPricePoint().getBalances().length ).as(" result.getPricePoint().getBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().getName() ).as(" result.getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" result.getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().isToken() ).as(" result.getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" result.getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" result.getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" result.getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().getDescription() ).as(" result.getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" result.getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().isResource() ).as(" result.getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" result.getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getResource().getCode() ).as(" result.getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getBalance() ).as(" result.getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getPackageId() ).as(" result.getPricePoint().getBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(result.getPricePoint().getBalances()[0].getSubscriptionId() ).as(" result.getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(result.getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" result.getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" result.getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(result.getPricePoint().getBalances()[0].getThreshold() ).as(" result.getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getBalances()[0].getSubscription() ).as(" result.getPricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(result.getPricePoint().isRecurring() ).as(" result.getPricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" result.getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(result.getPricePoint().getPricePointTier().getKey() ).as(" result.getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("result.getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" result.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" result.getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" result.getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTier().getPricingModel() ).as(" result.getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTier().getTier() ).as(" result.getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getPricePoint().getPricePointTier().isDefaultPPT() ).as(" result.getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" result.getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().size()).as("result.getPricePoint().getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getPricePoint().getAllBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" result.getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(result.getPricePoint().getPackageIdentifier() ).as(" result.getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pPreSignOn1_TAX_1_2_8_999_999_999_*_*_*_false_false_*");
        softly.assertThat(result.getPricePoint().getServiceIdentifier() ).as(" result.getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pPreSignOn1_TAX_1_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getResourceField().getName() ).as(" result.getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getResourceField().getResourceName() ).as(" result.getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getResourceField().isToken() ).as(" result.getPricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceField().isUsageToken() ).as(" result.getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceField().isPayToken() ).as(" result.getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceField().getResourceSymbol() ).as(" result.getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getResourceField().getDescription() ).as(" result.getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getResourceField().isCurrency() ).as(" result.getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getResourceField().isResource() ).as(" result.getPricePoint().getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getResourceField().getCountryId() ).as(" result.getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getResourceField().getCode() ).as(" result.getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(result.getPricePoint().getStandardRateWithoutTax() ).as(" result.getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(result.getPricePoint().isVolumeType() ).as(" result.getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isOriginal() ).as(" result.getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(result.getPricePoint().getPricePointTiers().length ).as(" result.getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getKey() ).as(" result.getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" result.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" result.getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" result.getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getTier() ).as(" result.getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" result.getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" result.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(result.getPricePoint().getProtectedFk() ).as(" result.getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(result.getPricePoint().getmPricingText1() ).as(" result.getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().getmPricingText2() ).as(" result.getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(result.getPricePoint().isNonRecurring() ).as(" result.getPricePoint().isNonRecurring()" ).isTrue() ;
        softly.assertThat(result.getPricePoint().isEvent() ).as(" result.getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().isPreOrder() ).as(" result.getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(result.getPricePoint().getTaxRate() ).as(" result.getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.185)) ;
        softly.assertThat(result.getPricePoint().getTaxCode() ).as(" result.getPricePoint().getTaxCode()" ).isEqualTo("TAX_1");
        softly.assertThat(result.getPricePoint().getLinkedByTrialPricepoint() ).as(" result.getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
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
        softly.assertThat(result.getPricePoint().getPaymentType() ).as(" result.getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(result.getPricePoint().getEventDateTime() ).as(" result.getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(result.getPricePoint().getEventUnits() ).as(" result.getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getPromoCodes().length ).as(" result.getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(result.getPricePoint().getBearerIds().length ).as(" result.getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(result.getPricePoint().getPromoCode() ).as(" result.getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(result.getPricePoint().getDuration() ).as(" result.getPricePoint().getDuration()" ).isEqualTo(8) ;
        softly.assertThat(result.getPricePoint().getChargingMethod() ).as(" result.getPricePoint().getChargingMethod()" ).isEqualTo(2) ;
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
        softly.assertThat(result.getServiceId() ).as(" result.getServiceId()" ).isEqualTo("c001");

        softly.assertAll();

    }


}
