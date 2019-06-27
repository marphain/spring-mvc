package com.marphain.demo.newer.spring.config.form;

import com.marphain.demo.newer.spring.aop.advice.AirPlaneAdvisor;
import com.marphain.demo.newer.spring.aop.advice.CarAfterAdvice;
import com.marphain.demo.newer.spring.aop.advice.CarBeforeAdvice;
import com.marphain.demo.newer.spring.aop.advice.LogAdvisor;
import com.marphain.demo.newer.spring.aop.service.CarService;
import com.marphain.demo.newer.spring.bean.UserBean;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

/**
 *  通过@Bean创建并管理bean
 */
@Configuration
public class AnnotationConfiguration {
    public AnnotationConfiguration(){
        System.out.println("AnnotationConfiguration()构造函数。。。");
    }

    @Bean(name = "userBean", initMethod = "init", destroyMethod = "destroy")
//    @Scope("prototype")//作用域默认为单例
    public UserBean userBean(){
        UserBean userBean = new UserBean();
        userBean.setName("China");
        return userBean;
    }

    @Bean
    public ProxyFactory proxyFactory(CarService carService, CarBeforeAdvice carBeforeAdvice, CarAfterAdvice carAfterAdvice){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(carService);
        proxyFactory.addAdvice(carBeforeAdvice);
        proxyFactory.addAdvice(carAfterAdvice);

        return  proxyFactory;
    }
}
