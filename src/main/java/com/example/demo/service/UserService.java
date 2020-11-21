/**
 * @(#)UserService.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service;

import com.example.demo.controller.LoginParams;
import com.example.demo.controller.RegisterParams;
import com.example.demo.util.AjaxResult;

public interface UserService {

    AjaxResult register(RegisterParams registerParams);

    AjaxResult teacherCheck(RegisterParams registerParams);

    AjaxResult login(LoginParams loginParams);

    AjaxResult logout(String userName);

    AjaxResult selectText(String userId);

    AjaxResult selectVideo(String userId);
}
