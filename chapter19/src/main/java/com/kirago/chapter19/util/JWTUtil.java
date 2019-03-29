package com.kirago.chapter19.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 3:52 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class JWTUtil {

    private static final long EXPIRE_TIME = 5*60*1000;

    public static boolean verify(String token,String username,String secret){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withClaim("username",username)
                    .build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    public static String getUsername(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e){
            return null;
        }
    }

    public static String sign(String username, String secret){
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e){
            return null;
        }
    }
}
