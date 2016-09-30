package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.SelfcareApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by Ravi Aghera
 */
@Component
public class PurchaseApiProcessor<T> implements PostProcessor<RequestResult<List<PurchaseAuthorization>>>{

    private static Logger logger = LoggerFactory.getLogger(PurchaseApiProcessor.class);

    @Autowired
    private SelfcareApiService selfcareApiService;

    @Override
    public void process(RequestResult<List<PurchaseAuthorization>> result) {
        result.getMsisdn().ifPresent(msisdn ->
                postProcessResult(result.getLocale(), msisdn, result.getResponse()));
    }

    public void postProcessResult(Locale locale, String msisdn, List<PurchaseAuthorization> auths) {
        auths.forEach(auth -> {
            Optional<Subscription> subOpt;
            try {
                subOpt = selfcareApiService.getSubscription(locale, msisdn , auth.getPackageSubscriptionId());
            } catch (EcommerceException e) {
                logger.warn("Postprocessing failed calling getSubscription(). Description: " + e.getErrorDescription());
                return;
            }

            subOpt.ifPresent(subscription -> {
                auth.setPackage(subscription.getPackage());
                auth.setPackageId(subscription.getPackageId());
                auth.setPricePoint(subscription.getPricePoint());
                auth.setPricePointId(subscription.getPricePoint().getId());
            });
        });
    }
}
