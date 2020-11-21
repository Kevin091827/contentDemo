/**
 * @(#)ReplyParams.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("回复实体")
public class ReplyParams {

    @ApiModelProperty("资源ID")
    private long resourceId;

    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("父评论id")
    private long commentId;

    @ApiModelProperty("内容")
    private String text;
}
