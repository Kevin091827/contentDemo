/**
 * @(#)ReadService.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service;

import com.example.demo.controller.ReadSumParams;
import com.example.demo.util.AjaxResult;

public interface ReadService {
    
    AjaxResult addReadSum(ReadSumParams readSumParams);

    AjaxResult selectReadData(String resourceId, String userId);
}
