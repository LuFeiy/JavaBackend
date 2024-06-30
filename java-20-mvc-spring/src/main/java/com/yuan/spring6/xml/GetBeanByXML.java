package com.yuan.spring6.xml;

import com.yuan.spring6.bean.HelloWorld;
import com.yuan.spring6.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanByXML {


    @Test
    public void testHelloWorld0(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        HelloWorld bean = (HelloWorld) ac.getBean("helloWorld");
        bean.sayHello();
    }

    @Test
    public void testHelloWorld1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        HelloWorld bean = ac.getBean(HelloWorld.class);
        bean.sayHello();
    }

    @Test
    public void testHelloWorld2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        HelloWorld bean = ac.getBean("helloworld", HelloWorld.class);
        bean.sayHello();
    }


    @Test
    public void testDIBySet(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        Student studentOne = ac.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }


    @Test
    public void testDIByConstructor(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        Student studentOne = ac.getBean("studentTwo", Student.class);
        System.out.println(studentOne);
    }




}
