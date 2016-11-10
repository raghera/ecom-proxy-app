package com.vodafone.er.ecom.proxy.data.builder;

import com.vodafone.global.er.business.catalog.BasePrice;

import static com.vodafone.er.ecom.proxy.data.builder.IdConstantsEnum.*;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.*;

/**
 * Created by Ravi Aghera
 */
public class BasePricesDataBuilder {

    public static BasePrice aBasePrice() {
        return new BasePrice(DEFAULT_SERVICE_ID.value(), aPricePoint());
    }
}
