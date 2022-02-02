package com.wang.material.api.controller;

import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.MaterialCreateDTO;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: 原材料管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "原材料管理", tags = "原材料管理")
@RestController
@RequestMapping("/material/manage")
public class MaterialController extends BaseOperationPlatformController {

    @Autowired
    private MaterialService materialService;

    @ApiOperation("新增/修改原材料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid MaterialCreateDTO material) {
        // 校验原材料是否存在
        MaterialEntity saveMaterial = new MaterialEntity();
        BeanUtils.copyProperties(material, saveMaterial);
        if (material.getId() == null) {
            saveMaterial.setCreateBy(getOperator());
        }
        saveMaterial.setUpdateBy(getOperator());
        Long id = materialService.createMaterial(saveMaterial);
        return ResponseEntity.ok(id);
    }

    @ApiOperation("删除原材料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/delete")
    public ResponseEntity<Integer> deleteMaterial(@RequestParam @Valid Long id) {
        MaterialEntity material = new MaterialEntity();
        material.setMaterialTypeId(id);
        material.setUpdateBy(getOperator());
        Integer result = materialService.deleteMaterial(material);
        // 校验原材料是否在配方中有使用，且配方为上线状态
        return ResponseEntity.ok(result);
    }
}
