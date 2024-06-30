package com.yuan.controller;

import com.yuan.bean.User;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamGetController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("query") String query, Model model) {
        // 在这里，你可以使用query参数（即 "spring mvc"）进行搜索操作
        model.addAttribute("result", "Search results for: " + query);
        return "searchResult";
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") Long userId, Model model) {
        // 根据userId（即123）获取用户信息
        System.out.println("userId:" + userId);
        //User user = userService.findById(userId);
        //model.addAttribute("user", user);
        return "userProfile";
    }

    /*@RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        // 在这里，你可以使用user对象（包含名字"John"和年龄30）来添加用户
        System.out.println("user：" + user);
        return ResponseEntity.ok("User created successfully");
    }*/


    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseEntity<String> checkHeader(@RequestHeader("User-Agent") String userAgent) {
        // 在这里，你可以使用userAgent字符串来进行检查
        return ResponseEntity.ok("Received request from User-Agent: " + userAgent);
    }

}
