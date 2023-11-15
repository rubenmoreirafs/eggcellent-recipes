package com.codeforall.eggrecipes.controller;

public class LoginController extends AbstractController {

    private boolean authFailed = false;
    private Controller nextController;
    private AuthService authService;

    public boolean getAuthFailed(){
        return authFailed;
    }

    public void setAuthService(AuthService authService){
        this.authService = authService;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void login(String email, String password){
        if (authService.autenticate(email, password)){
            nextController.init();
        }
        authFailed = true;
        init();
    }
}
