package org.example;

/*
 *@Description:
 *@Date:2024/11/30 2:13
 *@Author:YPH
 *@vision:1.0
 */


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTest {

    @Test
    public void TestGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token = JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()*1000*60*60*12))//系统毫秒*1000=1秒 *60=1分钟 *60=一小时 *12=十二小时
                .sign(Algorithm.HMAC256("NJHR"));
        System.out.println(token);
    }

    @Test
    public void TestParse(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJleHAiOjEwNzQ1MTQzMDU2MzY5OTMsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19" +
                ".e_pd0RPooTN2-4tmRbc8S6TeXfMp-5EYLQIugI-FAhU";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("NJHR")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
