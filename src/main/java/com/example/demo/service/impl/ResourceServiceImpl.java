/**
 * @(#)ResourceServiceImpl.java, 2020/11/19.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service.impl;

import com.example.demo.entity.Check;
import com.example.demo.entity.Resource;
import com.example.demo.mapper.CheckMapper;
import com.example.demo.mapper.ResourceMapper;
import com.example.demo.service.QiniuService;
import com.example.demo.service.ResourceService;
import com.example.demo.util.AjaxResult;
import com.qiniu.common.QiniuException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private QiniuService qiniuService;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public AjaxResult uploadResource(InputStream fileInputStream,
                                     String type,
                                     String author,
                                     String title,
                                     String text,
                                     String resourceType,
                                     String userId) {
        try {
            String url = qiniuService.uploadFile(fileInputStream);
            Resource resource = new Resource();
            resource.setAuthor(author);
            if (type == "1") {
                resource.setImgUrl("");
                resource.setContent(url);
            } else if (type == "2") {
                resource.setImgUrl(url);
                resource.setContent(text);
            }
            resource.setTitle(title);
            resource.setResourceType(Integer.parseInt(resourceType));
            resource.setType(Integer.parseInt(type));
            resource.setCreateTime(System.currentTimeMillis());
            resource.setUpdateTime(System.currentTimeMillis());
            resource.setStatue(1);
            resourceMapper.addResource(resource);
            Check check = new Check();
            check.setUrl(url);
            check.setType(2);
            check.setUpdateTime(System.currentTimeMillis());
            check.setCreateTime(System.currentTimeMillis());
            check.setStatus(0);
            check.setUserId(Long.parseLong(userId));
            checkMapper.addCheck(check);
            return new AjaxResult().ok(resource);
        } catch (QiniuException e) {
            e.printStackTrace();
            log.error("[op:ResourceServiceImpl#uploadResource]" + e.getMessage());
        }
        return new AjaxResult().error("资源上传失败");
    }

    @Override
    public AjaxResult selectReource(String type) {
        List<Resource> list = resourceMapper.selectResource(Integer.parseInt(type));
        return new AjaxResult().ok(list);
    }

    @Override
    public AjaxResult selectMyResource(String userId) {
        List<Resource> list = resourceMapper.selectMyResource(Long.parseLong(userId));
        return new AjaxResult().ok(list);
    }

    @Override
    public AjaxResult deleteResource(String userId) {
        try {
            List<Resource> list = resourceMapper.deleteResource(Long.parseLong(userId));
            return new AjaxResult().ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }
}
