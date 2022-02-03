package com.wang.material.material.service;

import com.wang.material.material.entity.FormulaPartEntity;

import java.util.List;

/**
 * @description: 配方服务
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */
public interface FormulaPartService {

    /**
     * 添加配方
     * @param formula
     * @return
     */
    Long createFormulaPar(FormulaPartEntity formula);


    /**
     * 删除配方
     * @param formula
     * @return
     */
    Integer deleteFormulaPart(FormulaPartEntity formula);

    /**
     * 根据名称查询配方步骤列表
     * @param name
     * @return
     */
    List<FormulaPartEntity> getFormulaPartByName(String name);

    /**
     * 根据id列表查询步骤列表
     * @param ids
     * @return
     */
    List<FormulaPartEntity> getFormulaPartById(List<Long> ids);

}

