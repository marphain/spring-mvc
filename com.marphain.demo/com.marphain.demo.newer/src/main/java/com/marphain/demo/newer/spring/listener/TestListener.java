package com.marphain.demo.newer.spring.listener;

import com.marphain.demo.newer.spring.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        System.out.println("处理事件testEvent：" + testEvent.getSource());
    }
}
