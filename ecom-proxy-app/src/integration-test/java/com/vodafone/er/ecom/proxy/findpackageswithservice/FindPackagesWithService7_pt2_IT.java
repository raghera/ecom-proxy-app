package com.vodafone.er.ecom.proxy.findpackageswithservice;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ravi Aghera
 */
public class FindPackagesWithService7_pt2_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void findPackagesWithService7() throws Exception {
        final CatalogService catalogService = EcomApiFactory.getCatalogApi(Locale.UK).getService("sAlt");

        final CatalogPackage[] result = EcomApiFactory.getCatalogApi(Locale.UK)
                .findPackagesWithService(catalogService);

        assertNotNull(result);
        assertEquals(result.length, 2);

        CatalogPackage pack =null;
        for(CatalogPackage p : result) {
            if(p.getId().equals("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*")) {
                pack = p;
                break;
            }
        }

        softly.assertThat(pack.getPricePoint().getBalanceImpactList().get(1).isResource() ).as(" pack.getPricePoint().getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getBalanceImpactList().get(1).getFixedAmount() ).as(" pack.getPricePoint().getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getBalanceImpactList().get(1).getScaledAmount() ).as(" pack.getPricePoint().getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold() ).as(" pack.getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getBalanceImpactList().get(1).getPricePoint() ).as(" pack.getPricePoint().getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoint().getGlid() ).as(" pack.getPricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoint().getContentId() ).as(" pack.getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoint().isDiscount() ).as(" pack.getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getStandardRate() ).as(" pack.getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(pack.getPricePoint().getDiscountPromoText() ).as(" pack.getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoint().isPreview() ).as(" pack.getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getInteractiveFlag() ).as(" pack.getPricePoint().getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoint().isForcedPurchase() ).as(" pack.getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isSubscriptionDuplicate() ).as(" pack.getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getFixedExpiryDate() ).as(" pack.getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getMinSubPeriod() ).as(" pack.getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPenaltyCharges() ).as(" pack.getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getCancellation() ).as(" pack.getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getMonthEndSubscription() ).as(" pack.getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoint().getFixedRecurrence() ).as(" pack.getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoint().isFixedRecurringPricePoint() ).as(" pack.getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isReceipting() ).as(" pack.getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getReceiptingAttribute() ).as(" pack.getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(pack.getPricePoint().getOrder() ).as(" pack.getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPaymentHandler() ).as(" pack.getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoint().isSubmitToPaymentHandler() ).as(" pack.getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isSuppressToPaymentHandler() ).as(" pack.getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricingTextTemplateName1() ).as(" pack.getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricingTextTemplateName2() ).as(" pack.getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(pack.getPricePoint().getTranslatedPricingText1() ).as(" pack.getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(pack.getPricePoint().getTranslatedPricingText2() ).as(" pack.getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(pack.getPricePoint().getUsageTime() ).as(" pack.getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoint().getRecurrenceDay() ).as(" pack.getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoint().isAlignWithExternal() ).as(" pack.getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAccessDuration() ).as(" pack.getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getGracePeriod() ).as(" pack.getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(pack.getPricePoint().getRetryFrequency() ).as(" pack.getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(pack.getPricePoint().getSuspensionPeriod() ).as(" pack.getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(pack.getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" pack.getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getTranslatedPricingText() ).as(" pack.getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoint().getFairUsageLimit() ).as(" pack.getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoint().getFairUsagePeriod() ).as(" pack.getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoint().getFairUsagePeriodUnit() ).as(" pack.getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(pack.getPricePoint().getExtensionPeriod() ).as(" pack.getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().isIncludeServiceForPackageFUP() ).as(" pack.getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isFairUsagePolicyEnabled() ).as(" pack.getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isTariff() ).as(" pack.getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isHideForPurchaseOptions() ).as(" pack.getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
//check size of array!
//        softly.assertThat(pack.getPricePoint().getResourceBalances().length ).as(" pack.getPricePoint().getResourceBalances().length" ).isEqualTo(2) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getBalance() ).as(" pack.getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getThreshold() ).as(" pack.getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getSubscription() ).as(" pack.getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getPackageId() ).as(" pack.getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(pack.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//check size of array!
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances().length ).as(" pack.getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(pack.getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoint().isAlwaysValidateMsisdn() ).as(" pack.getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
//check size of array!
//        softly.assertThat(pack.getPricePoint().getBalances().length ).as(" pack.getPricePoint().getBalances().length" ).isEqualTo(2) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().getName() ).as(" pack.getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().isResource() ).as(" pack.getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().getDescription() ).as(" pack.getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().getCode() ).as(" pack.getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().isToken() ).as(" pack.getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getBalance() ).as(" pack.getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getThreshold() ).as(" pack.getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getSubscription() ).as(" pack.getPricePoint().getBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getPackageId() ).as(" pack.getPricePoint().getBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getSubscriptionId() ).as(" pack.getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(pack.getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" pack.getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(pack.getPricePoint().getPricePointTier().getKey() ).as(" pack.getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("pack.getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" pack.getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" pack.getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getPricingModel() ).as(" pack.getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTier().getTier() ).as(" pack.getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoint().getPricePointTier().isDefaultPPT() ).as(" pack.getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" pack.getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getPricePoint().getResourceField().getName() ).as(" pack.getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
//        softly.assertThat(pack.getPricePoint().getResourceField().isCurrency() ).as(" pack.getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
//        softly.assertThat(pack.getPricePoint().getResourceField().isResource() ).as(" pack.getPricePoint().getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceField().getDescription() ).as(" pack.getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(pack.getPricePoint().getResourceField().getCode() ).as(" pack.getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(pack.getPricePoint().getResourceField().getCountryId() ).as(" pack.getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoint().getResourceField().isToken() ).as(" pack.getPricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceField().isUsageToken() ).as(" pack.getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceField().isPayToken() ).as(" pack.getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoint().getResourceField().getResourceName() ).as(" pack.getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(pack.getPricePoint().getResourceField().getResourceSymbol() ).as(" pack.getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoint().getStandardRateWithoutTax() ).as(" pack.getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().isVolumeType() ).as(" pack.getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isOriginal() ).as(" pack.getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoint().getPricePointTiers().length ).as(" pack.getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getKey() ).as(" pack.getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" pack.getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" pack.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" pack.getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getTier() ).as(" pack.getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" pack.getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" pack.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(pack.getPricePoint().getProtectedFk() ).as(" pack.getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(pack.getPricePoint().getmPricingText1() ).as(" pack.getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoint().getmPricingText2() ).as(" pack.getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoint().isNonRecurring() ).as(" pack.getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isEvent() ).as(" pack.getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isActive() ).as(" pack.getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().isPreOrder() ).as(" pack.getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getTaxRate() ).as(" pack.getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(pack.getPricePoint().getTaxCode() ).as(" pack.getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getPricePoint().getLinkedByTrialPricepoint() ).as(" pack.getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(pack.getPricePoint().getTax().getName() ).as(" pack.getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(pack.getPricePoint().getTax().getKey() ).as(" pack.getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRate() ).as(" pack.getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoint().getTax().getTaxCode() ).as(" pack.getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().size()).as("pack.getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(pack.getPricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().get(0).value() ).as(" pack.getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" pack.getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().get(1).value() ).as(" pack.getPricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" pack.getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().get(2).value() ).as(" pack.getPricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" pack.getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoint().getDescription() ).as(" pack.getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(pack.getPricePoint().isReserveOnly() ).as(" pack.getPricePoint().isReserveOnly()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.getPricePoint().getPricingText1() ).as(" pack.getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoint().getPricingText2() ).as(" pack.getPricePoint().getPricingText2()" ).isNullOrEmpty();
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getPricePoint().getPackageId() ).as(" pack.getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(pack.getPricePoint().isTrial() ).as(" pack.getPricePoint().isTrial()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoint().getNonMatchAllUserGroups().length ).as(" pack.getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().isRecurring() ).as(" pack.getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getPricepointIdLink() ).as(" pack.getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(pack.getPricePoint().isPromo() ).as(" pack.getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAccessDevice() ).as(" pack.getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
//check size of list!
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().size()).as("pack.getPricePoint().getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoint().getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getId() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getType() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getAllBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoint().getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoint().getServiceIdentifier() ).as(" pack.getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
        softly.assertThat(pack.getPricePoint().getPackageIdentifier() ).as(" pack.getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(pack.getPricePoint().isHistoric() ).as(" pack.getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getStartDate() ).as(" pack.getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getExpiryDate() ).as(" pack.getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getChannel() ).as(" pack.getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoint().getMultiUsageMode() ).as(" pack.getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getNetworkCodeMatchMethod() ).as(" pack.getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoint().isPreRatePriceGross() ).as(" pack.getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getPreRate() ).as(" pack.getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoint().getPaymentInformation() ).as(" pack.getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(pack.getPricePoint().getContentName() ).as(" pack.getPricePoint().getContentName()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAssetID() ).as(" pack.getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPremiumLevel() ).as(" pack.getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoint().getReserveOnlyFlag() ).as(" pack.getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoint().getSupplierId() ).as(" pack.getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoint().getDeviceType() ).as(" pack.getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(pack.getPricePoint().getUserGroups().length ).as(" pack.getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoint().getUserGroup() ).as(" pack.getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoint().getPaymentType() ).as(" pack.getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoint().getEventDateTime() ).as(" pack.getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(pack.getPricePoint().getEventUnits() ).as(" pack.getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(pack.getPricePoint().getPromoCodes().length ).as(" pack.getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(pack.getPricePoint().getBearerIds().length ).as(" pack.getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoint().getPromoCode() ).as(" pack.getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoint().getDuration() ).as(" pack.getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoint().getChargingMethod() ).as(" pack.getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(pack.getPricePoint().getBearer() ).as(" pack.getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoint().isInteractive() ).as(" pack.getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(pack.getPricePoint().isIncludeUnavailable() ).as(" pack.getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getExpressFlag() ).as(" pack.getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isExpressFlag() ).as(" pack.getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isCancellationUsage() ).as(" pack.getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getTierName() ).as(" pack.getPricePoint().getTierName()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPromoPrecode() ).as(" pack.getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(pack.getPricePoint().getUniquePromoCode() ).as(" pack.getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPromoUniqueCode() ).as(" pack.getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(pack.getPricePoint().getNextCycleDiscount() ).as(" pack.getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoint().getHasHistoricPricePointFlag() ).as(" pack.getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isIsForRenewal() ).as(" pack.getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getTaxRateAsDouble() ).as(" pack.getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAffiliateID() ).as(" pack.getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPartnerId() ).as(" pack.getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(pack.getPricePoint().getTariff() ).as(" pack.getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoint().getAggregatorId() ).as(" pack.getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(pack.getPricePoint().isForcePurchaseFlow() ).as(" pack.getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getReceipientMsisdn() ).as(" pack.getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoint().getProductCode() ).as(" pack.getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(pack.getPricePoint().getMerchantName() ).as(" pack.getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(pack.getPricePoint().getInvoiceText() ).as(" pack.getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(pack.getPricePoint().isReIssueEnabled() ).as(" pack.getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isReIssueFlagPresent() ).as(" pack.getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getShortPackageId() ).as(" pack.getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoint().getHistoryStartDate() ).as(" pack.getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoint().getVendorId() ).as(" pack.getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(pack.getPricePoint().isIsForNextPaymentAmount() ).as(" pack.getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getRenewalPreRate() ).as(" pack.getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoint().isOverrideDisallowPreRateFlag() ).as(" pack.getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getContentCategory() ).as(" pack.getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPartnerUrl() ).as(" pack.getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPartnerContactInfo() ).as(" pack.getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPartnerEmail() ).as(" pack.getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPartnerName() ).as(" pack.getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(pack.getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoint().getSubRenewalPricepointId() ).as(" pack.getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoint().getLinkPricepointId() ).as(" pack.getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoint().getSubPurchaseTransactionTrial() ).as(" pack.getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" pack.getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" pack.getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoint().getExtIdentifier1() ).as(" pack.getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(pack.getPricePoint().getExtIdentifier2() ).as(" pack.getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(pack.getPricePoint().getExtIdentifier3() ).as(" pack.getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(pack.getPricePoint().getAccessChannel() ).as(" pack.getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(pack.getPricePoint().getPurchaseChannel() ).as(" pack.getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(pack.getPricePoint().getDeviceID() ).as(" pack.getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(pack.getPricePoint().getLocal() ).as(" pack.getPricePoint().getLocal()" ).isNull();
        softly.assertThat(pack.getPricePoint().getMsisdn() ).as(" pack.getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoint().getLanguageLocale() ).as(" pack.getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(pack.getPricePoint().getLanguageCode() ).as(" pack.getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(pack.getPricePoint().getExternalField1() ).as(" pack.getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(pack.getPricePoint().getExternalField2() ).as(" pack.getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(pack.getPricePoint().getExternalTransId() ).as(" pack.getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(pack.getPricePoint().getActiveSubscriptions() ).as(" pack.getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(pack.getPricePoint().getCsrId() ).as(" pack.getPricePoint().getCsrId()" ).isNull();
// java.util.HashMap
        softly.assertThat(pack.getNonRefundableDescription() ).as(" pack.getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(pack.isRefundable() ).as(" pack.isRefundable()" ).isFalse() ;
//check size of list!
        softly.assertThat(pack.getPricePoints().size()).as("pack.getPricePoints().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().size() >= 3);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getResource().getName() ).as(" pack.getPricePoints().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getKey() ).as(" pack.getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getId() ).as(" pack.getPricePoints().get(0).getId()" ).isEqualTo("package:pAlt_TAX_2_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(pack.getPricePoints().get(0).isZeroCostIgnore() ).as(" pack.getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricingModelTier() ).as(" pack.getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).isArchived() ).as(" pack.getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isBasePricePoint() ).as(" pack.getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getRate() ).as(" pack.getPricePoints().get(0).getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(pack.getPricePoints().get(0).getNetRate() ).as(" pack.getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getAlternativeRate() ).as(" pack.getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts().length ).as(" pack.getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" pack.getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//check size of list!
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().size()).as("pack.getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(0).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" pack.getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getGlid() ).as(" pack.getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).getContentId() ).as(" pack.getPricePoints().get(0).getContentId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(0).isDiscount() ).as(" pack.getPricePoints().get(0).isDiscount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getStandardRate() ).as(" pack.getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(pack.getPricePoints().get(0).getDiscountPromoText() ).as(" pack.getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).isPreview() ).as(" pack.getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getInteractiveFlag() ).as(" pack.getPricePoints().get(0).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(pack.getPricePoints().get(0).isForcedPurchase() ).as(" pack.getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isSubscriptionDuplicate() ).as(" pack.getPricePoints().get(0).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getFixedExpiryDate() ).as(" pack.getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getMinSubPeriod() ).as(" pack.getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getPenaltyCharges() ).as(" pack.getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getCancellation() ).as(" pack.getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getMonthEndSubscription() ).as(" pack.getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(0).getFixedRecurrence() ).as(" pack.getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" pack.getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isReceipting() ).as(" pack.getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getReceiptingAttribute() ).as(" pack.getPricePoints().get(0).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(0).getOrder() ).as(" pack.getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getPaymentHandler() ).as(" pack.getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" pack.getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" pack.getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricingTextTemplateName1() ).as(" pack.getPricePoints().get(0).getPricingTextTemplateName1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).getPricingTextTemplateName2() ).as(" pack.getPricePoints().get(0).getPricingTextTemplateName2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).getTranslatedPricingText1() ).as(" pack.getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getTranslatedPricingText2() ).as(" pack.getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getUsageTime() ).as(" pack.getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getRecurrenceDay() ).as(" pack.getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(0).isAlignWithExternal() ).as(" pack.getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAccessDuration() ).as(" pack.getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getGracePeriod() ).as(" pack.getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getRetryFrequency() ).as(" pack.getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getSuspensionPeriod() ).as(" pack.getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" pack.getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getTranslatedPricingText() ).as(" pack.getPricePoints().get(0).getTranslatedPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getFairUsageLimit() ).as(" pack.getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(0).getFairUsagePeriod() ).as(" pack.getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" pack.getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(pack.getPricePoints().get(0).getExtensionPeriod() ).as(" pack.getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" pack.getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" pack.getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isTariff() ).as(" pack.getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isHideForPurchaseOptions() ).as(" pack.getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances().length ).as(" pack.getPricePoints().get(0).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getCustomResourceBalances() ).as(" pack.getPricePoints().get(0).getCustomResourceBalances()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" pack.getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getBalances().length ).as(" pack.getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getBalance() ).as(" pack.getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" pack.getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getKey() ).as(" pack.getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getPromotionalPrice() ).as(" pack.getPricePoints().get(0).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getPromotionalPricingText() ).as(" pack.getPricePoints().get(0).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getPricingModel() ).as(" pack.getPricePoints().get(0).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getTier() ).as(" pack.getPricePoints().get(0).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().isDefaultPPT() ).as(" pack.getPricePoints().get(0).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" pack.getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().getName() ).as(" pack.getPricePoints().get(0).getResourceField().getName()" ).isEqualTo("GBP");
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().isCurrency() ).as(" pack.getPricePoints().get(0).getResourceField().isCurrency()" ).isTrue() ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().isResource() ).as(" pack.getPricePoints().get(0).getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().getDescription() ).as(" pack.getPricePoints().get(0).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().getCode() ).as(" pack.getPricePoints().get(0).getResourceField().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().getCountryId() ).as(" pack.getPricePoints().get(0).getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().isToken() ).as(" pack.getPricePoints().get(0).getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().isUsageToken() ).as(" pack.getPricePoints().get(0).getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().isPayToken() ).as(" pack.getPricePoints().get(0).getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().getResourceName() ).as(" pack.getPricePoints().get(0).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(pack.getPricePoints().get(0).getResourceField().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getStandardRateWithoutTax() ).as(" pack.getPricePoints().get(0).getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).isVolumeType() ).as(" pack.getPricePoints().get(0).isVolumeType()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isOriginal() ).as(" pack.getPricePoints().get(0).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers().length ).as(" pack.getPricePoints().get(0).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getKey() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()).as("pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getPricingModel() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getTier() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" pack.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getProtectedFk() ).as(" pack.getPricePoints().get(0).getProtectedFk()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getmPricingText1() ).as(" pack.getPricePoints().get(0).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).getmPricingText2() ).as(" pack.getPricePoints().get(0).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).isNonRecurring() ).as(" pack.getPricePoints().get(0).isNonRecurring()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).isEvent() ).as(" pack.getPricePoints().get(0).isEvent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isActive() ).as(" pack.getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).isPreOrder() ).as(" pack.getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getTaxRate() ).as(" pack.getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(pack.getPricePoints().get(0).getTaxCode() ).as(" pack.getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" pack.getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getName() ).as(" pack.getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getKey() ).as(" pack.getPricePoints().get(0).getTax().getKey()" ).isNull();
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRate() ).as(" pack.getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxCode() ).as(" pack.getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().size()).as("pack.getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(pack.getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().get(0).value() ).as(" pack.getPricePoints().get(0).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" pack.getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().get(1).value() ).as(" pack.getPricePoints().get(0).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" pack.getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().get(2).value() ).as(" pack.getPricePoints().get(0).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" pack.getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getDescription() ).as(" pack.getPricePoints().get(0).getDescription()" ).isEqualTo("Non-recurring 7 day");
        softly.assertThat(pack.getPricePoints().get(0).isReserveOnly() ).as(" pack.getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.getPricePoints().get(0).getPricingText1() ).as(" pack.getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).getPricingText2() ).as(" pack.getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getPricePoints().get(0).getPackageId() ).as(" pack.getPricePoints().get(0).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(pack.getPricePoints().get(0).isTrial() ).as(" pack.getPricePoints().get(0).isTrial()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" pack.getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).isRecurring() ).as(" pack.getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPricepointIdLink() ).as(" pack.getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(0).isPromo() ).as(" pack.getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAccessDevice() ).as(" pack.getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
//check size of list!
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().size()).as("pack.getPricePoints().get(0).getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(0).getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getServiceIdentifier() ).as(" pack.getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
        softly.assertThat(pack.getPricePoints().get(0).getPackageIdentifier() ).as(" pack.getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_2_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(pack.getPricePoints().get(0).isHistoric() ).as(" pack.getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getChannel() ).as(" pack.getPricePoints().get(0).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(0).getMultiUsageMode() ).as(" pack.getPricePoints().get(0).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getNetworkCodeMatchMethod() ).as(" pack.getPricePoints().get(0).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(0).isPreRatePriceGross() ).as(" pack.getPricePoints().get(0).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getPreRate() ).as(" pack.getPricePoints().get(0).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getPaymentInformation() ).as(" pack.getPricePoints().get(0).getPaymentInformation()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getContentName() ).as(" pack.getPricePoints().get(0).getContentName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getAssetID() ).as(" pack.getPricePoints().get(0).getAssetID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPremiumLevel() ).as(" pack.getPricePoints().get(0).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(0).getReserveOnlyFlag() ).as(" pack.getPricePoints().get(0).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(0).getSupplierId() ).as(" pack.getPricePoints().get(0).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(0).getDeviceType() ).as(" pack.getPricePoints().get(0).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getUserGroups().length ).as(" pack.getPricePoints().get(0).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(0).getUserGroup() ).as(" pack.getPricePoints().get(0).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(0).getPaymentType() ).as(" pack.getPricePoints().get(0).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(0).getEventDateTime() ).as(" pack.getPricePoints().get(0).getEventDateTime()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getEventUnits() ).as(" pack.getPricePoints().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getPromoCodes().length ).as(" pack.getPricePoints().get(0).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(0).getBearerIds().length ).as(" pack.getPricePoints().get(0).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(0).getPromoCode() ).as(" pack.getPricePoints().get(0).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(0).getDuration() ).as(" pack.getPricePoints().get(0).getDuration()" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoints().get(0).getChargingMethod() ).as(" pack.getPricePoints().get(0).getChargingMethod()" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoints().get(0).getBearer() ).as(" pack.getPricePoints().get(0).getBearer()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(0).isInteractive() ).as(" pack.getPricePoints().get(0).isInteractive()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(0).isIncludeUnavailable() ).as(" pack.getPricePoints().get(0).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getExpressFlag() ).as(" pack.getPricePoints().get(0).getExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isExpressFlag() ).as(" pack.getPricePoints().get(0).isExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isCancellationUsage() ).as(" pack.getPricePoints().get(0).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getTierName() ).as(" pack.getPricePoints().get(0).getTierName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPromoPrecode() ).as(" pack.getPricePoints().get(0).getPromoPrecode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getUniquePromoCode() ).as(" pack.getPricePoints().get(0).getUniquePromoCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPromoUniqueCode() ).as(" pack.getPricePoints().get(0).getPromoUniqueCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getNextCycleDiscount() ).as(" pack.getPricePoints().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).getHasHistoricPricePointFlag() ).as(" pack.getPricePoints().get(0).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isIsForRenewal() ).as(" pack.getPricePoints().get(0).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getTaxRateAsDouble() ).as(" pack.getPricePoints().get(0).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getAffiliateID() ).as(" pack.getPricePoints().get(0).getAffiliateID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPartnerId() ).as(" pack.getPricePoints().get(0).getPartnerId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getTariff() ).as(" pack.getPricePoints().get(0).getTariff()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(0).getAggregatorId() ).as(" pack.getPricePoints().get(0).getAggregatorId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).isForcePurchaseFlow() ).as(" pack.getPricePoints().get(0).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getReceipientMsisdn() ).as(" pack.getPricePoints().get(0).getReceipientMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getProductCode() ).as(" pack.getPricePoints().get(0).getProductCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getMerchantName() ).as(" pack.getPricePoints().get(0).getMerchantName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getInvoiceText() ).as(" pack.getPricePoints().get(0).getInvoiceText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).isReIssueEnabled() ).as(" pack.getPricePoints().get(0).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isReIssueFlagPresent() ).as(" pack.getPricePoints().get(0).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getShortPackageId() ).as(" pack.getPricePoints().get(0).getShortPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getHistoryStartDate() ).as(" pack.getPricePoints().get(0).getHistoryStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getVendorId() ).as(" pack.getPricePoints().get(0).getVendorId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).isIsForNextPaymentAmount() ).as(" pack.getPricePoints().get(0).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getRenewalPreRate() ).as(" pack.getPricePoints().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(0).isOverrideDisallowPreRateFlag() ).as(" pack.getPricePoints().get(0).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getContentCategory() ).as(" pack.getPricePoints().get(0).getContentCategory()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPartnerUrl() ).as(" pack.getPricePoints().get(0).getPartnerUrl()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPartnerContactInfo() ).as(" pack.getPricePoints().get(0).getPartnerContactInfo()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPartnerEmail() ).as(" pack.getPricePoints().get(0).getPartnerEmail()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPartnerName() ).as(" pack.getPricePoints().get(0).getPartnerName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(0).getSubRenewalPricepointId() ).as(" pack.getPricePoints().get(0).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getLinkPricepointId() ).as(" pack.getPricePoints().get(0).getLinkPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getSubPurchaseTransactionTrial() ).as(" pack.getPricePoints().get(0).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getDiscardHiddenInactivePricepoints() ).as(" pack.getPricePoints().get(0).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints() ).as(" pack.getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(0).getExtIdentifier1() ).as(" pack.getPricePoints().get(0).getExtIdentifier1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getExtIdentifier2() ).as(" pack.getPricePoints().get(0).getExtIdentifier2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getExtIdentifier3() ).as(" pack.getPricePoints().get(0).getExtIdentifier3()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getAccessChannel() ).as(" pack.getPricePoints().get(0).getAccessChannel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getPurchaseChannel() ).as(" pack.getPricePoints().get(0).getPurchaseChannel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getDeviceID() ).as(" pack.getPricePoints().get(0).getDeviceID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getLocal() ).as(" pack.getPricePoints().get(0).getLocal()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getMsisdn() ).as(" pack.getPricePoints().get(0).getMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getLanguageLocale() ).as(" pack.getPricePoints().get(0).getLanguageLocale()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getLanguageCode() ).as(" pack.getPricePoints().get(0).getLanguageCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getExternalField1() ).as(" pack.getPricePoints().get(0).getExternalField1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getExternalField2() ).as(" pack.getPricePoints().get(0).getExternalField2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getExternalTransId() ).as(" pack.getPricePoints().get(0).getExternalTransId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getActiveSubscriptions() ).as(" pack.getPricePoints().get(0).getActiveSubscriptions()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(0).getCsrId() ).as(" pack.getPricePoints().get(0).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getResource().getName() ).as(" pack.getPricePoints().get(1).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(1).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(1).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(1).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(1).getKey() ).as(" pack.getPricePoints().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getId() ).as(" pack.getPricePoints().get(1).getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(pack.getPricePoints().get(1).isZeroCostIgnore() ).as(" pack.getPricePoints().get(1).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricingModelTier() ).as(" pack.getPricePoints().get(1).getPricingModelTier()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).isArchived() ).as(" pack.getPricePoints().get(1).isArchived()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isBasePricePoint() ).as(" pack.getPricePoints().get(1).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getRate() ).as(" pack.getPricePoints().get(1).getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(pack.getPricePoints().get(1).getNetRate() ).as(" pack.getPricePoints().get(1).getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getAlternativeRate() ).as(" pack.getPricePoints().get(1).getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts().length ).as(" pack.getPricePoints().get(1).getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].getName() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].isCurrency() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].isResource() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].getDescription() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].getCode() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].getCountryId() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].isToken() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].isPayToken() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].getResourceName() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol() ).as(" pack.getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//check size of list!
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().size()).as("pack.getPricePoints().get(1).getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(1).getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getName() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getKey() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getId() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getType() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getRate() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).isResource() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getName() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getKey() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getId() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getType() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getRate() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).isCurrency() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).isResource() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getFixedAmount() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getScaledAmount() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getNotificationThreshold() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalanceImpactList().get(1).getPricePoint() ).as(" pack.getPricePoints().get(1).getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getGlid() ).as(" pack.getPricePoints().get(1).getGlid()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(1).getContentId() ).as(" pack.getPricePoints().get(1).getContentId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(1).isDiscount() ).as(" pack.getPricePoints().get(1).isDiscount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getStandardRate() ).as(" pack.getPricePoints().get(1).getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(pack.getPricePoints().get(1).getDiscountPromoText() ).as(" pack.getPricePoints().get(1).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(1).isPreview() ).as(" pack.getPricePoints().get(1).isPreview()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getInteractiveFlag() ).as(" pack.getPricePoints().get(1).getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(1).isForcedPurchase() ).as(" pack.getPricePoints().get(1).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isSubscriptionDuplicate() ).as(" pack.getPricePoints().get(1).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getFixedExpiryDate() ).as(" pack.getPricePoints().get(1).getFixedExpiryDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getMinSubPeriod() ).as(" pack.getPricePoints().get(1).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getPenaltyCharges() ).as(" pack.getPricePoints().get(1).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getCancellation() ).as(" pack.getPricePoints().get(1).getCancellation()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getMonthEndSubscription() ).as(" pack.getPricePoints().get(1).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(1).getFixedRecurrence() ).as(" pack.getPricePoints().get(1).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(1).isFixedRecurringPricePoint() ).as(" pack.getPricePoints().get(1).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isReceipting() ).as(" pack.getPricePoints().get(1).isReceipting()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getReceiptingAttribute() ).as(" pack.getPricePoints().get(1).getReceiptingAttribute()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getOrder() ).as(" pack.getPricePoints().get(1).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getPaymentHandler() ).as(" pack.getPricePoints().get(1).getPaymentHandler()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(1).isSubmitToPaymentHandler() ).as(" pack.getPricePoints().get(1).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isSuppressToPaymentHandler() ).as(" pack.getPricePoints().get(1).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricingTextTemplateName1() ).as(" pack.getPricePoints().get(1).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricingTextTemplateName2() ).as(" pack.getPricePoints().get(1).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getTranslatedPricingText1() ).as(" pack.getPricePoints().get(1).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getTranslatedPricingText2() ).as(" pack.getPricePoints().get(1).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getUsageTime() ).as(" pack.getPricePoints().get(1).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getRecurrenceDay() ).as(" pack.getPricePoints().get(1).getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(1).isAlignWithExternal() ).as(" pack.getPricePoints().get(1).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getAccessDuration() ).as(" pack.getPricePoints().get(1).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getGracePeriod() ).as(" pack.getPricePoints().get(1).getGracePeriod()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getRetryFrequency() ).as(" pack.getPricePoints().get(1).getRetryFrequency()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getSuspensionPeriod() ).as(" pack.getPricePoints().get(1).getSuspensionPeriod()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined() ).as(" pack.getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getTranslatedPricingText() ).as(" pack.getPricePoints().get(1).getTranslatedPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getFairUsageLimit() ).as(" pack.getPricePoints().get(1).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(1).getFairUsagePeriod() ).as(" pack.getPricePoints().get(1).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(1).getFairUsagePeriodUnit() ).as(" pack.getPricePoints().get(1).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(pack.getPricePoints().get(1).getExtensionPeriod() ).as(" pack.getPricePoints().get(1).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).isIncludeServiceForPackageFUP() ).as(" pack.getPricePoints().get(1).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isFairUsagePolicyEnabled() ).as(" pack.getPricePoints().get(1).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isTariff() ).as(" pack.getPricePoints().get(1).isTariff()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isHideForPurchaseOptions() ).as(" pack.getPricePoints().get(1).isHideForPurchaseOptions()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances().length ).as(" pack.getPricePoints().get(1).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getBalance() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances().length ).as(" pack.getPricePoints().get(1).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getBalance() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).isAlwaysValidateMsisdn() ).as(" pack.getPricePoints().get(1).isAlwaysValidateMsisdn()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getBalances().length ).as(" pack.getPricePoints().get(1).getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }

    }


}
