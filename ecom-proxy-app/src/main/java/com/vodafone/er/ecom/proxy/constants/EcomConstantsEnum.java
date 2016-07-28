package com.vodafone.er.ecom.proxy.constants;

/**
 * Created by Ravi Aghera
 */
public enum EcomConstantsEnum {
    CLIENT_ID("ecom-proxy-application");

    private final String value;

    EcomConstantsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
