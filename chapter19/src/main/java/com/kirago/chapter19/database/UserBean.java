package com.kirago.chapter19.database;


/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 11:06 AM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class UserBean {

    private String username;

    private String password;

    private String role;

    private String permission;

    public UserBean() {};

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setPermission(String permission){
        this.permission = permission;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    public String getPermission(){
        return permission;
    }
}
