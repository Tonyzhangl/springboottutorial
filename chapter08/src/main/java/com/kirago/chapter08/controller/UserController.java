package com.kirago.chapter08.controller;

import com.kirago.chapter08.entity.UserEntity;
import com.kirago.chapter08.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/6 3:30 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public UserEntity save(UserEntity entity)
    {
        return userJPA.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public List<UserEntity> delete(Long id)
    {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
