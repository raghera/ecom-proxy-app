package com.vodafone.er.ecom.proxy.exception;

/**
 * Any problem during post processing should be wrapped in one of these.
 */
public class EpaPostProcessorException extends RuntimeException {
    public EpaPostProcessorException(String message, Throwable cause) {
        super(message, cause);
    }
}
