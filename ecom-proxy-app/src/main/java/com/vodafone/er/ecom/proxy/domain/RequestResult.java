package com.vodafone.er.ecom.proxy.domain;

/**
 * Created by Ravi Aghera
 */
public class RequestResult<T> {

    private T response;

    public T getResponse() {
        return response;
    }
    public void setResult(T response) {
        this.response = response;
    }
}
