package com.codeforall.eggrecipes.view;

import com.codeforall.eggrecipes.model.Recipe;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class AddToBookView extends AbstractView {
    private UserController userController;

    @Override
    public void show() {
        userController.addToBook(Integer.parseInt(getIdFromUser()));
    }

    private String getIdFromUser() {
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Enter recipe ID: ");
        return prompt.getUserInput(question);
    }
}
