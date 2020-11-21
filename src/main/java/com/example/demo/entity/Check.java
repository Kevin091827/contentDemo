/**
 * @(#)Check.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

@Data
public class Check {

    private long id;
    private long userId;
    private String url;
    private int status;
    private int type;
    private String userName;
    private long createTime;
    private long updateTime;
}
