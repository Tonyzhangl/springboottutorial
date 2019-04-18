package com.kirago.chapter20.pojo;

public class UserRoleKey {

    private Long userId;

    private Long roleId;

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public Long getUserId(){
        return userId;
    }

    public Long getRoleId(){
        return roleId;
    }
}
