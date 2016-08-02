package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoints;

import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.PACKAGE_ID;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.*;

/**
 * Created by Ravi Aghera
 */
public class CatalogServiceDataBuilder {

    private static final String SERVICE_ID = "sAlt";

    private CatalogServiceDataBuilder() {}

    public static CatalogService aCatalogService() {
        CatalogService catalogService = new CatalogService();
        catalogService.setId(SERVICE_ID);
        catalogService.setPackageId(PACKAGE_ID);
        PricePoints pricePoints = new PricePoints();
        pricePoints.add(aServicePricePoint());
        catalogService.setPricePoints(pricePoints);
        return catalogService;
    }
}
