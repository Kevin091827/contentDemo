/**
 * @(#)Resource.java, 2020/11/19.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

@Data
public class Resource {

    private int id;
    // 资源类型，1：育儿，2：传统，3：艺术
    private int resourceType;
    // 1：视频。2：文章
    private int type;
    // 内容
    private String content;
    // title
    private String title;
    // 作者
    private long userId;
    // 审核状态，1：审核，2：启用，3：禁用
    private int statue;
    // 缩图
    private String imgUrl;

    private long createTime;
    private long updateTime;
}
