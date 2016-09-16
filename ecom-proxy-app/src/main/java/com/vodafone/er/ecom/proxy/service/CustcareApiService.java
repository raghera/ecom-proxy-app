package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.BasicAccount;
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

    public boolean inactivateSubscription(Locale locale, String clientId, String msisdn, String subscriptionId, String csrId, String reason) throws Exception {
        return erApiManager.getCustcareApi(locale)
                .inactivateSubscription(clientId, msisdn, subscriptionId, csrId, reason);
    }

    public BasicAccount getBasicAccount(Locale locale, String clientId, String msisdn, int accessDevice) throws EcommerceException{
        return erApiManager.getCustcareApi(locale).getBasicAccount(clientId, msisdn, accessDevice);
    }



}
