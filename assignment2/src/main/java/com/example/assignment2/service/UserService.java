package com.example.assignment2.service;

import com.example.assignment2.entity.Post;
import com.example.assignment2.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(User user);
    List<Post> getPostsByUserId(int id);
    Post createPost(int userId, Post post);
}
