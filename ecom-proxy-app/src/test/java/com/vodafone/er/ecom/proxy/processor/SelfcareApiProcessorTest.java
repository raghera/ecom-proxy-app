package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.aCatalogPackage;
import static com.vodafone.er.ecom.proxy.data.builder.SubscriptionDataBuilder.aSubscription;
import static com.vodafone.er.ecom.proxy.data.builder.TransactionDataBuilder.aTransaction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class SelfcareApiProcessorTest {

    @Mock
    private CatalogApiService catalogApiService;
    @Mock
    private CatalogApiProcessor<CatalogPackage> catalogApiProcessor;

    @InjectMocks
    private SelfcareApiProcessor<List<?>> selfcareApiProcessor;

    @Test
    public void shouldProcessSelfcareApiSubscriptions() {
        List<Subscription> subscriptions = newArrayList(aSubscription());
        CatalogPackage pack = aCatalogPackage();
        String msisdn = "" + new Random().nextLong();

        when(catalogApiService.getCatalogPackage(Locale.UK, subscriptions.get(0).getPackageId()))
                .thenReturn(pack);

        RequestResult<List<?>> requestResult = new RequestResult.Builder<List<?>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(subscriptions)
                .build();

        selfcareApiProcessor.process(requestResult);

        verify(catalogApiService).getCatalogPackage(Locale.UK, subscriptions.get(0).getPackageId());
        verify(catalogApiProcessor).populatePricePointInPackage(pack, subscriptions.get(0).getPricePoint().getId());
        verifyNoMoreInteractions(catalogApiService, catalogApiProcessor);

        //Should have populated the Transactions with sub info
        assertEquals(subscriptions.get(0), subscriptions.get(0).getPaymentTransactions().get(0).getSubscription());
        assertEquals(subscriptions.get(0), subscriptions.get(0).getModifyTransactions().get(0).getSubscription());
        assertEquals(2, subscriptions.get(0).getTransactions().size());

        //Should have populated transactions with payment and modify transactions in dataset
        assertTrue(subscriptions.get(0).getTransactions().contains(subscriptions.get(0).getPaymentTransactions().get(0)));
        assertTrue(subscriptions.get(0).getTransactions().contains(subscriptions.get(0).getModifyTransactions().get(0)));

        assertEquals(pack, subscriptions.get(0).getPackage());
    }

    @Test
    public void shouldNotProcessSelfcareApiSubscriptionsWhenNoResults() {
        selfcareApiProcessor.process(new RequestResult.Builder<List<?>>()
                .msisdn("" + new Random().nextLong())
                .locale(Locale.UK)
                .response(newArrayList())
                .build());

        verifyZeroInteractions(catalogApiService, catalogApiProcessor);
    }

    @Test
    public void shouldNotRemoveExistingTransWhenThereAreNoPaymentOrModifyTransReturned() {
        List<Subscription> subscriptions = newArrayList(aSubscription());
        Transaction trans = aTransaction();
        subscriptions.get(0).setTransactions(newArrayList(trans));
        subscriptions.get(0).setPaymentTransactions(newArrayList());
        subscriptions.get(0).setModifyTransactions(newArrayList());

        CatalogPackage pack = aCatalogPackage();
        String msisdn = "" + new Random().nextLong();

        when(catalogApiService.getCatalogPackage(Locale.UK, subscriptions.get(0).getPackageId()))
                .thenReturn(pack);

        selfcareApiProcessor.process(new RequestResult.Builder<List<?>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(subscriptions)
                .build());

        verify(catalogApiService).getCatalogPackage(Locale.UK, subscriptions.get(0).getPackageId());
        verify(catalogApiProcessor).populatePricePointInPackage(pack, subscriptions.get(0).getPricePoint().getId());
        verifyNoMoreInteractions(catalogApiService, catalogApiProcessor);

        assertEquals(1, subscriptions.get(0).getTransactions().size());
        assertEquals(trans, subscriptions.get(0).getTransactions().get(0));
        assertEquals(pack, subscriptions.get(0).getPackage());
    }

    @Test
    public void shouldNotSetPricePointIdIfCatalogPackageReturnsNull() {
        List<Subscription> subscriptions = newArrayList(aSubscription());
        CatalogPackage pack = aCatalogPackage();
        String msisdn = "" + new Random().nextLong();

        when(catalogApiService.getCatalogPackage(Locale.UK, subscriptions.get(0).getPackageId()))
                .thenReturn(null);

        selfcareApiProcessor.process(new RequestResult.Builder<List<?>>()
                .msisdn(msisdn)
                .locale(Locale.UK)
                .response(subscriptions)
                .build());

        verify(catalogApiService).getCatalogPackage(Locale.UK, subscriptions.get(0).getPackageId());
        verifyZeroInteractions(catalogApiProcessor);
        verifyNoMoreInteractions(catalogApiService);

        //Should have populated the Transactions with sub info
        assertEquals(subscriptions.get(0), subscriptions.get(0).getPaymentTransactions().get(0).getSubscription());
        assertEquals(subscriptions.get(0), subscriptions.get(0).getModifyTransactions().get(0).getSubscription());
        assertEquals(2, subscriptions.get(0).getTransactions().size());

        //Should have populated transactions with payment and modify transactions in dataset
        assertTrue(subscriptions.get(0).getTransactions().contains(subscriptions.get(0).getPaymentTransactions().get(0)));
        assertTrue(subscriptions.get(0).getTransactions().contains(subscriptions.get(0).getModifyTransactions().get(0)));

    }

}
