package com.vodafone.er.ecom.proxy.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Component;

/**
 * Created by Ravi Aghera
 *
 * Since we use legacy application code we need to obtain the application context manually.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        if (null == context ) {
            throw new ApplicationContextException("ApplicationContext has not been loaded correctly");
        }
        return context;
    }
}
