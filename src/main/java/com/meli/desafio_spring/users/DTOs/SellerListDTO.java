package com.meli.desafio_spring.users.DTOs;

import com.meli.desafio_spring.users.models.Seller;

import java.util.List;

public class SellerListDTO extends UserDTO{
    private List<UserDTO> followers;

    public SellerListDTO(Seller seller, List<UserDTO> buyers) {
        super(seller.getUserId(), seller.getUserName());
        this.followers = buyers;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}
