package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeDao recipeDao;
    private IngredientDao ingredientDao;

    @Autowired
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
        return recipeDao.findAll();
    }

    @Override
    public List<Recipe> getAllPublicRecipes() {
        return recipeDao.getAllPublicRecipes();
    }

    @Override
    public List<Ingredient> getIngredientList(int id) {
        return recipeDao.getIngredientList(id);
    }
    @Transactional
    @Override
    public Recipe saveOrUpdate(Recipe recipe) {
        return recipeDao.saveOrUpdate(recipe);
    }
    @Transactional
    @Override
    public void saveOrUpdateIngredientToRecipe(int recipeId, Ingredient ingredient)  {
        Recipe recipe = recipeDao.findById(recipeId);
        recipe.addIngredient(ingredient);
        recipeDao.saveOrUpdate(recipe);
    }

    @Transactional
    @Override
    public void deleteIngredient(int recipeId, int ingredientId) {
        recipeDao.deleteIngredient(recipeId, ingredientId);
    }
    @Transactional
    @Override
    public void deleteRecipe(int recipeId) {
        recipeDao.delete(recipeId);
    }

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    @Autowired
    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}

