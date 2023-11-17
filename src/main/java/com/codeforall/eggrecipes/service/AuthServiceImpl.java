package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.User;

public class AuthServiceImpl implements AuthService {
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean authenticate(String email, String password) {
        // Do the authentication and get current user
        return true;
    }
}
