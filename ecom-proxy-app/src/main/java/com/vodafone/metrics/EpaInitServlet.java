package com.vodafone.metrics;

import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.properties.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.PROP_EPA_STARTUP_HEALTHCHECK;

/**
 * Created by Ravi Aghera
 */
public class EpaInitServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(EpaInitServlet.class);

    private HealthCheckService healthCheckService;

    public EpaInitServlet() {
        healthCheckService = ApplicationContextHolder.getContext().getBean(HealthCheckService.class);
    }


    @Override
    public void init() throws ServletException {
        super.init();

        logger.info("EpaInitServlet . . . ");

        PropertyService.getPropertyAsBoolean(PROP_EPA_STARTUP_HEALTHCHECK.value(), true)
                .ifPresent(propValue -> {
                    if(propValue) {
                        healthCheckService.runHealthChecks();
                    }
                });

        logger.info("EPA HAS STARTED");

    }
}
