package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;

import java.util.List;

public interface RecipeService {

    public Recipe get(int id);

    public List<Ingredient> getIngredientList(int id);

    public Recipe saveOrUpdate(Recipe recipe);

    public void addIngredientToRecipe(int recipeId, int ingredientId);

    public void deleteIngredient(int recipeId, int ingredientId);




}
