package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.selfcare.CustcareApi;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vizzavi.ecommerce.business.common.EcomApiFactory.*;
import static com.vodafone.er.ecom.proxy.constants.EcomAppEnum.CLIENT_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class ModifySubscriptionChargingMethodIT {

    //public boolean modifySubscriptionChargingMethod(String clientId, String msisdn, int deviceType, String packageSubId, int chargingMethod,String csrId,String reason) throws AccountNotFoundException, EcommerceException;

    @Test
    public void modifySubscriptionChargingMethod4Success() throws Exception {

        final String msisdn = String.valueOf(new Random().nextInt());

        final String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";

        final PurchaseAuthorization auth = getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue(auth.isSuccess());
        assertNotNull(auth.getPackageSubscriptionId());

        boolean result2 = getSelfcareApi(Locale.UK)
                .modifySubscriptionChargingMethod("test",msisdn, 0, auth.getPackageSubscriptionId(), 2, "csrId", "test-reason");

        assertTrue(result2);

    }

    @Test
    public void modifySubscriptionChargingMethod19Success() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());

        final String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";

        final PurchaseAuthorization auth = getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue(auth.isSuccess());
        assertNotNull(auth.getPackageSubscriptionId());
        CustcareApi custcareApi = getCustcareApi(Locale.UK);
        boolean result2 = custcareApi.modifySubscriptionChargingMethod(CLIENT_ID.getValue(), msisdn, 0, auth.getPackageSubscriptionId(), 2);

        assertTrue(result2);

    }

}
