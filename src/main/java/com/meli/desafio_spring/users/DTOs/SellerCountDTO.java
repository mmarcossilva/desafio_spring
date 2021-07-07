package com.meli.desafio_spring.users.DTOs;

import com.meli.desafio_spring.users.models.Seller;

public class SellerCountDTO extends UserDTO{
    private int followers_count;

    public SellerCountDTO(Seller seller) {
        super(seller.getUserId(), seller.getUserName());
        this.followers_count = seller.getFollowers().size();
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
