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
@TableName("material_type")
public class MaterialTypeEntity extends BaseEntity{
    @ApiModelProperty("材料类型编码")
    private String materialTypeCode;

    @ApiModelProperty("材料类型名称")
    private String materialTypeName;

    @ApiModelProperty("所属父分类")
    private Long parentId;


}
