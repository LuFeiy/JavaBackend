package com.yuan.hello;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select("select * from user where id = #{userId}")
    User getUser(@Param("userId")String userid);
}
