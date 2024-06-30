package com.yuan.spring6.junit;

import com.yuan.spring6.bean.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:jbeans.xml")
public class SpringJUnit5Test {

    @Autowired
    private Animal animal;

    @Test
    public void testUser(){
        System.out.println(animal);
        animal.sayHi();
    }
}
