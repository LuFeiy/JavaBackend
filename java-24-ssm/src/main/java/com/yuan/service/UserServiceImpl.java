package com.yuan.service;

import com.yuan.dao.UserDao;
import com.yuan.hello.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //    注入MyBatis的Dao对象
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser() {
        final User user = userDao.getUser("2");
        return user;
    }
}
