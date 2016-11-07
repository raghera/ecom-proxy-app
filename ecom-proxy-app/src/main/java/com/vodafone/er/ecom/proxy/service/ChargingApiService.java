package com.vodafone.er.ecom.proxy.service;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAuthorizationException;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
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
public class ChargingApiService {

    @Autowired
    private SelfcareApiService selfcareApiService;
    @Autowired
    private ErApiManager erApiManager;
    @Resource(name = "chargingApiProcessor")
    private PostProcessor<RequestResult<List<?>>> postProcessor;

    public UsageAuthorization usageAuthRateCharge(Locale locale, String clientId, String msisdn, String serviceId,
                                                  UsageAttributes usageAttributes) throws EcommerceException {
        Optional<UsageAuthorization> usageAuthOpt =
                Optional.ofNullable(erApiManager.getChargingApi(locale, clientId)
                .usageAuthRateCharge(clientId, msisdn, serviceId, usageAttributes));
        usageAuthOpt.ifPresent(usageAuth ->
                postProcessor.process(new RequestResult.Builder<List<?>>()
                        .response(Lists.newArrayList(usageAuth))
                        .msisdn(msisdn)
                        .locale(locale)
                        .build())
        );

        return usageAuthOpt.orElse(null);
    }

    public UsageAuthorization usageAuth(Locale locale, String clientId, String msisdn, String serviceId, UsageAttributes attributes)
            throws UsageAuthorizationException {

        Optional<UsageAuthorization> usageAuthOpt =
                Optional.ofNullable(erApiManager.getChargingApi(locale, clientId)
                .usageAuth(clientId,msisdn,serviceId, attributes));

        usageAuthOpt.ifPresent(usageAuth ->
                postProcessor.process(new RequestResult.Builder<List<?>>()
                        .response(Lists.newArrayList(usageAuth))
                        .msisdn(msisdn)
                        .locale(locale)
                        .build())
        );

        return usageAuthOpt.orElse(null);
    }

    public UsageAuthorization usageAuthRate(Locale locale, String clientId, String msisdn, String serviceId, UsageAttributes usageAttributes)
            throws EcommerceException{

        Optional<UsageAuthorization> usageAuthOpt =
                Optional.ofNullable(erApiManager.getChargingApi(locale, clientId)
                .usageAuthRate(clientId, msisdn, serviceId, usageAttributes));

        usageAuthOpt.ifPresent(usageAuth ->
                postProcessor.process(new RequestResult.Builder<List<?>>()
                        .response(Lists.newArrayList(usageAuth))
                        .msisdn(msisdn)
                        .locale(locale)
                        .build())
        );

        return usageAuthOpt.orElse(null);
    }

    public UsageAuthorization usageComplete(Locale locale, String eventReservationId, int deliveryStatus) throws EcommerceException {

        //Cannot populate anything else here since there is no msisdn available
        Optional<UsageAuthorization> auth = Optional.ofNullable(erApiManager.getChargingApi(locale, CLIENT_ID.value())
                .usageComplete(CLIENT_ID.value(), eventReservationId, deliveryStatus));

        //Currently no msisdn is returned here so cannot populate anything else
//        Optional<String> msisdnOpt = Optional.of(auth.getSubscription().getMsisdn());
//        msisdnOpt.ifPresent(msisdn -> processUsageAuthResponse(locale, msisdn, auth));

        return auth.orElse(null);
    }
}
