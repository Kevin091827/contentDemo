/**
 * @(#)CommentParams.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("评论回复实体")
@Data
public class CommentParams {

    @ApiModelProperty("资源id，对应帖子，视频，文章")
    private long resourceId;

    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("内容")
    private String text;
}
