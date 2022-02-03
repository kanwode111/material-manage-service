package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.dto.ElectronicBalanceQuery;
import com.wang.material.api.vo.ElectronicBalanceVO;
import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.mapper.ElectronicBalanceMapper;
import com.wang.material.material.service.ElectronicBalanceService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public IPage<ElectronicBalanceVO> getElectronics(IPage<ElectronicBalanceEntity> page, ElectronicBalanceQuery query) {
        QueryWrapper<ElectronicBalanceEntity> balanceQuery = new QueryWrapper<>();
        if(query.getId() != null) {
            balanceQuery.eq("id", query.getId());
        }

        if(!StringUtils.isEmpty(query.getIp())) {
            balanceQuery.like("ip", query.getIp());
        }
        if(!StringUtils.isEmpty(query.getName())) {
            balanceQuery.like("name", query.getName());
        }
        if(query.getLevel() != null) {
            balanceQuery.eq("level", query.getLevel());
        }
        if(query.getMaxWeight() != null) {
            balanceQuery.eq("max_weight", query.getMaxWeight());
        }
        List<ElectronicBalanceVO> resultUsers = new ArrayList<>();
        //分页实体类转换
        IPage<ElectronicBalanceEntity> balances = electronicBalanceMapper.selectPage(page, balanceQuery);
        balances.getRecords().forEach(user -> {
            ElectronicBalanceVO u = new ElectronicBalanceVO();
            BeanUtils.copyProperties(user, u);
            resultUsers.add(u);
        });
        IPage<ElectronicBalanceVO> resPage = new Page<>();
        resPage.setTotal(balances.getTotal());
        resPage.setRecords(resultUsers);
        resPage.setSize(balances.getSize());
        resPage.setPages(balances.getPages());
        return resPage;
    }
}
