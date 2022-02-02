package com.wang.material.api.controller;

import com.wang.material.api.dto.FormulaCreateDTO;
import com.wang.material.api.dto.MaterialCreateDTO;
import com.wang.material.api.dto.MaterialDeleteDTO;
import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.service.FormulaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
public class FormulaController {

    @Autowired
    private FormulaService formulaService;

    @ApiOperation("新增/修改配方")
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
    @PostMapping("/delete")
    public Integer deleteMaterial(@RequestBody @Valid MaterialDeleteDTO material) {
        // 校验原材料是否存在
        // 校验原材料是否在配方中有使用，且配方为上线状态
        return 1;
    }
}
