package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 创建配方步骤
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("创建配方步骤")
public class FormulaPartCreateDTO {

    @ApiModelProperty(value = "Id", name = "id", dataType = "Long",  required = false)
    private Long id;

    @ApiModelProperty(value = "配方步骤名称", name = "formulaPartName", dataType = "String", required = true)
    @NotEmpty
    private String formulaPartName;

    @ApiModelProperty(value = "配方步骤编码", name = "formulaPartCode", dataType = "String", required = true)
    @NotEmpty
    private String formulaPartCode;

    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "String", required = true)
    @NotNull
    private String createBy;

}
