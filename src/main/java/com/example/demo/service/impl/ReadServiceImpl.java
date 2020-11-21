/**
 * @(#)ReadServiceImpl.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service.impl;

import com.example.demo.controller.ReadSumParams;
import com.example.demo.entity.ResourceData;
import com.example.demo.mapper.ReadMapper;
import com.example.demo.service.ReadService;
import com.example.demo.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReadServiceImpl implements ReadService {

    @Autowired
    private ReadMapper readMapper;

    @Override
    public synchronized AjaxResult addReadSum(ReadSumParams readSumParams) {
        try {
            ResourceData resourceData = readMapper.selectReadData(readSumParams.getResourceId(), readSumParams.getUserId());
            long oldSum = resourceData.getReadSum();
            resourceData.setReadSum(oldSum+1);
            readMapper.addReadData(resourceData);
            return new AjaxResult().ok(resourceData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

    @Override
    public AjaxResult selectReadData(String resourceId, String userId) {
        try {
            ResourceData resourceData = readMapper.selectReadData(Long.parseLong(resourceId),Long.parseLong(userId));
            return new AjaxResult().ok(resourceData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }


}
