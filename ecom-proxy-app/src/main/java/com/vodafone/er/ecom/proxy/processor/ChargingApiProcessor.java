package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionFilter;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.exception.EpaServiceException;
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
import static com.vodafone.er.ecom.proxy.exception.EpaErrorMessageEnum.ERROR_FROM_CORE;

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

    public void processUsageAuthResponse(Locale locale, String msisdn, List<UsageAuthorization> usageAuths) {
        usageAuths.forEach(usageAuth -> {
            if(usageAuth.isSuccess()) {
                populateSubscription(locale, msisdn, usageAuth);
                populateUsageAuthServicePricePointFromSubscription(locale, msisdn, usageAuth);
                populatePackageFromSubscription(usageAuth);
                //TODO populate MatchingAttributes
                //populateMatchingAttributes as they tend to be null
//            usageAuth.getMatchingAttributes();
            }
        });
    }

    //finds the complete service pricepoint object from the subscription and replaces the one on the usageAuth
    protected void populateUsageAuthServicePricePointFromSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {

        if(null != usageAuthorization.getServicePricePoint() &&
                null != usageAuthorization.getServicePricePoint().getId() &&
                null != usageAuthorization.getSubscription() &&
                null != usageAuthorization.getSubscription().getPackage()) {

            String ppId = usageAuthorization.getServicePricePoint().getId();
            Subscription sub = usageAuthorization.getSubscription();
            //Find the full service object
            List<CatalogService> services = sub.getPackage().getServices();
            Optional<CatalogService> foundService = services.stream()
                    .filter(catalogService -> null != catalogService.getPricePoints().getPricePoint(ppId).getId())
                    .findFirst();
            foundService.ifPresent(service -> {
                PricePoint foundPp = service.getPricePoints().getPricePoint(ppId);
                usageAuthorization.setPricePoint(foundPp);
            });
        }
    }

    protected void populatePackageFromSubscription(final UsageAuthorization usageAuthorization) {
        usageAuthorization.setPackage(usageAuthorization.getSubscription().getPackage());
    }

    protected void populateSubscription(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {
        String subId = usageAuthorization.getPackageSubscriptionId();
        SubscriptionFilter filter = new SubscriptionFilterImpl();
        filter.setSubscriptionId(subId);
        try {
            final Subscription [] arr = selfcareApiService.getSubscriptions(locale, CLIENT_ID.value(), msisdn, 0, filter);
            if(arr == null || arr.length != 1) {
                return;
            }
            usageAuthorization.setSubscription(arr[0]);
        } catch (EcommerceException e) {
            logger.error("Could not get Subscription correctly using id: {}, with exception message: {}", subId, e);
            throw new EpaServiceException(ERROR_FROM_CORE, e);
        }
        populateActiveSubscriptions(locale, msisdn, usageAuthorization);
    }

    protected void populateActiveSubscriptions(Locale locale, String msisdn, UsageAuthorization usageAuthorization) {
        SubscriptionFilter activeFilter = new SubscriptionFilterImpl();
        activeFilter.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
        try {
            final Subscription [] activeSubs = selfcareApiService.getSubscriptions(locale, CLIENT_ID.value(), msisdn, 0, activeFilter);
            usageAuthorization.setActiveSubscriptions(Arrays.asList(activeSubs));
        } catch (EcommerceException e) {
            logger.error("Could not get Active Subscriptions.  Exception: {}", e );
            throw new EpaServiceException(ERROR_FROM_CORE, e);
        }
    }
}
