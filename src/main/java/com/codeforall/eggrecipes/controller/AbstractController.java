package com.codeforall.eggrecipes.controller;

public class AbstractController implements Controller{

    protected AuthService authService;
    protected View view;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init(){
        view.show();
    }
}
