package com.marphain.demo.newer.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.soap.SOAPBinding;

/**
 * 通过自动扫描@ComponentScan创建bean，使用注解@PostConstruct、@PreDestroy管理生命周期
 */
@Component
public class PigBean {
    @Value("fat")
    private String head;

    @Value("short")
    private String tail;

    @Autowired
    private UserBean userBean;

    public PigBean(){
        System.out.println("PigBean()构造方法。。。");
    }

    public PigBean(UserBean userBean){
        this.userBean = userBean;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    @PostConstruct
    public void init(){
        System.out.println("init方法。。。");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destory方法。。。");
    }
}
