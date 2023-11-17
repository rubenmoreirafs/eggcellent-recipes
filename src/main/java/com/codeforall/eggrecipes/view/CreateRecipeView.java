package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.RecipeController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.List;

public class CreateRecipeView extends AbstractView {
    private Recipe recipe = new Recipe();
    private RecipeController recipeController;

    public void setRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    @Override
    public void show() {
        getRecipeDetails();
    }

    private void getRecipeDetails() {
        StringInputScanner recipeName = new StringInputScanner();
        StringInputScanner ingredientName = new StringInputScanner();
        StringInputScanner instructions = new StringInputScanner();
        StringInputScanner prepTime = new StringInputScanner();
        StringInputScanner photoUrl = new StringInputScanner();

        recipeName.setMessage("Recipe name: ");
        ingredientName.setMessage("Enter ingredient (with measurement)");
        instructions.setMessage("Instructions: ");
        prepTime.setMessage("Prep time: ");
        photoUrl.setMessage("Photo URL: ");

        recipe.setName(prompt.getUserInput(recipeName));

        for (int i = 0; i < 3; i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(prompt.getUserInput(ingredientName));
            recipe.addIngredient(ingredient);
        }

        recipe.setPrepTime(Integer.parseInt(prompt.getUserInput(prepTime)));
        recipe.setInstructions(prompt.getUserInput(instructions));
        recipe.setPhotoUrl(prompt.getUserInput(photoUrl));
        recipe.setPrivate(true);
        recipe.setOwnerId(1); // Hardwiring user ID 1
        recipeController.createRecipe(recipe);
    }
}
