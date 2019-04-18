package com.kirago.chapter20.pojo;

public class Permission {

    private Long id;

    private Integer ptype;

    public void setId(Long id){
        this.id = id;
    }

    public void setType(Integer type){
        this.ptype = type;
    }

    public Long getId(){
        return id;
    }

    public Integer getType(){
        return ptype;
    }
}
