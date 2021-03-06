package com.wang.material.material.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.material.api.dto.UserQuery;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.UserEntity;

import java.util.List;

/**
 * @description: TODO
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */

public interface UserService {

    /**
     * 创建用户
     * @param user
     * @return
     */
    Long createUser(UserEntity user);

    /**
     * 分页查询所有用户
     * @param page
     * @return
     */
    IPage<UserVO> getAllUsers(IPage<UserEntity> page, UserQuery query);

    /**
     * 修改用户密码，需要校验用户权限
     * @param user
     * @return
     */
    Integer updatePassword(UserEntity user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    Integer deleteUser(UserEntity user);

    /**
     * 校验用户是否为管理员，如果为非管理员抛出异常
     * @param username
     * @return
     */
    void isAdmin(String username);

}

