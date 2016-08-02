package com.vodafone.er.ecom.proxy.data.builder;

/**
 * Created by Ravi Aghera
 */
public enum IdConstantsEnum {

    DEFAULT_PACKAGE_ID("pAlt"),
    DEFAULT_SERVICE_ID("sAlt"),
    DEFAULT_SERVICE_PRICEPOINT("content:pAlt_TAX_sAlt_1_999_999_999"),
    DEFAULT_PACKAGE_PRICEPOINT("package:pAlt_TAX_3_2_999_999_999_*_*");

    private String value;

    IdConstantsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
