package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PurchasePackageMsisdnIT {

    SoftAssertions softly = new SoftAssertions();

    @Test
    public void testPurchasePackageMsisdn1() throws Exception {

        final String msisdn = String.valueOf(new Random().nextInt());
        System.out.println("Using msisdn=" + msisdn);

        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*", new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());


        softly.assertThat(auth.getTransferUrl() ).as(" auth.getTransferUrl()" ).isEqualTo("P00007/9Z 1469108451439");
        softly.assertThat(auth.getSubscriptions() ).as(" auth.getSubscriptions()" ).isNull();
        softly.assertThat(auth.getUndiscountedStandardGrossRate() ).as(" auth.getUndiscountedStandardGrossRate()" ).isEqualTo(new Double(12.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getResourceBalances() ).as(" auth.getResourceBalances()" ).isEqualTo(0).isNotNull() ;
//        softly.assertThat(auth.getResourceBalances()[0].getThreshold() ).as(" auth.getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getResourceBalances()[0].getPackageId() ).as(" auth.getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(auth.getResourceBalances()[0].getSubscription() ).as(" auth.getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(auth.getResourceBalances()[0].getBalance() ).as(" auth.getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
//        softly.assertThat(auth.getResourceBalances()[0].getSubscriptionId() ).as(" auth.getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(auth.getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(auth.getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.isAuthorized() ).as(" auth.isAuthorized()" ).isTrue() ;
// com.vizzavi.ecommerce.business.catalog.internal.CatalogPackageImpl
// com.vizzavi.ecommerce.business.common.ChargingResource
// com.vizzavi.ecommerce.business.common.ReasonCode
        //TODO BaseAuth mPaymentStatusEnum is null and causes this to fail
//        softly.assertThat(auth.isValid() ).as(" auth.isValid()" ).isTrue() ;
        softly.assertThat(auth.isCharged() ).as(" auth.isCharged()" ).isTrue() ;
        softly.assertThat(auth.getUserResourceBalance() ).as(" auth.getUserResourceBalance()" ).isNull();
        softly.assertThat(auth.getTaxAmount() ).as(" auth.getTaxAmount()" ).isEqualTo(new Double(1.75)) ;
        softly.assertThat(auth.getAuthorized() ).as(" auth.getAuthorized()" ).isTrue() ;
        softly.assertThat(auth.getPaymentInfo() ).as(" auth.getPaymentInfo()" ).isEqualTo("This is payment info from Pay Auth handler");
        softly.assertThat(auth.getReceiptingCreditBalanceImpact() ).as(" auth.getReceiptingCreditBalanceImpact()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getReceiptingUsageTypeAttribute() ).as(" auth.getReceiptingUsageTypeAttribute()" ).isEqualTo(-1) ;
        softly.assertThat(auth.isServiceSubmit() ).as(" auth.isServiceSubmit()" ).isFalse() ;
// [J
        softly.assertThat(auth.isReservedOnly() ).as(" auth.isReservedOnly()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ResponseStatus
//        softly.assertThat(auth.getPackageSubscriptionIdLong() ).as(" auth.getPackageSubscriptionIdLong()" ).isEqualTo(new Long(18)) ;
        softly.assertThat(auth.getPackageSubscriptionIdLong() ).as(" auth.getPackageSubscriptionIdLong()" ).isNotNull().isGreaterThan(0);
//        softly.assertThat(auth.getTransactionIdLong() ).as(" auth.getTransactionIdLong()" ).isEqualTo(new Long(9)) ;
        softly.assertThat(auth.getTransactionIdLong() ).as(" auth.getTransactionIdLong()" ).isNotNull().isGreaterThan(0);
//        softly.assertThat(auth.getTransactionId() ).as(" auth.getTransactionId()" ).isEqualTo("9");
        softly.assertThat(auth.getTransactionId() ).as(" auth.getTransactionId()" ).isNotNull().isNotEmpty();
        softly.assertThat(auth.getPaymentStatus() ).as(" auth.getPaymentStatus()" ).isEqualTo(1) ;
// com.vodafone.global.er.payment.PaymentAuthStatus
        softly.assertThat(auth.getMicroServiceSubList() ).as(" auth.getMicroServiceSubList()" ).isNull();
        softly.assertThat(auth.getValidMicroServiceSub() ).as(" auth.getValidMicroServiceSub()" ).isNull();
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(auth.getPaymentErrorId() ).as(" auth.getPaymentErrorId()" ).isEqualTo("OK");
        softly.assertThat(auth.getPaymentErrorDescription() ).as(" auth.getPaymentErrorDescription()" ).isNull();
        softly.assertThat(auth.getPaymentId() ).as(" auth.getPaymentId()" ).isEqualTo("P00007/9Z");
        softly.assertThat(auth.getEventReservationId() ).as(" auth.getEventReservationId()" ).isEqualTo("P00007/9Z");
//        softly.assertThat(auth.getPackageSubscriptionId() ).as(" auth.getPackageSubscriptionId()" ).isEqualTo("18");
        softly.assertThat(auth.getPackageSubscriptionId() ).as(" auth.getPackageSubscriptionId()" ).isNotNull().isNotEmpty().isEqualTo(String.valueOf(auth.getPackageSubscriptionIdLong()));
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
        softly.assertThat(auth.getErrorId() ).as(" auth.getErrorId()" ).isEqualTo("OK");
        softly.assertThat(auth.getErrorDescription() ).as(" auth.getErrorDescription()" ).isNull();
        softly.assertThat(auth.getSubscription() ).as(" auth.getSubscription()" ).isNull();
        softly.assertThat(auth.getContentName() ).as(" auth.getContentName()" ).isNull();
        softly.assertThat(auth.isInteractive() ).as(" auth.isInteractive()" ).isFalse() ;
        softly.assertThat(auth.getPartnerId() ).as(" auth.getPartnerId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions() ).as(" auth.getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getAuthCode() ).as(" auth.getAuthCode()" ).isEqualTo("P00007/9Z 1469108451439");
        softly.assertThat(auth.getRate() ).as(" auth.getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(auth.getStandardRate() ).as(" auth.getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(auth.getAlternativeTaxCode() ).as(" auth.getAlternativeTaxCode()" ).isNull();
        softly.assertThat(auth.getAlternativeTaxRate() ).as(" auth.getAlternativeTaxRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getAlternativeTaxAmount() ).as(" auth.getAlternativeTaxAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getTaxRate() ).as(" auth.getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getTaxCode() ).as(" auth.getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(auth.isSuccess() ).as(" auth.isSuccess()" ).isTrue() ;
// java.util.Date
        softly.assertThat(auth.getNetRate() ).as(" auth.getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(auth.isAlwaysValidateMsisdn() ).as(" auth.isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getCurrencyId() ).as(" auth.getCurrencyId()" ).isEqualTo(826) ;
// com.vizzavi.ecommerce.business.common.ChargingResource

        //TODO auth.getCustomResourceBalances() is null
//        softly.assertThat(auth.getCustomResourceBalances()[0].getThreshold() ).as(" auth.getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getCustomResourceBalances()[0].getPackageId() ).as(" auth.getCustomResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(auth.getCustomResourceBalances()[0].getSubscription() ).as(" auth.getCustomResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(auth.getCustomResourceBalances()[0].getBalance() ).as(" auth.getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
//        softly.assertThat(auth.getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(auth.getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(auth.getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getNetStandardRate() ).as(" auth.getNetStandardRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(auth.getRatingSystemId() ).as(" auth.getRatingSystemId()" ).isEqualTo("ER");
        softly.assertThat(auth.getRatingSystemVersion() ).as(" auth.getRatingSystemVersion()" ).isEqualTo("ER 5.0.0");
        softly.assertThat(auth.isDiscount() ).as(" auth.isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getDiscountPromoText() ).as(" auth.getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getDiscountPromoText() ).as(" auth.getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(auth.isAlternativePaymentMethod() ).as(" auth.isAlternativePaymentMethod()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.RatingAttributes
        softly.assertThat(auth.getDiscountPercentage() ).as(" auth.getDiscountPercentage()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackageId() ).as(" auth.getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(auth.getContentId() ).as(" auth.getContentId()" ).isEqualTo("*");
        softly.assertThat(auth.getPricingText1() ).as(" auth.getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricingText1() ).as(" auth.getPricingText1()" ).isEqualTo("");
        softly.assertThat(auth.getPricingText2() ).as(" auth.getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricingText2() ).as(" auth.getPricingText2()" ).isEqualTo("");
        softly.assertThat(auth.getAlternativeCurrencyId() ).as(" auth.getAlternativeCurrencyId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getAlternativeNetRate() ).as(" auth.getAlternativeNetRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getRateIdentifier() ).as(" auth.getRateIdentifier()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(auth.getUsageTime() ).as(" auth.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getAccessDuration() ).as(" auth.getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePointId() ).as(" auth.getPricePointId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(auth.isUniquePromoCode() ).as(" auth.isUniquePromoCode()" ).isFalse() ;
        softly.assertThat(auth.isZeroCostIgnore() ).as(" auth.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(auth.getDescription() ).as(" auth.getDescription()" ).isEqualTo("ER Rated Event");
        softly.assertThat(auth.getEventUnits() ).as(" auth.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getUndiscountedStandardRate() ).as(" auth.getUndiscountedStandardRate()" ).isEqualTo(new Double(0.0)) ;

        softly.assertAll();

    }

}
