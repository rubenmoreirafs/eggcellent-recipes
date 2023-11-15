package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.UserServiceImpl;

public class MainController extends AbstractController {

    public void handleUserChoice(int choice){
        switch (choice){
            case 1:
                publicRecipeController.init();
                break;
            case 2:
                userRecipeBookController.init();
                break;
            case 3:
                privateRecipeController.init();
                break;
            case 4:
                publicRecipeController.init();
                privateRecipeController.init();
                recipeController.init();
                break;
            case 5:
                bookController.init();
                break;
            case 6:
                publicRecipeController.init(); //show all public so the user chooses which one to add to Book
                addToBookController.init();
                break;
            case 7:
                bookController.init();
                removeFromBookController.init();
                break;
            case 8:
                createRecipeController.init();
                break;
            case 9:
                privateRecipeController.init();
                updateRecipeController.init();
                break;
            case 10:
                privateRecipeController.init();
                deleteRecipeController.init();
                break;
            case 11:
                System.exit(1);
        }
    }



    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
