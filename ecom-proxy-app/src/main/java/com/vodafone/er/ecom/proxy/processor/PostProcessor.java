package com.vodafone.er.ecom.proxy.processor;

/**
 * Created by Ravi Aghera
 */
public interface PostProcessor<T> {
    /**
     * Generic method for all services to call to process a RequestResponse
     * Returns the processed RequestResponse
     */
    T process(T result);
}
