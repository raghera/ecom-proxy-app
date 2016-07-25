package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.common.*;
import com.vizzavi.ecommerce.business.selfcare.*;

import java.util.*;

/**
 * Created by Ravi Aghera
 */
public class SelfcareApiResultProcessor {

    private SelfcareApi selfcareApi;
    private com.vizzavi.ecommerce.business.catalog.CatalogApi catalogApi;

    public SelfcareApiResultProcessor(Locale locale) throws com.vizzavi.ecommerce.business.common.EcommerceException {
        selfcareApi = EcomApiFactory.getSelfcareApi(locale);
    }

    public Subscription [] process(Subscription [] subscriptions) {

        //TODO populate PurchasedServices
        //Call ER if there is a way to populate purchased services.
        throw new UnsupportedOperationException();
    }

}
