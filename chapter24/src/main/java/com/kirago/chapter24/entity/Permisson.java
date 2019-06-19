package com.kirago.chapter24.entity;

public class RolePermisson {
    private Long id;
    private String url;
    private String rolename;
    private String desription;

    public void setId(long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setRolename(String rolename){
        this.rolename = rolename;
    }

    public String getRolename(){
        return rolename;
    }

    public void setDesription(String desription){
        this.desription = desription;
    }

    public String getDesription() {
        return desription;
    }
}
