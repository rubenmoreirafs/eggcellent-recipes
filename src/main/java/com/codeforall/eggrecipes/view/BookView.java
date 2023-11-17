package com.codeforall.eggrecipes.view;


import com.codeforall.eggrecipes.controller.UserController;
import com.codeforall.eggrecipes.persistence.model.Recipe;

import java.util.Set;

public class BookView implements View {
    private UserController userController;

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void show() {
        showRecipeBook();
    }

    private void showRecipeBook() {
        Set<Recipe> recipeList = userController.listRecipeBook();

        for (Recipe recipe : recipeList) {
            System.out.println(recipe.getId() + " - " + recipe.getName());
        }
    }
}
