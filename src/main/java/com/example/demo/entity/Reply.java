/**
 * @(#)Reply.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

@Data
public class Reply {

    private long id;
    private long resourceId;
    private long userId;
    private long commentId;
    private String text;
    private long createTime;
    private long updateTime;
}
