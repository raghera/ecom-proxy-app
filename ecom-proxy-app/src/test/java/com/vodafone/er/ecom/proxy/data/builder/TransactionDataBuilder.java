package com.vodafone.er.ecom.proxy.data.builder;

import com.vizzavi.ecommerce.business.selfcare.Transaction;
import com.vizzavi.ecommerce.business.selfcare.TransactionStatus;
import com.vodafone.global.er.decoupling.binding.response.v2.PaymentTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ravi Aghera
 */
public class TransactionDataBuilder {

    public static Transaction aTransaction() {
        Transaction trans = new Transaction();
        trans.setStatus(TransactionStatus.COMPLETED);
        trans.setSubscriptionIdLong(new Random().nextLong());
        return trans;
    }

    public static List<Transaction> aTransactionList(int length) {
        List<Transaction> result = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            result.add(aTransaction());
        }
        return result;
    }

    public static Transaction [] aTransactionArray(int length) {
        return aTransactionList(length).toArray(new Transaction [length]);
    }

    public static PaymentTransaction aPaymentTransaction() {
        PaymentTransaction trans = new PaymentTransaction();
        trans.setStatus(TransactionStatus.COMPLETED);
        return trans;
    }

}
