package com.example.assignment5.service;

import com.example.assignment5.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(int id);
//    Post createPost(Post post);
}
