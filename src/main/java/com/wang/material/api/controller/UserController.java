package com.wang.material.api.controller;


import com.wang.material.api.vo.ElectronicManualVO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("创建用户")
    @PostMapping("/Create")
    public Long getElectronicManualList(@RequestBody @Valid UserEntity user) {
        userService.createUser(user);
        return 1l;
    }


    @ApiOperation("查询所有用户")
    @PostMapping("/getAllUser")
    public List<UserVO> getElectronicManualList() {
        return null;
    }


}
