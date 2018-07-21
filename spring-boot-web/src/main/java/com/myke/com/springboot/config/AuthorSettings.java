package com.myke.com.springboot.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * user: zhangjianbin <br/>
 * date: 2018/2/1 15:38
 */
@Data
@ConfigurationProperties(prefix = "myke", ignoreUnknownFields = true)
public class AuthorSettings {

    private ApplicationContext context;
    private HttpMessageConverters messageConverters;

    /**
     * 启动时 context 自动注入
     *
     * @param context
     */
    public AuthorSettings(ApplicationContext context, HttpMessageConverters messageConverters) {
        this.context = context;
        this.messageConverters = messageConverters;
    }

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Long age;
    /**
     * 其它属性
     */
    private Map<String, String> map;
}
