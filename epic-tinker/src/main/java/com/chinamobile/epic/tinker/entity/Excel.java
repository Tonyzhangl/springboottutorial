package com.chinamobile.epic.tinker.entity;

public class Excel {
    private String userName;
    private String organizationName;
    private String businessName;
    private String source;
    private String categoryType;
    private String levelName1;
    private String levelName2;
    private String levelName3;
    private Double itemWeight;
    private String itemDesc;
    private String levelSet;
    private String commentResult;
    private String remark;
    private String overallComments;
    private String totalDescription;


    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getLevelName1() {
        return levelName1;
    }

    public void setLevelName1(String levelName1) {
        this.levelName1 = levelName1;
    }

    public String getLevelName2() {
        return levelName2;
    }

    public void setLevelName2(String levelName2) {
        this.levelName2 = levelName2;
    }

    public String getLevelName3() {
        return levelName3;
    }

    public void setLevelName3(String levelName3) {
        this.levelName3 = levelName3;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
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

    public String getOverallComments() {
        return overallComments;
    }

    public void setOverallComments(String overallComments) {
        this.overallComments = overallComments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTotalDescription() {
        return totalDescription;
    }

    public void setTotalDescription(String totalDescription) {
        this.totalDescription = totalDescription;
    }

    @Override
    public String toString() {
        return "Excel{" +
                "userName='" + userName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", source='" + source + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", levelName1='" + levelName1 + '\'' +
                ", levelName2='" + levelName2 + '\'' +
                ", levelName3='" + levelName3 + '\'' +
                ", itemWeight=" + itemWeight +
                ", itemDesc='" + itemDesc + '\'' +
                ", levelSet='" + levelSet + '\'' +
                ", commentResult='" + commentResult + '\'' +
                ", remark='" + remark + '\'' +
                ", overallComments='" + overallComments + '\'' +
                ", totalDescription='" + totalDescription + '\'' +
                '}';
    }
}
