package com.myke.springboot.demo.config;

import com.myke.springboot.demo.service.BeanWayService;
import com.myke.springboot.demo.service.JSR250WayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 12:42
 */
@Configuration
@ComponentScan("com.myke")
public class PrePostConfig {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public BeanWayService beanWayService() {
        return new BeanWayService();
    }

    @Bean
    public JSR250WayService jsr250WayService() {
        return new JSR250WayService();
    }
}
