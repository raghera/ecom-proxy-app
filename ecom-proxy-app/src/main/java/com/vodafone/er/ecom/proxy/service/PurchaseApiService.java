package com.vodafone.er.ecom.proxy.service;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vodafone.er.ecom.proxy.api.ErApiManager;
import com.vodafone.er.ecom.proxy.domain.RequestResult;
import com.vodafone.er.ecom.proxy.processor.PostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by Ravi Aghera
 */
@Service
public class PurchaseApiService {

    @Resource(name="purchaseApiProcessor")
    private PostProcessor<RequestResult<List<PurchaseAuthorization>>> postProcessResult;

    @Autowired
    private ErApiManager erApiManager;

    @Autowired
    private CatalogApiService catalogApiService;

    @Autowired
    private SelfcareApiService selfcareApiService;

    public PurchaseAuthorization purchasePackageMsisdn(Locale locale, String clientId, String msisdn,
                                                       String packageId, PurchaseAttributes purchaseAttributes) throws Exception {
        return erApiManager.getPurchaseApi(locale, clientId)
                .purchasePackageMsisdn(clientId, msisdn, packageId, purchaseAttributes);
    }

    public PurchaseAuthorization renewPurchasePackageMsisdn(Locale locale, String clientId, String msisdn, String subId,
                                                            PurchaseAttributes attributes) throws Exception {
        Optional<PurchaseAuthorization> authOpt = Optional.of(erApiManager.getPurchaseApi(locale, clientId)
                .renewPurchasePackageMsisdn(clientId, msisdn, subId, attributes));

        authOpt.ifPresent(auth ->
                postProcessResult.process(new RequestResult.Builder<List<PurchaseAuthorization>>()
                        .response(Lists.newArrayList(auth))
                        .locale(locale)
                        .msisdn(msisdn)
                        .build()
                )
        );
        return authOpt.get();
    }
}
