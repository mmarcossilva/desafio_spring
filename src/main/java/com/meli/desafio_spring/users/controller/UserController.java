package com.meli.desafio_spring.users.controller;

import com.meli.desafio_spring.users.DTOs.BuyerListDTO;
import com.meli.desafio_spring.users.DTOs.SellerCountDTO;
import com.meli.desafio_spring.users.DTOs.SellerListDTO;
import com.meli.desafio_spring.users.DTOs.UserDTO;
import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        service.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<SellerCountDTO> getFollowersCount(@PathVariable Long userId){
        Seller seller = service.getSeller(userId);
        return new ResponseEntity<>(new SellerCountDTO(seller), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list/")
    public ResponseEntity<SellerListDTO> getFollowersList(@PathVariable Long userId){
        Seller seller = service.getSeller(userId);
        List<UserDTO> buyers = UserDTO.convertBuyers(service.getBuyers(seller.getFollowers()));
        return new ResponseEntity<>(new SellerListDTO(seller, buyers), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list/")
    public ResponseEntity<BuyerListDTO> getFollowedList(@PathVariable Long userId){
        Buyer buyer = service.getBuyer(userId);
        List<UserDTO> sellers = UserDTO.convertSellers(service.getSellers(buyer.getFollowed()));
        return new ResponseEntity<>(new BuyerListDTO(buyer, sellers), HttpStatus.OK);
    }

}
