package com.wang.material.api.controller;

import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.ElectronicBalanceCreateDTO;
import com.wang.material.api.dto.MaterialCreateDTO;
import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.entity.MaterialEntity;
import com.wang.material.material.service.ElectronicBalanceService;
import com.wang.material.material.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: 电子称管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "电子称管理", tags = "电子称管理")
@RestController
@RequestMapping("/electronicBalance/manage")
public class ElectronicBalanceController extends BaseOperationPlatformController {

    @Autowired
    private ElectronicBalanceService electronicBalanceService;

    @ApiOperation("新增/修改电子称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid ElectronicBalanceCreateDTO electronicBalance) {
        // 校验原材料是否存在
        ElectronicBalanceEntity electronic = new ElectronicBalanceEntity();
        BeanUtils.copyProperties(electronicBalance, electronic);
        if (electronicBalance.getId() == null) {
            electronic.setCreateBy(getOperator());
        }
        electronic.setUpdateBy(getOperator());
        Long id = electronicBalanceService.createElectronicBalance(electronic);
        return ResponseEntity.ok(id);
    }

    @ApiOperation("删除原材料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/delete")
    public ResponseEntity<Integer> deleteMaterial(@RequestParam @Valid Long id) {
        ElectronicBalanceEntity electronic = new ElectronicBalanceEntity();
        electronic.setId(id);
        electronic.setUpdateBy(getOperator());
        Integer result = electronicBalanceService.deleteElectronicBalance(electronic);
        // 校验原材料是否在配方中有使用，且配方为上线状态
        return ResponseEntity.ok(result);
    }
}
