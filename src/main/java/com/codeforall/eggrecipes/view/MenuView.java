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
        recipe.setName("Milky Milk");
        recipe.setInstructions("Milk the milk and it will all be milked");
        recipe.setOwnerId(2);
        recipe.setPrivate(false);

        Ingredient ingredient = new Ingredient();

        recipe.addIngredient(ingredient);

        menuController.createRecipe(recipe);
        //create user
        //delete user
        //get user

        //create recipe
        //edit recipe
        //delete recipe
        //add recipe to recipebook
        //remove book from recipebook
        //list all recipes

        //create ingredient
        //delete ingredient




        User user = menuController.getNameById(2);

        System.out.println(user.getUsername());

        System.out.println("Bye!");
    }
}
