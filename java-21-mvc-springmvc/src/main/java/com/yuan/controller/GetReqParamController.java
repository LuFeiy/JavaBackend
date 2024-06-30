package com.yuan.controller;


import com.yuan.bean.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GetReqParamController {

    @RequestMapping("/testParam")
    public String testParam(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/testParam2")
    public String testParam2(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }


    @RequestMapping("/testpojo")
    public String testPOJO(User2 user){
        System.out.println(user);
        return "success";
    }
//最终结果-->User{id=null, username='张三', password='123', age=23, sex='男', email='123@qq.com'}

}
