package com.wang.material.material.entity;

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
public class UserEntity extends BaseEntity{
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("电话")
    private Long phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("角色")
    private RoleEnum role;


}