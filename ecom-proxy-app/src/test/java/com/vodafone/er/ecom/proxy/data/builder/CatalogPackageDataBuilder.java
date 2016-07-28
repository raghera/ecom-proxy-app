package com.vodafone.er.ecom.proxy.data.builder;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.PricePoints;

/**
 * Created by Ravi Aghera
 */
public class CatalogPackageDataBuilder {

    private static final String PACKAGE_ID = "pAlt";

    private CatalogPackageDataBuilder() {}

    //Default test object.
    public static CatalogPackage aCatalogPackage() {
        CatalogPackage catalogPackage = new CatalogPackage();
        catalogPackage.setId(PACKAGE_ID);
        catalogPackage.setServices(Lists.newArrayList(CatalogServiceDataBuilder.aCatalogService()));
        PricePoints ppts = new PricePoints();
        ppts.add(PricePointDataBuilder.aPricePoint());
        catalogPackage.setPricePoints(ppts);

        return catalogPackage;
    }


}
