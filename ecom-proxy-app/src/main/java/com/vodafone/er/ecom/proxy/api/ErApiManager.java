package com.vodafone.er.ecom.proxy.api;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.provision.ProvisionApi;
import com.vizzavi.ecommerce.business.selfcare.CustcareApi;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Component
public class ErApiManager {

    private Logger log = LoggerFactory.getLogger(ErApiManager.class);

    private CatalogApi catalogApi;

    public PurchaseApi getPurchaseApi(Locale locale, String clientId) {
        return DecouplingApiFactory.getPurchaseApi(locale , checkClientId(clientId));
    }
    public ChargingApi getChargingApi(Locale locale, String clientId) {
        return DecouplingApiFactory.getChargingApi(locale , checkClientId(clientId));
    }
    public SelfcareApi getSelfcareApi(Locale locale) {
        return DecouplingApiFactory.getSelfcareApi(locale, CLIENT_ID.value());
    }
    public CustcareApi getCustcareApi(Locale locale) {
        return DecouplingApiFactory.getCustcareApi(locale, CLIENT_ID.value());
    }
    public CatalogApi getCatalogApi(Locale locale) {
        log.info("getPackages5: Calling DecouplingApiFactory");
        catalogApi = DecouplingApiFactory.getCatalogApi(locale, CLIENT_ID.value());
        return catalogApi;
    }
    public ProvisionApi getProvisionApi(Locale locale) {
        return DecouplingApiFactory.getProvisionApi(locale, CLIENT_ID.value());
    }
    private String checkClientId(String clientId) {
        if(null == clientId || clientId.isEmpty()) {
            log.warn("No clientId provided by the client so populating it with a default: " + CLIENT_ID.value());
            return CLIENT_ID.value();
        }
        return clientId;
    }
}
