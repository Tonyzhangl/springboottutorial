package com.chinamobile.epic.tinker.entity;

import java.sql.Timestamp;

public class ItemTemplate {

    private String id;
    private Integer source;
    private Integer categoryType;
    private String itemName;
    private String itemDesc;
    private Double itemWeight;
    private Integer isEnabled;
    private String secondaryItemName;
    private String primaryItemName;
    private String levelSet;
    private Timestamp createDate;
    private Integer version;
    private String ItemCode;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getSecondaryItemName() {
        return secondaryItemName;
    }

    public void setSecondaryItemName(String secondaryItemName) {
        this.secondaryItemName = secondaryItemName;
    }

    public String getPrimaryItemName() {
        return primaryItemName;
    }

    public void setPrimaryItemName(String primaryItemName) {
        this.primaryItemName = primaryItemName;
    }

    public String getLevelSet() {
        return levelSet;
    }

    public void setLevelSet(String levelSet) {
        this.levelSet = levelSet;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ItemTemplate{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", categoryType=" + categoryType +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemWeight=" + itemWeight +
                ", isEnabled=" + isEnabled +
                ", secondaryItemName='" + secondaryItemName + '\'' +
                ", primaryItemName='" + primaryItemName + '\'' +
                ", levelSet='" + levelSet + '\'' +
                ", createDate=" + createDate +
                ", version=" + version +
                ", ItemCode='" + ItemCode + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
