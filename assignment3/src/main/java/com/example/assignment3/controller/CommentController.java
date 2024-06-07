package com.example.assignment3.controller;

import com.example.assignment3.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignment3.service.CommentService;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public Comment createComment(@PathVariable int postId, @RequestBody Comment comment) {
        return commentService.createComment(postId, comment);
    }

    @GetMapping("/user/{userId}/post/{postId}/comment/{commentId}")
    public Comment getCommentByUserPostAndCommentId(@PathVariable int userId, @PathVariable int postId, @PathVariable int commentId) {
        return commentService.getCommentByUserPostAndCommentId(userId, postId, commentId);
    }
}
