package org.example.controller;

/*
 *@Description:
 *@Date:2024/11/29 16:52
 *@Author:YPH
 *@vision:1.0
 */

import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.Result;
import org.example.util.JWTUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(){
        return Result.success("所有文章数据");
    }
}
