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

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 *
 * UsageAuthRateCharge with a UsageAuthorisation response
 * Split into parts since the test is so long!
 */
public class UsageAuthRate2IT_pt7 {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageAuthRateCharge3UsageAuthResponse() throws Exception {
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

        //check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPackage().getServices().get(0).getPricingModels().length ).as(" auth.getActiveSubscriptions().get(0).getPackage().getServices().get(0).getPricingModels().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPackage().getServices().get(0).getSalesModel() ).as(" auth.getActiveSubscriptions().get(0).getPackage().getServices().get(0).getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPackage().getServices().get(0).getServiceType() ).as(" auth.getActiveSubscriptions().get(0).getPackage().getServices().get(0).getServiceType()" ).isEqualTo("service");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getCountry() ).as(" auth.getActiveSubscriptions().get(0).getCountry()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isArchived() ).as(" auth.getActiveSubscriptions().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getExtensionPeriod() ).as(" auth.getActiveSubscriptions().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isRecurring() ).as(" auth.getActiveSubscriptions().get(0).isRecurring()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getSubscriptionId()" ).isEqualTo("1126");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getSubscriptionIdLong() ).as(" auth.getActiveSubscriptions().get(0).getSubscriptionIdLong()" ).isEqualTo(new Long(1126)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getAccount() ).as(" auth.getActiveSubscriptions().get(0).getAccount()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRenewalDate() ).as(" auth.getActiveSubscriptions().get(0).getRenewalDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isInactiveOrClosed() ).as(" auth.getActiveSubscriptions().get(0).isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isFailed() ).as(" auth.getActiveSubscriptions().get(0).isFailed()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isBeingProvisioned() ).as(" auth.getActiveSubscriptions().get(0).isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isReserved() ).as(" auth.getActiveSubscriptions().get(0).isReserved()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLinkedPtID() ).as(" auth.getActiveSubscriptions().get(0).getLinkedPtID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isPreOrdered() ).as(" auth.getActiveSubscriptions().get(0).isPreOrdered()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getContentPaymentType() ).as(" auth.getActiveSubscriptions().get(0).getContentPaymentType()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPurchaseDeviceType() ).as(" auth.getActiveSubscriptions().get(0).getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getNextCyclePercentDiscount() ).as(" auth.getActiveSubscriptions().get(0).getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getNextPaymentAmount() ).as(" auth.getActiveSubscriptions().get(0).getNextPaymentAmount()" ).isEqualTo(new Double(7.0)) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getServiceIds().length ).as(" auth.getActiveSubscriptions().get(0).getServiceIds().length" ).isEqualTo(1) ;
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().size()).as("auth.getActiveSubscriptions().get(0).getResourceBalancesList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getResourceBalancesList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getName()" ).isEqualTo("Alerts");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getDescription()" ).isEqualTo("Alerts");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getSubscriptionId()" ).isEqualTo("1126");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getSubscriptionIdLong() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getSubscriptionIdLong()" ).isEqualTo(new Long(1126)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getOldestSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getThreshold() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getSubscription() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getSubscription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getBalance() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalancesList().get(0).getPackageId()" ).isNull();
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getChannel() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getMultiUsageMode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getNetworkCodeMatchMethod() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isPreRatePriceGross() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPreRate() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPaymentInformation() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getContentName() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getContentName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getAssetID() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getAssetID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPremiumLevel() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPremiumLevel()" ).isEqualTo(998) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getReserveOnlyFlag() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getSupplierId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getSupplierId()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getDeviceType() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getUserGroups().length ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getUserGroup() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPaymentType() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getEventDateTime() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getEventDateTime()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getEventUnits() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoCodes().length ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getBearerIds().length ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoCode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getDuration() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getDuration()" ).isEqualTo(4) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getChargingMethod() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getBearer() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isInteractive() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isIncludeUnavailable() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExpressFlag() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isExpressFlag() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isPreOrder() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isCancellationUsage() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getTierName() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getTierName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoPrecode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getUniquePromoCode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoUniqueCode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getNextCycleDiscount() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getHasHistoricPricePointFlag() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isIsForRenewal() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getTaxRate() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getTaxRateAsDouble() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getAffiliateID() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getTariff() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getAggregatorId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isForcePurchaseFlow() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getReceipientMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getProductCode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getProductCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getMerchantName() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getInvoiceText() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isReIssueEnabled() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isReIssueFlagPresent() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getShortPackageId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getTaxCode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getHistoryStartDate() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getVendorId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getVendorId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isIsForNextPaymentAmount() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getRenewalPreRate() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isOverrideDisallowPreRateFlag() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getContentCategory() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerUrl() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerContactInfo() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerEmail() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerName() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getLinkedByTrialPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getSubRenewalPricepointId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getLinkPricepointId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getSubPurchaseTransactionTrial() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getDiscardHiddenInactivePricepoints() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExtIdentifier1() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExtIdentifier2() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExtIdentifier3() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getAccessChannel() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getPurchaseChannel() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getDeviceID() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getLocal() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getLocal()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getLanguageLocale() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getLanguageCode() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExternalField1() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExternalField2() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getExternalTransId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getActiveSubscriptions() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRatingAttributes().getCsrId() ).as(" auth.getActiveSubscriptions().get(0).getRatingAttributes().getCsrId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPaymentTransactionId() ).as(" auth.getActiveSubscriptions().get(0).getPaymentTransactionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getNonRefundDescription() ).as(" auth.getActiveSubscriptions().get(0).getNonRefundDescription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getInteractiveUsageFlag() ).as(" auth.getActiveSubscriptions().get(0).getInteractiveUsageFlag()" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isFirstUsage() ).as(" auth.getActiveSubscriptions().get(0).isFirstUsage()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isSubscriptionUsed() ).as(" auth.getActiveSubscriptions().get(0).isSubscriptionUsed()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getCurrentNoOfOccurences() ).as(" auth.getActiveSubscriptions().get(0).getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPenaltyCharge() ).as(" auth.getActiveSubscriptions().get(0).getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isMinSubscriptionPeriodElapsed() ).as(" auth.getActiveSubscriptions().get(0).isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isUnderGracePeriod() ).as(" auth.getActiveSubscriptions().get(0).isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getBatchRetryDate() ).as(" auth.getActiveSubscriptions().get(0).getBatchRetryDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getOverdueExpiryDate() ).as(" auth.getActiveSubscriptions().get(0).getOverdueExpiryDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLastExpiryDate() ).as(" auth.getActiveSubscriptions().get(0).getLastExpiryDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isWasRecurringTrial() ).as(" auth.getActiveSubscriptions().get(0).isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getParentPackageID() ).as(" auth.getActiveSubscriptions().get(0).getParentPackageID()" ).isNull();
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getTransactions().size()).as("auth.getActiveSubscriptions().get(0).getTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getTransactions().size() >= 0);
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRefundTransactions().size()).as("auth.getActiveSubscriptions().get(0).getRefundTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getRefundTransactions().size() >= 0);
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPreviousStatus() ).as(" auth.getActiveSubscriptions().get(0).getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isParentAlsoPurchased() ).as(" auth.getActiveSubscriptions().get(0).isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isProvisionOnUsageSuccess() ).as(" auth.getActiveSubscriptions().get(0).isProvisionOnUsageSuccess()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMLocalEndDate() ).as(" auth.getActiveSubscriptions().get(0).getMLocalEndDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMLocalStartDate() ).as(" auth.getActiveSubscriptions().get(0).getMLocalStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMLocalEndDateCal() ).as(" auth.getActiveSubscriptions().get(0).getMLocalEndDateCal()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMLocalStartDateCal() ).as(" auth.getActiveSubscriptions().get(0).getMLocalStartDateCal()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLastUsageTransactionIdForSameContent() ).as(" auth.getActiveSubscriptions().get(0).getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getSpId() ).as(" auth.getActiveSubscriptions().get(0).getSpId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPartnerTaxRate() ).as(" auth.getActiveSubscriptions().get(0).getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getCountryId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isWasRecurringPromoCode() ).as(" auth.getActiveSubscriptions().get(0).isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLastPaymentTransaction() ).as(" auth.getActiveSubscriptions().get(0).getLastPaymentTransaction()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getB2BPartner() ).as(" auth.getActiveSubscriptions().get(0).getB2BPartner()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRenewalCounterToLinkedPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isRenewalPreRateGross() ).as(" auth.getActiveSubscriptions().get(0).isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getNextPricePointId() ).as(" auth.getActiveSubscriptions().get(0).getNextPricePointId()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLastPaymentTransactionAmount() ).as(" auth.getActiveSubscriptions().get(0).getLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLastToLastPaymentTransactionAmount() ).as(" auth.getActiveSubscriptions().get(0).getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isPricePointChangeOnRenewal() ).as(" auth.getActiveSubscriptions().get(0).isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getOldSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getOldMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getOldMsisdn()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isProvisionable() ).as(" auth.getActiveSubscriptions().get(0).isProvisionable()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getFuturePricePointRenewals() ).as(" auth.getActiveSubscriptions().get(0).getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPurcServiceList() ).as(" auth.getActiveSubscriptions().get(0).getPurcServiceList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPaymentTransactions().size()).as("auth.getActiveSubscriptions().get(0).getPaymentTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getPaymentTransactions().size() >= 0);
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getModifyTransactions().size()).as("auth.getActiveSubscriptions().get(0).getModifyTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getModifyTransactions().size() >= 0);
        softly.assertThat(auth.getActiveSubscriptions().get(0).getNextCyclePercentValue() ).as(" auth.getActiveSubscriptions().get(0).getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getLockId() ).as(" auth.getActiveSubscriptions().get(0).getLockId()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isDefault() ).as(" auth.getActiveSubscriptions().get(0).isDefault()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPaymentType() ).as(" auth.getActiveSubscriptions().get(0).getPaymentType()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPartnerId() ).as(" auth.getActiveSubscriptions().get(0).getPartnerId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMerchantName() ).as(" auth.getActiveSubscriptions().get(0).getMerchantName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getRenewalPreRate() ).as(" auth.getActiveSubscriptions().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getExtIdentifier1() ).as(" auth.getActiveSubscriptions().get(0).getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getExtIdentifier2() ).as(" auth.getActiveSubscriptions().get(0).getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getExtIdentifier3() ).as(" auth.getActiveSubscriptions().get(0).getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getMsisdn()" ).isEqualTo("-465397633");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getCsrId() ).as(" auth.getActiveSubscriptions().get(0).getCsrId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isPromotional() ).as(" auth.getActiveSubscriptions().get(0).isPromotional()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPromotionalExpiryDate() ).as(" auth.getActiveSubscriptions().get(0).getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getStatus() ).as(" auth.getActiveSubscriptions().get(0).getStatus()" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getExternalSubId() ).as(" auth.getActiveSubscriptions().get(0).getExternalSubId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getOptions() ).as(" auth.getActiveSubscriptions().get(0).getOptions()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getId()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricingModelTier() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isArchived() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isBasePricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAccessDevice() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAlternativeRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(8.225)) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts().length" ).isEqualTo(2) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().size()).as("auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalanceImpactList().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isTrial() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getGlid() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricepointIdLink() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isPreview() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getInteractiveFlag() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isForcedPurchase() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isSubscriptionDuplicate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getFixedExpiryDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isReserveOnly() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getMinSubPeriod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getMinSubPeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPenaltyCharges() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCancellation() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getMonthEndSubscription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isHistoric() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getFixedRecurrence() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isFixedRecurringPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isReceipting() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getReceiptingAttribute() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getOrder() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPaymentHandler() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getNonMatchAllUserGroups().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isPromo() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isSubmitToPaymentHandler() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isSuppressToPaymentHandler() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricingTextTemplateName1() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricingTextTemplateName2() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTranslatedPricingText1() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTranslatedPricingText2() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getRecurrenceDay() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getRecurrenceDay()" ).isEqualTo(0) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isAlignWithExternal() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getGracePeriod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getRetryFrequency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getSuspensionPeriod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTranslatedPricingText() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTranslatedPricingText()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getFairUsageLimit() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getFairUsagePeriod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getFairUsagePeriodUnit() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExtensionPeriod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isIncludeServiceForPackageFUP() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isFairUsagePolicyEnabled() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isTariff() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isHideForPurchaseOptions() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().size()).as("auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(0).value() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(1).value() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(2).value() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getSubscription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getBalance() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isRecurring() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPricingModel() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getTier() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().isDefaultPPT() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().size()).as("auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAllBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPackageIdentifier() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPackageIdentifier()" ).isEqualTo("package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false_*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getServiceIdentifier() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getServiceIdentifier()" ).isEqualTo("content:BP001_TAX_*_999_10010_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getStandardRateWithoutTax() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isVolumeType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isOriginal() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(2);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 2);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getKey()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPricePoint()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getFixedAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(1).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getTier() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getProtectedFk() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getmPricingText1() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getmPricingText2() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isNonRecurring() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isEvent() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isPreOrder() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTaxRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTaxCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getLinkedByTrialPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getDescription()" ).isEqualTo("Recurring 1 month");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExpiryDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExpiryDate()" ).isNull();
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances().length" ).isEqualTo(2) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getSubscription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getBalance() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getNetRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getNetRate()" ).isEqualTo(new Double(7.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isAlwaysValidateMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getStandardRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getStandardRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isDiscount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getDiscountPromoText() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getContentId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricingText1() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPricingText2() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getUsageTime() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAccessDuration() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isZeroCostIgnore() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isActive() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getRate()" ).isEqualTo(new Double(8.225)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getChannel() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getMultiUsageMode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getNetworkCodeMatchMethod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isPreRatePriceGross() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPreRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPaymentInformation() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getContentName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getContentName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAssetID() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPremiumLevel() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getReserveOnlyFlag() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getSupplierId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getDeviceType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getUserGroups().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getUserGroup() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPaymentType() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getEventDateTime() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getEventUnits() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPromoCodes().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBearerIds().length ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPromoCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getDuration() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getDuration()" ).isEqualTo(4) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getChargingMethod() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getBearer() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isInteractive() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isIncludeUnavailable() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExpressFlag() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isExpressFlag() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isCancellationUsage() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTierName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTierName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPromoPrecode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getUniquePromoCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPromoUniqueCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getNextCycleDiscount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getHasHistoricPricePointFlag() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isIsForRenewal() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTaxRateAsDouble() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAffiliateID() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getTariff() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAggregatorId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isForcePurchaseFlow() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getReceipientMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getProductCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getMerchantName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getInvoiceText() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isReIssueEnabled() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isReIssueFlagPresent() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getShortPackageId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getHistoryStartDate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getVendorId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isIsForNextPaymentAmount() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getRenewalPreRate() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isOverrideDisallowPreRateFlag() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getContentCategory() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerUrl() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerContactInfo() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerEmail() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerName() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getSubRenewalPricepointId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getLinkPricepointId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getSubPurchaseTransactionTrial() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExtIdentifier1() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExtIdentifier2() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExtIdentifier3() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getAccessChannel() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getPurchaseChannel() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getDeviceID() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getLocal() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getLocal()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getMsisdn() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getLanguageLocale() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getLanguageCode() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExternalField1() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExternalField2() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getExternalTransId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getActiveSubscriptions() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPricePoint().getCsrId() ).as(" auth.getActiveSubscriptions().get(0).getPricePoint().getCsrId()" ).isNull();
//check size of array!
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances().length ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getName() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getName()" ).isEqualTo("Alerts");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isResource() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getCode() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getDescription() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("Alerts");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isToken() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getSubscriptionId()" ).isEqualTo("1126");
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(1126)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getThreshold() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getSubscription() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getBalance() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getMicroServiceSubList() ).as(" auth.getActiveSubscriptions().get(0).getMicroServiceSubList()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPackageId() ).as(" auth.getActiveSubscriptions().get(0).getPackageId()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isRefundable() ).as(" auth.getActiveSubscriptions().get(0).isRefundable()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isSuperPackage() ).as(" auth.getActiveSubscriptions().get(0).isSuperPackage()" ).isFalse() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).getPackageClass() ).as(" auth.getActiveSubscriptions().get(0).getPackageClass()" ).isNull();
        softly.assertThat(auth.getActiveSubscriptions().get(0).isActive() ).as(" auth.getActiveSubscriptions().get(0).isActive()" ).isTrue() ;
        softly.assertThat(auth.getActiveSubscriptions().get(0).isSuspended() ).as(" auth.getActiveSubscriptions().get(0).isSuspended()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(auth.getReasonCode().getName() ).as(" auth.getReasonCode().getName()" ).isEqualTo("OK");
        softly.assertThat(auth.getReasonCode().getSubCode() ).as(" auth.getReasonCode().getSubCode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getReasonCode().getResourceName() ).as(" auth.getReasonCode().getResourceName()" ).isEqualTo("ReasonCode_0");
        softly.assertThat(auth.getReasonCode().getCode() ).as(" auth.getReasonCode().getCode()" ).isEqualTo(0) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointImpl
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getPricePoint().getResource().getName() ).as(" auth.getPricePoint().getResource().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPricePoint().getResource().isCurrency() ).as(" auth.getPricePoint().getResource().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResource().isResource() ).as(" auth.getPricePoint().getResource().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPricePoint().getResource().getCountryId() ).as(" auth.getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPricePoint().getResource().getResourceName() ).as(" auth.getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPricePoint().getResource().getCode() ).as(" auth.getPricePoint().getResource().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPricePoint().getResource().getDescription() ).as(" auth.getPricePoint().getResource().getDescription()" ).isNull();
//        softly.assertThat(auth.getPricePoint().getResource().isToken() ).as(" auth.getPricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResource().isUsageToken() ).as(" auth.getPricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResource().isPayToken() ).as(" auth.getPricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResource().getResourceSymbol() ).as(" auth.getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getKey() ).as(" auth.getPricePoint().getKey()" ).isNull();
        softly.assertThat(auth.getPricePoint().getId() ).as(" auth.getPricePoint().getId()" ).isEqualTo("content:BP001_TAX_B001_999_999_*_999_999");
        softly.assertThat(auth.getPricePoint().getPricingModelTier() ).as(" auth.getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(auth.getPricePoint().isArchived() ).as(" auth.getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isBasePricePoint() ).as(" auth.getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getAccessDevice() ).as(" auth.getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPricePoint().getAlternativeRate() ).as(" auth.getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(1.0)) ;
//check size of array!
        softly.assertThat(auth.getPricePoint().getBalanceImpacts().length ).as(" auth.getPricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].getName() ).as(" auth.getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" auth.getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].isResource() ).as(" auth.getPricePoint().getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" auth.getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" auth.getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].getCode() ).as(" auth.getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" auth.getPricePoint().getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].isToken() ).as(" auth.getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" auth.getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" auth.getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" auth.getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
//check size of list!
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().size()).as("auth.getPricePoint().getBalanceImpactList().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPricePoint().getBalanceImpactList().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getId() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getType() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" auth.getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().isTrial() ).as(" auth.getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getGlid() ).as(" auth.getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(auth.getPricePoint().getPricepointIdLink() ).as(" auth.getPricePoint().getPricepointIdLink()" ).isNull();
        softly.assertThat(auth.getPricePoint().isPreview() ).as(" auth.getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getInteractiveFlag() ).as(" auth.getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
        softly.assertThat(auth.getPricePoint().isForcedPurchase() ).as(" auth.getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isSubscriptionDuplicate() ).as(" auth.getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getFixedExpiryDate() ).as(" auth.getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(auth.getPricePoint().isReserveOnly() ).as(" auth.getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getMinSubPeriod() ).as(" auth.getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPenaltyCharges() ).as(" auth.getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePoint().getCancellation() ).as(" auth.getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getMonthEndSubscription() ).as(" auth.getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPricePoint().isHistoric() ).as(" auth.getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getFixedRecurrence() ).as(" auth.getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPricePoint().isFixedRecurringPricePoint() ).as(" auth.getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isReceipting() ).as(" auth.getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getReceiptingAttribute() ).as(" auth.getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
        softly.assertThat(auth.getPricePoint().getOrder() ).as(" auth.getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPaymentHandler() ).as(" auth.getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(auth.getPricePoint().getNonMatchAllUserGroups().length ).as(" auth.getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().isPromo() ).as(" auth.getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isSubmitToPaymentHandler() ).as(" auth.getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isSuppressToPaymentHandler() ).as(" auth.getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricingTextTemplateName1() ).as(" auth.getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricingTextTemplateName2() ).as(" auth.getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(auth.getPricePoint().getTranslatedPricingText1() ).as(" auth.getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(auth.getPricePoint().getTranslatedPricingText2() ).as(" auth.getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(auth.getPricePoint().getRecurrenceDay() ).as(" auth.getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(auth.getPricePoint().isAlignWithExternal() ).as(" auth.getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getGracePeriod() ).as(" auth.getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(auth.getPricePoint().getRetryFrequency() ).as(" auth.getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(auth.getPricePoint().getSuspensionPeriod() ).as(" auth.getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(auth.getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" auth.getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getTranslatedPricingText() ).as(" auth.getPricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricePoint().getFairUsageLimit() ).as(" auth.getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPricePoint().getFairUsagePeriod() ).as(" auth.getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPricePoint().getFairUsagePeriodUnit() ).as(" auth.getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(auth.getPricePoint().getExtensionPeriod() ).as(" auth.getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().isIncludeServiceForPackageFUP() ).as(" auth.getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isFairUsagePolicyEnabled() ).as(" auth.getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isTariff() ).as(" auth.getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isHideForPurchaseOptions() ).as(" auth.getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(auth.getPricePoint().getTax().getName() ).as(" auth.getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(auth.getPricePoint().getTax().getKey() ).as(" auth.getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRate() ).as(" auth.getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPricePoint().getTax().getTaxCode() ).as(" auth.getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().size()).as("auth.getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(auth.getPricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().get(0).value() ).as(" auth.getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" auth.getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().get(1).value() ).as(" auth.getPricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" auth.getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().get(2).value() ).as(" auth.getPricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(auth.getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" auth.getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
//check size of array!
        softly.assertThat(auth.getPricePoint().getBalances().length ).as(" auth.getPricePoint().getBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().getName() ).as(" auth.getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" auth.getPricePoint().getBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().isResource() ).as(" auth.getPricePoint().getBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" auth.getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" auth.getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().getCode() ).as(" auth.getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().getDescription() ).as(" auth.getPricePoint().getBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().isToken() ).as(" auth.getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" auth.getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" auth.getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getBalances()[0].getSubscriptionId() ).as(" auth.getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" auth.getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" auth.getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalances()[0].getThreshold() ).as(" auth.getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getSubscription() ).as(" auth.getPricePoint().getBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getBalances()[0].getBalance() ).as(" auth.getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getBalances()[0].getPackageId() ).as(" auth.getPricePoint().getBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPricePoint().isRecurring() ).as(" auth.getPricePoint().isRecurring()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" auth.getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(auth.getPricePoint().getPricePointTier().getKey() ).as(" auth.getPricePoint().getPricePointTier().getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("auth.getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" auth.getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" auth.getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getPricingModel() ).as(" auth.getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTier().getTier() ).as(" auth.getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPricePoint().getPricePointTier().isDefaultPPT() ).as(" auth.getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" auth.getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().size()).as("auth.getPricePoint().getAllBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPricePoint().getAllBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPackageIdentifier() ).as(" auth.getPricePoint().getPackageIdentifier()" ).isEqualTo("package:BP001_null_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(auth.getPricePoint().getServiceIdentifier() ).as(" auth.getPricePoint().getServiceIdentifier()" ).isEqualTo("content:BP001_null_B001_999_999_*_999_999");
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(auth.getPricePoint().getResourceField().getName() ).as(" auth.getPricePoint().getResourceField().getName()" ).isEqualTo("Credit Alert");
//        softly.assertThat(auth.getPricePoint().getResourceField().isCurrency() ).as(" auth.getPricePoint().getResourceField().isCurrency()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResourceField().isResource() ).as(" auth.getPricePoint().getResourceField().isResource()" ).isTrue() ;
//        softly.assertThat(auth.getPricePoint().getResourceField().getCountryId() ).as(" auth.getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(auth.getPricePoint().getResourceField().getResourceName() ).as(" auth.getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_1100033");
//        softly.assertThat(auth.getPricePoint().getResourceField().getCode() ).as(" auth.getPricePoint().getResourceField().getCode()" ).isEqualTo(1100033) ;
//        softly.assertThat(auth.getPricePoint().getResourceField().getDescription() ).as(" auth.getPricePoint().getResourceField().getDescription()" ).isNull();
//        softly.assertThat(auth.getPricePoint().getResourceField().isToken() ).as(" auth.getPricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResourceField().isUsageToken() ).as(" auth.getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResourceField().isPayToken() ).as(" auth.getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(auth.getPricePoint().getResourceField().getResourceSymbol() ).as(" auth.getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getStandardRateWithoutTax() ).as(" auth.getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().isVolumeType() ).as(" auth.getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isOriginal() ).as(" auth.getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPricePoint().getPricePointTiers().length ).as(" auth.getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getKey() ).as(" auth.getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
//check size of list!
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100033");
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" auth.getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" auth.getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" auth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" auth.getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getTier() ).as(" auth.getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" auth.getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" auth.getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(auth.getPricePoint().getProtectedFk() ).as(" auth.getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(auth.getPricePoint().getmPricingText1() ).as(" auth.getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricePoint().getmPricingText2() ).as(" auth.getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricePoint().isNonRecurring() ).as(" auth.getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isEvent() ).as(" auth.getPricePoint().isEvent()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().isPreOrder() ).as(" auth.getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getTaxRate() ).as(" auth.getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(auth.getPricePoint().getTaxCode() ).as(" auth.getPricePoint().getTaxCode()" ).isNull();
        softly.assertThat(auth.getPricePoint().getLinkedByTrialPricepoint() ).as(" auth.getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getStartDate() ).as(" auth.getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(auth.getPricePoint().getDescription() ).as(" auth.getPricePoint().getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(auth.getPricePoint().getExpiryDate() ).as(" auth.getPricePoint().getExpiryDate()" ).isNull();
//check size of array!
        softly.assertThat(auth.getPricePoint().getResourceBalances().length ).as(" auth.getPricePoint().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" auth.getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getThreshold() ).as(" auth.getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getSubscription() ).as(" auth.getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getBalance() ).as(" auth.getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getResourceBalances()[0].getPackageId() ).as(" auth.getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getNetRate() ).as(" auth.getPricePoint().getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().isAlwaysValidateMsisdn() ).as(" auth.getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getStandardRate() ).as(" auth.getPricePoint().getStandardRate()" ).isEqualTo(new Double(1.18)) ;
        softly.assertThat(auth.getPricePoint().isDiscount() ).as(" auth.getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getDiscountPromoText() ).as(" auth.getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricePoint().getPackageId() ).as(" auth.getPricePoint().getPackageId()" ).isEqualTo("BP001");
        softly.assertThat(auth.getPricePoint().getContentId() ).as(" auth.getPricePoint().getContentId()" ).isEqualTo("B001");
        softly.assertThat(auth.getPricePoint().getPricingText1() ).as(" auth.getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricePoint().getPricingText2() ).as(" auth.getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(auth.getPricePoint().getUsageTime() ).as(" auth.getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(auth.getPricePoint().getAccessDuration() ).as(" auth.getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(auth.getPricePoint().isZeroCostIgnore() ).as(" auth.getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//check size of array!
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances().length ).as(" auth.getPricePoint().getCustomResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().getName() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().getName()" ).isEqualTo("Credit Alert");
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().isResource() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100033");
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().getCode() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100033) ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().getDescription() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().getDescription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().isToken() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100033");
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionId() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getThreshold() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getSubscription() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getBalance() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getCustomResourceBalances()[0].getPackageId() ).as(" auth.getPricePoint().getCustomResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(auth.getPricePoint().isActive() ).as(" auth.getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(auth.getPricePoint().getRate() ).as(" auth.getPricePoint().getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(auth.getPricePoint().getChannel() ).as(" auth.getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPricePoint().getMultiUsageMode() ).as(" auth.getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getNetworkCodeMatchMethod() ).as(" auth.getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(auth.getPricePoint().isPreRatePriceGross() ).as(" auth.getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(auth.getPricePoint().getPreRate() ).as(" auth.getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(auth.getPricePoint().getPaymentInformation() ).as(" auth.getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(auth.getPricePoint().getContentName() ).as(" auth.getPricePoint().getContentName()" ).isNull();
        softly.assertThat(auth.getPricePoint().getAssetID() ).as(" auth.getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(auth.getPricePoint().getPremiumLevel() ).as(" auth.getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPricePoint().getReserveOnlyFlag() ).as(" auth.getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(auth.getPricePoint().getSupplierId() ).as(" auth.getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(auth.getPricePoint().getDeviceType() ).as(" auth.getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(auth.getPricePoint().getUserGroups().length ).as(" auth.getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(auth.getPricePoint().getUserGroup() ).as(" auth.getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(auth.getPricePoint().getPaymentType() ).as(" auth.getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(auth.getPricePoint().getEventDateTime() ).as(" auth.getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(auth.getPricePoint().getEventUnits() ).as(" auth.getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(auth.getPricePoint().getPromoCodes().length ).as(" auth.getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;





        softly.assertAll();

    }

}
