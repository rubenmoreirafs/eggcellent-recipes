package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.RecipeController;
import com.codeforall.eggrecipes.controller.UserController;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class DeleteRecipeView extends AbstractView {
    private Recipe recipe;
    private RecipeController recipeController;
    private UserController userController;

    public void setRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void show() {
        deleteRecipe(Integer.parseInt(getRecipeIdFromUser()));
    }

    private String getRecipeIdFromUser() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Enter ID of recipe to delete: ");
        System.out.println("Yea boi!");
        return prompt.getUserInput(question);
    }

    private void deleteRecipe(int id) {
        recipeController.deleteRecipe(id);
    }
}
