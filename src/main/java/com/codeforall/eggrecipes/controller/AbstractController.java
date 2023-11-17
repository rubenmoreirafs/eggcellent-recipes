package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.service.AuthServiceImpl;
import com.codeforall.eggrecipes.view.View;

public class AbstractController implements Controller{

    protected AuthServiceImpl authServiceImpl;
    protected View view;

    public void setAuthService(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init(){
        view.show();
    }
}
