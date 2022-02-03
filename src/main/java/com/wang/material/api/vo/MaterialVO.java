package com.wang.material.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 配方实体类
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("材料返回VO")
public class MaterialVO  extends BaseVO {
    @ApiModelProperty("材料编码")
    private String materialCode;

    @ApiModelProperty("材料名称")
    private String materialName;

    @ApiModelProperty("材料类型")
    private Long materialTypeId;

    @ApiModelProperty("库存，以克为单位的库存")
    private Double materialStock;

    @ApiModelProperty("单价，以克为单位的单价")
    private Double price;

}
