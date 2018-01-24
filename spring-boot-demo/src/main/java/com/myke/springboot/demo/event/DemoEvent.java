package com.myke.springboot.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 13:01
 */
public class DemoEvent extends ApplicationEvent {


    private String msg;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
