/**
 * @(#)UserMapper.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    @Insert("insert ignore into tb_user(type,name,password,loginName,createTime,grade,updateTime) " +
            "values(#{user.type} ,#{user.name} ," +
            "#{user.password} ,#{user.loginName} ," +
            "#{user.createTime} ,#{user.grade} ,#{user.updateTime} )")
    void addUser(@Param("user") User user);

    @Select("select * from tb_user where loginName=#{userName} and password = #{pwd}  ")
    User selectUser(@Param("pwd") String password,
                    @Param("userName") String userName);
}
