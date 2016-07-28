package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoints;

/**
 * Created by Ravi Aghera
 */
public class CatalogServiceDataBuilder {

    private static final String SERVICE_ID = "pAlt ... ";

    private CatalogServiceDataBuilder() {}

    public static CatalogService aCatalogService() {
        CatalogService catalogService = new CatalogService();
        catalogService.setId(SERVICE_ID);
        PricePoints pricePoints = new PricePoints();
        pricePoints.add(PricePointDataBuilder.aPricePoint());
        catalogService.setPricePoints(pricePoints);
        return catalogService;
    }
}
