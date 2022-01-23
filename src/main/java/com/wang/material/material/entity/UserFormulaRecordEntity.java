package com.wang.material.material.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 配方实体类
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@TableName("user_formula_record")
public class UserFormulaRecordEntity extends BaseEntity{

    @ApiModelProperty("配方ID")
    private Long formulaId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("材料id")
    private Long materialId;

    @ApiModelProperty("材料重量")
    private Long materialWeight;


}
