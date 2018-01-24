package com.myke.springboot.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 13:07
 */
@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String msg) {
        // 发布事件
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }

}
