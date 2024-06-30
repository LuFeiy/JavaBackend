package com.yuan.spring6.xml;

import com.yuan.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testUserFactoryBean(){
        //获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        User user = (User) ac.getBean("userFactoryBean");
        System.out.println(user);
    }
}
