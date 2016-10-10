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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Ravi Aghera
 */
@Component
public class CatalogApiProcessor<T> implements PostProcessor<RequestResult<List<T>>> {

    @Autowired
    private CatalogApiService catalogApiService;

    //Routes requests to process method
    @Override
    public void process(RequestResult<List<T>> result) {

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
        pricePoints.forEach(pricePoint ->
            pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()))
        );

        return pricePoints;
    }

    public List<CatalogPackage> processCatalogPackages(final Locale locale, final List<CatalogPackage> packages) {
        packages.forEach( catalogPackage -> {
            //populate missing service data
            for (CatalogService service : catalogPackage.getServiceArray()) {

                final CatalogService returnedService = catalogApiService.getCatalogService(locale, service.getId());
                service.setPricePoints(returnedService.getPricePoints());
                service.getPricePoints().forEach(ppt -> {

                    //Populate Service Pricepoint data
                    final PricePoint processedPricePoint = catalogApiService.getPricePoint(locale, ppt.getId());
                    ppt.setPackageId(catalogPackage.getSimplePackageId());
                    ppt.setTaxCode(processedPricePoint.getTaxCode());
                    ppt.setContentId(service.getId());
                    ppt.setTariff(processedPricePoint.getTariff());

                    //Should be fixed on core
                    if (ppt.getReceiptingAttribute() != null && ppt.getReceiptingAttribute().equals("NULL")) {
                        ppt.setReceiptingAttribute(null);
                    }
                    processPricePointBalanceImpacts(ppt);
                });

                //Populate PackagePricepoint Attributes
                catalogPackage.getPricePoints().forEach(packagePricePoint -> {

                    final PricePoint processedPricePoint = catalogApiService.getPricePoint(locale, packagePricePoint.getId());

                    packagePricePoint.setPackageId(catalogPackage.getSimplePackageId());
                    packagePricePoint.setTaxCode(processedPricePoint.getTaxCode());
                    packagePricePoint.setTariff(processedPricePoint.getTariff());

                    final BalanceImpact[] balanceImpacts = packagePricePoint.getAllBalanceImpacts().getBalanceImpacts();
                    final List<ResourceBalance> resourceBalances = processBalanceImpacts(Arrays.asList(balanceImpacts));
                    packagePricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
                });
            }
        });
        return packages;
    }

    //Takes a service and populates what is missing but required.
    public List<CatalogService> processCatalogService(final Locale locale, final List<CatalogService> catalogServices) {

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

    private List<ResourceBalance> processBalanceImpacts(List<BalanceImpact> balanceImpacts) {
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
