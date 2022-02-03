package com.wang.material.api.vo;

import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.FormulaEntity;
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
@ApiModel("用户配料记录返回VO")
public class UserFormulaRecordVO  extends BaseVO{

    @ApiModelProperty("配方ID")
    private Long formulaId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("材料id")
    private Long materialId;

    @ApiModelProperty("材料重量")
    private Long materialWeight;

    @ApiModelProperty("配方版本号")
    private Integer formulaVersion;

    @ApiModelProperty(value = "配方名称")
    private String formulaName;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "材料编码")
    private String materialCode;
}
