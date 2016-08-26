package com.vodafone.er.ecom.proxy.usageauthratecharge;

import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.constants.EcomAppEnum.CLIENT_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class UsageAuthRateCharge3IT_pt2 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageAuthRateCharge3UsageAuthResponse() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        final String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";

        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        final ChargingApi chargingApi = EcomApiFactory.getChargingApi(Locale.UK);
        UsageAuthorization usageAuth = chargingApi.usageAuthRateCharge(CLIENT_ID.getValue(), msisdn, "sAlt", new UsageAttributes());
        assertNotNull(usageAuth);
        assertTrue(usageAuth.isSuccess());


        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getTier() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getProtectedFk() ).as(" usageAuth.getPackage().getPricePoints().get(1).getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getmPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getmPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getmPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getmPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isNonRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(1).isNonRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isEvent() ).as(" usageAuth.getPackage().getPricePoints().get(1).isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isActive() ).as(" usageAuth.getPackage().getPricePoints().get(1).isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getStandardRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getStandardRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getChannel() ).as(" usageAuth.getPackage().getPricePoints().get(1).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getMultiUsageMode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getNetworkCodeMatchMethod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isPreRatePriceGross() ).as(" usageAuth.getPackage().getPricePoints().get(1).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPreRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPaymentInformation() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getContentName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getContentName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAssetID() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPremiumLevel() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getReserveOnlyFlag() ).as(" usageAuth.getPackage().getPricePoints().get(1).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getSupplierId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDeviceType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getUserGroups().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getUserGroup() ).as(" usageAuth.getPackage().getPricePoints().get(1).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPaymentType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getEventDateTime() ).as(" usageAuth.getPackage().getPricePoints().get(1).getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getEventUnits() ).as(" usageAuth.getPackage().getPricePoints().get(1).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPromoCodes().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBearerIds().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDuration() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDuration()" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getChargingMethod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBearer() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isInteractive() ).as(" usageAuth.getPackage().getPricePoints().get(1).isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isIncludeUnavailable() ).as(" usageAuth.getPackage().getPricePoints().get(1).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExpressFlag() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isExpressFlag() ).as(" usageAuth.getPackage().getPricePoints().get(1).isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isCancellationUsage() ).as(" usageAuth.getPackage().getPricePoints().get(1).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTierName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTierName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPromoPrecode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getUniquePromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPromoUniqueCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getNextCycleDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getHasHistoricPricePointFlag() ).as(" usageAuth.getPackage().getPricePoints().get(1).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isIsForRenewal() ).as(" usageAuth.getPackage().getPricePoints().get(1).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTaxRateAsDouble() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAffiliateID() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPartnerId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTariff() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAggregatorId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isForcePurchaseFlow() ).as(" usageAuth.getPackage().getPricePoints().get(1).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getReceipientMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(1).getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getProductCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getMerchantName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getInvoiceText() ).as(" usageAuth.getPackage().getPricePoints().get(1).getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isReIssueEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(1).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isReIssueFlagPresent() ).as(" usageAuth.getPackage().getPricePoints().get(1).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getShortPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getHistoryStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getVendorId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isIsForNextPaymentAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getRenewalPreRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isOverrideDisallowPreRateFlag() ).as(" usageAuth.getPackage().getPricePoints().get(1).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getContentCategory() ).as(" usageAuth.getPackage().getPricePoints().get(1).getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPartnerUrl() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPartnerContactInfo() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPartnerEmail() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPartnerName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getSubRenewalPricepointId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getLinkPricepointId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getSubPurchaseTransactionTrial() ).as(" usageAuth.getPackage().getPricePoints().get(1).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getPackage().getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getId()" ).isEqualTo("package:pAlt_TAX_2_4_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDescription()" ).isEqualTo("Non-recurring 1 month");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isPreOrder() ).as(" usageAuth.getPackage().getPricePoints().get(2).isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getLinkedByTrialPricepoint()" ).isFalse() ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getRate()" ).isEqualTo(new Double(17.625)) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getNetRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getNetRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(2).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(2).isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPackageId()" ).isEqualTo("pAlt");
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingModelTier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isArchived() ).as(" usageAuth.getPackage().getPricePoints().get(2).isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isBasePricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAccessDevice() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAlternativeRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAlternativeRate()" ).isEqualTo(new Double(17.625)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().size()).as("usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isTrial() ).as(" usageAuth.getPackage().getPricePoints().get(2).isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(2).getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(2).getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricepointIdLink()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isPreview() ).as(" usageAuth.getPackage().getPricePoints().get(2).isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getInteractiveFlag() ).as(" usageAuth.getPackage().getPricePoints().get(2).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isForcedPurchase() ).as(" usageAuth.getPackage().getPricePoints().get(2).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getPricePoints().get(2).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFixedExpiryDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isReserveOnly() ).as(" usageAuth.getPackage().getPricePoints().get(2).isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getMinSubPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getMinSubPeriod()" ).isEqualTo(0) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricingTextTemplateName2()" ).isEqualTo("");
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFairUsageLimit() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getPricePoints().get(2).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getExtensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getPricePoints().get(2).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(2).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isTariff() ).as(" usageAuth.getPackage().getPricePoints().get(2).isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getPricePoints().get(2).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getName()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size()).as("usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().size() >= 3);
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getValue() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getValue()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getValue() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getValue()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getValue() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getValue()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getStartDate().getTimezoneOffset() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getStartDate().getTimezoneOffset()" ).isEqualTo(0) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getEndDate().getTimezoneOffset() ).as(" usageAuth.getPackage().getPricePoints().get(2).getTax().getTaxRates().get(2).getEndDate().getTimezoneOffset()" ).isEqualTo(0) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getBalance()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(2).isRecurring()" ).isFalse() ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPackageIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_2_4_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getServiceIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(2).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getPricePoints().get(2).getStandardRateWithoutTax()" ).isEqualTo(new Double(15.0)) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isNonRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(2).isNonRecurring()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isEvent() ).as(" usageAuth.getPackage().getPricePoints().get(2).isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).isActive() ).as(" usageAuth.getPackage().getPricePoints().get(2).isActive()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getStandardRate() ).as(" usageAuth.getPackage().getPricePoints().get(2).getStandardRate()" ).isEqualTo(new Double(17.625)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(15.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(2).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPaymentType() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getEventDateTime() ).as(" usageAuth.getPackage().getPricePoints().get(2).getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getEventUnits() ).as(" usageAuth.getPackage().getPricePoints().get(2).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPromoCodes().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getBearerIds().length ).as(" usageAuth.getPackage().getPricePoints().get(2).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getPromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(2).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getDuration() ).as(" usageAuth.getPackage().getPricePoints().get(2).getDuration()" ).isEqualTo(4) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(2).getChargingMethod() ).as(" usageAuth.getPackage().getPricePoints().get(2).getChargingMethod()" ).isEqualTo(2) ;
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
        softly.assertThat(usageAuth.getPackage().getProtectedType() ).as(" usageAuth.getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getProtectedType() ).as(" usageAuth.getPackage().getProtectedType()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getDynamicProtectedValue() ).as(" usageAuth.getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getDynamicProtectedValue() ).as(" usageAuth.getPackage().getDynamicProtectedValue()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPurchaseMethod() ).as(" usageAuth.getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPurchaseMethod() ).as(" usageAuth.getPackage().getPurchaseMethod()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getKpiPackageProductCategory() ).as(" usageAuth.getPackage().getKpiPackageProductCategory()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getKpiPackageType() ).as(" usageAuth.getPackage().getKpiPackageType()" ).isNull();
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricingModels().length ).as(" usageAuth.getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().isExpressPurchase() ).as(" usageAuth.getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isRecieptingFlag() ).as(" usageAuth.getPackage().isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isPricePointOrder() ).as(" usageAuth.getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isSuperPackage() ).as(" usageAuth.getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isRevenueShareByUsage() ).as(" usageAuth.getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isDynamicDefault() ).as(" usageAuth.getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getACEPackage() ).as(" usageAuth.getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isUpSell() ).as(" usageAuth.getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getLogoId() ).as(" usageAuth.getPackage().getLogoId()" ).isNull();
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPartnerInfo() ).as(" usageAuth.getPackage().getPartnerInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getIsPackageModel() ).as(" usageAuth.getPackage().getIsPackageModel()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isParentPackage() ).as(" usageAuth.getPackage().isParentPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getChildPackages() ).as(" usageAuth.getPackage().getChildPackages()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getServicesNotInPackageFairUsagePolicyList() ).as(" usageAuth.getPackage().getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isHasParentSub() ).as(" usageAuth.getPackage().isHasParentSub()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getParentSubId() ).as(" usageAuth.getPackage().getParentSubId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isHasParentSubSuspendedResProv() ).as(" usageAuth.getPackage().isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getParentSubStatus() ).as(" usageAuth.getPackage().getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().isDisallowCancellations() ).as(" usageAuth.getPackage().isDisallowCancellations()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getSalesModel() ).as(" usageAuth.getPackage().getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(usageAuth.getPackage().getPackageClass() ).as(" usageAuth.getPackage().getPackageClass()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isDataVoiceTariffInclusive() ).as(" usageAuth.getPackage().isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getNominalValue() ).as(" usageAuth.getPackage().getNominalValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().isUseBeingDeprovisionedStatus() ).as(" usageAuth.getPackage().isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getDisallowDuplicateSubPurchase() ).as(" usageAuth.getPackage().getDisallowDuplicateSubPurchase()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getNoActivePricepoints() ).as(" usageAuth.getPackage().getNoActivePricepoints()" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().isHasBalanceImpactsWithDate() ).as(" usageAuth.getPackage().isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isHasPricePointsWithDate() ).as(" usageAuth.getPackage().isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isHasPromosWithDate() ).as(" usageAuth.getPackage().isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isHasTaxRateWithDate() ).as(" usageAuth.getPackage().isHasTaxRateWithDate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPromoCodeMap() ).as(" usageAuth.getPackage().getPromoCodeMap()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPromoCodeMapSize() ).as(" usageAuth.getPackage().getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getActiveStatusAsString() ).as(" usageAuth.getPackage().getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(usageAuth.getPackage().isUseRateCardService() ).as(" usageAuth.getPackage().isUseRateCardService()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getRateCardServiceId() ).as(" usageAuth.getPackage().getRateCardServiceId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().isUserGroupCalendarPricePointPackage() ).as(" usageAuth.getPackage().isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isUpsellDiscountProrated() ).as(" usageAuth.getPackage().isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isDisallowPrerate() ).as(" usageAuth.getPackage().isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceNames().length ).as(" usageAuth.getPackage().getServiceNames().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getDefaultPartnerProvisioningId() ).as(" usageAuth.getPackage().getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getUserGroupComparisonAtRenewal() ).as(" usageAuth.getPackage().getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getKey() ).as(" usageAuth.getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getId() ).as(" usageAuth.getPackage().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isPreOrder() ).as(" usageAuth.getPackage().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTaxRate() ).as(" usageAuth.getPackage().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTaxCode() ).as(" usageAuth.getPackage().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getStartDate() ).as(" usageAuth.getPackage().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRate() ).as(" usageAuth.getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getExpiryDate() ).as(" usageAuth.getPackage().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getNetRate() ).as(" usageAuth.getPackage().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isDiscount() ).as(" usageAuth.getPackage().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getContentId() ).as(" usageAuth.getPackage().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingText1() ).as(" usageAuth.getPackage().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingText1() ).as(" usageAuth.getPackage().getPricePoint().getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingText2() ).as(" usageAuth.getPackage().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingText2() ).as(" usageAuth.getPackage().getPricePoint().getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getUsageTime() ).as(" usageAuth.getPackage().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAccessDuration() ).as(" usageAuth.getPackage().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isZeroCostIgnore() ).as(" usageAuth.getPackage().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances().length ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricingModelTier() ).as(" usageAuth.getPackage().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isArchived() ).as(" usageAuth.getPackage().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isBasePricePoint() ).as(" usageAuth.getPackage().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAccessDevice() ).as(" usageAuth.getPackage().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAlternativeRate() ).as(" usageAuth.getPackage().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts().length ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().size()).as("usageAuth.getPackage().getPricePoint().getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoint().getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isTrial() ).as(" usageAuth.getPackage().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getGlid() ).as(" usageAuth.getPackage().getPricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getGlid() ).as(" usageAuth.getPackage().getPricePoint().getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isPreview() ).as(" usageAuth.getPackage().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getInteractiveFlag() ).as(" usageAuth.getPackage().getPricePoint().getInteractiveFlag()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isForcedPurchase() ).as(" usageAuth.getPackage().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFixedExpiryDate() ).as(" usageAuth.getPackage().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().isReserveOnly() ).as(" usageAuth.getPackage().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMinSubPeriod() ).as(" usageAuth.getPackage().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPenaltyCharges() ).as(" usageAuth.getPackage().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getCancellation() ).as(" usageAuth.getPackage().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getMonthEndSubscription() ).as(" usageAuth.getPackage().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoint().isHistoric() ).as(" usageAuth.getPackage().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getFixedRecurrence() ).as(" usageAuth.getPackage().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().isReceipting() ).as(" usageAuth.getPackage().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getReceiptingAttribute() ).as(" usageAuth.getPackage().getPricePoint().getReceiptingAttribute()" ).isNull();
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().getRecurrenceDay() ).as(" usageAuth.getPackage().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getName() ).as(" usageAuth.getPackage().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRate() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxCode() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().size()).as("usageAuth.getPackage().getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().size() >= 3);
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getValue() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getValue()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getStartDate().getTimezoneOffset() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(0).getStartDate().getTimezoneOffset()" ).isEqualTo(-60) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getValue() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getValue()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getStartDate().getTimezoneOffset() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(1).getStartDate().getTimezoneOffset()" ).isEqualTo(-60) ;


        // java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getValue() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getValue()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" usageAuth.getPackage().getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
