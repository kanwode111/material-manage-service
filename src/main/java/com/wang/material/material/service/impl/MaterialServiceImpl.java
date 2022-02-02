package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.FormulaDetailMapper;
import com.wang.material.material.mapper.FormulaMapper;
import com.wang.material.material.mapper.MaterialMapper;
import com.wang.material.material.service.MaterialService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Resource
    private MaterialMapper materialMapper;

    @Autowired
    private UserService userService;

    @Resource
    private FormulaDetailMapper formulaDetailMapper;

    @Override
    public Long createMaterial(MaterialEntity material) {
        userService.isAdmin(material.getUpdateBy());
        if(material.getId() != null) {
            materialMapper.updateById(material);
        }else {
            materialMapper.insert(material);
        }
        return material.getId();
    }

    @Override
    public Integer deleteMaterial(MaterialEntity material) {
        userService.isAdmin(material.getUpdateBy());
        //原材料有没有在配方中使用，如果在使用不能进行删除
        List<FormulaDetailEntity> details = formulaDetailMapper.selectList(new QueryWrapper<FormulaDetailEntity>().eq("material_id", material.getId()));
        if(CollectionUtils.isEmpty(details)) {
            return materialMapper.deleteById(material.getId());
        } else {
            throw new RuntimeException(MaterialErrorEnum.CANNOT_DELETE_USER.getErrorMessage());
        }

    }
}
