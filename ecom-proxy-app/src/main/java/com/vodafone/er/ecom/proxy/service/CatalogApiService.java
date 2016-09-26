package com.vodafone.er.ecom.proxy.service;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.CatalogApiProcessor;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import com.vodafone.global.er.business.catalog.BasePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CatalogApiService {

    @Autowired
    private ErApiManager erApiManager;
    @Resource(name = "catalogApiProcessor")
    private PostProcessor<RequestResult<List<?>>> postProcessor;
    @Autowired
    private CatalogApiProcessor<RequestResult> catalogApiProcessor;

    public CatalogPackage getCatalogPackage(final Locale locale, String packageId) {
        final Optional<CatalogPackage> resultOpt = Optional.of(erApiManager.getCatalogApi(locale).getPackage(packageId));
        resultOpt.ifPresent( result -> postProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                .response(Lists.newArrayList(result))
                .locale(locale)
                .build())
        );

        return resultOpt.get();
    }

    public CatalogService getCatalogService(final Locale locale, String serviceId) {
        final Optional<CatalogService> serviceOpt = Optional.of(erApiManager.getCatalogApi(locale).getService(serviceId));
        serviceOpt.ifPresent(service -> postProcessor.process(new RequestResult.Builder<List<CatalogService>>()
                .response(Lists.newArrayList(service))
                .locale(locale)
                .build())
        );

        return serviceOpt.get();
    }

    public PricePoint getPricePoint(final Locale locale, final String pricePointId) {
        final Optional<PricePoint> ppOpt =
                Optional.of(erApiManager.getCatalogApi(locale).getPricePoint(pricePointId));
        ppOpt.ifPresent(pricePoint -> postProcessor.process(new RequestResult.Builder<List<PricePoint>>()
                .response(Lists.newArrayList(pricePoint))
                .locale(locale)
                .build())
        );

        return ppOpt.get();
    }

    public CatalogPackage[] processFindPackagesWithService(Locale locale, String msisdn, CatalogService service, PurchaseAttributes purchaseAttributes) {
        Optional<CatalogPackage[]> packArrOpt =
                Optional.of(erApiManager.getCatalogApi(locale)
                        .findPackagesWithService(msisdn, service, purchaseAttributes));

        //TODO May not want to do the post-processing here due to performance
        packArrOpt.ifPresent(packs -> {
            catalogApiProcessor.postProcessFindPackagesWithService(locale, Lists.newArrayList(packs));
            postProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                    .response(Lists.newArrayList(packs))
                    .locale(locale)
                    .build());

        });

        return packArrOpt.get();
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

//    private PricePoint processPricePoint(final PricePoint pricePoint) {
//        pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
//        return pricePoint;
//    }
//
//    private CatalogPackage processCatalogPackages(final Locale locale, final CatalogPackage catalogPackage) {
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
