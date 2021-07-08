package com.meli.desafio_spring.products.service;

import com.meli.desafio_spring.products.exceptions.ObjectIdAlreadyExistsException;
import com.meli.desafio_spring.products.exceptions.SellerNotFoundException;
import com.meli.desafio_spring.products.models.Post;
import com.meli.desafio_spring.products.repository.PostRepository;
import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.service.UserService;
import commons.enums.OrderPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public void createPost(Post post){
        validatePostExists(post.getPostId());
        validateUserExists(post.getUserId());
        postRepository.save(post);
    }

    public void validateUserExists(int userId){
        Seller seller = userService.getSeller(userId);
        if(seller == null)
            throw new SellerNotFoundException();
    }

    public void validatePostExists(int id){
        Post post = postRepository.findById(id);
        if(post != null)
            throw new ObjectIdAlreadyExistsException();
    }

    public List<Post> getLatestPosts(int userId, OrderPost order){
        Buyer buyer = userService.getBuyer(userId);
        Date limitDate = this.getDateBeforeTwoWeeks();
        List<Post> posts = postRepository.findByListSeller(
                buyer.getFollowed()).stream()
                .filter(post -> post.getDate().after(limitDate))
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
        if(order == OrderPost.date_desc)
            Collections.reverse(posts);
        return posts;
    }

    public Date getDateBeforeTwoWeeks(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }

    public List<Post> getPromoPosts(int userId) {
        return postRepository.findPromosBySeller(userId);
    }

    public String getSellerName(int id) {
        return userService.getSeller(id).getUserName();
    }
}
