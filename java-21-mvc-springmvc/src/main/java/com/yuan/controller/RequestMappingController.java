package com.yuan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class RequestMappingController {

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        return "success";
    }

    @RequestMapping(
            value = {"/m1", "/m2"}
    )
    public String testRequestMapping1(){
        return "success";
    }


    @RequestMapping(
            value = {"/testRequestMapping2", "/test"}
            ,method = {RequestMethod.GET, RequestMethod.POST}
            ,params = {"username","password!=123456"}
    )
    public String testRequestMapping2(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}
