/**
 * @(#)UserController.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import com.example.demo.util.AjaxResult;
import com.example.demo.util.ServiceUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@Api("用户相关操作")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param registerParams
     * @return
     */
    @PostMapping("/register")
    @ApiOperation("注册接口")
    public AjaxResult register(@RequestBody RegisterParams registerParams) {
        if (registerParams == null) {
            log.error("[op:register] -> 参数有误 " + JSONObject.toJSONString(registerParams));
            return new AjaxResult().error("参数有误");
        }
        int type = registerParams.getType();
        if (type == 1){
            return userService.register(registerParams);
        }
        if (type == 2) {
            // 家长需要校验年龄
            return userService.register(registerParams);
        }
        if (type == 3) {
            // 走教师认证流程
            return userService.teacherCheck(registerParams);
        }
        return new AjaxResult().error("系统错误");
    }

    /**
     * 登录接口
     *
     * @param loginParams
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("登录接口")
    public AjaxResult login(@RequestBody LoginParams loginParams) {
        if (loginParams == null) {
            log.error("[op:login] -> 参数有误 " + JSONObject.toJSONString(loginParams));
            return new AjaxResult().error("参数有误");
        }
        return userService.login(loginParams);
    }

    /**
     * 退出登录接口
     *
     * @param userName
     * @return
     */
    @GetMapping("/logout")
    public AjaxResult logout(@RequestParam("userName") String userName) {
        if (StringUtils.isEmpty(userName)) {
            log.error("[op:logout] -> 参数有误 " + userName);
            return new AjaxResult().error("参数有误");
        }
        return userService.logout(userName);
    }

    /**
     * 查看我的文章
     * @param userId
     * @return
     */
    @GetMapping("/selectText")
    @ApiOperation("查看我的文章")
    public AjaxResult selectText(@RequestParam("userId")String userId){
        return userService.selectText(userId);
    }

    /**
     * 查看我的视频
     * @param userId
     * @return
     */
    @ApiOperation("查看我的视频")
    @GetMapping("/selectVideo")
    public AjaxResult selectVideo(@RequestParam("userId")String userId){
        return userService.selectVideo(userId);
    }
}
