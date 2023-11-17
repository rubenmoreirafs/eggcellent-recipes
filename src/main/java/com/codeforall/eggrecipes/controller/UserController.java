package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import java.util.List;
import java.util.Set;

public class UserController {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public Set<Recipe> listRecipeBook() {
        return userService.getRecipes(1);
    }

    public List<Recipe> listAllPrivate() {
        return userService.getAllPrivateRecipes(1);
    }

    public void addToBook(int recipeId) {
        userService.addRecipeToRecipeBook(1, recipeId);
    }

    public void removeFromBook(int recipeId) {
        userService.deleteRecipeFromBook(1, recipeId);
    }
}