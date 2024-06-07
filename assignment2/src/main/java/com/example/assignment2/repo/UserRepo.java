package com.example.assignment2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assignment2.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
