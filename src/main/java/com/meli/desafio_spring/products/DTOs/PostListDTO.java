package com.meli.desafio_spring.products.DTOs;

import java.util.List;

public class PostListDTO {
    private int userId;
    private List<PostDTO> posts;

    public PostListDTO(int userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
