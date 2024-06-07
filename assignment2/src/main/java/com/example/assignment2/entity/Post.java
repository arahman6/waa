package com.example.assignment2.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String author;

}

