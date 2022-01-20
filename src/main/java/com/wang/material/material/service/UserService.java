package com.wang.material.material.service;

import com.wang.material.material.entity.UserEntity;

import java.util.List;

/**
 * @description: TODO
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */

public interface UserService {

    void createUser(UserEntity user);

    List<UserEntity> getAllUsers();

    void test() ;
}
