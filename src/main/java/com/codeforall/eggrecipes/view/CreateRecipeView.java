package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.RecipeController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.*;

public class CreateRecipeView extends AbstractView {
    private RecipeController recipeController;
    private Map<String, String> recipeDataMap;
    private List<String> ingredientList;

    public CreateRecipeView() {
        super();
        recipeDataMap = new LinkedHashMap<>();
        ingredientList = new LinkedList<>();
    }

    public void setRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    @Override
    public void show() {
        getRecipeDetails();
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

        recipeController.createRecipe(recipeDataMap, ingredientList);
    }
}
