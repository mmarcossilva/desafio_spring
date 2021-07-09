package com.meli.desafio_spring.users.dto;

import com.meli.desafio_spring.users.models.Buyer;

import java.util.List;

public class BuyerListDTO extends UserDTO{
    private List<UserDTO> followed;

    public BuyerListDTO(Buyer buyer, List<UserDTO> sellers) {
        super(buyer.getUserId(), buyer.getUserName());
        this.followed = sellers;
    }

    public List<UserDTO> getFollowers() {
        return followed;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followed = followers;
    }
}
