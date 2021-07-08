package com.meli.desafio_spring.products.models;

import java.util.Date;

public class Post {
    private int userId;
    private int postId;
    private Date date;
    private int category;
    private double price;
    private Product product;
    private boolean hasPromo;
    private double discount;

    public Post(int userId, int postId, Date date, int category, double price, Product product) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.product = product;
        this.hasPromo = false;
    }

    public Post(int userId, int postId, Date date, int category, double price, Product product,
                boolean hasPromo, double discount) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.product = product;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
