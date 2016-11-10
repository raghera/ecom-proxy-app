package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.common.ChargingMethod;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import com.vodafone.er.ecom.proxy.processor.SelfcareApiProcessor;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import com.vodafone.global.er.subscriptionmanagement.TransactionFilterImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.data.builder.SubscriptionDataBuilder.aSubscription;
import static com.vodafone.er.ecom.proxy.data.builder.SubscriptionDataBuilder.aSubscriptionArray;
import static com.vodafone.er.ecom.proxy.data.builder.TransactionDataBuilder.aTransaction;
import static com.vodafone.er.ecom.proxy.data.builder.TransactionDataBuilder.aTransactionArray;
import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class SelfcareApiServiceTest {

    @Mock
    private PostProcessor<RequestResult<List<?>>> postProcessor;
    @Mock
    private ErApiManager erApiManager;
    @Mock
    private SelfcareApi selfcareApi;
    @Mock
    private SelfcareApiProcessor selfcareApiProcessor;

    private ArgumentCaptor<RequestResult> captor = ArgumentCaptor.forClass(RequestResult.class);
    private ArgumentCaptor<SubscriptionFilter> filterCaptor = ArgumentCaptor.forClass(SubscriptionFilter.class);

    @InjectMocks
    private SelfcareApiService selfcareApiService;

    @Test
    public void shouldGetSubscription() throws Exception {
        String subId = String.valueOf(new Random().nextLong());
        String msisdn = String.valueOf(new Random().nextLong());
        Subscription[] subs = new Subscription[]{aSubscription()};

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), any(SubscriptionFilter.class))).thenReturn(subs);

        Optional<Subscription> result = selfcareApiService.getSubscription(Locale.UK, msisdn, subId);
        assertNotNull(result);
        assertNotNull(result.get());
        assertThat(result.get()).isEqualToComparingFieldByField(subs[0]);

        InOrder inorder = inOrder(erApiManager, selfcareApi, postProcessor);
        inorder.verify(erApiManager).getSelfcareApi(Locale.UK);
        inorder.verify(selfcareApi).getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), filterCaptor.capture());
        inorder.verify(postProcessor).process(captor.capture());

        RequestResult<List<Subscription>> argument = captor.getValue();
        assertThat(argument.getResponse()).isNotNull();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(subs[0]);
        assertThat(argument.getLocale()).isEqualTo(Locale.UK);
        assertThat(argument.getMsisdn().get()).isEqualTo(msisdn);

        SubscriptionFilter filterArg = filterCaptor.getValue();
        assertThat(filterArg.getSubscriptionId()).isEqualTo(subId);
    }

    @Test
    public void shouldReturnEmptyOptional() throws Exception {
        String subId = String.valueOf(new Random().nextLong());
        String msisdn = String.valueOf(new Random().nextLong());

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), any(SubscriptionFilter.class))).thenReturn(new Subscription[0]);

        Optional<Subscription> result = selfcareApiService.getSubscription(Locale.UK, msisdn, subId);
        assertNotNull(result);
        assertThat(result).isEqualTo(Optional.empty());

        InOrder inorder = inOrder(erApiManager, selfcareApi);
        inorder.verify(erApiManager).getSelfcareApi(Locale.UK);
        inorder.verify(selfcareApi).getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), filterCaptor.capture());
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, selfcareApi);

        SubscriptionFilter filterArg = filterCaptor.getValue();
        assertThat(filterArg.getSubscriptionId()).isEqualTo(subId);
    }

    @Test
    public void shouldGetSubscriptions() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        Subscription[] subsArr = aSubscriptionArray(5);

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), eq(filter)))
                .thenReturn(subsArr);

        Subscription[] result = selfcareApiService.getSubscriptions(Locale.UK, CLIENT_ID.value(), msisdn, 0, filter);
        assertNotNull(result);
        assertThat(result.length).isEqualTo(subsArr.length);
        assertThat(result).isEqualTo(subsArr);

        InOrder inorder = inOrder(erApiManager, selfcareApi, postProcessor);
        inorder.verify(erApiManager).getSelfcareApi(Locale.UK);
        inorder.verify(selfcareApi).getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), eq(filter));
        inorder.verify(postProcessor).process(captor.capture());

        RequestResult<List<Subscription>> argument = captor.getValue();
        assertThat(argument.getResponse()).isNotNull();
        assertThat(argument.getResponse().size()).isEqualTo(subsArr.length);
        assertThat(argument.getResponse().toArray(new Subscription[argument.getResponse().size()])).isEqualTo(subsArr);
        assertThat(argument.getLocale()).isEqualTo(Locale.UK);
        assertThat(argument.getMsisdn().get()).isEqualTo(msisdn);

    }

    @Test
    public void shouldReturnEmptyArray() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        Subscription[] subsArr = new Subscription[0];

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), eq(filter)))
                .thenReturn(subsArr);

        Subscription[] result = selfcareApiService.getSubscriptions(Locale.UK, CLIENT_ID.value(), msisdn, 0, filter);
        assertNotNull(result);
        assertThat(result.length).isEqualTo(subsArr.length);
        assertThat(result).isEqualTo(subsArr);

        InOrder inorder = inOrder(erApiManager, selfcareApi);
        inorder.verify(erApiManager).getSelfcareApi(Locale.UK);
        inorder.verify(selfcareApi).getSubscriptions(eq(CLIENT_ID.value()), eq(msisdn), anyInt(), eq(filter));
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, selfcareApi);

    }

    @Test
    public void shouldGetTransaction() throws Exception {
        TransactionFilter filter = new TransactionFilterImpl();
        Transaction trans = aTransaction();

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getTransaction(CLIENT_ID.value(), filter)).thenReturn(trans);

        Optional<Transaction> transOpt = selfcareApiService.getTransaction(Locale.UK, CLIENT_ID.value(), filter);
        assertNotNull(transOpt);
        assertTrue(transOpt.isPresent());
        assertThat(transOpt.get()).isEqualToComparingFieldByField(trans);

        verify(erApiManager).getSelfcareApi(Locale.UK);
        verify(selfcareApi).getTransaction(CLIENT_ID.value(), filter);
        verifyNoMoreInteractions(erApiManager, selfcareApi);
    }

    @Test
    public void shouldGetTransactions() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        TransactionFilter filter = new TransactionFilterImpl();
        Transaction[] transArr = aTransactionArray(5);

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getTransactions(CLIENT_ID.value(), msisdn, 0, filter)).thenReturn(transArr);

        Transaction[] results = selfcareApiService.getTransactions(Locale.UK, CLIENT_ID.value(), msisdn, 0, filter);
        assertNotNull(results);
        assertThat(results.length).isEqualTo(transArr.length);
        assertThat(results).isEqualTo(transArr);

        verify(erApiManager).getSelfcareApi(Locale.UK);
        verify(selfcareApi).getTransactions(CLIENT_ID.value(), msisdn, 0, filter);
        verifyNoMoreInteractions(erApiManager, selfcareApi);
    }

    @Test
    public void shouldGetReturnEmptyArrayWhenNoResults() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        TransactionFilter filter = new TransactionFilterImpl();
        Transaction[] transArr = new Transaction[0];

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.getTransactions(CLIENT_ID.value(), msisdn, 0, filter)).thenReturn(transArr);

        Transaction[] results = selfcareApiService.getTransactions(Locale.UK, CLIENT_ID.value(), msisdn, 0, filter);
        assertNotNull(results);
        assertThat(results.length).isEqualTo(transArr.length);

        verify(erApiManager).getSelfcareApi(Locale.UK);
        verify(selfcareApi).getTransactions(CLIENT_ID.value(), msisdn, 0, filter);
        verifyNoMoreInteractions(erApiManager, selfcareApi);
    }

    @Test
    public void shouldModifyChargingMethod() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String subId = String.valueOf(new Random().nextLong());
        String reason = "test-reason";

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.modifySubscriptionChargingMethod(CLIENT_ID.value(), msisdn, 0, subId, ChargingMethod.RECURRING, CLIENT_ID.value(), reason))
                .thenReturn(true);

        boolean result = selfcareApiService.modifySubscriptionChargingMethod(Locale.UK, CLIENT_ID.value(), msisdn, 0, subId, ChargingMethod.RECURRING, CLIENT_ID.value(), reason);
        assertTrue(result);

        verify(erApiManager).getSelfcareApi(Locale.UK);
        verify(selfcareApi).modifySubscriptionChargingMethod(CLIENT_ID.value(), msisdn, 0, subId, ChargingMethod.RECURRING, CLIENT_ID.value(), reason);
        verifyNoMoreInteractions(erApiManager, selfcareApi);
    }

    @Test
    public void shouldFailModifyChargingMethod() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String subId = String.valueOf(new Random().nextLong());
        String reason = "test-reason";

        when(erApiManager.getSelfcareApi(Locale.UK)).thenReturn(selfcareApi);
        when(selfcareApi.modifySubscriptionChargingMethod(CLIENT_ID.value(), msisdn, 0, subId, ChargingMethod.RECURRING, CLIENT_ID.value(), reason))
                .thenReturn(false);

        boolean result = selfcareApiService.modifySubscriptionChargingMethod(Locale.UK, CLIENT_ID.value(), msisdn, 0, subId, ChargingMethod.RECURRING, CLIENT_ID.value(), reason);
        assertFalse(result);

        verify(erApiManager).getSelfcareApi(Locale.UK);
        verify(selfcareApi).modifySubscriptionChargingMethod(CLIENT_ID.value(), msisdn, 0, subId, ChargingMethod.RECURRING, CLIENT_ID.value(), reason);
        verifyNoMoreInteractions(erApiManager, selfcareApi);
    }
}