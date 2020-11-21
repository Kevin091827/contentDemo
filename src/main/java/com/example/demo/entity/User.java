/**
 * @(#)User.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

@Data
public class User {

    private long id;
    // 幼童：type = 1，家长：type = 2，老师：type = 3
    private int type;
    private String name;
    private String password;
    private String loginName;
    private long createTime;
    private long updateTime;
    // 等级
    private int grade;
}
