package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.RecipeController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class UpdateRecipeView extends AbstractView {
    private Recipe recipe;
    private Ingredient ingredient;
    private RecipeController recipeController;


    public void setRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    @Override
    public void show() {
        getRecipeToUpdate();
        getRecipeDetails();
    }

    private void getRecipeToUpdate() {
        StringInputScanner askForId = new StringInputScanner();
        askForId.setMessage("Enter ID of recipe to update: ");
        int id = Integer.parseInt(prompt.getUserInput(askForId));
        recipe = recipeController.findById(id);
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

        for (int i = 0; i < 4; i++) {
            ingredient = new Ingredient();
            ingredient.setName(prompt.getUserInput(ingredientName));
            recipeController.updateRecipe(recipe, ingredient);
        }

        recipe.setOwnerId(1); // Hardwiring user ID 1
        recipe.setName(prompt.getUserInput(instructions));
        recipe.setPrepTime(Integer.parseInt(prompt.getUserInput(prepTime)));
        recipe.setPhotoUrl(prompt.getUserInput(photoUrl));
    }

    private void updateRecipe() {
        recipeController.updateRecipe(recipe, ingredient);
    }
}