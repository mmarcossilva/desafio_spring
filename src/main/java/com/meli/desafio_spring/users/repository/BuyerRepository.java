package com.meli.desafio_spring.users.repository;

import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.repository.imple.DatabaseMethods;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuyerRepository implements DatabaseMethods<Buyer> {
    private static int id = 1;
    private List<Buyer> buyers;

    public BuyerRepository() {
        List<Buyer> buyers = new ArrayList<>();
        buyers.add(new Buyer(id++, "Buyer_1"));
        buyers.add(new Buyer(id++, "Buyer_2"));
        buyers.add(new Buyer(id++, "Buyer_3"));
        this.buyers = buyers;
    }

    @Override
    public Buyer findById(int id) {
        return buyers.stream().filter(buyer -> buyer.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Buyer item) {
        List<Buyer> buyers = this.buyers.stream()
                .filter(buyer -> buyer.getUserId() != item.getUserId())
                .collect(Collectors.toList());
        buyers.add(item);
        this.buyers = buyers;
    }
}
