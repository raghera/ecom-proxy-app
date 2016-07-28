package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.*;
import com.vizzavi.ecommerce.business.catalog.internal.BalanceImpact;
import com.vizzavi.ecommerce.business.selfcare.ResourceBalance;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.util.CatalogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.vodafone.er.ecom.proxy.constants.EcomConstantsEnum.CLIENT_ID;
import static org.apache.axis2.i18n.MessagesConstants.locale;

@Component
public class CatalogApiService {
    private Logger logger = LoggerFactory.getLogger(CatalogApiService.class);

    private CatalogApi catalogApi;

    public CatalogApi getCatalogApi() {
        if (null != catalogApi) {
            DecouplingApiFactory.getCatalogApi(locale, CLIENT_ID.getValue());
        }
        return catalogApi;
    }

    public CatalogPackage getCatalogPackage(final Locale locale, String packageId) {
        logger.info("calling catalogApi.getPackage with locale={}, client-id={}", locale, CLIENT_ID.getValue());
        //TODO move to it's own method that only instantiates one
        catalogApi = getCatalogApi();
        final CatalogPackage result = catalogApi.getPackage(packageId);
        return processCatalogPackage(locale, result);
    }

    public CatalogService getCatalogService(final Locale locale, String serviceId) {
        catalogApi = getCatalogApi();
        final CatalogService service = catalogApi.getService(serviceId);
        return processCatalogService(locale, service);
    }

    public PricePoint getPricePoint(final Locale locale, final String pricePointId) {
        catalogApi = getCatalogApi();
        final PricePoint pricePoint = catalogApi.getPricePoint(pricePointId);
        return processPricePoint(pricePoint);
    }

    private PricePoint processPricePoint(final PricePoint pricePoint) {
        //TODO fill in any required gaps here
        pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
        return pricePoint;
    }

    private CatalogPackage processCatalogPackage(final Locale locale, final CatalogPackage catalogPackage) {
        //populate missing service data
        for(CatalogService service : catalogPackage.getServiceArray()) {

            final CatalogService returnedService = getCatalogService(locale, service.getId());
            service.setPricePoints(returnedService.getPricePoints());
            service.getPricePoints().forEach(ppt -> {

                //Populate Service Pricepoint data
                final PricePoint processedPricePoint = getPricePoint(locale, ppt.getId());
                ppt.setPackageId(catalogPackage.getSimplePackageId());
                ppt.setTaxCode(processedPricePoint.getTaxCode());
                ppt.setContentId(service.getId());
                ppt.setTariff(processedPricePoint.getTariff());

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

            //Populate PackagePricepoint Attributes
            catalogPackage.getPricePoints().forEach(packagePricePoint -> {

                final PricePoint processedPricePoint = getPricePoint(locale, packagePricePoint.getId());

                packagePricePoint.setPackageId(catalogPackage.getSimplePackageId());
                packagePricePoint.setTaxCode(processedPricePoint.getTaxCode());
                packagePricePoint.setTariff(processedPricePoint.getTariff());

                final BalanceImpact[] balanceImpacts = packagePricePoint.getAllBalanceImpacts().getBalanceImpacts();
                final List<ResourceBalance> resourceBalances = processBalanceImpacts(Arrays.asList(balanceImpacts));
                packagePricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
            });
        }

        return catalogPackage;
    }

    private List<ResourceBalance> processBalanceImpacts(List<BalanceImpact> balanceImpacts) {
        List<ResourceBalance> resourceBalances = new ArrayList<>();
        balanceImpacts.forEach(balanceImpact -> {
            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
            resourceBalances.add(resourceBalance);
        });
        return resourceBalances;
    }

    //Takes a service and populates what is missing but required.
    private CatalogService processCatalogService(final Locale locale, final CatalogService catalogService) {

        //Go through the pricepoints, deduce the packageId and populate.
        final PricePoints origPpts = catalogService.getPricePoints();
        origPpts.forEach(pricePoint -> {
            //TODO currently does not need to go to the server but could add here for PricePoints
//            PricePoint processedPricePoint = getPricePoint(locale, pricePoint.getId());
            //For instance we can get the Tarriff info

            String packageId = CatalogUtil.getPackageIdFromServicePricepoint(pricePoint.getId());

            //TODO this does not always work so test
            pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
            pricePoint.setPackageId(packageId);
            pricePoint.setContentId(catalogService.getId());
            catalogService.setPackageId(packageId);
        });

        return catalogService;
    }

}

