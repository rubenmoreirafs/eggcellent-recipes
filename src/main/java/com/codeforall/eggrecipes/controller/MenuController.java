package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import view.MenuView;

public class MenuController {
    private MenuView menuView;
    private UserServiceImpl userService;

    private RecipeServiceImpl recipeService;

    public void createUser(User user) {
        userService.saveOrUpdate(user);
    }
    public void addRecipeToUser(int userId, int recipeId) {
        userService.addRecipe(userId, recipeId);
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
        recipeService.addIngredientToRecipe(recipeId,ingredientId);
    }
    public void setRecipeService(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeServiceImpl getRecipeService() {
        return recipeService;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }


    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public User getNameById(int id) {
        return userService.get(id);
    }


}
