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
@ApiModel("原材料查询")
public class MaterialQuery extends PageQuery{

    @ApiModelProperty(value = "Id", name = "id", dataType = "Long", required = false)
    private Long id;

    @ApiModelProperty(value = "材料编码", name = "materialCode", dataType = "String", required = false)
    private String materialCode;

    @ApiModelProperty(value = "材料名称", name = "materialName", dataType = "String", required = false)
    private String materialName;

    @ApiModelProperty(value = "材料类型", name = "materialTypeName", dataType = "String", required = false)
    private String materialTypeName;




}
