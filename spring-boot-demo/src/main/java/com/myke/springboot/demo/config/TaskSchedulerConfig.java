package com.myke.springboot.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/30 13:03
 */
@Configuration
@EnableScheduling // 开启对计划任务的支持
@ComponentScan("com.myke")
public class TaskSchedulerConfig {
}
