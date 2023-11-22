package com.codeforall.eggrecipes.persistence.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AbstractModel {
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "recipe_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe> recipeBook = new HashSet<>();
    private String username;
    private String password;
    private String email;


    public Set<Recipe> getRecipeBook() {
        return recipeBook;
    }

    public Recipe removeRecipe(Recipe recipe) {
        recipeBook.remove(recipe);
        return recipe;
    }

    public void setRecipeBook(Set<Recipe> recipeBook) {
        this.recipeBook = recipeBook;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
