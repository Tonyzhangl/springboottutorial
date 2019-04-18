package com.kirago.chapter20.pojo;

public class User {

    private Long id;

    private String username;

    /**
     * 密码
     */
    private String password;

    public void setId(Long id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Long getId(){
       return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

}
