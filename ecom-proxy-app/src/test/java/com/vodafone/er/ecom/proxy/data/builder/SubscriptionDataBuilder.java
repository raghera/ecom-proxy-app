package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.selfcare.Subscription;
import com.vizzavi.ecommerce.business.selfcare.SubscriptionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.vodafone.er.ecom.proxy.data.builder.CatalogPackageDataBuilder.aCatalogPackage;
import static com.vodafone.er.ecom.proxy.data.builder.PricePointDataBuilder.*;
import static com.vodafone.er.ecom.proxy.data.builder.TransactionDataBuilder.aTransaction;

/**
 * Created by Ravi Aghera
 */
public class SubscriptionDataBuilder {

    public static Subscription aSubscription() {

        Subscription sub = new Subscription();
        sub.setPackage(aCatalogPackage());
        sub.setStatus(SubscriptionStatus.ACTIVE);
        sub.setSubscriptionIdLong(new Random().nextLong());
        sub.setTransactions(newArrayList(aTransaction()));
        sub.setPricePoint(aPricePoint());
        return sub;

    }

    public static List<Subscription> aSubscriptionList(int length) {
        List<Subscription> result = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            Subscription sub = new Subscription();
            sub.setPackage(aCatalogPackage());
            sub.setStatus(SubscriptionStatus.ACTIVE);
            sub.setSubscriptionIdLong(new Random().nextLong());
            sub.setTransactions(newArrayList(aTransaction()));
            result.add(sub);
        }
        return result;
    }

    public static Subscription[] aSubscriptionArray(int length) {
        return aSubscriptionList(length).toArray(new Subscription[length]);
    }

}
