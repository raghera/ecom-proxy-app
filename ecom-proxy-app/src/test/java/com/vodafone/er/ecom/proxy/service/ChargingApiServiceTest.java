package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.data.builder.UsageAuthorizationDataBuilder.aUsageAuthorization;
import static com.vodafone.er.ecom.proxy.data.builder.UsageAuthorizationDataBuilder.aUsageAuthorizationFailure;
import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class ChargingApiServiceTest {

    @Mock
    private PostProcessor<RequestResult<List<?>>> postProcessor;
    @Mock
    private ErApiManager erApiManager;
    @Mock
    private ChargingApi chargingApi;

    private ArgumentCaptor<RequestResult> captor = ArgumentCaptor.forClass(RequestResult.class);

    @InjectMocks
    private ChargingApiService chargingApiService;

    @Test
    public void shouldCallUsageAuth() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuth(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(aUsageAuthorization());

        UsageAuthorization result =
                chargingApiService.usageAuth(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNotNull(result);
        assertThat(result.isSuccess()).isTrue();

        InOrder inOrder = inOrder(erApiManager, chargingApi, postProcessor);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuth(CLIENT_ID.value(), msisdn, serviceId, attributes);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, chargingApi, postProcessor);

        RequestResult<List<UsageAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aUsageAuthorization());
    }

    @Test
    public void shouldCallUsageAuthAndProcessResponseWhenResultIsFalse() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuth(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(aUsageAuthorizationFailure());

        UsageAuthorization result =
                chargingApiService.usageAuth(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNotNull(result);
        assertThat(result.isSuccess()).isFalse();

        InOrder inOrder = inOrder(erApiManager, chargingApi, postProcessor);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuth(CLIENT_ID.value(), msisdn, serviceId, attributes);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, chargingApi, postProcessor);

        RequestResult<List<UsageAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aUsageAuthorizationFailure());

    }

    @Test
    public void shouldCallUsageAuthNotCallProcessWhenResponseIsNull() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuth(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(null);

        UsageAuthorization result =
                chargingApiService.usageAuth(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNull(result);

        InOrder inOrder = inOrder(erApiManager, chargingApi);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuth(CLIENT_ID.value(), msisdn, serviceId, attributes);
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, chargingApi);
    }

    @Test
    public void shouldCallUsageAuthRate() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuthRate(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(aUsageAuthorization());

        UsageAuthorization result =
                chargingApiService.usageAuthRate(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNotNull(result);
        assertThat(result.isSuccess()).isTrue();

        InOrder inOrder = inOrder(erApiManager, chargingApi, postProcessor);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuthRate(CLIENT_ID.value(), msisdn, serviceId, attributes);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, chargingApi, postProcessor);

        RequestResult<List<UsageAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aUsageAuthorization());
    }

    @Test
    public void shouldCallUsageAuthRateAndProcessResponseWhenResultIsFalse() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuthRate(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(aUsageAuthorizationFailure());

        UsageAuthorization result =
                chargingApiService.usageAuthRate(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNotNull(result);
        assertThat(result.isSuccess()).isFalse();

        InOrder inOrder = inOrder(erApiManager, chargingApi, postProcessor);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuthRate(CLIENT_ID.value(), msisdn, serviceId, attributes);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, chargingApi, postProcessor);

        RequestResult<List<UsageAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aUsageAuthorizationFailure());
    }

    @Test
    public void shouldCallUsageAuthRateNotCallProcessWhenResponseIsNull() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuthRate(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(null);

        UsageAuthorization result =
                chargingApiService.usageAuthRate(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNull(result);

        InOrder inOrder = inOrder(erApiManager, chargingApi);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuthRate(CLIENT_ID.value(), msisdn, serviceId, attributes);
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, chargingApi);
    }

    @Test
    public void shouldCallUsageAuthRateCharge() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuthRateCharge(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(aUsageAuthorization());

        UsageAuthorization result =
                chargingApiService.usageAuthRateCharge(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNotNull(result);
        assertThat(result.isSuccess()).isTrue();

        InOrder inOrder = inOrder(erApiManager, chargingApi, postProcessor);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuthRateCharge(CLIENT_ID.value(), msisdn, serviceId, attributes);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, chargingApi, postProcessor);

        RequestResult<List<UsageAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aUsageAuthorization());
    }

    @Test
    public void shouldCallUsageAuthRateChargeAndProcessResponseWhenResultIsFalse() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuthRateCharge(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(aUsageAuthorizationFailure());

        UsageAuthorization result =
                chargingApiService.usageAuthRateCharge(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNotNull(result);
        assertThat(result.isSuccess()).isFalse();

        InOrder inOrder = inOrder(erApiManager, chargingApi, postProcessor);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuthRateCharge(CLIENT_ID.value(), msisdn, serviceId, attributes);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, chargingApi, postProcessor);

        RequestResult<List<UsageAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aUsageAuthorizationFailure());
    }

    @Test
    public void shouldCallUsageAuthRateChargeNotCallProcessWhenResponseIsNull() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        String serviceId = "packageId_X";
        UsageAttributes attributes = new UsageAttributes();

        when(erApiManager.getChargingApi(Locale.UK, CLIENT_ID.value())).thenReturn(chargingApi);
        when(chargingApi.usageAuthRateCharge(CLIENT_ID.value(), msisdn, serviceId, attributes))
                .thenReturn(null);

        UsageAuthorization result =
                chargingApiService.usageAuthRateCharge(Locale.UK, CLIENT_ID.value(), msisdn, serviceId, attributes);
        assertNull(result);

        InOrder inOrder = inOrder(erApiManager, chargingApi);
        inOrder.verify(erApiManager).getChargingApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(chargingApi).usageAuthRateCharge(CLIENT_ID.value(), msisdn, serviceId, attributes);
        verifyZeroInteractions(postProcessor);
        verifyNoMoreInteractions(erApiManager, chargingApi);
    }

}



