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
@ApiModel("原材料类型添加")
public class MaterialTypeCreateDTO {

    @ApiModelProperty(value = "id", name = "id", dataType = "Long", required = false)
    private Long id;

    @ApiModelProperty(value = "材料类型编码", name = "materialTypeCode", dataType = "String", required = true)
    private String materialTypeCode;

    @ApiModelProperty(value = "材料类型名称", name = "materialTypeName", dataType = "String", required = true)
    private String materialTypeName;

    @ApiModelProperty(value = "所属父分类", name = "parentId", dataType = "Long", required = true)
    private Long parentId;

    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "String", required = true)
    @NotNull
    private String createBy;


}
