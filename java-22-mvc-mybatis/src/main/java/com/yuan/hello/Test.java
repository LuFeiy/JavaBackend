package com.yuan.hello;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            // Insert a user
            User newUser = new User();
            newUser.setId(2);
            newUser.setName("John Doe");
            newUser.setAge(25);
            newUser.setEmail("john.doe@example.com");
            mapper.insertUser(newUser);
            session.commit();

            // Select a user
            User user = mapper.selectUser(newUser.getId());
            System.out.println(user.getName() + " - " + user.getEmail());
        }
    }
}
