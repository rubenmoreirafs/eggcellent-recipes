package com.codeforall.eggrecipes.persistence.dao;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;

import java.util.List;

public interface RecipeDao extends Dao<Recipe>{

	List<Recipe> getAllPublicRecipes(Integer userId);
	List<Ingredient> getIngredientList(Integer id);

	void saveOrUpdateIngredientToRecipe(Integer recipeId, Integer ingredientId);

	void deleteIngredient(int recipeId, int ingredientId);
}
