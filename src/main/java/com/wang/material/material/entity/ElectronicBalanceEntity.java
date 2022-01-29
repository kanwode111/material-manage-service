package com.wang.material.material.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wang.material.material.enums.RoleEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@TableName("electronic_balance")
public class ElectronicBalanceEntity extends BaseEntity{
    @ApiModelProperty("电子称名称")
    private String name;

    @ApiModelProperty("电子称IP和端口")
    private String ip;

    @ApiModelProperty("最大称重")
    private Double maxWeight;

    @ApiModelProperty("电子称级别")
    private Integer level;

}
