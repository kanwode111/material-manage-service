package com.wang.material.api.dto;

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
@ApiModel("用户修改密码")
public class UserUpdatePasswordDTO {

    @ApiModelProperty(value = "用户Id", name = "id", dataType = "Long", required = true)
    @NotNull
    private Long id;

    @ApiModelProperty(value = "密码", name = "password", dataType = "String", required = true)
    @NotNull
    private String password;

    @ApiModelProperty(value = "密码", name = "newPassword", dataType = "String", required = true)
    @NotNull
    private String newPassword;


}
