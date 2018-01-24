package com.myke.springboot.demo.config;

import com.myke.springboot.demo.event.DemoPublisher;
import com.myke.springboot.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/19 18:33
 */
@Slf4j
public class SringDemoTest {

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

    @Test
    public void applicationContext3() throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostConfig.class);

        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);

        context.close();
    }


    @Test
    public void applicationContext4() throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        //激活哪个环境
        context.getEnvironment().setActiveProfiles("dev");
        // 注册bean
        context.register(ProfileConfig.class);
        //刷新容器
        context.refresh();

        DemoBean bean = context.getBean(DemoBean.class);
        log.info("{} 环境的 bean", bean.getContext());

        context.close();
    }

    @Test
    public void applicationContext5() throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher bean = context.getBean(DemoPublisher.class);
        bean.publish("hello application event");
        context.close();
    }


    @Test
    public void applicationContext6() throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService bean = context.getBean(AwareService.class);
        bean.outputResult();
        context.close();
    }

    @Test
    public void applicationContext7() throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 40; i++) {
            // 执行结果是并发执行，而不是顺序执行
            bean.executeAsyncTask(i);
            bean.executeAsyncTaskPlus(i);
        }
        context.close();
    }

}