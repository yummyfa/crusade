package com.bright.common;

import com.bright.entity.EditEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangliang
 * @date 2022/4/23 22:29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {
    String appId() default "crusade";

    String reqDesc() default "";

    EditEnum editType();
}
