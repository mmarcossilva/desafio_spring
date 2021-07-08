package com.meli.desafio_spring.products.DTOs;

import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.models.Product;

import java.util.Date;

public class PostDTO {
    private int id_post;
    private Date date;
    private int category;
    private double price;
    private Product detail;

    public PostDTO(int id_post, Date date, int category, double price, Product detail) {
        this.id_post = id_post;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
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

    public static PostDTO convert(Post post){
        return new PostDTO(post.getPostId(), post.getDate(),
                post.getCategory(), post.getPrice(), post.getProduct());
    }
}
