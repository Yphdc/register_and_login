package org.example.interceptors;

/*
 *@Description:
 *@Date:2024/11/30 3:43
 *@Author:YPH
 *@vision:1.0
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.util.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String claimes = request.getHeader("Authorization");

        try {
            Map<String, Object> claims = JWTUtil.ParseToken(claimes);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }

    }
}
