package com.vodafone.er.ecom.proxy.usagecomplete;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class UsageComplete4_pt7_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void usageComplete() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        final String packageId = "2PP_P002__X__package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false";

        final PurchaseAuthorization auth =
                EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());

        final UsageAuthorization result = EcomApiFactory.getChargingApi(Locale.UK)
                .usageComplete("test-client-id", auth.getEventReservationId(), 1);


//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getDescription() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isToken() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isResource() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getKey() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getType() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).isCurrency() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getPricePoint() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getRate() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getFixedAmount() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getScaledAmount() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).isResource() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getChannel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getChannel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getMultiUsageMode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getMultiUsageMode()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getNetworkCodeMatchMethod() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isPreRatePriceGross() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isPreRatePriceGross()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPreRate() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPaymentInformation() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPaymentInformation()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getContentName() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getContentName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAssetID() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAssetID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPremiumLevel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPremiumLevel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getReserveOnlyFlag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getReserveOnlyFlag()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSupplierId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSupplierId()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDeviceType() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDeviceType()" ).isEqualTo(999) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getUserGroups().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getUserGroups().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getUserGroup() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getUserGroup()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPaymentType() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPaymentType()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getEventDateTime() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getEventDateTime()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getEventUnits() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoCodes().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoCodes().length" ).isEqualTo(1) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBearerIds().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBearerIds().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoCode()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDuration() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDuration()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getChargingMethod() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getChargingMethod()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBearer() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getBearer()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isInteractive() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isInteractive()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isIncludeUnavailable() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isIncludeUnavailable()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExpressFlag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isExpressFlag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isCancellationUsage() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isCancellationUsage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getTierName() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getTierName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoPrecode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoPrecode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getUniquePromoCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getUniquePromoCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoUniqueCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPromoUniqueCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getNextCycleDiscount() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getHasHistoricPricePointFlag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getHasHistoricPricePointFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isIsForRenewal() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isIsForRenewal()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getTaxRateAsDouble() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getTaxRateAsDouble()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAffiliateID() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAffiliateID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getTariff() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getTariff()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAggregatorId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAggregatorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isForcePurchaseFlow() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isForcePurchaseFlow()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getReceipientMsisdn() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getReceipientMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getProductCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getProductCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getMerchantName() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getMerchantName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getInvoiceText() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getInvoiceText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isReIssueEnabled() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isReIssueEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isReIssueFlagPresent() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isReIssueFlagPresent()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getShortPackageId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getShortPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getHistoryStartDate() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getHistoryStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getVendorId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getVendorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isIsForNextPaymentAmount() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isIsForNextPaymentAmount()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getRenewalPreRate() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isOverrideDisallowPreRateFlag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isOverrideDisallowPreRateFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getContentCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getContentCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerUrl() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerUrl()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerContactInfo() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerContactInfo()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerEmail() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerEmail()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerName() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPartnerName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSubRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSubRenewalPricepointId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSubRenewalPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLinkPricepointId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLinkPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSubPurchaseTransactionTrial() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getSubPurchaseTransactionTrial()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDiscardHiddenInactivePricepoints() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isDiscardMiddleAdvancedPricepoints() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExtIdentifier1() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExtIdentifier1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExtIdentifier2() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExtIdentifier2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExtIdentifier3() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExtIdentifier3()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAccessChannel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getAccessChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPurchaseChannel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getPurchaseChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDeviceID() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getDeviceID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLocal() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLocal()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getMsisdn() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLanguageLocale() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLanguageLocale()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLanguageCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getLanguageCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExternalField1() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExternalField1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExternalField2() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExternalField2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExternalTransId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getExternalTransId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getActiveSubscriptions() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getActiveSubscriptions()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getCsrId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoints().get(5).getCsrId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getServiceType() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getServiceType()" ).isEqualTo("service");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isDefaultService() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isDefaultService()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProvisioningSystem()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getUsageId() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getUsageId()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getServiceCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getServiceCategory()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getDealName() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getDealName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getDistributionChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isHighVolumeInterface()" ).isFalse() ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartners().length" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnerNum()" ).isEqualTo(0) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getServiceRevenueSharePartnersPurchaseCh().length" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getIndirectValue() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getIndirectValue()" ).isEqualTo("100");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getIndirectValueFormat()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPromoValue() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPromoValue()" ).isEqualTo("100");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPromoValueFormat()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getContentSubCategory()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getContentItem() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getContentItem()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getDeliveryMechanism()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProductCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProductCategory()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProductSubCategory2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProductWholesalePrice()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProductSelfRegulation()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isVolumeService() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isVolumeService()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProductFk() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProductFk()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isServiceShareOverride()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isExpiredPackageService()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getHasExpress() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getHasExpress()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getHasDynamicDefault()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getHasSuperPackage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isReturnTrialOptionsOnly()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getServiceClass() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getServiceClass()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getBandRevenueShares()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isReIssuePermittedFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getChargeableBy() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getChargeableBy()" ).isEqualTo("Not Defined");
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPackageIds().length" ).isEqualTo(6) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isMicroService() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].ismRefundable() ).as(" result.getSubscription().getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" result.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isUseRateCard() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isReturnAllCatalogueServicesInfo()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getInternalPartner() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getTaxCode() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getTaxCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getContentCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getContentCategory()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricingText1() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricingText1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricingText2() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricingText2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
//// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNull();
////check size of array!
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getPricePoint() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
//// java.util.HashMap
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isReserveOnly() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isReserveOnly()" ).isFalse() ;
//// java.util.HashMap
//// java.util.HashMap
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getSalesModel() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getDescription() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getDescription()" ).isEqualTo("null");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getUrl() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getUrl()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription() ).as(" result.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPackage().getServiceArray()[0].isRefundable() ).as(" result.getSubscription().getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPackage().isEventPackage() ).as(" result.getSubscription().getPackage().isEventPackage()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPackage().isRecurringPackage() ).as(" result.getSubscription().getPackage().isRecurringPackage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().getPackageType() ).as(" result.getSubscription().getPackage().getPackageType()" ).isEqualTo("Event");
//        softly.assertThat(result.getSubscription().getPackage().getNonRefundableDescription() ).as(" result.getSubscription().getPackage().getNonRefundableDescription()" ).isEqualTo("Sorry, the package is not refundable, because at least one of its service is not refundable!");
//        softly.assertThat(result.getSubscription().getPackage().isRefundable() ).as(" result.getSubscription().getPackage().isRefundable()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPackage().isCalendarPackage() ).as(" result.getSubscription().getPackage().isCalendarPackage()" ).isFalse() ;
//


        softly.assertThat(result.getSubscription().getCountry() ).as(" result.getSubscription().getCountry()" ).isNull();
        softly.assertThat(result.getSubscription().getMsisdn() ).as(" result.getSubscription().getMsisdn()" ).isEqualTo("809057993");
        softly.assertThat(result.getSubscription().getCsrId() ).as(" result.getSubscription().getCsrId()" ).isEqualTo("test");
        softly.assertThat(result.getSubscription().getExtensionPeriod() ).as(" result.getSubscription().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(result.getSubscription().getPaymentType() ).as(" result.getSubscription().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(result.getSubscription().getPartnerId() ).as(" result.getSubscription().getPartnerId()" ).isNull();
        softly.assertThat(result.getSubscription().getMerchantName() ).as(" result.getSubscription().getMerchantName()" ).isNull();
        softly.assertThat(result.getSubscription().getRenewalPreRate() ).as(" result.getSubscription().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getSubscription().getExtIdentifier1() ).as(" result.getSubscription().getExtIdentifier1()" ).isNull();
        softly.assertThat(result.getSubscription().getExtIdentifier2() ).as(" result.getSubscription().getExtIdentifier2()" ).isNull();
        softly.assertThat(result.getSubscription().getExtIdentifier3() ).as(" result.getSubscription().getExtIdentifier3()" ).isNull();
        softly.assertThat(result.getSubscription().getPackageId() ).as(" result.getSubscription().getPackageId()" ).isNull();
        softly.assertThat(result.getSubscription().isArchived() ).as(" result.getSubscription().isArchived()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isSuperPackage() ).as(" result.getSubscription().isSuperPackage()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().getName() ).as(" result.getSubscription().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().getCode() ).as(" result.getSubscription().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().isToken() ).as(" result.getSubscription().getPricePoint().getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getResource().isResource() ).as(" result.getSubscription().getPricePoint().getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getKey() ).as(" result.getSubscription().getPricePoint().getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getId() ).as(" result.getSubscription().getPricePoint().getId()" ).isEqualTo("package:2PP_P002_TAX_999_999_999_999_999_*_*_false_false");
//        softly.assertThat(result.getSubscription().getPricePoint().getGracePeriod() ).as(" result.getSubscription().getPricePoint().getGracePeriod()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getNetRate() ).as(" result.getSubscription().getPricePoint().getNetRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().isAlwaysValidateMsisdn() ).as(" result.getSubscription().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getCustomResourceBalances() ).as(" result.getSubscription().getPricePoint().getCustomResourceBalances()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getRetryFrequency() ).as(" result.getSubscription().getPricePoint().getRetryFrequency()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getSuspensionPeriod() ).as(" result.getSubscription().getPricePoint().getSuspensionPeriod()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" result.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTranslatedPricingText() ).as(" result.getSubscription().getPricePoint().getTranslatedPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getFairUsageLimit() ).as(" result.getSubscription().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getFairUsagePeriod() ).as(" result.getSubscription().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getFairUsagePeriodUnit() ).as(" result.getSubscription().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
//        softly.assertThat(result.getSubscription().getPricePoint().getExtensionPeriod() ).as(" result.getSubscription().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().isIncludeServiceForPackageFUP() ).as(" result.getSubscription().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isFairUsagePolicyEnabled() ).as(" result.getSubscription().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isVolumeType() ).as(" result.getSubscription().getPricePoint().isVolumeType()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isOriginal() ).as(" result.getSubscription().getPricePoint().isOriginal()" ).isFalse() ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers().length ).as(" result.getSubscription().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getKey() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()).as("result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getTier() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" result.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isPreOrder() ).as(" result.getSubscription().getPricePoint().isPreOrder()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTaxRate() ).as(" result.getSubscription().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTaxCode() ).as(" result.getSubscription().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
//        softly.assertThat(result.getSubscription().getPricePoint().getLinkedByTrialPricepoint() ).as(" result.getSubscription().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isDiscount() ).as(" result.getSubscription().getPricePoint().isDiscount()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getDiscountPromoText() ).as(" result.getSubscription().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPricePoint().getPackageId() ).as(" result.getSubscription().getPricePoint().getPackageId()" ).isEqualTo("2PP_P002");
//        softly.assertThat(result.getSubscription().getPricePoint().getContentId() ).as(" result.getSubscription().getPricePoint().getContentId()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricingText1() ).as(" result.getSubscription().getPricePoint().getPricingText1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricingText2() ).as(" result.getSubscription().getPricePoint().getPricingText2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPricePoint().getUsageTime() ).as(" result.getSubscription().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAccessDuration() ).as(" result.getSubscription().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricingModelTier() ).as(" result.getSubscription().getPricePoint().getPricingModelTier()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isArchived() ).as(" result.getSubscription().getPricePoint().isArchived()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isBasePricePoint() ).as(" result.getSubscription().getPricePoint().isBasePricePoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAccessDevice() ).as(" result.getSubscription().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAlternativeRate() ).as(" result.getSubscription().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(2.35)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts().length ).as(" result.getSubscription().getPricePoint().getBalanceImpacts().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].getName() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].isCurrency() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].getCode() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].getResourceName() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].getDescription() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].getCountryId() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].isToken() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].isUsageToken() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].isPayToken() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpacts()[0].isResource() ).as(" result.getSubscription().getPricePoint().getBalanceImpacts()[0].isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isActive() ).as(" result.getSubscription().getPricePoint().isActive()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getStartDate() ).as(" result.getSubscription().getPricePoint().getStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getRate() ).as(" result.getSubscription().getPricePoint().getRate()" ).isEqualTo(new Double(2.35)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getExpiryDate() ).as(" result.getSubscription().getPricePoint().getExpiryDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isTrial() ).as(" result.getSubscription().getPricePoint().isTrial()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getGlid() ).as(" result.getSubscription().getPricePoint().getGlid()" ).isNullOrEmpty();
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPricePoint().getPricepointIdLink() ).as(" result.getSubscription().getPricePoint().getPricepointIdLink()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isPreview() ).as(" result.getSubscription().getPricePoint().isPreview()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getInteractiveFlag() ).as(" result.getSubscription().getPricePoint().getInteractiveFlag()" ).isEqualTo("NONE");
//        softly.assertThat(result.getSubscription().getPricePoint().isForcedPurchase() ).as(" result.getSubscription().getPricePoint().isForcedPurchase()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isSubscriptionDuplicate() ).as(" result.getSubscription().getPricePoint().isSubscriptionDuplicate()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getFixedExpiryDate() ).as(" result.getSubscription().getPricePoint().getFixedExpiryDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isReserveOnly() ).as(" result.getSubscription().getPricePoint().isReserveOnly()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getMinSubPeriod() ).as(" result.getSubscription().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPenaltyCharges() ).as(" result.getSubscription().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getCancellation() ).as(" result.getSubscription().getPricePoint().getCancellation()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getMonthEndSubscription() ).as(" result.getSubscription().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
//        softly.assertThat(result.getSubscription().getPricePoint().isHistoric() ).as(" result.getSubscription().getPricePoint().isHistoric()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getFixedRecurrence() ).as(" result.getSubscription().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().isFixedRecurringPricePoint() ).as(" result.getSubscription().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isReceipting() ).as(" result.getSubscription().getPricePoint().isReceipting()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getReceiptingAttribute() ).as(" result.getSubscription().getPricePoint().getReceiptingAttribute()" ).isEqualTo("NULL");
//        softly.assertThat(result.getSubscription().getPricePoint().getOrder() ).as(" result.getSubscription().getPricePoint().getOrder()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPaymentHandler() ).as(" result.getSubscription().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getNonMatchAllUserGroups().length ).as(" result.getSubscription().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().isPromo() ).as(" result.getSubscription().getPricePoint().isPromo()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isSubmitToPaymentHandler() ).as(" result.getSubscription().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isSuppressToPaymentHandler() ).as(" result.getSubscription().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricingTextTemplateName1() ).as(" result.getSubscription().getPricePoint().getPricingTextTemplateName1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricingTextTemplateName2() ).as(" result.getSubscription().getPricePoint().getPricingTextTemplateName2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getTranslatedPricingText1() ).as(" result.getSubscription().getPricePoint().getTranslatedPricingText1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getTranslatedPricingText2() ).as(" result.getSubscription().getPricePoint().getTranslatedPricingText2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getRecurrenceDay() ).as(" result.getSubscription().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
//// java.util.HashMap
//// java.util.HashMap
//        softly.assertThat(result.getSubscription().getPricePoint().isAlignWithExternal() ).as(" result.getSubscription().getPricePoint().isAlignWithExternal()" ).isFalse() ;
////check size of list!
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().size()).as("result.getSubscription().getPricePoint().getAllBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPricePoint().getAllBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPricePoint().getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPackageIdentifier() ).as(" result.getSubscription().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:2PP_P002_TAX_999_999_999_999_999_*_*_*_false_false_*");
//        softly.assertThat(result.getSubscription().getPricePoint().getServiceIdentifier() ).as(" result.getSubscription().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:2PP_P002_TAX_*_999_999_*_999_999");
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().getName() ).as(" result.getSubscription().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().isCurrency() ).as(" result.getSubscription().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().getCode() ).as(" result.getSubscription().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().getResourceName() ).as(" result.getSubscription().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().getDescription() ).as(" result.getSubscription().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().getCountryId() ).as(" result.getSubscription().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().isToken() ).as(" result.getSubscription().getPricePoint().getResourceField().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().isUsageToken() ).as(" result.getSubscription().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().isPayToken() ).as(" result.getSubscription().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceField().isResource() ).as(" result.getSubscription().getPricePoint().getResourceField().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getStandardRateWithoutTax() ).as(" result.getSubscription().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getProtectedFk() ).as(" result.getSubscription().getPricePoint().getProtectedFk()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getmPricingText1() ).as(" result.getSubscription().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPricePoint().getmPricingText2() ).as(" result.getSubscription().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
//        softly.assertThat(result.getSubscription().getPricePoint().isNonRecurring() ).as(" result.getSubscription().getPricePoint().isNonRecurring()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isZeroCostIgnore() ).as(" result.getSubscription().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getDescription() ).as(" result.getSubscription().getPricePoint().getDescription()" ).isEqualTo("Default (event) ");
//        softly.assertThat(result.getSubscription().getPricePoint().isTariff() ).as(" result.getSubscription().getPricePoint().isTariff()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isHideForPurchaseOptions() ).as(" result.getSubscription().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
//// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getName() ).as(" result.getSubscription().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getKey() ).as(" result.getSubscription().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRate() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxCode() ).as(" result.getSubscription().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
////check size of list!
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().size()).as("result.getSubscription().getPricePoint().getTax().getTaxRates().size()").isEqualTo(3);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPricePoint().getTax().getTaxRates().size() >= 3);
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().get(0).value() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRates().get(0).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().get(0).getKey() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRates().get(0).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().get(1).value() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRates().get(1).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().get(1).getKey() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRates().get(1).getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().get(2).value() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRates().get(2).value()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTax().getTaxRates().get(2).getKey() ).as(" result.getSubscription().getPricePoint().getTax().getTaxRates().get(2).getKey()" ).isEqualTo(new Long(0)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances().length ).as(" result.getSubscription().getPricePoint().getBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().getName() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().getCode() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().isToken() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getResource().isResource() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getThreshold() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getBalance() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getPackageId() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getSubscription() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getSubscriptionId() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getSubscriptionIdLong() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalances()[0].getOldestSubscriptionId() ).as(" result.getSubscription().getPricePoint().getBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isRecurring() ).as(" result.getSubscription().getPricePoint().isRecurring()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" result.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
//// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getKey() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getKey()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().size()).as("result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getBalanceImpacts().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getPricingModel() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getTier() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" result.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" result.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isEvent() ).as(" result.getSubscription().getPricePoint().isEvent()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getStandardRate() ).as(" result.getSubscription().getPricePoint().getStandardRate()" ).isEqualTo(new Double(2.35)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances().length ).as(" result.getSubscription().getPricePoint().getResourceBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getName() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getCode() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isToken() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isResource() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getThreshold() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getBalance() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getPackageId() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getSubscription() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getSubscriptionId() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId() ).as(" result.getSubscription().getPricePoint().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
////check size of list!
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().size()).as("result.getSubscription().getPricePoint().getBalanceImpactList().size()").isEqualTo(1);
////if the list is smaller than expected we can't continue, so do a hard assert
//        assertTrue(result.getSubscription().getPricePoint().getBalanceImpactList().size() >= 1);
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getName() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getCode() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isToken() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isResource() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getResource().isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getKey() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getKey()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getId() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getType() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).isCurrency() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getPricePoint() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getPricePoint()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getRate() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getFixedAmount() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getScaledAmount() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBalanceImpactList().get(0).isResource() ).as(" result.getSubscription().getPricePoint().getBalanceImpactList().get(0).isResource()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getChannel() ).as(" result.getSubscription().getPricePoint().getChannel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getMultiUsageMode() ).as(" result.getSubscription().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getNetworkCodeMatchMethod() ).as(" result.getSubscription().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().isPreRatePriceGross() ).as(" result.getSubscription().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPreRate() ).as(" result.getSubscription().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPaymentInformation() ).as(" result.getSubscription().getPricePoint().getPaymentInformation()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getContentName() ).as(" result.getSubscription().getPricePoint().getContentName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getAssetID() ).as(" result.getSubscription().getPricePoint().getAssetID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPremiumLevel() ).as(" result.getSubscription().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getReserveOnlyFlag() ).as(" result.getSubscription().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getSupplierId() ).as(" result.getSubscription().getPricePoint().getSupplierId()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPricePoint().getDeviceType() ).as(" result.getSubscription().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getUserGroups().length ).as(" result.getSubscription().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getUserGroup() ).as(" result.getSubscription().getPricePoint().getUserGroup()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPricePoint().getPaymentType() ).as(" result.getSubscription().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getEventDateTime() ).as(" result.getSubscription().getPricePoint().getEventDateTime()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getEventUnits() ).as(" result.getSubscription().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getPromoCodes().length ).as(" result.getSubscription().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getPricePoint().getBearerIds().length ).as(" result.getSubscription().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPromoCode() ).as(" result.getSubscription().getPricePoint().getPromoCode()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPricePoint().getDuration() ).as(" result.getSubscription().getPricePoint().getDuration()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getChargingMethod() ).as(" result.getSubscription().getPricePoint().getChargingMethod()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getBearer() ).as(" result.getSubscription().getPricePoint().getBearer()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPricePoint().isInteractive() ).as(" result.getSubscription().getPricePoint().isInteractive()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isIncludeUnavailable() ).as(" result.getSubscription().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getExpressFlag() ).as(" result.getSubscription().getPricePoint().getExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isExpressFlag() ).as(" result.getSubscription().getPricePoint().isExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isCancellationUsage() ).as(" result.getSubscription().getPricePoint().isCancellationUsage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTierName() ).as(" result.getSubscription().getPricePoint().getTierName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPromoPrecode() ).as(" result.getSubscription().getPricePoint().getPromoPrecode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getUniquePromoCode() ).as(" result.getSubscription().getPricePoint().getUniquePromoCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPromoUniqueCode() ).as(" result.getSubscription().getPricePoint().getPromoUniqueCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getNextCycleDiscount() ).as(" result.getSubscription().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getHasHistoricPricePointFlag() ).as(" result.getSubscription().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isIsForRenewal() ).as(" result.getSubscription().getPricePoint().isIsForRenewal()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getTaxRateAsDouble() ).as(" result.getSubscription().getPricePoint().getTaxRateAsDouble()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getAffiliateID() ).as(" result.getSubscription().getPricePoint().getAffiliateID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPartnerId() ).as(" result.getSubscription().getPricePoint().getPartnerId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getTariff() ).as(" result.getSubscription().getPricePoint().getTariff()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getPricePoint().getAggregatorId() ).as(" result.getSubscription().getPricePoint().getAggregatorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isForcePurchaseFlow() ).as(" result.getSubscription().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getReceipientMsisdn() ).as(" result.getSubscription().getPricePoint().getReceipientMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getProductCode() ).as(" result.getSubscription().getPricePoint().getProductCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getMerchantName() ).as(" result.getSubscription().getPricePoint().getMerchantName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getInvoiceText() ).as(" result.getSubscription().getPricePoint().getInvoiceText()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isReIssueEnabled() ).as(" result.getSubscription().getPricePoint().isReIssueEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isReIssueFlagPresent() ).as(" result.getSubscription().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getShortPackageId() ).as(" result.getSubscription().getPricePoint().getShortPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getHistoryStartDate() ).as(" result.getSubscription().getPricePoint().getHistoryStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getVendorId() ).as(" result.getSubscription().getPricePoint().getVendorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().isIsForNextPaymentAmount() ).as(" result.getSubscription().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getRenewalPreRate() ).as(" result.getSubscription().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" result.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getContentCategory() ).as(" result.getSubscription().getPricePoint().getContentCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPartnerUrl() ).as(" result.getSubscription().getPricePoint().getPartnerUrl()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPartnerContactInfo() ).as(" result.getSubscription().getPricePoint().getPartnerContactInfo()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPartnerEmail() ).as(" result.getSubscription().getPricePoint().getPartnerEmail()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPartnerName() ).as(" result.getSubscription().getPricePoint().getPartnerName()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getPricePoint().getSubRenewalPricepointId() ).as(" result.getSubscription().getPricePoint().getSubRenewalPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getLinkPricepointId() ).as(" result.getSubscription().getPricePoint().getLinkPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getSubPurchaseTransactionTrial() ).as(" result.getSubscription().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" result.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" result.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getPricePoint().getExtIdentifier1() ).as(" result.getSubscription().getPricePoint().getExtIdentifier1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getExtIdentifier2() ).as(" result.getSubscription().getPricePoint().getExtIdentifier2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getExtIdentifier3() ).as(" result.getSubscription().getPricePoint().getExtIdentifier3()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getAccessChannel() ).as(" result.getSubscription().getPricePoint().getAccessChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getPurchaseChannel() ).as(" result.getSubscription().getPricePoint().getPurchaseChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getDeviceID() ).as(" result.getSubscription().getPricePoint().getDeviceID()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getLocal() ).as(" result.getSubscription().getPricePoint().getLocal()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getMsisdn() ).as(" result.getSubscription().getPricePoint().getMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getLanguageLocale() ).as(" result.getSubscription().getPricePoint().getLanguageLocale()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getLanguageCode() ).as(" result.getSubscription().getPricePoint().getLanguageCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getExternalField1() ).as(" result.getSubscription().getPricePoint().getExternalField1()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getExternalField2() ).as(" result.getSubscription().getPricePoint().getExternalField2()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getExternalTransId() ).as(" result.getSubscription().getPricePoint().getExternalTransId()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getActiveSubscriptions() ).as(" result.getSubscription().getPricePoint().getActiveSubscriptions()" ).isNull();
//        softly.assertThat(result.getSubscription().getPricePoint().getCsrId() ).as(" result.getSubscription().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(result.getSubscription().isActive() ).as(" result.getSubscription().isActive()" ).isTrue() ;
        softly.assertThat(result.getSubscription().isDefault() ).as(" result.getSubscription().isDefault()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isPromotional() ).as(" result.getSubscription().isPromotional()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getPromotionalExpiryDate() ).as(" result.getSubscription().getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(result.getSubscription().getStatus() ).as(" result.getSubscription().getStatus()" ).isEqualTo(1) ;
        softly.assertThat(result.getSubscription().getExternalSubId() ).as(" result.getSubscription().getExternalSubId()" ).isNull();
        softly.assertThat(result.getSubscription().getOptions() ).as(" result.getSubscription().getOptions()" ).isNull();
        softly.assertThat(result.getSubscription().getPackageClass() ).as(" result.getSubscription().getPackageClass()" ).isNull();
        softly.assertThat(result.getSubscription().getMicroServiceSubList() ).as(" result.getSubscription().getMicroServiceSubList()" ).isNull();
        softly.assertThat(result.getSubscription().isRecurring() ).as(" result.getSubscription().isRecurring()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getSubscriptionId() ).as(" result.getSubscription().getSubscriptionId()" ).isEqualTo("1248");
        softly.assertThat(result.getSubscription().getSubscriptionIdLong() ).as(" result.getSubscription().getSubscriptionIdLong()" ).isEqualTo(new Long(1248)) ;
        softly.assertThat(result.getSubscription().getAccount() ).as(" result.getSubscription().getAccount()" ).isNull();
        softly.assertThat(result.getSubscription().isInactiveOrClosed() ).as(" result.getSubscription().isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isFailed() ).as(" result.getSubscription().isFailed()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isBeingProvisioned() ).as(" result.getSubscription().isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isReserved() ).as(" result.getSubscription().isReserved()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getLinkedPtID() ).as(" result.getSubscription().getLinkedPtID()" ).isNull();
        softly.assertThat(result.getSubscription().isPreOrdered() ).as(" result.getSubscription().isPreOrdered()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getContentPaymentType() ).as(" result.getSubscription().getContentPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(result.getSubscription().getPurchaseDeviceType() ).as(" result.getSubscription().getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(result.getSubscription().getNextCyclePercentDiscount() ).as(" result.getSubscription().getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getSubscription().getNextPaymentAmount() ).as(" result.getSubscription().getNextPaymentAmount()" ).isEqualTo(new Double(2.0)) ;
//check size of array!
        softly.assertThat(result.getSubscription().getServiceIds().length ).as(" result.getSubscription().getServiceIds().length" ).isEqualTo(1) ;
        softly.assertThat(result.getSubscription().getResourceBalancesList() ).as(" result.getSubscription().getResourceBalancesList()" ).isNull();
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
//        softly.assertThat(result.getSubscription().getRatingAttributes().getChannel() ).as(" result.getSubscription().getRatingAttributes().getChannel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getMultiUsageMode() ).as(" result.getSubscription().getRatingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod() ).as(" result.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isPreRatePriceGross() ).as(" result.getSubscription().getRatingAttributes().isPreRatePriceGross()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPreRate() ).as(" result.getSubscription().getRatingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPaymentInformation() ).as(" result.getSubscription().getRatingAttributes().getPaymentInformation()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getContentName() ).as(" result.getSubscription().getRatingAttributes().getContentName()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getAssetID() ).as(" result.getSubscription().getRatingAttributes().getAssetID()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPremiumLevel() ).as(" result.getSubscription().getRatingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getReserveOnlyFlag() ).as(" result.getSubscription().getRatingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getSupplierId() ).as(" result.getSubscription().getRatingAttributes().getSupplierId()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getRatingAttributes().getDeviceType() ).as(" result.getSubscription().getRatingAttributes().getDeviceType()" ).isEqualTo(999) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getRatingAttributes().getUserGroups().length ).as(" result.getSubscription().getRatingAttributes().getUserGroups().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getUserGroup() ).as(" result.getSubscription().getRatingAttributes().getUserGroup()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPaymentType() ).as(" result.getSubscription().getRatingAttributes().getPaymentType()" ).isEqualTo(10010) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getEventDateTime() ).as(" result.getSubscription().getRatingAttributes().getEventDateTime()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getEventUnits() ).as(" result.getSubscription().getRatingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPromoCodes().length ).as(" result.getSubscription().getRatingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
////check size of array!
//        softly.assertThat(result.getSubscription().getRatingAttributes().getBearerIds().length ).as(" result.getSubscription().getRatingAttributes().getBearerIds().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPromoCode() ).as(" result.getSubscription().getRatingAttributes().getPromoCode()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getRatingAttributes().getDuration() ).as(" result.getSubscription().getRatingAttributes().getDuration()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getChargingMethod() ).as(" result.getSubscription().getRatingAttributes().getChargingMethod()" ).isEqualTo(999) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getBearer() ).as(" result.getSubscription().getRatingAttributes().getBearer()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getRatingAttributes().isInteractive() ).as(" result.getSubscription().getRatingAttributes().isInteractive()" ).isTrue() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isIncludeUnavailable() ).as(" result.getSubscription().getRatingAttributes().isIncludeUnavailable()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExpressFlag() ).as(" result.getSubscription().getRatingAttributes().getExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isExpressFlag() ).as(" result.getSubscription().getRatingAttributes().isExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isPreOrder() ).as(" result.getSubscription().getRatingAttributes().isPreOrder()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isCancellationUsage() ).as(" result.getSubscription().getRatingAttributes().isCancellationUsage()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getTierName() ).as(" result.getSubscription().getRatingAttributes().getTierName()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPromoPrecode() ).as(" result.getSubscription().getRatingAttributes().getPromoPrecode()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getUniquePromoCode() ).as(" result.getSubscription().getRatingAttributes().getUniquePromoCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPromoUniqueCode() ).as(" result.getSubscription().getRatingAttributes().getPromoUniqueCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getNextCycleDiscount() ).as(" result.getSubscription().getRatingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag() ).as(" result.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isIsForRenewal() ).as(" result.getSubscription().getRatingAttributes().isIsForRenewal()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getTaxRate() ).as(" result.getSubscription().getRatingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getTaxRateAsDouble() ).as(" result.getSubscription().getRatingAttributes().getTaxRateAsDouble()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getAffiliateID() ).as(" result.getSubscription().getRatingAttributes().getAffiliateID()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPartnerId() ).as(" result.getSubscription().getRatingAttributes().getPartnerId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getTariff() ).as(" result.getSubscription().getRatingAttributes().getTariff()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getRatingAttributes().getAggregatorId() ).as(" result.getSubscription().getRatingAttributes().getAggregatorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().isForcePurchaseFlow() ).as(" result.getSubscription().getRatingAttributes().isForcePurchaseFlow()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getReceipientMsisdn() ).as(" result.getSubscription().getRatingAttributes().getReceipientMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getProductCode() ).as(" result.getSubscription().getRatingAttributes().getProductCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getMerchantName() ).as(" result.getSubscription().getRatingAttributes().getMerchantName()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getInvoiceText() ).as(" result.getSubscription().getRatingAttributes().getInvoiceText()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().isReIssueEnabled() ).as(" result.getSubscription().getRatingAttributes().isReIssueEnabled()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isReIssueFlagPresent() ).as(" result.getSubscription().getRatingAttributes().isReIssueFlagPresent()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getShortPackageId() ).as(" result.getSubscription().getRatingAttributes().getShortPackageId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getTaxCode() ).as(" result.getSubscription().getRatingAttributes().getTaxCode()" ).isEqualTo("*");
//        softly.assertThat(result.getSubscription().getRatingAttributes().getHistoryStartDate() ).as(" result.getSubscription().getRatingAttributes().getHistoryStartDate()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getVendorId() ).as(" result.getSubscription().getRatingAttributes().getVendorId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().isIsForNextPaymentAmount() ).as(" result.getSubscription().getRatingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getRenewalPreRate() ).as(" result.getSubscription().getRatingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag() ).as(" result.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getContentCategory() ).as(" result.getSubscription().getRatingAttributes().getContentCategory()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPartnerUrl() ).as(" result.getSubscription().getRatingAttributes().getPartnerUrl()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPartnerContactInfo() ).as(" result.getSubscription().getRatingAttributes().getPartnerContactInfo()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPartnerEmail() ).as(" result.getSubscription().getRatingAttributes().getPartnerEmail()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPartnerName() ).as(" result.getSubscription().getRatingAttributes().getPartnerName()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint() ).as(" result.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getSubRenewalPricepointId() ).as(" result.getSubscription().getRatingAttributes().getSubRenewalPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getLinkPricepointId() ).as(" result.getSubscription().getRatingAttributes().getLinkPricepointId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial() ).as(" result.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints() ).as(" result.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" result.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExtIdentifier1() ).as(" result.getSubscription().getRatingAttributes().getExtIdentifier1()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExtIdentifier2() ).as(" result.getSubscription().getRatingAttributes().getExtIdentifier2()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExtIdentifier3() ).as(" result.getSubscription().getRatingAttributes().getExtIdentifier3()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getAccessChannel() ).as(" result.getSubscription().getRatingAttributes().getAccessChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getPurchaseChannel() ).as(" result.getSubscription().getRatingAttributes().getPurchaseChannel()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getDeviceID() ).as(" result.getSubscription().getRatingAttributes().getDeviceID()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getLocal() ).as(" result.getSubscription().getRatingAttributes().getLocal()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getMsisdn() ).as(" result.getSubscription().getRatingAttributes().getMsisdn()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getLanguageLocale() ).as(" result.getSubscription().getRatingAttributes().getLanguageLocale()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getLanguageCode() ).as(" result.getSubscription().getRatingAttributes().getLanguageCode()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExternalField1() ).as(" result.getSubscription().getRatingAttributes().getExternalField1()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExternalField2() ).as(" result.getSubscription().getRatingAttributes().getExternalField2()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getExternalTransId() ).as(" result.getSubscription().getRatingAttributes().getExternalTransId()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getActiveSubscriptions() ).as(" result.getSubscription().getRatingAttributes().getActiveSubscriptions()" ).isNull();
//        softly.assertThat(result.getSubscription().getRatingAttributes().getCsrId() ).as(" result.getSubscription().getRatingAttributes().getCsrId()" ).isNull();
        softly.assertThat(result.getSubscription().getPaymentTransactionId() ).as(" result.getSubscription().getPaymentTransactionId()" ).isEqualTo(new Long(904)) ;
        softly.assertThat(result.getSubscription().getNonRefundDescription() ).as(" result.getSubscription().getNonRefundDescription()" ).isEqualTo("Sorry, the package is not refundable, because at least one of its service is not refundable!");
        softly.assertThat(result.getSubscription().getInteractiveUsageFlag() ).as(" result.getSubscription().getInteractiveUsageFlag()" ).isEqualTo(1) ;
        softly.assertThat(result.getSubscription().isFirstUsage() ).as(" result.getSubscription().isFirstUsage()" ).isTrue() ;
        softly.assertThat(result.getSubscription().isSubscriptionUsed() ).as(" result.getSubscription().isSubscriptionUsed()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getCurrentNoOfOccurences() ).as(" result.getSubscription().getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(result.getSubscription().getPenaltyCharge() ).as(" result.getSubscription().getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getSubscription().isMinSubscriptionPeriodElapsed() ).as(" result.getSubscription().isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(result.getSubscription().isUnderGracePeriod() ).as(" result.getSubscription().isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getBatchRetryDate() ).as(" result.getSubscription().getBatchRetryDate()" ).isNull();
        softly.assertThat(result.getSubscription().getOverdueExpiryDate() ).as(" result.getSubscription().getOverdueExpiryDate()" ).isNull();
        softly.assertThat(result.getSubscription().getLastExpiryDate() ).as(" result.getSubscription().getLastExpiryDate()" ).isNull();
        softly.assertThat(result.getSubscription().isWasRecurringTrial() ).as(" result.getSubscription().isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getParentPackageID() ).as(" result.getSubscription().getParentPackageID()" ).isNull();
//check size of list!
        softly.assertThat(result.getSubscription().getTransactions().size()).as("result.getSubscription().getTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getSubscription().getTransactions().size() >= 0);
//check size of list!
        softly.assertThat(result.getSubscription().getRefundTransactions().size()).as("result.getSubscription().getRefundTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getSubscription().getRefundTransactions().size() >= 0);
        softly.assertThat(result.getSubscription().getPreviousStatus() ).as(" result.getSubscription().getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(result.getSubscription().isParentAlsoPurchased() ).as(" result.getSubscription().isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isProvisionOnUsageSuccess() ).as(" result.getSubscription().isProvisionOnUsageSuccess()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getLastUsageTransactionIdForSameContent() ).as(" result.getSubscription().getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(result.getSubscription().getSpId() ).as(" result.getSubscription().getSpId()" ).isNull();
        softly.assertThat(result.getSubscription().getPartnerTaxRate() ).as(" result.getSubscription().getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getSubscription().getCountryId() ).as(" result.getSubscription().getCountryId()" ).isNull();
        softly.assertThat(result.getSubscription().isWasRecurringPromoCode() ).as(" result.getSubscription().isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getLastPaymentTransaction() ).as(" result.getSubscription().getLastPaymentTransaction()" ).isNull();
        softly.assertThat(result.getSubscription().getB2BPartner() ).as(" result.getSubscription().getB2BPartner()" ).isNull();
        softly.assertThat(result.getSubscription().getRenewalCounterToLinkedPricepoint() ).as(" result.getSubscription().getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(result.getSubscription().isRenewalPreRateGross() ).as(" result.getSubscription().isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getNextPricePointId() ).as(" result.getSubscription().getNextPricePointId()" ).isNull();
        softly.assertThat(result.getSubscription().getLastPaymentTransactionAmount() ).as(" result.getSubscription().getLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getSubscription().getLastToLastPaymentTransactionAmount() ).as(" result.getSubscription().getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getSubscription().isPricePointChangeOnRenewal() ).as(" result.getSubscription().isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getOldSubscriptionId() ).as(" result.getSubscription().getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(result.getSubscription().getOldMsisdn() ).as(" result.getSubscription().getOldMsisdn()" ).isNull();
        softly.assertThat(result.getSubscription().isProvisionable() ).as(" result.getSubscription().isProvisionable()" ).isFalse() ;
        softly.assertThat(result.getSubscription().getFuturePricePointRenewals() ).as(" result.getSubscription().getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(result.getSubscription().getPurcServiceList() ).as(" result.getSubscription().getPurcServiceList()" ).isNull();
//check size of list!
        softly.assertThat(result.getSubscription().getPaymentTransactions().size()).as("result.getSubscription().getPaymentTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getSubscription().getPaymentTransactions().size() >= 0);
//check size of list!
        softly.assertThat(result.getSubscription().getModifyTransactions().size()).as("result.getSubscription().getModifyTransactions().size()").isEqualTo(0);
//if the list is smaller than expected we can't continue, so do a hard assert
        assertTrue(result.getSubscription().getModifyTransactions().size() >= 0);
        softly.assertThat(result.getSubscription().getNextCyclePercentValue() ).as(" result.getSubscription().getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getSubscription().getLockId() ).as(" result.getSubscription().getLockId()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(result.getSubscription().getResourceBalances() ).as(" result.getSubscription().getResourceBalances()" ).isNull();
        softly.assertThat(result.getSubscription().isRefundable() ).as(" result.getSubscription().isRefundable()" ).isFalse() ;
        softly.assertThat(result.getSubscription().isSuspended() ).as(" result.getSubscription().isSuspended()" ).isFalse() ;
        softly.assertThat(result.getEventReservationId() ).as(" result.getEventReservationId()" ).isEqualTo("904");
        softly.assertThat(result.isReservedOnly() ).as(" result.isReservedOnly()" ).isFalse() ;
        softly.assertThat(result.isCharged() ).as(" result.isCharged()" ).isTrue() ;
        softly.assertThat(result.getUserResourceBalance() ).as(" result.getUserResourceBalance()" ).isNull();
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(result.getSubReasonCode().getName() ).as(" result.getSubReasonCode().getName()" ).isEqualTo("OK");
        softly.assertThat(result.getSubReasonCode().getCode() ).as(" result.getSubReasonCode().getCode()" ).isEqualTo(0) ;
        softly.assertThat(result.getSubReasonCode().getSubCode() ).as(" result.getSubReasonCode().getSubCode()" ).isEqualTo(0) ;
        softly.assertThat(result.getSubReasonCode().getResourceName() ).as(" result.getSubReasonCode().getResourceName()" ).isEqualTo("ReasonCode_0");
        softly.assertThat(result.getPaymentErrorId() ).as(" result.getPaymentErrorId()" ).isNull();
        softly.assertThat(result.getPaymentErrorDescription() ).as(" result.getPaymentErrorDescription()" ).isNull();
        softly.assertThat(result.getPaymentId() ).as(" result.getPaymentId()" ).isEqualTo("904");
        softly.assertThat(result.getPackageSubscriptionId() ).as(" result.getPackageSubscriptionId()" ).isEqualTo("1248");
        softly.assertThat(result.getPackageSubscriptionIdLong() ).as(" result.getPackageSubscriptionIdLong()" ).isEqualTo(new Long(1248)) ;
        softly.assertThat(result.getTransactionId() ).as(" result.getTransactionId()" ).isEqualTo("904");
        softly.assertThat(result.getTransactionIdLong() ).as(" result.getTransactionIdLong()" ).isEqualTo(new Long(904)) ;
        softly.assertThat(result.getPaymentStatus() ).as(" result.getPaymentStatus()" ).isEqualTo(0) ;
        softly.assertThat(result.getPaymentStatusEnum() ).as(" result.getPaymentStatusEnum()" ).isNull();
// com.vizzavi.ecommerce.business.common.ResponseStatus
        softly.assertThat(result.getStatusEnum().getName() ).as(" result.getStatusEnum().getName()" ).isEqualTo("ACCEPTED");
        softly.assertThat(result.getStatusEnum().getId() ).as(" result.getStatusEnum().getId()" ).isEqualTo(1) ;
        softly.assertThat(result.getStatusEnum().isError() ).as(" result.getStatusEnum().isError()" ).isFalse() ;
        softly.assertThat(result.getStatusEnum().isAccepted() ).as(" result.getStatusEnum().isAccepted()" ).isTrue() ;
        softly.assertThat(result.getStatusEnum().isFailed() ).as(" result.getStatusEnum().isFailed()" ).isFalse() ;
        softly.assertThat(result.getStatusEnum().isRejected() ).as(" result.getStatusEnum().isRejected()" ).isFalse() ;
        softly.assertThat(result.getStatusEnum().isDenied() ).as(" result.getStatusEnum().isDenied()" ).isFalse() ;
        softly.assertThat(result.getTaxAmount() ).as(" result.getTaxAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getAuthorized() ).as(" result.getAuthorized()" ).isTrue() ;
        softly.assertThat(result.getPaymentInfo() ).as(" result.getPaymentInfo()" ).isNull();
        softly.assertThat(result.getReceiptingCreditBalanceImpact() ).as(" result.getReceiptingCreditBalanceImpact()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getReceiptingUsageTypeAttribute() ).as(" result.getReceiptingUsageTypeAttribute()" ).isEqualTo(-1) ;
//check size of array!
        softly.assertThat(result.getSubscriptionIds().length ).as(" result.getSubscriptionIds().length" ).isEqualTo(1) ;
        softly.assertThat(result.isServiceSubmit() ).as(" result.isServiceSubmit()" ).isFalse() ;
// [J
        softly.assertThat(result.getMicroServiceSubList() ).as(" result.getMicroServiceSubList()" ).isNull();
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(result.getReasonCode().getName() ).as(" result.getReasonCode().getName()" ).isEqualTo("OK");
        softly.assertThat(result.getReasonCode().getCode() ).as(" result.getReasonCode().getCode()" ).isEqualTo(0) ;
        softly.assertThat(result.getReasonCode().getSubCode() ).as(" result.getReasonCode().getSubCode()" ).isEqualTo(0) ;
        softly.assertThat(result.getReasonCode().getResourceName() ).as(" result.getReasonCode().getResourceName()" ).isEqualTo("ReasonCode_0");
        softly.assertThat(result.getAuthCode() ).as(" result.getAuthCode()" ).isNull();
        softly.assertThat(result.isValid() ).as(" result.isValid()" ).isFalse() ;
        softly.assertThat(result.getTaxRate() ).as(" result.getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(result.getTaxCode() ).as(" result.getTaxCode()" ).isNull();
        softly.assertThat(result.getRate() ).as(" result.getRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getStandardRate() ).as(" result.getStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getAlternativeTaxCode() ).as(" result.getAlternativeTaxCode()" ).isNull();
        softly.assertThat(result.getAlternativeTaxRate() ).as(" result.getAlternativeTaxRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getAlternativeTaxAmount() ).as(" result.getAlternativeTaxAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getNetRate() ).as(" result.getNetRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.isAlwaysValidateMsisdn() ).as(" result.isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(result.isSuccess() ).as(" result.isSuccess()" ).isTrue() ;
        softly.assertThat(result.getCurrencyId() ).as(" result.getCurrencyId()" ).isEqualTo(826) ;
        softly.assertThat(result.getNetStandardRate() ).as(" result.getNetStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getCustomResourceBalances() ).as(" result.getCustomResourceBalances()" ).isNull();
        softly.assertThat(result.getRatingSystemId() ).as(" result.getRatingSystemId()" ).isNull();
        softly.assertThat(result.getRatingSystemVersion() ).as(" result.getRatingSystemVersion()" ).isNull();
        softly.assertThat(result.isDiscount() ).as(" result.isDiscount()" ).isFalse() ;
        softly.assertThat(result.getDiscountPromoText() ).as(" result.getDiscountPromoText()" ).isNull();
        softly.assertThat(result.isAlternativePaymentMethod() ).as(" result.isAlternativePaymentMethod()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.RatingAttributes
//        softly.assertThat(result.getMatchingAttributes().getChannel() ).as(" result.getMatchingAttributes().getChannel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getMatchingAttributes().getMultiUsageMode() ).as(" result.getMatchingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
//        softly.assertThat(result.getMatchingAttributes().getNetworkCodeMatchMethod() ).as(" result.getMatchingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getMatchingAttributes().isPreRatePriceGross() ).as(" result.getMatchingAttributes().isPreRatePriceGross()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getPreRate() ).as(" result.getMatchingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getMatchingAttributes().getPaymentInformation() ).as(" result.getMatchingAttributes().getPaymentInformation()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getContentName() ).as(" result.getMatchingAttributes().getContentName()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getAssetID() ).as(" result.getMatchingAttributes().getAssetID()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPremiumLevel() ).as(" result.getMatchingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
//        softly.assertThat(result.getMatchingAttributes().getReserveOnlyFlag() ).as(" result.getMatchingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
//        softly.assertThat(result.getMatchingAttributes().getSupplierId() ).as(" result.getMatchingAttributes().getSupplierId()" ).isEqualTo("*");
//        softly.assertThat(result.getMatchingAttributes().getDeviceType() ).as(" result.getMatchingAttributes().getDeviceType()" ).isEqualTo(999) ;
////check size of array!
//        softly.assertThat(result.getMatchingAttributes().getUserGroups().length ).as(" result.getMatchingAttributes().getUserGroups().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getMatchingAttributes().getUserGroup() ).as(" result.getMatchingAttributes().getUserGroup()" ).isEqualTo("*");
//        softly.assertThat(result.getMatchingAttributes().getPaymentType() ).as(" result.getMatchingAttributes().getPaymentType()" ).isEqualTo(10010) ;
//        softly.assertThat(result.getMatchingAttributes().getEventUnits() ).as(" result.getMatchingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
////check size of array!
//        softly.assertThat(result.getMatchingAttributes().getPromoCodes().length ).as(" result.getMatchingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
////check size of array!
//        softly.assertThat(result.getMatchingAttributes().getBearerIds().length ).as(" result.getMatchingAttributes().getBearerIds().length" ).isEqualTo(1) ;
//        softly.assertThat(result.getMatchingAttributes().getPromoCode() ).as(" result.getMatchingAttributes().getPromoCode()" ).isEqualTo("*");
//        softly.assertThat(result.getMatchingAttributes().getDuration() ).as(" result.getMatchingAttributes().getDuration()" ).isEqualTo(999) ;
//        softly.assertThat(result.getMatchingAttributes().getChargingMethod() ).as(" result.getMatchingAttributes().getChargingMethod()" ).isEqualTo(999) ;
//        softly.assertThat(result.getMatchingAttributes().getBearer() ).as(" result.getMatchingAttributes().getBearer()" ).isEqualTo("*");
//        softly.assertThat(result.getMatchingAttributes().isInteractive() ).as(" result.getMatchingAttributes().isInteractive()" ).isTrue() ;
//        softly.assertThat(result.getMatchingAttributes().isIncludeUnavailable() ).as(" result.getMatchingAttributes().isIncludeUnavailable()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getExpressFlag() ).as(" result.getMatchingAttributes().getExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().isExpressFlag() ).as(" result.getMatchingAttributes().isExpressFlag()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().isPreOrder() ).as(" result.getMatchingAttributes().isPreOrder()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().isCancellationUsage() ).as(" result.getMatchingAttributes().isCancellationUsage()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getTierName() ).as(" result.getMatchingAttributes().getTierName()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPromoPrecode() ).as(" result.getMatchingAttributes().getPromoPrecode()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getUniquePromoCode() ).as(" result.getMatchingAttributes().getUniquePromoCode()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPromoUniqueCode() ).as(" result.getMatchingAttributes().getPromoUniqueCode()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getNextCycleDiscount() ).as(" result.getMatchingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
//        softly.assertThat(result.getMatchingAttributes().getHasHistoricPricePointFlag() ).as(" result.getMatchingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().isIsForRenewal() ).as(" result.getMatchingAttributes().isIsForRenewal()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getTaxRate() ).as(" result.getMatchingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getMatchingAttributes().getTaxRateAsDouble() ).as(" result.getMatchingAttributes().getTaxRateAsDouble()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getAffiliateID() ).as(" result.getMatchingAttributes().getAffiliateID()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPartnerId() ).as(" result.getMatchingAttributes().getPartnerId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getTariff() ).as(" result.getMatchingAttributes().getTariff()" ).isEqualTo("*");
//        softly.assertThat(result.getMatchingAttributes().getAggregatorId() ).as(" result.getMatchingAttributes().getAggregatorId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().isForcePurchaseFlow() ).as(" result.getMatchingAttributes().isForcePurchaseFlow()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getReceipientMsisdn() ).as(" result.getMatchingAttributes().getReceipientMsisdn()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getProductCode() ).as(" result.getMatchingAttributes().getProductCode()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getMerchantName() ).as(" result.getMatchingAttributes().getMerchantName()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getInvoiceText() ).as(" result.getMatchingAttributes().getInvoiceText()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().isReIssueEnabled() ).as(" result.getMatchingAttributes().isReIssueEnabled()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().isReIssueFlagPresent() ).as(" result.getMatchingAttributes().isReIssueFlagPresent()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getShortPackageId() ).as(" result.getMatchingAttributes().getShortPackageId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getTaxCode() ).as(" result.getMatchingAttributes().getTaxCode()" ).isEqualTo("*");
//        softly.assertThat(result.getMatchingAttributes().getHistoryStartDate() ).as(" result.getMatchingAttributes().getHistoryStartDate()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getVendorId() ).as(" result.getMatchingAttributes().getVendorId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().isIsForNextPaymentAmount() ).as(" result.getMatchingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getRenewalPreRate() ).as(" result.getMatchingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(result.getMatchingAttributes().isOverrideDisallowPreRateFlag() ).as(" result.getMatchingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getContentCategory() ).as(" result.getMatchingAttributes().getContentCategory()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPartnerUrl() ).as(" result.getMatchingAttributes().getPartnerUrl()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPartnerContactInfo() ).as(" result.getMatchingAttributes().getPartnerContactInfo()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPartnerEmail() ).as(" result.getMatchingAttributes().getPartnerEmail()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPartnerName() ).as(" result.getMatchingAttributes().getPartnerName()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" result.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" result.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
//        softly.assertThat(result.getMatchingAttributes().getLinkedByTrialPricepoint() ).as(" result.getMatchingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getSubRenewalPricepointId() ).as(" result.getMatchingAttributes().getSubRenewalPricepointId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getLinkPricepointId() ).as(" result.getMatchingAttributes().getLinkPricepointId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getSubPurchaseTransactionTrial() ).as(" result.getMatchingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getDiscardHiddenInactivePricepoints() ).as(" result.getMatchingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" result.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(result.getMatchingAttributes().getExtIdentifier1() ).as(" result.getMatchingAttributes().getExtIdentifier1()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getExtIdentifier2() ).as(" result.getMatchingAttributes().getExtIdentifier2()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getExtIdentifier3() ).as(" result.getMatchingAttributes().getExtIdentifier3()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getAccessChannel() ).as(" result.getMatchingAttributes().getAccessChannel()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getPurchaseChannel() ).as(" result.getMatchingAttributes().getPurchaseChannel()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getDeviceID() ).as(" result.getMatchingAttributes().getDeviceID()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getLocal() ).as(" result.getMatchingAttributes().getLocal()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getMsisdn() ).as(" result.getMatchingAttributes().getMsisdn()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getLanguageLocale() ).as(" result.getMatchingAttributes().getLanguageLocale()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getLanguageCode() ).as(" result.getMatchingAttributes().getLanguageCode()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getExternalField1() ).as(" result.getMatchingAttributes().getExternalField1()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getExternalField2() ).as(" result.getMatchingAttributes().getExternalField2()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getExternalTransId() ).as(" result.getMatchingAttributes().getExternalTransId()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getActiveSubscriptions() ).as(" result.getMatchingAttributes().getActiveSubscriptions()" ).isNull();
//        softly.assertThat(result.getMatchingAttributes().getCsrId() ).as(" result.getMatchingAttributes().getCsrId()" ).isNull();
        softly.assertThat(result.getInputAttributes() ).as(" result.getInputAttributes()" ).isNull();
        softly.assertThat(result.getDiscountPercentage() ).as(" result.getDiscountPercentage()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getPackageId() ).as(" result.getPackageId()" ).isEqualTo("*");
        softly.assertThat(result.getContentId() ).as(" result.getContentId()" ).isEqualTo("*");
        softly.assertThat(result.getPricingText1() ).as(" result.getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(result.getPricingText2() ).as(" result.getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(result.getAlternativeCurrencyId() ).as(" result.getAlternativeCurrencyId()" ).isEqualTo(0) ;
        softly.assertThat(result.getAlternativeNetRate() ).as(" result.getAlternativeNetRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getRateIdentifier() ).as(" result.getRateIdentifier()" ).isNull();
        softly.assertThat(result.getRateIdentifiers() ).as(" result.getRateIdentifiers()" ).isNull();
        softly.assertThat(result.getUsageTime() ).as(" result.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getAccessDuration() ).as(" result.getAccessDuration()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(result.getPricePointId() ).as(" result.getPricePointId()" ).isNull();
        softly.assertThat(result.isZeroCostIgnore() ).as(" result.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(result.isUniquePromoCode() ).as(" result.isUniquePromoCode()" ).isFalse() ;
        softly.assertThat(result.getDescription() ).as(" result.getDescription()" ).isNull();
        softly.assertThat(result.getUndiscountedStandardRate() ).as(" result.getUndiscountedStandardRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(result.getTimestamp() ).as(" result.getTimestamp()" ).isNull();

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }

    }

}
