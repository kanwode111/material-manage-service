package com.wang.material.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.PageQuery;
import com.wang.material.api.dto.UserCreateDTO;
import com.wang.material.api.dto.UserUpdatePasswordDTO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description: 用户管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("/user/manage")
public class UserController extends BaseOperationPlatformController {

    @Autowired
    private UserService userService;

    @ApiOperation("创建/修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid UserCreateDTO user) {
        UserEntity u = new UserEntity();
        BeanUtils.copyProperties(user, u);
        if(user.getId() == null) {
            u.setCreateBy(getOperator());
        }
        u.setUpdateBy(getOperator());
        return ResponseEntity.ok(userService.createUser(u));
    }


    @ApiOperation("查询所有用户")
    @PostMapping("/getAllUser")
    public ResponseEntity<IPage<UserVO>> getAllUser(@RequestBody PageQuery query) {
        Page<UserEntity> page = new Page<>(query.getPageNumber(), query.getPageSize());
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(query, user);
        IPage<UserVO> iPage = userService.getAllUsers(page);

        return ResponseEntity.ok(iPage);
    }

    @ApiOperation("修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/updatePassword")
    public ResponseEntity<Integer> updatePassword(UserUpdatePasswordDTO param) {
        //只有本人和管理员可以修改密码，需要校验权限
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(param, user);
        user.setUpdateBy(getOperator());
        return ResponseEntity.ok(userService.updatePassword(user));
    }

    @ApiOperation("删除用户，允许批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/deleteUser")
    public Integer deleteUser(@RequestParam @Valid @NotNull Long id) {
        // 只有管理员可以删除用户，需要校验权限
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setUpdateBy(getOperator());
        return 1;
    }


}
