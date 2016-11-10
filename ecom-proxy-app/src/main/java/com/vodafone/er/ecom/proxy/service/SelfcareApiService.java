package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vizzavi.ecommerce.business.selfcare.TransactionFilter;
import com.vodafone.application.util.Lists;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Service
public class SelfcareApiService {

    private final Logger logger = LoggerFactory.getLogger(SelfcareApiService.class);

    @Resource(name = "selfcareApiProcessor")
    private PostProcessor<RequestResult<List<?>>> postProcessor;
    @Autowired
    private ErApiManager erApiManager;

    public Optional<Subscription> getSubscription(Locale locale, String msisdn, String subId) throws EcommerceException {
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        Optional<Subscription> subs = getSubscription(locale, msisdn, 0, subId);
        if(!subs.isPresent()) {
            return Optional.empty();
        }
        return subs;
    }

    public Optional<Subscription> getSubscription(Locale locale, String msisdn, int deviceType, String subId) throws EcommerceException {
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        Subscription [] subs = getSubscriptions(locale, CLIENT_ID.value(), msisdn, deviceType, filter);
        if(subs == null || subs.length != 1) {
            return Optional.empty();
        }

        return Optional.of(subs[0]);
    }

    public Subscription [] getSubscriptions(Locale locale, String clientId, String msisdn, int device, SubscriptionFilter filter)
            throws EcommerceException{
        logger.debug("Enter SelfcareApiService.getSubscriptions");
        Subscription[] subscriptions = erApiManager.getSelfcareApi(locale).getSubscriptions(clientId, msisdn, device, filter);

        logger.debug("Enter SelfcareApiService.getSubscriptions recieved response" + subscriptions);

        if(subscriptions.length > 0) {
            logger.debug("Calling SelfcareApiService.postProcessor");

            List<Subscription> subs = Lists.newArrayList(subscriptions);
            postProcessor.process(new RequestResult.Builder<List<Subscription>>()
                    .response(subs)
                    .msisdn(msisdn)
                    .locale(locale)
                    .build());
            logger.debug("Received response from SelfcareApiService.postProcessor");
        }

        logger.debug("SelfcareApiService.getSubscriptions returning processed subscriptions" + subscriptions);

        return subscriptions;
    }

    public Optional<Transaction> getTransaction(Locale locale, String clientId, TransactionFilter filter) throws EcommerceException {
        return Optional.of(erApiManager.getSelfcareApi(locale).getTransaction(clientId, filter));
    }

    public Transaction [] getTransactions(Locale locale, String clientId, String msisdn, int accessDevice, TransactionFilter filter) throws EcommerceException {
        return erApiManager.getSelfcareApi(locale).getTransactions(clientId, msisdn, accessDevice, filter);
    }

    public boolean modifySubscriptionChargingMethod(Locale locale, String clientId, String msisdn, int deviceType,
                                                    String packageSubId, int chargingMethod, String csrId, String reason) throws Exception {
        return erApiManager.getSelfcareApi(locale).modifySubscriptionChargingMethod(clientId,msisdn,deviceType,packageSubId,chargingMethod,csrId,reason);
    }
}
