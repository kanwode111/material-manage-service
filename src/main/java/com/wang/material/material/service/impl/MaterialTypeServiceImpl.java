package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.dto.MaterialTypeQuery;
import com.wang.material.api.vo.MaterialTypeVO;
import com.wang.material.api.vo.MaterialTypeVO;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.entity.MaterialTypeEntity;
import com.wang.material.material.entity.MaterialTypeEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.MaterialMapper;
import com.wang.material.material.mapper.MaterialTypeMapper;
import com.wang.material.material.service.MaterialTypeService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private MaterialMapper materialMapper;

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
        List<MaterialEntity> materialList = materialMapper.selectList(new QueryWrapper<MaterialEntity>().eq("material_type_id", materialType.getId()));
        if(CollectionUtils.isEmpty(materialList)) {
            return materialTypeMapper.deleteById(materialType.getId());
        }else {
            throw new RuntimeException(MaterialErrorEnum.CANNOT_DELETE_MATERIAL_TYPE.getErrorMessage());
        }

    }

    @Override
    public IPage<MaterialTypeVO> getMaterialTypes(IPage<MaterialTypeEntity> page, MaterialTypeQuery query) {
        List<MaterialTypeVO> resultUsers = new ArrayList<>();
        QueryWrapper<MaterialTypeEntity> userQuery = new QueryWrapper<>();
        if(!StringUtils.isEmpty(query.getMaterialTypeName())) {
            userQuery.like("material_type_name", query.getMaterialTypeName());
        }


        //分页实体类转换
        IPage<MaterialTypeEntity> users = materialTypeMapper.selectPage(page, userQuery);
        users.getRecords().forEach(user -> {
            MaterialTypeVO u = new MaterialTypeVO();
            BeanUtils.copyProperties(user, u);
            resultUsers.add(u);
        });
        IPage<MaterialTypeVO> resPage = new Page<>();
        resPage.setTotal(users.getTotal());
        resPage.setRecords(resultUsers);
        resPage.setSize(users.getSize());
        resPage.setPages(users.getPages());
        return resPage;
    }

}

