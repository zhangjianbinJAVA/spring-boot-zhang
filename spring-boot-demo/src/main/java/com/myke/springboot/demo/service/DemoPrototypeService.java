package com.myke.springboot.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/19 18:29
 */
@Service
//prototype 每次调用新建一个bean实例
@Scope("prototype")
public class DemoPrototypeService {
}
