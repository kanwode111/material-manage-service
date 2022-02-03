package com.wang.material.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.MaterialDeleteDTO;
import com.wang.material.api.dto.MaterialQuery;
import com.wang.material.api.dto.MaterialTypeCreateDTO;
import com.wang.material.api.dto.MaterialTypeQuery;
import com.wang.material.api.vo.MaterialTypeVO;
import com.wang.material.api.vo.MaterialVO;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.entity.MaterialTypeEntity;
import com.wang.material.material.service.MaterialTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author
 * @version 1.0
 * @description: 原材料管理
 * @date 2022/1/17 10:59
 */
@Api(value = "原材料类型管理", tags = "原材料类型管理")
@RestController
@RequestMapping("/materialType/manage")
public class MaterialTypeController extends BaseOperationPlatformController {

    @Resource
    private MaterialTypeService materialTypeService;

    @ApiOperation("新增/修改原材料类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid MaterialTypeCreateDTO material) {
        MaterialTypeEntity materialType = new MaterialTypeEntity();
        BeanUtils.copyProperties(material, materialType);
        if (material.getId() == null) {
            materialType.setCreateBy(getOperator());
        }
        materialType.setUpdateBy(getOperator());
        Long id = materialTypeService.createMaterialType(materialType);
        return ResponseEntity.ok(id);
    }

    @ApiOperation("删除原材料类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/delete")
    public ResponseEntity<Integer> deleteMaterialType(@RequestParam @Valid @NotNull Long id) {
        // 检验原材料类型下是否有原材料
        MaterialTypeEntity type = new MaterialTypeEntity();
        type.setUpdateBy(getOperator());
        type.setId(id);
        return ResponseEntity.ok(materialTypeService.deleteMaterialType(type));
    }

    @ApiOperation("查询配方类型")
    @PostMapping("/getMaterialTypes")
    public ResponseEntity<IPage<MaterialTypeVO>> getMaterialTypes(@RequestBody @Valid MaterialTypeQuery query) {
        Page<MaterialTypeEntity> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<MaterialTypeVO> iPage = materialTypeService.getMaterialTypes(page, query);

        return ResponseEntity.ok(iPage);
    }
}
