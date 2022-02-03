package com.wang.material.material.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.material.api.dto.MaterialQuery;
import com.wang.material.api.dto.MaterialTypeQuery;
import com.wang.material.api.vo.MaterialTypeVO;
import com.wang.material.api.vo.MaterialVO;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.entity.MaterialTypeEntity;

/**
 * @description: 材料分类服务
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */

public interface MaterialTypeService {

    /**
     * 创建材料分类
     * @param materialType
     * @return
     */
    Long createMaterialType(MaterialTypeEntity materialType);

    /**
     * 删除原材料类型
     * @param materialType
     * @return
     */
    Integer deleteMaterialType(MaterialTypeEntity materialType);

    /**
     * 分页查询所有原材料
     * @param page
     * @return
     */
    IPage<MaterialTypeVO> getMaterialTypes(IPage<MaterialTypeEntity> page, MaterialTypeQuery query);

}

