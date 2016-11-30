package com.vodafone.er.ecom.proxy.usageAuthRate;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 *
 * UsageAuthRateCharge with a UsageAuthorisation response
 * Split into parts since the test is so long!
 */
public class UsageAuthRate2_pt1_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageAuthRate2() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false";
//
//        //Purchase
        final PurchaseAuthorization purchaseAuthorization = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(purchaseAuthorization);
        assertTrue("Auth response is false", purchaseAuthorization.isSuccess());

        final UsageAuthorization auth = EcomApiFactory.getChargingApi(Locale.UK)
                .usageAuthRate(CLIENT_ID.value(), msisdn, "B001", new UsageAttributes());
        assertNotNull(auth);
        assertTrue(auth.isSuccess());


        softly.assertThat(auth.getIsPreordered() ).as(" auth.getIsPreordered()" ).isEqualTo(0) ;
        softly.assertThat(auth.isFirstUsage() ).as(" auth.isFirstUsage()" ).isFalse() ;
        softly.assertThat(auth.getEventUnits() ).as(" auth.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getIsValidatedAccount() ).as(" auth.getIsValidatedAccount()" ).isNull();
        softly.assertThat(auth.getSubscriptionStatus() ).as(" auth.getSubscriptionStatus()" ).isEqualTo(1) ;
        softly.assertThat(auth.isSuccessfulExpressPurchase() ).as(" auth.isSuccessfulExpressPurchase()" ).isFalse() ;
        softly.assertThat(auth.getSubResourceBalances() ).as(" auth.getSubResourceBalances()" ).isNull();
        softly.assertThat(auth.isBasedOnMultiplePackages() ).as(" auth.isBasedOnMultiplePackages()" ).isFalse() ;
        softly.assertThat(auth.getParentTransactionId() ).as(" auth.getParentTransactionId()" ).isNull();
        softly.assertThat(auth.getParentTransactionIdLong() ).as(" auth.getParentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getReIssue() ).as(" auth.getReIssue()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getServicePricePoint().getResource().getName() ).as(" auth.getServicePricePoint().getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getServicePricePoint().getResource().isCurrency() ).as(" auth.getServicePricePoint().getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResource().isResource() ).as(" auth.getServicePricePoint().getResource().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getServicePricePoint().getResource().getCountryId() ).as(" auth.getServicePricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getServicePricePoint().getResource().getResourceName() ).as(" auth.getServicePricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getServicePricePoint().getResource().getCode() ).as(" auth.getServicePricePoint().getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getServicePricePoint().getResource().getDescription() ).as(" auth.getServicePricePoint().getResource().getDescription()" ).isNull();
//        softly.assertThat(auth.getServicePricePoint().getResource().isToken() ).as(" auth.getServicePricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResource().isUsageToken() ).as(" auth.getServicePricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResource().isPayToken() ).as(" auth.getServicePricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getKey() ).as(" auth.getServicePricePoint().getKey()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getId() ).as(" auth.getServicePricePoint().getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(auth.getServicePricePoint().getPricingModelTier() ).as(" auth.getServicePricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isArchived() ).as(" auth.getServicePricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isBasePricePoint() ).as(" auth.getServicePricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getAccessDevice() ).as(" auth.getServicePricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getServicePricePoint().getAlternativeRate() ).as(" auth.getServicePricePoint().getAlternativeRate()" ).isEqualTo(new Double(1.0)) ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts().length ).as(" auth.getServicePricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].getName() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].isCurrency() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].isResource() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].getCountryId() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].getResourceName() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].getCode() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].getDescription() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].isToken() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].isPayToken() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getServicePricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//check size of list!
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().size()).as("auth.getServicePricePoint().getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getServicePricePoint().getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getKey() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getId() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getType() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).isResource() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getRate() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" auth.getServicePricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().isTrial() ).as(" auth.getServicePricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getGlid() ).as(" auth.getServicePricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getServicePricePoint().getPricepointIdLink() ).as(" auth.getServicePricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().isPreview() ).as(" auth.getServicePricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getInteractiveFlag() ).as(" auth.getServicePricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(auth.getServicePricePoint().isForcedPurchase() ).as(" auth.getServicePricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isSubscriptionDuplicate() ).as(" auth.getServicePricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getFixedExpiryDate() ).as(" auth.getServicePricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isReserveOnly() ).as(" auth.getServicePricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getMinSubPeriod() ).as(" auth.getServicePricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPenaltyCharges() ).as(" auth.getServicePricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().getCancellation() ).as(" auth.getServicePricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getMonthEndSubscription() ).as(" auth.getServicePricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(auth.getServicePricePoint().isHistoric() ).as(" auth.getServicePricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getFixedRecurrence() ).as(" auth.getServicePricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getServicePricePoint().isFixedRecurringPricePoint() ).as(" auth.getServicePricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isReceipting() ).as(" auth.getServicePricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getReceiptingAttribute() ).as(" auth.getServicePricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getOrder() ).as(" auth.getServicePricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPaymentHandler() ).as(" auth.getServicePricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getNonMatchAllUserGroups().length ).as(" auth.getServicePricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().isPromo() ).as(" auth.getServicePricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isSubmitToPaymentHandler() ).as(" auth.getServicePricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isSuppressToPaymentHandler() ).as(" auth.getServicePricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricingTextTemplateName1() ).as(" auth.getServicePricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricingTextTemplateName2() ).as(" auth.getServicePricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getTranslatedPricingText1() ).as(" auth.getServicePricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getTranslatedPricingText2() ).as(" auth.getServicePricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getRecurrenceDay() ).as(" auth.getServicePricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getServicePricePoint().isAlignWithExternal() ).as(" auth.getServicePricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getGracePeriod() ).as(" auth.getServicePricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getRetryFrequency() ).as(" auth.getServicePricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getSuspensionPeriod() ).as(" auth.getServicePricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" auth.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getTranslatedPricingText() ).as(" auth.getServicePricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().getFairUsageLimit() ).as(" auth.getServicePricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getServicePricePoint().getFairUsagePeriod() ).as(" auth.getServicePricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getServicePricePoint().getFairUsagePeriodUnit() ).as(" auth.getServicePricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(auth.getServicePricePoint().getExtensionPeriod() ).as(" auth.getServicePricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().isIncludeServiceForPackageFUP() ).as(" auth.getServicePricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isFairUsagePolicyEnabled() ).as(" auth.getServicePricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isTariff() ).as(" auth.getServicePricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isHideForPurchaseOptions() ).as(" auth.getServicePricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(auth.getServicePricePoint().getTax().getName() ).as(" auth.getServicePricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(auth.getServicePricePoint().getTax().getKey() ).as(" auth.getServicePricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRate() ).as(" auth.getServicePricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxCode() ).as(" auth.getServicePricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().size()).as("auth.getServicePricePoint().getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(auth.getServicePricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().get(0).value() ).as(" auth.getServicePricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().get(0).getKey() ).as(" auth.getServicePricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().get(1).value() ).as(" auth.getServicePricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().get(1).getKey() ).as(" auth.getServicePricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().get(2).value() ).as(" auth.getServicePricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getServicePricePoint().getTax().getTaxRates().get(2).getKey() ).as(" auth.getServicePricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getBalances().length ).as(" auth.getServicePricePoint().getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().getName() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().isCurrency() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().isResource() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().getCountryId() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().getResourceName() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().getCode() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().getDescription() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().isToken() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().isUsageToken() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().isPayToken() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getSubscriptionId() ).as(" auth.getServicePricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" auth.getServicePricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" auth.getServicePricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getThreshold() ).as(" auth.getServicePricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getSubscription() ).as(" auth.getServicePricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getBalance() ).as(" auth.getServicePricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getBalances()[0].getPackageId() ).as(" auth.getServicePricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isRecurring() ).as(" auth.getServicePricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getRenewalsUntilLinkedPricepoint() ).as(" auth.getServicePricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getKey() ).as(" auth.getServicePricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()).as("auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getPromotionalPrice() ).as(" auth.getServicePricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getPromotionalPricingText() ).as(" auth.getServicePricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getPricingModel() ).as(" auth.getServicePricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getTier() ).as(" auth.getServicePricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().isDefaultPPT() ).as(" auth.getServicePricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().size()).as("auth.getServicePricePoint().getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getServicePricePoint().getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getId() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getType() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getServicePricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPackageIdentifier() ).as(" auth.getServicePricePoint().getPackageIdentifier()" ).isEqualTo("package:BP001_null_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(auth.getServicePricePoint().getServiceIdentifier() ).as(" auth.getServicePricePoint().getServiceIdentifier()" ).isEqualTo("content:BP001_null_B001_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getServicePricePoint().getResourceField().getName() ).as(" auth.getServicePricePoint().getResourceField().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getServicePricePoint().getResourceField().isCurrency() ).as(" auth.getServicePricePoint().getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().isResource() ).as(" auth.getServicePricePoint().getResourceField().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().getCountryId() ).as(" auth.getServicePricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().getResourceName() ).as(" auth.getServicePricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getServicePricePoint().getResourceField().getCode() ).as(" auth.getServicePricePoint().getResourceField().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().getDescription() ).as(" auth.getServicePricePoint().getResourceField().getDescription()" ).isNull();
//        softly.assertThat(auth.getServicePricePoint().getResourceField().isToken() ).as(" auth.getServicePricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().isUsageToken() ).as(" auth.getServicePricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().isPayToken() ).as(" auth.getServicePricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getServicePricePoint().getResourceField().getResourceSymbol() ).as(" auth.getServicePricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getStandardRateWithoutTax() ).as(" auth.getServicePricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().isVolumeType() ).as(" auth.getServicePricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isOriginal() ).as(" auth.getServicePricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers().length ).as(" auth.getServicePricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getKey() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getPricingModel() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getTier() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" auth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getProtectedFk() ).as(" auth.getServicePricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getmPricingText1() ).as(" auth.getServicePricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().getmPricingText2() ).as(" auth.getServicePricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().isNonRecurring() ).as(" auth.getServicePricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isEvent() ).as(" auth.getServicePricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isPreOrder() ).as(" auth.getServicePricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getTaxRate() ).as(" auth.getServicePricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getServicePricePoint().getTaxCode() ).as(" auth.getServicePricePoint().getTaxCode()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getLinkedByTrialPricepoint() ).as(" auth.getServicePricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getStartDate() ).as(" auth.getServicePricePoint().getStartDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getDescription() ).as(" auth.getServicePricePoint().getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(auth.getServicePricePoint().getExpiryDate() ).as(" auth.getServicePricePoint().getExpiryDate()" ).isNull();
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getResourceBalances().length ).as(" auth.getServicePricePoint().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().getName() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().isResource() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().getCode() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().isToken() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getThreshold() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getSubscription() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getBalance() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getResourceBalances()[0].getPackageId() ).as(" auth.getServicePricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getNetRate() ).as(" auth.getServicePricePoint().getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().isAlwaysValidateMsisdn() ).as(" auth.getServicePricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getStandardRate() ).as(" auth.getServicePricePoint().getStandardRate()" ).isEqualTo(new Double(1.18)) ;
        softly.assertThat(auth.getServicePricePoint().isDiscount() ).as(" auth.getServicePricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getDiscountPromoText() ).as(" auth.getServicePricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().getPackageId() ).as(" auth.getServicePricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getServicePricePoint().getContentId() ).as(" auth.getServicePricePoint().getContentId()" ).isEqualTo("B001");
        softly.assertThat(auth.getServicePricePoint().getPricingText1() ).as(" auth.getServicePricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().getPricingText2() ).as(" auth.getServicePricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getServicePricePoint().getUsageTime() ).as(" auth.getServicePricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getServicePricePoint().getAccessDuration() ).as(" auth.getServicePricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().isZeroCostIgnore() ).as(" auth.getServicePricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances().length ).as(" auth.getServicePricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getBalance() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" auth.getServicePricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isActive() ).as(" auth.getServicePricePoint().isActive()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().getRate() ).as(" auth.getServicePricePoint().getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getChannel() ).as(" auth.getServicePricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getServicePricePoint().getMultiUsageMode() ).as(" auth.getServicePricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getNetworkCodeMatchMethod() ).as(" auth.getServicePricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getServicePricePoint().isPreRatePriceGross() ).as(" auth.getServicePricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getPreRate() ).as(" auth.getServicePricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getServicePricePoint().getPaymentInformation() ).as(" auth.getServicePricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getContentName() ).as(" auth.getServicePricePoint().getContentName()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAssetID() ).as(" auth.getServicePricePoint().getAssetID()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPremiumLevel() ).as(" auth.getServicePricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getServicePricePoint().getReserveOnlyFlag() ).as(" auth.getServicePricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getServicePricePoint().getSupplierId() ).as(" auth.getServicePricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(auth.getServicePricePoint().getDeviceType() ).as(" auth.getServicePricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getUserGroups().length ).as(" auth.getServicePricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getServicePricePoint().getUserGroup() ).as(" auth.getServicePricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getServicePricePoint().getPaymentType() ).as(" auth.getServicePricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(auth.getServicePricePoint().getEventDateTime() ).as(" auth.getServicePricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getEventUnits() ).as(" auth.getServicePricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getPromoCodes().length ).as(" auth.getServicePricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(auth.getServicePricePoint().getBearerIds().length ).as(" auth.getServicePricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getServicePricePoint().getPromoCode() ).as(" auth.getServicePricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(auth.getServicePricePoint().getDuration() ).as(" auth.getServicePricePoint().getDuration()" ).isEqualTo(999) ;
        softly.assertThat(auth.getServicePricePoint().getChargingMethod() ).as(" auth.getServicePricePoint().getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(auth.getServicePricePoint().getBearer() ).as(" auth.getServicePricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(auth.getServicePricePoint().isInteractive() ).as(" auth.getServicePricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(auth.getServicePricePoint().isIncludeUnavailable() ).as(" auth.getServicePricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getExpressFlag() ).as(" auth.getServicePricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isExpressFlag() ).as(" auth.getServicePricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isCancellationUsage() ).as(" auth.getServicePricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getTierName() ).as(" auth.getServicePricePoint().getTierName()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPromoPrecode() ).as(" auth.getServicePricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getUniquePromoCode() ).as(" auth.getServicePricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPromoUniqueCode() ).as(" auth.getServicePricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getNextCycleDiscount() ).as(" auth.getServicePricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getServicePricePoint().getHasHistoricPricePointFlag() ).as(" auth.getServicePricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isIsForRenewal() ).as(" auth.getServicePricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getTaxRateAsDouble() ).as(" auth.getServicePricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAffiliateID() ).as(" auth.getServicePricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPartnerId() ).as(" auth.getServicePricePoint().getPartnerId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getTariff() ).as(" auth.getServicePricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(auth.getServicePricePoint().getAggregatorId() ).as(" auth.getServicePricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isForcePurchaseFlow() ).as(" auth.getServicePricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getReceipientMsisdn() ).as(" auth.getServicePricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getProductCode() ).as(" auth.getServicePricePoint().getProductCode()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getMerchantName() ).as(" auth.getServicePricePoint().getMerchantName()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getInvoiceText() ).as(" auth.getServicePricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isReIssueEnabled() ).as(" auth.getServicePricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isReIssueFlagPresent() ).as(" auth.getServicePricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getShortPackageId() ).as(" auth.getServicePricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getHistoryStartDate() ).as(" auth.getServicePricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getVendorId() ).as(" auth.getServicePricePoint().getVendorId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().isIsForNextPaymentAmount() ).as(" auth.getServicePricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getRenewalPreRate() ).as(" auth.getServicePricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getServicePricePoint().isOverrideDisallowPreRateFlag() ).as(" auth.getServicePricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getContentCategory() ).as(" auth.getServicePricePoint().getContentCategory()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPartnerUrl() ).as(" auth.getServicePricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPartnerContactInfo() ).as(" auth.getServicePricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPartnerEmail() ).as(" auth.getServicePricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPartnerName() ).as(" auth.getServicePricePoint().getPartnerName()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" auth.getServicePricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getServicePricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" auth.getServicePricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getServicePricePoint().getSubRenewalPricepointId() ).as(" auth.getServicePricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getLinkPricepointId() ).as(" auth.getServicePricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getSubPurchaseTransactionTrial() ).as(" auth.getServicePricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getDiscardHiddenInactivePricepoints() ).as(" auth.getServicePricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" auth.getServicePricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(auth.getServicePricePoint().getExtIdentifier1() ).as(" auth.getServicePricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getExtIdentifier2() ).as(" auth.getServicePricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getExtIdentifier3() ).as(" auth.getServicePricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getAccessChannel() ).as(" auth.getServicePricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getPurchaseChannel() ).as(" auth.getServicePricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getDeviceID() ).as(" auth.getServicePricePoint().getDeviceID()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getLocal() ).as(" auth.getServicePricePoint().getLocal()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getMsisdn() ).as(" auth.getServicePricePoint().getMsisdn()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getLanguageLocale() ).as(" auth.getServicePricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getLanguageCode() ).as(" auth.getServicePricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getExternalField1() ).as(" auth.getServicePricePoint().getExternalField1()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getExternalField2() ).as(" auth.getServicePricePoint().getExternalField2()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getExternalTransId() ).as(" auth.getServicePricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getActiveSubscriptions() ).as(" auth.getServicePricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getServicePricePoint().getCsrId() ).as(" auth.getServicePricePoint().getCsrId()" ).isNull();
        softly.assertThat(auth.isAuthorized() ).as(" auth.isAuthorized()" ).isTrue() ;
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(auth.getPackage().getName() ).as(" auth.getPackage().getName()" ).isEqualTo("BP001");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getResource().getName() ).as(" auth.getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getResource().isCurrency() ).as(" auth.getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getResource().isResource() ).as(" auth.getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getResource().getCountryId() ).as(" auth.getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getResource().getResourceName() ).as(" auth.getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getResource().getCode() ).as(" auth.getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getResource().getDescription() ).as(" auth.getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getResource().isToken() ).as(" auth.getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getResource().isUsageToken() ).as(" auth.getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getResource().isPayToken() ).as(" auth.getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getResource().getResourceSymbol() ).as(" auth.getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getKey() ).as(" auth.getPackage().getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPriority() ).as(" auth.getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getId() ).as(" auth.getPackage().getId()" ).isEqualTo("BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
// java.util.HashMap
        softly.assertThat(auth.getPackage().isReserveOnly() ).as(" auth.getPackage().isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPackage().isOriginal() ).as(" auth.getPackage().isOriginal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricingModel() ).as(" auth.getPackage().getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().isDefault() ).as(" auth.getPackage().isDefault()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getTaxCode() ).as(" auth.getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(auth.getPackage().getParentPackageId() ).as(" auth.getPackage().getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getUrl() ).as(" auth.getPackage().getUrl()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getResource().getName() ).as(" auth.getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().isResource() ).as(" auth.getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getResource().getCode() ).as(" auth.getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getResource().isToken() ).as(" auth.getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getKey() ).as(" auth.getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getId() ).as(" auth.getPackage().getPricePoint().getId()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
        softly.assertThat(auth.getPackage().getPricePoint().getPricingModelTier() ).as(" auth.getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isArchived() ).as(" auth.getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isBasePricePoint() ).as(" auth.getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAccessDevice() ).as(" auth.getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAlternativeRate() ).as(" auth.getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(8.225)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts().length ).as(" auth.getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].getName() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].isResource() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].getCode() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].isToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().size()).as("auth.getPackage().getPricePoint().getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoint().getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getId() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getType() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getKey() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getId() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getType() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).isCurrency() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).isResource() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getRate() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().isTrial() ).as(" auth.getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getGlid() ).as(" auth.getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getPricePoint().getPricepointIdLink() ).as(" auth.getPackage().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoint().isPreview() ).as(" auth.getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getInteractiveFlag() ).as(" auth.getPackage().getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(auth.getPackage().getPricePoint().isForcedPurchase() ).as(" auth.getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" auth.getPackage().getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getFixedExpiryDate() ).as(" auth.getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isReserveOnly() ).as(" auth.getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getMinSubPeriod() ).as(" auth.getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPenaltyCharges() ).as(" auth.getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getCancellation() ).as(" auth.getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getMonthEndSubscription() ).as(" auth.getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPackage().getPricePoint().isHistoric() ).as(" auth.getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getFixedRecurrence() ).as(" auth.getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" auth.getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isReceipting() ).as(" auth.getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getReceiptingAttribute() ).as(" auth.getPackage().getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPackage().getPricePoint().getOrder() ).as(" auth.getPackage().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPaymentHandler() ).as(" auth.getPackage().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getNonMatchAllUserGroups().length ).as(" auth.getPackage().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().isPromo() ).as(" auth.getPackage().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isSubmitToPaymentHandler() ).as(" auth.getPackage().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isSuppressToPaymentHandler() ).as(" auth.getPackage().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricingTextTemplateName1() ).as(" auth.getPackage().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricingTextTemplateName2() ).as(" auth.getPackage().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getTranslatedPricingText1() ).as(" auth.getPackage().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getTranslatedPricingText2() ).as(" auth.getPackage().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getRecurrenceDay() ).as(" auth.getPackage().getPricePoint().getRecurrenceDay()" ).isEqualTo(0) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPackage().getPricePoint().isAlignWithExternal() ).as(" auth.getPackage().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getGracePeriod() ).as(" auth.getPackage().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getRetryFrequency() ).as(" auth.getPackage().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getSuspensionPeriod() ).as(" auth.getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" auth.getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getTranslatedPricingText() ).as(" auth.getPackage().getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getFairUsageLimit() ).as(" auth.getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getFairUsagePeriod() ).as(" auth.getPackage().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getFairUsagePeriodUnit() ).as(" auth.getPackage().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(auth.getPackage().getPricePoint().getExtensionPeriod() ).as(" auth.getPackage().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().isIncludeServiceForPackageFUP() ).as(" auth.getPackage().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isFairUsagePolicyEnabled() ).as(" auth.getPackage().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isTariff() ).as(" auth.getPackage().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isHideForPurchaseOptions() ).as(" auth.getPackage().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getName() ).as(" auth.getPackage().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getKey() ).as(" auth.getPackage().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRate() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxCode() ).as(" auth.getPackage().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().size()).as("auth.getPackage().getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(auth.getPackage().getPricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().get(0).value() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().get(1).value() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().get(2).value() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" auth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getBalances().length ).as(" auth.getPackage().getPricePoint().getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isRecurring() ).as(" auth.getPackage().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" auth.getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getKey() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getPricingModel() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getTier() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" auth.getPackage().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().size()).as("auth.getPackage().getPricePoint().getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoint().getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPackageIdentifier() ).as(" auth.getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(auth.getPackage().getPricePoint().getServiceIdentifier() ).as(" auth.getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_*_999_10010_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().getName() ).as(" auth.getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().isCurrency() ).as(" auth.getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().isResource() ).as(" auth.getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().getCountryId() ).as(" auth.getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().getResourceName() ).as(" auth.getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().getCode() ).as(" auth.getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().getDescription() ).as(" auth.getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().isToken() ).as(" auth.getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" auth.getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().isPayToken() ).as(" auth.getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" auth.getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().isVolumeType() ).as(" auth.getPackage().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isOriginal() ).as(" auth.getPackage().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers().length ).as(" auth.getPackage().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getKey() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getTier() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" auth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getProtectedFk() ).as(" auth.getPackage().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getmPricingText1() ).as(" auth.getPackage().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoint().getmPricingText2() ).as(" auth.getPackage().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoint().isNonRecurring() ).as(" auth.getPackage().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isEvent() ).as(" auth.getPackage().getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isPreOrder() ).as(" auth.getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getTaxRate() ).as(" auth.getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getTaxCode() ).as(" auth.getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(auth.getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" auth.getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getStartDate() ).as(" auth.getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getDescription() ).as(" auth.getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 1 month");
        softly.assertThat(auth.getPackage().getPricePoint().getExpiryDate() ).as(" auth.getPackage().getPricePoint().getExpiryDate()" ).isNull();
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances().length ).as(" auth.getPackage().getPricePoint().getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getResourceBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getNetRate() ).as(" auth.getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" auth.getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getStandardRate() ).as(" auth.getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(auth.getPackage().getPricePoint().isDiscount() ).as(" auth.getPackage().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getDiscountPromoText() ).as(" auth.getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoint().getPackageId() ).as(" auth.getPackage().getPricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getPackage().getPricePoint().getContentId() ).as(" auth.getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoint().getPricingText1() ).as(" auth.getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoint().getPricingText2() ).as(" auth.getPackage().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoint().getUsageTime() ).as(" auth.getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getAccessDuration() ).as(" auth.getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().isZeroCostIgnore() ).as(" auth.getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances().length ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isActive() ).as(" auth.getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().getRate() ).as(" auth.getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getChannel() ).as(" auth.getPackage().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoint().getMultiUsageMode() ).as(" auth.getPackage().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getNetworkCodeMatchMethod() ).as(" auth.getPackage().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoint().isPreRatePriceGross() ).as(" auth.getPackage().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getPreRate() ).as(" auth.getPackage().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPaymentInformation() ).as(" auth.getPackage().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getContentName() ).as(" auth.getPackage().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAssetID() ).as(" auth.getPackage().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPremiumLevel() ).as(" auth.getPackage().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoint().getReserveOnlyFlag() ).as(" auth.getPackage().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoint().getSupplierId() ).as(" auth.getPackage().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoint().getDeviceType() ).as(" auth.getPackage().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getUserGroups().length ).as(" auth.getPackage().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getUserGroup() ).as(" auth.getPackage().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoint().getPaymentType() ).as(" auth.getPackage().getPricePoint().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(auth.getPackage().getPricePoint().getEventDateTime() ).as(" auth.getPackage().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getEventUnits() ).as(" auth.getPackage().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getPromoCodes().length ).as(" auth.getPackage().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoint().getBearerIds().length ).as(" auth.getPackage().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPromoCode() ).as(" auth.getPackage().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoint().getDuration() ).as(" auth.getPackage().getPricePoint().getDuration()" ).isEqualTo(4) ;
        softly.assertThat(auth.getPackage().getPricePoint().getChargingMethod() ).as(" auth.getPackage().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(auth.getPackage().getPricePoint().getBearer() ).as(" auth.getPackage().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoint().isInteractive() ).as(" auth.getPackage().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoint().isIncludeUnavailable() ).as(" auth.getPackage().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getExpressFlag() ).as(" auth.getPackage().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isExpressFlag() ).as(" auth.getPackage().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isCancellationUsage() ).as(" auth.getPackage().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getTierName() ).as(" auth.getPackage().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPromoPrecode() ).as(" auth.getPackage().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getUniquePromoCode() ).as(" auth.getPackage().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPromoUniqueCode() ).as(" auth.getPackage().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getNextCycleDiscount() ).as(" auth.getPackage().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().getHasHistoricPricePointFlag() ).as(" auth.getPackage().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isIsForRenewal() ).as(" auth.getPackage().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getTaxRateAsDouble() ).as(" auth.getPackage().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAffiliateID() ).as(" auth.getPackage().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPartnerId() ).as(" auth.getPackage().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getTariff() ).as(" auth.getPackage().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoint().getAggregatorId() ).as(" auth.getPackage().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isForcePurchaseFlow() ).as(" auth.getPackage().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getReceipientMsisdn() ).as(" auth.getPackage().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getProductCode() ).as(" auth.getPackage().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getMerchantName() ).as(" auth.getPackage().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getInvoiceText() ).as(" auth.getPackage().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isReIssueEnabled() ).as(" auth.getPackage().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isReIssueFlagPresent() ).as(" auth.getPackage().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getShortPackageId() ).as(" auth.getPackage().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getHistoryStartDate() ).as(" auth.getPackage().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getVendorId() ).as(" auth.getPackage().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().isIsForNextPaymentAmount() ).as(" auth.getPackage().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getRenewalPreRate() ).as(" auth.getPackage().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" auth.getPackage().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getContentCategory() ).as(" auth.getPackage().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPartnerUrl() ).as(" auth.getPackage().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPartnerContactInfo() ).as(" auth.getPackage().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPartnerEmail() ).as(" auth.getPackage().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPartnerName() ).as(" auth.getPackage().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" auth.getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" auth.getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoint().getSubRenewalPricepointId() ).as(" auth.getPackage().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getLinkPricepointId() ).as(" auth.getPackage().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getSubPurchaseTransactionTrial() ).as(" auth.getPackage().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" auth.getPackage().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" auth.getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoint().getExtIdentifier1() ).as(" auth.getPackage().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getExtIdentifier2() ).as(" auth.getPackage().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getExtIdentifier3() ).as(" auth.getPackage().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getAccessChannel() ).as(" auth.getPackage().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getPurchaseChannel() ).as(" auth.getPackage().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getDeviceID() ).as(" auth.getPackage().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getLocal() ).as(" auth.getPackage().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getMsisdn() ).as(" auth.getPackage().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getLanguageLocale() ).as(" auth.getPackage().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getLanguageCode() ).as(" auth.getPackage().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getExternalField1() ).as(" auth.getPackage().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getExternalField2() ).as(" auth.getPackage().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getExternalTransId() ).as(" auth.getPackage().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getActiveSubscriptions() ).as(" auth.getPackage().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoint().getCsrId() ).as(" auth.getPackage().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(auth.getPackage().getDescription() ).as(" auth.getPackage().getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getPricingText1() ).as(" auth.getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricingText2() ).as(" auth.getPackage().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().isGoodwillCredit() ).as(" auth.getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPriceModels() ).as(" auth.getPackage().getPriceModels()" ).isNull();
        softly.assertThat(auth.getPackage().getFullPackagePricepointId() ).as(" auth.getPackage().getFullPackagePricepointId()" ).isEqualTo("BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
// java.lang.Character
        softly.assertThat(auth.getPackage().getSimplePackageId() ).as(" auth.getPackage().getSimplePackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getPackage().getNotificationCategory() ).as(" auth.getPackage().getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(auth.getPackage().getPaymentContent().getKey() ).as(" auth.getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getPaymentContent().getDescription() ).as(" auth.getPackage().getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getPaymentContent().getMerchant() ).as(" auth.getPackage().getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getPaymentContent().getMerchantDescription() ).as(" auth.getPackage().getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getPaymentContent().getItemVolume() ).as(" auth.getPackage().getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getPaymentContent().getServiceType() ).as(" auth.getPackage().getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getPaymentContent().getPromotion() ).as(" auth.getPackage().getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getPaymentContent().getCategory() ).as(" auth.getPackage().getPaymentContent().getCategory()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(auth.getPackage().getServiceArray().length ).as(" auth.getPackage().getServiceArray().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getName() ).as(" auth.getPackage().getServiceArray()[0].getName()" ).isEqualTo("B001");
        softly.assertThat(auth.getPackage().getServiceArray()[0].getKey() ).as(" auth.getPackage().getServiceArray()[0].getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(auth.getPackage().getServiceArray()[0].getId() ).as(" auth.getPackage().getServiceArray()[0].getId()" ).isEqualTo("B001");
        softly.assertThat(auth.getPackage().getServiceArray()[0].getDisplayName() ).as(" auth.getPackage().getServiceArray()[0].getDisplayName()" ).isEqualTo("B001 (B001)");
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServiceArray()[0].isReserveOnly() ).as(" auth.getPackage().getServiceArray()[0].isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProvisioningTag() ).as(" auth.getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(auth.getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" auth.getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo() ).as(" auth.getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isDefaultService() ).as(" auth.getPackage().getServiceArray()[0].isDefaultService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" auth.getPackage().getServiceArray()[0].getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getUsageId() ).as(" auth.getPackage().getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getServiceCategory() ).as(" auth.getPackage().getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getDealName() ).as(" auth.getPackage().getServiceArray()[0].getDealName()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getDistributionChannel() ).as(" auth.getPackage().getServiceArray()[0].getDistributionChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" auth.getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isHighVolumeInterface() ).as(" auth.getPackage().getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" auth.getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" auth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(auth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" auth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getIndirectValue() ).as(" auth.getPackage().getServiceArray()[0].getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getIndirectValueFormat() ).as(" auth.getPackage().getServiceArray()[0].getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPromoValue() ).as(" auth.getPackage().getServiceArray()[0].getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPromoValueFormat() ).as(" auth.getPackage().getServiceArray()[0].getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(auth.getPackage().getServiceArray()[0].getContentSubCategory() ).as(" auth.getPackage().getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getContentItem() ).as(" auth.getPackage().getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" auth.getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProductCategory() ).as(" auth.getPackage().getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" auth.getPackage().getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" auth.getPackage().getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" auth.getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" auth.getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].isVolumeService() ).as(" auth.getPackage().getServiceArray()[0].isVolumeService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getProductFk() ).as(" auth.getPackage().getServiceArray()[0].getProductFk()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].isServiceShareOverride() ).as(" auth.getPackage().getServiceArray()[0].isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isExpiredPackageService() ).as(" auth.getPackage().getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getFixedUsageAmount() ).as(" auth.getPackage().getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getHasExpress() ).as(" auth.getPackage().getServiceArray()[0].getHasExpress()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getHasDynamicDefault() ).as(" auth.getPackage().getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getHasSuperPackage() ).as(" auth.getPackage().getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" auth.getPackage().getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getServiceClass() ).as(" auth.getPackage().getServiceArray()[0].getServiceClass()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getBandRevenueShares() ).as(" auth.getPackage().getServiceArray()[0].getBandRevenueShares()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].isReIssuePermittedFlag() ).as(" auth.getPackage().getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getChargeableBy() ).as(" auth.getPackage().getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPackageIds().length ).as(" auth.getPackage().getServiceArray()[0].getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isMicroService() ).as(" auth.getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" auth.getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" auth.getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].ismRefundable() ).as(" auth.getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" auth.getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isUseRateCard() ).as(" auth.getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getInternalPartner() ).as(" auth.getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getRateCardPartners() ).as(" auth.getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" auth.getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isGlobalHandler() ).as(" auth.getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" auth.getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" auth.getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" auth.getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getTaxCode() ).as(" auth.getPackage().getServiceArray()[0].getTaxCode()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getContentCategory() ).as(" auth.getPackage().getServiceArray()[0].getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getUrl() ).as(" auth.getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoint() ).as(" auth.getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getDescription() ).as(" auth.getPackage().getServiceArray()[0].getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricingText1() ).as(" auth.getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricingText2() ).as(" auth.getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getNotificationCategory() ).as(" auth.getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" auth.getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getNonRefundableDescription() ).as(" auth.getPackage().getServiceArray()[0].getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServiceArray()[0].isRefundable() ).as(" auth.getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//check size of list!
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().size()).as("auth.getPackage().getServiceArray()[0].getPricePoints().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServiceArray()[0].getPricePoints().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getName() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isCurrency() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isResource() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCountryId() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceName() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCode() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getDescription() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getDescription()" ).isNull();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isToken() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isPayToken() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getKey() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getId() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingModelTier() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).isArchived() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).isBasePricePoint() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAccessDevice() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAlternativeRate() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(1.175)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts().length ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//check size of list!
        softly.assertThat(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().size()).as("auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().size() >= 1);

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }
    }

}
