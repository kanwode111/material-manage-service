package com.wang.material.material.service;

import com.wang.material.material.entity.UserFormulaRecordEntity;

public interface UserFormulaRecordService {
    /**
     * 添加用户配方记录
     * @param record
     * @return
     */
    Long createUserFormulaRecord(UserFormulaRecordEntity record);


    /**
     * 删除用户配方记录
     * @param record
     * @return
     */
    Integer deleteUserFormulaRecord(UserFormulaRecordEntity record);
}
