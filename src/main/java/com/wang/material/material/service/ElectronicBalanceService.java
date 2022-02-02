package com.wang.material.material.service;

import com.wang.material.material.entity.ElectronicBalanceEntity;

public interface ElectronicBalanceService {
    /**
     * 添加配方
     * @param electronicBalanceEntity
     * @return
     */
    Long createElectronicBalance(ElectronicBalanceEntity electronicBalanceEntity);


    /**
     * 删除配方
     * @param electronicBalanceEntity
     * @return
     */
    Integer deleteElectronicBalance(ElectronicBalanceEntity electronicBalanceEntity);
}
