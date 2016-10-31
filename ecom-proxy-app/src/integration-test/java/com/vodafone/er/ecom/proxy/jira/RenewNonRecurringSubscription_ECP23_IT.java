package com.vodafone.er.ecom.proxy.jira;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.junit.Test;
import org.perf4j.log4j.Log4JStopWatch;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class RenewNonRecurringSubscription_ECP23_IT {

    @Test
    public void shouldNotRenewNonRecurringSubSuccessfully() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "pAlt__X__package:pAlt_TAX_2_2_999_999_999_*_*_*_false_false_*";//Non-recurring

        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, packageId, new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

        Log4JStopWatch stopWatch = new Log4JStopWatch("RenewNonRecurringSubscription_ECP23_IT");
        stopWatch.start();

        PurchaseAuthorization result = EcomApiFactory.getPurchaseApi(Locale.UK)
                .renewPurchasePackageMsisdn("test", msisdn, auth.getPackageSubscriptionId(), new PurchaseAttributes());
        stopWatch.stop();

        assertNotNull(result);
        assertTrue(result.isSuccess());//Even though it's a non-recurring, it "should" still recur the subscription!

        System.out.println("\nElapsed Time: " + stopWatch.getElapsedTime());
        assertTrue(stopWatch.getElapsedTime() < 5000);//should not be slower than this
    }

}
