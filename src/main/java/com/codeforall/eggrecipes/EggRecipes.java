package com.codeforall.eggrecipes;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.persistence.JPABootstrap;
import com.codeforall.eggrecipes.service.IngredientServiceImpl;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import view.MenuView;

import javax.persistence.EntityManagerFactory;

public class EggRecipes {
    public static void main(String[] args) {

        JPABootstrap jpa = new JPABootstrap();
        EntityManagerFactory emf = jpa.start();


        UserServiceImpl userService = new UserServiceImpl(emf);
        RecipeServiceImpl recipeService = new RecipeServiceImpl(emf);
        IngredientServiceImpl ingredientService = new IngredientServiceImpl(emf);

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
