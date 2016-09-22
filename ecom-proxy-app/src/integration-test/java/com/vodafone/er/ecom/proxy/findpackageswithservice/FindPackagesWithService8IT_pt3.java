package com.vodafone.er.ecom.proxy.findpackageswithservice;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class FindPackagesWithService8IT_pt3 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void findPackagesWithService8() throws Exception {
        final CatalogService catalogService = EcomApiFactory.getCatalogApi(Locale.UK).getService("sAlt");

        //Only difference with findPackagesWithService9 is that there is no msisdn
        final CatalogPackage[] result = EcomApiFactory.getCatalogApi(Locale.UK)
                .findPackagesWithService(null, catalogService, new PurchaseAttributes());

        assertNotNull(result);
        assertEquals(result.length, 2);

        System.out.println(">>>>" + result);

        CatalogPackage pack =null;
        for(CatalogPackage p : result) {
            if(p.getId().equals("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*")) {
                pack = p;
                break;
            }
        }


        softly.assertThat(pack.getPricePoints().get(1).getResourceField().getDescription() ).as(" pack.getPricePoints().get(1).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().getResourceName() ).as(" pack.getPricePoints().get(1).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().getCountryId() ).as(" pack.getPricePoints().get(1).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().isToken() ).as(" pack.getPricePoints().get(1).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().isUsageToken() ).as(" pack.getPricePoints().get(1).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().isPayToken() ).as(" pack.getPricePoints().get(1).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().isCurrency() ).as(" pack.getPricePoints().get(1).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().isResource() ).as(" pack.getPricePoints().get(1).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getResourceField().getCode() ).as(" pack.getPricePoints().get(1).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getStandardRateWithoutTax() ).as(" pack.getPricePoints().get(1).getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).isVolumeType() ).as(" pack.getPricePoints().get(1).isVolumeType()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isOriginal() ).as(" pack.getPricePoints().get(1).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers().length ).as(" pack.getPricePoints().get(1).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getKey() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()).as("pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getPricingModel() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].getTier() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT() ).as(" pack.getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).getProtectedFk() ).as(" pack.getPricePoints().get(1).getProtectedFk()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getmPricingText1() ).as(" pack.getPricePoints().get(1).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(1).getmPricingText2() ).as(" pack.getPricePoints().get(1).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(1).isNonRecurring() ).as(" pack.getPricePoints().get(1).isNonRecurring()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isEvent() ).as(" pack.getPricePoints().get(1).isEvent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getChannel() ).as(" pack.getPricePoints().get(1).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(1).getMultiUsageMode() ).as(" pack.getPricePoints().get(1).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getNetworkCodeMatchMethod() ).as(" pack.getPricePoints().get(1).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(1).isPreRatePriceGross() ).as(" pack.getPricePoints().get(1).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getPreRate() ).as(" pack.getPricePoints().get(1).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getPaymentInformation() ).as(" pack.getPricePoints().get(1).getPaymentInformation()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getContentName() ).as(" pack.getPricePoints().get(1).getContentName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getAssetID() ).as(" pack.getPricePoints().get(1).getAssetID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPremiumLevel() ).as(" pack.getPricePoints().get(1).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(1).getReserveOnlyFlag() ).as(" pack.getPricePoints().get(1).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(1).getSupplierId() ).as(" pack.getPricePoints().get(1).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(1).getDeviceType() ).as(" pack.getPricePoints().get(1).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getUserGroups().length ).as(" pack.getPricePoints().get(1).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(1).getUserGroup() ).as(" pack.getPricePoints().get(1).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(1).getPaymentType() ).as(" pack.getPricePoints().get(1).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(1).getEventDateTime() ).as(" pack.getPricePoints().get(1).getEventDateTime()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getEventUnits() ).as(" pack.getPricePoints().get(1).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getPromoCodes().length ).as(" pack.getPricePoints().get(1).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(1).getBearerIds().length ).as(" pack.getPricePoints().get(1).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(1).getPromoCode() ).as(" pack.getPricePoints().get(1).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(1).getDuration() ).as(" pack.getPricePoints().get(1).getDuration()" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoints().get(1).getChargingMethod() ).as(" pack.getPricePoints().get(1).getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(pack.getPricePoints().get(1).getBearer() ).as(" pack.getPricePoints().get(1).getBearer()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(1).isInteractive() ).as(" pack.getPricePoints().get(1).isInteractive()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(1).isIncludeUnavailable() ).as(" pack.getPricePoints().get(1).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getExpressFlag() ).as(" pack.getPricePoints().get(1).getExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isExpressFlag() ).as(" pack.getPricePoints().get(1).isExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isCancellationUsage() ).as(" pack.getPricePoints().get(1).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getTierName() ).as(" pack.getPricePoints().get(1).getTierName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPromoPrecode() ).as(" pack.getPricePoints().get(1).getPromoPrecode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getUniquePromoCode() ).as(" pack.getPricePoints().get(1).getUniquePromoCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPromoUniqueCode() ).as(" pack.getPricePoints().get(1).getPromoUniqueCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getNextCycleDiscount() ).as(" pack.getPricePoints().get(1).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).getHasHistoricPricePointFlag() ).as(" pack.getPricePoints().get(1).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isIsForRenewal() ).as(" pack.getPricePoints().get(1).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getTaxRateAsDouble() ).as(" pack.getPricePoints().get(1).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getAffiliateID() ).as(" pack.getPricePoints().get(1).getAffiliateID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPartnerId() ).as(" pack.getPricePoints().get(1).getPartnerId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getTariff() ).as(" pack.getPricePoints().get(1).getTariff()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(1).getAggregatorId() ).as(" pack.getPricePoints().get(1).getAggregatorId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).isForcePurchaseFlow() ).as(" pack.getPricePoints().get(1).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getReceipientMsisdn() ).as(" pack.getPricePoints().get(1).getReceipientMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getProductCode() ).as(" pack.getPricePoints().get(1).getProductCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getMerchantName() ).as(" pack.getPricePoints().get(1).getMerchantName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getInvoiceText() ).as(" pack.getPricePoints().get(1).getInvoiceText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).isReIssueEnabled() ).as(" pack.getPricePoints().get(1).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isReIssueFlagPresent() ).as(" pack.getPricePoints().get(1).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getShortPackageId() ).as(" pack.getPricePoints().get(1).getShortPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getHistoryStartDate() ).as(" pack.getPricePoints().get(1).getHistoryStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getVendorId() ).as(" pack.getPricePoints().get(1).getVendorId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).isIsForNextPaymentAmount() ).as(" pack.getPricePoints().get(1).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getRenewalPreRate() ).as(" pack.getPricePoints().get(1).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(1).isOverrideDisallowPreRateFlag() ).as(" pack.getPricePoints().get(1).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getContentCategory() ).as(" pack.getPricePoints().get(1).getContentCategory()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPartnerUrl() ).as(" pack.getPricePoints().get(1).getPartnerUrl()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPartnerContactInfo() ).as(" pack.getPricePoints().get(1).getPartnerContactInfo()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPartnerEmail() ).as(" pack.getPricePoints().get(1).getPartnerEmail()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPartnerName() ).as(" pack.getPricePoints().get(1).getPartnerName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(1).getSubRenewalPricepointId() ).as(" pack.getPricePoints().get(1).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getLinkPricepointId() ).as(" pack.getPricePoints().get(1).getLinkPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getSubPurchaseTransactionTrial() ).as(" pack.getPricePoints().get(1).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getDiscardHiddenInactivePricepoints() ).as(" pack.getPricePoints().get(1).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints() ).as(" pack.getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(1).getExtIdentifier1() ).as(" pack.getPricePoints().get(1).getExtIdentifier1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getExtIdentifier2() ).as(" pack.getPricePoints().get(1).getExtIdentifier2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getExtIdentifier3() ).as(" pack.getPricePoints().get(1).getExtIdentifier3()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getAccessChannel() ).as(" pack.getPricePoints().get(1).getAccessChannel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getPurchaseChannel() ).as(" pack.getPricePoints().get(1).getPurchaseChannel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getDeviceID() ).as(" pack.getPricePoints().get(1).getDeviceID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getLocal() ).as(" pack.getPricePoints().get(1).getLocal()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getMsisdn() ).as(" pack.getPricePoints().get(1).getMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getLanguageLocale() ).as(" pack.getPricePoints().get(1).getLanguageLocale()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getLanguageCode() ).as(" pack.getPricePoints().get(1).getLanguageCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getExternalField1() ).as(" pack.getPricePoints().get(1).getExternalField1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getExternalField2() ).as(" pack.getPricePoints().get(1).getExternalField2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getExternalTransId() ).as(" pack.getPricePoints().get(1).getExternalTransId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getActiveSubscriptions() ).as(" pack.getPricePoints().get(1).getActiveSubscriptions()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(1).getCsrId() ).as(" pack.getPricePoints().get(1).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getResource().getName() ).as(" pack.getPricePoints().get(2).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getResource().isToken() ).as(" pack.getPricePoints().get(2).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getResource().isResource() ).as(" pack.getPricePoints().get(2).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResource().getCode() ).as(" pack.getPricePoints().get(2).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getKey() ).as(" pack.getPricePoints().get(2).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getId() ).as(" pack.getPricePoints().get(2).getId()" ).isEqualTo("package:pAlt_TAX_2_4_999_999_999_*_*_*_false_false_*");
        softly.assertThat(pack.getPricePoints().get(2).getDescription() ).as(" pack.getPricePoints().get(2).getDescription()" ).isEqualTo("Non-recurring 1 month");
        softly.assertThat(pack.getPricePoints().get(2).isActive() ).as(" pack.getPricePoints().get(2).isActive()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isPreOrder() ).as(" pack.getPricePoints().get(2).isPreOrder()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getTaxRate() ).as(" pack.getPricePoints().get(2).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(pack.getPricePoints().get(2).getTaxCode() ).as(" pack.getPricePoints().get(2).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getPricePoints().get(2).getLinkedByTrialPricepoint() ).as(" pack.getPricePoints().get(2).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isDiscount() ).as(" pack.getPricePoints().get(2).isDiscount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getDiscountPromoText() ).as(" pack.getPricePoints().get(2).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getPackageId() ).as(" pack.getPricePoints().get(2).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(pack.getPricePoints().get(2).getContentId() ).as(" pack.getPricePoints().get(2).getContentId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(2).getPricingText1() ).as(" pack.getPricePoints().get(2).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getPricingText2() ).as(" pack.getPricePoints().get(2).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getUsageTime() ).as(" pack.getPricePoints().get(2).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAccessDuration() ).as(" pack.getPricePoints().get(2).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).isZeroCostIgnore() ).as(" pack.getPricePoints().get(2).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances().length ).as(" pack.getPricePoints().get(2).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getBalance() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getRate() ).as(" pack.getPricePoints().get(2).getRate()" ).isEqualTo(new Double(17.625)) ;
        softly.assertThat(pack.getPricePoints().get(2).getStandardRate() ).as(" pack.getPricePoints().get(2).getStandardRate()" ).isEqualTo(new Double(17.625)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances().length ).as(" pack.getPricePoints().get(2).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getBalance() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getResourceBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(2).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getNetRate() ).as(" pack.getPricePoints().get(2).getNetRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).isAlwaysValidateMsisdn() ).as(" pack.getPricePoints().get(2).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricingModelTier() ).as(" pack.getPricePoints().get(2).getPricingModelTier()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isArchived() ).as(" pack.getPricePoints().get(2).isArchived()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isBasePricePoint() ).as(" pack.getPricePoints().get(2).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAccessDevice() ).as(" pack.getPricePoints().get(2).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(2).getAlternativeRate() ).as(" pack.getPricePoints().get(2).getAlternativeRate()" ).isEqualTo(new Double(17.625)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts().length ).as(" pack.getPricePoints().get(2).getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].getName() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].getDescription() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].getResourceName() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].getCountryId() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].isToken() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].isPayToken() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].isCurrency() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].isResource() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpacts()[0].getCode() ).as(" pack.getPricePoints().get(2).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
//check size of list!
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().size()).as("pack.getPricePoints().get(2).getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(2).getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getKey() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getId() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getType() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).getRate() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(0).isResource() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getKey() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getId() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getType() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).getRate() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalanceImpactList().get(1).isResource() ).as(" pack.getPricePoints().get(2).getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).isTrial() ).as(" pack.getPricePoints().get(2).isTrial()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getGlid() ).as(" pack.getPricePoints().get(2).getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(pack.getPricePoints().get(2).getPricepointIdLink() ).as(" pack.getPricePoints().get(2).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).isPreview() ).as(" pack.getPricePoints().get(2).isPreview()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getInteractiveFlag() ).as(" pack.getPricePoints().get(2).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(pack.getPricePoints().get(2).isForcedPurchase() ).as(" pack.getPricePoints().get(2).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isSubscriptionDuplicate() ).as(" pack.getPricePoints().get(2).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getFixedExpiryDate() ).as(" pack.getPricePoints().get(2).getFixedExpiryDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isReserveOnly() ).as(" pack.getPricePoints().get(2).isReserveOnly()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getMinSubPeriod() ).as(" pack.getPricePoints().get(2).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPenaltyCharges() ).as(" pack.getPricePoints().get(2).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getCancellation() ).as(" pack.getPricePoints().get(2).getCancellation()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getMonthEndSubscription() ).as(" pack.getPricePoints().get(2).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(2).isHistoric() ).as(" pack.getPricePoints().get(2).isHistoric()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getFixedRecurrence() ).as(" pack.getPricePoints().get(2).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getPricePoints().get(2).isFixedRecurringPricePoint() ).as(" pack.getPricePoints().get(2).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isReceipting() ).as(" pack.getPricePoints().get(2).isReceipting()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getReceiptingAttribute() ).as(" pack.getPricePoints().get(2).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(pack.getPricePoints().get(2).getOrder() ).as(" pack.getPricePoints().get(2).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPaymentHandler() ).as(" pack.getPricePoints().get(2).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getNonMatchAllUserGroups().length ).as(" pack.getPricePoints().get(2).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).isPromo() ).as(" pack.getPricePoints().get(2).isPromo()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isSubmitToPaymentHandler() ).as(" pack.getPricePoints().get(2).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isSuppressToPaymentHandler() ).as(" pack.getPricePoints().get(2).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricingTextTemplateName1() ).as(" pack.getPricePoints().get(2).getPricingTextTemplateName1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getPricingTextTemplateName2() ).as(" pack.getPricePoints().get(2).getPricingTextTemplateName2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getTranslatedPricingText1() ).as(" pack.getPricePoints().get(2).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getTranslatedPricingText2() ).as(" pack.getPricePoints().get(2).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getRecurrenceDay() ).as(" pack.getPricePoints().get(2).getRecurrenceDay()" ).isEqualTo(0) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getPricePoints().get(2).isAlignWithExternal() ).as(" pack.getPricePoints().get(2).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getGracePeriod() ).as(" pack.getPricePoints().get(2).getGracePeriod()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getRetryFrequency() ).as(" pack.getPricePoints().get(2).getRetryFrequency()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getSuspensionPeriod() ).as(" pack.getPricePoints().get(2).getSuspensionPeriod()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isGraceSuspensionRetryFrequencyUndefined() ).as(" pack.getPricePoints().get(2).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getTranslatedPricingText() ).as(" pack.getPricePoints().get(2).getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getFairUsageLimit() ).as(" pack.getPricePoints().get(2).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(2).getFairUsagePeriod() ).as(" pack.getPricePoints().get(2).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(2).getFairUsagePeriodUnit() ).as(" pack.getPricePoints().get(2).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(pack.getPricePoints().get(2).getExtensionPeriod() ).as(" pack.getPricePoints().get(2).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).isIncludeServiceForPackageFUP() ).as(" pack.getPricePoints().get(2).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isFairUsagePolicyEnabled() ).as(" pack.getPricePoints().get(2).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isTariff() ).as(" pack.getPricePoints().get(2).isTariff()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isHideForPurchaseOptions() ).as(" pack.getPricePoints().get(2).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getName() ).as(" pack.getPricePoints().get(2).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getKey() ).as(" pack.getPricePoints().get(2).getTax().getKey()" ).isNull();
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRate() ).as(" pack.getPricePoints().get(2).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxCode() ).as(" pack.getPricePoints().get(2).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().size()).as("pack.getPricePoints().get(2).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(pack.getPricePoints().get(2).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().get(0).getValue() ).as(" pack.getPricePoints().get(2).getTax().getTaxRates().get(0).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().get(0).getKey() ).as(" pack.getPricePoints().get(2).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().get(1).getValue() ).as(" pack.getPricePoints().get(2).getTax().getTaxRates().get(1).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().get(1).getKey() ).as(" pack.getPricePoints().get(2).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().get(2).getValue() ).as(" pack.getPricePoints().get(2).getTax().getTaxRates().get(2).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getPricePoints().get(2).getTax().getTaxRates().get(2).getKey() ).as(" pack.getPricePoints().get(2).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getBalances().length ).as(" pack.getPricePoints().get(2).getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().getName() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().getDescription() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().isToken() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().isResource() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getResource().getCode() ).as(" pack.getPricePoints().get(2).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getThreshold() ).as(" pack.getPricePoints().get(2).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getBalance() ).as(" pack.getPricePoints().get(2).getBalances()[0].getBalance()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getPackageId() ).as(" pack.getPricePoints().get(2).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getSubscriptionId() ).as(" pack.getPricePoints().get(2).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong() ).as(" pack.getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId() ).as(" pack.getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getBalances()[0].getSubscription() ).as(" pack.getPricePoints().get(2).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isRecurring() ).as(" pack.getPricePoints().get(2).isRecurring()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getRenewalsUntilLinkedPricepoint() ).as(" pack.getPricePoints().get(2).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getKey() ).as(" pack.getPricePoints().get(2).getPricePointTier().getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getPromotionalPricingTextList() ).as(" pack.getPricePoints().get(2).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size()).as("pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getPromotionalPrice() ).as(" pack.getPricePoints().get(2).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getPromotionalPricingText() ).as(" pack.getPricePoints().get(2).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getPricingModel() ).as(" pack.getPricePoints().get(2).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().getTier() ).as(" pack.getPricePoints().get(2).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTier().isDefaultPPT() ).as(" pack.getPricePoints().get(2).getPricePointTier().isDefaultPPT()" ).isTrue() ;
//check size of list!
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().size()).as("pack.getPricePoints().get(2).getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(2).getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getId() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getType() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPackageIdentifier() ).as(" pack.getPricePoints().get(2).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_2_4_999_999_999_*_*_*_false_false_*");
        softly.assertThat(pack.getPricePoints().get(2).getServiceIdentifier() ).as(" pack.getPricePoints().get(2).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().getName() ).as(" pack.getPricePoints().get(2).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().getDescription() ).as(" pack.getPricePoints().get(2).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().getResourceName() ).as(" pack.getPricePoints().get(2).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().getCountryId() ).as(" pack.getPricePoints().get(2).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().isToken() ).as(" pack.getPricePoints().get(2).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().isUsageToken() ).as(" pack.getPricePoints().get(2).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().isPayToken() ).as(" pack.getPricePoints().get(2).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().isCurrency() ).as(" pack.getPricePoints().get(2).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().isResource() ).as(" pack.getPricePoints().get(2).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getResourceField().getCode() ).as(" pack.getPricePoints().get(2).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getStandardRateWithoutTax() ).as(" pack.getPricePoints().get(2).getStandardRateWithoutTax()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).isVolumeType() ).as(" pack.getPricePoints().get(2).isVolumeType()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isOriginal() ).as(" pack.getPricePoints().get(2).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers().length ).as(" pack.getPricePoints().get(2).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getKey() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size()).as("pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPrice() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingText() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getPricingModel() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].getTier() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getPricePoints().get(2).getPricePointTiers()[0].isDefaultPPT() ).as(" pack.getPricePoints().get(2).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).getProtectedFk() ).as(" pack.getPricePoints().get(2).getProtectedFk()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getmPricingText1() ).as(" pack.getPricePoints().get(2).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).getmPricingText2() ).as(" pack.getPricePoints().get(2).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricePoints().get(2).isNonRecurring() ).as(" pack.getPricePoints().get(2).isNonRecurring()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).isEvent() ).as(" pack.getPricePoints().get(2).isEvent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getChannel() ).as(" pack.getPricePoints().get(2).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(2).getMultiUsageMode() ).as(" pack.getPricePoints().get(2).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getNetworkCodeMatchMethod() ).as(" pack.getPricePoints().get(2).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(2).isPreRatePriceGross() ).as(" pack.getPricePoints().get(2).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getPreRate() ).as(" pack.getPricePoints().get(2).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getPaymentInformation() ).as(" pack.getPricePoints().get(2).getPaymentInformation()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getContentName() ).as(" pack.getPricePoints().get(2).getContentName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAssetID() ).as(" pack.getPricePoints().get(2).getAssetID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPremiumLevel() ).as(" pack.getPricePoints().get(2).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(2).getReserveOnlyFlag() ).as(" pack.getPricePoints().get(2).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(pack.getPricePoints().get(2).getSupplierId() ).as(" pack.getPricePoints().get(2).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(2).getDeviceType() ).as(" pack.getPricePoints().get(2).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getUserGroups().length ).as(" pack.getPricePoints().get(2).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(2).getUserGroup() ).as(" pack.getPricePoints().get(2).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(2).getPaymentType() ).as(" pack.getPricePoints().get(2).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(pack.getPricePoints().get(2).getEventDateTime() ).as(" pack.getPricePoints().get(2).getEventDateTime()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getEventUnits() ).as(" pack.getPricePoints().get(2).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getPromoCodes().length ).as(" pack.getPricePoints().get(2).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(pack.getPricePoints().get(2).getBearerIds().length ).as(" pack.getPricePoints().get(2).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getPricePoints().get(2).getPromoCode() ).as(" pack.getPricePoints().get(2).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(2).getDuration() ).as(" pack.getPricePoints().get(2).getDuration()" ).isEqualTo(4) ;
        softly.assertThat(pack.getPricePoints().get(2).getChargingMethod() ).as(" pack.getPricePoints().get(2).getChargingMethod()" ).isEqualTo(2) ;
        softly.assertThat(pack.getPricePoints().get(2).getBearer() ).as(" pack.getPricePoints().get(2).getBearer()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(2).isInteractive() ).as(" pack.getPricePoints().get(2).isInteractive()" ).isTrue() ;
        softly.assertThat(pack.getPricePoints().get(2).isIncludeUnavailable() ).as(" pack.getPricePoints().get(2).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getExpressFlag() ).as(" pack.getPricePoints().get(2).getExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isExpressFlag() ).as(" pack.getPricePoints().get(2).isExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isCancellationUsage() ).as(" pack.getPricePoints().get(2).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getTierName() ).as(" pack.getPricePoints().get(2).getTierName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPromoPrecode() ).as(" pack.getPricePoints().get(2).getPromoPrecode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getUniquePromoCode() ).as(" pack.getPricePoints().get(2).getUniquePromoCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPromoUniqueCode() ).as(" pack.getPricePoints().get(2).getPromoUniqueCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getNextCycleDiscount() ).as(" pack.getPricePoints().get(2).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).getHasHistoricPricePointFlag() ).as(" pack.getPricePoints().get(2).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isIsForRenewal() ).as(" pack.getPricePoints().get(2).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getTaxRateAsDouble() ).as(" pack.getPricePoints().get(2).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAffiliateID() ).as(" pack.getPricePoints().get(2).getAffiliateID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPartnerId() ).as(" pack.getPricePoints().get(2).getPartnerId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getTariff() ).as(" pack.getPricePoints().get(2).getTariff()" ).isEqualTo("*");
        softly.assertThat(pack.getPricePoints().get(2).getAggregatorId() ).as(" pack.getPricePoints().get(2).getAggregatorId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isForcePurchaseFlow() ).as(" pack.getPricePoints().get(2).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getReceipientMsisdn() ).as(" pack.getPricePoints().get(2).getReceipientMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getProductCode() ).as(" pack.getPricePoints().get(2).getProductCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getMerchantName() ).as(" pack.getPricePoints().get(2).getMerchantName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getInvoiceText() ).as(" pack.getPricePoints().get(2).getInvoiceText()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isReIssueEnabled() ).as(" pack.getPricePoints().get(2).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isReIssueFlagPresent() ).as(" pack.getPricePoints().get(2).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getShortPackageId() ).as(" pack.getPricePoints().get(2).getShortPackageId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getHistoryStartDate() ).as(" pack.getPricePoints().get(2).getHistoryStartDate()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getVendorId() ).as(" pack.getPricePoints().get(2).getVendorId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).isIsForNextPaymentAmount() ).as(" pack.getPricePoints().get(2).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getRenewalPreRate() ).as(" pack.getPricePoints().get(2).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getPricePoints().get(2).isOverrideDisallowPreRateFlag() ).as(" pack.getPricePoints().get(2).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getContentCategory() ).as(" pack.getPricePoints().get(2).getContentCategory()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPartnerUrl() ).as(" pack.getPricePoints().get(2).getPartnerUrl()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPartnerContactInfo() ).as(" pack.getPricePoints().get(2).getPartnerContactInfo()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPartnerEmail() ).as(" pack.getPricePoints().get(2).getPartnerEmail()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPartnerName() ).as(" pack.getPricePoints().get(2).getPartnerName()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getSubRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoints().get(2).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(2).getPPtRenewalCounterToLinkedPricepoint() ).as(" pack.getPricePoints().get(2).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getPricePoints().get(2).getSubRenewalPricepointId() ).as(" pack.getPricePoints().get(2).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getLinkPricepointId() ).as(" pack.getPricePoints().get(2).getLinkPricepointId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getSubPurchaseTransactionTrial() ).as(" pack.getPricePoints().get(2).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getDiscardHiddenInactivePricepoints() ).as(" pack.getPricePoints().get(2).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).isDiscardMiddleAdvancedPricepoints() ).as(" pack.getPricePoints().get(2).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(pack.getPricePoints().get(2).getExtIdentifier1() ).as(" pack.getPricePoints().get(2).getExtIdentifier1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getExtIdentifier2() ).as(" pack.getPricePoints().get(2).getExtIdentifier2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getExtIdentifier3() ).as(" pack.getPricePoints().get(2).getExtIdentifier3()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getAccessChannel() ).as(" pack.getPricePoints().get(2).getAccessChannel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getPurchaseChannel() ).as(" pack.getPricePoints().get(2).getPurchaseChannel()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getDeviceID() ).as(" pack.getPricePoints().get(2).getDeviceID()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getLocal() ).as(" pack.getPricePoints().get(2).getLocal()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getMsisdn() ).as(" pack.getPricePoints().get(2).getMsisdn()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getLanguageLocale() ).as(" pack.getPricePoints().get(2).getLanguageLocale()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getLanguageCode() ).as(" pack.getPricePoints().get(2).getLanguageCode()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getExternalField1() ).as(" pack.getPricePoints().get(2).getExternalField1()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getExternalField2() ).as(" pack.getPricePoints().get(2).getExternalField2()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getExternalTransId() ).as(" pack.getPricePoints().get(2).getExternalTransId()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getActiveSubscriptions() ).as(" pack.getPricePoints().get(2).getActiveSubscriptions()" ).isNull();
        softly.assertThat(pack.getPricePoints().get(2).getCsrId() ).as(" pack.getPricePoints().get(2).getCsrId()" ).isNull();
        softly.assertThat(pack.getProtectedType() ).as(" pack.getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(pack.getDynamicProtectedValue() ).as(" pack.getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(pack.getPurchaseMethod() ).as(" pack.getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(pack.getKpiPackageProductCategory() ).as(" pack.getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getKpiPackageType() ).as(" pack.getKpiPackageType()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(pack.getPricingModels().length ).as(" pack.getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(pack.isExpressPurchase() ).as(" pack.isExpressPurchase()" ).isFalse() ;
        softly.assertThat(pack.isRecieptingFlag() ).as(" pack.isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(pack.isPricePointOrder() ).as(" pack.isPricePointOrder()" ).isFalse() ;
        softly.assertThat(pack.isSuperPackage() ).as(" pack.isSuperPackage()" ).isFalse() ;
        softly.assertThat(pack.isRevenueShareByUsage() ).as(" pack.isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(pack.isDynamicDefault() ).as(" pack.isDynamicDefault()" ).isFalse() ;
        softly.assertThat(pack.getACEPackage() ).as(" pack.getACEPackage()" ).isFalse() ;
        softly.assertThat(pack.isUpSell() ).as(" pack.isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.getLogoId() ).as(" pack.getLogoId()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(pack.getPartnerInfo() ).as(" pack.getPartnerInfo()" ).isNullOrEmpty();
        softly.assertThat(pack.getIsPackageModel() ).as(" pack.getIsPackageModel()" ).isFalse() ;
        softly.assertThat(pack.isParentPackage() ).as(" pack.isParentPackage()" ).isFalse() ;
        softly.assertThat(pack.getChildPackages() ).as(" pack.getChildPackages()" ).isNull();
        softly.assertThat(pack.getServicesNotInPackageFairUsagePolicyList() ).as(" pack.getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(pack.isHasParentSub() ).as(" pack.isHasParentSub()" ).isFalse() ;
        softly.assertThat(pack.getParentSubId() ).as(" pack.getParentSubId()" ).isNull();
        softly.assertThat(pack.isHasParentSubSuspendedResProv() ).as(" pack.isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(pack.getParentSubStatus() ).as(" pack.getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(pack.isDisallowCancellations() ).as(" pack.isDisallowCancellations()" ).isFalse() ;
        softly.assertThat(pack.getSalesModel() ).as(" pack.getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(pack.getPackageClass() ).as(" pack.getPackageClass()" ).isNull();
        softly.assertThat(pack.isDataVoiceTariffInclusive() ).as(" pack.isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(pack.getNominalValue() ).as(" pack.getNominalValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.isUseBeingDeprovisionedStatus() ).as(" pack.isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(pack.getDisallowDuplicateSubPurchase() ).as(" pack.getDisallowDuplicateSubPurchase()" ).isNullOrEmpty();
        softly.assertThat(pack.getNoActivePricepoints() ).as(" pack.getNoActivePricepoints()" ).isEqualTo(2) ;
        softly.assertThat(pack.isHasBalanceImpactsWithDate() ).as(" pack.isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(pack.isHasPricePointsWithDate() ).as(" pack.isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(pack.isHasPromosWithDate() ).as(" pack.isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(pack.isHasTaxRateWithDate() ).as(" pack.isHasTaxRateWithDate()" ).isFalse() ;
        softly.assertThat(pack.getPromoCodeMap() ).as(" pack.getPromoCodeMap()" ).isNull();
        softly.assertThat(pack.getPromoCodeMapSize() ).as(" pack.getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(pack.getActiveStatusAsString() ).as(" pack.getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(pack.isUseRateCardService() ).as(" pack.isUseRateCardService()" ).isFalse() ;
        softly.assertThat(pack.getRateCardServiceId() ).as(" pack.getRateCardServiceId()" ).isNullOrEmpty();
        softly.assertThat(pack.isUserGroupCalendarPricePointPackage() ).as(" pack.isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(pack.isUpsellDiscountProrated() ).as(" pack.isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(pack.isDisallowPrerate() ).as(" pack.isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceNames().length ).as(" pack.getServiceNames().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getDefaultPartnerProvisioningId() ).as(" pack.getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(pack.getUserGroupComparisonAtRenewal() ).as(" pack.getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
        softly.assertThat(pack.getTaxCode() ).as(" pack.getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getUrl() ).as(" pack.getUrl()" ).isNull();
        softly.assertThat(pack.getPricingText1() ).as(" pack.getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getPricingText2() ).as(" pack.getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getRate() ).as(" pack.getRate()" ).isEqualTo(new Double(11.75)) ;
// java.util.HashMap
        softly.assertThat(pack.isReserveOnly() ).as(" pack.isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.isOriginal() ).as(" pack.isOriginal()" ).isFalse() ;
        softly.assertThat(pack.getPricingModel() ).as(" pack.getPricingModel()" ).isNull();
//check size of list!
        softly.assertThat(pack.getServices().size()).as("pack.getServices().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServices().size() >= 1);
        softly.assertThat(pack.getServices().get(0).getName() ).as(" pack.getServices().get(0).getName()" ).isEqualTo("Alternative Payment Service");
        softly.assertThat(pack.getServices().get(0).getKey() ).as(" pack.getServices().get(0).getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(pack.getServices().get(0).getId() ).as(" pack.getServices().get(0).getId()" ).isEqualTo("sAlt");
        softly.assertThat(pack.getServices().get(0).getDisplayName() ).as(" pack.getServices().get(0).getDisplayName()" ).isEqualTo("sAlt (Alternative Payment Service)");
        softly.assertThat(pack.getServices().get(0).getDescription() ).as(" pack.getServices().get(0).getDescription()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getServiceType() ).as(" pack.getServices().get(0).getServiceType()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).isReturnAllCatalogueServicesInfo() ).as(" pack.getServices().get(0).isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).isDefaultService() ).as(" pack.getServices().get(0).isDefaultService()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getProvisioningSystem() ).as(" pack.getServices().get(0).getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getUsageId() ).as(" pack.getServices().get(0).getUsageId()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getServiceCategory() ).as(" pack.getServices().get(0).getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getDealName() ).as(" pack.getServices().get(0).getDealName()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getDistributionChannel() ).as(" pack.getServices().get(0).getDistributionChannel()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getHighVolumeInterfaceLevel() ).as(" pack.getServices().get(0).getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(pack.getServices().get(0).isHighVolumeInterface() ).as(" pack.getServices().get(0).isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServices().get(0).getServiceRevenueSharePartners().length ).as(" pack.getServices().get(0).getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getServiceRevenueSharePartnerNum() ).as(" pack.getServices().get(0).getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(pack.getServices().get(0).getServiceRevenueSharePartnersPurchaseCh().length ).as(" pack.getServices().get(0).getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getIndirectValue() ).as(" pack.getServices().get(0).getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getIndirectValueFormat() ).as(" pack.getServices().get(0).getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(pack.getServices().get(0).getPromoValue() ).as(" pack.getServices().get(0).getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPromoValueFormat() ).as(" pack.getServices().get(0).getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(pack.getServices().get(0).getContentSubCategory() ).as(" pack.getServices().get(0).getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getContentItem() ).as(" pack.getServices().get(0).getContentItem()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getDeliveryMechanism() ).as(" pack.getServices().get(0).getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getProductCategory() ).as(" pack.getServices().get(0).getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getProductSubCategory1() ).as(" pack.getServices().get(0).getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getProductSubCategory2() ).as(" pack.getServices().get(0).getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getProductWholesalePrice() ).as(" pack.getServices().get(0).getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getProductSelfRegulation() ).as(" pack.getServices().get(0).getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).isVolumeService() ).as(" pack.getServices().get(0).isVolumeService()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getProductFk() ).as(" pack.getServices().get(0).getProductFk()" ).isNull();
        softly.assertThat(pack.getServices().get(0).isServiceShareOverride() ).as(" pack.getServices().get(0).isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).isExpiredPackageService() ).as(" pack.getServices().get(0).isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getFixedUsageAmount() ).as(" pack.getServices().get(0).getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServices().get(0).getHasExpress() ).as(" pack.getServices().get(0).getHasExpress()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getHasDynamicDefault() ).as(" pack.getServices().get(0).getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getHasSuperPackage() ).as(" pack.getServices().get(0).getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).isReturnTrialOptionsOnly() ).as(" pack.getServices().get(0).isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getServiceClass() ).as(" pack.getServices().get(0).getServiceClass()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getBandRevenueShares() ).as(" pack.getServices().get(0).getBandRevenueShares()" ).isNull();
        softly.assertThat(pack.getServices().get(0).isReIssuePermittedFlag() ).as(" pack.getServices().get(0).isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getChargeableBy() ).as(" pack.getServices().get(0).getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(pack.getServices().get(0).getPackageIds().length ).as(" pack.getServices().get(0).getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServices().get(0).isMicroService() ).as(" pack.getServices().get(0).isMicroService()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getSuperPackageIds() ).as(" pack.getServices().get(0).getSuperPackageIds()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getmExternalServPricePlan() ).as(" pack.getServices().get(0).getmExternalServPricePlan()" ).isNull();
        softly.assertThat(pack.getServices().get(0).ismRefundable() ).as(" pack.getServices().get(0).ismRefundable()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).ismReturnTrialOptionsOnly() ).as(" pack.getServices().get(0).ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).isUseRateCard() ).as(" pack.getServices().get(0).isUseRateCard()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getInternalPartner() ).as(" pack.getServices().get(0).getInternalPartner()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getRateCardPartners() ).as(" pack.getServices().get(0).getRateCardPartners()" ).isNull();
        softly.assertThat(pack.getServices().get(0).isUsageAllowedBeingProvisionedSub() ).as(" pack.getServices().get(0).isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).isGlobalHandler() ).as(" pack.getServices().get(0).isGlobalHandler()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).isGlobalHandlerNotification() ).as(" pack.getServices().get(0).isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPriorityServiceRevenueSharePartner() ).as(" pack.getServices().get(0).getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(pack.getServices().get(0).isUniqueServiceClass() ).as(" pack.getServices().get(0).isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoint() ).as(" pack.getServices().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getNotificationCategory() ).as(" pack.getServices().get(0).getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getKey() ).as(" pack.getServices().get(0).getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getDescription() ).as(" pack.getServices().get(0).getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getMerchant() ).as(" pack.getServices().get(0).getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getMerchantDescription() ).as(" pack.getServices().get(0).getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getItemVolume() ).as(" pack.getServices().get(0).getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getServiceType() ).as(" pack.getServices().get(0).getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getPromotion() ).as(" pack.getServices().get(0).getPaymentContent().getPromotion()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServices().get(0).getPaymentContent().getCategory() ).as(" pack.getServices().get(0).getPaymentContent().getCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getNonRefundableDescription() ).as(" pack.getServices().get(0).getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).isRefundable() ).as(" pack.getServices().get(0).isRefundable()" ).isTrue() ;
//check size of list!
        softly.assertThat(pack.getServices().get(0).getPricePoints().size()).as("pack.getServices().get(0).getPricePoints().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServices().get(0).getPricePoints().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().getDescription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().getResourceName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().getCountryId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().isToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().isUsageToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().isPayToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().getResourceSymbol() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().isCurrency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().isResource() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResource().getCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getId()" ).isEqualTo("content:pAlt_TAX_sAlt_1_999_999_999");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getDescription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getDescription()" ).isEqualTo("Default (event) , Channel 1");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isActive() ).as(" pack.getServices().get(0).getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getStartDate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getStartDate()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isPreOrder() ).as(" pack.getServices().get(0).getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTaxRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTaxCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" pack.getServices().get(0).getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getExpiryDate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getExpiryDate()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isDiscount() ).as(" pack.getServices().get(0).getPricePoints().get(0).isDiscount()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getDiscountPromoText() ).as(" pack.getServices().get(0).getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPackageId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getContentId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getContentId()" ).isEqualTo("sAlt");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricingText1() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricingText2() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getUsageTime() ).as(" pack.getServices().get(0).getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getAccessDuration() ).as(" pack.getServices().get(0).getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isZeroCostIgnore() ).as(" pack.getServices().get(0).getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getCustomResourceBalances() ).as(" pack.getServices().get(0).getPricePoints().get(0).getCustomResourceBalances()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getRate()" ).isEqualTo(new Double(2.35)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getStandardRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(2.35)) ;
//check size of array!
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances().length ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isResource() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getNetRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" pack.getServices().get(0).getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricingModelTier() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isArchived() ).as(" pack.getServices().get(0).getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isBasePricePoint() ).as(" pack.getServices().get(0).getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getAccessDevice() ).as(" pack.getServices().get(0).getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getAlternativeRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(2.35)) ;
//check size of array!
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts().length ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
//check size of list!
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size()).as("pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isTrial() ).as(" pack.getServices().get(0).getPricePoints().get(0).isTrial()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getGlid() ).as(" pack.getServices().get(0).getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricepointIdLink() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isPreview() ).as(" pack.getServices().get(0).getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getInteractiveFlag() ).as(" pack.getServices().get(0).getPricePoints().get(0).getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isForcedPurchase() ).as(" pack.getServices().get(0).getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isSubscriptionDuplicate() ).as(" pack.getServices().get(0).getPricePoints().get(0).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getFixedExpiryDate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isReserveOnly() ).as(" pack.getServices().get(0).getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getMinSubPeriod() ).as(" pack.getServices().get(0).getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPenaltyCharges() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getCancellation() ).as(" pack.getServices().get(0).getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getMonthEndSubscription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isHistoric() ).as(" pack.getServices().get(0).getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getFixedRecurrence() ).as(" pack.getServices().get(0).getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" pack.getServices().get(0).getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isReceipting() ).as(" pack.getServices().get(0).getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getReceiptingAttribute() ).as(" pack.getServices().get(0).getPricePoints().get(0).getReceiptingAttribute()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getOrder() ).as(" pack.getServices().get(0).getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPaymentHandler() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" pack.getServices().get(0).getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isPromo() ).as(" pack.getServices().get(0).getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" pack.getServices().get(0).getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" pack.getServices().get(0).getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName1() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName2() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTranslatedPricingText1() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTranslatedPricingText2() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getRecurrenceDay() ).as(" pack.getServices().get(0).getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isAlignWithExternal() ).as(" pack.getServices().get(0).getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getGracePeriod() ).as(" pack.getServices().get(0).getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getRetryFrequency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getSuspensionPeriod() ).as(" pack.getServices().get(0).getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" pack.getServices().get(0).getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTranslatedPricingText() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getFairUsageLimit() ).as(" pack.getServices().get(0).getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getFairUsagePeriod() ).as(" pack.getServices().get(0).getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" pack.getServices().get(0).getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getExtensionPeriod() ).as(" pack.getServices().get(0).getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" pack.getServices().get(0).getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" pack.getServices().get(0).getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isTariff() ).as(" pack.getServices().get(0).getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isHideForPurchaseOptions() ).as(" pack.getServices().get(0).getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getKey()" ).isNull();
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRate() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size()).as("pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getValue() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getValue() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getValue() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getValue()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances().length ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getBalance() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" pack.getServices().get(0).getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).isRecurring() ).as(" pack.getServices().get(0).getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" pack.getServices().get(0).getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getKey() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServices().get(0).getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");

        softly.assertAll();

    }
}
