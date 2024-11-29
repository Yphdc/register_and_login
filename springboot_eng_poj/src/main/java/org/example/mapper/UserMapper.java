package org.example.mapper;

import org.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 *@Description:
 *@Date:2024/11/27 19:34
 *@Author:YPH
 *@vision:1.0
 */

@Mapper
public interface UserMapper {

    @Select("select * from tb_eng_poj_user where username = #{username}")
    User findByUserName(String username);


    @Insert("insert into tb_eng_poj_user(username, password, create_time, update_time) " +
            "values(#{username}, #{password},now(),now())")
    void add(String username, String password);
}
