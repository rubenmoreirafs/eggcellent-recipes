package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.service.AuthServiceImpl;

public class LoginController extends AbstractController {

    private boolean authFailed = false;
    private Controller nextController;
    private AuthServiceImpl authServiceImpl;

    public boolean isAuthFailed(){
        return authFailed;
    }

    public void setAuthService(AuthServiceImpl authServiceImpl){
        this.authServiceImpl = authServiceImpl;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void login(String email, String password){
        if (authServiceImpl.authenticate(email, password)){
            nextController.init();
        }
        authFailed = true;
        init();
    }
}
