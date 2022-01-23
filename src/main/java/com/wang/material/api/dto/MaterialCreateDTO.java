package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: TODO
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("原材料添加")
public class MaterialCreateDTO {

    @ApiModelProperty(value = "用户Id", name = "id", dataType = "Long", required = false)
    private Long id;

    @ApiModelProperty(value = "材料编码", name = "materialCode", dataType = "String", required = true)
    private String materialCode;

    @ApiModelProperty(value = "材料名称", name = "materialName", dataType = "String", required = true)
    private String materialName;

    @ApiModelProperty(value = "材料类型", name = "materialTypeId", dataType = "Long", required = true)
    private Long materialTypeId;

    @ApiModelProperty(value = "库存，以克为单位的库存", name = "materialStock", dataType = "Double", required = false)
    private Double materialStock;

    @ApiModelProperty(value = "单价，以克为单位的单价", name = "price", dataType = "Double", required = false)
    private Double price;

    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "String", required = true)
    @NotNull
    private String createBy;


}
