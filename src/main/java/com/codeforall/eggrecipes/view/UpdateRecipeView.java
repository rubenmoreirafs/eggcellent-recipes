package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.RecipeController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UpdateRecipeView extends AbstractView {
    private RecipeController recipeController;
    private Map<String, String> recipeDataMap;
    private List<String> ingredientList;
    private Recipe recipe;

    public UpdateRecipeView() {
        super();
        recipeDataMap = new LinkedHashMap<>();
        ingredientList = new LinkedList<>();
    }

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
        StringInputScanner question = new StringInputScanner();

        question.setMessage("Recipe name: ");
        recipeDataMap.put("Name", prompt.getUserInput(question));

        question.setMessage("Enter ingredient (with measurement): ");
        for (int i = 0; i < 3; i++) {
            ingredientList.add(prompt.getUserInput(question));
        }

        question.setMessage("Instructions: ");
        recipeDataMap.put("Instructions", prompt.getUserInput(question));

        question.setMessage("Prep time: ");
        recipeDataMap.put("PrepTime", prompt.getUserInput(question));

        question.setMessage("Photo URL: ");
        recipeDataMap.put("PhotoURL", prompt.getUserInput(question));
    }

    private void updateRecipe() {
        recipeController.updateRecipe(recipeDataMap, ingredientList);
    }
}