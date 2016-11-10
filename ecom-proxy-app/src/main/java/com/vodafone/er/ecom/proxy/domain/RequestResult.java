package com.vodafone.er.ecom.proxy.domain;

import java.util.Locale;
import java.util.Optional;

/**
 * Created by Ravi Aghera
 */
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

    private RequestResult(T response, String msisdn, Locale locale) {
        this.response = response;
        this.msisdn = msisdn;
        this.locale = locale;
    }

    public static class Builder<T> {
        private T response;
        private Locale locale;
        private String msisdn;

        public Builder<T> response(T response) {
            this.response = response;
            return this;
        }
        public Builder<T> locale(Locale locale) {
            this.locale = locale;
            return this;
        }
        public Builder<T> msisdn(String msisdn) {
            this.msisdn = msisdn;
            return this;
        }
        public RequestResult<T> build() {
            return new RequestResult<>(response, msisdn, locale);
        }
    }
}
