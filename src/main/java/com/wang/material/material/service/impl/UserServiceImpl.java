package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.mapper.UserMapper;
import com.wang.material.material.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void createUser(UserEntity user) {
        userMapper.insert(user);

    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userMapper.selectList(new QueryWrapper<>());
        return users;
    }

    @Override
    public void test() {
        log.info("hello");
    }
}
