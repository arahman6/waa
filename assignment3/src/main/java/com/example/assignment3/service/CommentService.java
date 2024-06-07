package com.example.assignment3.service;

import com.example.assignment3.entity.Comment;

public interface CommentService {
    Comment createComment(int postId, Comment comment);
    Comment getCommentByUserPostAndCommentId(int userId, int postId, int commentId);
}
