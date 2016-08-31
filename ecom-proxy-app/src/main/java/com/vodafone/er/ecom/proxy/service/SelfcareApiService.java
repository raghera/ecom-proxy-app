package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.vodafone.er.ecom.proxy.constants.EcomAppEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Component
public class SelfcareApiService {

    private SelfcareApi selfcareApi;
    private CatalogApi catalogApi;
    private CatalogApiService catalogApiService;

    public SelfcareApiService(Locale locale) throws EcommerceException {
        selfcareApi = DecouplingApiFactory.getSelfcareApi(locale, CLIENT_ID.getValue());
        catalogApi = DecouplingApiFactory.getCatalogApi(locale, CLIENT_ID.getValue());
        catalogApiService = new CatalogApiService();
    }

    //call getSubscriptions instead where possible.
    public Optional<Subscription> getSubscription(Locale locale, String msisdn, String subId) throws EcommerceException {
//        Subscription sub = selfcareApi.getSubscription(CLIENT_ID.getValue(), msisdn, 0, subId);
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        Subscription [] subs = getSubscriptions(locale, msisdn, CLIENT_ID.getValue(), 0, filter);
        if(subs == null || subs.length != 1) {
            return Optional.empty();
        }
        process(locale, subs);

        return Optional.of(subs[0]);
    }

    //This one returns transactions which getSubscription does not
    public Subscription [] getSubscriptions(Locale locale, String clientId, String msisdn, int device, SubscriptionFilter filter)
            throws EcommerceException{

        filter.setIncludeModifyTxns(true);
        filter.setIncludePaymentTxns(true);
        filter.setIncludeRefundTxns(true);

        Subscription [] subs = selfcareApi.getSubscriptions(clientId, msisdn, device, filter);
        process(locale, subs);
        return subs;
    }

    public Subscription [] process(Locale locale, final Subscription [] subscriptions) {
        final List<Subscription> subsList = Arrays.asList(subscriptions);

        subsList.forEach(subscription -> populateSubscriptionTransactions(locale, subscription));

        //Currently nothing else required.
//        populatePurchasedServices(subsList);
        return subscriptions;

    }
    public void populateSubscriptionTransactions(Locale locale, Subscription subscription) {
        List<Transaction> resultList = new ArrayList<>();

        subscription.getPaymentTransactions().forEach(paymentTxn -> resultList.add(paymentTxn));
        subscription.getModifyTransactions().forEach(modifyTxn -> resultList.add(modifyTxn));
        if(subscription.getRefundTransactions() != null) {
            subscription.getRefundTransactions()
                    .forEach(refundTxn -> resultList.add(refundTxn));
        }

        subscription.setTransactions(resultList);

        final CatalogPackage pack = catalogApiService.getCatalogPackage(locale, subscription.getPackageId());
        catalogApiService.populatePricePointInPackage(pack, subscription.getPackage().getPricePoint().getId());
        subscription.setPackage(pack);

    }

    //TODO Rather delete this method as potentially thousands of calls to catalogApi.getService(serviceId);
    //TODO Better to test if purchasedServices object is required first, then potentially add an operation to obtain all services in a list in CORE
    public void populatePurchasedServices(final List<Subscription> subscriptions) {

        subscriptions.stream().forEach(subscription -> {
            final List<String> serviceIds = Arrays.asList(subscription.getServiceIds());
            final List<PurchasedService> purchasedServices = new ArrayList<>();
            serviceIds.stream().forEach(serviceId -> {

                final CatalogService catalogService = catalogApi.getService(serviceId);
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
