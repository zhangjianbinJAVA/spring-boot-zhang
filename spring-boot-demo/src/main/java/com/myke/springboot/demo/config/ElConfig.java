package com.myke.springboot.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * spring EL-Spring 表达式语言
 * user: zhangjianbin <br/>
 * date: 2018/1/22 13:00
 */
@Slf4j
@Configuration
// @PropertySource 加载资源文件
@PropertySource("classpath:application.properties")
public class ElConfig {

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private Environment environment;


    //注入普通字符串
    @Value("i love you")
    private String normal;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //注入表达式结果
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    //注入其他bean属性
    @Value("#{mailProperties.host}")
    private String mailHost;

    //注入文件资源
    @Value("classpath:com/myke/springboot/demo/config/test.txt")
    private Resource testProperties;

    // 注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;


    @Value("${zhang.mail.host}")
    private String mailHostProperties;

    public void outputResource() throws IOException {
        log.info("normal:{}", normal);
        log.info("osName:{}", osName);
        log.info("randomNumber:{}", randomNumber);
        log.info("mailHost:{}", mailHost);

        log.info("testProperties:{}", IOUtils.toString(testProperties.getInputStream()));
        log.info("testUrl www.baidu.com :{}", IOUtils.toString(testUrl.getInputStream()));

        log.info("mailHostProperties-1 :{}", mailHostProperties);
        log.info("mailHostProperties-2 :{}", environment.getProperty("zhang.mail.host"));
        log.info("mailHostProperties-3 :{}", mailProperties);
    }

}
