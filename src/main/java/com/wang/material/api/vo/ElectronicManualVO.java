package com.wang.material.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: 电子手册类
 * @author
 * @date 2022/1/18 13:25
 * @version 1.0
 */
@Data
@Builder
@ApiModel("电子手册列表返回VO类")
public class ElectronicManualVO {

    private Long id;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌编码")
    private String brandCode;

    @ApiModelProperty("车系code")
    private String seriesCode;

    @ApiModelProperty("车系名称")
    private String seriesName;

    @ApiModelProperty("动力类型编码")
    private String modelTypeCode;

    @ApiModelProperty("动力类型名")
    private String modelTypeName;

    @ApiModelProperty("年款")
    private String otPattern;

    @ApiModelProperty("语言")
    private String language;

    @ApiModelProperty("版本号")
    private Float versionNum;

    @ApiModelProperty("版本描述")
    private String versionDescription;


    @ApiModelProperty("国家列表")
    private List<String> countries;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private Date updateTime;


}
