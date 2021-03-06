package com.vodafone.er.ecom.proxy.usageauth;

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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 *
 * UsageAuthRateCharge with a Purchase Options response
 * Split into parts since the test is so long!
 */
public class UsageAuth1_pt1_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void testGetService1UsageAuthResponse() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        String packageId = "BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false";
        //        //Purchase
        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        final UsageAuthorization usageAuth = EcomApiFactory.getChargingApi(Locale.UK)
                .usageAuth("test", msisdn, "B001", new UsageAttributes());
        assertNotNull(usageAuth);
        assertTrue(usageAuth.isSuccess());



        softly.assertThat(usageAuth.isFirstUsage() ).as(" usageAuth.isFirstUsage()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getName() ).as(" usageAuth.getServicePricePoint().getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getCode() ).as(" usageAuth.getServicePricePoint().getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getResource().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isToken() ).as(" usageAuth.getServicePricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isResource() ).as(" usageAuth.getServicePricePoint().getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getKey() ).as(" usageAuth.getServicePricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getId() ).as(" usageAuth.getServicePricePoint().getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(usageAuth.getServicePricePoint().getDescription() ).as(" usageAuth.getServicePricePoint().getDescription()" ).isEqualTo("Default (event) ");
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances().length ).as(" usageAuth.getServicePricePoint().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscription() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getThreshold() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getPackageId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getBalance() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getStandardRate() ).as(" usageAuth.getServicePricePoint().getStandardRate()" ).isEqualTo(new Double(1.18)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getNetRate() ).as(" usageAuth.getServicePricePoint().getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getServicePricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isDiscount() ).as(" usageAuth.getServicePricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getDiscountPromoText() ).as(" usageAuth.getServicePricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getDiscountPromoText() ).as(" usageAuth.getServicePricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getPackageId() ).as(" usageAuth.getServicePricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(usageAuth.getServicePricePoint().getContentId() ).as(" usageAuth.getServicePricePoint().getContentId()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getServicePricePoint().getPricingText1() ).as(" usageAuth.getServicePricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingText1() ).as(" usageAuth.getServicePricePoint().getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getPricingText2() ).as(" usageAuth.getServicePricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingText2() ).as(" usageAuth.getServicePricePoint().getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getUsageTime() ).as(" usageAuth.getServicePricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAccessDuration() ).as(" usageAuth.getServicePricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isZeroCostIgnore() ).as(" usageAuth.getServicePricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances().length ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getExpiryDate() ).as(" usageAuth.getServicePricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getRate() ).as(" usageAuth.getServicePricePoint().getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isActive() ).as(" usageAuth.getServicePricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().isPreOrder() ).as(" usageAuth.getServicePricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxRate() ).as(" usageAuth.getServicePricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxCode() ).as(" usageAuth.getServicePricePoint().getTaxCode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getServicePricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getStartDate() ).as(" usageAuth.getServicePricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricingModelTier() ).as(" usageAuth.getServicePricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isArchived() ).as(" usageAuth.getServicePricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isBasePricePoint() ).as(" usageAuth.getServicePricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAccessDevice() ).as(" usageAuth.getServicePricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAlternativeRate() ).as(" usageAuth.getServicePricePoint().getAlternativeRate()" ).isEqualTo(new Double(1.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts().length ).as(" usageAuth.getServicePricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getName() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCode() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isResource() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isResource()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().size()).as("usageAuth.getServicePricePoint().getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getId() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getType() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().isTrial() ).as(" usageAuth.getServicePricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getGlid() ).as(" usageAuth.getServicePricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getGlid() ).as(" usageAuth.getServicePricePoint().getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getServicePricePoint().getPricepointIdLink() ).as(" usageAuth.getServicePricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isPreview() ).as(" usageAuth.getServicePricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getInteractiveFlag() ).as(" usageAuth.getServicePricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getServicePricePoint().isForcedPurchase() ).as(" usageAuth.getServicePricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getServicePricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getFixedExpiryDate() ).as(" usageAuth.getServicePricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isReserveOnly() ).as(" usageAuth.getServicePricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getMinSubPeriod() ).as(" usageAuth.getServicePricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
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
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getServicePricePoint().isAlignWithExternal() ).as(" usageAuth.getServicePricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getGracePeriod() ).as(" usageAuth.getServicePricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getRetryFrequency() ).as(" usageAuth.getServicePricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getSuspensionPeriod() ).as(" usageAuth.getServicePricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getServicePricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTranslatedPricingText() ).as(" usageAuth.getServicePricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getTranslatedPricingText() ).as(" usageAuth.getServicePricePoint().getTranslatedPricingText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getFairUsageLimit() ).as(" usageAuth.getServicePricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getFairUsagePeriod() ).as(" usageAuth.getServicePricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getFairUsagePeriodUnit() ).as(" usageAuth.getServicePricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getServicePricePoint().getExtensionPeriod() ).as(" usageAuth.getServicePricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().isIncludeServiceForPackageFUP() ).as(" usageAuth.getServicePricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isFairUsagePolicyEnabled() ).as(" usageAuth.getServicePricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isTariff() ).as(" usageAuth.getServicePricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isHideForPurchaseOptions() ).as(" usageAuth.getServicePricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getName() ).as(" usageAuth.getServicePricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getKey() ).as(" usageAuth.getServicePricePoint().getTax().getKey()" ).isNull();
//check size of list!
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().size()).as("usageAuth.getServicePricePoint().getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getServicePricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).value() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(1).value() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(2).value() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRate() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxCode() ).as(" usageAuth.getServicePricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBalances().length ).as(" usageAuth.getServicePricePoint().getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getName() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getCode() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isToken() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isResource() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getSubscription() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getThreshold() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getPackageId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getBalance() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isRecurring() ).as(" usageAuth.getServicePricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getServicePricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPricingModel() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getTier() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().isDefaultPPT() ).as(" usageAuth.getServicePricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPackageIdentifier() ).as(" usageAuth.getServicePricePoint().getPackageIdentifier()" ).isEqualTo("package:BP001_null_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getServicePricePoint().getServiceIdentifier() ).as(" usageAuth.getServicePricePoint().getServiceIdentifier()" ).isEqualTo("content:BP001_null_B001_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getName() ).as(" usageAuth.getServicePricePoint().getResourceField().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getCode() ).as(" usageAuth.getServicePricePoint().getResourceField().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getDescription() ).as(" usageAuth.getServicePricePoint().getResourceField().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getCountryId() ).as(" usageAuth.getServicePricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getResourceName() ).as(" usageAuth.getServicePricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isToken() ).as(" usageAuth.getServicePricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isUsageToken() ).as(" usageAuth.getServicePricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isPayToken() ).as(" usageAuth.getServicePricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isCurrency() ).as(" usageAuth.getServicePricePoint().getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isResource() ).as(" usageAuth.getServicePricePoint().getResourceField().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getStandardRateWithoutTax() ).as(" usageAuth.getServicePricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isVolumeType() ).as(" usageAuth.getServicePricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isOriginal() ).as(" usageAuth.getServicePricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers().length ).as(" usageAuth.getServicePricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getTier() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getProtectedFk() ).as(" usageAuth.getServicePricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText1() ).as(" usageAuth.getServicePricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText1() ).as(" usageAuth.getServicePricePoint().getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText2() ).as(" usageAuth.getServicePricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getmPricingText2() ).as(" usageAuth.getServicePricePoint().getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().isNonRecurring() ).as(" usageAuth.getServicePricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isEvent() ).as(" usageAuth.getServicePricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getChannel() ).as(" usageAuth.getServicePricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getMultiUsageMode() ).as(" usageAuth.getServicePricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getNetworkCodeMatchMethod() ).as(" usageAuth.getServicePricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getServicePricePoint().isPreRatePriceGross() ).as(" usageAuth.getServicePricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPreRate() ).as(" usageAuth.getServicePricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPaymentInformation() ).as(" usageAuth.getServicePricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getContentName() ).as(" usageAuth.getServicePricePoint().getContentName()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAssetID() ).as(" usageAuth.getServicePricePoint().getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPremiumLevel() ).as(" usageAuth.getServicePricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getReserveOnlyFlag() ).as(" usageAuth.getServicePricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getSupplierId() ).as(" usageAuth.getServicePricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().getDeviceType() ).as(" usageAuth.getServicePricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getUserGroups().length ).as(" usageAuth.getServicePricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getUserGroup() ).as(" usageAuth.getServicePricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getServicePricePoint().getPaymentType() ).as(" usageAuth.getServicePricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getEventDateTime() ).as(" usageAuth.getServicePricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getEventUnits() ).as(" usageAuth.getServicePricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getPromoCodes().length ).as(" usageAuth.getServicePricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBearerIds().length ).as(" usageAuth.getServicePricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPromoCode() ).as(" usageAuth.getServicePricePoint().getPromoCode()" ).isEqualTo("*");
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
        softly.assertThat(usageAuth.getSubscriptionStatus() ).as(" usageAuth.getSubscriptionStatus()" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.isSuccessfulExpressPurchase() ).as(" usageAuth.isSuccessfulExpressPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubResourceBalances() ).as(" usageAuth.getSubResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.isBasedOnMultiplePackages() ).as(" usageAuth.isBasedOnMultiplePackages()" ).isFalse() ;
        softly.assertThat(usageAuth.getParentTransactionId() ).as(" usageAuth.getParentTransactionId()" ).isNull();
        softly.assertThat(usageAuth.getParentTransactionIdLong() ).as(" usageAuth.getParentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getReIssue() ).as(" usageAuth.getReIssue()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getEventUnits() ).as(" usageAuth.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getIsValidatedAccount() ).as(" usageAuth.getIsValidatedAccount()" ).isNull();
        softly.assertThat(usageAuth.getIsPreordered() ).as(" usageAuth.getIsPreordered()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.isAuthorized() ).as(" usageAuth.isAuthorized()" ).isTrue() ;
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(usageAuth.getPackage().getName() ).as(" usageAuth.getPackage().getName()" ).isEqualTo("BP001");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getResource().getName() ).as(" usageAuth.getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getResource().getCode() ).as(" usageAuth.getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getResource().getDescription() ).as(" usageAuth.getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getResource().getCountryId() ).as(" usageAuth.getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getResource().getResourceName() ).as(" usageAuth.getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getResource().isToken() ).as(" usageAuth.getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().isUsageToken() ).as(" usageAuth.getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().isPayToken() ).as(" usageAuth.getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getResource().isCurrency() ).as(" usageAuth.getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getResource().isResource() ).as(" usageAuth.getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getKey() ).as(" usageAuth.getPackage().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPriority() ).as(" usageAuth.getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getId() ).as(" usageAuth.getPackage().getId()" ).isEqualTo("BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getKey() ).as(" usageAuth.getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getId() ).as(" usageAuth.getPackage().getPricePoint().getId()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 1 month");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances().length ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getStandardRate() ).as(" usageAuth.getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getNetRate() ).as(" usageAuth.getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isDiscount() ).as(" usageAuth.getPackage().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getContentId() ).as(" usageAuth.getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingText1() ).as(" usageAuth.getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingText2() ).as(" usageAuth.getPackage().getPricePoint().getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getUsageTime() ).as(" usageAuth.getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAccessDuration() ).as(" usageAuth.getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isZeroCostIgnore() ).as(" usageAuth.getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances().length ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExpiryDate() ).as(" usageAuth.getPackage().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRate() ).as(" usageAuth.getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isActive() ).as(" usageAuth.getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isPreOrder() ).as(" usageAuth.getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTaxRate() ).as(" usageAuth.getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTaxCode() ).as(" usageAuth.getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getStartDate() ).as(" usageAuth.getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingModelTier() ).as(" usageAuth.getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isArchived() ).as(" usageAuth.getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isBasePricePoint() ).as(" usageAuth.getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAccessDevice() ).as(" usageAuth.getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAlternativeRate() ).as(" usageAuth.getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(8.225)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts().length ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isResource()" ).isFalse() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().size()).as("usageAuth.getPackage().getPricePoint().getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoint().getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isTrial() ).as(" usageAuth.getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getGlid() ).as(" usageAuth.getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getGlid() ).as(" usageAuth.getPackage().getPricePoint().getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoint().getPricepointIdLink()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isPreview() ).as(" usageAuth.getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getInteractiveFlag() ).as(" usageAuth.getPackage().getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isForcedPurchase() ).as(" usageAuth.getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFixedExpiryDate() ).as(" usageAuth.getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isReserveOnly() ).as(" usageAuth.getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMinSubPeriod() ).as(" usageAuth.getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPenaltyCharges() ).as(" usageAuth.getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCancellation() ).as(" usageAuth.getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMonthEndSubscription() ).as(" usageAuth.getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isHistoric() ).as(" usageAuth.getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFixedRecurrence() ).as(" usageAuth.getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isReceipting() ).as(" usageAuth.getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getReceiptingAttribute() ).as(" usageAuth.getPackage().getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getOrder() ).as(" usageAuth.getPackage().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPaymentHandler() ).as(" usageAuth.getPackage().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getNonMatchAllUserGroups().length ).as(" usageAuth.getPackage().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isPromo() ).as(" usageAuth.getPackage().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isSubmitToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isSuppressToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTranslatedPricingText1() ).as(" usageAuth.getPackage().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTranslatedPricingText2() ).as(" usageAuth.getPackage().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRecurrenceDay() ).as(" usageAuth.getPackage().getPricePoint().getRecurrenceDay()" ).isEqualTo(0) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoint().isAlignWithExternal() ).as(" usageAuth.getPackage().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getGracePeriod() ).as(" usageAuth.getPackage().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRetryFrequency() ).as(" usageAuth.getPackage().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getSuspensionPeriod() ).as(" usageAuth.getPackage().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPackage().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTranslatedPricingText() ).as(" usageAuth.getPackage().getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFairUsageLimit() ).as(" usageAuth.getPackage().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFairUsagePeriod() ).as(" usageAuth.getPackage().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExtensionPeriod() ).as(" usageAuth.getPackage().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isTariff() ).as(" usageAuth.getPackage().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getName() ).as(" usageAuth.getPackage().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getKey()" ).isNull();
//check size of list!
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().size()).as("usageAuth.getPackage().getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).value() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).value() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).value() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRate() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxCode() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances().length ).as(" usageAuth.getPackage().getPricePoint().getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isRecurring() ).as(" usageAuth.getPackage().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getPricingModel() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getTier() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPackageIdentifier() ).as(" usageAuth.getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getServiceIdentifier() ).as(" usageAuth.getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_*_999_10010_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getName() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getCode() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isResource() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isVolumeType() ).as(" usageAuth.getPackage().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isOriginal() ).as(" usageAuth.getPackage().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers().length ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getTier() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getProtectedFk() ).as(" usageAuth.getPackage().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getmPricingText1() ).as(" usageAuth.getPackage().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getmPricingText1() ).as(" usageAuth.getPackage().getPricePoint().getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getmPricingText2() ).as(" usageAuth.getPackage().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getmPricingText2() ).as(" usageAuth.getPackage().getPricePoint().getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isNonRecurring() ).as(" usageAuth.getPackage().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isEvent() ).as(" usageAuth.getPackage().getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getChannel() ).as(" usageAuth.getPackage().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMultiUsageMode() ).as(" usageAuth.getPackage().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getNetworkCodeMatchMethod() ).as(" usageAuth.getPackage().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isPreRatePriceGross() ).as(" usageAuth.getPackage().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPreRate() ).as(" usageAuth.getPackage().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPaymentInformation() ).as(" usageAuth.getPackage().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getContentName() ).as(" usageAuth.getPackage().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAssetID() ).as(" usageAuth.getPackage().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPremiumLevel() ).as(" usageAuth.getPackage().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getReserveOnlyFlag() ).as(" usageAuth.getPackage().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getSupplierId() ).as(" usageAuth.getPackage().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDeviceType() ).as(" usageAuth.getPackage().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getUserGroups().length ).as(" usageAuth.getPackage().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getUserGroup() ).as(" usageAuth.getPackage().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPaymentType() ).as(" usageAuth.getPackage().getPricePoint().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getEventDateTime() ).as(" usageAuth.getPackage().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getEventUnits() ).as(" usageAuth.getPackage().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPromoCodes().length ).as(" usageAuth.getPackage().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBearerIds().length ).as(" usageAuth.getPackage().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPromoCode() ).as(" usageAuth.getPackage().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDuration() ).as(" usageAuth.getPackage().getPricePoint().getDuration()" ).isEqualTo(4) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getChargingMethod() ).as(" usageAuth.getPackage().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBearer() ).as(" usageAuth.getPackage().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isInteractive() ).as(" usageAuth.getPackage().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isIncludeUnavailable() ).as(" usageAuth.getPackage().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExpressFlag() ).as(" usageAuth.getPackage().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isExpressFlag() ).as(" usageAuth.getPackage().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isCancellationUsage() ).as(" usageAuth.getPackage().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTierName() ).as(" usageAuth.getPackage().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPromoPrecode() ).as(" usageAuth.getPackage().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getUniquePromoCode() ).as(" usageAuth.getPackage().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPromoUniqueCode() ).as(" usageAuth.getPackage().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getNextCycleDiscount() ).as(" usageAuth.getPackage().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getHasHistoricPricePointFlag() ).as(" usageAuth.getPackage().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isIsForRenewal() ).as(" usageAuth.getPackage().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTaxRateAsDouble() ).as(" usageAuth.getPackage().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAffiliateID() ).as(" usageAuth.getPackage().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPartnerId() ).as(" usageAuth.getPackage().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTariff() ).as(" usageAuth.getPackage().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAggregatorId() ).as(" usageAuth.getPackage().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isForcePurchaseFlow() ).as(" usageAuth.getPackage().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getReceipientMsisdn() ).as(" usageAuth.getPackage().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getProductCode() ).as(" usageAuth.getPackage().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMerchantName() ).as(" usageAuth.getPackage().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getInvoiceText() ).as(" usageAuth.getPackage().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isReIssueEnabled() ).as(" usageAuth.getPackage().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isReIssueFlagPresent() ).as(" usageAuth.getPackage().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getShortPackageId() ).as(" usageAuth.getPackage().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getHistoryStartDate() ).as(" usageAuth.getPackage().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getVendorId() ).as(" usageAuth.getPackage().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isIsForNextPaymentAmount() ).as(" usageAuth.getPackage().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRenewalPreRate() ).as(" usageAuth.getPackage().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" usageAuth.getPackage().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getContentCategory() ).as(" usageAuth.getPackage().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPartnerUrl() ).as(" usageAuth.getPackage().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPartnerContactInfo() ).as(" usageAuth.getPackage().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPartnerEmail() ).as(" usageAuth.getPackage().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPartnerName() ).as(" usageAuth.getPackage().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getSubRenewalPricepointId() ).as(" usageAuth.getPackage().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getLinkPricepointId() ).as(" usageAuth.getPackage().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getSubPurchaseTransactionTrial() ).as(" usageAuth.getPackage().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getPackage().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getPackage().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExtIdentifier1() ).as(" usageAuth.getPackage().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExtIdentifier2() ).as(" usageAuth.getPackage().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExtIdentifier3() ).as(" usageAuth.getPackage().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAccessChannel() ).as(" usageAuth.getPackage().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPurchaseChannel() ).as(" usageAuth.getPackage().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDeviceID() ).as(" usageAuth.getPackage().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getLocal() ).as(" usageAuth.getPackage().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMsisdn() ).as(" usageAuth.getPackage().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getLanguageLocale() ).as(" usageAuth.getPackage().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getLanguageCode() ).as(" usageAuth.getPackage().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExternalField1() ).as(" usageAuth.getPackage().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExternalField2() ).as(" usageAuth.getPackage().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExternalTransId() ).as(" usageAuth.getPackage().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getActiveSubscriptions() ).as(" usageAuth.getPackage().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCsrId() ).as(" usageAuth.getPackage().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getDescription() ).as(" usageAuth.getPackage().getDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getDescription() ).as(" usageAuth.getPackage().getDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricingText1() ).as(" usageAuth.getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricingText1() ).as(" usageAuth.getPackage().getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricingText2() ).as(" usageAuth.getPackage().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricingText2() ).as(" usageAuth.getPackage().getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getUrl() ).as(" usageAuth.getPackage().getUrl()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isDefault() ).as(" usageAuth.getPackage().isDefault()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getRate() ).as(" usageAuth.getPackage().getRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(usageAuth.getPackage().isUseRateCardService() ).as(" usageAuth.getPackage().isUseRateCardService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getRateCardServiceId() ).as(" usageAuth.getPackage().getRateCardServiceId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().isUserGroupCalendarPricePointPackage() ).as(" usageAuth.getPackage().isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isUpsellDiscountProrated() ).as(" usageAuth.getPackage().isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isDisallowPrerate() ).as(" usageAuth.getPackage().isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricingModels().length ).as(" usageAuth.getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().isExpressPurchase() ).as(" usageAuth.getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isRecieptingFlag() ).as(" usageAuth.getPackage().isRecieptingFlag()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray().length ).as(" usageAuth.getPackage().getServiceArray().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getName()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getId() ).as(" usageAuth.getPackage().getServiceArray()[0].getId()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDisplayName() ).as(" usageAuth.getPackage().getServiceArray()[0].getDisplayName()" ).isEqualTo("B001 (B001)");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoint() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricingText1() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricingText1() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricingText2() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricingText2() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProvisioningTag() ).as(" usageAuth.getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" usageAuth.getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo() ).as(" usageAuth.getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isDefaultService() ).as(" usageAuth.getPackage().getServiceArray()[0].isDefaultService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" usageAuth.getPackage().getServiceArray()[0].getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" usageAuth.getPackage().getServiceArray()[0].getProvisioningSystem()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getUsageId() ).as(" usageAuth.getPackage().getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getUsageId() ).as(" usageAuth.getPackage().getServiceArray()[0].getUsageId()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getServiceCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getServiceCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getServiceCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDealName() ).as(" usageAuth.getPackage().getServiceArray()[0].getDealName()" ).isNull();



        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDistributionChannel() ).as(" usageAuth.getPackage().getServiceArray()[0].getDistributionChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" usageAuth.getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isHighVolumeInterface() ).as(" usageAuth.getPackage().getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" usageAuth.getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" usageAuth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" usageAuth.getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getIndirectValue() ).as(" usageAuth.getPackage().getServiceArray()[0].getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getIndirectValue() ).as(" usageAuth.getPackage().getServiceArray()[0].getIndirectValue()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getIndirectValueFormat() ).as(" usageAuth.getPackage().getServiceArray()[0].getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPromoValue() ).as(" usageAuth.getPackage().getServiceArray()[0].getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPromoValue() ).as(" usageAuth.getPackage().getServiceArray()[0].getPromoValue()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPromoValueFormat() ).as(" usageAuth.getPackage().getServiceArray()[0].getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getContentSubCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getContentSubCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getContentSubCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getContentItem() ).as(" usageAuth.getPackage().getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getContentItem() ).as(" usageAuth.getPackage().getServiceArray()[0].getContentItem()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" usageAuth.getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" usageAuth.getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductSubCategory1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductSubCategory2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isVolumeService() ).as(" usageAuth.getPackage().getServiceArray()[0].isVolumeService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getProductFk() ).as(" usageAuth.getPackage().getServiceArray()[0].getProductFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isServiceShareOverride() ).as(" usageAuth.getPackage().getServiceArray()[0].isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isExpiredPackageService() ).as(" usageAuth.getPackage().getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getFixedUsageAmount() ).as(" usageAuth.getPackage().getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getHasExpress() ).as(" usageAuth.getPackage().getServiceArray()[0].getHasExpress()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getHasDynamicDefault() ).as(" usageAuth.getPackage().getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getHasSuperPackage() ).as(" usageAuth.getPackage().getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" usageAuth.getPackage().getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getServiceClass() ).as(" usageAuth.getPackage().getServiceArray()[0].getServiceClass()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getBandRevenueShares() ).as(" usageAuth.getPackage().getServiceArray()[0].getBandRevenueShares()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isReIssuePermittedFlag() ).as(" usageAuth.getPackage().getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getChargeableBy() ).as(" usageAuth.getPackage().getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPackageIds().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isMicroService() ).as(" usageAuth.getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" usageAuth.getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" usageAuth.getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].ismRefundable() ).as(" usageAuth.getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" usageAuth.getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isUseRateCard() ).as(" usageAuth.getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getInternalPartner() ).as(" usageAuth.getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getRateCardPartners() ).as(" usageAuth.getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" usageAuth.getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isGlobalHandler() ).as(" usageAuth.getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" usageAuth.getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" usageAuth.getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" usageAuth.getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getUrl() ).as(" usageAuth.getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getUrl() ).as(" usageAuth.getPackage().getServiceArray()[0].getUrl()" ).isEqualTo("");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricingModels().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getNotificationCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getNotificationCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getNotificationCategory()" ).isEqualTo("");
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" usageAuth.getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getSalesModel() ).as(" usageAuth.getPackage().getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].isRefundable() ).as(" usageAuth.getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().size()).as("usageAuth.getPackage().getServiceArray()[0].getPricePoints().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServiceArray()[0].getPricePoints().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getDescription()" ).isEqualTo("Default (event) ");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getStandardRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getNetRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isDiscount() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getDiscountPromoText() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getDiscountPromoText() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPackageId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getContentId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getContentId()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText1() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText1() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText2() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText2() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getUsageTime() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAccessDuration() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isZeroCostIgnore() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getExpiryDate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isActive() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isPreOrder() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTaxRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTaxCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getStartDate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingModelTier() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isArchived() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isBasePricePoint() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAccessDevice() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAlternativeRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(1.175)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().size()).as("usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isTrial() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getGlid() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getGlid() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricepointIdLink() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isPreview() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getInteractiveFlag() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isForcedPurchase() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFixedExpiryDate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isReserveOnly() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getMinSubPeriod() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPenaltyCharges() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCancellation() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getMonthEndSubscription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isHistoric() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFixedRecurrence() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isReceipting() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getReceiptingAttribute() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getOrder() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPaymentHandler() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isPromo() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTranslatedPricingText1() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTranslatedPricingText2() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRecurrenceDay() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isAlignWithExternal() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getGracePeriod() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRetryFrequency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getSuspensionPeriod() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTranslatedPricingText() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFairUsageLimit() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFairUsagePeriod() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getExtensionPeriod() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isTariff() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getKey()" ).isNull();
//check size of list!
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().size()).as("usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).value() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).value() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).value() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRate() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances().length ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isRecurring() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getKey() ).as(" usageAuth.getPackage().getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }

    }

}
