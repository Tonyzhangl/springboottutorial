package com.kirago.chapter20.pojo;

public class RolePermissionKey {

    private Long roleId;

    private Long permissionId;

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public void setPermissionId(Long permissionId){
        this.permissionId = permissionId;
    }

    public Long getRoleId(){
        return roleId;
    }

    public Long getPermissionId(){
        return permissionId;
    }
}
