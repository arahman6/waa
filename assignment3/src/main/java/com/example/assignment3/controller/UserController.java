package com.example.assignment3.controller;

import com.example.assignment3.entity.Post;
import com.example.assignment3.entity.User;
import com.example.assignment3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable int id) {
        return userService.getPostsByUserId(id);
    }

    @GetMapping("/with-more-than/{n}-posts")
    public List<User> findUsersWithMoreThanNPosts(@PathVariable int n) {
        return userService.findUsersWithMoreThanNPosts(n);
    }

    @PostMapping("/{id}/posts")
    public Post createPost(@PathVariable int id, @RequestBody Post post) {
        return userService.createPost(id, post);
    }



}


