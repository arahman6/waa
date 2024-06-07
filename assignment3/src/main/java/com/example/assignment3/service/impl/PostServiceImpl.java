package com.example.assignment3.service.impl;

import com.example.assignment3.entity.Post;
import com.example.assignment3.repo.PostRepo;
import com.example.assignment3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
