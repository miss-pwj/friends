package com.lcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lcl
 * @date 2019/10/20 23:02
 * @Description
 */

@Controller
public class TestController {

    //设置欢迎页面
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    //测试连接性
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "welcome hello";
    }



}