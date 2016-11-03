package com.vodafone.metrics;

import com.codahale.metrics.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Map;

import static com.vodafone.metrics.EpaHealthCheckServletContextListener.HEALTH_CHECK_REGISTRY;

/**
 * Created by Ravi Aghera
 */
public class InitServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(InitServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        logger.debug("Start EpaInitServlet . . . ");
        HEALTH_CHECK_REGISTRY.register("core-check", new EpaHealthCheck());


        logger.info("Running application HealthChecks . . . ");
        for (Map.Entry<String, HealthCheck.Result> entry : HEALTH_CHECK_REGISTRY.runHealthChecks().entrySet()) {
            if( entry.getValue().isHealthy()) {
                logger.info(entry.getKey() + "= OK");
            } else {
                logger.error(entry.getKey() + "= FAIL" +  " Error= " + entry.getValue().getError());
            }
        }
        logger.debug("Health checks complete");
    }
}
