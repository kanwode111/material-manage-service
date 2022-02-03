package com.wang.material.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.dto.MaterialQuery;
import com.wang.material.api.vo.MaterialVO;
import com.wang.material.api.vo.MaterialVO;
import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.enums.MaterialErrorEnum;
import com.wang.material.material.mapper.FormulaDetailMapper;
import com.wang.material.material.mapper.FormulaMapper;
import com.wang.material.material.mapper.MaterialMapper;
import com.wang.material.material.service.MaterialService;
import com.wang.material.material.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public IPage<MaterialVO> getMaterials(IPage<MaterialEntity> page, MaterialQuery query) {
        List<MaterialVO> resultUsers = new ArrayList<>();
        QueryWrapper<MaterialEntity> userQuery = new QueryWrapper<>();
        if(!StringUtils.isEmpty(query.getMaterialCode())) {
            userQuery.like("material_code", query.getMaterialCode());
        }
        if(!StringUtils.isEmpty(query.getMaterialName())) {
            userQuery.like("material_name", query.getMaterialName());
        }
        if(!StringUtils.isEmpty(query.getMaterialTypeName())) {
            userQuery.like("material_type_name", query.getMaterialTypeName());
        }

        //分页实体类转换
        IPage<MaterialEntity> users = materialMapper.selectPage(page, userQuery);
        users.getRecords().forEach(user -> {
            MaterialVO u = new MaterialVO();
            BeanUtils.copyProperties(user, u);
            resultUsers.add(u);
        });
        IPage<MaterialVO> resPage = new Page<>();
        resPage.setTotal(users.getTotal());
        resPage.setRecords(resultUsers);
        resPage.setSize(users.getSize());
        resPage.setPages(users.getPages());
        return resPage;
    }
}
