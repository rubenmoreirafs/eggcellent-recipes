package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.service.IngredientServiceImpl;

public class IngredientController {

    int recipeId;
    IngredientServiceImpl ingredientService;
    IngredientView ingredientView;

    public void addIngredient(int recipeId, int ingredientId) {
        recipeService.addIngredientToRecipe(recipeId,ingredientId);
    }

    public void init(){
        view.show();
    }
}
