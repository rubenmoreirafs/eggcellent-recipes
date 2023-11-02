package view;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;

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
        menuController.createRecipe(2, 3);
        System.out.println(user.getUsername());

        System.out.println("Bye!");
    }
}
