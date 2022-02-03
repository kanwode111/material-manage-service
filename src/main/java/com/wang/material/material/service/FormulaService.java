package com.wang.material.material.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.material.api.dto.ElectronicBalanceQuery;
import com.wang.material.api.dto.FormulaQuery;
import com.wang.material.api.vo.ElectronicBalanceVO;
import com.wang.material.api.vo.FormulaPartVO;
import com.wang.material.api.vo.FormulaVO;
import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.MaterialEntity;

/**
 * @description: 配方服务
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */
public interface FormulaService {

    /**
     * 添加配方
     * @param formula
     * @return
     */
    Long createFormula(FormulaEntity formula);

    Long updateFormula(FormulaEntity formula);

    /**
     * 删除配方
     * @param formula
     * @return
     */
    Integer deleteFormula(FormulaEntity formula);

    /**
     * 查询配方
     * @param page
     * @return
     */
    IPage<FormulaVO> getFormulas(IPage<FormulaEntity> page, FormulaQuery query);


}

