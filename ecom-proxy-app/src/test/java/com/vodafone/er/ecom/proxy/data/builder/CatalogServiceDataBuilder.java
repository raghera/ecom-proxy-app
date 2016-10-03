package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoints;

import static com.vodafone.er.ecom.proxy.data.builder.IdConstantsEnum.*;
import static com.vodafone.er.ecom.proxy.data.builder.IdConstantsEnum.DEFAULT_SERVICE_ID;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.aServicePricePoint;


/**
 * Created by Ravi Aghera
 */
public class CatalogServiceDataBuilder {

    private CatalogServiceDataBuilder() {}

    public static CatalogService aCatalogService() {
        CatalogService catalogService = new CatalogService();
        catalogService.setId(DEFAULT_SERVICE_ID.value());
        catalogService.setPackageId(DEFAULT_PACKAGE_ID.value());
        PricePoints pricePoints = new PricePoints();
        pricePoints.add(aServicePricePoint());
        catalogService.setPricePoints(pricePoints);
        return catalogService;
    }
}
