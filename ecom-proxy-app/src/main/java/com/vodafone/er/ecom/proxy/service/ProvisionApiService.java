package com.vodafone.er.ecom.proxy.service;

import com.vodafone.er.ecom.proxy.api.ErApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
@Service
public class ProvisionApiService {

    @Autowired
    private ErApiManager erApiManager;

    public boolean updateServiceStatus(Locale locale, String provisionId, int serviceStatus, int provStatus) throws Exception {
        return erApiManager.getProvisionApi(locale)
                .updateServiceStatus(provisionId, serviceStatus, provStatus);
    }
}
