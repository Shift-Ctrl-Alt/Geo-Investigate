package com.oymn.geoinvestigate.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CheckUserForUpdateRecord {
    
}
