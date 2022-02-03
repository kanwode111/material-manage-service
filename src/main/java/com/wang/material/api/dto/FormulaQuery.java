package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 创建配方
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("配方查询")
public class FormulaQuery extends PageQuery {

    @ApiModelProperty(value = "Id", name = "id", dataType = "Long",  required = false)
    private Long id;

    @ApiModelProperty(value = "配方名称", name = "formulaName", dataType = "String", required = false)
    private String formulaName;

    @ApiModelProperty(value = "配方步骤名称", name = "formulaStepName", dataType = "String", required = false)
    private String formulaStepName;

    @ApiModelProperty(value = "所属配置", name = "parentId", dataType = "Long", required = false)
    private Long parentId;

    @ApiModelProperty(value = "配方是否上线，只有最新版本号的配方是上线状态的，其它都为下线", name = "onlineStatus", dataType = "Boolean", required = false)
    private Boolean onlineStatus;


}
