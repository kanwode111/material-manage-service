package com.wang.material.api.controller;

import com.wang.material.api.dto.MaterialCreateDTO;
import com.wang.material.api.dto.MaterialDeleteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description: 原材料配方管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "配方管理", tags = "配方管理")
@RestController
@RequestMapping("/formula/manage")
public class FormulaController {

    @ApiOperation("新增/修改配方")
    @PostMapping("/create")
    public Integer create(@RequestBody @Valid MaterialCreateDTO material) {
        // 校验原材料是否存在
        return 1;
    }

    @ApiOperation("删除配方")
    @PostMapping("/delete")
    public Integer deleteMaterial(@RequestBody @Valid MaterialDeleteDTO material) {
        // 校验原材料是否存在
        // 校验原材料是否在配方中有使用，且配方为上线状态
        return 1;
    }
}
