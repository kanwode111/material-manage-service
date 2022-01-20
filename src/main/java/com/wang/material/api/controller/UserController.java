package com.wang.material.api.controller;


import com.wang.material.api.vo.ElectronicManualVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description: 用户管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("/user/manage")
public class UserController
{

    @ApiOperation("创建用户")

    @PostMapping("/Create")
    public ElectronicManualVO getElectronicManualList(@RequestBody @Valid String query) {
        return null;
    }




}
