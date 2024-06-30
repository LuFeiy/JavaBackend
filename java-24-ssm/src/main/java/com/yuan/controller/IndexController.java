package com.yuan.controller;

import com.yuan.hello.User;
import com.yuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test() throws Exception{
        return "Hello F2135";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public String getUser() throws Exception{
        final User user = userService.getUser();
        return user.toString();
    }
}
