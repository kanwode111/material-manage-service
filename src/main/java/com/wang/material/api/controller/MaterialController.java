package com.wang.material.api.controller;

import com.wang.material.api.dto.MaterialCreateDTO;
import com.wang.material.api.dto.MaterialDeleteDTO;
import com.wang.material.api.dto.UserCreateDTO;
import com.wang.material.material.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description: 原材料管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "原材料管理", tags = "原材料管理")
@RestController
@RequestMapping("/material/manage")
public class MaterialController {

    @ApiOperation("新增/修改原材料")
    @PostMapping("/create")
    public Integer getElectronicManualList(@RequestBody @Valid MaterialCreateDTO material) {
        // 校验原材料是否存在
        return 1;
    }

    @ApiOperation("删除原材料")
    @PostMapping("/delete")
    public Integer deleteMaterial(@RequestBody @Valid MaterialDeleteDTO material) {
        // 校验原材料是否存在
        // 校验原材料是否在配方中有使用，且配方为上线状态
        return 1;
    }
}
