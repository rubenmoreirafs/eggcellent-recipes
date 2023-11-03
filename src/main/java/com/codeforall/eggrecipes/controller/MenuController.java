package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.model.User;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import view.MenuView;

public class MenuController {
    private MenuView menuView;
    private UserServiceImpl userService;

    private RecipeServiceImpl recipeService;
    public void createRecipe(int userId, int recipeId) {
        recipeService.createRecipe(userId, recipeId);
    }

    public void setRecipeService(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeServiceImpl getRecipeService() {
        return recipeService;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }


    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public User getNameById(int id) {
        return userService.get(id);
    }


}
