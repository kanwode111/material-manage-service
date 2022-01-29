package com.wang.material.material.service.impl;

import com.wang.material.material.entity.MaterialTypeEntity;
import com.wang.material.material.mapper.MaterialTypeMapper;
import com.wang.material.material.service.MaterialTypeService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 材料分类服务
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {

    @Resource
    private MaterialTypeMapper materialTypeMapper;

    @Autowired
    private UserService userService;

    @Override
    public Long createMaterialType(MaterialTypeEntity materialType) {
        userService.isAdmin(materialType.getUpdateBy());
        if(materialType.getId() != null) {
            materialTypeMapper.updateById(materialType);
        }else {
            materialTypeMapper.insert(materialType);
        }
        return materialType.getId();
    }

    @Override
    public Integer deleteMaterialType(MaterialTypeEntity materialType) {
        userService.isAdmin(materialType.getUpdateBy());
        return materialTypeMapper.deleteById(materialType.getId());
    }

}

