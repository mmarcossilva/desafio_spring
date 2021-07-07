package com.meli.desafio_spring.users.models;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private List<Integer> followed;

    public Buyer(int userId, String userName) {
        super(userId, userName);
        this.followed = new ArrayList<>();
    }

    public List<Integer> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Integer> followed) {
        this.followed = followed;
    }

    public void follow(Integer sellerId) {
        followed.add(sellerId);
    }
}
