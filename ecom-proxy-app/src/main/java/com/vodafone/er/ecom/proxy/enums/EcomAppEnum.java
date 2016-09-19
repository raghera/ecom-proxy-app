package com.vodafone.er.ecom.proxy.enums;

/**
 * Created by Ravi Aghera
 */
public enum EcomAppEnum {
    CLIENT_ID("ecom-proxy-application");

    private final String value;

    EcomAppEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
