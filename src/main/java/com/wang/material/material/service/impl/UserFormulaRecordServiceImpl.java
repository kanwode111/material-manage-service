package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.dto.UserFormulaRecordQuery;
import com.wang.material.api.vo.UserFormulaRecordVO;
import com.wang.material.material.entity.UserFormulaRecordEntity;
import com.wang.material.material.mapper.UserFormulaRecordMapper;
import com.wang.material.material.service.UserFormulaRecordService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public IPage<UserFormulaRecordVO> getUserFormulaRecord(IPage<UserFormulaRecordEntity> page, UserFormulaRecordQuery query) {
        List<UserFormulaRecordVO> resultUsers = new ArrayList<>();
        QueryWrapper<UserFormulaRecordEntity> userQuery = new QueryWrapper<>();
        if(!StringUtils.isEmpty(query.getUsername())) {
            userQuery.like("username", query.getUsername());
        }
        if(!StringUtils.isEmpty(query.getFormulaName())) {
            userQuery.like("formula_name", query.getFormulaName());
        }
        if(!StringUtils.isEmpty(query.getMaterialCode())) {
            userQuery.like("material_code", query.getMaterialCode());
        }


        //分页实体类转换
        IPage<UserFormulaRecordEntity> users = userFormulaRecordMapper.selectPage(page, userQuery);
        users.getRecords().forEach(user -> {
            UserFormulaRecordVO u = new UserFormulaRecordVO();
            BeanUtils.copyProperties(user, u);
            resultUsers.add(u);
        });
        IPage<UserFormulaRecordVO> resPage = new Page<>();
        resPage.setTotal(users.getTotal());
        resPage.setRecords(resultUsers);
        resPage.setSize(users.getSize());
        resPage.setPages(users.getPages());
        return resPage;
    }
}
