package com.vodafone.er.ecom.proxy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExpectedTestFailure {
    boolean enabled() default true;
}
