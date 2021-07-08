package com.meli.desafio_spring.products.controller;


import com.meli.desafio_spring.products.DTOs.*;
import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.service.PostService;
import commons.enums.OrderPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private PostService service;

    @PostMapping("/newpost")
    public ResponseEntity<?> createPost(@RequestBody PostFormDTO post){
        service.createPost(PostFormDTO.convert(post));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getListPosts(
            @RequestParam(defaultValue = "date_desc") OrderPost order, @PathVariable int userId){
        List<PostDTO> posts = service.getLatestPosts(userId, order)
                .stream()
                .map(PostDTO::convert)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PostListDTO(userId, posts),HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<?> createPromoPost(@RequestBody PromoPostFormDTO post){
        service.createPost(PromoPostFormDTO.convert(post));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PostPromoCountDTO> getPostsPromoCount(@PathVariable int userId) {
        List<Post> posts = service.getPromoPosts(userId);
        return new ResponseEntity<>(new PostPromoCountDTO(userId, service.getSellerName(userId), posts.size()),
                HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PostPromoListDTO> getPostsPromoList(@PathVariable int userId) {
        List<PostPromoDTO> posts = service.getPromoPosts(userId)
                .stream()
                .map(PostPromoDTO::convert)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PostPromoListDTO(userId, service.getSellerName(userId), posts),
                HttpStatus.OK);
    }
}
