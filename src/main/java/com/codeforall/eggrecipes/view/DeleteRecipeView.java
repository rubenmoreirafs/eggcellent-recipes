package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class DeleteRecipeView extends AbstractView {
    private Recipe recipe;
    private RecipeController recipeController;

    @Override
    public void show() {
        deleteRecipe(Integer.parseInt(getRecipeIdFromUser()));
    }

    private String getRecipeIdFromUser() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Enter ID of recipe to delete: ");
        System.out.println("Yea boi!");
        return prompt.getUserInput(question);
    }

    private void deleteRecipe(int id) {
        recipeController.deleteRecipe(Integer.parseInt(id));
    }
}
