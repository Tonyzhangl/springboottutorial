package com.chinamobile.epic.tinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 租户指标实体类
 * createed 2019-07-25
 * author daizhongwei
 */
@Data
@ApiModel(value = "TenantTarget", description = "租户评定指标项")
public class TenantTarget {

    //@ApiModelProperty(value = "指标项ID")
    @JsonIgnore
    private String id;

    @ApiModelProperty(value = "业务系统ID", required = true)
    private String businessId;

    @ApiModelProperty(value = "指标名称", required = true)
    private String itemName;

    @ApiModelProperty(value = "指标描述", required = true)
    private String itemDesc;

    @ApiModelProperty(value = "权重", required = true)
    private Double itemWeight;

    @ApiModelProperty(value = "是否启用，0禁用，1启用", required = true)
    private String isEnabled;

    @ApiModelProperty(value = "分类，0事前，1事中，2事后", required = true)
    private String categoryType;

    @ApiModelProperty(value = "评定结果", required = true)
    private String commentsResult;

    @ApiModelProperty(value = "等级名称", required = true)
    private String levelItem;

    @ApiModelProperty(value = "等级设定所属分组", required = true)
    private String groupId;

    @ApiModelProperty(value = "等级比重", required = true)
    private String defualtKey;
}