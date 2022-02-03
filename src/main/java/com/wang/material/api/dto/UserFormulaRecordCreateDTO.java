package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 用户配方记录实体
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("用户配方记录")
public class UserFormulaRecordCreateDTO {

    @ApiModelProperty(value = "配方Id", name = "formulaId", dataType = "Long",  required = true)
    private Long formulaId;

    @ApiModelProperty(value = "用户ID", name = "userId", dataType = "Long",  required = true)
    private Long userId;

    @ApiModelProperty(value = "材料id", name = "materialId", dataType = "Long",  required = true)
    private Long materialId;

    @ApiModelProperty(value = "配方Id", name = "formulaId", dataType = "String",  required = true)
    private String formulaName;

    @ApiModelProperty(value = "用户ID", name = "userId", dataType = "String",  required = true)
    private String userName;

    @ApiModelProperty(value = "材料id", name = "materialId", dataType = "String",  required = true)
    private String materialName;

    @ApiModelProperty(value = "材料重量", name = "materialWeight", dataType = "Long",  required = true)
    private Long materialWeight;

    @ApiModelProperty(value = "配方版本号，当配方修改后，配方版本号+1，同一父配方下的所有子配置版本号也+1", name = "formulaId", dataType = "Long",  required = true)
    private Integer formulaVersion;

}
