package com.marphain.demo.newer.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
public class TestEvent extends ApplicationEvent {
    public TestEvent(Object source) {
        super(source);
    }
}
