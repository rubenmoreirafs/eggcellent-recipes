package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.RecipeService;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserService;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import view.MenuView;

import java.util.List;
import java.util.Set;

public class MenuController {
    private MenuView menuView;
    private UserService userService;

    private RecipeService recipeService;

    //test list methods

    public Set<Recipe> getRecipeBook(Integer id) {
        return userService.getRecipes(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    public List<Recipe> getAllPrivateRecipes(Integer id) {
        return userService.getAllPrivateRecipes(id);
    }

    public List<Recipe> getAllPublicRecipes(Integer id) {
        return userService.getAllPublicRecipes(id);
    }

    public User getNameById(int id) {
        return userService.get(id);
    }
    public void createUser(User user) {
        userService.saveOrUpdate(user);
    }

    public void addRecipeToUser(int userId, int recipeId) {
        userService.addRecipeToRecipeBook(userId, recipeId);
    }

    public void removeRecipe(int userId, int recipeId) {
        userService.deleteRecipe(userId, recipeId);
    }
    public void deleteUser(int userId) {
        userService.delete(userId);
    }

    public void createRecipe(Recipe recipe) {
        recipeService.saveOrUpdate(recipe);
    }

    public void deleteRecipe(int userId, int recipeId) {
        userService.deleteRecipe(userId, recipeId);
    }
    public void addIngredient(int recipeId, int ingredientId) {
        recipeService.saveOrUpdateIngredientToRecipe(recipeId,ingredientId);
    }

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeService getRecipeService() {
        return recipeService;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
