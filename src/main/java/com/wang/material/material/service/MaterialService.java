package com.wang.material.material.service;

import com.wang.material.material.entity.MaterialEntity;

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


}

