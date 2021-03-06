package com.marphain.demo.newer.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通过配置注解@Bean创建bean，并管理生命周期
 */
public class UserBean {
    private String name;

    private int age;

    @Autowired
    private PigBean pigBean;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserBean() {
        System.out.println("UserBean()构造方法。。。");
    }

    public UserBean(PigBean pigBean) {
        this.pigBean = pigBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setter方法。。。");
        this.name = name;
    }

    public PigBean getPigBean() {
        return pigBean;
    }

    public void setPigBean(PigBean pigBean) {
        this.pigBean = pigBean;
    }

    public void init() {
        System.out.println("init方法。。。");
    }

    public void destroy() {
        System.out.println("destory方法。。。");
    }
}
