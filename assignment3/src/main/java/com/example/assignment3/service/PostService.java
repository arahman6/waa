package com.example.assignment3.service;

import com.example.assignment3.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(int id);
//    Post createPost(Post post);
}
