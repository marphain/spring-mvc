package com.marphain.demo.newer.ws.service.impl;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "testService")
public interface TestService {
    @WebMethod
    void printBanner();
}
