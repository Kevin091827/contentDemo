/**
 * @(#)ReadMapper.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.mapper;

import com.example.demo.entity.ResourceData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface ReadMapper {

    @Select("select * from tb_resource_data where resourceId = #{resourceId} " +
            "and userId = #{userId} ")
    ResourceData selectReadData(@Param("resourceId") long resourceId,
                                @Param("userId") long userId);

    @Insert("insert into tb_resource_data(resourceId,userId,readSum) " +
            "values(#{data.resourceId},#{data.userId} ,#{data.readSum} )")
    void addReadData(@Param("data") ResourceData resourceData);
}
