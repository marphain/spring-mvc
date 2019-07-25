package com.marphain.demo.newer.ws;

import com.marphain.demo.newer.ws.config.WsConfig;
import com.netfinworks.invest.facade.InvestQueryFacade;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WsApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WsConfig.class);
        InvestQueryFacade investQueryFacade = (InvestQueryFacade) ctx.getBean("investQueryFacade");
        System.out.println(investQueryFacade.queryMemberInfo("", null));

//        TestService testService = (TestService) ctx.getBean("testService");
//        testService.printBanner();
    }
}
