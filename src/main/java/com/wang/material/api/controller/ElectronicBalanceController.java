package com.wang.material.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.ElectronicBalanceCreateDTO;
import com.wang.material.api.dto.ElectronicBalanceQuery;
import com.wang.material.api.dto.PageQuery;
import com.wang.material.api.vo.ElectronicBalanceVO;
import com.wang.material.api.vo.UserVO;
import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.entity.UserEntity;
import com.wang.material.material.service.ElectronicBalanceService;
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

    @ApiOperation("查询电子称")
    @PostMapping("/getElectronics")
    public ResponseEntity<IPage<ElectronicBalanceVO>> getAllUser(@RequestBody ElectronicBalanceQuery query) {
        Page<ElectronicBalanceEntity> page = new Page<>(query.getPageNumber(), query.getPageSize());
        ElectronicBalanceEntity balance = new ElectronicBalanceEntity();
        IPage<ElectronicBalanceVO> iPage = electronicBalanceService.getElectronics(page, query);

        return ResponseEntity.ok(iPage);
    }

}
