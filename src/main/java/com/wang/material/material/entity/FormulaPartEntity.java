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
@TableName("formula_part")
public class FormulaPartEntity extends BaseEntity{

    @ApiModelProperty("配方步骤编码")
    private String formulaStepCode;

    @ApiModelProperty("配方步骤名称")
    private String formulaStepName;


}
