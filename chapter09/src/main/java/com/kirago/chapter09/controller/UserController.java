package com.kirago.chapter09.controller;

import com.kirago.chapter09.entity.UserEntity;
import com.kirago.chapter09.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/6 4:33 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody UserEntity user, HttpServletRequest request)
    {
        //登录成功
        boolean flag = true;
        String result = "登录失败";
        //根据用户名查询用户是否存在
        Optional<UserEntity> userEntityOptional = userJPA.findById(user.getId());
        if(userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            if(userEntity == null){
                flag = false;
                result = "用户不存在，登录失败";}
            //密码错误
            else if(!userEntity.getPwd().equals(user.getPwd())){
                flag = false;
                result = "用户密码不相符，登录失败";
            }
            //登录成功
            if(flag){
                //将用户写入session
                request.getSession().setAttribute("_session_user",userEntity);
                result = "登录成功";
            }
        }

        return result;
    }
}
