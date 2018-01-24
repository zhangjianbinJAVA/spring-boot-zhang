package com.myke.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 13:42
 */
@Slf4j
@Service
public class AsyncTaskService {

    //@Async 表示异步方法，在类上，则所有方法都是异步方法，在这里方法自动被注入ThreadPoolTaskExecutor 作为 TaskExecutor
    @Async
    public void executeAsyncTask(Integer i) {
        log.info("执行异步任务：{}", i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        log.info("执行异步任务+1：{}", i + 1);
    }
}
