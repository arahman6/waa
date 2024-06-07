package com.example.assignment3.repo;

import com.example.assignment3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assignment3.entity.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}

