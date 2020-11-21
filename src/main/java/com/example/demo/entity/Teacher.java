/**
 * @(#)Teacher.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

@Data
public class Teacher extends User {

    // 是否能发资源，1：能，0：拉黑
    private int canUpdateResource;

}
