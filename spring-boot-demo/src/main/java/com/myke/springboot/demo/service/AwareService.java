package com.myke.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/24 13:28
 */
@Slf4j
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() throws IOException {
        log.info("bean名称：{}", beanName);

        Resource resource = loader.getResource("classpath:com/myke/springboot/demo/config/test.txt");
        log.info("ResourceLoader 加载的文件内容：{}", IOUtils.toString(resource.getInputStream()));
    }

}
