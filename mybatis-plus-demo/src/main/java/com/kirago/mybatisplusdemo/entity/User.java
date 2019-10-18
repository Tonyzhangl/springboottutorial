package com.kirago.mybatisplusdemo.entity;

import lombok.Data;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/10/9 10:57 AM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@Data
public class User {

    private long id;

    private String name;

    private Integer age;

    private String email;
}
