package com.example.assignment5.service.impl;

import com.example.assignment5.entity.Comment;
import com.example.assignment5.entity.Post;
import com.example.assignment5.repo.PostRepo;
import com.example.assignment5.repo.UserRepo;
import com.example.assignment5.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    return savedPost.getComments().get(savedPost.getComments().size() - 1);
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
