/**
 * @(#)CommentService.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service;

import com.example.demo.controller.CommentParams;
import com.example.demo.controller.ReplyParams;
import com.example.demo.util.AjaxResult;

public interface CommentService {

    AjaxResult comment(CommentParams commentParams);

    AjaxResult reply(ReplyParams replayParams);

    AjaxResult getCommentAndReplay(String resourceId);
}
