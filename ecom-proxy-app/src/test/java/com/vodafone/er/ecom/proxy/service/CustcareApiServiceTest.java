package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.selfcare.BasicAccount;
import com.vizzavi.ecommerce.business.selfcare.CustcareApi;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class CustcareApiServiceTest {

    @Mock
    private ErApiManager erApiManager;
    @Mock
    private CustcareApi custcareApi;

    @InjectMocks
    private CustcareApiService custcareApiService;


    @Test
    public void shouldUpdateSuccessfully() throws Exception {
        //given
        String msisdn = String.valueOf(new Random().nextLong());
        String subId = "123";

        when(erApiManager.getCustcareApi(Locale.UK)).thenReturn(custcareApi);
        when(custcareApi.inactivateSubscription(CLIENT_ID.value(), msisdn, subId, CLIENT_ID.value(), "test-reason"))
                .thenReturn(true);

        //when
        boolean result = custcareApiService.inactivateSubscription(Locale.UK, CLIENT_ID.value(), msisdn, subId, CLIENT_ID.value(), "test-reason");
        assertTrue(result);

        //then
        InOrder inOrder = inOrder(erApiManager, custcareApi);
        inOrder.verify(erApiManager).getCustcareApi(Locale.UK);
        inOrder.verify(custcareApi).inactivateSubscription(CLIENT_ID.value(), msisdn, subId, CLIENT_ID.value(), "test-reason");
    }

    @Test
    public void shouldNotUpdateSuccessfully() throws Exception {
        String msisdn = String.valueOf(new Random().nextLong());
        BasicAccount account = new BasicAccount();

        when(erApiManager.getCustcareApi(Locale.UK)).thenReturn(custcareApi);
        when(custcareApi.getBasicAccount(CLIENT_ID.value(), msisdn, 0)).thenReturn(account);

        BasicAccount result = custcareApiService.getBasicAccount(Locale.UK, CLIENT_ID.value(), msisdn, 0);
        assertNotNull(result);
        assertThat(result).isEqualToComparingFieldByField(account);

        InOrder inOrder = inOrder(erApiManager, custcareApi);

        inOrder.verify(erApiManager).getCustcareApi(Locale.UK);
        inOrder.verify(custcareApi).getBasicAccount(CLIENT_ID.value(), msisdn, 0);

    }
}
