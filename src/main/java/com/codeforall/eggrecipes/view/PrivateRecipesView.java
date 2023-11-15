package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.model.Recipe;

import java.util.List;
import java.util.Set;

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
            System.out.println(recipe.getId() + " " + recipe.getName());
        }
    }
}
