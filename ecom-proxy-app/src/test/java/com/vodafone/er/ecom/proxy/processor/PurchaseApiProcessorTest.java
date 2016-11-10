package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.SelfcareApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.SubscriptionDataBuilder.aSubscription;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class PurchaseApiProcessorTest {

    @Mock
    private SelfcareApiService selfcareApiService;

    @InjectMocks
    private PurchaseApiProcessor<RequestResult<List<PurchaseAuthorization>>> purchaseApiProcessor;

    @Test
    public void shouldProcessPurchaseResult() throws Exception {
        //given
        String msisdn = "" + new Random().nextLong();
        PurchaseAuthorization auth = new PurchaseAuthorization();
        Subscription sub = aSubscription();
        auth.setPackageSubscriptionId("" + sub.getSubscriptionIdLong());

        when(selfcareApiService.getSubscription(Locale.UK, msisdn , auth.getPackageSubscriptionId()))
                .thenReturn(Optional.ofNullable(sub));

        //when
        purchaseApiProcessor.process(new RequestResult.Builder<List<PurchaseAuthorization>>()
                .locale(Locale.UK)
                .response(newArrayList(auth))
                .msisdn(msisdn)
                .build());

        //then
        verify(selfcareApiService).getSubscription(Locale.UK, msisdn, auth.getPackageSubscriptionId());

        assertEquals(sub.getSubscriptionIdLong(), auth.getPackageSubscriptionIdLong());
        assertEquals(sub.getPackageId(), auth.getPackageId());
        assertEquals(sub.getPricePoint(), auth.getPricePoint());
        assertEquals(sub.getPricePoint().getId(), auth.getPricePoint().getId());

    }

    @Test
    public void shouldReturnEmptySubscriptionDuringPostProcess() throws Exception {
        //given
        String msisdn = "" + new Random().nextLong();
        PurchaseAuthorization auth = new PurchaseAuthorization();
        Subscription sub = aSubscription();
        auth.setPackageSubscriptionId("" + sub.getSubscriptionIdLong());

        when(selfcareApiService.getSubscription(Locale.UK, msisdn , auth.getPackageSubscriptionId()))
                .thenReturn(Optional.empty());

        //when
        purchaseApiProcessor.process(new RequestResult.Builder<List<PurchaseAuthorization>>()
                .locale(Locale.UK)
                .response(newArrayList(auth))
                .msisdn(msisdn)
                .build());

        //then
        verify(selfcareApiService).getSubscription(Locale.UK, msisdn, auth.getPackageSubscriptionId());

        assertNotEquals(sub.getPackageId(), auth.getPackageId());
        assertNotEquals(sub.getPricePoint(), auth.getPricePoint());
        assertNotEquals(sub.getPricePoint().getId(), auth.getPricePoint().getId());

    }

    @Test
    public void shouldNotCallGetSubscriptionsWhenEmptyResultList() throws Exception {
        //given
        String msisdn = "" + new Random().nextLong();
        PurchaseAuthorization auth = new PurchaseAuthorization();

        //when
        purchaseApiProcessor.process(new RequestResult.Builder<List<PurchaseAuthorization>>()
                .locale(Locale.UK)
                .response(newArrayList())
                .msisdn(msisdn)
                .build());

        //then
        verifyZeroInteractions(selfcareApiService);

    }

    @Test
    public void shouldThrowEcommerceExceptionDuringPostProcessAndHandle() throws Exception {
        //given
        String msisdn = "" + new Random().nextLong();
        PurchaseAuthorization auth = new PurchaseAuthorization();
        Subscription sub = aSubscription();
        auth.setPackageSubscriptionId("" + sub.getSubscriptionIdLong());

        when(selfcareApiService.getSubscription(Locale.UK, msisdn , auth.getPackageSubscriptionId()))
                .thenThrow(new EcommerceException("Test Exception"));

        //when
        purchaseApiProcessor.process(new RequestResult.Builder<List<PurchaseAuthorization>>()
                .locale(Locale.UK)
                .response(newArrayList(auth))
                .msisdn(msisdn)
                .build());

        //then
        verify(selfcareApiService).getSubscription(Locale.UK, msisdn, auth.getPackageSubscriptionId());

        assertNotEquals(sub.getPackageId(), auth.getPackageId());
        assertNotEquals(sub.getPricePoint(), auth.getPricePoint());
        assertNotEquals(sub.getPricePoint().getId(), auth.getPricePoint().getId());

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionDuringPostProcess() throws Exception {
        //given
        String msisdn = "" + new Random().nextLong();
        PurchaseAuthorization auth = new PurchaseAuthorization();
        Subscription sub = aSubscription();
        auth.setPackageSubscriptionId("" + sub.getSubscriptionIdLong());

        when(selfcareApiService.getSubscription(Locale.UK, msisdn , auth.getPackageSubscriptionId()))
                .thenThrow(new RuntimeException("Test Exception"));

        //when
        purchaseApiProcessor.process(new RequestResult.Builder<List<PurchaseAuthorization>>()
                .locale(Locale.UK)
                .response(newArrayList(auth))
                .msisdn(msisdn)
                .build());

        //then
        verify(selfcareApiService).getSubscription(Locale.UK, msisdn, auth.getPackageSubscriptionId());

    }


}
