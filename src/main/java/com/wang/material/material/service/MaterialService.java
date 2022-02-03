package com.wang.material.material.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.material.api.dto.MaterialQuery;
import com.wang.material.api.dto.UserQuery;
import com.wang.material.api.vo.MaterialVO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.entity.UserEntity;

/**
 * @description: 材料服务
 * @author
 * @date 2022/1/17 11:01
 * @version 1.0
 */
public interface MaterialService {

    /**
     * 创建材料分类
     * @param material
     * @return
     */
    Long createMaterial(MaterialEntity material);

    /**
     * 删除原材料类型
     * @param material
     * @return
     */
    Integer deleteMaterial(MaterialEntity material);

    /**
     * 分页查询所有原材料
     * @param page
     * @return
     */
    IPage<MaterialVO> getMaterials(IPage<MaterialEntity> page, MaterialQuery query);


}

