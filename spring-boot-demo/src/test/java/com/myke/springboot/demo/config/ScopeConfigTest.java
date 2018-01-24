package com.myke.springboot.demo.config;

import com.myke.springboot.demo.service.DemoPrototypeService;
import com.myke.springboot.demo.service.DemoSingletonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/19 18:33
 */
@Slf4j
public class ScopeConfigTest {

    /**
     * 使用AnnotationConfigApplicationContext
     * 可以实现基于Java的配置类加载Spring的应用上下文.
     * 避免使用application.xml进行配置
     */
    @Test
    public void applicationContext() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService singletonService = context.getBean(DemoSingletonService.class);
        DemoSingletonService singletonService1 = context.getBean(DemoSingletonService.class);

        DemoPrototypeService prototypeService = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService prototypeService1 = context.getBean(DemoPrototypeService.class);

        log.info("singletonService 和singletonService1 是否相等：{}", singletonService.equals(singletonService1));
        log.info("prototypeService 和prototypeService1是否相等：{}", prototypeService.equals(prototypeService1));
    }

    @Test
    public void applicationContext2() throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ResourcConfig.class);
        ElConfig bean = context.getBean(ElConfig.class);
        bean.outputResource();
    }

}