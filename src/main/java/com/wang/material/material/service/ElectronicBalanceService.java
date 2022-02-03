package com.wang.material.material.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wang.material.api.dto.ElectronicBalanceQuery;
import com.wang.material.api.vo.ElectronicBalanceVO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.entity.UserEntity;

public interface ElectronicBalanceService {
    /**
     * 添加配方
     * @param electronicBalanceEntity
     * @return
     */
    Long createElectronicBalance(ElectronicBalanceEntity electronicBalanceEntity);


    /**
     * 删除配方
     * @param electronicBalanceEntity
     * @return
     */
    Integer deleteElectronicBalance(ElectronicBalanceEntity electronicBalanceEntity);

    /**
     * 分页查询电子称
     * @param page
     * @return
     */
    IPage<ElectronicBalanceVO> getElectronics(IPage<ElectronicBalanceEntity> page, ElectronicBalanceQuery query);

}
