package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.model.Ingredient;
import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;

import java.util.List;

public interface RecipeService {

    public Recipe get(int id);

    public List<Ingredient> getIngredientList(int id);

    public Recipe saveOrUpdate(int userId, int recipeId);

    public void delete(int id);

}
