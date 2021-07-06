package com.meli.desafio_spring.users.service;

import com.meli.desafio_spring.users.exceptions.ObjectNotFoundException;
import com.meli.desafio_spring.users.exceptions.UserAlreadyFollow;
import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.repository.BuyerRepository;
import com.meli.desafio_spring.users.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public void followSeller(Long buyerId, Long sellerId){
        Seller seller = sellerRepository.findById(sellerId);
        Buyer buyer = buyerRepository.findById(buyerId);
        if(seller == null || buyer == null)
            throw new ObjectNotFoundException();
        if(buyer.getFollowed().contains(sellerId))
            throw new UserAlreadyFollow();
        buyer.follow(sellerId);
        seller.addFollower(buyerId);
        sellerRepository.save(seller);
        buyerRepository.save(buyer);
    }

    public Seller getSeller(Long userId) {
        Seller seller = sellerRepository.findById(userId);
        if(seller == null)
            throw new ObjectNotFoundException();
        return seller;
    }

    public List<Buyer> getBuyers(List<Long> buyersIds){
        return buyersIds.stream().map(id -> buyerRepository.findById(id)).collect(Collectors.toList());
    }

    public List<Seller> getSellers(List<Long> sellersIds){
        return sellersIds.stream().map(id -> sellerRepository.findById(id)).collect(Collectors.toList());
    }
}
