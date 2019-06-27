package com.marphain.demo.newer.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * Bean的生命周期
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    /**
     * 实例化(调用构造函数)前调用
     * @param aClass
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
        return null;
    }

    /**
     * 实例化后调用
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        return false;
    }

    /**
     * seeter方法调用前使用
     * @param propertyValues
     * @param propertyDescriptors
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        return null;
    }

    /**
     * 初始化init()前使用
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    /**
     * 初始化init()后使用
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
