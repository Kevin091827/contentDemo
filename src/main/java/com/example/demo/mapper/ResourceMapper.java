/**
 * @(#)ResourceMapper.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.mapper;

import com.example.demo.entity.Resource;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ResourceMapper {

    @Insert("insert into tb_resource(resourceType,type,content,title,userId,statue,imgUrl,createTime,updateTime)" +
            " values(" +
            "#{resource.resourceType}," +
            "#{resource.type} ," +
            "#{resource.content} ," +
            "#{resource.title} ," +
            "#{resource.userId} ," +
            "#{resource.statue} ," +
            "#{resource.imgUrl} ," +
            "#{resource.createTime} ," +
            "#{resource.updateTime} )")
    void addResource(@Param("resource") Resource resource);

    @Select("select * from tb_resource where type = #{type} ")
    List<Resource> selectResource(int type);

    @Select("select * from tb_resource where userId = #{userId}")
    List<Resource> selectMyResource(long userId);

    @Delete("delete from tb_resource where userId = #{userId} ")
    List<Resource> deleteResource(long userId);
}
