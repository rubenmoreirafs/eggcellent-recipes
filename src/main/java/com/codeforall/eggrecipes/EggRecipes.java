package com.codeforall.eggrecipes;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.persistence.JPABootstrap;
import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaIngredientDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaRecipeDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaUserDao;
import com.codeforall.eggrecipes.service.*;
import view.MenuView;

import javax.persistence.EntityManagerFactory;

public class EggRecipes {
    public static void main(String[] args) {

        JPABootstrap jpa = new JPABootstrap();
        EntityManagerFactory emf = jpa.start();


        // Menus
        MenuController menuController = new MenuController();
        MenuView menuView = new MenuView();

        // Services
        UserServiceImpl userService = new UserServiceImpl();
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        IngredientServiceImpl ingredientService = new IngredientServiceImpl();

        //Daos
        UserDao userDao = new JpaUserDao(emf);
        RecipeDao recipeDao = new JpaRecipeDao(emf);
        IngredientDao ingredientDao = new JpaIngredientDao(emf);


        //Setting Menu Controller
        menuController.setUserService(userService);
        menuController.setRecipeService(recipeService);

        //Setting Menu View
        menuView.setMenuController(menuController);

        //Setting Services
        userService.setUserdao(userDao);
        recipeService.setRecipeDao(recipeDao);
        ingredientService.setIngredientDao(ingredientDao);


        menuView.show();
        jpa.stop();
    }
}
