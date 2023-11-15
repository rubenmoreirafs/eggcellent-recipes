package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.model.Recipe;

import java.util.List;
import java.util.Set;

public class PublicRecipesView implements View {
    private RecipeController recipeController;

    public void setListRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    @Override
    public void show() {
        showAllRecipes();
    }

    private void showAllRecipes() {
        List<Recipe> recipes = recipeController.listAllPublic();

        for (Recipe recipe : recipes) {
            System.out.println(recipe.getId() + " - " + recipe.getName());
        }
    }
}
