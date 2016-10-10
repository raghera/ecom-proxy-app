package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorizationException;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.data.builder.PurchaseAuthorizationDataBuilder.aPurchaseAuthorization;
import static com.vodafone.er.ecom.proxy.data.builder.PurchaseAuthorizationDataBuilder.aPurchaseAuthorizationFailure;
import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class PurchaseApiServiceTest {

    @Captor
    private ArgumentCaptor<RequestResult<List<PurchaseAuthorization>>> captor;

    @Mock
    private ErApiManager erApiManager;
    @Mock
    private PurchaseApi purchaseApi;
    @Mock
    private PostProcessor postProcessor;

    @InjectMocks
    private PurchaseApiService purchaseApiService;

    @Test
    public void shouldPurchasePackage() throws Exception {
        String packageId = "package_X";
        String msisdn= String.valueOf(new Random().nextLong());
        PurchaseAttributes attrs = new PurchaseAttributes();

        when(erApiManager.getPurchaseApi(Locale.UK, CLIENT_ID.value())).thenReturn(purchaseApi);
        when(purchaseApi.purchasePackageMsisdn(CLIENT_ID.value(), msisdn, packageId, attrs)).thenReturn(aPurchaseAuthorization());

        final PurchaseAuthorization result = purchaseApiService.purchasePackageMsisdn(Locale.UK, CLIENT_ID.value(), msisdn, packageId, attrs);
        assertNotNull(result);
        assertTrue(result.isSuccess());

        verify(erApiManager).getPurchaseApi(any(Locale.class), any(String.class));
        verify(purchaseApi).purchasePackageMsisdn(CLIENT_ID.value(), msisdn, packageId, attrs);
    }

    @Test
    public void shouldNotPurchasePackage() throws Exception {
        String packageId = "package_X";
        String msisdn= String.valueOf(new Random().nextLong());
        PurchaseAttributes attrs = new PurchaseAttributes();

        when(erApiManager.getPurchaseApi(Locale.UK, CLIENT_ID.value())).thenReturn(purchaseApi);
        when(purchaseApi.purchasePackageMsisdn(CLIENT_ID.value(), msisdn, packageId, attrs)).thenReturn(aPurchaseAuthorizationFailure());

        final PurchaseAuthorization result = purchaseApiService.purchasePackageMsisdn(Locale.UK, CLIENT_ID.value(), msisdn, packageId, new PurchaseAttributes());
        assertNotNull(result);
        assertFalse(result.isSuccess());

        verify(erApiManager).getPurchaseApi(any(Locale.class), any(String.class));
        verify(purchaseApi).purchasePackageMsisdn(CLIENT_ID.value(), msisdn, packageId, attrs);
    }

    @Test(expected = PurchaseAuthorizationException.class)
    public void shouldThrowPurchaseAuthException() throws Exception {
        String packageId = "package_X";
        String msisdn= String.valueOf(new Random().nextLong());
        PurchaseAttributes attrs = new PurchaseAttributes();

        when(erApiManager.getPurchaseApi(Locale.UK, CLIENT_ID.value())).thenReturn(purchaseApi);
        when(purchaseApi.purchasePackageMsisdn(CLIENT_ID.value(), msisdn, packageId, attrs))
                .thenThrow(PurchaseAuthorizationException.class);

        purchaseApiService.purchasePackageMsisdn(Locale.UK, CLIENT_ID.value(), msisdn, packageId, new PurchaseAttributes());
        fail();
    }

    @Test
    public void shouldRenewPurchasePackage() throws Exception {
        String subId = "package_X";
        String msisdn= String.valueOf(new Random().nextLong());
        PurchaseAttributes attrs = new PurchaseAttributes();

        when(erApiManager.getPurchaseApi(Locale.UK, CLIENT_ID.value())).thenReturn(purchaseApi);
        when(purchaseApi.renewPurchasePackageMsisdn(CLIENT_ID.value(), msisdn, subId, attrs))
                .thenReturn(aPurchaseAuthorization());

        final PurchaseAuthorization result = purchaseApiService.renewPurchasePackageMsisdn(Locale.UK, CLIENT_ID.value(), msisdn, subId, attrs);
        assertNotNull(result);
        assertTrue(result.isSuccess());

        InOrder inOrder = inOrder(erApiManager, purchaseApi, postProcessor);
        inOrder.verify(erApiManager).getPurchaseApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(purchaseApi).renewPurchasePackageMsisdn(CLIENT_ID.value(), msisdn, subId, attrs);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, purchaseApi, postProcessor);

        RequestResult<List<PurchaseAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aPurchaseAuthorization());
        assertThat(argument.getLocale()).isEqualTo(Locale.UK);
        assertThat(argument.getMsisdn().get()).isEqualTo(msisdn);
    }

    @Test
    public void shouldNotRenewPurchasePackage() throws Exception {
        String subId = "package_X";
        String msisdn= String.valueOf(new Random().nextLong());
        PurchaseAttributes attrs = new PurchaseAttributes();

        when(erApiManager.getPurchaseApi(Locale.UK, CLIENT_ID.value())).thenReturn(purchaseApi);
        when(purchaseApi.renewPurchasePackageMsisdn(CLIENT_ID.value(), msisdn, subId, attrs))
                .thenReturn(aPurchaseAuthorizationFailure());

        final PurchaseAuthorization result = purchaseApiService.renewPurchasePackageMsisdn(Locale.UK, CLIENT_ID.value(), msisdn, subId, attrs);
        assertNotNull(result);
        assertFalse(result.isSuccess());

        InOrder inOrder = inOrder(erApiManager, purchaseApi, postProcessor);
        inOrder.verify(erApiManager).getPurchaseApi(Locale.UK, CLIENT_ID.value());
        inOrder.verify(purchaseApi).renewPurchasePackageMsisdn(CLIENT_ID.value(), msisdn, subId, attrs);
        inOrder.verify(postProcessor).process(captor.capture());
        verifyNoMoreInteractions(erApiManager, purchaseApi, postProcessor);

        RequestResult<List<PurchaseAuthorization>> argument = captor.getValue();
        assertThat(argument.getResponse().get(0)).isEqualToComparingFieldByField(aPurchaseAuthorizationFailure());
        assertThat(argument.getLocale()).isEqualTo(Locale.UK);
        assertThat(argument.getMsisdn().get()).isEqualTo(msisdn);
    }
}
