package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.processor.CatalogApiProcessor;
import com.vodafone.global.er.business.catalog.BasePrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.EcomAppEnum.CLIENT_ID;

@Service
public class CatalogApiService {
    private Logger logger = LoggerFactory.getLogger(CatalogApiService.class);

    @Autowired
    private ErApiManager erApiManager;

    @Autowired
    CatalogApiProcessor catalogApiProcessor;

    public CatalogPackage getCatalogPackage(final Locale locale, String packageId) {
        logger.info("calling catalogApi.getPackage with locale={}, client-id={}", locale, CLIENT_ID.getValue());
        final CatalogPackage result = erApiManager.getCatalogApi(locale).getPackage(packageId);
            return catalogApiProcessor.processCatalogPackage(locale, result);
    }

    public CatalogService getCatalogService(final Locale locale, String serviceId) {
        final CatalogService service = erApiManager.getCatalogApi(locale).getService(serviceId);
        return catalogApiProcessor.processCatalogService(locale, service);
    }

    public PricePoint getPricePoint(final Locale locale, final String pricePointId) {
        final PricePoint pricePoint = erApiManager.getCatalogApi(locale).getPricePoint(pricePointId);
        return catalogApiProcessor.processPricePoint(pricePoint);
    }

    public BasePrice[] getBasePrices(Locale locale, String [] serviceIds) throws EcommerceException {
        return erApiManager.getCatalogApi(locale)
                .getBasePrices(serviceIds);
    }

    public CatalogPackage [] getPackages(Locale locale) {
        return erApiManager.getCatalogApi(locale)
                .getPackages();
    }

    public String getVersion(Locale locale) {
        return erApiManager.getCatalogApi(locale)
                .getVersion();
    }

    public CatalogPackage[] processFindPackagesWithService(Locale locale, String msisdn, CatalogService service, PurchaseAttributes purchaseAttributes) {
        Optional<CatalogPackage[]> packArrOpt =
                Optional.of(erApiManager.getCatalogApi(locale)
                        .findPackagesWithService(msisdn, service, purchaseAttributes));

        //May not want to do the post-processing here
        catalogApiProcessor.postProcessFindPackagesWithService(packArrOpt);
        return packArrOpt.get();
    }

//    private PricePoint processPricePoint(final PricePoint pricePoint) {
//        pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
//        return pricePoint;
//    }
//
//    private CatalogPackage processCatalogPackage(final Locale locale, final CatalogPackage catalogPackage) {
//        //populate missing service data
//        for(CatalogService service : catalogPackage.getServiceArray()) {
//
//            final CatalogService returnedService = getCatalogService(locale, service.getId());
//            service.setPricePoints(returnedService.getPricePoints());
//            service.getPricePoints().forEach(ppt -> {
//
//                //Populate Service Pricepoint data
//                final PricePoint processedPricePoint = getPricePoint(locale, ppt.getId());
//                ppt.setPackageId(catalogPackage.getSimplePackageId());
//                ppt.setTaxCode(processedPricePoint.getTaxCode());
//                ppt.setContentId(service.getId());
//                ppt.setTariff(processedPricePoint.getTariff());
//
//                //Should be fixed on core
//                if(ppt.getReceiptingAttribute() != null && ppt.getReceiptingAttribute().equals("NULL")) {
//                    ppt.setReceiptingAttribute(null);
//                }
//                processPricePointBalanceImpacts(ppt);
//            });
//
//            //Populate PackagePricepoint Attributes
//            catalogPackage.getPricePoints().forEach(packagePricePoint -> {
//
//                final PricePoint processedPricePoint = getPricePoint(locale, packagePricePoint.getId());
//
//                packagePricePoint.setPackageId(catalogPackage.getSimplePackageId());
//                packagePricePoint.setTaxCode(processedPricePoint.getTaxCode());
//                packagePricePoint.setTariff(processedPricePoint.getTariff());
//
//                final BalanceImpact[] balanceImpacts = packagePricePoint.getAllBalanceImpacts().getBalanceImpacts();
//                final List<ResourceBalance> resourceBalances = processBalanceImpacts(Arrays.asList(balanceImpacts));
//                packagePricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
//            });
//        }
//        return catalogPackage;
//    }
//
//    public void processPricePointBalanceImpacts(PricePoint pricePoint) {
//        BalanceImpact[] origBalanceImpacts = pricePoint.getAllBalanceImpacts().getBalanceImpacts();
//        List<ResourceBalance> resourceBalances = new ArrayList<>();
//        for(BalanceImpact balanceImpact : origBalanceImpacts) {
//            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
//            resourceBalance.getResource().setName(balanceImpact.getResource().getName());
//            resourceBalances.add(resourceBalance);
//        }
//        pricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
//    }
//
//    private List<ResourceBalance> processBalanceImpacts(List<BalanceImpact> balanceImpacts) {
//        List<ResourceBalance> resourceBalances = new ArrayList<>();
//        balanceImpacts.forEach(balanceImpact -> {
//            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
//            resourceBalances.add(resourceBalance);
//        });
//        return resourceBalances;
//    }
//
//    //Takes a service and populates what is missing but required.
//    private CatalogService processCatalogService(final Locale locale, final CatalogService catalogService) {
//
//        //Go through the pricepoints, deduce the packageId and populate.
//        final PricePoints origPpts = catalogService.getPricePoints();
//        origPpts.forEach(pricePoint -> {
//            //TODO currently does not need to go to the server but could add here for PricePoints
//            PricePoint processedPricePoint = getPricePoint(locale, pricePoint.getId());
//            //For instance we can get the Tariff info
//
//            String packageId = CatalogUtil.getPackageIdFromServicePricepoint(pricePoint.getId());
//
//            pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
//            pricePoint.setPackageId(packageId);
//            pricePoint.setContentId(catalogService.getId());
//
////            catalogService.setPackageId(packageId);
//        });
//
//        return catalogService;
//    }
//
//    public void populatePricePointInPackage(CatalogPackage pack, String pricepointId) {
//        if(pack.getPricePoints() != null && !pack.getPricePoints().isEmpty()) {
//            PricePoint ppt = pack.getPricePoints().getPricePoint(pricepointId);
//            pack.setPricePoint(ppt);
//        }
//    }
//
//    public CatalogPackage[] postProcessFindPackagesWithService(Optional<CatalogPackage[]> packArrOpt) {
//        //TODO - Currently the below could result in performance degradation.
//        //If there are 100 packages in the response then calling getPackage 100 times.
//        //Caching of the packages locally will help this although only if has been called before
//
//        packArrOpt.ifPresent( packArr -> {
//            List<CatalogPackage> packs = Arrays.asList(packArr);
//            packs.forEach(pack -> {
//                Optional<CatalogPackage> packOpt = Optional.of(getCatalogPackage(locale, pack.getId()));
//                packOpt.ifPresent(returnedPack -> {
//                    pack.setServices(returnedPack.getServices());
//                    pack.setPricePoints(returnedPack.getPricePoints());
//                });
//            });
//        });
//        return packArrOpt.get();
//    }
}
