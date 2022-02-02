package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.FormulaDetailMapper;
import com.wang.material.material.mapper.FormulaMapper;
import com.wang.material.material.mapper.MaterialMapper;
import com.wang.material.material.service.FormulaService;
import com.wang.material.material.service.MaterialService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FormulaServiceImpl implements FormulaService {

    @Resource
    private MaterialMapper materialMapper;

    @Autowired
    private UserService userService;

    @Resource
    private FormulaDetailMapper formulaDetailMapper;

    @Resource
    private FormulaMapper formulaMapper;


    @Override
    public Long updateFormula(FormulaEntity formula) {
        userService.isAdmin(formula.getUpdateBy());
        //修改的时候增加了版本号之后即为添加了一条新的记录，原有配方为下线状态，新插入的为在线状态
        // 下线原有配方
        FormulaEntity dbFormula = formulaMapper.selectById(formula.getId());
        dbFormula.setOnlineStatus(false);
        dbFormula.setUpdateBy(formula.getUpdateBy());
        dbFormula.setUpdateDate(new Date());
        formulaMapper.updateById(dbFormula);
        //修改，修改的时候相当于增加了一个版本号，formulaCode不变，

        formula.setVersion(dbFormula.getVersion() + 1);
        formula.setOnlineStatus(true);
        // 设置ID为空，添加一个新的配方
        formula.setId(null);
        Integer result = formulaMapper.insert(formula);
        insertDetail(formula);
        return formula.getId();
    }


    @Override
    public Long createFormula(FormulaEntity formula) {
        userService.isAdmin(formula.getUpdateBy());
        FormulaEntity dbFormula = formulaMapper.selectById(formula.getId());
        // 校验配方名称或者编码是否有重复
        QueryWrapper<FormulaEntity> query = new QueryWrapper<>();
        query.eq("formula_name", formula.getFormulaName());
        List<FormulaEntity> formulaEntities = formulaMapper.selectList(query);
        if(!CollectionUtils.isEmpty(formulaEntities)) {
            throw new RuntimeException(MaterialErrorEnum.FORMULA_NAME_CODE_EXIST.getErrorMessage());
        }
        formulaMapper.insert(formula);
        insertDetail(formula);
        return formula.getId();
    }

    private void insertDetail(FormulaEntity formula) {
        if(!CollectionUtils.isEmpty(formula.getDetailList()) ) {
            formula.getDetailList().forEach(item -> {
                item.setFormulaId(formula.getId());
                item.setUpdateBy(formula.getUpdateBy());
                item.setCreateBy(formula.getCreateBy());
            });
            formulaDetailMapper.insertBatch(formula.getDetailList());
        }
        if(!CollectionUtils.isEmpty(formula.getChildFormulas())) {
            // 如果子配方不为空，子配方版本和父配方版本号保持一致
            formula.getChildFormulas().stream().forEach(item -> {
                item.setVersion(formula.getVersion());
                item.setParentId(formula.getId());
                item.setUpdateBy(formula.getUpdateBy());
                item.setCreateBy(formula.getCreateBy());
            });
            formulaMapper.batchInsert(formula.getChildFormulas());
        }
    }

    @Override
    public Integer deleteFormula(FormulaEntity formula) {
        return null;
    }
}
