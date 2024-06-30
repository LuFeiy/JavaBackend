package com.yuan.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestUserController {

    @GetMapping("/userPage")
    public String userPage() {
        // 返回视图名称，Spring MVC 会结合配置的视图解析器来找到对应的JSP文件
        return "user"; // 这里的 "user" 对应 WEB-INF/pages/user.jsp
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return "User " + id;
    }

    @PostMapping
    public String createUser(@RequestBody String user) {
        System.out.println("user: " + user);
        return "User created";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody String user) {
        // 更新用户信息
        return "User " + id + " updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        // 删除用户
        return "User " + id + " deleted";
    }
}
