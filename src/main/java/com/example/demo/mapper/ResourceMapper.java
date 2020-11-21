/**
 * @(#)ResourceMapper.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.mapper;

import com.example.demo.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ResourceMapper {


    void addResource(Resource resource);

    List<Resource> selectResource(int parseInt);

    List<Resource> selectMyResource(long parseLong);

    List<Resource> deleteResource(long parseLong);
}
