/**
 * @(#)CheckServiceImpl.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service.impl;

import com.example.demo.controller.CheckParams;
import com.example.demo.entity.Check;
import com.example.demo.mapper.CheckMapper;
import com.example.demo.service.CheckService;
import com.example.demo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public AjaxResult selectCheck() {
        try{
            List<Check> list = checkMapper.selectAll();
            return new AjaxResult().ok(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }


    @Override
    public AjaxResult updateCheck(CheckParams checkParams) {
        try {
            checkMapper.updateCheck(checkParams);
            return new AjaxResult().ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }
}
