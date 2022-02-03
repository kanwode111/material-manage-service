package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 创建配方
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("用户配料记录查询")
public class UserFormulaRecordQuery extends PageQuery {

    @ApiModelProperty(value = "Id", name = "id", dataType = "Long",  required = false)
    private Long id;

    @ApiModelProperty(value = "配方名称", name = "formulaName", dataType = "String", required = false)
    private String formulaName;

    @ApiModelProperty(value = "用户姓名", name = "username", dataType = "String", required = false)
    private String username;

    @ApiModelProperty(value = "材料编码", name = "materialCode", dataType = "String", required = false)
    private String materialCode;




}
