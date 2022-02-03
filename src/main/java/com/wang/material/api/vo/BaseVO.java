package com.wang.material.api.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class BaseVO {
    private Long id;
    @ApiModelProperty("创建人")
    protected Date createBy;
    @ApiModelProperty("修改人")
    protected Date updateBy;
    @ApiModelProperty("创建时间")
    protected Date createDate;
    @ApiModelProperty("修改时间")
    protected Date updateDate;
}
