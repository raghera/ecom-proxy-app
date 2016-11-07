package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.selfcare.PurchasedService;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(SelfcareApiProcessor.class);

    @Autowired
    private CatalogApiProcessor catalogApiProcessor;
    @Autowired
    private CatalogApiService catalogApiService;

    @Override
    public void process(RequestResult<List<?>> result) {
        logger.debug("Enter SelfcareApiProcessor.process");

        if(!result.getResponse().isEmpty() && (result.getResponse().get(0) instanceof Subscription)) {
            List<Subscription> subscriptions = (List<Subscription>) result.getResponse();
            processSubscriptionsResponse(result.getLocale(), subscriptions);
        }
    }

    private List<Subscription> processSubscriptionsResponse(Locale locale, final List<Subscription> subscriptions) {
        logger.debug("Enter SelfcareApiProcessor.processSubscriptionsResponse");
        subscriptions.forEach(subscription -> populateTransactions(locale, subscription));
        //Currently nothing else required.
//        populatePurchasedServices(subsList);
        return subscriptions;
    }

    //Sets the Subscription obj in the Transaction objects without any calls to ER Core
    private void populateTransactions(Locale locale, Subscription subscription) {
        logger.debug("Enter SelfcareApiProcessor.populateTransactions");
        List<Transaction> resultList = new ArrayList<>();

        subscription.getPaymentTransactions().forEach(paymentTxn -> {
            paymentTxn.setSubscription(subscription);
            resultList.add(paymentTxn);
        });
        subscription.getModifyTransactions().forEach(modifyTxn -> {
            modifyTxn.setSubscription(subscription);
            resultList.add(modifyTxn);
        });
        //TODO These are currently never being populated - so code below is pointless
        //If Refunds are ever required in EPA then we can put this back.
//        if(subscription.getRefundTransactions() != null) {
//            subscription.getRefundTransactions()
//                    .forEach(refundTxn -> {
//                        refundTxn.setSubscription(subscription);
//                        resultList.add(refundTxn);
//                    });
//        }

        subscription.getTransactions().addAll(resultList);

        logger.debug("Completed populating transactions");

        //TODO modify getCatalogPackage service call to never return a null (make it Optional).
        //populate the package correctly
        final CatalogPackage pack = catalogApiService.getCatalogPackage(locale, subscription.getPackageId());
        if(pack != null) {
            catalogApiProcessor.populatePricePointInPackage(pack, subscription.getPackage().getPricePoint().getId());
            subscription.setPackage(pack);
        }

    }

    //TODO Rather delete this method as potentially thousands of calls to catalogApi.getService(serviceId);
    //TODO Better to test if purchasedServices object is required first, then potentially add an operation to obtain all services in a list in CORE
    private void populatePurchasedServices(Locale locale, final List<Subscription> subscriptions) {

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

            subscription.setPurcServiceList(purchasedServices);

        });
    }

}
