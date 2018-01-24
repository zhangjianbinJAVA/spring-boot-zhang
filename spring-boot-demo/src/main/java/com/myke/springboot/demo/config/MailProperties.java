package com.myke.springboot.demo.config;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/22 14:19
 */
@Data
//@ConfigurationProperties注解就可以绑定属性了
//ignoreUnknownFields = false告诉Spring Boot在有属性不能匹配到声明的域的时候抛出异常
//prefix 用来选择哪个属性的prefix名字来绑定
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "zhang.mail",locations = "classpath:application.properties")
public class MailProperties {

    @Data
    public static class Smtp {
        private boolean auth;
        private boolean starttlsEnable;
    }

    @NotBlank
    private String host;
    private int port;
    private String from;
    private String username;
    private String password;
    @NotNull
    private Smtp smtp;

}
