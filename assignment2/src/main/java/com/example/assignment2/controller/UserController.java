package com.example.assignment2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignment2.service.UserService;
import com.example.assignment2.entity.User;
import com.example.assignment2.entity.Post;

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

    @PostMapping("/{id}/posts")
    public Post createPost(@PathVariable int id, @RequestBody Post post) {
        return userService.createPost(id, post);
    }
}


