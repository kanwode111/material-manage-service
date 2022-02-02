package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 创建配方
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("电子称添加")
public class ElectronicBalanceCreateDTO {

    @ApiModelProperty(value = "用户Id", name = "id", dataType = "Long",  required = false)
    private Long id;

    @ApiModelProperty(value = "电子称名称", name = "name", dataType = "String", required = true)
    @NotEmpty
    private String name;

    @ApiModelProperty(value = "电子称IP", name = "ip", dataType = "String", required = false)
    private String ip;

    @ApiModelProperty(value = "最大重量", name = "maxWeight", dataType = "Double", required = false)
    private Double maxWeight;

    @ApiModelProperty(value = "电子称等级", name = "level", dataType = "Integer", required = true)
    @NotNull
    private Integer level;

}
