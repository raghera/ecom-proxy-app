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

import static org.apache.axis2.i18n.MessagesConstants.locale;

/**
 * Created by Ravi Aghera
 */
@Component
public class CatalogApiProcessor implements ResponseEnricher<RequestResult<CatalogPackage>> {

    @Autowired
    private CatalogApiService catalogApiService;

    public RequestResult<CatalogPackage> process(Locale locale, String msisdn, RequestResult<CatalogPackage> result) {
        if(result.getResponse() instanceof CatalogPackage) {
            processCatalogPackage(locale, result.getResponse());
        }
        //PostProcess
        return null;
    }

    public PricePoint processPricePoint(final PricePoint pricePoint) {
        pricePoint.setTaxCode(CatalogUtil.getTaxCodeFromPricePointId(pricePoint.getId()));
        return pricePoint;
    }

    public CatalogPackage processCatalogPackage(final Locale locale, final CatalogPackage catalogPackage) {
        //populate missing service data
        for(CatalogService service : catalogPackage.getServiceArray()) {

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
                if(ppt.getReceiptingAttribute() != null && ppt.getReceiptingAttribute().equals("NULL")) {
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
        return catalogPackage;
    }

    public void processPricePointBalanceImpacts(PricePoint pricePoint) {
        BalanceImpact[] origBalanceImpacts = pricePoint.getAllBalanceImpacts().getBalanceImpacts();
        List<ResourceBalance> resourceBalances = new ArrayList<>();
        for(BalanceImpact balanceImpact : origBalanceImpacts) {
            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
            resourceBalance.getResource().setName(balanceImpact.getResource().getName());
            resourceBalances.add(resourceBalance);
        }
        pricePoint.setBalances(resourceBalances.toArray(new ResourceBalance[resourceBalances.size()]));
    }

    public List<ResourceBalance> processBalanceImpacts(List<BalanceImpact> balanceImpacts) {
        List<ResourceBalance> resourceBalances = new ArrayList<>();
        balanceImpacts.forEach(balanceImpact -> {
            ResourceBalance resourceBalance = new ResourceBalance(balanceImpact.getResource(), balanceImpact.getFixedAmount());
            resourceBalances.add(resourceBalance);
        });
        return resourceBalances;
    }

    //Takes a service and populates what is missing but required.
    public CatalogService processCatalogService(final Locale locale, final CatalogService catalogService) {

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
        return catalogService;
    }

    public void populatePricePointInPackage(CatalogPackage pack, String pricepointId) {
        if(pack.getPricePoints() != null && !pack.getPricePoints().isEmpty()) {
            PricePoint ppt = pack.getPricePoints().getPricePoint(pricepointId);
            pack.setPricePoint(ppt);
        }
    }

    //TODO potential performance degradation here.
    public CatalogPackage[] postProcessFindPackagesWithService(Optional<CatalogPackage[]> packArrOpt) {
        packArrOpt.ifPresent( packArr -> {
            List<CatalogPackage> packs = Arrays.asList(packArr);
            packs.forEach(pack -> {
                Optional<CatalogPackage> packOpt = Optional.of(catalogApiService.getCatalogPackage(locale, pack.getId()));
                packOpt.ifPresent(returnedPack -> {
                    pack.setServices(returnedPack.getServices());
                    pack.setPricePoints(returnedPack.getPricePoints());
                });
            });
        });
        return packArrOpt.get();
    }

}
