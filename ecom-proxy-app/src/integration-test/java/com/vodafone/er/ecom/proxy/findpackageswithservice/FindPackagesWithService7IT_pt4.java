package com.vodafone.er.ecom.proxy.findpackageswithservice;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ravi Aghera
 */
public class FindPackagesWithService7IT_pt4 {

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


        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getBalance() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPromotionalPrice() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPromotionalPricingText() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPricingModel() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getTier() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().isDefaultPPT() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getName()" ).isEqualTo("GBP");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isCurrency()" ).isTrue() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getStandardRateWithoutTax() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getStandardRateWithoutTax()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isVolumeType() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isVolumeType()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isOriginal() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers().length ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()).as("pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPricingModel() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getTier() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getProtectedFk() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getProtectedFk()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getmPricingText1() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getmPricingText2() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isNonRecurring() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isNonRecurring()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isEvent() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isEvent()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isActive() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isPreOrder() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTaxRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTaxCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getKey()" ).isNull();
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().size()).as("pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).value() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).value() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).value() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getDescription()" ).isEqualTo("Default (event) , Channel 1");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isReserveOnly() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricingText1() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricingText2() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isTrial() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isTrial()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isRecurring() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPricepointIdLink() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isPromo() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAccessDevice() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().size()).as("pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getServiceIdentifier() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_sAlt_1_999_*_999_999");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPackageIdentifier() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_999_999_999_999_1_*_*_*_false_false_*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isHistoric() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExpiryDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExpiryDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getChannel() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getChannel()" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getMultiUsageMode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getNetworkCodeMatchMethod() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isPreRatePriceGross() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPreRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPaymentInformation() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPaymentInformation()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getContentName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getContentName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAssetID() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAssetID()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPremiumLevel() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getReserveOnlyFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getSupplierId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getDeviceType() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getUserGroups().length ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getUserGroup() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPaymentType() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getEventDateTime() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getEventDateTime()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getEventUnits() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPromoCodes().length ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBearerIds().length ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPromoCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getDuration() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getDuration()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getChargingMethod() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getBearer() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getBearer()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isInteractive() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isInteractive()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isIncludeUnavailable() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExpressFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isExpressFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isCancellationUsage() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTierName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTierName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPromoPrecode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPromoPrecode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getUniquePromoCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getUniquePromoCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPromoUniqueCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPromoUniqueCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getNextCycleDiscount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getHasHistoricPricePointFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isIsForRenewal() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTaxRateAsDouble() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAffiliateID() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAffiliateID()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPartnerId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPartnerId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getTariff() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getTariff()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAggregatorId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAggregatorId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isForcePurchaseFlow() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getReceipientMsisdn() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getReceipientMsisdn()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getProductCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getProductCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getMerchantName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getMerchantName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getInvoiceText() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getInvoiceText()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isReIssueEnabled() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isReIssueFlagPresent() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getShortPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getShortPackageId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getHistoryStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getHistoryStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getVendorId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getVendorId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isIsForNextPaymentAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getRenewalPreRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isOverrideDisallowPreRateFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getContentCategory() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getContentCategory()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPartnerUrl() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPartnerUrl()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPartnerContactInfo() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPartnerContactInfo()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPartnerEmail() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPartnerEmail()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPartnerName() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPartnerName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getSubRenewalPricepointId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getLinkPricepointId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getLinkPricepointId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getSubPurchaseTransactionTrial() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getDiscardHiddenInactivePricepoints() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExtIdentifier1() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExtIdentifier1()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExtIdentifier2() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExtIdentifier2()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExtIdentifier3() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExtIdentifier3()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getAccessChannel() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getAccessChannel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getPurchaseChannel() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getPurchaseChannel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getDeviceID() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getDeviceID()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getLocal() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getLocal()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getMsisdn() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getMsisdn()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getLanguageLocale() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getLanguageLocale()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getLanguageCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getLanguageCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExternalField1() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExternalField1()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExternalField2() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExternalField2()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getExternalTransId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getExternalTransId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getActiveSubscriptions() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getActiveSubscriptions()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(0).getCsrId() ).as(" pack.getServiceArray()[0].getPricePoints().get(0).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().isResource()" ).isTrue() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().getDescription()" ).isNull();
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getId()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_999_999");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isZeroCostIgnore() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricingModelTier() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricingModelTier()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isArchived() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isArchived()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isBasePricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getNetRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAlternativeRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAlternativeRate()" ).isEqualTo(new Double(1.175)) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100035");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().size()).as("pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getGlid() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getGlid()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getContentId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getContentId()" ).isEqualTo("sAlt");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isDiscount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isDiscount()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getStandardRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getStandardRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getDiscountPromoText() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isPreview() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isPreview()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getInteractiveFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isForcedPurchase() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isSubscriptionDuplicate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getFixedExpiryDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getFixedExpiryDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getMinSubPeriod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPenaltyCharges() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCancellation() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCancellation()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getMonthEndSubscription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getFixedRecurrence() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isFixedRecurringPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isReceipting() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isReceipting()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getReceiptingAttribute() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getReceiptingAttribute()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getOrder() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPaymentHandler() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPaymentHandler()" ).isEqualTo("NULL");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isSubmitToPaymentHandler() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isSuppressToPaymentHandler() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricingTextTemplateName1() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricingTextTemplateName2() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTranslatedPricingText1() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTranslatedPricingText2() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getUsageTime() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getRecurrenceDay() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isAlignWithExternal() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAccessDuration() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getGracePeriod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getGracePeriod()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getRetryFrequency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getRetryFrequency()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getSuspensionPeriod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getSuspensionPeriod()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTranslatedPricingText() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getFairUsageLimit() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getFairUsagePeriod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getFairUsagePeriodUnit() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExtensionPeriod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isIncludeServiceForPackageFUP() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isFairUsagePolicyEnabled() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isTariff() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isTariff()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isHideForPurchaseOptions() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isHideForPurchaseOptions()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getBalance() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getSubscription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getBalance() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isAlwaysValidateMsisdn() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isAlwaysValidateMsisdn()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getBalance() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getSubscription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getSubscriptionIdLong() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getOldestSubscriptionId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getRenewalsUntilLinkedPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size()).as("pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPromotionalPrice() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPromotionalPricingText() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPricingModel() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getTier() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().isDefaultPPT() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPromotionalPricingTextList() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isResource()" ).isTrue() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getDescription()" ).isNull();
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100035");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getStandardRateWithoutTax() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isVolumeType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isVolumeType()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isOriginal() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()).as("pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPricingModel() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getTier() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getProtectedFk() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getProtectedFk()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getmPricingText1() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getmPricingText2() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isNonRecurring() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isNonRecurring()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isEvent() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isEvent()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isActive() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isActive()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isPreOrder() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isPreOrder()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTaxRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTaxCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getLinkedByTrialPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getLinkedByTrialPricepoint()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getKey()" ).isNull();
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().size()).as("pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(0).value() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(1).value() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(1).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(2).value() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(2).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isReserveOnly() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isReserveOnly()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricingText1() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricingText2() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricingText2()" ).isNullOrEmpty();
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isTrial() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isTrial()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getNonMatchAllUserGroups().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isRecurring() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isRecurring()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPricepointIdLink() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isPromo() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isPromo()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAccessDevice() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAccessDevice()" ).isEqualTo(999) ;
//check size of list!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().size()).as("pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getServiceIdentifier() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_*_999_999");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPackageIdentifier() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isHistoric() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isHistoric()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExpiryDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExpiryDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getChannel() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getMultiUsageMode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getNetworkCodeMatchMethod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isPreRatePriceGross() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPreRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPaymentInformation() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPaymentInformation()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getContentName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getContentName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAssetID() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAssetID()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPremiumLevel() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getReserveOnlyFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getSupplierId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getDeviceType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getUserGroups().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getUserGroup() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPaymentType() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getEventDateTime() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getEventDateTime()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getEventUnits() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPromoCodes().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBearerIds().length ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPromoCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getDuration() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getDuration()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getChargingMethod() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getBearer() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getBearer()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isInteractive() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isInteractive()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isIncludeUnavailable() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExpressFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isExpressFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isExpressFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isCancellationUsage() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTierName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTierName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPromoPrecode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPromoPrecode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getUniquePromoCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getUniquePromoCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPromoUniqueCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPromoUniqueCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getNextCycleDiscount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getHasHistoricPricePointFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isIsForRenewal() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTaxRateAsDouble() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAffiliateID() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAffiliateID()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPartnerId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPartnerId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getTariff() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getTariff()" ).isEqualTo("*");
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAggregatorId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAggregatorId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isForcePurchaseFlow() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getReceipientMsisdn() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getReceipientMsisdn()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getProductCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getProductCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getMerchantName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getMerchantName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getInvoiceText() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getInvoiceText()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isReIssueEnabled() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isReIssueFlagPresent() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getShortPackageId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getShortPackageId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getHistoryStartDate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getHistoryStartDate()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getVendorId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getVendorId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isIsForNextPaymentAmount() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getRenewalPreRate() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isOverrideDisallowPreRateFlag() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getContentCategory() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getContentCategory()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPartnerUrl() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPartnerUrl()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPartnerContactInfo() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPartnerContactInfo()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPartnerEmail() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPartnerEmail()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPartnerName() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPartnerName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getSubRenewalPricepointId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getLinkPricepointId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getLinkPricepointId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getSubPurchaseTransactionTrial() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getDiscardHiddenInactivePricepoints() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExtIdentifier1() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExtIdentifier1()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExtIdentifier2() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExtIdentifier2()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExtIdentifier3() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExtIdentifier3()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getAccessChannel() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getAccessChannel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getPurchaseChannel() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getPurchaseChannel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getDeviceID() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getDeviceID()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getLocal() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getLocal()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getMsisdn() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getMsisdn()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getLanguageLocale() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getLanguageLocale()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getLanguageCode() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getLanguageCode()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExternalField1() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExternalField1()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExternalField2() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExternalField2()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getExternalTransId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getExternalTransId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getActiveSubscriptions() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getActiveSubscriptions()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricePoints().get(1).getCsrId() ).as(" pack.getServiceArray()[0].getPricePoints().get(1).getCsrId()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getProvisioningTag() ).as(" pack.getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(pack.getServiceArray()[0].getProvisioningSystem() ).as(" pack.getServiceArray()[0].getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getUsageId() ).as(" pack.getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getUrl() ).as(" pack.getServiceArray()[0].getUrl()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getNotificationCategory() ).as(" pack.getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getKey() ).as(" pack.getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getDescription() ).as(" pack.getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getServiceType() ).as(" pack.getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getCategory() ).as(" pack.getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getMerchant() ).as(" pack.getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" pack.getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" pack.getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(pack.getServiceArray()[0].getPaymentContent().getPromotion() ).as(" pack.getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getServiceCategory() ).as(" pack.getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].isReserveOnly() ).as(" pack.getServiceArray()[0].isReserveOnly()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.getServiceArray()[0].getDealName() ).as(" pack.getServiceArray()[0].getDealName()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getPricingText1() ).as(" pack.getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPricingText2() ).as(" pack.getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getDistributionChannel() ).as(" pack.getServiceArray()[0].getDistributionChannel()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" pack.getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(pack.getServiceArray()[0].isHighVolumeInterface() ).as(" pack.getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" pack.getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" pack.getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" pack.getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].getIndirectValue() ).as(" pack.getServiceArray()[0].getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getIndirectValueFormat() ).as(" pack.getServiceArray()[0].getIndirectValueFormat()" ).isEqualTo("%");
        softly.assertThat(pack.getServiceArray()[0].getPromoValue() ).as(" pack.getServiceArray()[0].getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getPromoValueFormat() ).as(" pack.getServiceArray()[0].getPromoValueFormat()" ).isEqualTo("%");
        softly.assertThat(pack.getServiceArray()[0].getContentSubCategory() ).as(" pack.getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getContentItem() ).as(" pack.getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getDeliveryMechanism() ).as(" pack.getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getProductCategory() ).as(" pack.getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getProductSubCategory1() ).as(" pack.getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getProductSubCategory2() ).as(" pack.getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getProductWholesalePrice() ).as(" pack.getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getProductSelfRegulation() ).as(" pack.getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].getServiceType() ).as(" pack.getServiceArray()[0].getServiceType()" ).isNullOrEmpty();
        softly.assertThat(pack.getServiceArray()[0].isVolumeService() ).as(" pack.getServiceArray()[0].isVolumeService()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getProductFk() ).as(" pack.getServiceArray()[0].getProductFk()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].isServiceShareOverride() ).as(" pack.getServiceArray()[0].isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].isExpiredPackageService() ).as(" pack.getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getFixedUsageAmount() ).as(" pack.getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(pack.getServiceArray()[0].getHasExpress() ).as(" pack.getServiceArray()[0].getHasExpress()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getHasDynamicDefault() ).as(" pack.getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getHasSuperPackage() ).as(" pack.getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" pack.getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getSalesModel() ).as(" pack.getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(pack.getServiceArray()[0].getServiceClass() ).as(" pack.getServiceArray()[0].getServiceClass()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getBandRevenueShares() ).as(" pack.getServiceArray()[0].getBandRevenueShares()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].isReIssuePermittedFlag() ).as(" pack.getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].isProvisionOnUsage() ).as(" pack.getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getChargeableBy() ).as(" pack.getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
//check size of array!
//        softly.assertThat(pack.getServiceArray()[0].getPackageIds().length ).as(" pack.getServiceArray()[0].getPackageIds().length" ).isEqualTo(1) ;
        softly.assertThat(pack.getServiceArray()[0].isMicroService() ).as(" pack.getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getSuperPackageIds() ).as(" pack.getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getmExternalServPricePlan() ).as(" pack.getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].ismRefundable() ).as(" pack.getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(pack.getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" pack.getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].isUseRateCard() ).as(" pack.getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getInternalPartner() ).as(" pack.getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].getRateCardPartners() ).as(" pack.getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(pack.getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" pack.getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].isGlobalHandler() ).as(" pack.getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].isGlobalHandlerNotification() ).as(" pack.getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(pack.getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" pack.getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
//check size of array!
        softly.assertThat(pack.getServiceArray()[0].getPricingModels().length ).as(" pack.getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(pack.getServiceArray()[0].isUniqueServiceClass() ).as(" pack.getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(pack.isEventPackage() ).as(" pack.isEventPackage()" ).isFalse() ;
        softly.assertThat(pack.isRecurringPackage() ).as(" pack.isRecurringPackage()" ).isTrue() ;
        softly.assertThat(pack.getPackageType() ).as(" pack.getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(pack.isCalendarPackage() ).as(" pack.isCalendarPackage()" ).isTrue() ;
        softly.assertThat(pack.getProtectedType() ).as(" pack.getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(pack.getDynamicProtectedValue() ).as(" pack.getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(pack.getPurchaseMethod() ).as(" pack.getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(pack.getKpiPackageProductCategory() ).as(" pack.getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(pack.getKpiPackageType() ).as(" pack.getKpiPackageType()" ).isNullOrEmpty();
        softly.assertThat(pack.isExpressPurchase() ).as(" pack.isExpressPurchase()" ).isFalse() ;
        softly.assertThat(pack.isRecieptingFlag() ).as(" pack.isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(pack.isPricePointOrder() ).as(" pack.isPricePointOrder()" ).isFalse() ;
        softly.assertThat(pack.isSuperPackage() ).as(" pack.isSuperPackage()" ).isFalse() ;
        softly.assertThat(pack.isRevenueShareByUsage() ).as(" pack.isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(pack.isDynamicDefault() ).as(" pack.isDynamicDefault()" ).isFalse() ;
        softly.assertThat(pack.getACEPackage() ).as(" pack.getACEPackage()" ).isFalse() ;
        softly.assertThat(pack.isUpSell() ).as(" pack.isUpSell()" ).isFalse() ;
        softly.assertThat(pack.getLogoId() ).as(" pack.getLogoId()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(pack.getPartnerInfo() ).as(" pack.getPartnerInfo()" ).isNullOrEmpty();
        softly.assertThat(pack.getIsPackageModel() ).as(" pack.getIsPackageModel()" ).isFalse() ;
        softly.assertThat(pack.isParentPackage() ).as(" pack.isParentPackage()" ).isFalse() ;
        softly.assertThat(pack.getParentPackageId() ).as(" pack.getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(pack.getChildPackages() ).as(" pack.getChildPackages()" ).isNull();
        softly.assertThat(pack.getServicesNotInPackageFairUsagePolicyList() ).as(" pack.getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(pack.isHasParentSub() ).as(" pack.isHasParentSub()" ).isFalse() ;
        softly.assertThat(pack.getParentSubId() ).as(" pack.getParentSubId()" ).isNull();
        softly.assertThat(pack.isHasParentSubSuspendedResProv() ).as(" pack.isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(pack.getParentSubStatus() ).as(" pack.getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(pack.isDisallowCancellations() ).as(" pack.isDisallowCancellations()" ).isFalse() ;
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

        softly.assertAll();

    }


}
