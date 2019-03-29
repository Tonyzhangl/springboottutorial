package com.kirago.chapter19.database;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 3:10 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Component
public class UserService {

    public UserBean getUser(String username){
        if(!DataSource.getData().containsKey(username)){
            return null;
        }
        UserBean userBean = new UserBean();
        Map<String, String> detail = DataSource.getData().get(username);

        userBean.setUsername(username);
        userBean.setPassword(detail.get("password"));
        userBean.setPermission(detail.get("permission"));
        userBean.setRole(detail.get("role"));

        return userBean;
    }
}
