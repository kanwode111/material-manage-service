package com.wang.material.material.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 配方步骤实体类
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@TableName("formula_detail")
public class FormulaDetailEntity extends BaseEntity{
    
    @ApiModelProperty("配方Id")
    private Long formulaId;

    @ApiModelProperty("材料ID")
    private Long materialId;

    @ApiModelProperty("材料重量")
    private Double materialWeight;

    @ApiModelProperty("浮动上限（最大值）")
    private Double upperLimit;

    @ApiModelProperty("下限位（最小值）")
    private Double lowerLimit;



}
