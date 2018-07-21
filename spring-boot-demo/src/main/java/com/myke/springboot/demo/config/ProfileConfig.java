package com.myke.springboot.demo.config;

import com.myke.springboot.demo.service.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 12:51
 */
@Configuration
@ComponentScan(basePackages = {"com.myke"})
public class ProfileConfig {


    @Bean
    @Profile("dev")
    public DemoBean devDemoBean() {
        return new DemoBean("dev profile");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean() {
        return new DemoBean("prod profile");
    }
}
