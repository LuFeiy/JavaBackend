package com.yuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/userPage")
    public String userPage() {
        // 返回视图名称，Spring MVC 会结合配置的视图解析器来找到对应的JSP文件
        return "user"; // 这里的 "user" 对应 WEB-INF/pages/user.jsp
    }

}
