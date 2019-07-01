package com.marphain.demo.newer.ws.service.impl;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {
    @Override
    public void printBanner() {
        System.out.println("web service.");
    }
}
