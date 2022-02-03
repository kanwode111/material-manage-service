package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.FormulaPartEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.FormulaMapper;
import com.wang.material.material.mapper.FormulaPartMapper;
import com.wang.material.material.service.FormulaPartService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormulaPartServiceImpl implements FormulaPartService {

    @Resource
    private FormulaPartMapper formulaPartMapper;

    @Resource
    private FormulaMapper formulaMapper;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Long createFormulaPar(FormulaPartEntity formula) {
        userService.isAdmin(formula.getUpdateBy());
        if(formula.getId() == null) {
            formulaPartMapper.insert(formula);
        } else {
            formulaPartMapper.updateById(formula);
        }

        return formula.getId();
    }

    @Override
    public Integer deleteFormulaPart(FormulaPartEntity formulaPart) {
        // 校验配方步骤下面是否含有配方，且配方为上线状态
        userService.isAdmin(formulaPart.getUpdateBy());
        QueryWrapper<FormulaEntity> formulaQuery = new QueryWrapper<>();
        formulaQuery.eq("formula_part_id", formulaPart.getId());
        formulaQuery.eq("online_status", 0);
        List<FormulaEntity> formulas = formulaMapper.selectList(formulaQuery);
        if(!CollectionUtils.isEmpty(formulas)) {
            throw new RuntimeException(MaterialErrorEnum.CANNOT_DELETE_FORMULA_PART.getErrorMessage());
        }
        return formulaPartMapper.deleteById(formulaPart.getId());
    }

    @Override
    public List<FormulaPartEntity> getFormulaPartByName(String name) {
        QueryWrapper<FormulaPartEntity> query = new QueryWrapper<>();
        query.like("formula_part_name", name);
        return formulaPartMapper.selectList(query);
    }

    @Override
    public List<FormulaPartEntity> getFormulaPartById(List<Long> ids) {
        if(CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        return formulaPartMapper.selectBatchIds(ids);
    }

}
