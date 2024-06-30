package com.yuan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {




    @RequestMapping(path = "/quick")
    public String quick() {
        // 业务逻辑
        System.out.println("quick runningggg......");
        // 视图跳转
        return "success";
    }
}
