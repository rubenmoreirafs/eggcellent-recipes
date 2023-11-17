package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RecipeServiceImpl implements RecipeService {

    private RecipeDao recipeDao;
    private IngredientDao ingredientDao;

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    @Override
    public Recipe get(int id) {
        return recipeDao.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeDao.getAllPublicRecipes(1);
    }

    @Override
    public List<Recipe> getAllPublicRecipes(Integer userId) {
        return recipeDao.getAllPublicRecipes(userId);
    }

    @Override
    public List<Ingredient> getIngredientList(int id) {
        return recipeDao.getIngredientList(id);
    }

    @Override
    public Recipe saveOrUpdate(Map<String, String> recipeData, List<String> ingredientList) {
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();

        recipe.setName(recipeData.get("Name"));
        recipe.setInstructions(recipeData.get("Instructions"));
        recipe.setPrepTime(Integer.parseInt(recipeData.get("PrepTime")));
        recipe.setPhotoUrl(recipeData.get("PhotoURL"));
        recipe.setPrivate(true);
        recipe.setOwnerId(1); // Temporarily hardwiring owner ID

        for (String ingredientString : ingredientList) {
            ingredient.setName(ingredientString);
            recipe.addIngredient(ingredient);
        }

        return recipeDao.saveOrUpdate(recipe);
    }

    @Override
    public void saveOrUpdateIngredientToRecipe(int recipeId, int ingredientId)  {

        recipeDao.saveOrUpdateIngredientToRecipe(recipeId, ingredientId);
    }

    @Override
    public void deleteIngredient(int recipeId, int ingredientId) {
        recipeDao.deleteIngredient(recipeId, ingredientId);
    }

    @Override
    public void deleteRecipe(int recipeId) {
        recipeDao.delete(recipeId);
    }

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}

