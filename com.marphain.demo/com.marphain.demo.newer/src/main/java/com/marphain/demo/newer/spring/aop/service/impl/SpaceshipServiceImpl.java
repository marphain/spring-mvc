package com.marphain.demo.newer.spring.aop.service.impl;

import com.marphain.demo.newer.spring.aop.annotation.Log;
import com.marphain.demo.newer.spring.aop.service.SpaceshipService;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipServiceImpl implements SpaceshipService {
    @Log
    @Override
    public void huge() {
        System.out.println("spaceship");
    }
}
