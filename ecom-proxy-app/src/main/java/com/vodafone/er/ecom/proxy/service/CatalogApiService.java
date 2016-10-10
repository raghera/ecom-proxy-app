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
@SuppressWarnings("unchecked")
public class CatalogApiService {

    @Autowired
    private ErApiManager erApiManager;
    @Resource(name = "catalogApiProcessor")
    private PostProcessor<RequestResult<List<?>>> postProcessor;
    @Autowired
    private CatalogApiProcessor<RequestResult> catalogApiProcessor;

    public CatalogPackage getCatalogPackage(final Locale locale, String packageId) {
        final Optional<CatalogPackage> resultOpt = Optional.ofNullable(erApiManager.getCatalogApi(locale).getPackage(packageId));
        resultOpt.ifPresent( result -> postProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
                .response(Lists.newArrayList(result))
                .locale(locale)
                .build())
        );

        //TODO Should not return null anywhere
        return resultOpt.orElse(null);
    }

    public CatalogService getCatalogService(final Locale locale, String serviceId) {
        final Optional<CatalogService> serviceOpt = Optional.ofNullable(erApiManager.getCatalogApi(locale).getService(serviceId));
        serviceOpt.ifPresent(service -> postProcessor.process(new RequestResult.Builder<List<CatalogService>>()
                .response(Lists.newArrayList(service))
                .locale(locale)
                .build())
        );

        return serviceOpt.orElse(null);
    }

    public PricePoint getPricePoint(final Locale locale, final String pricePointId) {
        final Optional<PricePoint> ppOpt =
                Optional.ofNullable(erApiManager.getCatalogApi(locale).getPricePoint(pricePointId));
        ppOpt.ifPresent(pricePoint -> postProcessor.process(new RequestResult.Builder<List<PricePoint>>()
                .response(Lists.newArrayList(pricePoint))
                .locale(locale)
                .build())
        );

        return ppOpt.orElse(null);
    }

    public CatalogPackage[] findPackageWithService(Locale locale, String msisdn, CatalogService service, PurchaseAttributes purchaseAttributes) {
        CatalogPackage[] packArr = erApiManager.getCatalogApi(locale)
                .findPackagesWithService(msisdn, service, purchaseAttributes);

        if(null != packArr && packArr.length > 0) {
            //TODO May not want to do the post-processing here due to performance
            catalogApiProcessor.postProcessFindPackagesWithService(locale, Lists.newArrayList(packArr));
//            postProcessor.process(new RequestResult.Builder<List<CatalogPackage>>()
//                    .response(Lists.newArrayList(packs))
//                    .locale(locale)
//                    .build());
        }
        return packArr;
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
}
