package com.kirago.chapter07.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    protected int page = 1;

    /**
     * <p>
     * 分页每页数量,默认20条
     * <p>
     */
    protected int size = 20;

    /**
     * <p>
     * 排序列名称,默认为id
     * <p>
     */
    protected String sidx = "id";

    /**
     * <p>
     * 排序正序
     * <p>
     */
    protected String sord = "asc";
}
