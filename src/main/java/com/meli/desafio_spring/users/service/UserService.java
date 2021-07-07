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

    public void followSeller(int buyerId, int sellerId){
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

    public Seller getSeller(int userId) {
        Seller seller = sellerRepository.findById(userId);
        if(seller == null)
            throw new ObjectNotFoundException();
        return seller;
    }

    public Buyer getBuyer(int userId) {
        Buyer getBuyer = buyerRepository.findById(userId);
        if(getBuyer == null)
            throw new ObjectNotFoundException();
        return getBuyer;
    }

    public List<Buyer> getBuyers(List<Integer> buyersIds){
        return buyersIds.stream().map(id -> buyerRepository.findById(id)).collect(Collectors.toList());
    }

    public List<Seller> getSellers(List<Integer> sellersIds){
        return sellersIds.stream().map(id -> sellerRepository.findById(id)).collect(Collectors.toList());
    }
}
