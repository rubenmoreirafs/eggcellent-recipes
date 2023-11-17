package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.AuthServiceImpl;
import com.codeforall.eggrecipes.service.IngredientServiceImpl;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import com.codeforall.eggrecipes.view.View;

import java.util.List;
import java.util.Map;

public class RecipeController extends AbstractController {

    private View view;
    private UserServiceImpl userService;
    private RecipeServiceImpl recipeService;
    private IngredientServiceImpl ingredientService;
    private AuthServiceImpl authServiceImpl;

    public RecipeController() {
        super();
    }
    public AuthServiceImpl getAuthService() {
        return authServiceImpl;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public IngredientServiceImpl getIngredientService() {
        return ingredientService;
    }

    public void setIngredientService(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    public void setRecipeService(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeServiceImpl getRecipeService() {
        return recipeService;
    }


    public List<Recipe> listAllPublic(){
        return recipeService.findAll();
    }

    public void createRecipe(Map<String, String> recipeData, List<String> ingredientList) {
        recipeService.saveOrUpdate(recipeData, ingredientList);
    }

    public void deleteRecipe(int recipeId) {
        recipeService.deleteRecipe(recipeId);
    }

    public void updateRecipe(Recipe recipe, Ingredient ingredient) {
        ingredientService.saveOrUpdate(ingredient);
//        recipeService.saveOrUpdate(recipe);
    }

    public Recipe findById(int id) {
        return recipeService.get(id);
    }
}
