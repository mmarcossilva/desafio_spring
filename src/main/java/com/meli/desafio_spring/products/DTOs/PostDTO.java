package com.meli.desafio_spring.products.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.models.Product;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostDTO {
    @NotNull
    private int userId;
    @NotNull
    private int id_post;
    @NotNull
    @JsonSerialize(as = Date.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            lenient = OptBoolean.FALSE, locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date date;
    private int category;
    private double price;
    @NotNull
    private Product detail;

    public PostDTO() {
    }

    public PostDTO(int userId, int postId, Date date, int category, double price, Product detail) {
        this.userId = userId;
        this.id_post = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public static Post convert(PostDTO post){
        return new Post(post.getUserId(), post.getId_post(), post.getDate(),
                    post.getCategory(), post.getPrice(), post.getDetail());
    }
}
