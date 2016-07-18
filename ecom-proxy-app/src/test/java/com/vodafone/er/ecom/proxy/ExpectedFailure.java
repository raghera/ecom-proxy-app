package com.vodafone.er.ecom.proxy;

import com.vodafone.er.ecom.proxy.annotations.ExpectedTestFailure;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ExpectedFailure implements TestRule {

    @Override
    public Statement apply(final Statement statement, final Description description) {

        //TODO should do with a lambda
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable throwable) {
                    if(null != description.getAnnotation(ExpectedTestFailure.class) &&
                            description.getAnnotation(ExpectedTestFailure.class).enabled()) {
                        System.out.println(" ================================================================ ");
                        System.out.println(" ================================================================ ");

                        System.out.println("Failed Assertion=" + throwable.getMessage());

                        System.out.println(" ================================================================ ");
                        System.out.println(" ================================================================ ");

                    } else {
                        throw throwable;
                    }
                }

            }
        };

    }





}
