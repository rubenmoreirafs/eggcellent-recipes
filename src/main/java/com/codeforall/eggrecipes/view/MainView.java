package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.MainController;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MainView extends AbstractView {
    private MainController mainController;
    private MenuInputScanner menuInputScanner;

    public void setMenuController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void show() {
        buildMenu();

        while (true) {
            mainController.handleUserChoice(getUserChoice());
        }
    }

    private void buildMenu() {
        String[] options = {
                "List all public recipes in DB",
                "List my private recipes",
                "Find recipe by ID",
                "Show recipe book",
                "Add recipe to recipe book",
                "Remove recipe from recipe book",
                "Create recipe",
                "Edit recipe",
                "Delete recipe",
                "Quit"
        };

        menuInputScanner = new MenuInputScanner(options);
        menuInputScanner.setMessage("Make your selection: ");
    }

    private int getUserChoice() {
        return prompt.getUserInput(menuInputScanner);
    }
}
