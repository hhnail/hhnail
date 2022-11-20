package com.hhnail.spring.aop.anno;

import com.hhnail.spring.aop.convert.ParamConvert;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {

    String desc() default "";

    Class<? extends ParamConvert> convert();
}
