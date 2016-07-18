package com.vodafone.er.ecom.proxy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExpectedTestFailure {
    public boolean enabled() default true;
}
