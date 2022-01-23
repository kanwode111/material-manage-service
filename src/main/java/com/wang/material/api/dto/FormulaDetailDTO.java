package com.wang.material.api.dto;

import com.wang.material.material.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * @description: 配方步骤实体类
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("配方材料关联明细")
public class FormulaDetailDTO extends BaseEntity {

    @ApiModelProperty(value = "用户Id", name = "id", dataType = "Long", required = false)
    private Long id;

    @ApiModelProperty(value = "配方Id", name = "formulaId", dataType = "Long", required = false)
    private Long formulaId;

    @ApiModelProperty(value = "材料ID", name = "materialId", dataType = "Long", required = true)
    @NotNull
    private Long materialId;

    @ApiModelProperty(value = "材料重量", name = "materialWeight", dataType = "Double", required = true)
    @DecimalMin("0")
    @NotNull
    private Double materialWeight;

    @ApiModelProperty(value = "浮动上限（最大值）", name = "upperLimit", dataType = "Double", required = true)
    @DecimalMin("0")
    @NotNull
    private Double upperLimit;

    @ApiModelProperty(value = "下限位（最小值)", name = "lowerLimit", dataType = "Double", required = true)
    @DecimalMin("0")
    @NotNull
    private Double lowerLimit;

    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "String", required = true)
    @NotNull
    private String createBy;


}
