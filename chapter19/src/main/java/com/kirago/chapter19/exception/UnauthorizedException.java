package com.kirago.chapter19.exception;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 3:23 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String msg){
        super(msg);
    }

    public UnauthorizedException(){
        super();
    }
}
