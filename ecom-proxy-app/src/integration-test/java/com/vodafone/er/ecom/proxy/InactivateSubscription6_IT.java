package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vodafone.er.ecom.proxy.enums.EpaClientEnum;
import org.junit.Test;

import java.util.Random;

import static java.util.Locale.UK;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class InactivateSubscription6_IT {

    @Test
    public void inactivateSubscription6() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*";
        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        boolean result = EcomApiFactory.getCustcareApi(UK).inactivateSubscription(EpaClientEnum.CLIENT_ID.value(), msisdn, auth.getPackageSubscriptionId(), "test-csrId", "test-reason");
        assertTrue(result);
    }
}
