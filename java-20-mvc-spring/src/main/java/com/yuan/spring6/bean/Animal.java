package com.yuan.spring6.bean;

import org.springframework.stereotype.Component;

@Component
public class Animal {
    public Animal() {
        System.out.println("run animal");
    }

    public void sayHi() {
        System.out.println("Animal HI");
    }
}
