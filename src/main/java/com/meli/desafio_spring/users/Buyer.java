package com.meli.desafio_spring.users;

import java.util.List;

public class Buyer extends User{
    private List<Long> followed;

    public Buyer(long userId, String userName, List<Long> followed) {
        super(userId, userName);
        this.followed = followed;
    }

    public List<Long> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Long> followed) {
        this.followed = followed;
    }
}
