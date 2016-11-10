package com.vodafone.metrics;

import com.codahale.metrics.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.vodafone.metrics.EpaHealthCheckServletContextListener.HEALTH_CHECK_REGISTRY;

/**
 * Created by Ravi Aghera
 */
@Service
public class HealthCheckService {

    private static final Logger logger = LoggerFactory.getLogger(HealthCheckService.class);

    public void runHealthChecks() {
        HEALTH_CHECK_REGISTRY.register("http-health-check", new HttpHealthCheck());

        logger.info("Running application HealthChecks . . . ");
        for (Map.Entry<String, HealthCheck.Result> entry : HEALTH_CHECK_REGISTRY.runHealthChecks().entrySet()) {
            if( entry.getValue().isHealthy()) {
                logger.info(entry.getKey() + " STATUS = OK");
            } else {
                logger.error(entry.getKey() + " STATUS = FAIL" +  " Error= " + entry.getValue().getError());
            }
        }
        logger.debug("Health checks complete");

    }

}
