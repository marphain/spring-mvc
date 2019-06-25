package com.marphain.demo.newer.spring;

import com.marphain.demo.newer.spring.bean.LionBean;
import com.marphain.demo.newer.spring.bean.PigBean;
import com.marphain.demo.newer.spring.bean.UserBean;
import com.marphain.demo.newer.spring.config.ContextConfiguration;
import com.marphain.demo.newer.spring.config.form.ScanConfiguration;
import com.marphain.demo.newer.spring.event.TestEvent;
import com.marphain.demo.newer.spring.publisher.TestPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 基于注解的ApplicationContext
 */
public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        UserBean userBean1 = ctx.getBean("userBean", UserBean.class);
        System.out.println(userBean1 + userBean1.getName());

        UserBean userBean2 = ctx.getBean("userBean", UserBean.class);
        System.out.println(userBean2 + userBean2.getName());

        LionBean lionBean = ctx.getBean("lionBean", LionBean.class);
        System.out.println(lionBean.getLeg());

        PigBean pigBean = ctx.getBean("pigBean", PigBean.class);
        System.out.println(pigBean.getHead());

        TestPublisher publisher = ctx.getBean("testPublisher", TestPublisher.class);
        publisher.onPublishEvent(new TestEvent("event test"));
    }

}
