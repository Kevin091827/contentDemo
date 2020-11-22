/**
 * @(#)ResourceService.java, 2020/11/19.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service;

import com.example.demo.util.AjaxResult;

import java.io.FileInputStream;
import java.io.InputStream;

public interface ResourceService {


    AjaxResult uploadResource(InputStream fileInputStream,
                              String type,
                              String title,
                              String text,
                              String resourceType,
                              String userId);

    AjaxResult selectReource(String type);

    AjaxResult selectMyResource(String userId);

    AjaxResult deleteResource(String userId);
}
