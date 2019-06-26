package com.marphain.demo.newer.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * car环绕增强（spring aop编程式）
 */
@Component
public class CarAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("The car can swim.");
        Object result = methodInvocation.proceed();
        System.out.println("The car can fly.");
        return result;
    }
}
