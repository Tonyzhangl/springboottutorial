package com.kirago.redis.hongbao.util;

import com.kirago.redis.hongbao.constant.StatusCode;

public class BaseResponse<T> {
    private Integer code;
    
    private String msg;
    
    private T data;
    
    public BaseResponse(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    
    public BaseResponse(StatusCode statusCode){
        this.code = statusCode.getStatus();
        this.msg = statusCode.getMsg();
    }
    
    public Integer getCode(){
        return code;
    }
    
    public void setCode(Integer code){
        this.code = code;
    }
    
    public String getMsg(){
        return msg;
    }
    
    public void setMsg(String msg){
        this.msg = msg;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
}
