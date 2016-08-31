package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.UsageAttributes;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAuthorizationException;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.constants.EcomAppEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Component
public class ChargingApiService {

    private Logger logger = LoggerFactory.getLogger(CatalogApiService.class);

    private ChargingApi chargingApi;
    private SelfcareApiService selfcareApiService;
    private CatalogApiService catalogApiService;

    public ChargingApiService(Locale locale) throws EcommerceException {
        selfcareApiService = new SelfcareApiService(locale);
        catalogApiService = new CatalogApiService();
    }

    public ChargingApi getChargingApi(Locale locale, String clientId) {
        if (null == chargingApi) {
            chargingApi = DecouplingApiFactory.getChargingApi(locale , clientId);
        }
        return chargingApi;
    }

    public UsageAuthorization processUsageAuth(Locale locale, String clientId, String msisdn, String serviceId,UsageAttributes attributes)
            throws UsageAuthorizationException {

        UsageAuthorization usageAuthorization = getChargingApi(locale, clientId)
                .usageAuth(clientId,msisdn,serviceId, attributes);

        populateSubscription(locale, msisdn, usageAuthorization);
        populateActiveSubscriptions(locale, msisdn, usageAuthorization);
        populateUsageAuthServicePricePointFromSubscription(locale, msisdn, usageAuthorization);
        populatePackageFromSubscription(usageAuthorization);

        //TODO populate MatchingAttributes
        //populateMatchingAttributes
        usageAuthorization.getMatchingAttributes();

        return usageAuthorization;
    }

    //finds the complete service pricepoint object from the subscription and replaces the one on the usageAuth
    public void populateUsageAuthServicePricePointFromSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {

//        PricePoint servicePp = catalogApiService.getPricePoint(locale, usageAuthorization.getServicePricePoint().getId());
//        usageAuthorization.setPricePoint(servicePp);

//TODO could get the Pricepoint from the Subscription as per below but need the ServiceId
        Optional<String> ppIdOpt = Optional.of(usageAuthorization.getServicePricePoint().getId());

        ppIdOpt.ifPresent(ppId -> {
            //Find the full service object
            List<CatalogService> services = usageAuthorization.getSubscription().getPackage().getServices();
            Optional<CatalogService> foundService = services.stream()
                    .filter(catalogService -> null != catalogService.getPricePoints().getPricePoint(ppId).getId())
                    .findFirst();
            foundService.ifPresent(service -> {
                PricePoint foundPp = service.getPricePoints().getPricePoint(ppId);
                usageAuthorization.setPricePoint(foundPp);
            });
        });
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
}
