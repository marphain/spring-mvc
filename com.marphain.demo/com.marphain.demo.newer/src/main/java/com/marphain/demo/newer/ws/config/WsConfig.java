package com.marphain.demo.newer.ws.config;

import com.marphain.demo.newer.ws.service.TestService;
import com.marphain.demo.newer.ws.service.impl.TestServiceImpl;
import com.netfinworks.invest.facade.InvestQueryFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class WsConfig {
    @Bean
    public JaxWsPortProxyFactoryBean investQueryFacade(){
        try {
            JaxWsPortProxyFactoryBean proxyFactoryBean = new JaxWsPortProxyFactoryBean();
            proxyFactoryBean.setServiceInterface(InvestQueryFacade.class);
            proxyFactoryBean.setWsdlDocumentUrl(new URL("http://localhost:8313/invest/ws/investQueryFacade?wsdl"));
            proxyFactoryBean.setServiceName("InvestQueryFacadeImplService");

            return proxyFactoryBean;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8080/");
        return  exporter;
    }

    @Bean
    public TestService testServiceImpl(){
        TestService testService = new TestServiceImpl();
        return  testService;
    }

//    @Bean
//    public JaxWsPortProxyFactoryBean testService(){
//        try {
//            JaxWsPortProxyFactoryBean proxyFactoryBean = new JaxWsPortProxyFactoryBean();
//            proxyFactoryBean.setServiceInterface(InvestQueryFacade.class);
//            proxyFactoryBean.setWsdlDocumentUrl(new URL("http://localhost:8080/testService?wsdl"));
//            proxyFactoryBean.setServiceName("testService");
//
//            return proxyFactoryBean;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
