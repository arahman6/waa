package com.example.assignment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assignment2.repo.PostRepo;
import com.example.assignment2.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(int id) {
        return postRepo.findById(id)
                .orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return postRepo.save(post);
    }
}
