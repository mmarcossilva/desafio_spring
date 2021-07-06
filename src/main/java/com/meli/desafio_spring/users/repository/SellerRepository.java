package com.meli.desafio_spring.users.repository;

import com.meli.desafio_spring.users.models.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepository {
    private static Long id = 1L;
    private List<Seller> sellers;

    public SellerRepository() {
        List<Seller> sellers = new ArrayList<>();
        sellers.add(new Seller(id++, "Seller_1"));
        sellers.add(new Seller(id++, "Seller_2"));
        sellers.add(new Seller(id++, "Seller_3"));
        this.sellers = sellers;
    }
}
