package com.yuan.spring6.tx;


//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import com.yuan.spring6.bean.Animal;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring-datasource.xml")
public class JDBCTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Animal animal;

    @Test
    public void testUser(){
        System.out.println(animal);
        animal.sayHi();
    }

    @Test
    //测试增删改功能
    public void testUpdate(){
        //添加功能
        String sql = "insert into t_emp values(null,?,?,?)";
        int result = jdbcTemplate.update(sql, "张三", 23, "男");

    }



}




