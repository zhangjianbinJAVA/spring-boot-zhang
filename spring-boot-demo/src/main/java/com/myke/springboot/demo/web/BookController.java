package com.myke.springboot.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user: zhangjianbin <br/>
 * date: 2018/1/19 18:16
 */
@RestController
public class BookController {

    @GetMapping
    public String index() {
        return "spring boot run";
    }
}
