package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserServiceImpl;

import java.util.List;

public class RecipeController extends AbstractController {

    private View view;
    private UserServiceImpl userService;
    private RecipeServiceImpl recipeService;
    private PublicRecipesView publicRecipesView;

    public void setPublicRecipesView(PublicRecipesView publicRecipesView) {
        this.publicRecipesView = publicRecipesView;
    }

    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public void setRecipeService(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeServiceImpl getRecipeService() {
        return recipeService;
    }


    public List<Recipe> listAllPublic(){
        return recipeServiceImpl.getRecipes();
    }

    public void createRecipe(int recipeId) {
        recipeService.saveOrUpdate(recipeId);
    }

    public void deleteRecipe(int recipeId) {
        userService.deleteRecipe(recipeId);
    }

    public void updateRecipe(int recipeId) {
        userService.updateRecipe(recipeId);
    }

    public Recipe findById(int id) {
        return recipeService.get(id);
    }
}
