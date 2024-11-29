package org.example.entity;

/*
 *@Description:
 *@Date:2024/11/28 8:14
 *@Author:YPH
 *@vision:1.0
 */

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;//状态码: 0-成功,1-失败
    private String message;//提示信息
    private T date;//响应数据

    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功",data);
    }

    public static Result success(){
        return new Result(0,"操作成功",null);
    }

    public static Result error(String message){
        return new Result(1,message,null);
    }
}
