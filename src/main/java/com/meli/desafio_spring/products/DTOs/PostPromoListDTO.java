package com.meli.desafio_spring.products.DTOs;

import java.util.List;

public class PostPromoListDTO {
    private int userId;
    private String userName;
    private List<PostPromoDTO> posts;

    public PostPromoListDTO(int userId, String userName, List<PostPromoDTO> posts) {
        this.userId = userId;
        this.posts = posts;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostPromoDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostPromoDTO> posts) {
        this.posts = posts;
    }
}
