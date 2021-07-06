package com.meli.desafio_spring.users;

import java.util.List;

public class Seller extends User{
    private List<Long> followers;

    public Seller(long userId, String userName, List<Long> followers) {
        super(userId, userName);
        this.followers = followers;
    }

    public List<Long> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Long> followers) {
        this.followers = followers;
    }
}
