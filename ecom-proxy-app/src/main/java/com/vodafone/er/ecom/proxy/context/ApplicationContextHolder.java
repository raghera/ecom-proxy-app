package com.vodafone.er.ecom.proxy.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Ravi Aghera
 *
 * Since this is a legacy application we need to obtain the application context manually
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextHolder.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        if (null == context ) {
//            ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("epa-context.xml");
//            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
            logger.error("Spring ApplicataionContext is null." + context + ".");

        }
        return context;
    }
}
