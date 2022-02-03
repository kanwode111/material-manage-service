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

import java.util.Date;
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
@ApiModel("配方返回VO")
public class FormulaVO  extends BaseVO{
    @ApiModelProperty("配方编码，唯一不可变，同一配方的多个版本code相同")
    private String formulaCode;

    @ApiModelProperty("配方名称")
    private String formulaName;

    @ApiModelProperty("配方描述")
    private String description;

    @ApiModelProperty("配方总重量")
    private Double totalWeight;

    @ApiModelProperty("配方步骤")
    private FormulaPartVO formulaPart;

    @ApiModelProperty("所属配置")
    private Long parentId;

    @ApiModelProperty("配方版本号，当配方修改后，配方版本号+1，同一父配方下的所有子配置版本号也+1")
    private Integer version;

    @ApiModelProperty("配方是否上线，只有最新版本号的配方是上线状态的，其它")
    private Boolean onlineStatus;

    @ApiModelProperty("配方明细")
    private List<FormulaDetailEntity> detailList;

    @ApiModelProperty("配方下子配方")
    private List<FormulaEntity> childFormulas;

}
