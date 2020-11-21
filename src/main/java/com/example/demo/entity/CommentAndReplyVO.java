/**
 * @(#)CommentAndReplyVO.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class CommentAndReplyVO {

    private List<Comment> commentList;
    private List<Reply> replyList;
}
