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
 * 1 uniform way to get the Decoupling ErApi's in a singleton way
 *
 * Created by Ravi Aghera
 */
@Component
public class ErApiManager {

    private Logger log = LoggerFactory.getLogger(ErApiManager.class);

    private ChargingApi chargingApi;
    private CatalogApi catalogApi;
    private SelfcareApi selfcareApi;
    private CustcareApi custcareApi;
    private ProvisionApi provisionApi;
    private PurchaseApi purchaseApi;

    public PurchaseApi getPurchaseApi(Locale locale, String clientId) {
        if (null == purchaseApi) {
            purchaseApi = DecouplingApiFactory.getPurchaseApi(locale , clientId);
        }
        return purchaseApi;
    }
    public ChargingApi getChargingApi(Locale locale, String clientId) {
        if (null == chargingApi) {
            chargingApi = DecouplingApiFactory.getChargingApi(locale , clientId);
        }
        return chargingApi;
    }
    public SelfcareApi getSelfcareApi(Locale locale) {
        if(null == selfcareApi) {
            selfcareApi = DecouplingApiFactory.getSelfcareApi(locale, CLIENT_ID.value());
        }
        return selfcareApi;
    }

    public CustcareApi getCustcareApi(Locale locale) {
        if(null == custcareApi) {
            custcareApi = DecouplingApiFactory.getCustcareApi(locale, CLIENT_ID.value());
        }
        return custcareApi;
    }

    public CatalogApi getCatalogApi(Locale locale) {
        if(null == catalogApi) {
            log.info("getPackages5: Calling DecouplingApiFactory");
            catalogApi = DecouplingApiFactory.getCatalogApi(locale, CLIENT_ID.value());
        }
        return catalogApi;
    }

    public ProvisionApi getProvisionApi(Locale locale) {
        if(null == provisionApi) {
            provisionApi = DecouplingApiFactory.getProvisionApi(locale, CLIENT_ID.value());
        }
        return provisionApi;
    }

}
