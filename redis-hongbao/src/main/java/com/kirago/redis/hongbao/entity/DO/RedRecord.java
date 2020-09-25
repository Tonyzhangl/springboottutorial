package com.kirago.redis.hongbao.entity.DO;

import java.math.BigDecimal;
import java.util.Date;

public class RedRecord {
    private Integer id;

    private Integer userId;

    private String redPackage;

    private Integer total;

    private BigDecimal amount;

    private Byte isActive;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRedPackage() {
        return redPackage;
    }

    public void setRedPackage(String redPackage) {
        this.redPackage = redPackage == null ? null : redPackage.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}