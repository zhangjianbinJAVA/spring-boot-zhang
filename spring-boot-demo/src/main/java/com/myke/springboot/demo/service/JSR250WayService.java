package com.myke.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 12:38
 */
@Slf4j
public class JSR250WayService {
    //在构造函数执行完之后执行
    @PostConstruct
    public void init() {
        log.info("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        log.info("初始化构造函数-{}", this.getClass().getSimpleName());
    }

    // 在 bean 销毁之前执行
    @PreDestroy
    public void destory() {
        log.info("jsr250-destory-method");
    }
}
