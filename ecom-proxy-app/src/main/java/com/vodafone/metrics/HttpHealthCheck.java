package com.vodafone.metrics;

import com.codahale.metrics.health.HealthCheck;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.*;
import static com.vodafone.er.ecom.proxy.properties.PropertyService.getProperty;

/**
 * Created by Ravi Aghera
 */
public class HttpHealthCheck extends HealthCheck {

    @Autowired
    private CatalogApiService service;

    public HttpHealthCheck() {
        service = ApplicationContextHolder.getContext().getBean(CatalogApiService.class);
    }

    @Override
    protected Result check() throws Exception {
        Optional<String> countryStr = getProperty(PROP_EPA_HEALTHCHECK_COUNTRY.value(), "HU");
        Optional<String> langStr = getProperty(PROP_EPA_HEALTHCHECK_LANG.value(), "hu");

        String result = null;
        if(countryStr.isPresent() && langStr.isPresent()) {
             result = service.getVersion(new Locale(langStr.get(), countryStr.get()));
        }

        if(result == null || result.length() == 0) {
            return Result.unhealthy("Http get-version request to ER Core did not return a response.  " +
                    "Check ER Core is up and running correctly for country: " + countryStr +
                    "and language: " + langStr + " Operating Countries");
        }
        return Result.healthy();
    }
}
