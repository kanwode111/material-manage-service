package com.wang.material.api.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wang.material.material.entity.BaseEntity;
import com.wang.material.material.enums.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: TODO
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("用户信息VO")
public class UserVO extends BaseVO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("角色")
    private RoleEnum role;



}
