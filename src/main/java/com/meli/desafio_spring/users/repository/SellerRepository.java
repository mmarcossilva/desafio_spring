package com.meli.desafio_spring.users.repository;

import com.meli.desafio_spring.users.models.Buyer;
import com.meli.desafio_spring.users.models.Seller;
import com.meli.desafio_spring.users.repository.imple.DatabaseMethods;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SellerRepository implements DatabaseMethods<Seller> {
    private static Long id = 1L;
    private List<Seller> sellers;

    public SellerRepository() {
        List<Seller> sellers = new ArrayList<>();
        sellers.add(new Seller(id++, "Seller_1"));
        sellers.add(new Seller(id++, "Seller_2"));
        sellers.add(new Seller(id++, "Seller_3"));
        this.sellers = sellers;
    }

    @Override
    public Seller findById(Long id) {
        return sellers.stream().filter(seller -> seller.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Seller item) {
        List<Seller> sellers = this.sellers.stream()
                .filter(seller -> seller.getUserId() != item.getUserId())
                .collect(Collectors.toList());
        sellers.add(item);
        this.sellers = sellers;
    }
}
