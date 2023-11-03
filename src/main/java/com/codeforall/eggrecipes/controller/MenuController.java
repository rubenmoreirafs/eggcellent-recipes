package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;
import com.codeforall.eggrecipes.service.RecipeService;
import com.codeforall.eggrecipes.service.UserService;
import view.MenuView;

public class MenuController {
    private MenuView menuView;
    private UserService userService;

    private RecipeService recipeService;
    public void createRecipe(int userId, int recipeId) {
        recipeService.createRecipe(userId, recipeId);
    }

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeService getRecipeService() {
        return recipeService;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getNameById(int id) {
        return userService.getUserById(id);
    }


}
