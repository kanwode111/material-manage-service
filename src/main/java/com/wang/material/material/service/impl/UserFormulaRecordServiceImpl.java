package com.wang.material.material.service.impl;

import com.wang.material.material.entity.UserFormulaRecordEntity;
import com.wang.material.material.mapper.UserFormulaRecordMapper;
import com.wang.material.material.service.UserFormulaRecordService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserFormulaRecordServiceImpl implements UserFormulaRecordService {

    @Autowired
    private UserService userService;

    @Resource
    private UserFormulaRecordMapper userFormulaRecordMapper;

    /**
     * 添加配方
     * @param record
     * @return
     */
    @Override
    public Long createUserFormulaRecord(UserFormulaRecordEntity record){
        userService.isAdmin(record.getUpdateBy());
        if(record.getId() == null) {
            userFormulaRecordMapper.insert(record);
        } else {
            userFormulaRecordMapper.updateById(record);
        }

        return record.getId();
    }


    /**
     * 删除配方
     * @param record
     * @return
     */
    @Override
    public Integer deleteUserFormulaRecord(UserFormulaRecordEntity record){
        return userFormulaRecordMapper.deleteById(record.getId());
    }
}
