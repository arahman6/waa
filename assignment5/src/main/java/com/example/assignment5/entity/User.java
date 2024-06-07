package com.example.assignment5.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.example.assignment5.entity.Role;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    private String name;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

//    @OneToMany()
//    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> posts;
}
