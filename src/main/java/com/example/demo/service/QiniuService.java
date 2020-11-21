/**
 * @(#)QiniuService.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

public interface QiniuService {

    String uploadFile(File file) throws QiniuException;

    String uploadFile(InputStream inputStream) throws QiniuException;

    Response delete(String key) throws QiniuException;
}
