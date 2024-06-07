package com.example.assignment2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assignment2.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
