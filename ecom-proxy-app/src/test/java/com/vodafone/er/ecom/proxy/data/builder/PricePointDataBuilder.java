package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.PricePoint;

/**
 * Created by Ravi Aghera
 */
public class PricePointDataBuilder {

    private static final String DEFAULT_PRICEPOINT_ID = "pAlt ... ";

    private PricePointDataBuilder() {}

    public static PricePoint aPricePoint() {
        PricePoint pp = new PricePoint();
        pp.setId(DEFAULT_PRICEPOINT_ID);
        return pp;
    }

}
