package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.*;
import com.vizzavi.ecommerce.business.catalog.internal.BalanceImpact;
import com.vizzavi.ecommerce.business.selfcare.ResourceBalance;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.util.CatalogUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class CatalogApiResultProcessor {
    private CatalogApi catalogApi;

    public CatalogApiResultProcessor(Locale locale, String clientId) {
        catalogApi = DecouplingApiFactory.getCatalogApi(locale, clientId);
    }

    //TODO refactor so can be more re-usable
    public CatalogPackage processCatalogPackage(CatalogPackage result) {
        //populate missing service data
        for(CatalogService service : result.getServiceArray()) {
            processCatalogService(service);
            final CatalogService returnedService = catalogApi.getService(service.getId());
            service.setPricePoints(returnedService.getPricePoints());

            service.getPricePoints().forEach(ppt -> {

                PricePoint returnedServPricePoint = catalogApi.getPricePoint(ppt.getId());
                ppt.setPackageId(result.getSimplePackageId());
                ppt.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(ppt.getId()));
                ppt.setContentId(service.getId());
                ppt.setTariff(returnedServPricePoint.getTariff());

                //Should be fixed on core
                if(ppt.getReceiptingAttribute() != null && ppt.getReceiptingAttribute().equals("NULL")) {
                    ppt.setReceiptingAttribute(null);
                }

                BalanceImpact[] origBalanceImpacts = ppt.getAllBalanceImpacts().getBalanceImpacts();
                List<ResourceBalance> resourceBalances = new ArrayList<>();
                for(BalanceImpact balanceImpact : origBalanceImpacts) {
                    ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
                    resourceBalance.getResource().setName(balanceImpact.getResource().getName());
                    resourceBalances.add(resourceBalance);
                }
                ppt.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));

            });

            result.getPricePoints().stream().forEach(packagePricePoint -> {

                PricePoint returnedPricePoint = catalogApi.getPricePoint(packagePricePoint.getId());

                BalanceImpact[] balanceImpacts = packagePricePoint.getAllBalanceImpacts().getBalanceImpacts();
                packagePricePoint.setPackageId(result.getSimplePackageId());
                packagePricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(packagePricePoint.getId()));
//                    packagePricePoint.setTariff(returnedPricePoint.getTariff());

                //Should be fixed on core
                if(packagePricePoint.getReceiptingAttribute() != null && packagePricePoint.getReceiptingAttribute().equals("NULL")) {
                    packagePricePoint.setReceiptingAttribute(null);
                }

                List<ResourceBalance> resourceBalances = new ArrayList<>();
                for(BalanceImpact balanceImpact : balanceImpacts) {
                    ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
                    resourceBalances.add(resourceBalance);
                }
                packagePricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
            });
        }

        return result;
    }

    public CatalogService processCatalogService(final CatalogService catalogService) {
        //Go through the pricepoints, deduce the packageId and populate.
        final PricePoints origPpts = catalogService.getPricePoints();
        origPpts.forEach(pricePoint -> {

            String packageId = CatalogUtil.getPackageIdFromServicePricepoint(pricePoint.getId());
//            final PricePoint pricePointFromServer = catalogApi.getPricePoint(pricePoint.getId());

            pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
            pricePoint.setPackageId(packageId);
            pricePoint.setContentId(catalogService.getId());
            catalogService.setPackageId(packageId);
        });

        return catalogService;
    }
}

