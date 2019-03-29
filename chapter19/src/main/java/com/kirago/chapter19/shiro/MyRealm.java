package com.kirago.chapter19.shiro;

import com.kirago.chapter19.database.UserBean;
import com.kirago.chapter19.database.UserService;
import com.kirago.chapter19.util.JWTUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 4:09 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        String username = JWTUtil.getUsername(principalCollection.toString());
        UserBean userBean = userService.getUser(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(userBean.getRole());
        Set<String> permissions = new HashSet<>(Arrays.asList(userBean.getPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);
        if(username == null){
            throw new AuthenticationException("token invalid");
        }

        UserBean userBean = userService.getUser(username);

        if(userBean == null) {
            throw new AuthenticationException("User didn't existed");
        }

        if(!JWTUtil.verify(token,username,userBean.getPassword())){
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
