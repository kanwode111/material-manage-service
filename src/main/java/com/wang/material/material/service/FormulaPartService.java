package com.wang.material.material.service;

import com.wang.material.material.entity.FormulaPartEntity;

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

}

