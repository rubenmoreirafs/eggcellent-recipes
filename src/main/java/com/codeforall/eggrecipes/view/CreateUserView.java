package com.codeforall.eggrecipes.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class CreateUserView extends AbstractView {
//    private CreateUserController createUserController;
//    public void setCreateUserController(CreateUserController createUserController) {
//        this.createUserController = createUserController;
//    }

    @Override
    public void show() {
        createUser(getUserDetails());
    }

    private String[] getUserDetails() {
        String[] userDetails = new String[2];

        StringInputScanner emailQuestion = new StringInputScanner();
        StringInputScanner passwordQuestion = new StringInputScanner();

        emailQuestion.setMessage("Enter your email: ");
        passwordQuestion.setMessage("Enter a password: ");

        userDetails[0] = prompt.getUserInput(emailQuestion);
        userDetails[1] = prompt.getUserInput(passwordQuestion);

        return userDetails;
    }

    private void createUser(String[] userDetails) {
//        CreateUserController.createUser(userDetails);
    }
}
