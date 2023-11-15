package com.codeforall.eggrecipes.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class RemoveFromBookView extends AbstractView {
    private UserController userController;

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
