package org.example.entity;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


/*
 *@Description:
 *@Date:2024/11/28 0:12
 *@Author:YPH
 *@vision:1.0
 */


//Lombok - @Data注解：自动在实体类自动配置GET SET 方法


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    private String nickname;//昵称
    private String password;//密码
    private String emily;//邮箱
    private String number;//电话号码
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
