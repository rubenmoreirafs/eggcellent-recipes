package com.codeforall.eggrecipes.view;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements View {
    Prompt prompt;

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }
}
