/**
 * @(#)CheckParams.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("审核实体")
public class CheckParams {

    @ApiModelProperty("图片上传的url")
    private String url;

    @ApiModelProperty("审核状态，1：通过，2：不通过")
    private int status;

    // 1：教师审核，2：资源审核
    @ApiModelProperty(" 1：教师审核，2：资源审核")
    private int type;

    @ApiModelProperty("教师审核时，上传教师名")
    private String userName;

}
