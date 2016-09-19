package com.vodafone.er.ecom.proxy.api;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.provision.ProvisionApi;
import com.vizzavi.ecommerce.business.selfcare.CustcareApi;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
public interface IErApiManager {

    PurchaseApi getPurchaseApi(Locale locale, String clientId);
    ChargingApi getChargingApi(Locale locale, String clientId);
    SelfcareApi getSelfcareApi(Locale locale);
    CustcareApi getCustcareApi(Locale locale);
    CatalogApi getCatalogApi(Locale locale);
    ProvisionApi getProvisionApi(Locale locale);

}
