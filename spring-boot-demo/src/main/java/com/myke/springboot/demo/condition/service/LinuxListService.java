package com.myke.springboot.demo.condition.service;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/30 13:31
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
