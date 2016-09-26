package com.vodafone.er.ecom.proxy.usageAuthRate;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.enums.EcomAppEnum.CLIENT_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 *
 * UsageAuthRateCharge with a UsageAuthorisation response
 * Split into parts since the test is so long!
 */
public class UsageAuthRate2IT_pt3 {

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
                .usageAuthRate(CLIENT_ID.getValue(), msisdn, "B001", new UsageAttributes());
        assertNotNull(auth);
        assertTrue(auth.isSuccess());


        softly.assertThat(auth.getPackage().getPricePoints().get(1).getRenewalsUntilLinkedPricepoint() ).as(" auth.getPackage().getPricePoints().get(1).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getKey() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size()).as("auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPrice() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingText() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getPricingModel() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getTier() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().isDefaultPPT() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().size()).as("auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPackageIdentifier() ).as(" auth.getPackage().getPricePoints().get(1).getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_B_*_false_false_*");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getServiceIdentifier() ).as(" auth.getPackage().getPricePoints().get(1).getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_*_999_10010_B_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().getName() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceField().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getStandardRateWithoutTax() ).as(" auth.getPackage().getPricePoints().get(1).getStandardRateWithoutTax()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isVolumeType() ).as(" auth.getPackage().getPricePoints().get(1).isVolumeType()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isOriginal() ).as(" auth.getPackage().getPricePoints().get(1).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers().length ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getKey() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()).as("auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPricingModel() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getTier() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" auth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getProtectedFk() ).as(" auth.getPackage().getPricePoints().get(1).getProtectedFk()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getmPricingText1() ).as(" auth.getPackage().getPricePoints().get(1).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getmPricingText2() ).as(" auth.getPackage().getPricePoints().get(1).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isNonRecurring() ).as(" auth.getPackage().getPricePoints().get(1).isNonRecurring()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isEvent() ).as(" auth.getPackage().getPricePoints().get(1).isEvent()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isPreOrder() ).as(" auth.getPackage().getPricePoints().get(1).isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getTaxRate() ).as(" auth.getPackage().getPricePoints().get(1).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getTaxCode() ).as(" auth.getPackage().getPricePoints().get(1).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getLinkedByTrialPricepoint() ).as(" auth.getPackage().getPricePoints().get(1).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getDescription()" ).isEqualTo("Recurring 1 month, Bearer B");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExpiryDate() ).as(" auth.getPackage().getPricePoints().get(1).getExpiryDate()" ).isNull();
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances().length ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getNetRate() ).as(" auth.getPackage().getPricePoints().get(1).getNetRate()" ).isEqualTo(new Double(20.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isAlwaysValidateMsisdn() ).as(" auth.getPackage().getPricePoints().get(1).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getStandardRate() ).as(" auth.getPackage().getPricePoints().get(1).getStandardRate()" ).isEqualTo(new Double(23.5)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isDiscount() ).as(" auth.getPackage().getPricePoints().get(1).isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getDiscountPromoText() ).as(" auth.getPackage().getPricePoints().get(1).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPackageId() ).as(" auth.getPackage().getPricePoints().get(1).getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getContentId() ).as(" auth.getPackage().getPricePoints().get(1).getContentId()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricingText1() ).as(" auth.getPackage().getPricePoints().get(1).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPricingText2() ).as(" auth.getPackage().getPricePoints().get(1).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getUsageTime() ).as(" auth.getPackage().getPricePoints().get(1).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAccessDuration() ).as(" auth.getPackage().getPricePoints().get(1).getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isZeroCostIgnore() ).as(" auth.getPackage().getPricePoints().get(1).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances().length ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isActive() ).as(" auth.getPackage().getPricePoints().get(1).isActive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(1).getRate()" ).isEqualTo(new Double(23.5)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getChannel() ).as(" auth.getPackage().getPricePoints().get(1).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getMultiUsageMode() ).as(" auth.getPackage().getPricePoints().get(1).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getNetworkCodeMatchMethod() ).as(" auth.getPackage().getPricePoints().get(1).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isPreRatePriceGross() ).as(" auth.getPackage().getPricePoints().get(1).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPreRate() ).as(" auth.getPackage().getPricePoints().get(1).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPaymentInformation() ).as(" auth.getPackage().getPricePoints().get(1).getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getContentName() ).as(" auth.getPackage().getPricePoints().get(1).getContentName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAssetID() ).as(" auth.getPackage().getPricePoints().get(1).getAssetID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPremiumLevel() ).as(" auth.getPackage().getPricePoints().get(1).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getReserveOnlyFlag() ).as(" auth.getPackage().getPricePoints().get(1).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getSupplierId() ).as(" auth.getPackage().getPricePoints().get(1).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getDeviceType() ).as(" auth.getPackage().getPricePoints().get(1).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getUserGroups().length ).as(" auth.getPackage().getPricePoints().get(1).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getUserGroup() ).as(" auth.getPackage().getPricePoints().get(1).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPaymentType() ).as(" auth.getPackage().getPricePoints().get(1).getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getEventDateTime() ).as(" auth.getPackage().getPricePoints().get(1).getEventDateTime()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getEventUnits() ).as(" auth.getPackage().getPricePoints().get(1).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPromoCodes().length ).as(" auth.getPackage().getPricePoints().get(1).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getBearerIds().length ).as(" auth.getPackage().getPricePoints().get(1).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPromoCode() ).as(" auth.getPackage().getPricePoints().get(1).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getDuration() ).as(" auth.getPackage().getPricePoints().get(1).getDuration()" ).isEqualTo(4) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getChargingMethod() ).as(" auth.getPackage().getPricePoints().get(1).getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getBearer() ).as(" auth.getPackage().getPricePoints().get(1).getBearer()" ).isEqualTo("B");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isInteractive() ).as(" auth.getPackage().getPricePoints().get(1).isInteractive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isIncludeUnavailable() ).as(" auth.getPackage().getPricePoints().get(1).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExpressFlag() ).as(" auth.getPackage().getPricePoints().get(1).getExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isExpressFlag() ).as(" auth.getPackage().getPricePoints().get(1).isExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isCancellationUsage() ).as(" auth.getPackage().getPricePoints().get(1).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getTierName() ).as(" auth.getPackage().getPricePoints().get(1).getTierName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPromoPrecode() ).as(" auth.getPackage().getPricePoints().get(1).getPromoPrecode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getUniquePromoCode() ).as(" auth.getPackage().getPricePoints().get(1).getUniquePromoCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPromoUniqueCode() ).as(" auth.getPackage().getPricePoints().get(1).getPromoUniqueCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getNextCycleDiscount() ).as(" auth.getPackage().getPricePoints().get(1).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getHasHistoricPricePointFlag() ).as(" auth.getPackage().getPricePoints().get(1).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isIsForRenewal() ).as(" auth.getPackage().getPricePoints().get(1).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getTaxRateAsDouble() ).as(" auth.getPackage().getPricePoints().get(1).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAffiliateID() ).as(" auth.getPackage().getPricePoints().get(1).getAffiliateID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPartnerId() ).as(" auth.getPackage().getPricePoints().get(1).getPartnerId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getTariff() ).as(" auth.getPackage().getPricePoints().get(1).getTariff()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAggregatorId() ).as(" auth.getPackage().getPricePoints().get(1).getAggregatorId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isForcePurchaseFlow() ).as(" auth.getPackage().getPricePoints().get(1).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getReceipientMsisdn() ).as(" auth.getPackage().getPricePoints().get(1).getReceipientMsisdn()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getProductCode() ).as(" auth.getPackage().getPricePoints().get(1).getProductCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getMerchantName() ).as(" auth.getPackage().getPricePoints().get(1).getMerchantName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getInvoiceText() ).as(" auth.getPackage().getPricePoints().get(1).getInvoiceText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isReIssueEnabled() ).as(" auth.getPackage().getPricePoints().get(1).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isReIssueFlagPresent() ).as(" auth.getPackage().getPricePoints().get(1).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getShortPackageId() ).as(" auth.getPackage().getPricePoints().get(1).getShortPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getHistoryStartDate() ).as(" auth.getPackage().getPricePoints().get(1).getHistoryStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getVendorId() ).as(" auth.getPackage().getPricePoints().get(1).getVendorId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isIsForNextPaymentAmount() ).as(" auth.getPackage().getPricePoints().get(1).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getRenewalPreRate() ).as(" auth.getPackage().getPricePoints().get(1).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isOverrideDisallowPreRateFlag() ).as(" auth.getPackage().getPricePoints().get(1).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getContentCategory() ).as(" auth.getPackage().getPricePoints().get(1).getContentCategory()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPartnerUrl() ).as(" auth.getPackage().getPricePoints().get(1).getPartnerUrl()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPartnerContactInfo() ).as(" auth.getPackage().getPricePoints().get(1).getPartnerContactInfo()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPartnerEmail() ).as(" auth.getPackage().getPricePoints().get(1).getPartnerEmail()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPartnerName() ).as(" auth.getPackage().getPricePoints().get(1).getPartnerName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint() ).as(" auth.getPackage().getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint() ).as(" auth.getPackage().getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getSubRenewalPricepointId() ).as(" auth.getPackage().getPricePoints().get(1).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getLinkPricepointId() ).as(" auth.getPackage().getPricePoints().get(1).getLinkPricepointId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getSubPurchaseTransactionTrial() ).as(" auth.getPackage().getPricePoints().get(1).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getDiscardHiddenInactivePricepoints() ).as(" auth.getPackage().getPricePoints().get(1).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints() ).as(" auth.getPackage().getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExtIdentifier1() ).as(" auth.getPackage().getPricePoints().get(1).getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExtIdentifier2() ).as(" auth.getPackage().getPricePoints().get(1).getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExtIdentifier3() ).as(" auth.getPackage().getPricePoints().get(1).getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getAccessChannel() ).as(" auth.getPackage().getPricePoints().get(1).getAccessChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getPurchaseChannel() ).as(" auth.getPackage().getPricePoints().get(1).getPurchaseChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getDeviceID() ).as(" auth.getPackage().getPricePoints().get(1).getDeviceID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getLocal() ).as(" auth.getPackage().getPricePoints().get(1).getLocal()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getMsisdn() ).as(" auth.getPackage().getPricePoints().get(1).getMsisdn()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getLanguageLocale() ).as(" auth.getPackage().getPricePoints().get(1).getLanguageLocale()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getLanguageCode() ).as(" auth.getPackage().getPricePoints().get(1).getLanguageCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExternalField1() ).as(" auth.getPackage().getPricePoints().get(1).getExternalField1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExternalField2() ).as(" auth.getPackage().getPricePoints().get(1).getExternalField2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getExternalTransId() ).as(" auth.getPackage().getPricePoints().get(1).getExternalTransId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getActiveSubscriptions() ).as(" auth.getPackage().getPricePoints().get(1).getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(1).getCsrId() ).as(" auth.getPackage().getPricePoints().get(1).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getId() ).as(" auth.getPackage().getPricePoints().get(2).getId()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricingModelTier() ).as(" auth.getPackage().getPricePoints().get(2).getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isArchived() ).as(" auth.getPackage().getPricePoints().get(2).isArchived()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isBasePricePoint() ).as(" auth.getPackage().getPricePoints().get(2).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAccessDevice() ).as(" auth.getPackage().getPricePoints().get(2).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAlternativeRate() ).as(" auth.getPackage().getPricePoints().get(2).getAlternativeRate()" ).isEqualTo(new Double(8.225)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts().length ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getName() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isResource() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCode() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().size()).as("auth.getPackage().getPricePoints().get(2).getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isTrial() ).as(" auth.getPackage().getPricePoints().get(2).isTrial()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getGlid() ).as(" auth.getPackage().getPricePoints().get(2).getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricepointIdLink() ).as(" auth.getPackage().getPricePoints().get(2).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isPreview() ).as(" auth.getPackage().getPricePoints().get(2).isPreview()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getInteractiveFlag() ).as(" auth.getPackage().getPricePoints().get(2).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isForcedPurchase() ).as(" auth.getPackage().getPricePoints().get(2).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isSubscriptionDuplicate() ).as(" auth.getPackage().getPricePoints().get(2).isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getFixedExpiryDate() ).as(" auth.getPackage().getPricePoints().get(2).getFixedExpiryDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isReserveOnly() ).as(" auth.getPackage().getPricePoints().get(2).isReserveOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getMinSubPeriod() ).as(" auth.getPackage().getPricePoints().get(2).getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPenaltyCharges() ).as(" auth.getPackage().getPricePoints().get(2).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCancellation() ).as(" auth.getPackage().getPricePoints().get(2).getCancellation()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getMonthEndSubscription() ).as(" auth.getPackage().getPricePoints().get(2).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isHistoric() ).as(" auth.getPackage().getPricePoints().get(2).isHistoric()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getFixedRecurrence() ).as(" auth.getPackage().getPricePoints().get(2).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isFixedRecurringPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isReceipting() ).as(" auth.getPackage().getPricePoints().get(2).isReceipting()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getReceiptingAttribute() ).as(" auth.getPackage().getPricePoints().get(2).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getOrder() ).as(" auth.getPackage().getPricePoints().get(2).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPaymentHandler() ).as(" auth.getPackage().getPricePoints().get(2).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getNonMatchAllUserGroups().length ).as(" auth.getPackage().getPricePoints().get(2).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isPromo() ).as(" auth.getPackage().getPricePoints().get(2).isPromo()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isSubmitToPaymentHandler() ).as(" auth.getPackage().getPricePoints().get(2).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isSuppressToPaymentHandler() ).as(" auth.getPackage().getPricePoints().get(2).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1() ).as(" auth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2() ).as(" auth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTranslatedPricingText1() ).as(" auth.getPackage().getPricePoints().get(2).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTranslatedPricingText2() ).as(" auth.getPackage().getPricePoints().get(2).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getRecurrenceDay() ).as(" auth.getPackage().getPricePoints().get(2).getRecurrenceDay()" ).isEqualTo(0) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isAlignWithExternal() ).as(" auth.getPackage().getPricePoints().get(2).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getGracePeriod() ).as(" auth.getPackage().getPricePoints().get(2).getGracePeriod()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getRetryFrequency() ).as(" auth.getPackage().getPricePoints().get(2).getRetryFrequency()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getSuspensionPeriod() ).as(" auth.getPackage().getPricePoints().get(2).getSuspensionPeriod()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isGraceSuspensionRetryFrequencyUndefined() ).as(" auth.getPackage().getPricePoints().get(2).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTranslatedPricingText() ).as(" auth.getPackage().getPricePoints().get(2).getTranslatedPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getFairUsageLimit() ).as(" auth.getPackage().getPricePoints().get(2).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getFairUsagePeriod() ).as(" auth.getPackage().getPricePoints().get(2).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getFairUsagePeriodUnit() ).as(" auth.getPackage().getPricePoints().get(2).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExtensionPeriod() ).as(" auth.getPackage().getPricePoints().get(2).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isIncludeServiceForPackageFUP() ).as(" auth.getPackage().getPricePoints().get(2).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isFairUsagePolicyEnabled() ).as(" auth.getPackage().getPricePoints().get(2).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isTariff() ).as(" auth.getPackage().getPricePoints().get(2).isTariff()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isHideForPurchaseOptions() ).as(" auth.getPackage().getPricePoints().get(2).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getName() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getKey() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getKey()" ).isNull();
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRate() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxCode() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size()).as("auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getValue() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getValue() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getValue() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances().length ).as(" auth.getPackage().getPricePoints().get(2).getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoints().get(2).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isRecurring() ).as(" auth.getPackage().getPricePoints().get(2).isRecurring()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getRenewalsUntilLinkedPricepoint() ).as(" auth.getPackage().getPricePoints().get(2).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getKey() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size()).as("auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPrice() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingText() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getPricingModel() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getTier() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().isDefaultPPT() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().size()).as("auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPackageIdentifier() ).as(" auth.getPackage().getPricePoints().get(2).getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getServiceIdentifier() ).as(" auth.getPackage().getPricePoints().get(2).getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_*_999_10010_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().getName() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceField().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getStandardRateWithoutTax() ).as(" auth.getPackage().getPricePoints().get(2).getStandardRateWithoutTax()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isVolumeType() ).as(" auth.getPackage().getPricePoints().get(2).isVolumeType()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isOriginal() ).as(" auth.getPackage().getPricePoints().get(2).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers().length ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getKey() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size()).as("auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPrice() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingText() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPricingModel() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getTier() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].isDefaultPPT() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" auth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getProtectedFk() ).as(" auth.getPackage().getPricePoints().get(2).getProtectedFk()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getmPricingText1() ).as(" auth.getPackage().getPricePoints().get(2).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getmPricingText2() ).as(" auth.getPackage().getPricePoints().get(2).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isNonRecurring() ).as(" auth.getPackage().getPricePoints().get(2).isNonRecurring()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isEvent() ).as(" auth.getPackage().getPricePoints().get(2).isEvent()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isPreOrder() ).as(" auth.getPackage().getPricePoints().get(2).isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTaxRate() ).as(" auth.getPackage().getPricePoints().get(2).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTaxCode() ).as(" auth.getPackage().getPricePoints().get(2).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getLinkedByTrialPricepoint() ).as(" auth.getPackage().getPricePoints().get(2).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getDescription()" ).isEqualTo("Recurring 1 month");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExpiryDate() ).as(" auth.getPackage().getPricePoints().get(2).getExpiryDate()" ).isNull();
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances().length ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getNetRate() ).as(" auth.getPackage().getPricePoints().get(2).getNetRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isAlwaysValidateMsisdn() ).as(" auth.getPackage().getPricePoints().get(2).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getStandardRate() ).as(" auth.getPackage().getPricePoints().get(2).getStandardRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isDiscount() ).as(" auth.getPackage().getPricePoints().get(2).isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getDiscountPromoText() ).as(" auth.getPackage().getPricePoints().get(2).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPackageId() ).as(" auth.getPackage().getPricePoints().get(2).getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getContentId() ).as(" auth.getPackage().getPricePoints().get(2).getContentId()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricingText1() ).as(" auth.getPackage().getPricePoints().get(2).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPricingText2() ).as(" auth.getPackage().getPricePoints().get(2).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getUsageTime() ).as(" auth.getPackage().getPricePoints().get(2).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAccessDuration() ).as(" auth.getPackage().getPricePoints().get(2).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isZeroCostIgnore() ).as(" auth.getPackage().getPricePoints().get(2).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances().length ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getBalance() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId() ).as(" auth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isActive() ).as(" auth.getPackage().getPricePoints().get(2).isActive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getRate() ).as(" auth.getPackage().getPricePoints().get(2).getRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getChannel() ).as(" auth.getPackage().getPricePoints().get(2).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getMultiUsageMode() ).as(" auth.getPackage().getPricePoints().get(2).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getNetworkCodeMatchMethod() ).as(" auth.getPackage().getPricePoints().get(2).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isPreRatePriceGross() ).as(" auth.getPackage().getPricePoints().get(2).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPreRate() ).as(" auth.getPackage().getPricePoints().get(2).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPaymentInformation() ).as(" auth.getPackage().getPricePoints().get(2).getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getContentName() ).as(" auth.getPackage().getPricePoints().get(2).getContentName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAssetID() ).as(" auth.getPackage().getPricePoints().get(2).getAssetID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPremiumLevel() ).as(" auth.getPackage().getPricePoints().get(2).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getReserveOnlyFlag() ).as(" auth.getPackage().getPricePoints().get(2).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getSupplierId() ).as(" auth.getPackage().getPricePoints().get(2).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getDeviceType() ).as(" auth.getPackage().getPricePoints().get(2).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getUserGroups().length ).as(" auth.getPackage().getPricePoints().get(2).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getUserGroup() ).as(" auth.getPackage().getPricePoints().get(2).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPaymentType() ).as(" auth.getPackage().getPricePoints().get(2).getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getEventDateTime() ).as(" auth.getPackage().getPricePoints().get(2).getEventDateTime()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getEventUnits() ).as(" auth.getPackage().getPricePoints().get(2).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPromoCodes().length ).as(" auth.getPackage().getPricePoints().get(2).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBearerIds().length ).as(" auth.getPackage().getPricePoints().get(2).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPromoCode() ).as(" auth.getPackage().getPricePoints().get(2).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getDuration() ).as(" auth.getPackage().getPricePoints().get(2).getDuration()" ).isEqualTo(4) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getChargingMethod() ).as(" auth.getPackage().getPricePoints().get(2).getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getBearer() ).as(" auth.getPackage().getPricePoints().get(2).getBearer()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isInteractive() ).as(" auth.getPackage().getPricePoints().get(2).isInteractive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isIncludeUnavailable() ).as(" auth.getPackage().getPricePoints().get(2).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExpressFlag() ).as(" auth.getPackage().getPricePoints().get(2).getExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isExpressFlag() ).as(" auth.getPackage().getPricePoints().get(2).isExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isCancellationUsage() ).as(" auth.getPackage().getPricePoints().get(2).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTierName() ).as(" auth.getPackage().getPricePoints().get(2).getTierName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPromoPrecode() ).as(" auth.getPackage().getPricePoints().get(2).getPromoPrecode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getUniquePromoCode() ).as(" auth.getPackage().getPricePoints().get(2).getUniquePromoCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPromoUniqueCode() ).as(" auth.getPackage().getPricePoints().get(2).getPromoUniqueCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getNextCycleDiscount() ).as(" auth.getPackage().getPricePoints().get(2).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getHasHistoricPricePointFlag() ).as(" auth.getPackage().getPricePoints().get(2).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isIsForRenewal() ).as(" auth.getPackage().getPricePoints().get(2).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTaxRateAsDouble() ).as(" auth.getPackage().getPricePoints().get(2).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAffiliateID() ).as(" auth.getPackage().getPricePoints().get(2).getAffiliateID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPartnerId() ).as(" auth.getPackage().getPricePoints().get(2).getPartnerId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getTariff() ).as(" auth.getPackage().getPricePoints().get(2).getTariff()" ).isEqualTo("*");
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAggregatorId() ).as(" auth.getPackage().getPricePoints().get(2).getAggregatorId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isForcePurchaseFlow() ).as(" auth.getPackage().getPricePoints().get(2).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getReceipientMsisdn() ).as(" auth.getPackage().getPricePoints().get(2).getReceipientMsisdn()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getProductCode() ).as(" auth.getPackage().getPricePoints().get(2).getProductCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getMerchantName() ).as(" auth.getPackage().getPricePoints().get(2).getMerchantName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getInvoiceText() ).as(" auth.getPackage().getPricePoints().get(2).getInvoiceText()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isReIssueEnabled() ).as(" auth.getPackage().getPricePoints().get(2).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isReIssueFlagPresent() ).as(" auth.getPackage().getPricePoints().get(2).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getShortPackageId() ).as(" auth.getPackage().getPricePoints().get(2).getShortPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getHistoryStartDate() ).as(" auth.getPackage().getPricePoints().get(2).getHistoryStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getVendorId() ).as(" auth.getPackage().getPricePoints().get(2).getVendorId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isIsForNextPaymentAmount() ).as(" auth.getPackage().getPricePoints().get(2).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getRenewalPreRate() ).as(" auth.getPackage().getPricePoints().get(2).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isOverrideDisallowPreRateFlag() ).as(" auth.getPackage().getPricePoints().get(2).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getContentCategory() ).as(" auth.getPackage().getPricePoints().get(2).getContentCategory()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPartnerUrl() ).as(" auth.getPackage().getPricePoints().get(2).getPartnerUrl()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPartnerContactInfo() ).as(" auth.getPackage().getPricePoints().get(2).getPartnerContactInfo()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPartnerEmail() ).as(" auth.getPackage().getPricePoints().get(2).getPartnerEmail()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPartnerName() ).as(" auth.getPackage().getPricePoints().get(2).getPartnerName()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getSubRenewalCounterToLinkedPricepoint() ).as(" auth.getPackage().getPricePoints().get(2).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPPtRenewalCounterToLinkedPricepoint() ).as(" auth.getPackage().getPricePoints().get(2).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getSubRenewalPricepointId() ).as(" auth.getPackage().getPricePoints().get(2).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getLinkPricepointId() ).as(" auth.getPackage().getPricePoints().get(2).getLinkPricepointId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getSubPurchaseTransactionTrial() ).as(" auth.getPackage().getPricePoints().get(2).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getDiscardHiddenInactivePricepoints() ).as(" auth.getPackage().getPricePoints().get(2).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).isDiscardMiddleAdvancedPricepoints() ).as(" auth.getPackage().getPricePoints().get(2).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExtIdentifier1() ).as(" auth.getPackage().getPricePoints().get(2).getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExtIdentifier2() ).as(" auth.getPackage().getPricePoints().get(2).getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExtIdentifier3() ).as(" auth.getPackage().getPricePoints().get(2).getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getAccessChannel() ).as(" auth.getPackage().getPricePoints().get(2).getAccessChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getPurchaseChannel() ).as(" auth.getPackage().getPricePoints().get(2).getPurchaseChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getDeviceID() ).as(" auth.getPackage().getPricePoints().get(2).getDeviceID()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getLocal() ).as(" auth.getPackage().getPricePoints().get(2).getLocal()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getMsisdn() ).as(" auth.getPackage().getPricePoints().get(2).getMsisdn()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getLanguageLocale() ).as(" auth.getPackage().getPricePoints().get(2).getLanguageLocale()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getLanguageCode() ).as(" auth.getPackage().getPricePoints().get(2).getLanguageCode()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExternalField1() ).as(" auth.getPackage().getPricePoints().get(2).getExternalField1()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExternalField2() ).as(" auth.getPackage().getPricePoints().get(2).getExternalField2()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getExternalTransId() ).as(" auth.getPackage().getPricePoints().get(2).getExternalTransId()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getActiveSubscriptions() ).as(" auth.getPackage().getPricePoints().get(2).getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getPackage().getPricePoints().get(2).getCsrId() ).as(" auth.getPackage().getPricePoints().get(2).getCsrId()" ).isNull();
        softly.assertThat(auth.getPackage().getProtectedType() ).as(" auth.getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getDynamicProtectedValue() ).as(" auth.getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getPurchaseMethod() ).as(" auth.getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getKpiPackageProductCategory() ).as(" auth.getPackage().getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getKpiPackageType() ).as(" auth.getPackage().getKpiPackageType()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(auth.getPackage().getPricingModels().length ).as(" auth.getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().isExpressPurchase() ).as(" auth.getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isRecieptingFlag() ).as(" auth.getPackage().isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isPricePointOrder() ).as(" auth.getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isSuperPackage() ).as(" auth.getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isRevenueShareByUsage() ).as(" auth.getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isDynamicDefault() ).as(" auth.getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getACEPackage() ).as(" auth.getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isUpSell() ).as(" auth.getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(auth.getPackage().getLogoId() ).as(" auth.getPackage().getLogoId()" ).isNull();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getPartnerInfo() ).as(" auth.getPackage().getPartnerInfo()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getIsPackageModel() ).as(" auth.getPackage().getIsPackageModel()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isParentPackage() ).as(" auth.getPackage().isParentPackage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getChildPackages() ).as(" auth.getPackage().getChildPackages()" ).isNull();
        softly.assertThat(auth.getPackage().getServicesNotInPackageFairUsagePolicyList() ).as(" auth.getPackage().getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(auth.getPackage().isHasParentSub() ).as(" auth.getPackage().isHasParentSub()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getParentSubId() ).as(" auth.getPackage().getParentSubId()" ).isNull();
        softly.assertThat(auth.getPackage().isHasParentSubSuspendedResProv() ).as(" auth.getPackage().isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getParentSubStatus() ).as(" auth.getPackage().getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().isDisallowCancellations() ).as(" auth.getPackage().isDisallowCancellations()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getSalesModel() ).as(" auth.getPackage().getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(auth.getPackage().getPackageClass() ).as(" auth.getPackage().getPackageClass()" ).isNull();
        softly.assertThat(auth.getPackage().isDataVoiceTariffInclusive() ).as(" auth.getPackage().isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getNominalValue() ).as(" auth.getPackage().getNominalValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().isUseBeingDeprovisionedStatus() ).as(" auth.getPackage().isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getDisallowDuplicateSubPurchase() ).as(" auth.getPackage().getDisallowDuplicateSubPurchase()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getNoActivePricepoints() ).as(" auth.getPackage().getNoActivePricepoints()" ).isEqualTo(3) ;
        softly.assertThat(auth.getPackage().isHasBalanceImpactsWithDate() ).as(" auth.getPackage().isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isHasPricePointsWithDate() ).as(" auth.getPackage().isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isHasPromosWithDate() ).as(" auth.getPackage().isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isHasTaxRateWithDate() ).as(" auth.getPackage().isHasTaxRateWithDate()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getPromoCodeMap() ).as(" auth.getPackage().getPromoCodeMap()" ).isNull();
        softly.assertThat(auth.getPackage().getPromoCodeMapSize() ).as(" auth.getPackage().getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getActiveStatusAsString() ).as(" auth.getPackage().getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(auth.getPackage().isUseRateCardService() ).as(" auth.getPackage().isUseRateCardService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getRateCardServiceId() ).as(" auth.getPackage().getRateCardServiceId()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().isUserGroupCalendarPricePointPackage() ).as(" auth.getPackage().isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isUpsellDiscountProrated() ).as(" auth.getPackage().isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(auth.getPackage().isDisallowPrerate() ).as(" auth.getPackage().isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getServiceNames().length ).as(" auth.getPackage().getServiceNames().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getDefaultPartnerProvisioningId() ).as(" auth.getPackage().getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(auth.getPackage().getUserGroupComparisonAtRenewal() ).as(" auth.getPackage().getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
        softly.assertThat(auth.getPackage().isActive() ).as(" auth.getPackage().isActive()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getRate() ).as(" auth.getPackage().getRate()" ).isEqualTo(new Double(8.225)) ;
//check size of list!
        softly.assertThat(auth.getPackage().getServices().size()).as("auth.getPackage().getServices().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServices().size() >= 1);
        softly.assertThat(auth.getPackage().getServices().get(0).getName() ).as(" auth.getPackage().getServices().get(0).getName()" ).isEqualTo("B001");
        softly.assertThat(auth.getPackage().getServices().get(0).getKey() ).as(" auth.getPackage().getServices().get(0).getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(auth.getPackage().getServices().get(0).getId() ).as(" auth.getPackage().getServices().get(0).getId()" ).isEqualTo("B001");
        softly.assertThat(auth.getPackage().getServices().get(0).getDisplayName() ).as(" auth.getPackage().getServices().get(0).getDisplayName()" ).isEqualTo("B001 (B001)");
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServices().get(0).isReserveOnly() ).as(" auth.getPackage().getServices().get(0).isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServices().get(0).getProvisioningTag() ).as(" auth.getPackage().getServices().get(0).getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(auth.getPackage().getServices().get(0).isProvisionOnUsage() ).as(" auth.getPackage().getServices().get(0).isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isReturnAllCatalogueServicesInfo() ).as(" auth.getPackage().getServices().get(0).isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isDefaultService() ).as(" auth.getPackage().getServices().get(0).isDefaultService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getProvisioningSystem() ).as(" auth.getPackage().getServices().get(0).getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getUsageId() ).as(" auth.getPackage().getServices().get(0).getUsageId()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getServiceCategory() ).as(" auth.getPackage().getServices().get(0).getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getDealName() ).as(" auth.getPackage().getServices().get(0).getDealName()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getDistributionChannel() ).as(" auth.getPackage().getServices().get(0).getDistributionChannel()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getHighVolumeInterfaceLevel() ).as(" auth.getPackage().getServices().get(0).getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(auth.getPackage().getServices().get(0).isHighVolumeInterface() ).as(" auth.getPackage().getServices().get(0).isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPackage().getServices().get(0).getServiceRevenueSharePartners().length ).as(" auth.getPackage().getServices().get(0).getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getServiceRevenueSharePartnerNum() ).as(" auth.getPackage().getServices().get(0).getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(auth.getPackage().getServices().get(0).getServiceRevenueSharePartnersPurchaseCh().length ).as(" auth.getPackage().getServices().get(0).getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getIndirectValue() ).as(" auth.getPackage().getServices().get(0).getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getIndirectValueFormat() ).as(" auth.getPackage().getServices().get(0).getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(auth.getPackage().getServices().get(0).getPromoValue() ).as(" auth.getPackage().getServices().get(0).getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getPromoValueFormat() ).as(" auth.getPackage().getServices().get(0).getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(auth.getPackage().getServices().get(0).getContentSubCategory() ).as(" auth.getPackage().getServices().get(0).getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getContentItem() ).as(" auth.getPackage().getServices().get(0).getContentItem()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getDeliveryMechanism() ).as(" auth.getPackage().getServices().get(0).getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getProductCategory() ).as(" auth.getPackage().getServices().get(0).getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getProductSubCategory1() ).as(" auth.getPackage().getServices().get(0).getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getProductSubCategory2() ).as(" auth.getPackage().getServices().get(0).getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getProductWholesalePrice() ).as(" auth.getPackage().getServices().get(0).getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getProductSelfRegulation() ).as(" auth.getPackage().getServices().get(0).getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).isVolumeService() ).as(" auth.getPackage().getServices().get(0).isVolumeService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getProductFk() ).as(" auth.getPackage().getServices().get(0).getProductFk()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).isServiceShareOverride() ).as(" auth.getPackage().getServices().get(0).isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isExpiredPackageService() ).as(" auth.getPackage().getServices().get(0).isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getFixedUsageAmount() ).as(" auth.getPackage().getServices().get(0).getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getHasExpress() ).as(" auth.getPackage().getServices().get(0).getHasExpress()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getHasDynamicDefault() ).as(" auth.getPackage().getServices().get(0).getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getHasSuperPackage() ).as(" auth.getPackage().getServices().get(0).getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isReturnTrialOptionsOnly() ).as(" auth.getPackage().getServices().get(0).isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getServiceClass() ).as(" auth.getPackage().getServices().get(0).getServiceClass()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getBandRevenueShares() ).as(" auth.getPackage().getServices().get(0).getBandRevenueShares()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).isReIssuePermittedFlag() ).as(" auth.getPackage().getServices().get(0).isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getChargeableBy() ).as(" auth.getPackage().getServices().get(0).getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(auth.getPackage().getServices().get(0).getPackageIds().length ).as(" auth.getPackage().getServices().get(0).getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPackage().getServices().get(0).isMicroService() ).as(" auth.getPackage().getServices().get(0).isMicroService()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getSuperPackageIds() ).as(" auth.getPackage().getServices().get(0).getSuperPackageIds()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getmExternalServPricePlan() ).as(" auth.getPackage().getServices().get(0).getmExternalServPricePlan()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).ismRefundable() ).as(" auth.getPackage().getServices().get(0).ismRefundable()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).ismReturnTrialOptionsOnly() ).as(" auth.getPackage().getServices().get(0).ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isUseRateCard() ).as(" auth.getPackage().getServices().get(0).isUseRateCard()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getInternalPartner() ).as(" auth.getPackage().getServices().get(0).getInternalPartner()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getRateCardPartners() ).as(" auth.getPackage().getServices().get(0).getRateCardPartners()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).isUsageAllowedBeingProvisionedSub() ).as(" auth.getPackage().getServices().get(0).isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isGlobalHandler() ).as(" auth.getPackage().getServices().get(0).isGlobalHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).isGlobalHandlerNotification() ).as(" auth.getPackage().getServices().get(0).isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPriorityServiceRevenueSharePartner() ).as(" auth.getPackage().getServices().get(0).getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).isUniqueServiceClass() ).as(" auth.getPackage().getServices().get(0).isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getTaxCode() ).as(" auth.getPackage().getServices().get(0).getTaxCode()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getContentCategory() ).as(" auth.getPackage().getServices().get(0).getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getUrl() ).as(" auth.getPackage().getServices().get(0).getUrl()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoint() ).as(" auth.getPackage().getServices().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getDescription() ).as(" auth.getPackage().getServices().get(0).getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServices().get(0).getPricingText1() ).as(" auth.getPackage().getServices().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricingText2() ).as(" auth.getPackage().getServices().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getNotificationCategory() ).as(" auth.getPackage().getServices().get(0).getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getKey() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getDescription() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getMerchant() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getMerchantDescription() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getItemVolume() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getServiceType() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getPromotion() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPaymentContent().getCategory() ).as(" auth.getPackage().getServices().get(0).getPaymentContent().getCategory()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).getNonRefundableDescription() ).as(" auth.getPackage().getServices().get(0).getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(auth.getPackage().getServices().get(0).isRefundable() ).as(" auth.getPackage().getServices().get(0).isRefundable()" ).isTrue() ;
//check size of list!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().size()).as("auth.getPackage().getServices().get(0).getPricePoints().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServices().get(0).getPricePoints().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getDescription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getDescription()" ).isNull();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isPayToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingModelTier() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isArchived() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isBasePricePoint() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessDevice() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAlternativeRate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(1.175)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts().length ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//check size of list!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size()).as("auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isTrial() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isTrial()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getGlid() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricepointIdLink() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricepointIdLink()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isPreview() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getInteractiveFlag() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isForcedPurchase() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isSubscriptionDuplicate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedExpiryDate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isReserveOnly() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getMinSubPeriod() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPenaltyCharges() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getCancellation() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getMonthEndSubscription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isHistoric() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedRecurrence() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isReceipting() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getReceiptingAttribute() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getOrder() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentHandler() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isPromo() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName1() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName2() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText1() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText2() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getRecurrenceDay() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isAlignWithExternal() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getGracePeriod() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getRetryFrequency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getSuspensionPeriod() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTranslatedPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsageLimit() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriod() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getExtensionPeriod() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isTariff() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isHideForPurchaseOptions() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getKey()" ).isNull();
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size()).as("auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getValue() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getValue() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getValue() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances().length ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getBalance() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).isRecurring() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPrice() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingText() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPricingModel() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getTier() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().isDefaultPPT() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().size()).as("auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getPackageIdentifier() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getServiceIdentifier() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isCurrency() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isResource() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCountryId() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getResourceName() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCode() ).as(" auth.getPackage().getServices().get(0).getPricePoints().get(0).getResourceField().getCode()" ).isEqualTo(1100033) ;




        softly.assertAll();

    }

}
