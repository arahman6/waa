package com.example.assignment2.service;

import com.example.assignment2.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(int id);
    Post createPost(Post post);
}
