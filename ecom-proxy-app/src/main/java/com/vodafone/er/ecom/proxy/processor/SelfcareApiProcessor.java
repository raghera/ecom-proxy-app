package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.selfcare.PurchasedService;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
@Component
public class SelfcareApiProcessor<T> implements PostProcessor<RequestResult<List<?>>> {

    @Autowired
    private CatalogApiProcessor catalogApiProcessor;
    @Autowired
    private CatalogApiService catalogApiService;

    @Override
    public RequestResult<List<?>> process(RequestResult<List<?>> result) {

        if(!result.getResponse().isEmpty() && result.getResponse().get(0) instanceof Subscription ) {
            List<Subscription> subscriptions = (List<Subscription>) result.getResponse();
            processSubscriptionsResponse(result.getLocale(), subscriptions);
        }

        return result;
    }

    public List<Subscription> processSubscriptionsResponse(Locale locale, final List<Subscription> subscriptions) {
        subscriptions.forEach(subscription -> populateTransactions(locale, subscription));
        //Currently nothing else required.
//        populatePurchasedServices(subsList);
        return subscriptions;
    }

    public void populateTransactions(Locale locale, Subscription subscription) {
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
        catalogApiProcessor.populatePricePointInPackage(pack, subscription.getPackage().getPricePoint().getId());
        subscription.setPackage(pack);

    }

    //TODO Rather delete this method as potentially thousands of calls to catalogApi.getService(serviceId);
    //TODO Better to test if purchasedServices object is required first, then potentially add an operation to obtain all services in a list in CORE
    public void populatePurchasedServices(Locale locale, final List<Subscription> subscriptions) {

        subscriptions.forEach(subscription -> {
            final List<String> serviceIds = Arrays.asList(subscription.getServiceIds());
            final List<PurchasedService> purchasedServices = new ArrayList<>();
            serviceIds.forEach(serviceId -> {

//                final CatalogService catalogService = erApiManager.getCatalogApi(locale).getService(serviceId);
                final CatalogService catalogService = catalogApiService.getCatalogService(locale, serviceId);
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
