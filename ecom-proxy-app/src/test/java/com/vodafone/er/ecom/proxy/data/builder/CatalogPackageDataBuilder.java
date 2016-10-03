package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.PricePoints;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogServiceDataBuilder.aCatalogService;
import static com.vodafone.er.ecom.proxy.data.builder.IdConstantsEnum.DEFAULT_PACKAGE_ID;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.aPricePoint;

/**
 * Created by Ravi Aghera
 *
 */
public class CatalogPackageDataBuilder {


    private CatalogPackageDataBuilder() {}

    public static CatalogPackage aCatalogPackage() {
        CatalogPackage catalogPackage = new CatalogPackage();
        catalogPackage.setId(DEFAULT_PACKAGE_ID.value());
        catalogPackage.setServices(newArrayList(aCatalogService()));
        PricePoints ppts = new PricePoints();
        ppts.add(aPricePoint());
        catalogPackage.setPricePoints(ppts);

        return catalogPackage;
    }

    public static List<CatalogPackage> aCatalogPackageList(int length) {
        List<CatalogPackage> result = newArrayList();
        for(int i = 0; i< length; i++) {
            CatalogPackage catalogPackage = aCatalogPackage();
            catalogPackage.setId(DEFAULT_PACKAGE_ID.value() + "-" + i);
            result.add(catalogPackage);
        }
        return result;
    }


}
