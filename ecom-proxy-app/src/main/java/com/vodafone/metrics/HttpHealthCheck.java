package com.vodafone.metrics;

import com.codahale.metrics.health.HealthCheck;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

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
        //Try all supported locales
        final String ptResult = service.getVersion(new Locale("pt", "PT"));
        final String huResult = service.getVersion(new Locale("hu", "HU"));

        if(ptResult == null || huResult ==null
                || ptResult.length() == 0 || huResult.length() == 0) {
            return Result.unhealthy("Http get-version request to ER Core did not return a response.  " +
                    "Check ER Core is up and running correctly for PT and HU Operating Countries");
        }
        return Result.healthy();
    }
}
