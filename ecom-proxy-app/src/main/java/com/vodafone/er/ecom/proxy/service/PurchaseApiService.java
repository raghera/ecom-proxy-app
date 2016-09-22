package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
@Service
public class PurchaseApiService {

    @Autowired
    private ErApiManager erApiManager;

    @Autowired
    private CatalogApiService catalogApiService;

    public PurchaseAuthorization purchasePackageMsisdn(Locale locale, String clientId, String msisdn,
                                                       String packageId, PurchaseAttributes purchaseAttributes) throws Exception {
        return erApiManager.getPurchaseApi(locale, clientId)
                .purchasePackageMsisdn(clientId, msisdn, packageId, purchaseAttributes);
    }

    public PurchaseAuthorization renewPurchasePackageMsisdn(Locale locale, String clientId, String msisdn, String subId,
                                                            PurchaseAttributes attributes) throws Exception {
        return erApiManager.getPurchaseApi(locale, clientId)
                .renewPurchasePackageMsisdn(clientId, msisdn, subId, attributes);

    }

}
