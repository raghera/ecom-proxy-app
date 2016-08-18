package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.CatalogService;

/**
 * Created by Ravi Aghera
 */
public class CatalogServiceDataBuilder {

    private static final String SERVICE_ID = "sAlt";

    private CatalogServiceDataBuilder() {}

    public static CatalogService aCatalogService() {
        throw new UnsupportedOperationException();
//        CatalogService catalogService = new CatalogService();
////        catalogService.setId(SERVICE_ID);
//        catalogService.setPackageId(PACKAGE_ID);
//        PricePoints pricePoints = new PricePoints();
//        pricePoints.add(aServicePricePoint());
//        catalogService.setPricePoints(pricePoints);
//        return catalogService;
    }
}
