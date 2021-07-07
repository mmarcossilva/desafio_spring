package com.meli.desafio_spring.products.repository;

import commons.interfaceDB.DatabaseMethods;
import com.meli.desafio_spring.products.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements DatabaseMethods<Post> {
    private List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public Post findById(int id) {
        return posts.stream().filter(post -> post.getPostId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Post item) {
        List<Post> posts = this.posts.stream()
                .filter(post -> post.getPostId() != item.getPostId())
                .collect(Collectors.toList());
        posts.add(item);
        this.posts = posts;
    }

    public List<Post> findByListSeller(List<Integer> followedId) {
        return posts.stream().filter(post -> followedId.contains(post.getUserId())).collect(Collectors.toList());
    }
}