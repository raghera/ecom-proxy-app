package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.PricePoint;

import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.PACKAGE_ID;

/**
 * Created by Ravi Aghera
 */
public class PricePointDataBuilder {


    protected static final String PACKAGE_PRICEPOINT_ID = "content:pAlt_TAX_sAlt_1_999_999_999";
    protected static final String SERVICE_PRICEPOINT_ID = "package:pAlt_TAX_3_2_999_999_999_*_*";

    private PricePointDataBuilder() {}

    public static PricePoint aPricePoint() {
        PricePoint pp = new PricePoint();
        pp.setId(PACKAGE_PRICEPOINT_ID);
        pp.setPackageId(PACKAGE_ID);
        return pp;
    }
    public static PricePoint aServicePricePoint() {
        PricePoint pp = new PricePoint();
        pp.setId(SERVICE_PRICEPOINT_ID);
        pp.setPackageId(PACKAGE_ID);
        return pp;
    }

}
