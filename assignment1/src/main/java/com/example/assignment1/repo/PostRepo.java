package com.example.assignment1.repo;

import com.example.assignment1.model.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();
    Post findById(long id);
    void save(Post post);

    void deleteById(long id);
    void update(Post post);
    List<Post> findByAuthor(String author);
    List<Post> findByAuthorContaining(String text);
}
