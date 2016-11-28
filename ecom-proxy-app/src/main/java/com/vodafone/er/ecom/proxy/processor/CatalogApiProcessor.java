package com.vodafone.er.ecom.proxy.processor;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.catalog.PricePoints;
import com.vizzavi.ecommerce.business.catalog.internal.BalanceImpact;
import com.vizzavi.ecommerce.business.selfcare.ResourceBalance;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import com.vodafone.global.er.util.CatalogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Ravi Aghera
 */
@Component
public class CatalogApiProcessor<T> implements PostProcessor<RequestResult<List<T>>> {

    private static Logger logger = LoggerFactory.getLogger(CatalogApiProcessor.class);

    @Autowired
    private CatalogApiService catalogApiService;

    //Routes requests to process method
    @Override
    public void process(RequestResult<List<T>> result) {

        logger.debug("Enter CatalogApiProcessor.process");
        if(!result.getResponse().isEmpty()  && result.getResponse().get(0) instanceof CatalogPackage) {
            List<CatalogPackage> packages = (List<CatalogPackage>) result.getResponse();
            processCatalogPackages(result.getLocale(), packages);
        } else if (!result.getResponse().isEmpty() && result.getResponse().get(0) instanceof CatalogService) {
            List<CatalogService> services = (List<CatalogService>) result.getResponse();
            processCatalogService(result.getLocale(), services);
        } else if (!result.getResponse().isEmpty()  && result.getResponse().get(0) instanceof PricePoint) {
            List<PricePoint> pricePoints = (List<PricePoint>) result.getResponse();
            processPricePoint(pricePoints);
        }
    }

    public List<PricePoint> processPricePoint(final List<PricePoint> pricePoints) {
        logger.debug("Enter CatalogApiServlet.processPricePoint");
        pricePoints.forEach(pricePoint ->
            pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()))
        );

        return pricePoints;
    }

    //TODO - Review with OpCos as there could be performance hit here
    //Removed calls to getPricepoint as not needed. getFullCatalogService/Package should get you all the data you need now.
    //
    public List<CatalogPackage> processCatalogPackages(final Locale locale, final List<CatalogPackage> packages) {
        logger.debug("Enter CatalogApiProcessor.processCatalogPackages");
        packages.forEach( catalogPackage -> {
            //populate missing service DATA
            for (CatalogService service : catalogPackage.getServiceArray()) {

                final CatalogService returnedService = catalogApiService.getCatalogService(locale, service.getId());
                service.setPricePoints(returnedService.getPricePoints());
                service.getPricePoints().forEach(ppt -> {

                    processServicePricePoint(locale, ppt);
                    ppt.setPackageId(catalogPackage.getSimplePackageId());
                    ppt.setContentId(service.getId());
                });

                //Populate PackagePricepoint Attributes
                catalogPackage.getPricePoints().forEach(packagePricePoint -> {

//                    final PricePoint returnedPackPp = catalogApiService.getPricePoint(locale, packagePricePoint.getId());

                    packagePricePoint.setPackageId(catalogPackage.getSimplePackageId());
//                    packagePricePoint.setTaxCode(returnedPackPp.getTaxCode());
//                    packagePricePoint.setTariff(returnedPackPp.getTariff());

                    final BalanceImpact[] balanceImpacts = packagePricePoint.getAllBalanceImpacts().getBalanceImpacts();
                    final List<ResourceBalance> resourceBalances = buildBalanceImpacts(Arrays.asList(balanceImpacts));
                    packagePricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
                });
            }
        });
        return packages;
    }

    private void processServicePricePoint(Locale locale, PricePoint ppt) {
        //removed call to getPricePoint as not needed.
//        final PricePoint returnedServPp = catalogApiService.getPricePoint(locale, ppt.getId());
//        ppt.setTaxCode(returnedServPp.getTaxCode());
//        ppt.setTariff(returnedServPp.getTariff());

        //Should be fixed on core
        if (ppt.getReceiptingAttribute() != null && ppt.getReceiptingAttribute().equals("NULL")) {
            ppt.setReceiptingAttribute(null);
        }
        processPricePointBalanceImpacts(ppt);
    }

    //Takes a service and populates what is missing but required.
    public List<CatalogService> processCatalogService(final Locale locale, final List<CatalogService> catalogServices) {
        logger.debug("Enter CatalogApiProcessor.processCatalogService");
        catalogServices.forEach(catalogService -> {
            //Go through the pricepoints, deduce the packageId and populate.
            final PricePoints origPpts = catalogService.getPricePoints();
            origPpts.forEach(pricePoint -> {
                //TODO currently does not need to go to the server but could add here for PricePoints
//            PricePoint processedPricePoint = catalogApiService.getPricePoint(locale, pricePoint.getId());
                //For instance we can get the Tariff info

                String packageId = CatalogUtil.getPackageIdFromServicePricepoint(pricePoint.getId());

                pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
                pricePoint.setPackageId(packageId);
                pricePoint.setContentId(catalogService.getId());
//            catalogService.setPackageId(packageId);
            });
        });

        return catalogServices;
    }

    //TODO potential performance degradation here.
    public void postProcessFindPackagesWithService(Locale locale, List<CatalogPackage> packs) {
            packs.forEach(pack -> {
                Optional<CatalogPackage> packOpt = Optional.of(catalogApiService.getCatalogPackage(locale, pack.getId()));
                packOpt.ifPresent(returnedPack -> {
                    pack.setServices(returnedPack.getServices());
                    pack.setPricePoints(returnedPack.getPricePoints());
                });
            });
    }

    private void processPricePointBalanceImpacts(PricePoint pricePoint) {
        BalanceImpact[] origBalanceImpacts = pricePoint.getAllBalanceImpacts().getBalanceImpacts();
        List<ResourceBalance> resourceBalances = new ArrayList<>();
        for(BalanceImpact balanceImpact : origBalanceImpacts) {
            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
            resourceBalance.getResource().setName(balanceImpact.getResource().getName());
            resourceBalances.add(resourceBalance);
        }
        pricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
    }

    private List<ResourceBalance> buildBalanceImpacts(List<BalanceImpact> balanceImpacts) {
        List<ResourceBalance> resourceBalances = new ArrayList<>();
        balanceImpacts.forEach(balanceImpact -> {
            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
            resourceBalances.add(resourceBalance);
        });
        return resourceBalances;
    }

    public void populatePricePointInPackage(CatalogPackage pack, String pricepointId) {
        if(pack.getPricePoints() != null && !pack.getPricePoints().isEmpty()) {
            PricePoint ppt = pack.getPricePoints().getPricePoint(pricepointId);
            pack.setPricePoint(ppt);
        }
    }

}
