package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAuthorizationException;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.EcomAppEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Service
public class ChargingApiService {

    private Logger logger = LoggerFactory.getLogger(CatalogApiService.class);

    private SelfcareApiService selfcareApiService;
    private ErApiManager erApiManager;

    public ChargingApiService() {
        selfcareApiService = new SelfcareApiService();
        erApiManager = new ErApiManager();
    }

    public UsageAuthorization processUsageAuthRateCharge(Locale locale, String clientId, String msisdn, String serviceId,
                                                         UsageAttributes usageAttributes) throws EcommerceException {

        UsageAuthorization usageAuth = erApiManager.getChargingApi(locale, clientId)
                .usageAuthRateCharge(clientId, msisdn, serviceId, usageAttributes);
        processUsageAuthResponse(locale, msisdn, usageAuth);
        return usageAuth;
    }

    public UsageAuthorization processUsageAuth(Locale locale, String clientId, String msisdn, String serviceId,UsageAttributes attributes)
            throws UsageAuthorizationException {

        UsageAuthorization usageAuth = erApiManager.getChargingApi(locale, clientId)
                .usageAuth(clientId,msisdn,serviceId, attributes);
        processUsageAuthResponse(locale, msisdn, usageAuth);

        return usageAuth;
    }

    public UsageAuthorization processUsageAuthRate(Locale locale, String clientId, String msisdn, String serviceId, UsageAttributes usageAttributes)
            throws EcommerceException{

        UsageAuthorization usageAuth = erApiManager.getChargingApi(locale, clientId)
                .usageAuthRate(clientId, msisdn, serviceId, usageAttributes);

        processUsageAuthResponse(locale, msisdn, usageAuth);

        return usageAuth;

    }

    public void processUsageAuthResponse(Locale locale, String msisdn, UsageAuthorization usageAuth) {
        if(usageAuth.isSuccess()) {
            //TODO could combine populateSubscription & populateActiveSubscriptions - getAll in one
            populateSubscription(locale, msisdn, usageAuth);
            populateActiveSubscriptions(locale, msisdn, usageAuth);
            populateUsageAuthServicePricePointFromSubscription(locale, msisdn, usageAuth);
            populatePackageFromSubscription(usageAuth);
            //TODO populate MatchingAttributes
            //populateMatchingAttributes as they tend to be null
//            usageAuth.getMatchingAttributes();
        }
    }

    //finds the complete service pricepoint object from the subscription and replaces the one on the usageAuth
    public void populateUsageAuthServicePricePointFromSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {

        //The existing content
        Optional<String> ppIdOpt = Optional.of(usageAuthorization.getServicePricePoint().getId());
        Optional<Subscription> subOpt = Optional.of(usageAuthorization.getSubscription());

        if(subOpt.isPresent() && null != subOpt.get().getPackage()) {

            ppIdOpt.ifPresent(ppId -> {
                //Find the full service object
                List<CatalogService> services = subOpt.get().getPackage().getServices();
                Optional<CatalogService> foundService = services.stream()
                        .filter(catalogService -> null != catalogService.getPricePoints().getPricePoint(ppId).getId())
                        .findFirst();
                foundService.ifPresent(service -> {
                    PricePoint foundPp = service.getPricePoints().getPricePoint(ppId);
                    usageAuthorization.setPricePoint(foundPp);
                });
            });
        }
    }

    public void populatePackageFromSubscription(final UsageAuthorization usageAuthorization) {
        usageAuthorization.setPackage(usageAuthorization.getSubscription().getPackage());
    }

    public void populateSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {
        String subId = usageAuthorization.getPackageSubscriptionId();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        try {
            final Subscription [] arr = selfcareApiService.getSubscriptions(locale, CLIENT_ID.getValue(), msisdn, 0, filter);
            if(arr == null || arr.length != 1) {
                return;
            }
            usageAuthorization.setSubscription(arr[0]);
        } catch (EcommerceException e) {
            logger.error("Could not get Subscription correctly using id: {}, with exception message: {}", subId, e);
            return;
        }
    }

    public void populateActiveSubscriptions(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
        try {
            final Subscription [] activeSubs = selfcareApiService.getSubscriptions(locale, CLIENT_ID.getValue(), msisdn, 0, activeFilter);
            usageAuthorization.setActiveSubscriptions(Arrays.asList(activeSubs));
        } catch (EcommerceException e) {
            logger.error("Could not get Active Subscriptions.  Exception: {}", e );
            return;
        }
    }

    public UsageAuthorization usageComplete(Locale locale, String eventReservationId, int deliveryStatus) throws EcommerceException {

        //Cannot populate anything else here since there is no msisdn available
        UsageAuthorization auth = erApiManager.getChargingApi(locale, CLIENT_ID.getValue())
                .usageComplete(CLIENT_ID.getValue(), eventReservationId, deliveryStatus);

        //Currently no msisdn is returned here
//        Optional<String> msisdnOpt = Optional.of(auth.getSubscription().getMsisdn());
//        msisdnOpt.ifPresent(msisdn -> processUsageAuthResponse(locale, msisdn, auth));

        return auth;
    }


}
