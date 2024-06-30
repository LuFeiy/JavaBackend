package com.yuan.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBatisSpringTest {
    @Test
    public void testSpringMyBatis(){
        /*构建一个Spring容器*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");

        /*从容器中获取Mapper*/
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        User user = userMapper.getUser("2");

        System.out.println("user = " + user);
    }

}
