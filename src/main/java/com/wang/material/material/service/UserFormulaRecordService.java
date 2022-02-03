package com.wang.material.material.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.material.api.dto.UserFormulaRecordQuery;
import com.wang.material.api.dto.UserQuery;
import com.wang.material.api.vo.UserFormulaRecordVO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;
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

    /**
     * 分页查询用户配料记录
     * @param page
     * @return
     */
    IPage<UserFormulaRecordVO> getUserFormulaRecord(IPage<UserFormulaRecordEntity> page, UserFormulaRecordQuery query);
}
