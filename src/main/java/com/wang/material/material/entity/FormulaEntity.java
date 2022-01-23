package com.wang.material.material.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wang.material.material.enums.RoleEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 配方实体类
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@TableName("formula")
public class FormulaEntity extends BaseEntity{
    @ApiModelProperty("配方编码")
    private String formulaCode;

    @ApiModelProperty("配方名称")
    private String formulaName;

    @ApiModelProperty("配方描述")
    private String description;

    @ApiModelProperty("配方总重量")
    private Double totalWeight;

    @ApiModelProperty("配方步骤")
    private Long formulaStepId;

    @ApiModelProperty("所属配置")
    private Long parentId;

}
