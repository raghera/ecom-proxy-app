package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.SelfcareApiService;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.SubscriptionDataBuilder.aSubscription;
import static com.vodafone.er.ecom.proxy.data.builder.UsageAuthorizationDataBuilder.aUsageAuthorization;
import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class ChargingApiProcessorTest {


    @Mock
    private SelfcareApiService selfcareApiService;

    @InjectMocks
    private ChargingApiProcessor<UsageAuthorization> chargingApiProcessor;

    ArgumentCaptor<SubscriptionFilter> captor = ArgumentCaptor.forClass(SubscriptionFilter.class);

    @Test
    public void shouldProcessUsageAuthResponseFully() throws EcommerceException {
        String msisdn = "" + new Random().nextLong();
        UsageAuthorization uAuth = aUsageAuthorization();
        Subscription subResponse = aSubscription();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(uAuth.getPackageSubscriptionId());

        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);

        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), any(SubscriptionFilter.class)))
                .thenReturn(newArrayList(subResponse).toArray(new Subscription[1]));
        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), eq(activeFilter)))
                .thenReturn(newArrayList(subResponse).toArray(new Subscription[1]));

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(newArrayList(uAuth))
                .build());

//              selfcareApiService.getSubscriptions(locale, CLIENT_ID.value(), msisdn, 0, filter);
        InOrder inorder = Mockito.inOrder(selfcareApiService);
        inorder.verify(selfcareApiService, times(2)).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), any(SubscriptionFilter.class));
//        inorder.verify(selfcareApiService).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), any());

//        assertEquals(sub.getSubscriptionId(), captor.getValue().getSubscriptionId());
//        assertEquals(SubscriptionStatus.ACTIVE, captor.getValue().getSubscriptionStatus());

    }


}
