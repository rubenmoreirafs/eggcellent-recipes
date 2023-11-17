package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.controller.UserController;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class RemoveFromBookView extends AbstractView {
    private UserController userController;

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void show() {
        userController.removeFromBook(Integer.parseInt(getIdFromUser()));
    }

    private String getIdFromUser() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Enter recipe ID: ");
        return prompt.getUserInput(question);
    }
}
