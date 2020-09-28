package com.kirago.redis.hongbao.constant;

public enum StatusCode {
    
    Success(0,"成功"),
    Fail(-1,"失败"),
    InvalidParams(201,"非法的参数!"),
    InvalidGrantType(202,"非法的授权");
    
    private Integer status;
    private String msg;
    
    StatusCode(Integer status, String msg){
        this.status = status;
        this.msg = msg;
    }
    
    public void setStatus(Integer status){
        this.status = status;
    }
    
    public Integer getStatus(){
        return status;
    }
    
    public void setMsg(String msg){
        this.msg = msg;
    }
    
    public String getMsg(){
        return msg;
    }
}
