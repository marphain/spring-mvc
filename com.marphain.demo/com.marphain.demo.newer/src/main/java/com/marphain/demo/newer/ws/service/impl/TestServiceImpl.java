package com.marphain.demo.newer.ws.service.impl;

import org.springframework.stereotype.Component;
import com.marphain.demo.newer.ws.service.TestService;

@Component
public class TestServiceImpl implements TestService {
    @Override
    public void printBanner() {
        System.out.println("web service.");
    }
}
