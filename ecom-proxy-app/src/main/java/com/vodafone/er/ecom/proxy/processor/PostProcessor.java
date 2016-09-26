package com.vodafone.er.ecom.proxy.processor;

import com.vodafone.er.ecom.proxy.domain.RequestResult;

/**
 * Created by Ravi Aghera
 */
public interface PostProcessor<T extends RequestResult> {
    /**
     * Generic method for all services to call to process a RequestResponse
     * Returns the processed RequestResponse
     */
    T process(T result);
}
