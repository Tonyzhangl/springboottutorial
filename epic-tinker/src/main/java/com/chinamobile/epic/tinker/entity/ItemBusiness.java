package com.chinamobile.epic.tinker.entity;

import java.sql.Date;

public class ItemBusiness {
    private String id;
    private Integer source;
    private Integer categoryType;
    private String userId;
    private String businessId;
    private String businessName;
    private String targetId;
    private Integer version;
    private String primaryItemName;
    private String secondaryItemName;
    private String itemName;
    private String itemDesc;
    private String levelSet;
    private Double itemWeight;
    private String commentResult;
    private String remark;
    private Date createDate;
    private Integer isDelete;
    private String estimateId;
    private String itemCommentsId;
    private String templateId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPrimaryItemName() {
        return primaryItemName;
    }

    public void setPrimaryItemName(String primaryItemName) {
        this.primaryItemName = primaryItemName;
    }

    public String getSecondaryItemName() {
        return secondaryItemName;
    }

    public void setSecondaryItemName(String secondaryItemName) {
        this.secondaryItemName = secondaryItemName;
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

    public String getLevelSet() {
        return levelSet;
    }

    public void setLevelSet(String levelSet) {
        this.levelSet = levelSet;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getCommentResult() {
        return commentResult;
    }

    public void setCommentResult(String commentResult) {
        this.commentResult = commentResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEstimateId() {
        return estimateId;
    }

    public void setEstimateId(String estimateId) {
        this.estimateId = estimateId;
    }


    public String getItemCommentsId() { return itemCommentsId; }

    public void setItemCommentsId(String itemCommentsId) { this.itemCommentsId = itemCommentsId; }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "ItemBusiness{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", categoryType=" + categoryType +
                ", userId='" + userId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", targetId='" + targetId + '\'' +
                ", version=" + version +
                ", primaryItemName='" + primaryItemName + '\'' +
                ", secondaryItemName='" + secondaryItemName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", levelSet='" + levelSet + '\'' +
                ", itemWeight='" + itemWeight + '\'' +
                ", commentsResult='" + commentResult + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate='" + createDate + '\'' +
                ", isDelete=" + isDelete +
                ", estimateId='" + estimateId + '\'' +
                ", itemCommentsId='" + itemCommentsId + '\'' +
                ", templateId='" + templateId + '\'' +
                '}';
    }
}
