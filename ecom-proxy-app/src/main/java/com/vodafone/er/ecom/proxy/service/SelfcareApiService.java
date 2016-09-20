package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.vodafone.er.ecom.proxy.enums.EcomAppEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Service
public class SelfcareApiService {

    private CatalogApiService catalogApiService;
    private ErApiManager erApiManager;

    public SelfcareApiService() {
        catalogApiService = new CatalogApiService();
        erApiManager = new ErApiManager();
    }

    public Optional<Subscription> getSubscription(Locale locale, String msisdn, String subId) throws EcommerceException {
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        Optional<Subscription> subs = getSubscription(locale, msisdn, 0, subId);
        if(!subs.isPresent()) {
            return Optional.empty();
        }
        return subs;
    }

    public Optional<Subscription> getSubscription(Locale locale, String msisdn, int deviceType, String subId) throws EcommerceException {
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        Subscription [] subs = getSubscriptions(locale, msisdn, CLIENT_ID.getValue(), deviceType, filter);
        if(subs == null || subs.length != 1) {
            return Optional.empty();
        }
        processSubscriptionsResponse(locale, subs);

        return Optional.of(subs[0]);
    }

    //This one returns transactions which getSubscription does not
    public Subscription [] getSubscriptions(Locale locale, String clientId, String msisdn, int device, SubscriptionFilter filter)
            throws EcommerceException{

        filter.setIncludeModifyTxns(true);
        filter.setIncludePaymentTxns(true);
        filter.setIncludeRefundTxns(true);

        Subscription [] subs = erApiManager.getSelfcareApi(locale).getSubscriptions(clientId, msisdn, device, filter);
        processSubscriptionsResponse(locale, subs);
        return subs;
    }

    public Transaction [] getTransactions(Locale locale, String clientId, String msisdn, int accessDevice, TransactionFilter filter) throws EcommerceException {
        return erApiManager.getSelfcareApi(locale).getTransactions(clientId, msisdn, accessDevice, filter);
    }

    public Optional<Transaction> getTransaction(Locale locale, String clientId, TransactionFilter filter) throws EcommerceException {
        Transaction [] results  = getTransactions(locale, clientId, null, 0, filter);
        if(results == null || results.length != 1 ) {
            return Optional.empty();
        }

        return Optional.of(results[0]);
    }

    public boolean modifySubscriptionChargingMethod(Locale locale, String clientId, String msisdn, int deviceType,
                                                    String packageSubId, int chargingMethod, String csrId, String reason) throws Exception {
        return erApiManager.getSelfcareApi(locale).modifySubscriptionChargingMethod(clientId,msisdn,deviceType,packageSubId,chargingMethod,csrId,reason);
    }

    //TODO move to a post-processor class

    public Subscription [] processSubscriptionsResponse(Locale locale, final Subscription [] subscriptions) {
        final List<Subscription> subsList = Arrays.asList(subscriptions);

        subsList.forEach(subscription -> populateSubscriptionTransactions(locale, subscription));

        //Currently nothing else required.
//        populatePurchasedServices(subsList);
        return subscriptions;

    }
    public void populateSubscriptionTransactions(Locale locale, Subscription subscription) {
        List<Transaction> resultList = new ArrayList<>();

        subscription.getPaymentTransactions().forEach(paymentTxn -> {
            paymentTxn.setSubscription(subscription);
            resultList.add(paymentTxn);
        });
        subscription.getModifyTransactions().forEach(modifyTxn -> {
            modifyTxn.setSubscription(subscription);
            resultList.add(modifyTxn);
        });
        if(subscription.getRefundTransactions() != null) {
            subscription.getRefundTransactions()
                    .forEach(refundTxn -> {
                        refundTxn.setSubscription(subscription);
                        resultList.add(refundTxn);
                    });
        }

        subscription.setTransactions(resultList);

        //populate the package correctly
        final CatalogPackage pack = catalogApiService.getCatalogPackage(locale, subscription.getPackageId());
        catalogApiService.populatePricePointInPackage(pack, subscription.getPackage().getPricePoint().getId());
        subscription.setPackage(pack);

    }

    //TODO Rather delete this method as potentially thousands of calls to catalogApi.getService(serviceId);
    //TODO Better to test if purchasedServices object is required first, then potentially add an operation to obtain all services in a list in CORE
    public void populatePurchasedServices(Locale locale, final List<Subscription> subscriptions) {

        subscriptions.stream().forEach(subscription -> {
            final List<String> serviceIds = Arrays.asList(subscription.getServiceIds());
            final List<PurchasedService> purchasedServices = new ArrayList<>();
            serviceIds.stream().forEach(serviceId -> {

                final CatalogService catalogService = erApiManager.getCatalogApi(locale).getService(serviceId);
                PurchasedService purchasedService = new PurchasedService();
                purchasedService.setId(Long.valueOf(serviceId));
                purchasedService.setProvisioningTag(catalogService.getProvisioningTag());
                purchasedService.setServiceClass(catalogService.getServiceClass());
                //TODO Add whatever else is requierd here.

                purchasedServices.add(purchasedService);
            });

            //TODO Commented after move to 13-12
            subscription.setPurcServiceList(purchasedServices);

        });
    }
}
