package com.codeforall.eggrecipes.service;

public interface AuthService {
    boolean authenticate(String email, String password);
}
