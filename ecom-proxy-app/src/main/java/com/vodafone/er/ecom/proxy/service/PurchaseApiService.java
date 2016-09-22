package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

/**
 * Created by Ravi Aghera
 */
@Service
public class PurchaseApiService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseApiService.class);

    @Autowired
    private ErApiManager erApiManager;

    @Autowired
    private CatalogApiService catalogApiService;

    @Autowired
    private SelfcareApiService selfcareApiService;

    public PurchaseAuthorization purchasePackageMsisdn(Locale locale, String clientId, String msisdn,
                                                       String packageId, PurchaseAttributes purchaseAttributes) throws Exception {
        return erApiManager.getPurchaseApi(locale, clientId)
                .purchasePackageMsisdn(clientId, msisdn, packageId, purchaseAttributes);
    }

    public PurchaseAuthorization renewPurchasePackageMsisdn(Locale locale, String clientId, String msisdn, String subId,
                                                            PurchaseAttributes attributes) throws Exception {
        PurchaseAuthorization auth = erApiManager.getPurchaseApi(locale, clientId)
                .renewPurchasePackageMsisdn(clientId, msisdn, subId, attributes);

        postProcessResult(locale, msisdn, auth);

        return auth;

    }

    public void postProcessResult(Locale locale, String msisdn, PurchaseAuthorization auth) {

        Optional<Subscription> subOpt = null;
        try {
            subOpt = selfcareApiService.getSubscription(locale, msisdn , auth.getPackageSubscriptionId());
        } catch (EcommerceException e) {
            logger.warn("Postprocessing failed calling getSubscription(). Description: " + e.getErrorDescription());
            return;
        }

        PricePoint existingPp = auth.getPricePoint();

        subOpt.ifPresent(subscription -> {
            auth.setPackage(subscription.getPackage());
            auth.setPackageId(subscription.getPackageId());
            auth.setPricePoint(subscription.getPricePoint());
            auth.setPricePointId(subscription.getPricePoint().getId());
        });
    }

}
