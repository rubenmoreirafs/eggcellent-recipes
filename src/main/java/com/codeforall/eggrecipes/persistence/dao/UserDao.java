package com.codeforall.eggrecipes.persistence.dao;

import com.codeforall.eggrecipes.persistence.dao.Dao;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao extends Dao<User> {

	List<Recipe> getAllPrivateRecipes(Integer userId);

	List<Recipe> getAllPublicRecipes(Integer userId);

	Set<Recipe> getRecipeBook(Integer userId);

	Recipe addRecipeToRecipeBook(Integer userId, Integer recipeId);

	void deleteRecipe(Integer userId, Integer recipeId);



}
