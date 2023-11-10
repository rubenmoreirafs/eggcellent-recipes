package view;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.IngredientServiceImpl;
import com.codeforall.eggrecipes.service.RecipeServiceImpl;
import com.codeforall.eggrecipes.service.UserServiceImpl;

public class MenuView {
    private MenuController menuController;

    private UserServiceImpl userService;
    private RecipeServiceImpl recipeService;
    private IngredientServiceImpl ingredientService;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() {
        System.out.println("hello!");

        menuController.deleteUser(4);

        //create user
      //works  menuController.createUser(user);
        //delete user
        //get user

        //create recipe
       //only works if private is true menuController.createRecipe(recipe);
        //edit recipe
        //delete recipe
        //add recipe to recipebook
        //remove book from recipebook
        //list all recipes

        //create ingredient
        //delete ingredient




        User user1 = menuController.getNameById(2);

        System.out.println(user1.getUsername());

        System.out.println("Bye!");
    }
}
