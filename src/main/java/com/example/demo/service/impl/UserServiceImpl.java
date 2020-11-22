/**
 * @(#)UserServiceImpl.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service.impl;

import com.example.demo.controller.LoginParams;
import com.example.demo.controller.RegisterParams;
import com.example.demo.entity.Check;
import com.example.demo.entity.Resource;
import com.example.demo.entity.User;
import com.example.demo.mapper.CheckMapper;
import com.example.demo.mapper.ResourceMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.QiniuService;
import com.example.demo.service.UserService;
import com.example.demo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CheckMapper checkMapper;

    @Autowired
    private QiniuService qiniuService;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public AjaxResult register(RegisterParams registerParams) {
        try {
            User user = new User();
            user.setCreateTime(System.currentTimeMillis());
            user.setGrade(1);
            user.setType(registerParams.getType());
            user.setLoginName(registerParams.getUserName());
            user.setPassword(registerParams.getPassword());
            user.setName(registerParams.getName());
            user.setUpdateTime(System.currentTimeMillis());
            userMapper.addUser(user);
            return new AjaxResult().ok("注册成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

    @Override
    public AjaxResult teacherCheck(RegisterParams registerParams) {
        try {
            String url = qiniuService.uploadFile(registerParams.getTeacherImage().getInputStream());
            Check check = new Check();
            check.setCreateTime(System.currentTimeMillis());
            check.setUpdateTime(System.currentTimeMillis());
            check.setStatus(0);
            check.setUrl(url);
            check.setType(0);
            check.setUserName(registerParams.getUserName());
            //checkMapper.addCheck(check);
            return new AjaxResult().ok("提交成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

    @Override
    public AjaxResult login(LoginParams loginParams) {
        User user = userMapper.selectUser(loginParams.getPassword(),loginParams.getUserName());
        if(user != null){
            return new AjaxResult().ok(user);
        }else{
            return new AjaxResult().error("登录失败");
        }
    }

    @Override
    public AjaxResult logout(String userName) {
        return null;
    }

    @Override
    public AjaxResult selectText(String userId) {
        List<Resource> res = new ArrayList<>();
        List<Resource> list = resourceMapper.selectMyResource(Long.parseLong(userId));
        for(Resource s : list){
            if(s.getType() != 2){
                continue;
            }
            res.add(s);
        }
        return new AjaxResult().ok(res);
    }

    @Override
    public AjaxResult selectVideo(String userId) {
        List<Resource> res = new ArrayList<>();
        List<Resource> list = resourceMapper.selectMyResource(Long.parseLong(userId));
        for(Resource s : list){
            if(s.getType() != 1){
                continue;
            }
            res.add(s);
        }
        return new AjaxResult().ok(res);
    }
}
