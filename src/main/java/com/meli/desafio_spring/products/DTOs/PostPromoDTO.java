package com.meli.desafio_spring.products.DTOs;

import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.models.Product;

import java.util.Date;

public class PostPromoDTO extends PostDTO{
    private boolean hasPromo;
    private double discount;

    public PostPromoDTO(int id_post, Date date, int category, double price, Product detail, boolean hasPromo, double discount) {
        super(id_post, date, category, price, detail);
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

    public static PostPromoDTO convert(Post post){
        return new PostPromoDTO(post.getPostId(), post.getDate(), post.getCategory(), post.getPrice(),
                post.getProduct(), post.isHasPromo(), post.getDiscount());
    }
}
