/**
 * @(#)CommentServiceImpl.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.service.impl;

import com.example.demo.controller.CommentParams;
import com.example.demo.controller.ReplyParams;
import com.example.demo.entity.Comment;
import com.example.demo.entity.CommentAndReplyVO;
import com.example.demo.entity.Reply;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.ReplyMapper;
import com.example.demo.service.CommentService;
import com.example.demo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public AjaxResult comment(CommentParams commentParams) {
        Comment comment = new Comment();
        comment.setCreateTime(System.currentTimeMillis());
        comment.setUpdateTime(System.currentTimeMillis());
        comment.setUserId(commentParams.getUserId());
        comment.setResourceId(commentParams.getResourceId());
        comment.setText(commentParams.getText());
        commentMapper.addComment(comment);
        return new AjaxResult().ok();
    }

    @Override
    public AjaxResult reply(ReplyParams replayParams) {
        Reply reply = new Reply();
        reply.setCommentId(replayParams.getCommentId());
        reply.setCreateTime(System.currentTimeMillis());
        reply.setResourceId(replayParams.getResourceId());
        reply.setUserId(replayParams.getUserId());
        reply.setUpdateTime(System.currentTimeMillis());
        reply.setText(replayParams.getText());
        replyMapper.addReply(reply);
        return new AjaxResult().ok();
    }

    @Override
    public AjaxResult getCommentAndReplay(String resourceId) {
        long rId = Long.parseLong(resourceId);
        List<Comment> commentList = commentMapper.selectByResourceId(rId);
        List<Reply> replyList = replyMapper.selectByResourceId(rId);
        CommentAndReplyVO commentAndReplyVO = new CommentAndReplyVO();
        commentAndReplyVO.setCommentList(commentList);
        commentAndReplyVO.setReplyList(replyList);
        return new AjaxResult().ok(commentAndReplyVO);
    }
}
