package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;

/**
 * Created by Ravi Aghera
 */
public class PurchaseAuthorizationDataBuilder {

    public static PurchaseAuthorization aPurchaseAuthorization() {
        PurchaseAuthorization auth = new PurchaseAuthorization();
        auth.setIsSuccess(true);
        return auth;
    }
    public static PurchaseAuthorization aPurchaseAuthorizationFailure() {
        PurchaseAuthorization auth = new PurchaseAuthorization();
        auth.setIsSuccess(false);
        return auth;
    }

}

