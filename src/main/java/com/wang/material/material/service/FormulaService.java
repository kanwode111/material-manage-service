package com.wang.material.material.service;

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

}

