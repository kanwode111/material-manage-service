package com.wang.material.api.controller;

import com.wang.material.api.common.BaseOperationPlatformController;
import com.wang.material.api.dto.ElectronicBalanceCreateDTO;
import com.wang.material.api.dto.UserFormulaRecordCreateDTO;
import com.wang.material.material.entity.ElectronicBalanceEntity;
import com.wang.material.material.entity.UserFormulaRecordEntity;
import com.wang.material.material.service.UserFormulaRecordService;
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
 * @description: 用户配方记录管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "用户配料记录管理", tags = "用户配料记录管理")
@RestController
@RequestMapping("/userFormulaRecord/manage")
public class UserFormulaRecordController extends BaseOperationPlatformController {

    @Autowired
    private UserFormulaRecordService userFormulaRecordService;

    @ApiOperation("新增用户配料记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operator", value = "操作人", paramType = "header", required = true),
    })
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid UserFormulaRecordCreateDTO userFormulaRecord) {
        // 校验原材料是否存在
        UserFormulaRecordEntity record = new UserFormulaRecordEntity();
        BeanUtils.copyProperties(userFormulaRecord, record);
        record.setUpdateBy(getOperator());
        Long id = userFormulaRecordService.createUserFormulaRecord(record);
        return ResponseEntity.ok(id);
    }


}
