package com.marphain.demo.newer.spring.aop.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * car后置增强（spring aop编程式）
 */
@Component
public class CarAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("The car need fly tool.");
    }
}
