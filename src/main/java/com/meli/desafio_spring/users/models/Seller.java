package com.meli.desafio_spring.users.models;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private List<Long> followers;

    public Seller(long userId, String userName) {
        super(userId, userName);
        this.followers = new ArrayList<>();
    }

    public List<Long> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Long> followers) {
        this.followers = followers;
    }
}
