/**
 * @(#)ReadController.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import com.example.demo.service.ReadService;
import com.example.demo.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/read")
@Api("浏览数相关接口")
public class ReadController {

    @Autowired
    private ReadService readService;

    /**
     * 增加阅读数
     * @param readSumParams
     * @return
     */
    @ApiOperation("增加阅读数")
    @PostMapping("/addReadSum")
    public AjaxResult addReadSum(@RequestBody ReadSumParams readSumParams){
        return readService.addReadSum(readSumParams);
    }

    /**
     * 查询阅读数据
     * @param resourceId
     * @param userId
     * @return
     */
    @GetMapping("/selectReadData")
    public AjaxResult selectReadData(@RequestParam("resourceId")String resourceId,
                                     @RequestParam("userId")String userId){
        return readService.selectReadData(resourceId,userId);
    }
}
