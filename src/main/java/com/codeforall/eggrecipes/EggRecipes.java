package com.codeforall.eggrecipes;

import com.codeforall.eggrecipes.controller.*;
import com.codeforall.eggrecipes.persistence.JPABootstrap;
import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaIngredientDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaRecipeDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaUserDao;
import com.codeforall.eggrecipes.service.*;
import com.codeforall.eggrecipes.view.*;
import org.academiadecodigo.bootcamp.Prompt;

import javax.persistence.EntityManagerFactory;

public class EggRecipes {
    public static void main(String[] args) {

        JPABootstrap jpa = new JPABootstrap();
        EntityManagerFactory emf = jpa.start();

        // Daos
        UserDao userDao = new JpaUserDao(emf);
        RecipeDao recipeDao = new JpaRecipeDao(emf);
        IngredientDao ingredientDao = new JpaIngredientDao(emf);

        // Setting Services
        UserServiceImpl userService = new UserServiceImpl();
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        IngredientServiceImpl ingredientService = new IngredientServiceImpl();
        userService.setUserdao(userDao);
        recipeService.setRecipeDao(recipeDao);
        ingredientService.setIngredientDao(ingredientDao);
        recipeService.setIngredientDao(ingredientDao);

        // Setting user controller
        UserController userController = new UserController();
        userController.setUserService(userService);

        // Setting Book views and controllers
        BookView bookView = new BookView();
        BookController bookController = new BookController();
        bookController.setView(bookView);
        bookView.setUserController(userController);
        AddToBookView addToBookView = new AddToBookView();
        addToBookView.setUserController(userController);
        AddToBookController addToBookController = new AddToBookController();
        addToBookController.setView(addToBookView);
        RemoveFromBookView removeFromBookView = new RemoveFromBookView();
        removeFromBookView.setUserController(userController);
        RemoveFromBookController removeFromBookController = new RemoveFromBookController();
        removeFromBookController.setView(removeFromBookView);

        // Setting private recipe controllers
        PrivateRecipesView privateRecipesView = new PrivateRecipesView();
        privateRecipesView.setUserController(userController);
        PrivateRecipeController privateRecipeController = new PrivateRecipeController();
        privateRecipeController.setView(privateRecipesView);

        // Setting public recipe controllers
        RecipeView recipeView = new RecipeView();
        RecipeController recipeController = new RecipeController();
        recipeController.setIngredientService(ingredientService);
        recipeController.setView(recipeView);
        recipeController.setUserService(userService);
        recipeController.setRecipeService(recipeService);
        recipeView.setRecipeController(recipeController);
        PublicRecipesView publicRecipesView = new PublicRecipesView();
        PublicRecipeController publicRecipeController = new PublicRecipeController();
        publicRecipeController.setView(publicRecipesView);
        publicRecipesView.setRecipeController(recipeController);

        // Setting Recipe views and controllers
        CreateRecipeView createRecipeView = new CreateRecipeView();
        createRecipeView.setRecipeController(recipeController);
        CreateRecipeController createRecipeController = new CreateRecipeController();
        createRecipeController.setView(createRecipeView);
        UpdateRecipeView updateRecipeView = new UpdateRecipeView();
        UpdateRecipeController updateRecipeController = new UpdateRecipeController();
        updateRecipeController.setView(updateRecipeView);
        updateRecipeView.setRecipeController(recipeController);
        DeleteRecipeController deleteRecipeController = new DeleteRecipeController();
        DeleteRecipeView deleteRecipeView = new DeleteRecipeView();
        deleteRecipeController.setView(deleteRecipeView);
        deleteRecipeView.setRecipeController(recipeController);
        deleteRecipeView.setUserController(userController);

        // Setting menu view and controller
        MainView mainView = new MainView();
        MainController mainController = new MainController();
        mainView.setMenuController(mainController);
        mainController.setView(mainView);
        mainController.setAddToBookController(addToBookController);
        mainController.setBookController(bookController);
        mainController.setRemoveFromBookController(removeFromBookController);
        mainController.setCreateRecipeController(createRecipeController);
        mainController.setDeleteRecipeController(deleteRecipeController);
        mainController.setPrivateRecipeController(privateRecipeController);
        mainController.setPublicRecipeController(publicRecipeController);
        mainController.setUpdateRecipeController(updateRecipeController);
        mainController.setRecipeController(recipeController);

        mainController.init();
        jpa.stop();
    }
}
