/**
 * @(#)ResourceData.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

@Data
public class ResourceData {

    private long id;
    // 资源id
    private long resourceId;
    // 用户id
    private long userId;
    // 浏览数
    private long readSum;


}
