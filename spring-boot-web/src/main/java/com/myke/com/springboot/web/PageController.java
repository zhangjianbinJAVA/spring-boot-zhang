package com.myke.com.springboot.web;

import com.myke.com.springboot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * user: zhangjianbin <br/>
 * date: 2018/2/1 15:12
 */
@EnableConfigurationProperties(AuthorSettings.class)
@Controller
public class PageController {

    @Autowired
    private AuthorSettings authorSettings;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", authorSettings.getName());
        model.addAttribute("address", authorSettings.getMap().get("address"));
        model.addAttribute("zhang", "myke");
        return "index";
    }
}
