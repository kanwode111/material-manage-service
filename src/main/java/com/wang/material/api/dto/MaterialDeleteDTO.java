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
@ApiModel("原材料删除")
public class MaterialDeleteDTO {

    @ApiModelProperty(value = "原材料Id", name = "id", dataType = "Long", required = false)
    private Long id;



    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "String", required = true)
    @NotNull
    private String createBy;


}
