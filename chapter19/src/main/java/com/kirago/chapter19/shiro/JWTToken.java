package com.kirago.chapter19.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 4:14 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class JWTToken implements AuthenticationToken{

    private String token;

    public JWTToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal(){
        return token;
    }

    @Override
    public Object getCredentials(){
        return token;
    }

}
