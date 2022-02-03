package com.wang.material.api.dto;

import com.wang.material.material.enums.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 查询用户列表
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("用户查询")
public class UserQuery extends PageQuery {

    @ApiModelProperty(value = "用户名", name = "username", dataType = "String", required = false)
    private String username;

    @ApiModelProperty(value = "电话", name = "phone", dataType = "String", required = false)
    private String phone;

    @ApiModelProperty(value = "地址", name = "address", dataType = "String", required = false)
    private String address;

    @ApiModelProperty(value = "角色：WORKER：普通员工， ADMIN: 管理员", name = "role", dataType = "RoleEnum", required = false)
    private RoleEnum role;

}
