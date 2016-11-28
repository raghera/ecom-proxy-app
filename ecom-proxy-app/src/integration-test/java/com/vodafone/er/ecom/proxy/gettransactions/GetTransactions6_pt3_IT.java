package com.vodafone.er.ecom.proxy.gettransactions;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vodafone.global.er.subscriptionmanagement.TransactionFilterImpl;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class GetTransactions6_pt3_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void getTransactions16() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";
        String serviceId = "sAlt";

        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertTrue(auth.isSuccess());
        String transId1 = auth.getTransactionId();

        final UsageAuthorization uAuth = EcomApiFactory.getChargingApi(Locale.UK).usageAuthRateCharge("test", msisdn, serviceId, new UsageAttributes());
        String transId2 = uAuth.getTransactionId();

        Transaction[] transactions = EcomApiFactory.getSelfcareApi(Locale.UK).getTransactions("test", msisdn, 0, new TransactionFilterImpl());
        assertNotNull(transactions);
        assertEquals(2, transactions.length);

        Transaction purchaseTrans = null;
        Transaction usageTrans = null;

        //purchaseTransaction first
        for (Transaction trans : transactions) {
            if(trans.getTransactionId().equals(transId1)) {
                purchaseTrans = trans;
            }
            if(trans.getTransactionId().equals(transId2)) {
                usageTrans = trans;
            }
        }



        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isMicroService() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isMicroService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSuperPackageIds()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getmExternalServPricePlan()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismRefundable() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismRefundable()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUseRateCard() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUseRateCard()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getInternalPartner() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getInternalPartner()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getRateCardPartners()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPriorityServiceRevenueSharePartner()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricePoint() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricePoint()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getTaxCode() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getTaxCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getDescription()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNotificationCategory()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.internal.PaymentContentImpl
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getKey()" ).isEqualTo(new Long(0)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getCategory()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getDescription()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchant()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getMerchantDescription()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getItemVolume()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getServiceType()" ).isNullOrEmpty();
//        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPaymentContent().getPromotion()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isRefundable() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isRefundable()" ).isTrue() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getPricingModels().length" ).isEqualTo(0) ;
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSalesModel() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getSalesModel()" ).isEqualTo("Reseller");
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReserveOnly() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].isReserveOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceType() ).as(" purchaseTrans.getSubscription().getPackage().getServiceArray()[0].getServiceType()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isEventPackage() ).as(" purchaseTrans.getSubscription().getPackage().isEventPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRecurringPackage() ).as(" purchaseTrans.getSubscription().getPackage().isRecurringPackage()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPackageType() ).as(" purchaseTrans.getSubscription().getPackage().getPackageType()" ).isEqualTo("Calendar");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNonRefundableDescription() ).as(" purchaseTrans.getSubscription().getPackage().getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRefundable() ).as(" purchaseTrans.getSubscription().getPackage().isRefundable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isCalendarPackage() ).as(" purchaseTrans.getSubscription().getPackage().isCalendarPackage()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getProtectedType() ).as(" purchaseTrans.getSubscription().getPackage().getProtectedType()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDynamicProtectedValue() ).as(" purchaseTrans.getSubscription().getPackage().getDynamicProtectedValue()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPurchaseMethod() ).as(" purchaseTrans.getSubscription().getPackage().getPurchaseMethod()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getKpiPackageProductCategory() ).as(" purchaseTrans.getSubscription().getPackage().getKpiPackageProductCategory()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getKpiPackageType() ).as(" purchaseTrans.getSubscription().getPackage().getKpiPackageType()" ).isNullOrEmpty();
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingModels().length ).as(" purchaseTrans.getSubscription().getPackage().getPricingModels().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isExpressPurchase() ).as(" purchaseTrans.getSubscription().getPackage().isExpressPurchase()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRecieptingFlag() ).as(" purchaseTrans.getSubscription().getPackage().isRecieptingFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isPricePointOrder() ).as(" purchaseTrans.getSubscription().getPackage().isPricePointOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isSuperPackage() ).as(" purchaseTrans.getSubscription().getPackage().isSuperPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isRevenueShareByUsage() ).as(" purchaseTrans.getSubscription().getPackage().isRevenueShareByUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDynamicDefault() ).as(" purchaseTrans.getSubscription().getPackage().isDynamicDefault()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getACEPackage() ).as(" purchaseTrans.getSubscription().getPackage().getACEPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUpSell() ).as(" purchaseTrans.getSubscription().getPackage().isUpSell()" ).isFalse() ;
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getLogoId() ).as(" purchaseTrans.getSubscription().getPackage().getLogoId()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPartnerInfo() ).as(" purchaseTrans.getSubscription().getPackage().getPartnerInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getIsPackageModel() ).as(" purchaseTrans.getSubscription().getPackage().getIsPackageModel()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isParentPackage() ).as(" purchaseTrans.getSubscription().getPackage().isParentPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getChildPackages() ).as(" purchaseTrans.getSubscription().getPackage().getChildPackages()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServicesNotInPackageFairUsagePolicyList() ).as(" purchaseTrans.getSubscription().getPackage().getServicesNotInPackageFairUsagePolicyList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasParentSub() ).as(" purchaseTrans.getSubscription().getPackage().isHasParentSub()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getParentSubId() ).as(" purchaseTrans.getSubscription().getPackage().getParentSubId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasParentSubSuspendedResProv() ).as(" purchaseTrans.getSubscription().getPackage().isHasParentSubSuspendedResProv()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getParentSubStatus() ).as(" purchaseTrans.getSubscription().getPackage().getParentSubStatus()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDisallowCancellations() ).as(" purchaseTrans.getSubscription().getPackage().isDisallowCancellations()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getSalesModel() ).as(" purchaseTrans.getSubscription().getPackage().getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPackageClass() ).as(" purchaseTrans.getSubscription().getPackage().getPackageClass()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDataVoiceTariffInclusive() ).as(" purchaseTrans.getSubscription().getPackage().isDataVoiceTariffInclusive()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNominalValue() ).as(" purchaseTrans.getSubscription().getPackage().getNominalValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUseBeingDeprovisionedStatus() ).as(" purchaseTrans.getSubscription().getPackage().isUseBeingDeprovisionedStatus()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDisallowDuplicateSubPurchase() ).as(" purchaseTrans.getSubscription().getPackage().getDisallowDuplicateSubPurchase()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getNoActivePricepoints() ).as(" purchaseTrans.getSubscription().getPackage().getNoActivePricepoints()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasBalanceImpactsWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasBalanceImpactsWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasPricePointsWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasPricePointsWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasPromosWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasPromosWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isHasTaxRateWithDate() ).as(" purchaseTrans.getSubscription().getPackage().isHasTaxRateWithDate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPromoCodeMap() ).as(" purchaseTrans.getSubscription().getPackage().getPromoCodeMap()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPromoCodeMapSize() ).as(" purchaseTrans.getSubscription().getPackage().getPromoCodeMapSize()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getActiveStatusAsString() ).as(" purchaseTrans.getSubscription().getPackage().getActiveStatusAsString()" ).isEqualTo("ACTIVE");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUseRateCardService() ).as(" purchaseTrans.getSubscription().getPackage().isUseRateCardService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getRateCardServiceId() ).as(" purchaseTrans.getSubscription().getPackage().getRateCardServiceId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUserGroupCalendarPricePointPackage() ).as(" purchaseTrans.getSubscription().getPackage().isUserGroupCalendarPricePointPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isUpsellDiscountProrated() ).as(" purchaseTrans.getSubscription().getPackage().isUpsellDiscountProrated()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDisallowPrerate() ).as(" purchaseTrans.getSubscription().getPackage().isDisallowPrerate()" ).isFalse() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getServiceNames().length ).as(" purchaseTrans.getSubscription().getPackage().getServiceNames().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getDefaultPartnerProvisioningId() ).as(" purchaseTrans.getSubscription().getPackage().getDefaultPartnerProvisioningId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getUserGroupComparisonAtRenewal() ).as(" purchaseTrans.getSubscription().getPackage().getUserGroupComparisonAtRenewal()" ).isEqualTo("SYSTEM");
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isActive() ).as(" purchaseTrans.getSubscription().getPackage().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isDefault() ).as(" purchaseTrans.getSubscription().getPackage().isDefault()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isOriginal() ).as(" purchaseTrans.getSubscription().getPackage().isOriginal()" ).isFalse() ;
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPackage().isReserveOnly() ).as(" purchaseTrans.getSubscription().getPackage().isReserveOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackage().getPricingModel() ).as(" purchaseTrans.getSubscription().getPackage().getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getCountry() ).as(" purchaseTrans.getSubscription().getCountry()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isPromotional() ).as(" purchaseTrans.getSubscription().isPromotional()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPromotionalExpiryDate() ).as(" purchaseTrans.getSubscription().getPromotionalExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getStatus() ).as(" purchaseTrans.getSubscription().getStatus()" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getExternalSubId() ).as(" purchaseTrans.getSubscription().getExternalSubId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getOptions() ).as(" purchaseTrans.getSubscription().getOptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPackageId() ).as(" purchaseTrans.getSubscription().getPackageId()" ).isNull();
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getDescription() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isResource() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getId() ).as(" purchaseTrans.getSubscription().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isDiscount() ).as(" purchaseTrans.getSubscription().getPricePoint().isDiscount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDiscountPromoText() ).as(" purchaseTrans.getSubscription().getPricePoint().getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPackageId() ).as(" purchaseTrans.getSubscription().getPricePoint().getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getContentId() ).as(" purchaseTrans.getSubscription().getPricePoint().getContentId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingText1() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingText2() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUsageTime() ).as(" purchaseTrans.getSubscription().getPricePoint().getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAccessDuration() ).as(" purchaseTrans.getSubscription().getPricePoint().getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getCustomResourceBalances() ).as(" purchaseTrans.getSubscription().getPricePoint().getCustomResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPreOrder() ).as(" purchaseTrans.getSubscription().getPricePoint().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTaxRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTaxCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDescription() ).as(" purchaseTrans.getSubscription().getPricePoint().getDescription()" ).isEqualTo("Recurring 7 day");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getStandardRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExpiryDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isZeroCostIgnore() ).as(" purchaseTrans.getSubscription().getPricePoint().isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceBalances() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingModelTier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingModelTier()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isArchived() ).as(" purchaseTrans.getSubscription().getPricePoint().isArchived()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isBasePricePoint() ).as(" purchaseTrans.getSubscription().getPricePoint().isBasePricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getStartDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isActive() ).as(" purchaseTrans.getSubscription().getPricePoint().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPackageIdentifier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*_*_false_false_*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getServiceIdentifier() ).as(" purchaseTrans.getSubscription().getPricePoint().getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_*_999_999_*_999_999");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isTrial() ).as(" purchaseTrans.getSubscription().getPricePoint().isTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAccessDevice() ).as(" purchaseTrans.getSubscription().getPricePoint().getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAlternativeRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getAlternativeRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isAlignWithExternal() ).as(" purchaseTrans.getSubscription().getPricePoint().isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getGracePeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getGracePeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRetryFrequency() ).as(" purchaseTrans.getSubscription().getPricePoint().getRetryFrequency()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSuspensionPeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getSuspensionPeriod()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined() ).as(" purchaseTrans.getSubscription().getPricePoint().isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText() ).as(" purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFairUsageLimit() ).as(" purchaseTrans.getSubscription().getPricePoint().getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isVolumeType() ).as(" purchaseTrans.getSubscription().getPricePoint().isVolumeType()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isOriginal() ).as(" purchaseTrans.getSubscription().getPricePoint().isOriginal()" ).isFalse() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers().length ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getTier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBalances() ).as(" purchaseTrans.getSubscription().getPricePoint().getBalances()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isRecurring() ).as(" purchaseTrans.getSubscription().getPricePoint().isRecurring()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getKey()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPrice()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPricingModel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPricingModel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getTier() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getTier()" ).isEqualTo("default");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().isDefaultPPT()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricePointTier().getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMonthEndSubscription() ).as(" purchaseTrans.getSubscription().getPricePoint().getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isHistoric() ).as(" purchaseTrans.getSubscription().getPricePoint().isHistoric()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFixedRecurrence() ).as(" purchaseTrans.getSubscription().getPricePoint().getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isFixedRecurringPricePoint() ).as(" purchaseTrans.getSubscription().getPricePoint().isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReceipting() ).as(" purchaseTrans.getSubscription().getPricePoint().isReceipting()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getReceiptingAttribute() ).as(" purchaseTrans.getSubscription().getPricePoint().getReceiptingAttribute()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getOrder() ).as(" purchaseTrans.getSubscription().getPricePoint().getOrder()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPaymentHandler() ).as(" purchaseTrans.getSubscription().getPricePoint().getPaymentHandler()" ).isEqualTo("NULL");
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNonMatchAllUserGroups().length ).as(" purchaseTrans.getSubscription().getPricePoint().getNonMatchAllUserGroups().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPromo() ).as(" purchaseTrans.getSubscription().getPricePoint().isPromo()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isSubmitToPaymentHandler() ).as(" purchaseTrans.getSubscription().getPricePoint().isSubmitToPaymentHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isSuppressToPaymentHandler() ).as(" purchaseTrans.getSubscription().getPricePoint().isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName1() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName2() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText1() ).as(" purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText2() ).as(" purchaseTrans.getSubscription().getPricePoint().getTranslatedPricingText2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRecurrenceDay() ).as(" purchaseTrans.getSubscription().getPricePoint().getRecurrenceDay()" ).isEqualTo(-1) ;
// java.util.HashMap
// java.util.HashMap
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBalanceImpacts().length ).as(" purchaseTrans.getSubscription().getPricePoint().getBalanceImpacts().length" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getGlid() ).as(" purchaseTrans.getSubscription().getPricePoint().getGlid()" ).isNullOrEmpty();
// java.util.HashMap
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPricepointIdLink() ).as(" purchaseTrans.getSubscription().getPricePoint().getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPreview() ).as(" purchaseTrans.getSubscription().getPricePoint().isPreview()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getInteractiveFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isForcedPurchase() ).as(" purchaseTrans.getSubscription().getPricePoint().isForcedPurchase()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isSubscriptionDuplicate() ).as(" purchaseTrans.getSubscription().getPricePoint().isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFixedExpiryDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getFixedExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReserveOnly() ).as(" purchaseTrans.getSubscription().getPricePoint().isReserveOnly()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMinSubPeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPenaltyCharges() ).as(" purchaseTrans.getSubscription().getPricePoint().getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getCancellation() ).as(" purchaseTrans.getSubscription().getPricePoint().getCancellation()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getProtectedFk() ).as(" purchaseTrans.getSubscription().getPricePoint().getProtectedFk()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getmPricingText1() ).as(" purchaseTrans.getSubscription().getPricePoint().getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getmPricingText2() ).as(" purchaseTrans.getSubscription().getPricePoint().getmPricingText2()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isNonRecurring() ).as(" purchaseTrans.getSubscription().getPricePoint().isNonRecurring()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isEvent() ).as(" purchaseTrans.getSubscription().getPricePoint().isEvent()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isUsageToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isPayToken() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getDescription() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getCountryId() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isResource() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().isCurrency() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceName() ).as(" purchaseTrans.getSubscription().getPricePoint().getResourceField().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getStandardRateWithoutTax() ).as(" purchaseTrans.getSubscription().getPricePoint().getStandardRateWithoutTax()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriodUnit() ).as(" purchaseTrans.getSubscription().getPricePoint().getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtensionPeriod() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIncludeServiceForPackageFUP() ).as(" purchaseTrans.getSubscription().getPricePoint().isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isFairUsagePolicyEnabled() ).as(" purchaseTrans.getSubscription().getPricePoint().isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isTariff() ).as(" purchaseTrans.getSubscription().getPricePoint().isTariff()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isHideForPurchaseOptions() ).as(" purchaseTrans.getSubscription().getPricePoint().isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.Tax
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getName() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getName()" ).isEqualTo("TAX");
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getKey() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getKey()" ).isNull();
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getTaxRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getTaxRate()" ).isEqualTo(new Double(0.175)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTax().getTaxCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getTax().getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNetRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getNetRate()" ).isEqualTo(new Double(10.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isAlwaysValidateMsisdn() ).as(" purchaseTrans.getSubscription().getPricePoint().isAlwaysValidateMsisdn()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getChannel() ).as(" purchaseTrans.getSubscription().getPricePoint().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMultiUsageMode() ).as(" purchaseTrans.getSubscription().getPricePoint().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getSubscription().getPricePoint().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isPreRatePriceGross() ).as(" purchaseTrans.getSubscription().getPricePoint().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPreRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPaymentInformation() ).as(" purchaseTrans.getSubscription().getPricePoint().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getContentName() ).as(" purchaseTrans.getSubscription().getPricePoint().getContentName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAssetID() ).as(" purchaseTrans.getSubscription().getPricePoint().getAssetID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPremiumLevel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getReserveOnlyFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSupplierId() ).as(" purchaseTrans.getSubscription().getPricePoint().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDeviceType() ).as(" purchaseTrans.getSubscription().getPricePoint().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUserGroups().length ).as(" purchaseTrans.getSubscription().getPricePoint().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUserGroup() ).as(" purchaseTrans.getSubscription().getPricePoint().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPaymentType() ).as(" purchaseTrans.getSubscription().getPricePoint().getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getEventDateTime() ).as(" purchaseTrans.getSubscription().getPricePoint().getEventDateTime()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getEventUnits() ).as(" purchaseTrans.getSubscription().getPricePoint().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoCodes().length ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBearerIds().length ).as(" purchaseTrans.getSubscription().getPricePoint().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDuration() ).as(" purchaseTrans.getSubscription().getPricePoint().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getChargingMethod() ).as(" purchaseTrans.getSubscription().getPricePoint().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getBearer() ).as(" purchaseTrans.getSubscription().getPricePoint().getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isInteractive() ).as(" purchaseTrans.getSubscription().getPricePoint().isInteractive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIncludeUnavailable() ).as(" purchaseTrans.getSubscription().getPricePoint().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExpressFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isExpressFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().isExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isCancellationUsage() ).as(" purchaseTrans.getSubscription().getPricePoint().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTierName() ).as(" purchaseTrans.getSubscription().getPricePoint().getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoPrecode() ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getUniquePromoCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getUniquePromoCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPromoUniqueCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getNextCycleDiscount() ).as(" purchaseTrans.getSubscription().getPricePoint().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getHasHistoricPricePointFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIsForRenewal() ).as(" purchaseTrans.getSubscription().getPricePoint().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTaxRateAsDouble() ).as(" purchaseTrans.getSubscription().getPricePoint().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAffiliateID() ).as(" purchaseTrans.getSubscription().getPricePoint().getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getTariff() ).as(" purchaseTrans.getSubscription().getPricePoint().getTariff()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAggregatorId() ).as(" purchaseTrans.getSubscription().getPricePoint().getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isForcePurchaseFlow() ).as(" purchaseTrans.getSubscription().getPricePoint().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getReceipientMsisdn() ).as(" purchaseTrans.getSubscription().getPricePoint().getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getProductCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMerchantName() ).as(" purchaseTrans.getSubscription().getPricePoint().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getInvoiceText() ).as(" purchaseTrans.getSubscription().getPricePoint().getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReIssueEnabled() ).as(" purchaseTrans.getSubscription().getPricePoint().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isReIssueFlagPresent() ).as(" purchaseTrans.getSubscription().getPricePoint().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getShortPackageId() ).as(" purchaseTrans.getSubscription().getPricePoint().getShortPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getHistoryStartDate() ).as(" purchaseTrans.getSubscription().getPricePoint().getHistoryStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getVendorId() ).as(" purchaseTrans.getSubscription().getPricePoint().getVendorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isIsForNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getPricePoint().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getPricePoint().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag() ).as(" purchaseTrans.getSubscription().getPricePoint().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getContentCategory() ).as(" purchaseTrans.getSubscription().getPricePoint().getContentCategory()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerUrl() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerContactInfo() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerContactInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerEmail() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerEmail()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerName() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getPricePoint().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSubRenewalPricepointId() ).as(" purchaseTrans.getSubscription().getPricePoint().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLinkPricepointId() ).as(" purchaseTrans.getSubscription().getPricePoint().getLinkPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getSubPurchaseTransactionTrial() ).as(" purchaseTrans.getSubscription().getPricePoint().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints() ).as(" purchaseTrans.getSubscription().getPricePoint().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints() ).as(" purchaseTrans.getSubscription().getPricePoint().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getPricePoint().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPartnerId() ).as(" purchaseTrans.getSubscription().getPricePoint().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getAccessChannel() ).as(" purchaseTrans.getSubscription().getPricePoint().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getPurchaseChannel() ).as(" purchaseTrans.getSubscription().getPricePoint().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getDeviceID() ).as(" purchaseTrans.getSubscription().getPricePoint().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLocal() ).as(" purchaseTrans.getSubscription().getPricePoint().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getMsisdn() ).as(" purchaseTrans.getSubscription().getPricePoint().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLanguageCode() ).as(" purchaseTrans.getSubscription().getPricePoint().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getActiveSubscriptions() ).as(" purchaseTrans.getSubscription().getPricePoint().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getCsrId() ).as(" purchaseTrans.getSubscription().getPricePoint().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExternalField1() ).as(" purchaseTrans.getSubscription().getPricePoint().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExternalField2() ).as(" purchaseTrans.getSubscription().getPricePoint().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getExternalTransId() ).as(" purchaseTrans.getSubscription().getPricePoint().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPricePoint().getLanguageLocale() ).as(" purchaseTrans.getSubscription().getPricePoint().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPaymentType() ).as(" purchaseTrans.getSubscription().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getSubscription().getMerchantName() ).as(" purchaseTrans.getSubscription().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getMsisdn() ).as(" purchaseTrans.getSubscription().getMsisdn()" ).isNotNull();
        softly.assertThat(purchaseTrans.getSubscription().getCsrId() ).as(" purchaseTrans.getSubscription().getCsrId()" ).isEqualTo("test");
        softly.assertThat(purchaseTrans.getSubscription().getSubscriptionId() ).as(" purchaseTrans.getSubscription().getSubscriptionId()" ).isNotEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getAccount() ).as(" purchaseTrans.getSubscription().getAccount()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isInactiveOrClosed() ).as(" purchaseTrans.getSubscription().isInactiveOrClosed()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isFailed() ).as(" purchaseTrans.getSubscription().isFailed()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isBeingProvisioned() ).as(" purchaseTrans.getSubscription().isBeingProvisioned()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isReserved() ).as(" purchaseTrans.getSubscription().isReserved()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getLinkedPtID() ).as(" purchaseTrans.getSubscription().getLinkedPtID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isPreOrdered() ).as(" purchaseTrans.getSubscription().isPreOrdered()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getContentPaymentType() ).as(" purchaseTrans.getSubscription().getContentPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getSubscription().getPurchaseDeviceType() ).as(" purchaseTrans.getSubscription().getPurchaseDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getNextCyclePercentDiscount() ).as(" purchaseTrans.getSubscription().getNextCyclePercentDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getNextPaymentAmount()" ).isEqualTo(new Double(10.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getServiceIds().length ).as(" purchaseTrans.getSubscription().getServiceIds().length" ).isEqualTo(1) ;
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getChannel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getChannel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getMultiUsageMode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isPreRatePriceGross() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPreRate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPaymentInformation() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getContentName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getContentName()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAssetID() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAssetID()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPremiumLevel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getReserveOnlyFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSupplierId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSupplierId()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDeviceType() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getUserGroups().length ).as(" purchaseTrans.getSubscription().getRatingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getUserGroup() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getUserGroup()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPaymentType() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getEventDateTime() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getEventDateTime()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getEventUnits() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoCodes().length ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getBearerIds().length ).as(" purchaseTrans.getSubscription().getRatingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDuration() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDuration()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getChargingMethod() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getChargingMethod()" ).isEqualTo(3) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getBearer() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isInteractive() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isIncludeUnavailable() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExpressFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isExpressFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isPreOrder() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isCancellationUsage() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTierName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTierName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoPrecode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getUniquePromoCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPromoUniqueCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getNextCycleDiscount() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isIsForRenewal() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTaxRate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTaxRateAsDouble() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAffiliateID() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTariff() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAggregatorId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isForcePurchaseFlow() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getReceipientMsisdn() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getProductCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getProductCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getMerchantName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getInvoiceText() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isReIssueEnabled() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isReIssueFlagPresent() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getShortPackageId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getTaxCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getHistoryStartDate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getVendorId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getVendorId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isIsForNextPaymentAmount() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getRenewalPreRate() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getContentCategory() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerUrl() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerContactInfo() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerEmail() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerName() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalPricepointId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLinkPricepointId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" purchaseTrans.getSubscription().getRatingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier1() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier2() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier3() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPartnerId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getAccessChannel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getPurchaseChannel() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getDeviceID() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLocal() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLocal()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getMsisdn() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLanguageCode() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getActiveSubscriptions() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getCsrId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getCsrId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExternalField1() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExternalField2() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getExternalTransId() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRatingAttributes().getLanguageLocale() ).as(" purchaseTrans.getSubscription().getRatingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPaymentTransactionId() ).as(" purchaseTrans.getSubscription().getPaymentTransactionId()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getSubscription().getNonRefundDescription() ).as(" purchaseTrans.getSubscription().getNonRefundDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getInteractiveUsageFlag() ).as(" purchaseTrans.getSubscription().getInteractiveUsageFlag()" ).isEqualTo(2) ;
        softly.assertThat(purchaseTrans.getSubscription().isFirstUsage() ).as(" purchaseTrans.getSubscription().isFirstUsage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isSubscriptionUsed() ).as(" purchaseTrans.getSubscription().isSubscriptionUsed()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getCurrentNoOfOccurences() ).as(" purchaseTrans.getSubscription().getCurrentNoOfOccurences()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPenaltyCharge() ).as(" purchaseTrans.getSubscription().getPenaltyCharge()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().isMinSubscriptionPeriodElapsed() ).as(" purchaseTrans.getSubscription().isMinSubscriptionPeriodElapsed()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().isUnderGracePeriod() ).as(" purchaseTrans.getSubscription().isUnderGracePeriod()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getBatchRetryDate() ).as(" purchaseTrans.getSubscription().getBatchRetryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getOverdueExpiryDate() ).as(" purchaseTrans.getSubscription().getOverdueExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getLastExpiryDate() ).as(" purchaseTrans.getSubscription().getLastExpiryDate()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isWasRecurringTrial() ).as(" purchaseTrans.getSubscription().isWasRecurringTrial()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getParentPackageID() ).as(" purchaseTrans.getSubscription().getParentPackageID()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPreviousStatus() ).as(" purchaseTrans.getSubscription().getPreviousStatus()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().isParentAlsoPurchased() ).as(" purchaseTrans.getSubscription().isParentAlsoPurchased()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isProvisionOnUsageSuccess() ).as(" purchaseTrans.getSubscription().isProvisionOnUsageSuccess()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getLastUsageTransactionIdForSameContent() ).as(" purchaseTrans.getSubscription().getLastUsageTransactionIdForSameContent()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getSpId() ).as(" purchaseTrans.getSubscription().getSpId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getPartnerTaxRate() ).as(" purchaseTrans.getSubscription().getPartnerTaxRate()" ).isEqualTo(new Double(-1.0)) ;
//        softly.assertThat(purchaseTrans.getSubscription().getCountryId() ).as(" purchaseTrans.getSubscription().getCountryId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isWasRecurringPromoCode() ).as(" purchaseTrans.getSubscription().isWasRecurringPromoCode()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getLastPaymentTransaction() ).as(" purchaseTrans.getSubscription().getLastPaymentTransaction()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getB2BPartner() ).as(" purchaseTrans.getSubscription().getB2BPartner()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getRenewalCounterToLinkedPricepoint() ).as(" purchaseTrans.getSubscription().getRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().isRenewalPreRateGross() ).as(" purchaseTrans.getSubscription().isRenewalPreRateGross()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getNextPricePointId() ).as(" purchaseTrans.getSubscription().getNextPricePointId()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getSubscription().getLastPaymentTransactionAmount() ).as(" purchaseTrans.getSubscription().getLastPaymentTransactionAmount()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSubscription().getLastToLastPaymentTransactionAmount() ).as(" purchaseTrans.getSubscription().getLastToLastPaymentTransactionAmount()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().isPricePointChangeOnRenewal() ).as(" purchaseTrans.getSubscription().isPricePointChangeOnRenewal()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getOldSubscriptionId() ).as(" purchaseTrans.getSubscription().getOldSubscriptionId()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getOldMsisdn() ).as(" purchaseTrans.getSubscription().getOldMsisdn()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isProvisionable() ).as(" purchaseTrans.getSubscription().isProvisionable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getFuturePricePointRenewals() ).as(" purchaseTrans.getSubscription().getFuturePricePointRenewals()" ).isEqualTo(-1) ;
        softly.assertThat(purchaseTrans.getSubscription().getNextCyclePercentValue() ).as(" purchaseTrans.getSubscription().getNextCyclePercentValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getLockId() ).as(" purchaseTrans.getSubscription().getLockId()" ).isEqualTo(new Long(1)) ;
        softly.assertThat(purchaseTrans.getSubscription().getPartnerId() ).as(" purchaseTrans.getSubscription().getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getSubscriptionIdLong() ).as(" purchaseTrans.getSubscription().getSubscriptionIdLong()" ).isNotNull() ;
//check size of array!
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances().length ).as(" purchaseTrans.getSubscription().getResourceBalances().length" ).isEqualTo(1) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getName() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getName()" ).isEqualTo("SINGLE_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isToken() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isUsageToken() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isPayToken() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceSymbol() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCode() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCode()" ).isEqualTo(1100035) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getDescription() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getDescription()" ).isEqualTo("MULTIPLE_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCountryId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isResource() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isResource()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isCurrency() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().isCurrency()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceName() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_1100035");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getThreshold() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getPackageId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getPackageId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionId()" ).isEqualTo("8470");
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getOldestSubscriptionId() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getSubscription() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getSubscription()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getBalance() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionIdLong() ).as(" purchaseTrans.getSubscription().getResourceBalances()[0].getSubscriptionIdLong()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getSubscription().isRefundable() ).as(" purchaseTrans.getSubscription().isRefundable()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isSuperPackage() ).as(" purchaseTrans.getSubscription().isSuperPackage()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().getPackageClass() ).as(" purchaseTrans.getSubscription().getPackageClass()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isArchived() ).as(" purchaseTrans.getSubscription().isArchived()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isActive() ).as(" purchaseTrans.getSubscription().isActive()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().isDefault() ).as(" purchaseTrans.getSubscription().isDefault()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscription().isRecurring() ).as(" purchaseTrans.getSubscription().isRecurring()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getSubscription().getExtensionPeriod() ).as(" purchaseTrans.getSubscription().getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubscription().getMicroServiceSubList() ).as(" purchaseTrans.getSubscription().getMicroServiceSubList()" ).isNull();
        softly.assertThat(purchaseTrans.getSubscription().isSuspended() ).as(" purchaseTrans.getSubscription().isSuspended()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getDescription() ).as(" purchaseTrans.getDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.getStandardRate() ).as(" purchaseTrans.getStandardRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getSpId() ).as(" purchaseTrans.getSpId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getChargingResource().getName() ).as(" purchaseTrans.getChargingResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getChargingResource().isToken() ).as(" purchaseTrans.getChargingResource().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().isUsageToken() ).as(" purchaseTrans.getChargingResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().isPayToken() ).as(" purchaseTrans.getChargingResource().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().getResourceSymbol() ).as(" purchaseTrans.getChargingResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getChargingResource().getCode() ).as(" purchaseTrans.getChargingResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getChargingResource().getDescription() ).as(" purchaseTrans.getChargingResource().getDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getChargingResource().getCountryId() ).as(" purchaseTrans.getChargingResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getChargingResource().isResource() ).as(" purchaseTrans.getChargingResource().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getChargingResource().isCurrency() ).as(" purchaseTrans.getChargingResource().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getChargingResource().getResourceName() ).as(" purchaseTrans.getChargingResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getParentTransactionIdLong() ).as(" purchaseTrans.getParentTransactionIdLong()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(purchaseTrans.getReIssue() ).as(" purchaseTrans.getReIssue()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getLocalPurchaseDate() ).as(" purchaseTrans.getLocalPurchaseDate()" ).isNull();
        softly.assertThat(purchaseTrans.getLocalPurchaseDateCal() ).as(" purchaseTrans.getLocalPurchaseDateCal()" ).isNull();
        softly.assertThat(purchaseTrans.getPurchaseRate() ).as(" purchaseTrans.getPurchaseRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(purchaseTrans.getPurchaseNetRate() ).as(" purchaseTrans.getPurchaseNetRate()" ).isEqualTo(new Double(10.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getName() ).as(" purchaseTrans.getPurchaseCurrency().getName()" ).isEqualTo("GBP");
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isToken() ).as(" purchaseTrans.getPurchaseCurrency().isToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isUsageToken() ).as(" purchaseTrans.getPurchaseCurrency().isUsageToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isPayToken() ).as(" purchaseTrans.getPurchaseCurrency().isPayToken()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getResourceSymbol() ).as(" purchaseTrans.getPurchaseCurrency().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getCode() ).as(" purchaseTrans.getPurchaseCurrency().getCode()" ).isEqualTo(826) ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getDescription() ).as(" purchaseTrans.getPurchaseCurrency().getDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getCountryId() ).as(" purchaseTrans.getPurchaseCurrency().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isResource() ).as(" purchaseTrans.getPurchaseCurrency().isResource()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().isCurrency() ).as(" purchaseTrans.getPurchaseCurrency().isCurrency()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getPurchaseCurrency().getResourceName() ).as(" purchaseTrans.getPurchaseCurrency().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(purchaseTrans.getNextCycleDiscountPercent() ).as(" purchaseTrans.getNextCycleDiscountPercent()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getRefundEnlargementDate() ).as(" purchaseTrans.getRefundEnlargementDate()" ).isNull();
        softly.assertThat(purchaseTrans.getRefundPaymentTransactionId() ).as(" purchaseTrans.getRefundPaymentTransactionId()" ).isNull();
        softly.assertThat(purchaseTrans.getRefundPaymentTransactionIdLong() ).as(" purchaseTrans.getRefundPaymentTransactionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getRefundable() ).as(" purchaseTrans.getRefundable()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getModificationInfo() ).as(" purchaseTrans.getModificationInfo()" ).isNull();
        softly.assertThat(purchaseTrans.getClientId() ).as(" purchaseTrans.getClientId()" ).isEqualTo("test");
        softly.assertThat(purchaseTrans.getNextCycleDiscountValue() ).as(" purchaseTrans.getNextCycleDiscountValue()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(purchaseTrans.getContentDescription() ).as(" purchaseTrans.getContentDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getAssetId() ).as(" purchaseTrans.getAssetId()" ).isNull();
        softly.assertThat(purchaseTrans.getBalanceImpact() ).as(" purchaseTrans.getBalanceImpact()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.getSubRecords() ).as(" purchaseTrans.getSubRecords()" ).isNull();
        softly.assertThat(purchaseTrans.getDeviceId() ).as(" purchaseTrans.getDeviceId()" ).isNull();
        softly.assertThat(purchaseTrans.getSuitabilityDecision() ).as(" purchaseTrans.getSuitabilityDecision()" ).isEqualTo(0) ;
        softly.assertThat(purchaseTrans.isContainsReIssueService() ).as(" purchaseTrans.isContainsReIssueService()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getIsPrepay() ).as(" purchaseTrans.getIsPrepay()" ).isNull();
        softly.assertThat(purchaseTrans.getModifyTransactionId() ).as(" purchaseTrans.getModifyTransactionId()" ).isNull();
        softly.assertThat(purchaseTrans.getChildSpId() ).as(" purchaseTrans.getChildSpId()" ).isNull();
        softly.assertThat(purchaseTrans.getSpType() ).as(" purchaseTrans.getSpType()" ).isNull();
        softly.assertThat(purchaseTrans.isRefundTransaction() ).as(" purchaseTrans.isRefundTransaction()" ).isFalse() ;
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(purchaseTrans.getTransactionIdLong() ).as(" purchaseTrans.getTransactionIdLong()" ).isNotNull() ;
        softly.assertThat(purchaseTrans.getParentTransactionId() ).as(" purchaseTrans.getParentTransactionId()" ).isNull();
        softly.assertThat(purchaseTrans.getExternalField1() ).as(" purchaseTrans.getExternalField1()" ).isNull();
        softly.assertThat(purchaseTrans.getExternalField2() ).as(" purchaseTrans.getExternalField2()" ).isNull();
        softly.assertThat(purchaseTrans.getExternalTransId() ).as(" purchaseTrans.getExternalTransId()" ).isNull();
        softly.assertThat(purchaseTrans.getPartnerId() ).as(" purchaseTrans.getPartnerId()" ).isNull();
        softly.assertThat(purchaseTrans.isZeroCostIgnore() ).as(" purchaseTrans.isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(purchaseTrans.getSubscriptionIdLong() ).as(" purchaseTrans.getSubscriptionIdLong()" ).isNotNull() ;
//check size of array!
//        softly.assertThat(purchaseTrans.getResourceBalances().length ).as(" purchaseTrans.getResourceBalances().length" ).isEqualTo(1) ;
//// com.vizzavi.ecommerce.business.common.ChargingResource
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getName() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getName()" ).isEqualTo("GBP");
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isToken() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isToken()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isUsageToken() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isUsageToken()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isPayToken() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isPayToken()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getResourceSymbol() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getCode() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getCode()" ).isEqualTo(826) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getDescription() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getDescription()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getCountryId() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isResource() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isResource()" ).isFalse() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().isCurrency() ).as(" purchaseTrans.getResourceBalances()[0].getResource().isCurrency()" ).isTrue() ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getResource().getResourceName() ).as(" purchaseTrans.getResourceBalances()[0].getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getThreshold() ).as(" purchaseTrans.getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getPackageId() ).as(" purchaseTrans.getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getSubscriptionId() ).as(" purchaseTrans.getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getOldestSubscriptionId() ).as(" purchaseTrans.getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getSubscription() ).as(" purchaseTrans.getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getBalance() ).as(" purchaseTrans.getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(purchaseTrans.getResourceBalances()[0].getSubscriptionIdLong() ).as(" purchaseTrans.getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
        softly.assertThat(purchaseTrans.getAuthCode() ).as(" purchaseTrans.getAuthCode()" ).isNotEmpty();
        softly.assertThat(purchaseTrans.getNonRefundableDescription() ).as(" purchaseTrans.getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(purchaseTrans.isRefundable() ).as(" purchaseTrans.isRefundable()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getAccessDevice() ).as(" purchaseTrans.getAccessDevice()" ).isEqualTo(999) ;
        softly.assertThat(purchaseTrans.isSuccess() ).as(" purchaseTrans.isSuccess()" ).isTrue() ;
        softly.assertThat(purchaseTrans.getTransactionId() ).as(" purchaseTrans.getTransactionId()" ).isNotEmpty();
        softly.assertThat(purchaseTrans.getPaymentErrorId() ).as(" purchaseTrans.getPaymentErrorId()" ).isEqualTo("OK");
        softly.assertThat(purchaseTrans.getPaymentErrorDescription() ).as(" purchaseTrans.getPaymentErrorDescription()" ).isNull();
        softly.assertThat(purchaseTrans.getPaymentStatus() ).as(" purchaseTrans.getPaymentStatus()" ).isEqualTo(101) ;
        softly.assertThat(purchaseTrans.getTaxAmount() ).as(" purchaseTrans.getTaxAmount()" ).isEqualTo(new Double(1.75)) ;
        softly.assertThat(purchaseTrans.getPaymentInfo() ).as(" purchaseTrans.getPaymentInfo()" ).isEqualTo("This is payment info from Pay Auth handler");
        softly.assertThat(purchaseTrans.getReason() ).as(" purchaseTrans.getReason()" ).isNull();
// com.vizzavi.ecommerce.business.selfcare.TransactionType
        softly.assertThat(usageTrans.getType().getType() ).as(" usageTrans.getType().getType()" ).isEqualTo("PAYMENT_CONTENT_TRANSACTION");
// com.vizzavi.ecommerce.business.selfcare.Transaction$MetaType
        softly.assertThat(usageTrans.getType().isPaymentContent() ).as(" usageTrans.getType().isPaymentContent()" ).isTrue() ;
        softly.assertThat(usageTrans.getType().isRefundCash() ).as(" usageTrans.getType().isRefundCash()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRefundDiscount() ).as(" usageTrans.getType().isRefundDiscount()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRefundEnlargement() ).as(" usageTrans.getType().isRefundEnlargement()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRefundNonCash() ).as(" usageTrans.getType().isRefundNonCash()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRefund() ).as(" usageTrans.getType().isRefund()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isPackagePayment() ).as(" usageTrans.getType().isPackagePayment()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isNewPackagePayment() ).as(" usageTrans.getType().isNewPackagePayment()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isSubscription() ).as(" usageTrans.getType().isSubscription()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModification() ).as(" usageTrans.getType().isModification()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRecurringPayment() ).as(" usageTrans.getType().isRecurringPayment()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRenewalPayment() ).as(" usageTrans.getType().isRenewalPayment()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isRecurOrRenew() ).as(" usageTrans.getType().isRecurOrRenew()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isDunningTransaction() ).as(" usageTrans.getType().isDunningTransaction()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isCreditRefundTransaction() ).as(" usageTrans.getType().isCreditRefundTransaction()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isAccountModification() ).as(" usageTrans.getType().isAccountModification()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifyMsisdn() ).as(" usageTrans.getType().isModifyMsisdn()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifyInactivateSubscription() ).as(" usageTrans.getType().isModifyInactivateSubscription()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifyChargingMethod() ).as(" usageTrans.getType().isModifyChargingMethod()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifySubscription() ).as(" usageTrans.getType().isModifySubscription()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifyUserGroups() ).as(" usageTrans.getType().isModifyUserGroups()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifyBAN() ).as(" usageTrans.getType().isModifyBAN()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isModifyInactivateSubPromoCode() ).as(" usageTrans.getType().isModifyInactivateSubPromoCode()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().isGoodwillCredit() ).as(" usageTrans.getType().isGoodwillCredit()" ).isFalse() ;
        softly.assertThat(usageTrans.getType().getResourceName() ).as(" usageTrans.getType().getResourceName()" ).isEqualTo("PAYMENT_CONTENT_TRANSACTION");
        softly.assertThat(usageTrans.getStatus() ).as(" usageTrans.getStatus()" ).isEqualTo(101) ;
        softly.assertThat(usageTrans.getServiceId() ).as(" usageTrans.getServiceId()" ).isEqualTo("sAlt");
// com.vodafone.global.er.subscriptionmanagement.ERRatingAttributes
        softly.assertThat(usageTrans.getMatchingAttributes().getChannel() ).as(" usageTrans.getMatchingAttributes().getChannel()" ).isEqualTo(998) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getMultiUsageMode() ).as(" usageTrans.getMatchingAttributes().getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getNetworkCodeMatchMethod() ).as(" usageTrans.getMatchingAttributes().getNetworkCodeMatchMethod()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getMatchingAttributes().isPreRatePriceGross() ).as(" usageTrans.getMatchingAttributes().isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getPreRate() ).as(" usageTrans.getMatchingAttributes().getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getPaymentInformation() ).as(" usageTrans.getMatchingAttributes().getPaymentInformation()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getContentName() ).as(" usageTrans.getMatchingAttributes().getContentName()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getMatchingAttributes().getAssetID() ).as(" usageTrans.getMatchingAttributes().getAssetID()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getMatchingAttributes().getPremiumLevel() ).as(" usageTrans.getMatchingAttributes().getPremiumLevel()" ).isEqualTo(998) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getReserveOnlyFlag() ).as(" usageTrans.getMatchingAttributes().getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getSupplierId() ).as(" usageTrans.getMatchingAttributes().getSupplierId()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getMatchingAttributes().getDeviceType() ).as(" usageTrans.getMatchingAttributes().getDeviceType()" ).isEqualTo(999) ;
//check size of array!
        softly.assertThat(usageTrans.getMatchingAttributes().getUserGroups().length ).as(" usageTrans.getMatchingAttributes().getUserGroups().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getUserGroup() ).as(" usageTrans.getMatchingAttributes().getUserGroup()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPaymentType() ).as(" usageTrans.getMatchingAttributes().getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getEventUnits() ).as(" usageTrans.getMatchingAttributes().getEventUnits()" ).isEqualTo(new Double(0.0)) ;
//check size of array!
        softly.assertThat(usageTrans.getMatchingAttributes().getPromoCodes().length ).as(" usageTrans.getMatchingAttributes().getPromoCodes().length" ).isEqualTo(1) ;
//check size of array!
        softly.assertThat(usageTrans.getMatchingAttributes().getBearerIds().length ).as(" usageTrans.getMatchingAttributes().getBearerIds().length" ).isEqualTo(1) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getPromoCode() ).as(" usageTrans.getMatchingAttributes().getPromoCode()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getMatchingAttributes().getDuration() ).as(" usageTrans.getMatchingAttributes().getDuration()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getChargingMethod() ).as(" usageTrans.getMatchingAttributes().getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getBearer() ).as(" usageTrans.getMatchingAttributes().getBearer()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getMatchingAttributes().isInteractive() ).as(" usageTrans.getMatchingAttributes().isInteractive()" ).isTrue() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isIncludeUnavailable() ).as(" usageTrans.getMatchingAttributes().isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getExpressFlag() ).as(" usageTrans.getMatchingAttributes().getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isExpressFlag() ).as(" usageTrans.getMatchingAttributes().isExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isPreOrder() ).as(" usageTrans.getMatchingAttributes().isPreOrder()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isCancellationUsage() ).as(" usageTrans.getMatchingAttributes().isCancellationUsage()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getTierName() ).as(" usageTrans.getMatchingAttributes().getTierName()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPromoPrecode() ).as(" usageTrans.getMatchingAttributes().getPromoPrecode()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getUniquePromoCode() ).as(" usageTrans.getMatchingAttributes().getUniquePromoCode()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPromoUniqueCode() ).as(" usageTrans.getMatchingAttributes().getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getNextCycleDiscount() ).as(" usageTrans.getMatchingAttributes().getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getHasHistoricPricePointFlag() ).as(" usageTrans.getMatchingAttributes().getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isIsForRenewal() ).as(" usageTrans.getMatchingAttributes().isIsForRenewal()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getTaxRate() ).as(" usageTrans.getMatchingAttributes().getTaxRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getTaxRateAsDouble() ).as(" usageTrans.getMatchingAttributes().getTaxRateAsDouble()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getAffiliateID() ).as(" usageTrans.getMatchingAttributes().getAffiliateID()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getTariff() ).as(" usageTrans.getMatchingAttributes().getTariff()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getMatchingAttributes().getAggregatorId() ).as(" usageTrans.getMatchingAttributes().getAggregatorId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().isForcePurchaseFlow() ).as(" usageTrans.getMatchingAttributes().isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getReceipientMsisdn() ).as(" usageTrans.getMatchingAttributes().getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getProductCode() ).as(" usageTrans.getMatchingAttributes().getProductCode()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getMerchantName() ).as(" usageTrans.getMatchingAttributes().getMerchantName()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getInvoiceText() ).as(" usageTrans.getMatchingAttributes().getInvoiceText()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().isReIssueEnabled() ).as(" usageTrans.getMatchingAttributes().isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isReIssueFlagPresent() ).as(" usageTrans.getMatchingAttributes().isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getShortPackageId() ).as(" usageTrans.getMatchingAttributes().getShortPackageId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getTaxCode() ).as(" usageTrans.getMatchingAttributes().getTaxCode()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getMatchingAttributes().getHistoryStartDate() ).as(" usageTrans.getMatchingAttributes().getHistoryStartDate()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getVendorId() ).as(" usageTrans.getMatchingAttributes().getVendorId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().isIsForNextPaymentAmount() ).as(" usageTrans.getMatchingAttributes().isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getRenewalPreRate() ).as(" usageTrans.getMatchingAttributes().getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(usageTrans.getMatchingAttributes().isOverrideDisallowPreRateFlag() ).as(" usageTrans.getMatchingAttributes().isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getContentCategory() ).as(" usageTrans.getMatchingAttributes().getContentCategory()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPartnerUrl() ).as(" usageTrans.getMatchingAttributes().getPartnerUrl()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPartnerContactInfo() ).as(" usageTrans.getMatchingAttributes().getPartnerContactInfo()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPartnerEmail() ).as(" usageTrans.getMatchingAttributes().getPartnerEmail()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPartnerName() ).as(" usageTrans.getMatchingAttributes().getPartnerName()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getMatchingAttributes().getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint() ).as(" usageTrans.getMatchingAttributes().getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(usageTrans.getMatchingAttributes().getLinkedByTrialPricepoint() ).as(" usageTrans.getMatchingAttributes().getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getSubRenewalPricepointId() ).as(" usageTrans.getMatchingAttributes().getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getLinkPricepointId() ).as(" usageTrans.getMatchingAttributes().getLinkPricepointId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getSubPurchaseTransactionTrial() ).as(" usageTrans.getMatchingAttributes().getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getDiscardHiddenInactivePricepoints() ).as(" usageTrans.getMatchingAttributes().getDiscardHiddenInactivePricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints() ).as(" usageTrans.getMatchingAttributes().isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
        softly.assertThat(usageTrans.getMatchingAttributes().getExtIdentifier1() ).as(" usageTrans.getMatchingAttributes().getExtIdentifier1()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getExtIdentifier2() ).as(" usageTrans.getMatchingAttributes().getExtIdentifier2()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getExtIdentifier3() ).as(" usageTrans.getMatchingAttributes().getExtIdentifier3()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPartnerId() ).as(" usageTrans.getMatchingAttributes().getPartnerId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getAccessChannel() ).as(" usageTrans.getMatchingAttributes().getAccessChannel()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getPurchaseChannel() ).as(" usageTrans.getMatchingAttributes().getPurchaseChannel()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getDeviceID() ).as(" usageTrans.getMatchingAttributes().getDeviceID()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getLocal() ).as(" usageTrans.getMatchingAttributes().getLocal()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getMsisdn() ).as(" usageTrans.getMatchingAttributes().getMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getLanguageCode() ).as(" usageTrans.getMatchingAttributes().getLanguageCode()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getActiveSubscriptions() ).as(" usageTrans.getMatchingAttributes().getActiveSubscriptions()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getCsrId() ).as(" usageTrans.getMatchingAttributes().getCsrId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getExternalField1() ).as(" usageTrans.getMatchingAttributes().getExternalField1()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getExternalField2() ).as(" usageTrans.getMatchingAttributes().getExternalField2()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getExternalTransId() ).as(" usageTrans.getMatchingAttributes().getExternalTransId()" ).isNull();
        softly.assertThat(usageTrans.getMatchingAttributes().getLanguageLocale() ).as(" usageTrans.getMatchingAttributes().getLanguageLocale()" ).isNull();
        softly.assertThat(usageTrans.getPackageId() ).as(" usageTrans.getPackageId()" ).isNull();
        softly.assertThat(usageTrans.getRateIdentifier() ).as(" usageTrans.getRateIdentifier()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_999_999");
        softly.assertThat(usageTrans.getUsageTime() ).as(" usageTrans.getUsageTime()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getSessionId() ).as(" usageTrans.getSessionId()" ).isNull();
        softly.assertThat(usageTrans.getContentName() ).as(" usageTrans.getContentName()" ).isNull();
        softly.assertThat(usageTrans.getAssetID() ).as(" usageTrans.getAssetID()" ).isNull();
        softly.assertThat(usageTrans.getPaymentType() ).as(" usageTrans.getPaymentType()" ).isEqualTo(10010) ;
        softly.assertThat(usageTrans.getEventUnits() ).as(" usageTrans.getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getBearer() ).as(" usageTrans.getBearer()" ).isEqualTo("*");
        softly.assertThat(usageTrans.getExpressFlag() ).as(" usageTrans.getExpressFlag()" ).isFalse() ;
        softly.assertThat(usageTrans.getTierName() ).as(" usageTrans.getTierName()" ).isNull();
        softly.assertThat(usageTrans.getPromoPrecode() ).as(" usageTrans.getPromoPrecode()" ).isNull();
        softly.assertThat(usageTrans.getPromoUniqueCode() ).as(" usageTrans.getPromoUniqueCode()" ).isNull();
        softly.assertThat(usageTrans.getNextCycleDiscount() ).as(" usageTrans.getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getTaxRate() ).as(" usageTrans.getTaxRate()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(usageTrans.getAffiliateID() ).as(" usageTrans.getAffiliateID()" ).isNull();
        softly.assertThat(usageTrans.getAggregatorId() ).as(" usageTrans.getAggregatorId()" ).isNull();
        softly.assertThat(usageTrans.getReceipientMsisdn() ).as(" usageTrans.getReceipientMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getProductCode() ).as(" usageTrans.getProductCode()" ).isNull();
        softly.assertThat(usageTrans.getMerchantName() ).as(" usageTrans.getMerchantName()" ).isNull();
        softly.assertThat(usageTrans.getInvoiceText() ).as(" usageTrans.getInvoiceText()" ).isNull();
        softly.assertThat(usageTrans.getContentCategory() ).as(" usageTrans.getContentCategory()" ).isNull();
        softly.assertThat(usageTrans.getAccessChannel() ).as(" usageTrans.getAccessChannel()" ).isNull();
        softly.assertThat(usageTrans.getPurchaseChannel() ).as(" usageTrans.getPurchaseChannel()" ).isNull();
        softly.assertThat(usageTrans.getDeviceID() ).as(" usageTrans.getDeviceID()" ).isNull();
        softly.assertThat(usageTrans.getMsisdn() ).as(" usageTrans.getMsisdn()" ).isNull();
        softly.assertThat(usageTrans.getCsrId() ).as(" usageTrans.getCsrId()" ).isEqualTo("test");
        softly.assertThat(usageTrans.getSubscriptionId() ).as(" usageTrans.getSubscriptionId()" ).isNotEmpty();
// com.vodafone.global.er.subscriptionmanagement.ERSubscription
//check size of array!
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices().length ).as(" usageTrans.getSubscription().getPurchasedServices().length" ).isEqualTo(1) ;
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getId() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getId()" ).isEqualTo(new Long(5030)) ;
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getStatus() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getStatus()" ).isEqualTo(201) ;
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getServiceId() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getServiceId()" ).isEqualTo("sAlt");
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getServiceClass() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getServiceClass()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getUpdateTimeStamp()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getProvStatus() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getProvStatus()" ).isEqualTo(221) ;
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getLastProvisionUpdate()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getSubscription() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getSubscription()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getNonRefundDescription()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getCountryId() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getCountryId()" ).isNull();
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].getProvisioningTag()" ).isEqualTo("N/A");
//        softly.assertThat(usageTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage() ).as(" usageTrans.getSubscription().getPurchasedServices()[0].isProvisionOnUsage()" ).isFalse() ;
// com.vizzavi.ecommerce.business.catalog.CatalogPackage
        softly.assertThat(usageTrans.getSubscription().getPackage().getName() ).as(" usageTrans.getSubscription().getPackage().getName()" ).isEqualTo("2 Usage Alternative Payment Pkg");
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().getName() ).as(" usageTrans.getSubscription().getPackage().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().isToken() ).as(" usageTrans.getSubscription().getPackage().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().isUsageToken() ).as(" usageTrans.getSubscription().getPackage().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().isPayToken() ).as(" usageTrans.getSubscription().getPackage().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().getResourceSymbol() ).as(" usageTrans.getSubscription().getPackage().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().getCode() ).as(" usageTrans.getSubscription().getPackage().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().getDescription() ).as(" usageTrans.getSubscription().getPackage().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().getCountryId() ).as(" usageTrans.getSubscription().getPackage().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().isResource() ).as(" usageTrans.getSubscription().getPackage().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().isCurrency() ).as(" usageTrans.getSubscription().getPackage().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getResource().getResourceName() ).as(" usageTrans.getSubscription().getPackage().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageTrans.getSubscription().getPackage().getKey() ).as(" usageTrans.getSubscription().getPackage().getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPriority() ).as(" usageTrans.getSubscription().getPackage().getPriority()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getId() ).as(" usageTrans.getSubscription().getPackage().getId()" ).isEqualTo("pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getParentPackageId() ).as(" usageTrans.getSubscription().getPackage().getParentPackageId()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getUrl() ).as(" usageTrans.getSubscription().getPackage().getUrl()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getRate() ).as(" usageTrans.getSubscription().getPackage().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricingText1() ).as(" usageTrans.getSubscription().getPackage().getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricingText2() ).as(" usageTrans.getSubscription().getPackage().getPricingText2()" ).isNullOrEmpty();
// com.vizzavi.ecommerce.business.catalog.PricePoint
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().getName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().getName()" ).isEqualTo("GBP");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().isToken() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().isToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().isUsageToken() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().isUsageToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().isPayToken() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().isPayToken()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().getCode() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().getCode()" ).isEqualTo(826) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().getDescription() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().getDescription()" ).isEqualTo("British Pound Sterling");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().getCountryId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().getCountryId()" ).isEqualTo(0) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().isResource() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().isResource()" ).isFalse() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().isCurrency() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().isCurrency()" ).isTrue() ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceName() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getResource().getResourceName()" ).isEqualTo("ChargingResource_826");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getKey() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getKey()" ).isNull();
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getId() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getId()" ).isEqualTo("package:pAlt_TAX_3_2_999_999_999_*_*");
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().getRate() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().getRate()" ).isEqualTo(new Double(11.75)) ;
        softly.assertThat(usageTrans.getSubscription().getPackage().getPricePoint().isDiscount() ).as(" usageTrans.getSubscription().getPackage().getPricePoint().isDiscount()" ).isFalse() ;

        //Only want to report the SoftAssertionErrors and not actually fail the test
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            e.getErrors().forEach(System.err::println);
        }
    }

}
