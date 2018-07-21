package com.myke.springboot.demo.config;

import com.myke.springboot.demo.condition.LinuxCondition;
import com.myke.springboot.demo.condition.WindowsCondition;
import com.myke.springboot.demo.condition.service.LinuxListService;
import com.myke.springboot.demo.condition.service.ListService;
import com.myke.springboot.demo.condition.service.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/30 13:32
 */
@Configuration
@ComponentScan("com.myke")
public class ConditionConfig {

    /**
     * 符合 windows 条件则实例化
     *
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean
    public ListService windowsListService() {
        return new WindowsListService();
    }

    /**
     * 符合 linux 条件则实例化
     *
     * @return
     */
    @Conditional(LinuxCondition.class)
    @Bean
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
