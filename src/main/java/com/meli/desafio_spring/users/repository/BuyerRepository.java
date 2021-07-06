package com.meli.desafio_spring.users.repository;

import com.meli.desafio_spring.users.models.Buyer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyerRepository {
    private static Long id = 1L;
    private List<Buyer> buyers;

    public BuyerRepository() {
        List<Buyer> buyers = new ArrayList<>();
        buyers.add(new Buyer(id++, "Buyer_1"));
        buyers.add(new Buyer(id++, "Buyer_2"));
        buyers.add(new Buyer(id++, "Buyer_3"));
        this.buyers = buyers;
    }
}
