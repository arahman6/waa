package com.example.assignment1.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment1.repo.PostRepo;
import com.example.assignment1.model.Post;
import com.example.assignment1.model.dto.response.PostDTO;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

//    @Autowired
//    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
//        this.postRepo = postRepo;
//        this.modelMapper = modelMapper;
//    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepo.findAll().stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepo.findById(id);
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public void createPost(Post post) {
        postRepo.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePost(Post post) {
        post.setId(post.getId());
        postRepo.update(post);
    }

    @Override
    public List<PostDTO> getPostsByAuthor(String author) {
        return postRepo.findByAuthor(author)
                .stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostsByAuthorContaining(String text) {
        return postRepo.findByAuthorContaining(text)
                .stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }
}
