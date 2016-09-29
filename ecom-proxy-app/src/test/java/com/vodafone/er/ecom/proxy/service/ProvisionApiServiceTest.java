package com.vodafone.er.ecom.proxy.service;

import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.global.er.decoupling.client.ProvisionApiDecouplingImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class ProvisionApiServiceTest {

    @InjectMocks
    private ProvisionApiService provisionApiService;

    @Mock
    private ErApiManager erApiManager;
    @Mock
    private ProvisionApiDecouplingImpl provisionApi;

    @Test
    public void shouldUpdateSuccessfully() throws Exception {

        //given
        when(erApiManager.getProvisionApi(Locale.UK)).thenReturn(provisionApi);
        when(provisionApi.updateServiceStatus("123", 2, 2)).thenReturn(true);

        //when
        boolean result = provisionApiService.updateServiceStatus(Locale.UK, "123", 2, 2);
        assertTrue(result);

        //then
        InOrder inOrder = inOrder(erApiManager, provisionApi);
        inOrder.verify(erApiManager).getProvisionApi(Locale.UK);
        inOrder.verify(provisionApi).updateServiceStatus("123", 2, 2);
    }

    @Test
    public void shouldNotUpdateSuccessfully() throws Exception {

        when(erApiManager.getProvisionApi(Locale.UK)).thenReturn(provisionApi);
        when(provisionApi.updateServiceStatus("123", 2, 2)).thenReturn(false);

        boolean result = provisionApiService.updateServiceStatus(Locale.UK, "123", 2, 2);
        assertFalse(result);

        InOrder inOrder = inOrder(erApiManager, provisionApi);

        inOrder.verify(erApiManager).getProvisionApi(Locale.UK);
        inOrder.verify(provisionApi).updateServiceStatus("123", 2, 2);

    }
}
