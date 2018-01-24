package com.myke.springboot.demo.service;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 12:53
 */
public class DemoBean {
    private String context;

    public DemoBean(String context) {
        super();
        this.context = context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }
}
