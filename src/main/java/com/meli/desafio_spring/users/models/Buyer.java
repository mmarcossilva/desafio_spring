package com.meli.desafio_spring.users.models;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private List<Long> followed;

    public Buyer(long userId, String userName) {
        super(userId, userName);
        this.followed = new ArrayList<>();
    }

    public List<Long> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Long> followed) {
        this.followed = followed;
    }

    public void follow(Long sellerId) {
        followed.add(sellerId);
    }
}
