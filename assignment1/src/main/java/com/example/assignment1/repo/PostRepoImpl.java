package com.example.assignment1.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.assignment1.model.Post;

import org.springframework.stereotype.Repository;


@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts = new ArrayList<>();
    private static long idCounter = 1;

    static {
        Post p1 = new Post();
        p1.setId(idCounter++);
        p1.setTitle("First Post");
        p1.setContent("This is the content of the first post.");
        p1.setAuthor("John Doe");

        Post p2 = new Post();
        p2.setId(idCounter++);
        p2.setTitle("Second Post");
        p2.setContent("This is the content of the second post.");
        p2.setAuthor("Jane Smith");

        posts.add(p1);
        posts.add(p2);
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findById(long id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(idCounter++);
        posts.add(post);
    }



    @Override
    public void deleteById(long id) {
        if(findById(id) != null){
            posts.remove(findById(id));
        }
    }

    @Override
    public void update(Post post) {
        deleteById(post.getId());
        posts.add(post);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.stream()
                .filter(post -> post.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findByAuthorContaining(String text) {
        return posts.stream()
                .filter(post -> post.getAuthor().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

}
