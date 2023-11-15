package com.codeforall.eggrecipes.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class LoginView extends AbstractView {
    private LoginController loginController;
    private MenuInputScanner menuInputScanner;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;

    }
    @Override
    public void show() {
        if (loginController.isAuthFailed) {
            System.out.println("Incorrect details entered");
        }

        displayMenu();
        int answer = getUserInput(menuInputScanner);

        switch (answer) {
            case 1:
                handleLogin();
                break;
            case 2:
                handleCreateUserAccount();
        }
    }

    private void displayMenu() {
        String[] menuOptions = {"Login", "Create an account"};
        menuInputScanner = new MenuInputScanner(menuOptions);

        System.out.println("=== EGGCELLENT RECIPES ===");
        menuInputScanner.setMessage("Please select an option: ");
    }

    private int getUserInput(MenuInputScanner scanner) {
        return prompt.getUserInput(scanner);
    }

    private void handleLogin() {
        StringInputScanner emailPrompt = new StringInputScanner();
        PasswordInputScanner passwordPrompt = new PasswordInputScanner();

        emailPrompt.setMessage("Wass yo email, fool: ");
        passwordPrompt.setMessage("And yo password, bumbaclart: ");

        String email = prompt.getUserInput(emailPrompt);
        String password = prompt.getUserInput(passwordPrompt);

        loginController.login(email, password);
    }

    private void handleCreateUserAccount() {
        System.out.println("Creating user account");
    }
}
