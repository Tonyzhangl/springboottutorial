package com.chinamobile.epic.tinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel(value = "TargetTemplate", description = "指标模板")
public class TargetTemplate {

    @JsonIgnore
    private String id;

    @ApiModelProperty(value = "来源，0业务，1租户", required = true)
    private String source;

    @ApiModelProperty(value = "类型 0事前;1事中;2事后", required = true)
    private String categoryType;

    @ApiModelProperty(value = "三级指标名称", required = true)
    private String itemName;

    @ApiModelProperty(value = "指标描述", required = true)
    private String itemDesc;

    @ApiModelProperty(value = "权重", required = true)
    private Double itemWeight;

    @JsonIgnore
    private String isEnabled;

    @ApiModelProperty(value = "备注", required = true)
    private String remark;

    @ApiModelProperty(value = "二级指标名称", required = true)
    private String secondaryIitemName;

    @ApiModelProperty(value = "一级指标名称", required = true)
    private String primaryItemName;

    @ApiModelProperty(value = "等级设定", required = true)
    private String levelSet;

    @JsonIgnore
    private Timestamp createDate;

    @JsonIgnore
    private int version;

}
