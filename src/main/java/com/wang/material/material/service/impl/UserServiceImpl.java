package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.UserMapper;
import com.wang.material.material.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Long createUser(UserEntity user) {
        //1. 校验用户名是否有重复
        List<UserEntity> users = userMapper.selectList(new QueryWrapper<UserEntity>().eq("username", user.getUsername()));
        if(!CollectionUtils.isEmpty(users)) {
            throw new RuntimeException(MaterialErrorEnum.USERNAME_ALREADY_EXIST.getErrorMessage());
        }
        userMapper.insert(user);
        return user.getId();

    }

    @Override
    public IPage<UserVO> getAllUsers(IPage<UserEntity> page) {
        List<UserVO> resultUsers = new ArrayList<>();
        //分页实体类转换
        IPage<UserEntity> users = userMapper.selectPage(page, new QueryWrapper<UserEntity>());
        users.getRecords().forEach(user -> {
            UserVO u = new UserVO();
            BeanUtils.copyProperties(user, u);
            resultUsers.add(u);
        });
        IPage<UserVO> resPage = new Page<>();
        resPage.setTotal(users.getTotal());
        resPage.setRecords(resultUsers);
        resPage.setSize(users.getSize());
        resPage.setPages(users.getPages());
        return resPage;
    }

    @Override
    public Integer updatePassword(UserEntity user) {
        UserEntity dbUser = userMapper.selectById(user.getId());

        return null;
    }

}
