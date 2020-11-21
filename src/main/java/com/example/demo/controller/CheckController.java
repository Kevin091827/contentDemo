/**
 * @(#)CheckController.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import com.example.demo.service.CheckService;
import com.example.demo.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/check")
@RestController
@Api(value = "审核类接口")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @ApiOperation(value = "查询所有审核")
    @GetMapping("/select")
    public AjaxResult selectCheck(){
        return checkService.selectCheck();
    }

    @ApiOperation(value = "更新审核状态")
    @PostMapping("/updateCheck")
    public AjaxResult updateCheck(@RequestBody CheckParams checkParams){
        return checkService.updateCheck(checkParams);
    }

}
