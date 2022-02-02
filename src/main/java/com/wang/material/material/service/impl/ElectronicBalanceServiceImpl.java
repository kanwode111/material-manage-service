package com.wang.material.material.service.impl;

import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.mapper.ElectronicBalanceMapper;
import com.wang.material.material.service.ElectronicBalanceService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ElectronicBalanceServiceImpl implements ElectronicBalanceService {

    @Autowired
    private UserService userService;

    @Resource
    private ElectronicBalanceMapper electronicBalanceMapper;

    @Override
    public Long createElectronicBalance(ElectronicBalanceEntity electronicBalanceEntity) {
        userService.isAdmin(electronicBalanceEntity.getUpdateBy());
        if(electronicBalanceEntity.getId() == null) {
            electronicBalanceMapper.insert(electronicBalanceEntity);
        }else {
            electronicBalanceMapper.updateById(electronicBalanceEntity);
        }
        return electronicBalanceEntity.getId();
    }

    @Override
    public Integer deleteElectronicBalance(ElectronicBalanceEntity electronicBalanceEntity) {
        userService.isAdmin(electronicBalanceEntity.getUpdateBy());
        return electronicBalanceMapper.deleteById(electronicBalanceEntity.getId());
    }
}
