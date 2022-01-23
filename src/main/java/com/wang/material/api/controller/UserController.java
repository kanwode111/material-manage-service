package com.wang.material.api.controller;


import com.wang.material.api.dto.UserCreateDTO;
import com.wang.material.api.dto.UserDeleteDTO;
import com.wang.material.api.dto.UserUpdatePasswordDTO;
import com.wang.material.api.vo.ElectronicManualVO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 用户管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("/user/manage")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("创建/修改用户信息")
    @PostMapping("/create")
    public Integer create(@RequestBody @Valid UserCreateDTO user) {
        UserEntity u = new UserEntity();
        BeanUtils.copyProperties(user, u);
        return userService.createUser(u);
    }


    @ApiOperation("查询所有用户")
    @PostMapping("/getAllUser")
    public List<UserEntity> getAllUser() {
        return userService.getAllUsers();
    }

    @ApiOperation("修改用户密码")
    @PostMapping("/updatePassword")
    public Integer updatePassword(UserUpdatePasswordDTO user) {
        //只有本人和管理员可以修改密码，需要校验权限
        return 1;
    }

    @ApiOperation("删除用户，允许批量删除")
    @PostMapping("/deleteUser")
    public Integer deleteUser(UserDeleteDTO users) {
        // 只有管理员可以删除用户，需要校验权限
        return 1;
    }


}
