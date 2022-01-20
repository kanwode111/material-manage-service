package com.wang.material.api.dto;

import com.wang.material.material.entity.BaseEntity;
import com.wang.material.material.enums.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: TODO
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("用户创建")
public class UserCreateDTO extends BaseEntity {
    @ApiModelProperty(value = "用户名", name = "username", dataType = "String", required = true)
    @NotNull
    private String username;

    @ApiModelProperty(value = "密码", name = "password", dataType = "String", required = true)
    @NotNull
    private String password;

    @ApiModelProperty(value = "电话", name = "phone", dataType = "Long", required = true)
    @NotNull
    private Long phone;

    @ApiModelProperty(value = "地址", name = "address", dataType = "String", required = true)
    @NotNull
    private String address;

    @ApiModelProperty(value = "角色：WORKER：普通员工， ADMIN: 管理员", name = "role", dataType = "RoleEnum", required = true)
    @NotNull
    private RoleEnum role;

    @ApiModelProperty(value = "创建人", name = "createBy", dataType = "RoleEnum", required = true)
    @NotNull
    private String createBy;


}
