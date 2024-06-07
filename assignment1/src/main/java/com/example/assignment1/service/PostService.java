package com.example.assignment1.service;

import com.example.assignment1.model.Post;
import com.example.assignment1.model.dto.response.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO>  getAllPosts();
    PostDTO getPostById(long id);
    void createPost(Post post);

    void deletePost(long id);
    void updatePost(Post post);
    List<PostDTO>  getPostsByAuthor(String author);
    List<PostDTO>  getPostsByAuthorContaining(String text);
}
