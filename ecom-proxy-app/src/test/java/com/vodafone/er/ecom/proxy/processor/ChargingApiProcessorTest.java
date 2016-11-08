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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.SubscriptionDataBuilder.aSubscription;
import static com.vodafone.er.ecom.proxy.data.builder.UsageAuthorizationDataBuilder.aUsageAuthorization;
import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

        SubscriptionFilterImpl activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);

        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), any(SubscriptionFilter.class)))
                .thenReturn(newArrayList(subResponse).toArray(new Subscription[1]));

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(newArrayList(uAuth))
                .build());

        verify(selfcareApiService, times(2)).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), captor.capture());

        final List<SubscriptionFilter> argFilters = captor.getAllValues();

        assertThat(filter).as("Comparing filter with SubscriptionId").isEqualToComparingFieldByField(argFilters.get(0));
        assertThat(activeFilter).as("Comparing filter with SubscriptionStatus object").isEqualToComparingFieldByField(argFilters.get(1));

        assertEquals(subResponse, uAuth.getSubscription());
    }

    @Test
    public void shouldNotProcessWhenMoreThanOneSubReturned() throws EcommerceException {
        String msisdn = "" + new Random().nextLong();
        UsageAuthorization uAuth = aUsageAuthorization();
        Subscription subResponse = aSubscription();
        Subscription activeSubResponse = aSubscription();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(uAuth.getPackageSubscriptionId());
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);

        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(filter)))
                .thenReturn(newArrayList(subResponse, aSubscription()).toArray(new Subscription[2]));
        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(activeFilter)))
                .thenReturn(newArrayList(activeSubResponse).toArray(new Subscription[1]));


        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(newArrayList(uAuth))
                .build());

        verify(selfcareApiService, times(2)).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), captor.capture());

        final List<SubscriptionFilter> argFilters = captor.getAllValues();

        assertThat(filter).as("Comparing filter with SubscriptionId").isEqualToComparingFieldByField(argFilters.get(0));
        assertThat(activeFilter).as("Comparing filter with SubscriptionStatus object").isEqualToComparingFieldByField(argFilters.get(1));

        assertEquals(1, uAuth.getActiveSubscriptions().size());
        assertEquals(activeSubResponse, uAuth.getActiveSubscriptions().get(0));
    }

    @Test
    public void shouldGetActiveSubsWhenNullSubsReturnedWithSubId() throws EcommerceException {
        String msisdn = "" + new Random().nextLong();
        UsageAuthorization uAuth = aUsageAuthorization();
        Subscription subResponse = aSubscription();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(uAuth.getPackageSubscriptionId());
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);

        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(filter)))
                .thenReturn(null);
        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(activeFilter)))
                .thenReturn(newArrayList(subResponse).toArray(new Subscription[1]));

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(newArrayList(uAuth))
                .build());

        verify(selfcareApiService, times(2)).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), captor.capture());

        final List<SubscriptionFilter> argFilters = captor.getAllValues();

        assertThat(filter).as("Comparing filter with SubscriptionId").isEqualToComparingFieldByField(argFilters.get(0));
        assertThat(activeFilter).as("Comparing filter with SubscriptionStatus object").isEqualToComparingFieldByField(argFilters.get(1));
    }

    @Test
    public void shouldHandleNullActiveSubsReturned() throws EcommerceException {

        String msisdn = "" + new Random().nextLong();
        UsageAuthorization uAuth = aUsageAuthorization();
        Subscription subResponse = aSubscription();
        Subscription activeSubResponse = null;
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(uAuth.getPackageSubscriptionId());
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);

        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(filter)))
                .thenReturn(newArrayList(subResponse, aSubscription()).toArray(new Subscription[2]));
        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(activeFilter)))
                .thenReturn(null);

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(newArrayList(uAuth))
                .build());

        verify(selfcareApiService, times(2)).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), captor.capture());

        final List<SubscriptionFilter> argFilters = captor.getAllValues();

        assertThat(filter).as("Comparing filter with SubscriptionId").isEqualToComparingFieldByField(argFilters.get(0));
        assertThat(activeFilter).as("Comparing filter with SubscriptionStatus object").isEqualToComparingFieldByField(argFilters.get(1));
        assertNull(uAuth.getActiveSubscriptions());

    }

    @Test
    public void shouldHandleEcommerceExceptionForGetSubsFromCore() throws EcommerceException {

        String msisdn = "" + new Random().nextLong();
        UsageAuthorization uAuth = aUsageAuthorization();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(uAuth.getPackageSubscriptionId());
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);

        when(selfcareApiService.getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), refEq(filter)))
                .thenThrow(new EcommerceException("This is a test exception"));

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(newArrayList(uAuth))
                .build());

        verify(selfcareApiService).getSubscriptions(eq(Locale.UK), eq(CLIENT_ID.value()), eq(msisdn), eq(0), any(SubscriptionFilter.class));

        final List<SubscriptionFilter> argFilters = captor.getAllValues();

        assertThat(filter).as("Comparing filter with SubscriptionId").isEqualToComparingFieldByField(argFilters.get(0));
        assertThat(activeFilter).as("Comparing filter with SubscriptionStatus object").isEqualToComparingFieldByField(argFilters.get(1));
        assertNull(uAuth.getActiveSubscriptions());

    }


    @Test
    public void shouldNotProcessWhenResponseListEmpty() throws EcommerceException {

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn("" + new Random().nextLong())
                .locale(Locale.UK)
                .response(newArrayList())
                .build());

        verifyZeroInteractions(selfcareApiService);
    }
    @Test
    public void shouldNotProcessWhenResponseListNull() throws EcommerceException {

        chargingApiProcessor.process(new RequestResult.Builder<List<UsageAuthorization>>()
                .msisdn("" + new Random().nextLong())
                .locale(Locale.UK)
                .response(newArrayList())
                .build());

        verifyZeroInteractions(selfcareApiService);
    }

}
