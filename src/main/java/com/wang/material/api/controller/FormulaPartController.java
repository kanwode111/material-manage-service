package com.wang.material.api.controller;

import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.FormulaPartCreateDTO;
import com.wang.material.material.entity.FormulaPartEntity;
import com.wang.material.material.service.FormulaPartService;
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

@Api(value = "配方步骤管理", tags = "配方步骤管理")
@RestController
@RequestMapping("/formulaPart/manage")
public class FormulaPartController extends BaseOperationPlatformController {

    @Autowired
    private FormulaPartService formulaPartService;

    @ApiOperation("新增/修改原材料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid FormulaPartCreateDTO formula) {
        FormulaPartEntity formulaPart = new FormulaPartEntity();
        BeanUtils.copyProperties(formula, formulaPart);
        formulaPart.setCreateBy(getOperator());
        formulaPart.setUpdateBy(getOperator());
        return ResponseEntity.ok(formulaPartService.createFormulaPar(formulaPart));
    }

    @ApiOperation("删除配方")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @GetMapping("/delete")
    public ResponseEntity<Integer> deleteFormulaPart(@RequestParam @Valid @NotNull Long id) {

        FormulaPartEntity formula = new FormulaPartEntity();
        formula.setUpdateBy(getOperator());
        formula.setId(id);
        return ResponseEntity.ok(formulaPartService.deleteFormulaPart(formula));
    }
}
