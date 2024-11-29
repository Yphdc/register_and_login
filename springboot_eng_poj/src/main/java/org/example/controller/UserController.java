package org.example.controller;

/*
 *@Description:
 *@Date:2024/11/27 19:33
 *@Author:YPH
 *@vision:1.0
 */


import jakarta.validation.constraints.Pattern;
import jakarta.websocket.server.PathParam;
import org.example.entity.User;
import org.example.entity.Result;
import org.example.service.UserService;
import org.example.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){

            //查询用户
            User u = userService.findByUserName(username);
            if(u == null){
                //null说明没有被占用
                //注册
                userService.register(username,password);
                return Result.success();
            }else{
                //占用
                return Result.error("用户被占用");
            }

    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp="^\\S{5,16}$") String username, @Pattern(regexp="^\\S{5,16}$") String password){

        //查询用户
        User loginUser = userService.findByUserName(username);

        //判断用户是否存在
        if(loginUser == null){
            return Result.error("用户未注册");
        }

        //密码是否正确
        if(password.equals(loginUser.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("user",loginUser.getUsername());
            String token = JWTUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }
}
