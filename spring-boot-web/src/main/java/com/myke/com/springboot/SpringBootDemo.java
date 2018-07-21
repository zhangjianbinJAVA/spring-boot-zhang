package com.myke.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * user: zhangjianbin <br/>
 * date: 2018/2/1 15:10
 */
@SpringBootApplication
public class SpringBootDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo.class, args);
    }


    @Configuration
    public static class CustomServletContainer implements EmbeddedServletContainerCustomizer {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            //根据不同的http 错误状态码，响应不同的错误页面
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        }
    }
}
