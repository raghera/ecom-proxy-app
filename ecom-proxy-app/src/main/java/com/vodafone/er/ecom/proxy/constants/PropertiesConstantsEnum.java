package com.vodafone.er.ecom.proxy.constants;

/**
 * Created by Ravi Aghera
 */
public enum  PropertiesConstantsEnum {
    PROPERTIES_FILE_NAME("ecom-proxy-application"),
    PROP_GET_PACKAGES2("proxy.getPackages2"),
    PROP_GET_SERVICE1("proxy.getService1"),
    PROP_GET_SUBSCRIPTIONS2("proxy.getSubsciptions2"),
    PROP_PURCHASE_PACKAGE_MSISDN1("proxy.purchasePackageMsisdn1"),
    PROP_UPDATE_SERVICE_STATUS1("proxy.updateServiceStatus1");

    private final String value;

    PropertiesConstantsEnum (String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
