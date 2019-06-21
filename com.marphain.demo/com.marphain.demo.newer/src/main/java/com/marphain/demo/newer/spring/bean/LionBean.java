package com.marphain.demo.newer.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 通过xml配置文件创建bean，并管理生命周期
 * (为了与Spring解藕，不建议实现InitializingBean, DisposableBean)
 */
public class LionBean implements InitializingBean, DisposableBean {
    private String leg;

    public LionBean(){
        System.out.println("LionBean()构造方法。。。");
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public void init(){
        System.out.println("init方法。。。");
    }

    public void destroy(){
        System.out.println("destory方法。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
