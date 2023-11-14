package view;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.*;

public class MenuView {
    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() {
        System.out.println("hello!");


        for(Recipe recipe: menuController.getAllRecipes()) {
            System.out.println(recipe.getName());
        }

        for(Recipe recipe: menuController.getAllPrivateRecipes(1)) {
            System.out.println(recipe.getName());
        }
        //works create user

        // works delete user

        // works get user

        // works create recipe

        //works edit recipe

        // works delete recipe


        // works add recipe to recipebook

        // works remove book from recipebook

        //list all recipes

        //create ingredient

        //delete ingredient




        User user1 = menuController.getNameById(2);

        System.out.println(user1.getUsername());

        System.out.println("Bye!");
    }
}
