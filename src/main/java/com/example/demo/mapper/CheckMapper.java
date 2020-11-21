/**
 * @(#)CheckMapper.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.mapper;

import com.example.demo.controller.CheckParams;
import com.example.demo.entity.Check;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckMapper {


    void addCheck(Check check);

    List<Check> selectAll();

    void updateCheck(CheckParams checkParams);
}
