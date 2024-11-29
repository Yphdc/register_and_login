package org.example.service;

import org.example.entity.User;

/*
 *@Description:
 *@Date:2024/11/27 19:32
 *@Author:YPH
 *@vision:1.0
 */
public interface UserService {

    //根据用户名注册
    User findByUserName(String username);

    void register(String username,String password);
}
