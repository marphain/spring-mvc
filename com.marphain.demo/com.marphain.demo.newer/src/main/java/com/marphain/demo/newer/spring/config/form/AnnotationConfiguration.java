package com.marphain.demo.newer.spring.config.form;

import com.marphain.demo.newer.spring.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
