package com.chinamobile.epic.tinker.entity;

import java.util.Date;
import java.util.List;

public class BusinessEstimate {
    private String id;
    private String userId;
    private String businessId;
    private String businessName;
    private String orgId;
    private String orgName;
    private Date createDate;
    private Date updateDate;
    private Integer source;
    private Integer status;
    private String statusText;
    private String description;
    private List<TenantFile> tenantFileList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOrgId() { return orgId;}

    public void setOrgId(String orgId) {this.orgId = orgId;}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getDescription() {return description; }

    public void setDescription(String description) {this.description = description; }

    public String getBusinessName() {return businessName;}

    public void setBusinessName(String businessName) {this.businessName = businessName; }

    public String getOrgName() {return orgName; }

    public void setOrgName(String orgName) {this.orgName = orgName;}

    public List<TenantFile> getTenantFileList() {return tenantFileList;}

    public void setTenantFileList(List<TenantFile> tenantFileList) {this.tenantFileList = tenantFileList;}

    @Override
    public String toString() {
        return "BusinessEstimate{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", source=" + source +
                ", status=" + status +
                ", statusText='" + statusText + '\'' +
                ", description='" + description + '\'' +
                ", tenantFileList=" + tenantFileList +
                '}';
    }
}
