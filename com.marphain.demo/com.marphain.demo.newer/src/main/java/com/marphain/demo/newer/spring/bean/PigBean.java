package com.marphain.demo.newer.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过自动扫描@ComponentScan创建bean，使用注解@PostConstruct、@PreDestroy管理生命周期
 */
@Component
public class PigBean {
    @Value("fat")
    private String head;

    @Value("short")
    private String tail;

    public PigBean(){
        System.out.println("PigBean()构造方法。。。");
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
