package com.wang.material.api.vo;

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
@ApiModel("电子手册列表返回VO类")
public class ElectronicBalanceVO extends BaseVO{

    @ApiModelProperty("电子称名称")
    private String name;

    @ApiModelProperty("电子称IP和端口")
    private String ip;

    @ApiModelProperty("最大称重")
    private Double maxWeight;

    @ApiModelProperty("电子称级别")
    private Integer level;

}
