package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.dto.FormulaQuery;
import com.wang.material.api.vo.ElectronicBalanceVO;
import com.wang.material.api.vo.FormulaPartVO;
import com.wang.material.api.vo.FormulaVO;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.FormulaPartEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.FormulaDetailMapper;
import com.wang.material.material.mapper.FormulaMapper;
import com.wang.material.material.service.FormulaPartService;
import com.wang.material.material.service.FormulaService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormulaServiceImpl implements FormulaService {

    @Autowired
    private UserService userService;

    @Resource
    private FormulaDetailMapper formulaDetailMapper;

    @Resource
    private FormulaMapper formulaMapper;

    @Autowired
    private FormulaPartService formulaPartService;


    @Override
    @Transactional
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
    @Transactional
    public Long createFormula(FormulaEntity formula) {
        userService.isAdmin(formula.getUpdateBy());
        FormulaEntity dbFormula = formulaMapper.selectById(formula.getId());
        // 校验配方名称或者编码是否有重复
        QueryWrapper<FormulaEntity> query = new QueryWrapper<>();
        query.eq("formula_name", formula.getFormulaName());
        List<FormulaEntity> formulaEntities = formulaMapper.selectList(query);
        if (!CollectionUtils.isEmpty(formulaEntities)) {
            throw new RuntimeException(MaterialErrorEnum.FORMULA_NAME_CODE_EXIST.getErrorMessage());
        }
        formulaMapper.insert(formula);
        insertDetail(formula);
        return formula.getId();
    }

    private void insertDetail(FormulaEntity formula) {
        if (!CollectionUtils.isEmpty(formula.getDetailList())) {
            formula.getDetailList().forEach(item -> {
                item.setFormulaId(formula.getId());
                item.setUpdateBy(formula.getUpdateBy());
                item.setCreateBy(formula.getCreateBy());
            });
            formulaDetailMapper.insertBatch(formula.getDetailList());
        }
        if (!CollectionUtils.isEmpty(formula.getChildFormulas())) {
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
    @Transactional
    public Integer deleteFormula(FormulaEntity formula) {
        Integer result = formulaMapper.deleteById(formula.getId());
        QueryWrapper formulaQuery = new QueryWrapper();
        formulaQuery.eq("parent_id", formula.getId());
        formulaMapper.delete(formulaQuery);
        QueryWrapper detailQuery = new QueryWrapper();
        detailQuery.eq("formula_id", formula.getId());
        formulaDetailMapper.delete(detailQuery);
        return result;
    }

    @Override
    public IPage<FormulaVO> getFormulas(IPage<FormulaEntity> page, FormulaQuery query) {
        QueryWrapper<FormulaEntity> formulaQuery = new QueryWrapper<>();
        if (query.getId() != null) {
            formulaQuery.eq("id", query.getId());
        }
        if (query.getOnlineStatus() != null) {
            formulaQuery.eq("online_status", query.getOnlineStatus());
        }
        if (!StringUtils.isEmpty(query.getFormulaStepName())) {
            List<FormulaPartEntity> parts = formulaPartService.getFormulaPartByName(query.getFormulaName());
            if (CollectionUtils.isEmpty(parts)) {
                throw new RuntimeException(MaterialErrorEnum.FORMULA_PART_NOT_EXIST.getErrorMessage());
            }
            formulaQuery.in("formula_step_id", parts.stream().map(FormulaPartEntity::getId).collect(Collectors.toList()));
        }
        if (query.getParentId() != null) {
            formulaQuery.eq("parent_id", query.getParentId());
        }

        List<FormulaVO> resultFormulas = new ArrayList<>();

        //分页实体类转换
        IPage<FormulaEntity> formulas = formulaMapper.selectPage(page, formulaQuery);
        // 组装配方步骤的名称
        List<Long> formulaPartIds = formulas.getRecords().stream().map(FormulaEntity::getFormulaPartId).collect(Collectors.toList());
        List<FormulaPartEntity> formulaParts = formulaPartService.getFormulaPartById(formulaPartIds);
        formulas.getRecords().forEach(formula -> {
            FormulaVO u = new FormulaVO();
            BeanUtils.copyProperties(formula, u);
            if( !CollectionUtils.isEmpty(formulaParts)) {
                Optional<FormulaPartEntity> optional = formulaParts.stream().filter(part -> part.getId().equals(formula.getFormulaPartId())).findFirst();
                if(optional.isPresent()) {
                    FormulaPartVO partVO = new FormulaPartVO();
                    BeanUtils.copyProperties(optional.get(), partVO);
                    u.setFormulaPart(partVO);
                }
            }

            resultFormulas.add(u);
        });


        IPage<FormulaVO> resPage = new Page<>();
        resPage.setTotal(formulas.getTotal());
        resPage.setRecords(resultFormulas);
        resPage.setSize(formulas.getSize());
        resPage.setPages(formulas.getPages());
        return resPage;
    }
}
