package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.BasicAccount;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
@Service
public class CustcareApiService {

    @Autowired
    private ErApiManager erApiManager;

    public boolean inactivateSubscription(Locale locale, String clientId, String msisdn, String subscriptionId, String csrId, String reason) throws Exception {
        return erApiManager.getCustcareApi(locale)
                .inactivateSubscription(clientId, msisdn, subscriptionId, csrId, reason);
    }

    public BasicAccount getBasicAccount(Locale locale, String clientId, String msisdn, int accessDevice) throws EcommerceException{
        return erApiManager.getCustcareApi(locale).getBasicAccount(clientId, msisdn, accessDevice);
    }


}
