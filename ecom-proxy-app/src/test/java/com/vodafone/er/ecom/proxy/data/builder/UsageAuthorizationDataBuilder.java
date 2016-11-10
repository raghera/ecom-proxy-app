package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.charging.UsageAuthorization;

/**
 * Created by Ravi Aghera
 */
public class UsageAuthorizationDataBuilder {

    public static UsageAuthorization aUsageAuthorization() {
        UsageAuthorization usageAuth = new UsageAuthorization();
        usageAuth.setIsSuccess(true);

        return usageAuth;
    }

    public static UsageAuthorization aUsageAuthorizationFailure() {
        UsageAuthorization usageAuth = new UsageAuthorization();
        usageAuth.setIsSuccess(false);
        usageAuth.setErrorDescription("This is a test ErrorDescription");
        usageAuth.setErrorId("This is a test ErrorId");

        return usageAuth;

    }
}
