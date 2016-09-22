package com.vodafone.er.ecom.proxy.processor;

import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
@FunctionalInterface
public interface ResponseEnricher<T> {
    T process(Locale locale, String msisdn, T result);
}
