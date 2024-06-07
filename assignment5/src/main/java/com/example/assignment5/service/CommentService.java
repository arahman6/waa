package com.example.assignment5.service;

import com.example.assignment5.entity.Comment;

public interface CommentService {
    Comment createComment(int postId, Comment comment);
    Comment getCommentByUserPostAndCommentId(int userId, int postId, int commentId);
}
