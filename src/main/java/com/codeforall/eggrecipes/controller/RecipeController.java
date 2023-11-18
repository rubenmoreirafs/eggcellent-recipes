package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.*;
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
        Recipe recipe = new Recipe();

        recipe.setName(recipeData.get("Name"));
        recipe.setInstructions(recipeData.get("Instructions"));
        recipe.setPrepTime(Integer.parseInt(recipeData.get("PrepTime")));
        recipe.setPhotoUrl(recipeData.get("PhotoURL"));
        recipe.setPrivate(true);
        recipe.setOwnerId(1); // Temporarily hardwiring owner ID

        for (String ingredientString : ingredientList) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientString);
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
            System.out.println(recipe.getId());
//            recipeService.saveOrUpdateIngredientToRecipe(recipe.getId(), ingredient);
        }

        recipeService.saveOrUpdate(recipe);
    }

    public void deleteRecipe(int recipeId) {
        recipeService.deleteRecipe(recipeId);
    }

    public void updateRecipe(Map<String, String> recipeData, List<String> ingredientList, int recipeId) {
        Recipe recipe = recipeService.get(recipeId);

        recipe.setName(recipeData.get("Name"));
        recipe.setInstructions(recipeData.get("Instructions"));
        recipe.setPrepTime(Integer.parseInt(recipeData.get("PrepTime")));
        recipe.setPhotoUrl(recipeData.get("PhotoURL"));
        recipe.setPrivate(true);
        recipe.setOwnerId(1); // Temporarily hardwiring owner ID

        for (String ingredientString : ingredientList) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientString);
            ingredient.setRecipe(recipe);
            ingredientService.saveOrUpdate(ingredient);
            recipeService.saveOrUpdateIngredientToRecipe(recipeId,ingredient);
        }

        recipeService.saveOrUpdate(recipe);
    }

    public Recipe findById(int id) {
        return recipeService.get(id);
    }
}
