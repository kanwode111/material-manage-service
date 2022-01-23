package com.wang.material.api.controller;

import com.wang.material.api.dto.MaterialDeleteDTO;
import com.wang.material.api.dto.MaterialTypeCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description: 原材料管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "原材料类型管理", tags = "原材料类型管理")
@RestController
@RequestMapping("/materialType/manage")
public class MaterialTypeController {

    @ApiOperation("新增/修改原材料类型")
    @PostMapping("/create")
    public Integer create(@RequestBody @Valid MaterialTypeCreateDTO material) {
        // 校验原材料是否存在
        return 1;
    }

    @ApiOperation("删除原材料类型")
    @PostMapping("/delete")
    public Integer deleteMaterialType(@RequestBody @Valid MaterialDeleteDTO material) {
        // 检验原材料类型下是否有原材料
        return 1;
    }
}
