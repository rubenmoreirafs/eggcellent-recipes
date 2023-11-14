package com.codeforall.eggrecipes.persistence.model;


import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient extends AbstractModel {

    private String name;
    @ManyToOne
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
