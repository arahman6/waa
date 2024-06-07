package com.example.assignment3.repo;

import com.example.assignment3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > ?1")
    List<User> findUsersWithMoreThanNPosts(int n);


    @Query("SELECT DISTINCT u FROM User u JOIN u.posts p WHERE p.title LIKE %?1%")
    List<User> findUsersByPostTitle(String title);
}
