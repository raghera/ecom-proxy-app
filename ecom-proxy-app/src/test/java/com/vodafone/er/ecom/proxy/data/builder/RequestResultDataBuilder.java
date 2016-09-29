package com.vodafone.er.ecom.proxy.data.builder;


import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.charging.UsageAuthorization;
import com.vodafone.er.ecom.proxy.domain.RequestResult;

import java.util.List;
import java.util.Locale;

/**
 * Created by Ravi Aghera
 */
public class RequestResultDataBuilder<T> {
    private RequestResult<List<T>> getRequestResult(Locale locale, String msisdn, List<T> results) {
        return new RequestResult.Builder()
                .response(results).locale(locale)
                .msisdn(msisdn)
                .build();
    }

    public static RequestResult<List<CatalogPackage>> aCatalogPackageRequestResult(Locale locale, String msisdn, List<CatalogPackage> results) {
        return new RequestResultDataBuilder<CatalogPackage>().getRequestResult(locale, msisdn, results);
    }
    public static RequestResult<List<CatalogService>> aCatalogServiceRequestResult(Locale locale, String msisdn, List<CatalogService> results) {
        return new RequestResultDataBuilder<CatalogService>().getRequestResult(locale, msisdn, results);
    }
    public static RequestResult<List<PricePoint>> aPricePointRequestResult(Locale locale, String msisdn, List<PricePoint> results) {
        return new RequestResultDataBuilder<PricePoint>().getRequestResult(locale, msisdn, results);
    }
    public static RequestResult<List<UsageAuthorization>> aUsageAuthRequestResult(Locale locale, String msisdn, List<UsageAuthorization> results) {
        return new RequestResultDataBuilder<UsageAuthorization>().getRequestResult(locale, msisdn, results);
    }
    public static RequestResult<List<PurchaseAuthorization>> aPurchaseAuthRequestResult(Locale locale, String msisdn, List<PurchaseAuthorization> results) {
        return new RequestResultDataBuilder<PurchaseAuthorization>().getRequestResult(locale, msisdn, results);
    }
}
