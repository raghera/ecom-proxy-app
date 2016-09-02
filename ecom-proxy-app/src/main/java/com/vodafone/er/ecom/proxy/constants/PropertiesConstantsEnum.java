package com.vodafone.er.ecom.proxy.constants;

/**
 * Created by Ravi Aghera
 */
public enum  PropertiesConstantsEnum {
    PROPERTIES_FILE_NAME("ecom-proxy-application"),
    PROP_GET_PACKAGE2("proxy.getPackage2"),
    PROP_GET_SERVICE1("proxy.getService1"),
    PROP_GET_SUBSCRIPTIONS2("proxy.getSubsciptions2"),
    PROP_GET_SUBSCRIPTIONS18("proxy.getSubsciptions18"),
    PROP_PURCHASE_PACKAGE_MSISDN1("proxy.purchasePackageMsisdn1"),
    PROP_UPDATE_SERVICE_STATUS1("proxy.updateServiceStatus1"),
    PROP_USAGE_AUTH1("proxy.usageAuth1"),
    PROP_USAGE_AUTH_RATE_CHARGE3("proxy.usageAuthRateCharge3"),
    PROP_FIND_PACKAGES_WITH_SERVICE9("proxy.findPackagesWithService9"),
    PROP_MODIFY_SUBSCRIPTION_CHARGING_METHOD4("proxy.modifySubscriptionChargingMethod4"),
    PROP_MODIFY_SUBSCRIPTION_CHARGING_METHOD19("proxy.modifySubscriptionChargingMethod19");

    private final String value;

    PropertiesConstantsEnum (String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
