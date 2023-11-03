package com.codeforall.eggrecipes;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.model.User;
import com.codeforall.eggrecipes.persistence.JPABootstrap;
import com.codeforall.eggrecipes.service.RecipeService;
import com.codeforall.eggrecipes.service.UserService;
import view.MenuView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EggRecipes {
    public static void main(String[] args) {
        JPABootstrap jpa = new JPABootstrap();
        EntityManagerFactory emf = jpa.start();
        UserService userService = new UserService(emf);
        RecipeService recipeService = new RecipeService(emf);
        MenuController menuController = new MenuController();
        MenuView menuView = new MenuView();
        menuController.setMenuView(menuView);
        menuController.setUserService(userService);
        menuController.setRecipeService(recipeService);
        menuView.setMenuController(menuController);


        menuView.show();
        jpa.stop();
    }
}
