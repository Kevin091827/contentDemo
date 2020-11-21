/**
 * @(#)CommentController.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.controller;

import com.example.demo.service.CommentService;
import com.example.demo.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api("评论回复模块")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 评论
     * @param commentParams
     * @return
     */
    @ApiOperation("评论")
    @PostMapping("/comment")
    public AjaxResult comment(@RequestBody CommentParams commentParams){
        try{
            return commentService.comment(commentParams);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

    /**
     * 回复
     * @param replayParams
     * @return
     */
    @ApiOperation("回复")
    @PostMapping("/reply")
    public AjaxResult reply(@RequestBody ReplyParams replayParams){
        try{
            return commentService.reply(replayParams);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

    /**
     * 获取一个资源下的所有评论回复
     * @param resourceId
     * @return
     */
    @ApiOperation("根据资源id获取该资源下的所有评论和回复")
    @GetMapping("/getCommentAndReplay")
    public AjaxResult getCommentAndReplay(@RequestParam("resourceId")String resourceId){
        try{
            return commentService.getCommentAndReplay(resourceId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult().error();
    }

}
