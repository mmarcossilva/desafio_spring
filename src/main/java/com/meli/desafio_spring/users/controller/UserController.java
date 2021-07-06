package com.meli.desafio_spring.users.controller;

import com.meli.desafio_spring.users.DTOs.SellerDTO;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<SellerDTO> getFollowersCount(@PathVariable Long userId){
        Seller seller = service.getSeller(userId);
        return new ResponseEntity<>(new SellerDTO(seller), HttpStatus.OK);
    }

}
