package com.marphain.demo.newer.spring.aop.service.impl;

import com.marphain.demo.newer.spring.aop.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public void printCar() {
        System.out.println("The car can run.");
    }
}
