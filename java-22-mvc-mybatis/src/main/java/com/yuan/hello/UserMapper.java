package com.yuan.hello;

public interface UserMapper {
    User selectUser(int id);
    int insertUser(User user);
}
