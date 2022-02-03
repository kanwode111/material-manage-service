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
@ApiModel("配方添加")
public class FormulaCreateDTO {

    @ApiModelProperty(value = "Id", name = "id", dataType = "Long",  required = false)
    private Long id;

    @ApiModelProperty(value = "配方名称", name = "formulaName", dataType = "String", required = true)
    @NotEmpty
    private String formulaName;

    @ApiModelProperty(value = "配方描述", name = "description", dataType = "String", required = false)
    private String description;

    @ApiModelProperty(value = "配方总重量", name = "totalWeight", dataType = "Double", required = false)
    private Double totalWeight;

    @ApiModelProperty(value = "配方步骤", name = "formulaStepId", dataType = "Long", required = true)
    @NotNull
    private Long formulaStepId;

    @ApiModelProperty(value = "所属配置", name = "parentId", dataType = "Long", required = false)
    private Long parentId;

    @ApiModelProperty(value = "配方是否上线，只有最新版本号的配方是上线状态的，其它都为下线", name = "onlineStatus", dataType = "Boolean", required = false)
    private Boolean onlineStatus;

    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "String", required = true)
    @NotNull
    private String createBy;

    @ApiModelProperty(value = "子配方", name = "childFormulas", dataType = "List", required = false)
    private List<FormulaCreateDTO> childFormulas;

    @ApiModelProperty(value = "配方关联原材料集合", name = "formulaDetails", dataType = "List", required = false)
    private List<FormulaDetailDTO> formulaDetails;


}
