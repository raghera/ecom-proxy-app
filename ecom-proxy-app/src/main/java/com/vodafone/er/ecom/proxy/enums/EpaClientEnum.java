package com.vodafone.er.ecom.proxy.enums;

/**
 * Created by Ravi Aghera
 */
public enum EpaClientEnum {
    CLIENT_ID("ecom-proxy-application");

    private final String value;

    EpaClientEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
