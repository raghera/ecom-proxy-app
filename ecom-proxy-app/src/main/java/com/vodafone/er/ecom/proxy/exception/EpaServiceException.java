package com.vodafone.er.ecom.proxy.exception;

public class EpaServiceException extends RuntimeException {
    public EpaServiceException(EpaErrorMessageEnum message, Throwable cause) {
        super(message.value(), cause);
    }
}
