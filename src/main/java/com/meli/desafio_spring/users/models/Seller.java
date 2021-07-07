package com.meli.desafio_spring.users.models;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private List<Integer> followers;

    public Seller(int userId, String userName) {
        super(userId, userName);
        this.followers = new ArrayList<>();
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public void addFollower(Integer buyerId) {
        this.followers.add(buyerId);
    }

    public void removeFollower(Integer buyerId){
        this.followers.remove(buyerId);
    }
}
