package com.codeforall.eggrecipes.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "recipe_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe> recipeBook = new HashSet<>();
    private String username;
    @Transient
    private String password;
    private String email;


    public Recipe removeRecipe(Recipe recipe) {
        recipeBook.remove(recipe);
        return recipe;
    }
    public Set<Recipe> getRecipeBook() {
        return recipeBook;
    }

    public void setRecipeBook(Set<Recipe> recipeBook) {
        this.recipeBook = recipeBook;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
