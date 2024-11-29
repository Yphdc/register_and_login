package org.example.service.impl;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@Description:
 *@Date:2024/11/27 19:32
 *@Author:YPH
 *@vision:1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        //加密
        //。。。。。。。。。。。。


        //调用mapper层添加
        userMapper.add(username,password);
    }
}
