package com.example.v6.appUser;

public class AppUser {

    private final Integer userId;
    private final String userName;

    public AppUser(Integer userId,
                   String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
