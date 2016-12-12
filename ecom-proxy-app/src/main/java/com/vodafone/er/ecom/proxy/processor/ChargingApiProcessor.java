package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.SelfcareApiService;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.EpaClientEnum.CLIENT_ID;

/**
 * Created by Ravi Aghera
 */
@Component
public class ChargingApiProcessor<T extends UsageAuthorization> implements PostProcessor<RequestResult<List<UsageAuthorization>>> {

    private static final Logger logger = LoggerFactory.getLogger(ChargingApiProcessor.class);

    @Autowired
    private SelfcareApiService selfcareApiService;

    @Override
    public void process(RequestResult<List<UsageAuthorization>> result) {
        if (!result.getResponse().isEmpty() && result.getResponse().get(0) != null) {
            result.getMsisdn().ifPresent(msisdn ->
                    processUsageAuthResponse(result.getLocale(), msisdn, result.getResponse())
            );
        }
    }

    private void processUsageAuthResponse(Locale locale, String msisdn, List<UsageAuthorization> usageAuths) {
        usageAuths.forEach(usageAuth -> {
            if(usageAuth.isSuccess()) {
                populateSubscription(locale, msisdn, usageAuth);
                populateUsageAuthServicePricePointFromSubscription(locale, msisdn, usageAuth);
                populatePackageFromSubscription(usageAuth);
            }
        });
    }

    //finds the complete service pricepoint object from the subscription and replaces the one on the usageAuth
    private void populateUsageAuthServicePricePointFromSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {

        if(null != usageAuthorization.getServicePricePoint() &&
                null != usageAuthorization.getServicePricePoint().getId() &&
                null != usageAuthorization.getSubscription() &&
                null != usageAuthorization.getSubscription().getPackage()) {

            String ppId = usageAuthorization.getServicePricePoint().getId();
            Subscription sub = usageAuthorization.getSubscription();
            //Find the full service object
            List<CatalogService> services = sub.getPackage().getServices();
            Optional<CatalogService> foundService = services.stream()
                    .filter(catalogService ->
                        null != catalogService.getPricePoints() &&
                                null != catalogService.getPricePoints().getPricePoint(ppId) &&
                                null != catalogService.getPricePoints().getPricePoint(ppId).getId())
                    .findFirst();
            foundService.ifPresent(service -> {
                PricePoint foundPp = service.getPricePoints().getPricePoint(ppId);
                usageAuthorization.setPricePoint(foundPp);
            });
        }
    }

    private void populatePackageFromSubscription(final UsageAuthorization usageAuthorization) {
        usageAuthorization.setPackage(usageAuthorization.getSubscription().getPackage());
    }

    private void populateSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {
        String subId = usageAuthorization.getPackageSubscriptionId();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);

        try {
            //First see if we've already got it
//            Optional<Subscription> subscription = usageAuthorization.getActiveSubscriptions().stream()
//                    .filter(sub -> sub.getSubscriptionId().equals(subId)).findFirst();

//            if(subscription.isPresent()) {
//                usageAuthorization.setSubscription(subscription.get());
//            }
//            else {
                final Subscription [] arr = selfcareApiService.getSubscriptions(locale, CLIENT_ID.value(), msisdn, 0, filter);
                if(arr == null || arr.length < 1) {
                    logger.warn("Could not find any subscriptions using subscriptionId: {}.", subId);
                } else if (arr.length > 1) {
                    logger.warn("Found more than one Subscription using subscriptionId: {}.", subId);
                } else {
                    usageAuthorization.setSubscription(arr[0]);
                }
//        }
            populateActiveSubscriptions(locale, msisdn, usageAuthorization);

        } catch (EcommerceException e) {
            logger.error("PostProcessor error. Could not get Subscription from ER Core correctly using id: {}, with exception message: {}. Continuing responding with original response", subId, e);
            //don't bother trying again
            return;
        }

    }

    private void populateActiveSubscriptions(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
        try {
            final Subscription [] activeSubs = selfcareApiService.getSubscriptions(locale, CLIENT_ID.value(), msisdn, 0, activeFilter);
            if(activeSubs != null) {
                usageAuthorization.setActiveSubscriptions(Arrays.asList(activeSubs));
            } else {
                logger.warn("Could not get any active subscriptions for msisdn: {}", msisdn);
            }
        } catch (EcommerceException e) {
            logger.error("PostProcessor error. Could not get ActiveSubscriptions from ER Core for msisdn: {}, with exception message: {}.", msisdn, e);
            //we have the original response so continue
        }
    }
}
