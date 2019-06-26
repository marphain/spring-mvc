package com.marphain.demo.newer.spring.aop.service.impl;

import com.marphain.demo.newer.spring.aop.service.AirplaneService;
import org.springframework.stereotype.Component;

@Component
public class AirplaneServiceImpl implements AirplaneService {
    @Override
    public void fly() {
        System.out.println("flying");
    }
}
