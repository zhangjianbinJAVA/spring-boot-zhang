package com.myke.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/30 12:57
 */
@Slf4j
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("每隔五秒执行一次 ：{}", DATE_FORMAT.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecution() {
        log.info("在指定时间 ：{} 执行", DATE_FORMAT.format(new Date()));
    }
}
