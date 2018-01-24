package com.myke.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 12:36
 */
@Slf4j
public class BeanWayService {

    public void init() {
        log.info("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        log.info("初始化构造函数-{}", this.getClass().getSimpleName());
    }

    public void destory() {
        log.info("@Bean-destory-method");
    }
}
