/**
 * @(#)RegisterParams.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

@Data
@ApiModel("注册实体")
public class RegisterParams {

    @ApiModelProperty("真实姓名")
    private String name;

    @ApiModelProperty("登录用户名")
    private String userName;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("身份类型：幼童：type = 1，家长：type = 2，老师：type = 3")
    private int type;

    @ApiModelProperty("教师认证时传的图片")
    @Nullable
    private MultipartFile teacherImage;
}
