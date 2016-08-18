package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;

/**
 * Created by Ravi Aghera
 *
 */
public class CatalogPackageDataBuilder {

    protected static final String PACKAGE_ID = "pAlt";

    private CatalogPackageDataBuilder() {}

    //Default test object.
    public static CatalogPackage aCatalogPackage() {
        throw new UnsupportedOperationException();
//        CatalogPackage catalogPackage = new CatalogPackage();
//        catalogPackage.setId(PACKAGE_ID);
//        catalogPackage.setServices(newArrayList(aCatalogService()));
//        PricePoints ppts = new PricePoints();
//        ppts.add(PricePointDataBuilder.aPricePoint());
//        catalogPackage.setPricePoints(ppts);
//
//        return catalogPackage;
    }


}
