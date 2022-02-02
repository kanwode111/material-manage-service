package com.wang.material.api.controller;

import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.FormulaCreateDTO;
import com.wang.material.api.dto.MaterialCreateDTO;
import com.wang.material.api.dto.MaterialDeleteDTO;
import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.service.FormulaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 原材料配方管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "配方管理", tags = "配方管理")
@RestController
@RequestMapping("/formula/manage")
public class FormulaController extends BaseOperationPlatformController {

    @Autowired
    private FormulaService formulaService;

    @ApiOperation("新增/修改配方")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid FormulaCreateDTO formula) {
        FormulaEntity formulaEntity = new FormulaEntity();
        BeanUtils.copyProperties(formula, formulaEntity);
        this.convert(formulaEntity, formula);
        if(formula.getId() != null) {
            return ResponseEntity.ok(formulaService.createFormula(formulaEntity));
        }else {
            return ResponseEntity.ok(formulaService.updateFormula(formulaEntity));
        }
    }

    private void convert(FormulaEntity formulaEntity, FormulaCreateDTO formula) {
        if(CollectionUtils.isEmpty(formula.getChildFormulas())) {
            List<FormulaEntity> childFormulas = new ArrayList<>();
            formula.getChildFormulas().forEach(item -> {
                FormulaEntity child = new FormulaEntity();
                BeanUtils.copyProperties(item, child);
                childFormulas.add(child);
            });
            formulaEntity.setChildFormulas(childFormulas);
        }
        if(CollectionUtils.isEmpty(formula.getFormulaDetails())) {
            List<FormulaDetailEntity> details = new ArrayList<>();
            formula.getChildFormulas().forEach(item -> {
                FormulaDetailEntity child = new FormulaDetailEntity();
                BeanUtils.copyProperties(item, child);
                details.add(child);
            });
            formulaEntity.setDetailList(details);
        }
    }

    @ApiOperation("删除配方")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @GetMapping("/delete")
    public ResponseEntity<Integer> deleteFormula(@RequestParam @Valid @NotNull Long id) {
        // 校验原材料是否存在
        // 校验原材料是否在配方中有使用，且配方为上线状态
        FormulaEntity formula = new FormulaEntity();
        formula.setUpdateBy(getOperator());
        formula.setId(id);
        return ResponseEntity.ok(formulaService.deleteFormula(formula));
    }
}
