package com.example.assignment1.controller;


import com.example.assignment1.model.Post;
import com.example.assignment1.model.dto.response.PostDTO;
import com.example.assignment1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {


    private PostService postService;
    private ModelMapper modelMapper;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }

    @PutMapping("/")
    public void updatePost(@RequestBody Post post) {
        postService.updatePost(post);
    }

    @GetMapping("/filterByAuthor")
    public List<PostDTO> getPostsByAuthor(@RequestParam String author) {
        return postService.getPostsByAuthor(author);
    }

    @GetMapping("/filterByAuthorContaining")
    public List<PostDTO> getPostsByAuthorContaining(@RequestParam String text) {
        return postService.getPostsByAuthorContaining(text);
    }

}
