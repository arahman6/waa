package com.example.assignment3.controller;

import com.example.assignment3.entity.Post;
import com.example.assignment3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

//    @PostMapping("/")
//    public Post createPost(@RequestBody Post post) {
//        return postService.createPost(post);
//    }
}
