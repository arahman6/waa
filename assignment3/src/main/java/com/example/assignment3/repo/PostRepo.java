package com.example.assignment3.repo;

import com.example.assignment3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findPostsByTitleContaining(String title);
}
