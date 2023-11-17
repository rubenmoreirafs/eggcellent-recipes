package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe get(int id);

    List<Recipe> findAll();

    List<Recipe> getAllPublicRecipes(Integer userId);

    List<Ingredient> getIngredientList(int id);

    Recipe saveOrUpdate(Recipe recipe);

    void saveOrUpdateIngredientToRecipe(int recipeId, int ingredientId);

    void deleteIngredient(int recipeId, int ingredientId);

    void deleteRecipe(int recipeId);
}
