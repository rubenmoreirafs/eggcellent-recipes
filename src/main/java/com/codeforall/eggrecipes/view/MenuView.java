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

        Recipe recipe = new Recipe();
        recipe.setOwnerId(2);
        recipe.setName("Milky milk");
        recipe.setInstructions("milk the milk to the get to the milky god of milk");
        recipe.setPrivate(false);


        //create user
        //works  menuController.createUser(user);

        //delete user

        //get user

        //create recipe
        //menuController.createRecipe(recipe);

        //edit recipe

        //delete recipe
        //works menuController.removeRecipe(2,5);


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
