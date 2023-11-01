package view;

import com.codeforall.eggrecipes.controller.MenuController;
import com.codeforall.eggrecipes.model.User;

public class MenuView {
    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() {
        System.out.println("hello!");

        User user = menuController.getNameById(2);
        System.out.println(user.getUsername());

        System.out.println("Bye!");
    }
}
