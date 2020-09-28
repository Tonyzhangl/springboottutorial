package com.kirago.cache.penetration.entity.DO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Item {
    private Integer id;

    private String code;

    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Item(){}
    
    public Item(Integer id, String code, String name, Date createTime){
        this.id = id;
        this.code = code;
        this.name = name;
        this.createTime = createTime;
    }
    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code == null ? null : code.trim();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name == null ? null : name.trim();
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//    
//    @Override
//    public String toString(){
//        return "{" +
//                "id=" + id +"," +
//                "code=" + code + "," +
//                "name=" + name + "," +
//                "createTime=" + createTime +
//                "}";
//    }
}