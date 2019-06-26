package com.marphain.demo.newer.spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Aspect
@Component
public class LogAdvisor {
    @Pointcut("@annotation(com.marphain.demo.newer.spring.aop.annotation.Log)")
    public void log(){

    }

    /**
     * 环绕增强（不支持@Before、@After等注解）
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object beforeLog(ProceedingJoinPoint pjp) throws Throwable{
        String targetClassName = pjp.getClass().getName();
        String targetMethodName = pjp.getSignature().getName();
        System.out.println("execute " + targetClassName + "." + targetMethodName + "()");

        Object result = pjp.proceed();
        return result;
    }
}
