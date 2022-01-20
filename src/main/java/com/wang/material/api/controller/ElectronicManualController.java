package com.wang.material.api.controller;


import com.wang.material.api.vo.ElectronicManualVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description: 电子手册管理
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Api(value = "电子手册管理", tags = "电子手册管理")
@RestController
@RequestMapping("/electronicManual/manage")
public class ElectronicManualController
{

    @ApiOperation("获取电子手册列表(运营使用)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "language", value = "语言码", paramType = "header", required = true)
    })
    @PostMapping("/getElectronicManualList")
    public ElectronicManualVO getElectronicManualList(@RequestBody @Valid String query) {
        return null;
    }




}