// java.util.Date
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances().length ).as(" usageAuth.getPackage().getPricePoint().getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPackageIdentifier() ).as(" usageAuth.getPackage().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getServiceIdentifier() ).as(" usageAuth.getPackage().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getName() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getCode() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().isResource() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceField().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().isActive() ).as(" usageAuth.getPackage().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getStandardRate() ).as(" usageAuth.getPackage().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances().length ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
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
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPaymentType() ).as(" usageAuth.getPackage().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getEventDateTime() ).as(" usageAuth.getPackage().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoint().getEventUnits() ).as(" usageAuth.getPackage().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPromoCodes().length ).as(" usageAuth.getPackage().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoint().getBearerIds().length ).as(" usageAuth.getPackage().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoint().getPromoCode() ).as(" usageAuth.getPackage().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoint().getDuration() ).as(" usageAuth.getPackage().getPricePoint().getDuration()" ).isEqualTo(2) ;
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
        softly.assertThat(usageAuth.getPackage().getTaxCode() ).as(" usageAuth.getPackage().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().isDefault() ).as(" usageAuth.getPackage().isDefault()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getParentPackageId() ).as(" usageAuth.getPackage().getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getParentPackageId() ).as(" usageAuth.getPackage().getParentPackageId()" ).isEqualTo("");
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getStartDate().getTimezoneOffset() ).as(" usageAuth.getPackage().getStartDate().getTimezoneOffset()" ).isEqualTo(-60) ;
        softly.assertThat(usageAuth.getPackage().getRate() ).as(" usageAuth.getPackage().getRate()" ).isEqualTo(new Double(11.75)) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricingText1() ).as(" usageAuth.getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricingText1() ).as(" usageAuth.getPackage().getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricingText2() ).as(" usageAuth.getPackage().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricingText2() ).as(" usageAuth.getPackage().getPricingText2()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().isReserveOnly() ).as(" usageAuth.getPackage().isReserveOnly()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().isOriginal() ).as(" usageAuth.getPackage().isOriginal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricingModel() ).as(" usageAuth.getPackage().getPricingModel()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getServices().size()).as("usageAuth.getPackage().getServices().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getServices().size() >= 0);
        softly.assertThat(usageAuth.getPackage().isActive() ).as(" usageAuth.getPackage().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getUrl() ).as(" usageAuth.getPackage().getUrl()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getResource().getName() ).as(" usageAuth.getResource().getName()" ).isNull();
        softly.assertThat(usageAuth.getResource().getCode() ).as(" usageAuth.getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getResource().getDescription() ).as(" usageAuth.getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getResource().isToken() ).as(" usageAuth.getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isUsageToken() ).as(" usageAuth.getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isPayToken() ).as(" usageAuth.getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().getResourceSymbol() ).as(" usageAuth.getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getResource().isCurrency() ).as(" usageAuth.getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getResource().isResource() ).as(" usageAuth.getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getResource().getCountryId() ).as(" usageAuth.getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getResource().getResourceName() ).as(" usageAuth.getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getErrorId() ).as(" usageAuth.getErrorId()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getErrorId() ).as(" usageAuth.getErrorId()" ).isEqualTo("");
        softly.assertThat(usageAuth.getErrorDescription() ).as(" usageAuth.getErrorDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getErrorDescription() ).as(" usageAuth.getErrorDescription()" ).isEqualTo("");
// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//check size of array!
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices().length ).as(" usageAuth.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getId() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getStatus() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//check size of array!
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices().length ).as(" usageAuth.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getId() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getStatus() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" usageAuth.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
// com.vizzavi.ecommerce.business.catalog.internal.CatalogPackageImpl
        softly.assertThat(usageAuth.getSubscription().getPackage().getName() ).as(" usageAuth.getSubscription().getPackage().getName()" ).isEqualTo("2 Usage Alternative Payment Pkg");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().getName() ).as(" usageAuth.getSubscription().getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().getCode() ).as(" usageAuth.getSubscription().getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().getDescription() ).as(" usageAuth.getSubscription().getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().isToken() ).as(" usageAuth.getSubscription().getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().isUsageToken() ).as(" usageAuth.getSubscription().getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().isPayToken() ).as(" usageAuth.getSubscription().getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().getResourceSymbol() ).as(" usageAuth.getSubscription().getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().isCurrency() ).as(" usageAuth.getSubscription().getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().isResource() ).as(" usageAuth.getSubscription().getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().getCountryId() ).as(" usageAuth.getSubscription().getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getResource().getResourceName() ).as(" usageAuth.getSubscription().getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getSubscription().getPackage().getKey() ).as(" usageAuth.getSubscription().getPackage().getKey()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPriority() ).as(" usageAuth.getSubscription().getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getId() ).as(" usageAuth.getSubscription().getPackage().getId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageAuth.getSubscription().getPackage().isGoodwillCredit() ).as(" usageAuth.getSubscription().getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getPriceModels() ).as(" usageAuth.getSubscription().getPackage().getPriceModels()" ).isNull();
        softly.assertThat(usageAuth.getSubscription().getPackage().getFullPackagePricepointId() ).as(" usageAuth.getSubscription().getPackage().getFullPackagePricepointId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// java.lang.Character
        softly.assertThat(usageAuth.getSubscription().getPackage().getSimplePackageId() ).as(" usageAuth.getSubscription().getPackage().getSimplePackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageAuth.getSubscription().getPackage().getNotificationCategory() ).as(" usageAuth.getSubscription().getPackage().getNotificationCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getNotificationCategory() ).as(" usageAuth.getSubscription().getPackage().getNotificationCategory()" ).isEqualTo("");
// com.vizzavi.ecommerce.business.catalog.PaymentContent
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getKey() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getDescription() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getCategory()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getCategory() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getCategory()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getMerchant() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getMerchant()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getMerchantDescription() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getMerchantDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getItemVolume() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getItemVolume()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getServiceType() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getServiceType()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getPaymentContent().getPromotion() ).as(" usageAuth.getSubscription().getPackage().getPaymentContent().getPromotion()" ).isEqualTo("");
//check size of array!
        softly.assertThat(usageAuth.getSubscription().getPackage().getServiceArray().length ).as(" usageAuth.getSubscription().getPackage().getServiceArray().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(usageAuth.getSubscription().getPackage().isEventPackage() ).as(" usageAuth.getSubscription().getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().isRecurringPackage() ).as(" usageAuth.getSubscription().getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().getPackageType() ).as(" usageAuth.getSubscription().getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(usageAuth.getSubscription().getPackage().getNonRefundableDescription() ).as(" usageAuth.getSubscription().getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getSubscription().getPackage().getNonRefundableDescription() ).as(" usageAuth.getSubscription().getPackage().getNonRefundableDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getSubscription().getPackage().isRefundable() ).as(" usageAuth.getSubscription().getPackage().isRefundable()" ).isFalse() ;
        softly.assertThat(usageAuth.getSubscription().getPackage().isCalendarPackage() ).as(" usageAuth.getSubscription().getPackage().isCalendarPackage()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getSubscription().getPackage().getPricePoints().size()).as("usageAuth.getSubscription().getPackage().getPricePoints().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert

    }

}
