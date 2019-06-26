package com.marphain.demo.newer.spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Aspect注解实现aop
 */
@Aspect
@Component
public class AirPlaneAdvisor {

    /**
     * 环绕增强（不支持@Before、@After等注解）
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.marphain.demo.newer.spring.aop.service.impl.AirplaneServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    public void before(){
        System.out.println("before fly");
    }

    public void after(){
        System.out.println("after fly");
    }
}
