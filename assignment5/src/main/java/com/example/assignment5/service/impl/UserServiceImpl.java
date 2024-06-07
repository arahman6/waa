package com.example.assignment5.service.impl;


import com.example.assignment5.entity.Post;
import com.example.assignment5.entity.User;
import com.example.assignment5.repo.UserRepo;
import com.example.assignment5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id)
                .orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<Post> getPostsByUserId(int id) {
        return userRepo.findById(id)
                .map(User::getPosts)
                .orElse(null);
    }

    @Override
    public Post createPost(int userId, Post post) {
        return userRepo.findById(userId)
                .map(user -> {
                    user.getPosts().add(post);
                    User updatedUser = userRepo.save(user);
                    return updatedUser.getPosts().get(updatedUser.getPosts().size() - 1);
                })
                .orElse(null);
    }

    @Override
    public List<User> findUsersWithMoreThanNPosts(int n) {
        return userRepo.findUsersWithMoreThanNPosts(n);
    }

    @Override
    public List<User> findUsersByPostTitle(String title) {
        return userRepo.findUsersByPostTitle(title);
    }
}
