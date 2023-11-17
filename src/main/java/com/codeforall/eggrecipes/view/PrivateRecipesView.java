package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.UserController;
import com.codeforall.eggrecipes.persistence.model.Recipe;

import java.util.List;

public class PrivateRecipesView implements View {
    private UserController userController;

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void show() {
        showPrivateRecipes();
    }

    private void showPrivateRecipes() {
        List<Recipe> recipes = userController.listAllPrivate();

        for (Recipe recipe : recipes) {
            System.out.println(recipe.getId() + " - " + recipe.getName());
        }
    }
}
