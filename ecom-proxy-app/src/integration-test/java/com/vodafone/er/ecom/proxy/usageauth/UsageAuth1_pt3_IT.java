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
public class UsageAuth1_pt3_IT {

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

        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExtIdentifier1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExtIdentifier2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExtIdentifier3() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAccessChannel() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPurchaseChannel() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDeviceID() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getLocal() ).as(" usageAuth.getPackage().getPricePoints().get(1).getLocal()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(1).getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getLanguageLocale() ).as(" usageAuth.getPackage().getPricePoints().get(1).getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getLanguageCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExternalField1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExternalField2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExternalTransId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getActiveSubscriptions() ).as(" usageAuth.getPackage().getPricePoints().get(1).getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCsrId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getId()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDescription()" ).isEqualTo("Recurring 1 month");
//check size of array!
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getStandardRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getStandardRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getNetRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getNetRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(2).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(2).isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getContentId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getUsageTime() ).as(" usageAuth.getPackage().getPricePoints().get(2).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAccessDuration() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isZeroCostIgnore() ).as(" usageAuth.getPackage().getPricePoints().get(2).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExpiryDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isActive() ).as(" usageAuth.getPackage().getPricePoints().get(2).isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isPreOrder() ).as(" usageAuth.getPackage().getPricePoints().get(2).isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingModelTier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isArchived() ).as(" usageAuth.getPackage().getPricePoints().get(2).isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isBasePricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAccessDevice() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAlternativeRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAlternativeRate()" ).isEqualTo(new Double(8.225)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isResource()" ).isFalse() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().size()).as("usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isTrial() ).as(" usageAuth.getPackage().getPricePoints().get(2).isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(2).getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(2).getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isPreview() ).as(" usageAuth.getPackage().getPricePoints().get(2).isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getInteractiveFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isForcedPurchase() ).as(" usageAuth.getPackage().getPricePoints().get(2).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getPricePoints().get(2).isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFixedExpiryDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isReserveOnly() ).as(" usageAuth.getPackage().getPricePoints().get(2).isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getMinSubPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPenaltyCharges() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCancellation() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getMonthEndSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isHistoric() ).as(" usageAuth.getPackage().getPricePoints().get(2).isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFixedRecurrence() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isReceipting() ).as(" usageAuth.getPackage().getPricePoints().get(2).isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getReceiptingAttribute() ).as(" usageAuth.getPackage().getPricePoints().get(2).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getOrder() ).as(" usageAuth.getPackage().getPricePoints().get(2).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getNonMatchAllUserGroups().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isPromo() ).as(" usageAuth.getPackage().getPricePoints().get(2).isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isSubmitToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(2).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isSuppressToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(2).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getRecurrenceDay() ).as(" usageAuth.getPackage().getPricePoints().get(2).getRecurrenceDay()" ).isEqualTo(0) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isAlignWithExternal() ).as(" usageAuth.getPackage().getPricePoints().get(2).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getGracePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getRetryFrequency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getSuspensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPackage().getPricePoints().get(2).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFairUsageLimit() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExtensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getPricePoints().get(2).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(2).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isTariff() ).as(" usageAuth.getPackage().getPricePoints().get(2).isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getPricePoints().get(2).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getKey()" ).isNull();
//check size of list!
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size()).as("usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).value() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).value() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).value() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(2).isRecurring()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPricingModel() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getTier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPackageIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getServiceIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_*_999_10010_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getPricePoints().get(2).getStandardRateWithoutTax()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isVolumeType() ).as(" usageAuth.getPackage().getPricePoints().get(2).isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isOriginal() ).as(" usageAuth.getPackage().getPricePoints().get(2).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getTier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getProtectedFk() ).as(" usageAuth.getPackage().getPricePoints().get(2).getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getmPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getmPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getmPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getmPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isNonRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(2).isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isEvent() ).as(" usageAuth.getPackage().getPricePoints().get(2).isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getChannel() ).as(" usageAuth.getPackage().getPricePoints().get(2).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getMultiUsageMode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getNetworkCodeMatchMethod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isPreRatePriceGross() ).as(" usageAuth.getPackage().getPricePoints().get(2).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPreRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPaymentInformation() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getContentName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getContentName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAssetID() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPremiumLevel() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getReserveOnlyFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getSupplierId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDeviceType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getUserGroups().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getUserGroup() ).as(" usageAuth.getPackage().getPricePoints().get(2).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPaymentType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getEventDateTime() ).as(" usageAuth.getPackage().getPricePoints().get(2).getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getEventUnits() ).as(" usageAuth.getPackage().getPricePoints().get(2).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPromoCodes().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBearerIds().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDuration() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDuration()" ).isEqualTo(4) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getChargingMethod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBearer() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isInteractive() ).as(" usageAuth.getPackage().getPricePoints().get(2).isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isIncludeUnavailable() ).as(" usageAuth.getPackage().getPricePoints().get(2).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExpressFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isExpressFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isCancellationUsage() ).as(" usageAuth.getPackage().getPricePoints().get(2).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTierName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTierName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPromoPrecode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getUniquePromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPromoUniqueCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getNextCycleDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getHasHistoricPricePointFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isIsForRenewal() ).as(" usageAuth.getPackage().getPricePoints().get(2).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTaxRateAsDouble() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAffiliateID() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPartnerId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTariff() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAggregatorId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isForcePurchaseFlow() ).as(" usageAuth.getPackage().getPricePoints().get(2).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getReceipientMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(2).getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getProductCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getMerchantName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getInvoiceText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isReIssueEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(2).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isReIssueFlagPresent() ).as(" usageAuth.getPackage().getPricePoints().get(2).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getShortPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getHistoryStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getVendorId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isIsForNextPaymentAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getRenewalPreRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isOverrideDisallowPreRateFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getContentCategory() ).as(" usageAuth.getPackage().getPricePoints().get(2).getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPartnerUrl() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPartnerContactInfo() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPartnerEmail() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPartnerName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getSubRenewalPricepointId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getLinkPricepointId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getSubPurchaseTransactionTrial() ).as(" usageAuth.getPackage().getPricePoints().get(2).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getPackage().getPricePoints().get(2).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExtIdentifier1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExtIdentifier2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExtIdentifier3() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAccessChannel() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPurchaseChannel() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDeviceID() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getLocal() ).as(" usageAuth.getPackage().getPricePoints().get(2).getLocal()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(2).getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getLanguageLocale() ).as(" usageAuth.getPackage().getPricePoints().get(2).getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getLanguageCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExternalField1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExternalField2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExternalTransId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getActiveSubscriptions() ).as(" usageAuth.getPackage().getPricePoints().get(2).getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCsrId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCsrId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServicesNotInPackageFairUsagePolicyList() ).as(" usageAuth.getPackage().getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isHasParentSub() ).as(" usageAuth.getPackage().isHasParentSub()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getParentSubId() ).as(" usageAuth.getPackage().getParentSubId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isHasParentSubSuspendedResProv() ).as(" usageAuth.getPackage().isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getParentSubStatus() ).as(" usageAuth.getPackage().getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPromoCodeMap() ).as(" usageAuth.getPackage().getPromoCodeMap()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPromoCodeMapSize() ).as(" usageAuth.getPackage().getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPackageType() ).as(" usageAuth.getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(usageAuth.getPackage().getNonRefundableDescription() ).as(" usageAuth.getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getNonRefundableDescription() ).as(" usageAuth.getPackage().getNonRefundableDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getUserGroupComparisonAtRenewal() ).as(" usageAuth.getPackage().getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
        softly.assertThat(usageAuth.getPackage().isDataVoiceTariffInclusive() ).as(" usageAuth.getPackage().isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isUseBeingDeprovisionedStatus() ).as(" usageAuth.getPackage().isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getDisallowDuplicateSubPurchase() ).as(" usageAuth.getPackage().getDisallowDuplicateSubPurchase()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().isPricePointOrder() ).as(" usageAuth.getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isSuperPackage() ).as(" usageAuth.getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isRevenueShareByUsage() ).as(" usageAuth.getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isDynamicDefault() ).as(" usageAuth.getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getACEPackage() ).as(" usageAuth.getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isUpSell() ).as(" usageAuth.getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getFullPackagePricepointId() ).as(" usageAuth.getPackage().getFullPackagePricepointId()" ).isEqualTo("BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
        softly.assertThat(usageAuth.getPackage().getDefaultPartnerProvisioningId() ).as(" usageAuth.getPackage().getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getActiveStatusAsString() ).as(" usageAuth.getPackage().getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(usageAuth.getPackage().isGoodwillCredit() ).as(" usageAuth.getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isEventPackage() ).as(" usageAuth.getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isRecurringPackage() ).as(" usageAuth.getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getNoActivePricepoints() ).as(" usageAuth.getPackage().getNoActivePricepoints()" ).isEqualTo(3) ;
        softly.assertThat(usageAuth.getPackage().isHasBalanceImpactsWithDate() ).as(" usageAuth.getPackage().isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isHasPricePointsWithDate() ).as(" usageAuth.getPackage().isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isHasPromosWithDate() ).as(" usageAuth.getPackage().isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isHasTaxRateWithDate() ).as(" usageAuth.getPackage().isHasTaxRateWithDate()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceNames().length ).as(" usageAuth.getPackage().getServiceNames().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getProtectedType() ).as(" usageAuth.getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getProtectedType() ).as(" usageAuth.getPackage().getProtectedType()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getDynamicProtectedValue() ).as(" usageAuth.getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getDynamicProtectedValue() ).as(" usageAuth.getPackage().getDynamicProtectedValue()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPurchaseMethod() ).as(" usageAuth.getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPurchaseMethod() ).as(" usageAuth.getPackage().getPurchaseMethod()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getKpiPackageProductCategory() ).as(" usageAuth.getPackage().getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getKpiPackageType() ).as(" usageAuth.getPackage().getKpiPackageType()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().isParentPackage() ).as(" usageAuth.getPackage().isParentPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getChildPackages() ).as(" usageAuth.getPackage().getChildPackages()" ).isNull();
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getLogoId() ).as(" usageAuth.getPackage().getLogoId()" ).isNull();
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPartnerInfo() ).as(" usageAuth.getPackage().getPartnerInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getIsPackageModel() ).as(" usageAuth.getPackage().getIsPackageModel()" ).isFalse() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().size()).as("usageAuth.getPackage().getServices().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().size() >= 1);
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getName() ).as(" usageAuth.getPackage().getServices().get(0).getName()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getId() ).as(" usageAuth.getPackage().getServices().get(0).getId()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDisplayName() ).as(" usageAuth.getPackage().getServices().get(0).getDisplayName()" ).isEqualTo("B001 (B001)");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricingText1() ).as(" usageAuth.getPackage().getServices().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricingText2() ).as(" usageAuth.getPackage().getServices().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProvisioningTag() ).as(" usageAuth.getPackage().getServices().get(0).getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isProvisionOnUsage() ).as(" usageAuth.getPackage().getServices().get(0).isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isReturnAllCatalogueServicesInfo() ).as(" usageAuth.getPackage().getServices().get(0).isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isDefaultService() ).as(" usageAuth.getPackage().getServices().get(0).isDefaultService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProvisioningSystem() ).as(" usageAuth.getPackage().getServices().get(0).getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProvisioningSystem() ).as(" usageAuth.getPackage().getServices().get(0).getProvisioningSystem()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getUsageId() ).as(" usageAuth.getPackage().getServices().get(0).getUsageId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getUsageId() ).as(" usageAuth.getPackage().getServices().get(0).getUsageId()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceCategory() ).as(" usageAuth.getPackage().getServices().get(0).getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceCategory() ).as(" usageAuth.getPackage().getServices().get(0).getServiceCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDealName() ).as(" usageAuth.getPackage().getServices().get(0).getDealName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDistributionChannel() ).as(" usageAuth.getPackage().getServices().get(0).getDistributionChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getHighVolumeInterfaceLevel() ).as(" usageAuth.getPackage().getServices().get(0).getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isHighVolumeInterface() ).as(" usageAuth.getPackage().getServices().get(0).isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceRevenueSharePartners().length ).as(" usageAuth.getPackage().getServices().get(0).getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceRevenueSharePartnerNum() ).as(" usageAuth.getPackage().getServices().get(0).getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceRevenueSharePartnersPurchaseCh().length ).as(" usageAuth.getPackage().getServices().get(0).getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getIndirectValue() ).as(" usageAuth.getPackage().getServices().get(0).getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getIndirectValue() ).as(" usageAuth.getPackage().getServices().get(0).getIndirectValue()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getIndirectValueFormat() ).as(" usageAuth.getPackage().getServices().get(0).getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPromoValue() ).as(" usageAuth.getPackage().getServices().get(0).getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPromoValue() ).as(" usageAuth.getPackage().getServices().get(0).getPromoValue()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPromoValueFormat() ).as(" usageAuth.getPackage().getServices().get(0).getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getContentSubCategory() ).as(" usageAuth.getPackage().getServices().get(0).getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getContentSubCategory() ).as(" usageAuth.getPackage().getServices().get(0).getContentSubCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getContentItem() ).as(" usageAuth.getPackage().getServices().get(0).getContentItem()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getContentItem() ).as(" usageAuth.getPackage().getServices().get(0).getContentItem()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDeliveryMechanism() ).as(" usageAuth.getPackage().getServices().get(0).getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getDeliveryMechanism() ).as(" usageAuth.getPackage().getServices().get(0).getDeliveryMechanism()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductCategory() ).as(" usageAuth.getPackage().getServices().get(0).getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductCategory() ).as(" usageAuth.getPackage().getServices().get(0).getProductCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductSubCategory1() ).as(" usageAuth.getPackage().getServices().get(0).getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductSubCategory1() ).as(" usageAuth.getPackage().getServices().get(0).getProductSubCategory1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductSubCategory2() ).as(" usageAuth.getPackage().getServices().get(0).getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductSubCategory2() ).as(" usageAuth.getPackage().getServices().get(0).getProductSubCategory2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductWholesalePrice() ).as(" usageAuth.getPackage().getServices().get(0).getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductWholesalePrice() ).as(" usageAuth.getPackage().getServices().get(0).getProductWholesalePrice()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductSelfRegulation() ).as(" usageAuth.getPackage().getServices().get(0).getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductSelfRegulation() ).as(" usageAuth.getPackage().getServices().get(0).getProductSelfRegulation()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isVolumeService() ).as(" usageAuth.getPackage().getServices().get(0).isVolumeService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getProductFk() ).as(" usageAuth.getPackage().getServices().get(0).getProductFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isServiceShareOverride() ).as(" usageAuth.getPackage().getServices().get(0).isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isExpiredPackageService() ).as(" usageAuth.getPackage().getServices().get(0).isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getFixedUsageAmount() ).as(" usageAuth.getPackage().getServices().get(0).getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getHasExpress() ).as(" usageAuth.getPackage().getServices().get(0).getHasExpress()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getHasDynamicDefault() ).as(" usageAuth.getPackage().getServices().get(0).getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getHasSuperPackage() ).as(" usageAuth.getPackage().getServices().get(0).getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isReturnTrialOptionsOnly() ).as(" usageAuth.getPackage().getServices().get(0).isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceClass() ).as(" usageAuth.getPackage().getServices().get(0).getServiceClass()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getBandRevenueShares() ).as(" usageAuth.getPackage().getServices().get(0).getBandRevenueShares()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isReIssuePermittedFlag() ).as(" usageAuth.getPackage().getServices().get(0).isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getChargeableBy() ).as(" usageAuth.getPackage().getServices().get(0).getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPackageIds().length ).as(" usageAuth.getPackage().getServices().get(0).getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isMicroService() ).as(" usageAuth.getPackage().getServices().get(0).isMicroService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getSuperPackageIds() ).as(" usageAuth.getPackage().getServices().get(0).getSuperPackageIds()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getmExternalServPricePlan() ).as(" usageAuth.getPackage().getServices().get(0).getmExternalServPricePlan()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).ismRefundable() ).as(" usageAuth.getPackage().getServices().get(0).ismRefundable()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).ismReturnTrialOptionsOnly() ).as(" usageAuth.getPackage().getServices().get(0).ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isUseRateCard() ).as(" usageAuth.getPackage().getServices().get(0).isUseRateCard()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getInternalPartner() ).as(" usageAuth.getPackage().getServices().get(0).getInternalPartner()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getRateCardPartners() ).as(" usageAuth.getPackage().getServices().get(0).getRateCardPartners()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isUsageAllowedBeingProvisionedSub() ).as(" usageAuth.getPackage().getServices().get(0).isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isGlobalHandler() ).as(" usageAuth.getPackage().getServices().get(0).isGlobalHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isGlobalHandlerNotification() ).as(" usageAuth.getPackage().getServices().get(0).isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPriorityServiceRevenueSharePartner() ).as(" usageAuth.getPackage().getServices().get(0).getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isUniqueServiceClass() ).as(" usageAuth.getPackage().getServices().get(0).isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getUrl() ).as(" usageAuth.getPackage().getServices().get(0).getUrl()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getUrl() ).as(" usageAuth.getPackage().getServices().get(0).getUrl()" ).isEqualTo("");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricingModels().length ).as(" usageAuth.getPackage().getServices().get(0).getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getNotificationCategory() ).as(" usageAuth.getPackage().getServices().get(0).getNotificationCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getNotificationCategory() ).as(" usageAuth.getPackage().getServices().get(0).getNotificationCategory()" ).isEqualTo("");
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getDescription()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getCategory() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getCategory()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getMerchant() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getMerchant()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getMerchantDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getMerchantDescription()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getItemVolume() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getItemVolume()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getServiceType() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getServiceType()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPaymentContent().getPromotion() ).as(" usageAuth.getPackage().getServices().get(0).getPaymentContent().getPromotion()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getSalesModel() ).as(" usageAuth.getPackage().getServices().get(0).getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isRefundable() ).as(" usageAuth.getPackage().getServices().get(0).isRefundable()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().size()).as("usageAuth.getPackage().getServices().get(0).getPricePoints().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().get(0).getPricePoints().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDescription()" ).isEqualTo("Default (event) ");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getStandardRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNetRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isDiscount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDiscountPromoText() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDiscountPromoText() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPackageId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getContentId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getContentId()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUsageTime() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessDuration() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isZeroCostIgnore() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExpiryDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isActive() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPreOrder() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTaxRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTaxCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getStartDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingModelTier() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isArchived() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isBasePricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessDevice() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAlternativeRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(1.175)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size()).as("usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isTrial() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getGlid() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getGlid() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricepointIdLink() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPreview() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getInteractiveFlag() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isForcedPurchase() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedExpiryDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReserveOnly() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMinSubPeriod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPenaltyCharges() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCancellation() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMonthEndSubscription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isHistoric() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedRecurrence() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReceipting() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getReceiptingAttribute() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getReceiptingAttribute()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getOrder() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentHandler() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPromo() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRecurrenceDay() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isAlignWithExternal() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getGracePeriod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRetryFrequency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSuspensionPeriod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsageLimit() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtensionPeriod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isTariff() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getKey()" ).isNull();
//check size of list!
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size()).as("usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).value() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).value() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).value() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isRecurring() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPricingModel() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getTier() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().isDefaultPPT() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().size()).as("usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPackageIdentifier() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getServiceIdentifier() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isVolumeType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isOriginal() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;




        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getTier() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getProtectedFk() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isNonRecurring() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isEvent() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getChannel() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMultiUsageMode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNetworkCodeMatchMethod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPreRatePriceGross() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPreRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentInformation() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getContentName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getContentName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAssetID() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPremiumLevel() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getReserveOnlyFlag() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSupplierId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDeviceType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUserGroups().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUserGroup() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentType() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getEventDateTime() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getEventUnits() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoCodes().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBearerIds().length ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDuration() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDuration()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getChargingMethod() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBearer() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isInteractive() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIncludeUnavailable() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExpressFlag() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isExpressFlag() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isCancellationUsage() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTierName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTierName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoPrecode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUniquePromoCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoUniqueCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNextCycleDiscount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getHasHistoricPricePointFlag() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIsForRenewal() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTaxRateAsDouble() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAffiliateID() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTariff() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAggregatorId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isForcePurchaseFlow() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getReceipientMsisdn() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getProductCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMerchantName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getInvoiceText() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReIssueEnabled() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReIssueFlagPresent() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getShortPackageId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getHistoryStartDate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getVendorId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIsForNextPaymentAmount() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRenewalPreRate() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isOverrideDisallowPreRateFlag() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getContentCategory() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerUrl() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerContactInfo() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerEmail() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerName() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSubRenewalPricepointId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLinkPricepointId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSubPurchaseTransactionTrial() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtIdentifier1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtIdentifier2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtIdentifier3() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessChannel() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPurchaseChannel() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDeviceID() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLocal() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLocal()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMsisdn() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLanguageLocale() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLanguageCode() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExternalField1() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExternalField2() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExternalTransId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getActiveSubscriptions() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCsrId() ).as(" usageAuth.getPackage().getServices().get(0).getPricePoints().get(0).getCsrId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getNonRefundableDescription() ).as(" usageAuth.getPackage().getServices().get(0).getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getNonRefundableDescription() ).as(" usageAuth.getPackage().getServices().get(0).getNonRefundableDescription()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getServiceType() ).as(" usageAuth.getPackage().getServices().get(0).getServiceType()" ).isEqualTo("service");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getTaxCode() ).as(" usageAuth.getPackage().getServices().get(0).getTaxCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getContentCategory() ).as(" usageAuth.getPackage().getServices().get(0).getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getServices().get(0).getContentCategory() ).as(" usageAuth.getPackage().getServices().get(0).getContentCategory()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getServices().get(0).isReserveOnly() ).as(" usageAuth.getPackage().getServices().get(0).isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().isActive() ).as(" usageAuth.getPackage().isActive()" ).isTrue() ;
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getTaxCode() ).as(" usageAuth.getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getParentPackageId() ).as(" usageAuth.getPackage().getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getParentPackageId() ).as(" usageAuth.getPackage().getParentPackageId()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().isReserveOnly() ).as(" usageAuth.getPackage().isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().isOriginal() ).as(" usageAuth.getPackage().isOriginal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricingModel() ).as(" usageAuth.getPackage().getPricingModel()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getResource().getName() ).as(" usageAuth.getResource().getName()" ).isNull();
        softly.assertThat(usageAuth.getResource().getCode() ).as(" usageAuth.getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getResource().getDescription() ).as(" usageAuth.getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getResource().getCountryId() ).as(" usageAuth.getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getResource().getResourceName() ).as(" usageAuth.getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getResource().isToken() ).as(" usageAuth.getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isUsageToken() ).as(" usageAuth.getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isPayToken() ).as(" usageAuth.getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().getResourceSymbol() ).as(" usageAuth.getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getResource().isCurrency() ).as(" usageAuth.getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isResource() ).as(" usageAuth.getResource().isResource()" ).isTrue() ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getPricePoint().getResource().getName() ).as(" usageAuth.getPricePoint().getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPricePoint().getResource().getCode() ).as(" usageAuth.getPricePoint().getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPricePoint().getResource().getDescription() ).as(" usageAuth.getPricePoint().getResource().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPricePoint().getResource().getCountryId() ).as(" usageAuth.getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPricePoint().getResource().getResourceName() ).as(" usageAuth.getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPricePoint().getResource().isToken() ).as(" usageAuth.getPricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getResource().isUsageToken() ).as(" usageAuth.getPricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getResource().isPayToken() ).as(" usageAuth.getPricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getResource().getResourceSymbol() ).as(" usageAuth.getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPricePoint().getResource().isCurrency() ).as(" usageAuth.getPricePoint().getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getResource().isResource() ).as(" usageAuth.getPricePoint().getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getKey() ).as(" usageAuth.getPricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getId() ).as(" usageAuth.getPricePoint().getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(usageAuth.getPricePoint().getDescription() ).as(" usageAuth.getPricePoint().getDescription()" ).isEqualTo("Default (event) ");
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances().length ).as(" usageAuth.getPricePoint().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getBalance() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getStandardRate() ).as(" usageAuth.getPricePoint().getStandardRate()" ).isEqualTo(new Double(1.18)) ;
        softly.assertThat(usageAuth.getPricePoint().getNetRate() ).as(" usageAuth.getPricePoint().getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isDiscount() ).as(" usageAuth.getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getPackageId() ).as(" usageAuth.getPricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(usageAuth.getPricePoint().getContentId() ).as(" usageAuth.getPricePoint().getContentId()" ).isEqualTo("B001");
        softly.assertThat(usageAuth.getPricePoint().getPricingText1() ).as(" usageAuth.getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getPricingText1() ).as(" usageAuth.getPricePoint().getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getPricingText2() ).as(" usageAuth.getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getPricingText2() ).as(" usageAuth.getPricePoint().getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricePoint().getUsageTime() ).as(" usageAuth.getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPricePoint().getAccessDuration() ).as(" usageAuth.getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isZeroCostIgnore() ).as(" usageAuth.getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances().length ).as(" usageAuth.getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getExpiryDate() ).as(" usageAuth.getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getRate() ).as(" usageAuth.getPricePoint().getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().isActive() ).as(" usageAuth.getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().isPreOrder() ).as(" usageAuth.getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getTaxRate() ).as(" usageAuth.getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPricePoint().getTaxCode() ).as(" usageAuth.getPricePoint().getTaxCode()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getStartDate() ).as(" usageAuth.getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getPricingModelTier() ).as(" usageAuth.getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isArchived() ).as(" usageAuth.getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isBasePricePoint() ).as(" usageAuth.getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getAccessDevice() ).as(" usageAuth.getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPricePoint().getAlternativeRate() ).as(" usageAuth.getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(1.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts().length ).as(" usageAuth.getPricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].getName() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getPricePoint().getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPricePoint().getBalanceImpacts()[0].isResource()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().size()).as("usageAuth.getPricePoint().getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPricePoint().getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPricePoint().getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().isTrial() ).as(" usageAuth.getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getGlid() ).as(" usageAuth.getPricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().getGlid() ).as(" usageAuth.getPricePoint().getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPricePoint().getPricepointIdLink() ).as(" usageAuth.getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricePoint().isPreview() ).as(" usageAuth.getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getInteractiveFlag() ).as(" usageAuth.getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPricePoint().isForcedPurchase() ).as(" usageAuth.getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(usageAuth.getPricePoint().getFixedExpiryDate() ).as(" usageAuth.getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().isReserveOnly() ).as(" usageAuth.getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getMinSubPeriod() ).as(" usageAuth.getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPricePoint().getPenaltyCharges() ).as(" usageAuth.getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPricePoint().getCancellation() ).as(" usageAuth.getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getMonthEndSubscription() ).as(" usageAuth.getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPricePoint().isHistoric() ).as(" usageAuth.getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getFixedRecurrence() ).as(" usageAuth.getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPricePoint().isFixedRecurringPricePoint() ).as(" usageAuth.getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().isReceipting() ).as(" usageAuth.getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getReceiptingAttribute() ).as(" usageAuth.getPricePoint().getReceiptingAttribute()" ).isNull();
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
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPricePoint().isAlignWithExternal() ).as(" usageAuth.getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPricePoint().getGracePeriod() ).as(" usageAuth.getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPricePoint().getRetryFrequency() ).as(" usageAuth.getPricePoint().getRetryFrequency()" ).isNull();

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }

    }

}
