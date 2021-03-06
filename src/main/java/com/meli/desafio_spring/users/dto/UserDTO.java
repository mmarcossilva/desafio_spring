package com.meli.desafio_spring.users.dto;

import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.models.Seller;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private int userID;
    private String userName;

    public UserDTO(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static List<UserDTO> convertBuyers(List<Buyer> buyers){
     return buyers.stream().map(buyer -> new UserDTO(buyer.getUserId(), buyer.getUserName())).collect(Collectors.toList());
    }

    public static List<UserDTO> convertSellers(List<Seller> sellers){
        return sellers.stream().map(seller -> new UserDTO(seller.getUserId(), seller.getUserName())).collect(Collectors.toList());
    }
}
