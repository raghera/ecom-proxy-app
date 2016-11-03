package com.vodafone.metrics;

import com.codahale.metrics.health.HealthCheck;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
public class EpaHealthCheck extends HealthCheck {

    @Autowired
    private CatalogApiService service;

    public EpaHealthCheck() {

        service = ApplicationContextHolder.getContext().getBean(CatalogApiService.class);
    }

//    @Override
//    protected Result check() throws Exception {
//        //Try all supported locales
//        final String ptResult = service.getVersion(new Locale("pt", "PT"));
//        final String huResult = service.getVersion(new Locale("hu", "HU"));
//
//        if(ptResult == null || huResult ==null
//                || ptResult.length() == 0 || huResult.length() == 0) {
//            return Result.unhealthy("Could not get a result from ER Core.  Check ER Core is up and running");
//        }
//        return Result.healthy();
//    }
    @Override
    //TODO - this is for DEV only so restart
    protected Result check() throws Exception {

        //Try all supported locales
        final String ptResult = service.getVersion(Locale.UK);

        if(ptResult == null || ptResult.length() == 0) {
            return Result.unhealthy("Could not get a result from ER Core.  Check ER Core is up and running");
        }
        return Result.healthy();
    }
}
