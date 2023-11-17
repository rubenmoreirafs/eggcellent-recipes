package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.UserServiceImpl;

public class MainController extends AbstractController {
    private PublicRecipeController publicRecipeController;
    private PrivateRecipeController privateRecipeController;
    private RecipeController recipeController;
    private BookController bookController;

    private AddToBookController addToBookController;
    private RemoveFromBookController removeFromBookController;
    private CreateRecipeController createRecipeController;
    private UpdateRecipeController updateRecipeController;
    private DeleteRecipeController deleteRecipeController;

    public void setPublicRecipeController(PublicRecipeController publicRecipeController) {
        this.publicRecipeController = publicRecipeController;
    }

    public void setPrivateRecipeController(PrivateRecipeController privateRecipeController) {
        this.privateRecipeController = privateRecipeController;
    }

    public void setRecipeController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }

    public void setAddToBookController(AddToBookController addToBookController) {
        this.addToBookController = addToBookController;
    }

    public void setRemoveFromBookController(RemoveFromBookController removeFromBookController) {
        this.removeFromBookController = removeFromBookController;
    }

    public void setCreateRecipeController(CreateRecipeController createRecipeController) {
        this.createRecipeController = createRecipeController;
    }

    public void setUpdateRecipeController(UpdateRecipeController updateRecipeController) {
        this.updateRecipeController = updateRecipeController;
    }

    public void setDeleteRecipeController(DeleteRecipeController deleteRecipeController) {
        this.deleteRecipeController = deleteRecipeController;
    }

    public MainController() {
        super();
    }

    public void handleUserChoice(int choice){
        switch (choice){
            case 1:
                publicRecipeController.init();
                break;
            case 2:
                privateRecipeController.init();
                break;
            case 3:
                recipeController.init();
                break;
            case 4:
                bookController.init();
                break;
            case 5:
                addToBookController.init();
                break;
            case 6:
                bookController.init();
                removeFromBookController.init();
                break;
            case 7:
                createRecipeController.init();
                break;
            case 8:
                privateRecipeController.init();
                updateRecipeController.init();
                break;
            case 9:
                privateRecipeController.init();
                deleteRecipeController.init();
                break;
            case 10:
                System.exit(69);
        }
    }
}
