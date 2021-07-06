package com.meli.desafio_spring.users.DTOs;

import com.meli.desafio_spring.users.models.Buyer;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long userID;
    private  String userName;

    public UserDTO(Long userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public static List<UserDTO> convert(List<Buyer> buyers){
     return buyers.stream().map(buyer -> new UserDTO(buyer.getUserId(), buyer.getUserName())).collect(Collectors.toList());
    }
}
