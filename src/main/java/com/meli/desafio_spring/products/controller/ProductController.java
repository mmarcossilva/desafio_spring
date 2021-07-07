package com.meli.desafio_spring.products.controller;


import com.meli.desafio_spring.products.DTOs.PostDTO;
import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private PostService service;

    @PostMapping("/newpost")
    public ResponseEntity<?> follow(@RequestBody PostDTO post){
        service.createPost(PostDTO.convert(post));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
