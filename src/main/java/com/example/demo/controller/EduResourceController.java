/**
 * @(#)EduResourceController.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import com.example.demo.service.ResourceService;
import com.example.demo.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/edu/resource")
@RestController
@Api("资源模块")
public class EduResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 以流的形式上传视频/文章
     * @param file
     * @param text
     * @param type
     * @param resourceType
     * @param title
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("以流的形式上传视频/文章")
    public AjaxResult uploadFile(
            @ApiParam("图片和视频时要传，文章不用传") @RequestParam("file") @Nullable MultipartFile file,
            @ApiParam("文章要传，图片和视频不用传") @RequestParam("text")@Nullable String text,
            @ApiParam("1：视频。2：文章")@RequestParam("type") String type,
            @ApiParam("资源类型，1：育儿，2：传统，3：艺术")@RequestParam("resourceType")String resourceType,
            @ApiParam("标题")@RequestParam("title")String title,
            @ApiParam("用户id")@RequestParam("userId")String userId) {
        try {
            return resourceService.uploadResource(file.getInputStream(),type,title,text,resourceType,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult().error("资源上传失败");
    }

    /**
     * 根据类别返回通过审核的资源
     * @param type
     * @return
     */
    @GetMapping("/selectByType")
    @ApiOperation("根据类别返回通过审核的资源")
    public AjaxResult selectResource(@ApiParam("资源类型，1：育儿，2：传统，3：艺术") @RequestParam("type") String type){
        try{
            return resourceService.selectReource(type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

    /**
     * 查看我的资源
     * @param userId
     * @return
     */
    @ApiOperation("查看我的资源")
    @GetMapping("/selectMyResource")
    public AjaxResult selectMyResource(@ApiParam("用户id")@RequestParam("userId") String userId){
        try{
            return resourceService.selectMyResource(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }


    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    @ApiOperation("删除资源")
    @PostMapping("/deleteResource")
    public AjaxResult deleteResource(@ApiParam("资源id")@RequestParam("resourceId")String resourceId,
                                     @ApiParam("用户id")@RequestParam("userId")String userId){
        try{
            return resourceService.deleteResource(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }



}
