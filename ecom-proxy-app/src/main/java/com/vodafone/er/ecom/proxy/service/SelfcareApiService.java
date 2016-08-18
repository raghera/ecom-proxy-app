package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.PurchasedService;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
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
    }

    public Subscription [] process(final Subscription [] subscriptions) {
        final List<Subscription> subsList = Arrays.asList(subscriptions);

//        populatePurchasedServices(subsList);

        //Currently nothing required
        return subscriptions;

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
//            subscription.setPurcServiceList(purchasedServices);

        });



    }

}
