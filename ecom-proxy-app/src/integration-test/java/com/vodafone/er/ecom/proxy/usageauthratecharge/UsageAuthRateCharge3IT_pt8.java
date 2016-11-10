package com.vodafone.er.ecom.proxy.usageauthratecharge;

import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 *
 * UsageAuthRateCharge with a UsageAuthorisation response
 * Split into parts since the test is so long!
 */
public class UsageAuthRateCharge3IT_pt8 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageAuthRateCharge3UsageAuthResponse() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        final String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";

        final PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());
        assertThat(auth).as("PurchaseAuth is null ").isNotNull();

        final ChargingApi chargingApi = EcomApiFactory.getChargingApi(Locale.UK);
        UsageAuthorization usageAuth = chargingApi.usageAuthRateCharge(CLIENT_ID.value(), msisdn, "sAlt", new UsageAttributes());
        assertNotNull(usageAuth);
        assertTrue(usageAuth.isSuccess());


        softly.assertThat(usageAuth.isAlternativePaymentMethod() ).as(" usageAuth.isAlternativePaymentMethod()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.RatingAttributes
//        softly.assertThat(usageAuth.getMatchingAttributes().getChannel() ).as(" usageAuth.getMatchingAttributes().getChannel()" ).isEqualTo(998) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getMultiUsageMode() ).as(" usageAuth.getMatchingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getNetworkCodeMatchMethod() ).as(" usageAuth.getMatchingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isPreRatePriceGross() ).as(" usageAuth.getMatchingAttributes().isPreRatePriceGross()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getPreRate() ).as(" usageAuth.getMatchingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getPaymentInformation() ).as(" usageAuth.getMatchingAttributes().getPaymentInformation()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getContentName() ).as(" usageAuth.getMatchingAttributes().getContentName()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getAssetID() ).as(" usageAuth.getMatchingAttributes().getAssetID()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPremiumLevel() ).as(" usageAuth.getMatchingAttributes().getPremiumLevel()" ).isEqualTo(998) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getReserveOnlyFlag() ).as(" usageAuth.getMatchingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getSupplierId() ).as(" usageAuth.getMatchingAttributes().getSupplierId()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getMatchingAttributes().getSupplierId() ).as(" usageAuth.getMatchingAttributes().getSupplierId()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getMatchingAttributes().getDeviceType() ).as(" usageAuth.getMatchingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
//        softly.assertThat(usageAuth.getMatchingAttributes().getUserGroups().length ).as(" usageAuth.getMatchingAttributes().getUserGroups().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getUserGroup() ).as(" usageAuth.getMatchingAttributes().getUserGroup()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getMatchingAttributes().getUserGroup() ).as(" usageAuth.getMatchingAttributes().getUserGroup()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getMatchingAttributes().getPaymentType() ).as(" usageAuth.getMatchingAttributes().getPaymentType()" ).isEqualTo(999) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getEventDateTime() ).as(" usageAuth.getMatchingAttributes().getEventDateTime()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getEventUnits() ).as(" usageAuth.getMatchingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
//        softly.assertThat(usageAuth.getMatchingAttributes().getPromoCodes().length ).as(" usageAuth.getMatchingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
//        softly.assertThat(usageAuth.getMatchingAttributes().getBearerIds().length ).as(" usageAuth.getMatchingAttributes().getBearerIds().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getPromoCode() ).as(" usageAuth.getMatchingAttributes().getPromoCode()" ).isNullOrEmpty();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPromoCode() ).as(" usageAuth.getMatchingAttributes().getPromoCode()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getMatchingAttributes().getDuration() ).as(" usageAuth.getMatchingAttributes().getDuration()" ).isEqualTo(999) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getChargingMethod() ).as(" usageAuth.getMatchingAttributes().getChargingMethod()" ).isEqualTo(999) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getBearer() ).as(" usageAuth.getMatchingAttributes().getBearer()" ).isEqualTo("*");
//        softly.assertThat(usageAuth.getMatchingAttributes().isInteractive() ).as(" usageAuth.getMatchingAttributes().isInteractive()" ).isTrue() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isIncludeUnavailable() ).as(" usageAuth.getMatchingAttributes().isIncludeUnavailable()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getExpressFlag() ).as(" usageAuth.getMatchingAttributes().getExpressFlag()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isExpressFlag() ).as(" usageAuth.getMatchingAttributes().isExpressFlag()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isPreOrder() ).as(" usageAuth.getMatchingAttributes().isPreOrder()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isCancellationUsage() ).as(" usageAuth.getMatchingAttributes().isCancellationUsage()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getTierName() ).as(" usageAuth.getMatchingAttributes().getTierName()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPromoPrecode() ).as(" usageAuth.getMatchingAttributes().getPromoPrecode()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getUniquePromoCode() ).as(" usageAuth.getMatchingAttributes().getUniquePromoCode()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPromoUniqueCode() ).as(" usageAuth.getMatchingAttributes().getPromoUniqueCode()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getNextCycleDiscount() ).as(" usageAuth.getMatchingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getHasHistoricPricePointFlag() ).as(" usageAuth.getMatchingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isIsForRenewal() ).as(" usageAuth.getMatchingAttributes().isIsForRenewal()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getTaxRate() ).as(" usageAuth.getMatchingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getTaxRateAsDouble() ).as(" usageAuth.getMatchingAttributes().getTaxRateAsDouble()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getAffiliateID() ).as(" usageAuth.getMatchingAttributes().getAffiliateID()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPartnerId() ).as(" usageAuth.getMatchingAttributes().getPartnerId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getTariff() ).as(" usageAuth.getMatchingAttributes().getTariff()" ).isEqualTo("*");
//        softly.assertThat(usageAuth.getMatchingAttributes().getAggregatorId() ).as(" usageAuth.getMatchingAttributes().getAggregatorId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().isForcePurchaseFlow() ).as(" usageAuth.getMatchingAttributes().isForcePurchaseFlow()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getReceipientMsisdn() ).as(" usageAuth.getMatchingAttributes().getReceipientMsisdn()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getProductCode() ).as(" usageAuth.getMatchingAttributes().getProductCode()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getMerchantName() ).as(" usageAuth.getMatchingAttributes().getMerchantName()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getInvoiceText() ).as(" usageAuth.getMatchingAttributes().getInvoiceText()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().isReIssueEnabled() ).as(" usageAuth.getMatchingAttributes().isReIssueEnabled()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isReIssueFlagPresent() ).as(" usageAuth.getMatchingAttributes().isReIssueFlagPresent()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getShortPackageId() ).as(" usageAuth.getMatchingAttributes().getShortPackageId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getTaxCode() ).as(" usageAuth.getMatchingAttributes().getTaxCode()" ).isEqualTo("*");
//        softly.assertThat(usageAuth.getMatchingAttributes().getHistoryStartDate() ).as(" usageAuth.getMatchingAttributes().getHistoryStartDate()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getVendorId() ).as(" usageAuth.getMatchingAttributes().getVendorId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().isIsForNextPaymentAmount() ).as(" usageAuth.getMatchingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getRenewalPreRate() ).as(" usageAuth.getMatchingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isOverrideDisallowPreRateFlag() ).as(" usageAuth.getMatchingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getContentCategory() ).as(" usageAuth.getMatchingAttributes().getContentCategory()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPartnerUrl() ).as(" usageAuth.getMatchingAttributes().getPartnerUrl()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPartnerContactInfo() ).as(" usageAuth.getMatchingAttributes().getPartnerContactInfo()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPartnerEmail() ).as(" usageAuth.getMatchingAttributes().getPartnerEmail()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPartnerName() ).as(" usageAuth.getMatchingAttributes().getPartnerName()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getLinkedByTrialPricepoint() ).as(" usageAuth.getMatchingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getSubRenewalPricepointId() ).as(" usageAuth.getMatchingAttributes().getSubRenewalPricepointId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getLinkPricepointId() ).as(" usageAuth.getMatchingAttributes().getLinkPricepointId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getSubPurchaseTransactionTrial() ).as(" usageAuth.getMatchingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getMatchingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(usageAuth.getMatchingAttributes().getExtIdentifier1() ).as(" usageAuth.getMatchingAttributes().getExtIdentifier1()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getExtIdentifier2() ).as(" usageAuth.getMatchingAttributes().getExtIdentifier2()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getExtIdentifier3() ).as(" usageAuth.getMatchingAttributes().getExtIdentifier3()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getAccessChannel() ).as(" usageAuth.getMatchingAttributes().getAccessChannel()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getPurchaseChannel() ).as(" usageAuth.getMatchingAttributes().getPurchaseChannel()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getDeviceID() ).as(" usageAuth.getMatchingAttributes().getDeviceID()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getLocal() ).as(" usageAuth.getMatchingAttributes().getLocal()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getMsisdn() ).as(" usageAuth.getMatchingAttributes().getMsisdn()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getLanguageLocale() ).as(" usageAuth.getMatchingAttributes().getLanguageLocale()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getLanguageCode() ).as(" usageAuth.getMatchingAttributes().getLanguageCode()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getExternalField1() ).as(" usageAuth.getMatchingAttributes().getExternalField1()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getExternalField2() ).as(" usageAuth.getMatchingAttributes().getExternalField2()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getExternalTransId() ).as(" usageAuth.getMatchingAttributes().getExternalTransId()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getActiveSubscriptions() ).as(" usageAuth.getMatchingAttributes().getActiveSubscriptions()" ).isNull();
//        softly.assertThat(usageAuth.getMatchingAttributes().getCsrId() ).as(" usageAuth.getMatchingAttributes().getCsrId()" ).isNull();
        softly.assertThat(usageAuth.getInputAttributes() ).as(" usageAuth.getInputAttributes()" ).isNull();
        softly.assertThat(usageAuth.getDiscountPercentage() ).as(" usageAuth.getDiscountPercentage()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackageId() ).as(" usageAuth.getPackageId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getContentId() ).as(" usageAuth.getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPricingText1() ).as(" usageAuth.getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricingText1() ).as(" usageAuth.getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPricingText2() ).as(" usageAuth.getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPricingText2() ).as(" usageAuth.getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getAlternativeCurrencyId() ).as(" usageAuth.getAlternativeCurrencyId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getAlternativeNetRate() ).as(" usageAuth.getAlternativeNetRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getRateIdentifier() ).as(" usageAuth.getRateIdentifier()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_999_999");
//check size of array!
//        softly.assertThat(usageAuth.getRateIdentifiers().length ).as(" usageAuth.getRateIdentifiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getUsageTime() ).as(" usageAuth.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getAccessDuration() ).as(" usageAuth.getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPricePointId() ).as(" usageAuth.getPricePointId()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_999_999");
        softly.assertThat(usageAuth.isUniquePromoCode() ).as(" usageAuth.isUniquePromoCode()" ).isFalse() ;
        softly.assertThat(usageAuth.isZeroCostIgnore() ).as(" usageAuth.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageAuth.getCustomResourceBalances() ).as(" usageAuth.getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getNetStandardRate() ).as(" usageAuth.getNetStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getUndiscountedStandardRate() ).as(" usageAuth.getUndiscountedStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getTimestamp() ).as(" usageAuth.getTimestamp()" ).isNull();

        softly.assertThat(usageAuth.getEventUnits() ).as(" usageAuth.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
// java.util.Date
        softly.assertThat(usageAuth.getIsValidatedAccount() ).as(" usageAuth.getIsValidatedAccount()" ).isNull();
        softly.assertThat(usageAuth.getIsPreordered() ).as(" usageAuth.getIsPreordered()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.isFirstUsage() ).as(" usageAuth.isFirstUsage()" ).isTrue() ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getName() ).as(" usageAuth.getServicePricePoint().getResource().getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getCode() ).as(" usageAuth.getServicePricePoint().getResource().getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getResource().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isToken() ).as(" usageAuth.getServicePricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().isResource() ).as(" usageAuth.getServicePricePoint().getResource().isResource()" ).isTrue() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getKey() ).as(" usageAuth.getServicePricePoint().getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getId() ).as(" usageAuth.getServicePricePoint().getId()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_999_999");
        softly.assertThat(usageAuth.getServicePricePoint().getDescription() ).as(" usageAuth.getServicePricePoint().getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(usageAuth.getServicePricePoint().isPreOrder() ).as(" usageAuth.getServicePricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxRate() ).as(" usageAuth.getServicePricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getTaxCode() ).as(" usageAuth.getServicePricePoint().getTaxCode()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getLinkedByTrialPricepoint() ).as(" usageAuth.getServicePricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getStartDate() ).as(" usageAuth.getServicePricePoint().getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getRate() ).as(" usageAuth.getServicePricePoint().getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getExpiryDate() ).as(" usageAuth.getServicePricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getNetRate() ).as(" usageAuth.getServicePricePoint().getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isAlwaysValidateMsisdn() ).as(" usageAuth.getServicePricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isDiscount() ).as(" usageAuth.getServicePricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getDiscountPromoText() ).as(" usageAuth.getServicePricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getDiscountPromoText() ).as(" usageAuth.getServicePricePoint().getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getServicePricePoint().getPackageId() ).as(" usageAuth.getServicePricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageAuth.getServicePricePoint().getContentId() ).as(" usageAuth.getServicePricePoint().getContentId()" ).isEqualTo("sAlt");
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
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getServicePricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricingModelTier() ).as(" usageAuth.getServicePricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isArchived() ).as(" usageAuth.getServicePricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isBasePricePoint() ).as(" usageAuth.getServicePricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAccessDevice() ).as(" usageAuth.getServicePricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAlternativeRate() ).as(" usageAuth.getServicePricePoint().getAlternativeRate()" ).isEqualTo(new Double(1.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts().length ).as(" usageAuth.getServicePricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getName() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCode() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].isResource() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getServicePricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100035");
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().size()).as("usageAuth.getServicePricePoint().getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getId() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getType() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().isTrial() ).as(" usageAuth.getServicePricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getGlid() ).as(" usageAuth.getServicePricePoint().getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getServicePricePoint().getGlid() ).as(" usageAuth.getServicePricePoint().getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getServicePricePoint().getPricepointIdLink() ).as(" usageAuth.getServicePricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isPreview() ).as(" usageAuth.getServicePricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getInteractiveFlag() ).as(" usageAuth.getServicePricePoint().getInteractiveFlag()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().isForcedPurchase() ).as(" usageAuth.getServicePricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().isSubscriptionDuplicate() ).as(" usageAuth.getServicePricePoint().isSubscriptionDuplicate()" ).isFalse() ;
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
        softly.assertThat(usageAuth.getServicePricePoint().getReceiptingAttribute() ).as(" usageAuth.getServicePricePoint().getReceiptingAttribute()" ).isNull();
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
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRate() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxCode() ).as(" usageAuth.getServicePricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of list!
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().size()).as("usageAuth.getServicePricePoint().getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getServicePricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).value() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getBalances().length ).as(" usageAuth.getServicePricePoint().getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getName() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getCode() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isToken() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().isResource() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getSubscription() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getBalance() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getPackageId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getBalances()[0].getThreshold() ).as(" usageAuth.getServicePricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().isRecurring() ).as(" usageAuth.getServicePricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getServicePricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
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
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPackageIdentifier() ).as(" usageAuth.getServicePricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_null_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getServicePricePoint().getServiceIdentifier() ).as(" usageAuth.getServicePricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_null_sAlt_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getName() ).as(" usageAuth.getServicePricePoint().getResourceField().getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getCode() ).as(" usageAuth.getServicePricePoint().getResourceField().getCode()" ).isEqualTo(1100035) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getDescription() ).as(" usageAuth.getServicePricePoint().getResourceField().getDescription()" ).isNull();
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isToken() ).as(" usageAuth.getServicePricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isUsageToken() ).as(" usageAuth.getServicePricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isPayToken() ).as(" usageAuth.getServicePricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isCurrency() ).as(" usageAuth.getServicePricePoint().getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().isResource() ).as(" usageAuth.getServicePricePoint().getResourceField().isResource()" ).isTrue() ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getCountryId() ).as(" usageAuth.getServicePricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(usageAuth.getServicePricePoint().getResourceField().getResourceName() ).as(" usageAuth.getServicePricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100035");
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
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getServicePricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
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
        softly.assertThat(usageAuth.getServicePricePoint().isActive() ).as(" usageAuth.getServicePricePoint().isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getStandardRate() ).as(" usageAuth.getServicePricePoint().getStandardRate()" ).isEqualTo(new Double(1.18)) ;
//check size of array!
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances().length ).as(" usageAuth.getServicePricePoint().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscription() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getBalance() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getPackageId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getServicePricePoint().getResourceBalances()[0].getThreshold() ).as(" usageAuth.getServicePricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
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
        softly.assertThat(usageAuth.isAuthorized() ).as(" usageAuth.isAuthorized()" ).isTrue() ;
// com.vizzavi.ecommerce.business.catalog.internal.CatalogPackageImpl
        softly.assertThat(usageAuth.getPackage().getName() ).as(" usageAuth.getPackage().getName()" ).isEqualTo("2 Usage Alternative Payment Pkg");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getResource().getName() ).as(" usageAuth.getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getResource().getCode() ).as(" usageAuth.getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getResource().getDescription() ).as(" usageAuth.getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getResource().isToken() ).as(" usageAuth.getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().isUsageToken() ).as(" usageAuth.getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().isPayToken() ).as(" usageAuth.getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getResource().isCurrency() ).as(" usageAuth.getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getResource().isResource() ).as(" usageAuth.getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getResource().getCountryId() ).as(" usageAuth.getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getResource().getResourceName() ).as(" usageAuth.getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getKey() ).as(" usageAuth.getPackage().getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPriority() ).as(" usageAuth.getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getId() ).as(" usageAuth.getPackage().getId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageAuth.getPackage().isGoodwillCredit() ).as(" usageAuth.getPackage().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPriceModels() ).as(" usageAuth.getPackage().getPriceModels()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getFullPackagePricepointId() ).as(" usageAuth.getPackage().getFullPackagePricepointId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
// java.lang.Character
        softly.assertThat(usageAuth.getPackage().getSimplePackageId() ).as(" usageAuth.getPackage().getSimplePackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageAuth.getPackage().getNotificationCategory() ).as(" usageAuth.getPackage().getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.PaymentContent
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getKey() ).as(" usageAuth.getPackage().getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getDescription() ).as(" usageAuth.getPackage().getPaymentContent().getDescription()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getCategory() ).as(" usageAuth.getPackage().getPaymentContent().getCategory()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getMerchant() ).as(" usageAuth.getPackage().getPaymentContent().getMerchant()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getMerchantDescription() ).as(" usageAuth.getPackage().getPaymentContent().getMerchantDescription()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getItemVolume() ).as(" usageAuth.getPackage().getPaymentContent().getItemVolume()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getServiceType() ).as(" usageAuth.getPackage().getPaymentContent().getServiceType()" ).isEqualTo("");
//        softly.assertThat(usageAuth.getPackage().getPaymentContent().getPromotion() ).as(" usageAuth.getPackage().getPaymentContent().getPromotion()" ).isEqualTo("");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getServiceArray().length ).as(" usageAuth.getPackage().getServiceArray().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().isEventPackage() ).as(" usageAuth.getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isRecurringPackage() ).as(" usageAuth.getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPackageType() ).as(" usageAuth.getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(usageAuth.getPackage().getNonRefundableDescription() ).as(" usageAuth.getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getNonRefundableDescription() ).as(" usageAuth.getPackage().getNonRefundableDescription()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().isRefundable() ).as(" usageAuth.getPackage().isRefundable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().isCalendarPackage() ).as(" usageAuth.getPackage().isCalendarPackage()" ).isTrue() ;
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().size()).as("usageAuth.getPackage().getPricePoints().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().size() >= 3);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getId()" ).isEqualTo("package:pAlt_TAX_2_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDescription()" ).isEqualTo("Non-recurring 7 day");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isPreOrder() ).as(" usageAuth.getPackage().getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getRate()" ).isEqualTo(new Double(11.75)) ;
// java.util.Date
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getNetRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(0).isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getContentId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getUsageTime() ).as(" usageAuth.getPackage().getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAccessDuration() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isZeroCostIgnore() ).as(" usageAuth.getPackage().getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getCustomResourceBalances() ).as(" usageAuth.getPackage().getPricePoints().get(0).getCustomResourceBalances()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingModelTier() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isArchived() ).as(" usageAuth.getPackage().getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isBasePricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAccessDevice() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAlternativeRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().size()).as("usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isTrial() ).as(" usageAuth.getPackage().getPricePoints().get(0).isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(0).getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricepointIdLink()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isPreview() ).as(" usageAuth.getPackage().getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getInteractiveFlag() ).as(" usageAuth.getPackage().getPricePoints().get(0).getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isForcedPurchase() ).as(" usageAuth.getPackage().getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getPricePoints().get(0).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getFixedExpiryDate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isReserveOnly() ).as(" usageAuth.getPackage().getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getMinSubPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPenaltyCharges() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getCancellation() ).as(" usageAuth.getPackage().getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getMonthEndSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isHistoric() ).as(" usageAuth.getPackage().getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getFixedRecurrence() ).as(" usageAuth.getPackage().getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isReceipting() ).as(" usageAuth.getPackage().getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getReceiptingAttribute() ).as(" usageAuth.getPackage().getPricePoints().get(0).getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getOrder() ).as(" usageAuth.getPackage().getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getNonMatchAllUserGroups().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isPromo() ).as(" usageAuth.getPackage().getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricingTextTemplateName2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTranslatedPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTranslatedPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getRecurrenceDay() ).as(" usageAuth.getPackage().getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isAlignWithExternal() ).as(" usageAuth.getPackage().getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getGracePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getRetryFrequency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getSuspensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPackage().getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTranslatedPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getFairUsageLimit() ).as(" usageAuth.getPackage().getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getFairUsagePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExtensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isTariff() ).as(" usageAuth.getPackage().getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTax().getKey()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of list!
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().size()).as("usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).value() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPricingModel() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getTier() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPackageIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_2_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getServiceIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceField().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getPricePoints().get(0).getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isVolumeType() ).as(" usageAuth.getPackage().getPricePoints().get(0).isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isOriginal() ).as(" usageAuth.getPackage().getPricePoints().get(0).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPricingModel() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getTier() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getProtectedFk() ).as(" usageAuth.getPackage().getPricePoints().get(0).getProtectedFk()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getmPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getmPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getmPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getmPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getmPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getmPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isNonRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(0).isNonRecurring()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isEvent() ).as(" usageAuth.getPackage().getPricePoints().get(0).isEvent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isActive() ).as(" usageAuth.getPackage().getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getStandardRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getChannel() ).as(" usageAuth.getPackage().getPricePoints().get(0).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getMultiUsageMode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getNetworkCodeMatchMethod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isPreRatePriceGross() ).as(" usageAuth.getPackage().getPricePoints().get(0).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPreRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPaymentInformation() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPaymentInformation()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getContentName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getContentName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAssetID() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAssetID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPremiumLevel() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getReserveOnlyFlag() ).as(" usageAuth.getPackage().getPricePoints().get(0).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getSupplierId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDeviceType() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getUserGroups().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getUserGroup() ).as(" usageAuth.getPackage().getPricePoints().get(0).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPaymentType() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getEventDateTime() ).as(" usageAuth.getPackage().getPricePoints().get(0).getEventDateTime()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getEventUnits() ).as(" usageAuth.getPackage().getPricePoints().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPromoCodes().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBearerIds().length ).as(" usageAuth.getPackage().getPricePoints().get(0).getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDuration() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDuration()" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getChargingMethod() ).as(" usageAuth.getPackage().getPricePoints().get(0).getChargingMethod()" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getBearer() ).as(" usageAuth.getPackage().getPricePoints().get(0).getBearer()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isInteractive() ).as(" usageAuth.getPackage().getPricePoints().get(0).isInteractive()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isIncludeUnavailable() ).as(" usageAuth.getPackage().getPricePoints().get(0).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExpressFlag() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isExpressFlag() ).as(" usageAuth.getPackage().getPricePoints().get(0).isExpressFlag()" ).isFalse() ;


        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isCancellationUsage() ).as(" usageAuth.getPackage().getPricePoints().get(0).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTierName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTierName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPromoPrecode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPromoPrecode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getUniquePromoCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getUniquePromoCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPromoUniqueCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getNextCycleDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getHasHistoricPricePointFlag() ).as(" usageAuth.getPackage().getPricePoints().get(0).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isIsForRenewal() ).as(" usageAuth.getPackage().getPricePoints().get(0).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTaxRateAsDouble() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAffiliateID() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAffiliateID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPartnerId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPartnerId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getTariff() ).as(" usageAuth.getPackage().getPricePoints().get(0).getTariff()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAggregatorId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAggregatorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isForcePurchaseFlow() ).as(" usageAuth.getPackage().getPricePoints().get(0).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getReceipientMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(0).getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getProductCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getProductCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getMerchantName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getMerchantName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getInvoiceText() ).as(" usageAuth.getPackage().getPricePoints().get(0).getInvoiceText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isReIssueEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(0).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isReIssueFlagPresent() ).as(" usageAuth.getPackage().getPricePoints().get(0).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getShortPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getShortPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getHistoryStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getHistoryStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getVendorId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getVendorId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isIsForNextPaymentAmount() ).as(" usageAuth.getPackage().getPricePoints().get(0).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getRenewalPreRate() ).as(" usageAuth.getPackage().getPricePoints().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isOverrideDisallowPreRateFlag() ).as(" usageAuth.getPackage().getPricePoints().get(0).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getContentCategory() ).as(" usageAuth.getPackage().getPricePoints().get(0).getContentCategory()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPartnerUrl() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPartnerUrl()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPartnerContactInfo() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPartnerEmail() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPartnerEmail()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPartnerName() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPartnerName()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getSubRenewalPricepointId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getLinkPricepointId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getLinkPricepointId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getSubPurchaseTransactionTrial() ).as(" usageAuth.getPackage().getPricePoints().get(0).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDiscardHiddenInactivePricepoints() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints() ).as(" usageAuth.getPackage().getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExtIdentifier1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExtIdentifier1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExtIdentifier2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExtIdentifier2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExtIdentifier3() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExtIdentifier3()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getAccessChannel() ).as(" usageAuth.getPackage().getPricePoints().get(0).getAccessChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getPurchaseChannel() ).as(" usageAuth.getPackage().getPricePoints().get(0).getPurchaseChannel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getDeviceID() ).as(" usageAuth.getPackage().getPricePoints().get(0).getDeviceID()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getLocal() ).as(" usageAuth.getPackage().getPricePoints().get(0).getLocal()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(0).getMsisdn()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getLanguageLocale() ).as(" usageAuth.getPackage().getPricePoints().get(0).getLanguageLocale()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getLanguageCode() ).as(" usageAuth.getPackage().getPricePoints().get(0).getLanguageCode()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExternalField1() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExternalField1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExternalField2() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExternalField2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getExternalTransId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getExternalTransId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getActiveSubscriptions() ).as(" usageAuth.getPackage().getPricePoints().get(0).getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(0).getCsrId() ).as(" usageAuth.getPackage().getPricePoints().get(0).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isPreOrder() ).as(" usageAuth.getPackage().getPricePoints().get(1).isPreOrder()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getLinkedByTrialPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExpiryDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getNetRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isAlwaysValidateMsisdn() ).as(" usageAuth.getPackage().getPricePoints().get(1).isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isDiscount() ).as(" usageAuth.getPackage().getPricePoints().get(1).isDiscount()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getDiscountPromoText() ).as(" usageAuth.getPackage().getPricePoints().get(1).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getContentId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getContentId()" ).isEqualTo("*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingText1()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingText2()" ).isEqualTo("");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getUsageTime() ).as(" usageAuth.getPackage().getPricePoints().get(1).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAccessDuration() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isZeroCostIgnore() ).as(" usageAuth.getPackage().getPricePoints().get(1).isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingModelTier() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingModelTier()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isArchived() ).as(" usageAuth.getPackage().getPricePoints().get(1).isArchived()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isBasePricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAccessDevice() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAlternativeRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().size()).as("usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isTrial() ).as(" usageAuth.getPackage().getPricePoints().get(1).isTrial()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(1).getGlid()" ).isNullOrEmpty();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getGlid() ).as(" usageAuth.getPackage().getPricePoints().get(1).getGlid()" ).isEqualTo("");
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricepointIdLink() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricepointIdLink()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isPreview() ).as(" usageAuth.getPackage().getPricePoints().get(1).isPreview()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getInteractiveFlag() ).as(" usageAuth.getPackage().getPricePoints().get(1).getInteractiveFlag()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isForcedPurchase() ).as(" usageAuth.getPackage().getPricePoints().get(1).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isSubscriptionDuplicate() ).as(" usageAuth.getPackage().getPricePoints().get(1).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getFixedExpiryDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getFixedExpiryDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isReserveOnly() ).as(" usageAuth.getPackage().getPricePoints().get(1).isReserveOnly()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getMinSubPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPenaltyCharges() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getCancellation() ).as(" usageAuth.getPackage().getPricePoints().get(1).getCancellation()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getMonthEndSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isHistoric() ).as(" usageAuth.getPackage().getPricePoints().get(1).isHistoric()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getFixedRecurrence() ).as(" usageAuth.getPackage().getPricePoints().get(1).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isFixedRecurringPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isReceipting() ).as(" usageAuth.getPackage().getPricePoints().get(1).isReceipting()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getReceiptingAttribute() ).as(" usageAuth.getPackage().getPricePoints().get(1).getReceiptingAttribute()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getOrder() ).as(" usageAuth.getPackage().getPricePoints().get(1).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getNonMatchAllUserGroups().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isPromo() ).as(" usageAuth.getPackage().getPricePoints().get(1).isPromo()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isSubmitToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(1).isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isSuppressToPaymentHandler() ).as(" usageAuth.getPackage().getPricePoints().get(1).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingTextTemplateName1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricingTextTemplateName2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTranslatedPricingText1() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTranslatedPricingText2() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getRecurrenceDay() ).as(" usageAuth.getPackage().getPricePoints().get(1).getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isAlignWithExternal() ).as(" usageAuth.getPackage().getPricePoints().get(1).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getGracePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getGracePeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getRetryFrequency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getRetryFrequency()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getSuspensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getSuspensionPeriod()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined() ).as(" usageAuth.getPackage().getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTranslatedPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTranslatedPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getFairUsageLimit() ).as(" usageAuth.getPackage().getPricePoints().get(1).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getFairUsagePeriod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getFairUsagePeriodUnit() ).as(" usageAuth.getPackage().getPricePoints().get(1).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getExtensionPeriod() ).as(" usageAuth.getPackage().getPricePoints().get(1).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isIncludeServiceForPackageFUP() ).as(" usageAuth.getPackage().getPricePoints().get(1).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isFairUsagePolicyEnabled() ).as(" usageAuth.getPackage().getPricePoints().get(1).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isTariff() ).as(" usageAuth.getPackage().getPricePoints().get(1).isTariff()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isHideForPurchaseOptions() ).as(" usageAuth.getPackage().getPricePoints().get(1).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTax().getKey()" ).isNull();
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxCode()" ).isEqualTo("TAX");
//check size of list!
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().size()).as("usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().size()").isEqualTo(3);
//if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().size() >= 3);
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().get(0).value() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
// java.util.Date
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getSubscription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getBalance() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getBalance()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getPackageId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getSubscriptionIdLong() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getOldestSubscriptionId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isRecurring() ).as(" usageAuth.getPackage().getPricePoints().get(1).isRecurring()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getRenewalsUntilLinkedPricepoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPrice() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingText() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPricingModel() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getTier() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().isDefaultPPT() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingTextList() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-2.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPackageIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getServiceIdentifier() ).as(" usageAuth.getPackage().getPricePoints().get(1).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getResourceField().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getStandardRateWithoutTax() ).as(" usageAuth.getPackage().getPricePoints().get(1).getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isVolumeType() ).as(" usageAuth.getPackage().getPricePoints().get(1).isVolumeType()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).isOriginal() ).as(" usageAuth.getPackage().getPricePoints().get(1).isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers().length ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()).as("usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Content Credit");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" usageAuth.getPackage().getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100035");





    }

}
