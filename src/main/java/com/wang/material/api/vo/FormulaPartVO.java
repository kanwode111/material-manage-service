package com.wang.material.api.vo;

import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.FormulaPartEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: 电子手册类
 * @author
 * @date 2022/1/18 13:25
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("配方步骤返回VO")
public class FormulaPartVO extends BaseVO{

    @ApiModelProperty("配方步骤编码")
    private String formulaPartCode;

    @ApiModelProperty("配方步骤名称")
    private String formulaPartName;

    @ApiModelProperty("电子称ID")
    private Long electronicBalanceId;

}
