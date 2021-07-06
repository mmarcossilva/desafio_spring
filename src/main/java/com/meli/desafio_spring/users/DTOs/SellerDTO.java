package com.meli.desafio_spring.users.DTOs;

import com.meli.desafio_spring.users.models.Seller;
import org.springframework.util.MultiValueMap;

public class SellerDTO {
    private Long userID;
    private  String userName;
    private int followers_count;

    public SellerDTO(Seller seller) {
        this.userID = seller.getUserId();
        this.userName = seller.getUserName();
        this.followers_count = seller.getFollowers().size();
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
