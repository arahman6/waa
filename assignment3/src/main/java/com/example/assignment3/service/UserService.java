package com.example.assignment3.service;

import com.example.assignment3.entity.Post;
import com.example.assignment3.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(User user);
    List<Post> getPostsByUserId(int id);
    Post createPost(int userId, Post post);

    List<User> findUsersWithMoreThanNPosts(int count);
    List<User> findUsersByPostTitle(String title);
}
