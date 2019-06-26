package com.marphain.demo.newer.spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * car 前置增强（spring aop编程式）
 */
@Component
public class CarBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("The car need swim tool.");
    }
}
