package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.RecipeController;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class RecipeView extends AbstractView {
    private RecipeController recipeController;

    public void setRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    public void show() {
        showRecipe(Integer.parseInt(getUserInput()));
    }

    private String getUserInput() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Enter recipe ID: ");
        return prompt.getUserInput(question);
    }

    private void showRecipe(int id) {
        Recipe recipe = recipeController.findById(id);
        System.out.println(recipe.getName());
    }
}
