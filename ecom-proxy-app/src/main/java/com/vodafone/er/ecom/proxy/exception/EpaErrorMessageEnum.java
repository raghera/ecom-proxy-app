package com.vodafone.er.ecom.proxy.exception;

/**
 * Created by Ravi Aghera
 */

public enum EpaErrorMessageEnum {
    ERROR_FROM_CORE("Error from ER Core calling DecouplingApi."),
    ERROR_FROM_CORE_ECOM("Error from ER Core calling EcomApi."),
    ERROR_FROM_EPA_DECOUPLING_DESERIALISATION("Error while deserialisation of DecouplingApi response."),
    ERROR_FROM_EPA("Error from EPA");

    private final String message;

    EpaErrorMessageEnum(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}
