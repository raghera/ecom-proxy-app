package com.vodafone.er.ecom.proxy.domain;

import java.util.Locale;
import java.util.Optional;

/**
 * Created by Ravi Aghera
 */
@SuppressWarnings("unchecked")
public class RequestResult<T> {

    private final T response;
    private final Locale locale;
    private final String msisdn;

    public T getResponse() {
        return response;
    }
    public Locale getLocale() {
        return locale;
    }
    public Optional<String> getMsisdn() {
        return Optional.of(msisdn);
    }

    private RequestResult(Builder builder) {
        //Can only be Type T
        this.response = (T) builder.response;
        this.msisdn = builder.msisdn;
        this.locale = builder.locale;
    }

    public static class Builder<T> {
        private T response;
        private Locale locale;
        private String msisdn;

        public Builder response(T response) {
            this.response = response;
            return this;
        }
        public Builder locale(Locale locale) {
            this.locale = locale;
            return this;
        }
        public Builder msisdn(String msisdn) {
            this.msisdn = msisdn;
            return this;
        }
        public RequestResult<T> build() {
            return new RequestResult<>(this);
        }
    }
}
