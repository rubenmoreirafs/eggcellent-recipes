package view;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

public class MenuView {
    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() {
        System.out.println("hello!");
        Recipe recipe = new Recipe();
        recipe.setName("Milky Milk");
        recipe.setInstructions("Milk the milk and it will all be milked");
        recipe.setOwnerId(2);
        User user = menuController.getNameById(2);
        //menuController.createRecipe(recipe);
        Ingredient ingredient = new Ingredient();
        ingredient.setName("eggy egg");
        ingredient.setRecipe(recipe);
        //menuController.addIngredient(3, ingredient.getId());

        //menuController.addRecipe(3, 3);
        menuController.deleteRecipe(2, 5);

        System.out.println(user.getUsername());

        System.out.println("Bye!");
    }
}
