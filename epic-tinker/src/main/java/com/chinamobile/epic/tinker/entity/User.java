package com.chinamobile.epic.tinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
/**
 * @Author: wangjunsheng
 * @Date: 2019/11/4
 * @Descrption:
 */
@ApiModel(value = "User", description = "用户")
public class User implements Serializable {

    private String id;

    @ApiModelProperty(value = "用户名称", required = true)
    private String username;

    @ApiModelProperty(value = "用户邮箱", required = true)
    private String email;

    @ApiModelProperty(value = "用户手机号", required = true)
    private String phone;

    @ApiModelProperty(value = "用户所属部门", required = true)
    private String organizationId;

    @JsonIgnore
    private String createDate;

    @JsonIgnore
    private Integer deleted = 0;

    @ApiModelProperty(value = "员工编号", required = false)
    private String eployeeId;

    @ApiModelProperty(value = "用户密码", required = true)
    private String password;

    @ApiModelProperty(value = "用户角色", required = true)
    private List<Role> authorities ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrganizationId() {
        return organizationId;
    }

//    @JsonProperty
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted == null ? 0 : 1;
    }

    public String getEployeeId() {
        return eployeeId;
    }

    public void setEployeeId(String eployeeId) {
        this.eployeeId = eployeeId == null ? null : eployeeId.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", deleted=" + deleted +
                ", eployeeId='" + eployeeId + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}