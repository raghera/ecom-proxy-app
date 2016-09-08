package com.vodafone.er.ecom.proxy.service;

import com.vodafone.er.ecom.proxy.api.ErApiManager;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
public class ProvisionApiService {

    private ErApiManager erApiManager;

    public ProvisionApiService(){
        erApiManager = new ErApiManager();
    }

    public boolean updateServiceStatus(Locale locale, String provisionId, int serviceStatus, int provStatus) throws Exception {
        return erApiManager.getProvisionApi(locale)
                .updateServiceStatus(provisionId, serviceStatus, provStatus);
    }
}
