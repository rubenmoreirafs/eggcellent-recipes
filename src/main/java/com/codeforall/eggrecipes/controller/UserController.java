package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import java.util.List;
import java.util.Set;

public class UserController {

    private UserServiceImpl userService;

    public Set<Recipe> listRecipeBook() {
        return userService.getRecipesInBook();
    }

    public List<Recipe> listAllPrivate() {
        return userService.getPrivateRecipes();
    }

    public void addToBook(int id) {
        userService.addRecipe(id);
    }

    public void removeFromBook(int id) {
        userService.deleteRecipe(id);
    }

}