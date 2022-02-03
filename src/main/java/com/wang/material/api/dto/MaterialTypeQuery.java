package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("原材料类型查询")
public class MaterialTypeQuery extends PageQuery{

    @ApiModelProperty(value = "材料类型", name = "materialTypeName", dataType = "Long", required = false)
    private String materialTypeName;




}
