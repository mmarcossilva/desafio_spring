package com.meli.desafio_spring.users.service;

import com.meli.desafio_spring.users.exceptions.ObjectNotFoundException;
import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.repository.BuyerRepository;
import com.meli.desafio_spring.users.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        buyer.follow(sellerId);
        seller.addFollower(buyerId);
        sellerRepository.save(seller);
        buyerRepository.save(buyer);
    }
}
