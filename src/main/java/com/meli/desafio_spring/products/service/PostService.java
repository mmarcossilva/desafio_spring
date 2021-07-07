package com.meli.desafio_spring.products.service;

import com.meli.desafio_spring.products.DTOs.PostDTO;
import com.meli.desafio_spring.products.exceptions.ObjectIdAlreadyExistsExeception;
import com.meli.desafio_spring.products.exceptions.SellerNotFoundException;
import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.repository.PostRepository;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private  UserService userService;

    public void createPost(Post post){
        validadePostExists(post.getPostId());
        validadeUserExists(post.getUserId());
        postRepository.save(post);
    }

    public void validadeUserExists(int userId){
        Seller seller = userService.getSeller(userId);
        if(seller == null)
            throw new SellerNotFoundException();
    }

    public void validadePostExists(int id){
        Post post = postRepository.findById(id);
        if(post != null)
            throw new ObjectIdAlreadyExistsExeception();
    }
}
