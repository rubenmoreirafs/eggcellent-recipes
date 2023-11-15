package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class UpdateRecipeView extends AbstractView {
    private Recipe recipe;
    private RecipeController recipeController;

    @Override
    public void show() {
        getRecipeDetails();
    }

    private void getRecipeDetails() {
        StringInputScanner recipeName = new StringInputScanner();
        StringInputScanner ingredient = new StringInputScanner();
        StringInputScanner instructions = new StringInputScanner();
        StringInputScanner prepTime = new StringInputScanner();
        StringInputScanner photoUrl = new StringInputScanner();

        recipeName.setMessage("Recipe name: ");
        ingredient.setMessage("Enter ingredient (with measurement": );
        instructions.setMessage("Instructions: ");
        prepTime.setMessage("Prep time: ");
        photoUrl.setMessage("Photo URL: ");

        recipe.setName(prompt.getUserInput(recipeName));

        for (int i = 0; i < 4; i++) {
            recipe.addIngredient(prompt.getUserInput(ingredient));
        }

        recipe.setName(prompt.getUserInput(instructions));
        recipe.setPrepTime(Integer.parseInt(prompt.getUserInput(prepTime)));
        recipe.setPhotoUrl(prompt.getUserInput(photoUrl));

        recipeController.createRecipe(recipe);
    }
}
