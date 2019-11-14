package com.chinamobile.epic.tinker.entity;
/**
 * @Author: wangjunsheng
 * @Date: 2019/11/4
 * @Descrption:
 */
public class TenantFile {
    private String id;
    private String relationId;
    private String fileName;
    private String fileType;
    private String fileSize;
    private String fileConent;
    private String orgId;
    private String businessId;
    private String url;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileConent() {
        return fileConent;
    }

    public void setFileConent(String fileConent) {
        this.fileConent = fileConent;
    }

    public String getOrgId() {return orgId; }

    public void setOrgId(String orgId) {this.orgId = orgId; }

    public String getBusinessId() {return businessId; }

    public void setBusinessId(String businessId) {this.businessId = businessId;}


    public String getUrl() { return url;}

    public void setUrl(String url) {this.url = url;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    @Override
    public String toString() {
        return "TenantFile{" +
                "id='" + id + '\'' +
                ", relationId='" + relationId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileConent='" + fileConent + '\'' +
                ", orgId='" + orgId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
