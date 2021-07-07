package com.meli.desafio_spring.products.controller;


import com.meli.desafio_spring.products.DTOs.PostDTO;
import com.meli.desafio_spring.products.DTOs.PostFormDTO;
import com.meli.desafio_spring.products.DTOs.PostListDTO;
import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.service.PostService;
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
    public ResponseEntity<PostListDTO> getListPosts(@PathVariable int userId){
        List<PostDTO> posts = service.getLatestPosts(userId)
                .stream().map(PostDTO::convert).collect(Collectors.toList());
        return new ResponseEntity<>(new PostListDTO(userId, posts),HttpStatus.OK);
    }

}
