package com.chinamobile.epic.tinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 评定指标的项的结果
 * createed 2019-07-25
 * author daizhongwei
 */
//@Api
@Data
@ApiModel(value = "BusinessTarget", description = "业务评定指标项")
public class BusinessTarget {
    //@ApiModelProperty(value = "指标项ID")
    @JsonIgnore
    private String id;

    @ApiModelProperty(value = "来源，0业务，1租户", required = true)
    private String source;

    @ApiModelProperty(value = "类型，0事前，1事中，2事后", required = true)
    private String categoryType;

    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;

    @ApiModelProperty(value = "业务系统ID", required = true)
    private String businessId;

    @ApiModelProperty(value = "指标模板ID", required = true)
    private String targetId;

    @ApiModelProperty(value = "指标模板版本", required = true)
    private String version;

    @ApiModelProperty(value = "一级指标名称", required = true)
    private String primaryItemName;

    @ApiModelProperty(value = "二级指标名称", required = true)
    private String secondaryItemName;

    @ApiModelProperty(value = "三级指标名称", required = true)
    private String itemName;

    @ApiModelProperty(value = "指标描述", required = true)
    private String itemDesc;

    @ApiModelProperty(value = "等级设定", required = true)
    private String levelSet;

    @ApiModelProperty(value = "权重", required = true)
    private Double itemWeight;

    @ApiModelProperty(value = "评定结果", required = true)
    private String commentsResult;

    @ApiModelProperty(value = "评定时间", required = true)
    private String createDate;
}