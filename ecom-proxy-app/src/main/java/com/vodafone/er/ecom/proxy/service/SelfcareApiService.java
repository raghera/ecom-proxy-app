package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.er.ecom.proxy.constants.EcomAppEnum;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
@Component
public class SelfcareApiService {

    private SelfcareApi selfcareApi;
    private CatalogApi catalogApi;

    //TODO initialize in Spring
    public SelfcareApiService(Locale locale) throws EcommerceException {
        selfcareApi = EcomApiFactory.getSelfcareApi(locale);
        catalogApi = DecouplingApiFactory.getCatalogApi(locale, EcomAppEnum.CLIENT_ID.getValue());
    }

    public Subscription [] process(final Subscription [] subscriptions) {
        final List<Subscription> subsList = Arrays.asList(subscriptions);

        subsList.forEach(subcription -> populateSubscriptionTransactions(subcription));

        //Don't think these are currently required.
//        populatePurchasedServices(subsList);

        //Currently nothing required
        return subscriptions;

    }
    public void populateSubscriptionTransactions(Subscription subscription) {
        List<Transaction> resultList = new ArrayList<>();

        subscription.getPaymentTransactions().forEach(paymentTxn -> resultList.add(paymentTxn));
        subscription.getModifyTransactions().forEach(modifyTxn -> resultList.add(modifyTxn));
        if(subscription.getRefundTransactions() != null) {
            subscription.getRefundTransactions()
                    .forEach(refundTxn -> resultList.add(refundTxn));
        }

        subscription.setTransactions(resultList);

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
