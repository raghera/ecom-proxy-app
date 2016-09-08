package com.vodafone.er.ecom.proxy.service;

import com.vodafone.er.ecom.proxy.api.ErApiManager;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
public class CustcareApiService {

    ErApiManager erApiManager;

    public CustcareApiService() {
        erApiManager = new ErApiManager();
    }

    public boolean process(Locale locale, String clientId, String msisdn, String subscriptionId, String csrId, String reason) throws Exception {
        return erApiManager.getCustcareApi(locale)
                .inactivateSubscription(clientId, msisdn, subscriptionId, csrId, reason);
    }

}
