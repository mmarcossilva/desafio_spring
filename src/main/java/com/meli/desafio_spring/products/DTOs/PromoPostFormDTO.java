package com.meli.desafio_spring.products.DTOs;

import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.models.Product;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PromoPostFormDTO extends  PostFormDTO{
    @NotNull
    private double discount;
    @NotNull
    private boolean hasPromo;

    public PromoPostFormDTO() {
    }

    public PromoPostFormDTO(int userId, int postId, Date date, int category, double price,
                            Product detail, double discount, boolean hasPromo) {
        super(userId, postId, date, category, price, detail);
        this.discount = discount;
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public static Post convert(PromoPostFormDTO postFormDTO){
        return new Post(postFormDTO.getUserId(), postFormDTO.getId_post(), postFormDTO.getDate(),
                postFormDTO.getCategory(), postFormDTO.getPrice(), postFormDTO.getDetail(),
                postFormDTO.isHasPromo(), postFormDTO.getDiscount());
    }
}
