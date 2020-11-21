/**
 * @(#)ReadSumParams.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("浏览数请求模型")
public class ReadSumParams {

    @ApiModelProperty("资源id，帖子，文章，视频")
    private long resourceId;

    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("之前的浏览量，我这边加锁后加1")
    private long sum;
}
