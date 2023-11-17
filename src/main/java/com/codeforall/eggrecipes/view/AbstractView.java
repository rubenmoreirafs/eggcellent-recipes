package com.codeforall.eggrecipes.view;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements View {
    Prompt prompt;

    public AbstractView() {
        prompt = new Prompt(System.in, System.out);
    }
}
