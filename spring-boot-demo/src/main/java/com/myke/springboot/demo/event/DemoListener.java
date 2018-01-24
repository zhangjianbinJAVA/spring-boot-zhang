package com.myke.springboot.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 13:04
 */
@Component
@Slf4j
public class DemoListener implements ApplicationListener<DemoEvent> {

    /**
     * 对消息进行接收处理
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        log.info("DemoListener 接收到 DemoPublisher 发布的 消息：{}", msg);
    }
}
