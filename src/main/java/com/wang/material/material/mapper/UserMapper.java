package com.wang.material.material.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.material.material.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    Integer updateUserPassword(@Param("user") UserEntity user);

}
