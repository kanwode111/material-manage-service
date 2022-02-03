package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.dto.UserQuery;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.enums.RoleEnum;
import com.wang.material.material.mapper.UserMapper;
import com.wang.material.material.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
        if (!CollectionUtils.isEmpty(users)) {
            throw new RuntimeException(MaterialErrorEnum.USERNAME_ALREADY_EXIST.getErrorMessage());
        }
        if (user.getId() != null) {
            userMapper.updateById(user);
        } else {
            userMapper.insert(user);
        }
        return user.getId();

    }

    @Override
    public IPage<UserVO> getAllUsers(IPage<UserEntity> page, UserQuery query) {
        List<UserVO> resultUsers = new ArrayList<>();
        QueryWrapper<UserEntity> userQuery = new QueryWrapper<>();
        if(!StringUtils.isEmpty(query.getUsername())) {
            userQuery.like("username", query.getUsername());
        }
        if(!StringUtils.isEmpty(query.getAddress())) {
            userQuery.like("address", query.getAddress());
        }
        if(query.getRole() != null) {
            userQuery.eq("role", query.getRole());
        }
        if(!StringUtils.isEmpty(query.getPhone())) {
            userQuery.like("phone", query.getPhone());
        }

        //分页实体类转换
        IPage<UserEntity> users = userMapper.selectPage(page, userQuery);
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
        if (dbUser.getUsername().equals(user.getUpdateBy())) {
            // 修改的用户名和数据库中查询出来的用户名一致，则为自己修改自己的密码，允许修改
            return userMapper.updateUserPassword(user);
        } else {
            this.isAdmin(user.getUpdateBy());
            return userMapper.updateUserPassword(user);
        }
    }

    @Override
    public Integer deleteUser(UserEntity user) {
        this.isAdmin(user.getUpdateBy());
        return userMapper.deleteById(user.getId());
    }

    @Override
    public void isAdmin(String username) {
        QueryWrapper query = new QueryWrapper();
        query.eq("username", username);
        UserEntity dbUser = userMapper.selectOne(query);
        if (!dbUser.getRole().equals(RoleEnum.ADMIN)) {
            throw new RuntimeException(MaterialErrorEnum.CANNOT_DELETE_USER.getErrorMessage());
        }
    }


}
