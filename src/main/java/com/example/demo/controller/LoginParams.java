/**
 * @(#)LoginParams.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录实体")
public class LoginParams {

    @ApiModelProperty("注册那会的username")
    private String userName;

    @ApiModelProperty("密码")
    private String password;
}
