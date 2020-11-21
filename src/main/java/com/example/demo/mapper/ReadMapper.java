/**
 * @(#)ReadMapper.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.mapper;

import com.example.demo.entity.ResourceData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface ReadMapper {

    ResourceData selectReadData(long resourceId, long userId);

    void addReadData(ResourceData resourceData);
}
