package com.example.assignment3.service.impl;

import com.example.assignment3.entity.Post;
import com.example.assignment3.repo.UserRepo;
import com.example.assignment3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assignment3.repo.PostRepo;
import com.example.assignment3.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;


    @Override
    public Comment createComment(int postId, Comment comment) {
        return postRepo.findById(postId)
                .map(post -> {
                    post.getComments().add(comment);
                    Post savedPost = postRepo.save(post);
                    return savedPost.getComments().getLast();
                })
                .orElse(null);
    }

    @Override
    public Comment getCommentByUserPostAndCommentId(int userId, int postId, int commentId) {
        return userRepo.findById(userId)
                .flatMap(user -> user.getPosts()
                        .stream()
                        .filter(post -> post.getId() == postId)
                        .findFirst()
                        .flatMap(post -> post.getComments()
                                .stream()
                                .filter(comment -> comment.getId() == commentId)
                                .findFirst()
                        ))
                .orElse(null);
    }
}
