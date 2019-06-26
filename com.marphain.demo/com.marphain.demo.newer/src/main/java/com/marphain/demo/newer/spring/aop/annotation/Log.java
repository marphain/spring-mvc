package com.marphain.demo.newer.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {
}
