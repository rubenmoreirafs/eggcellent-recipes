package com.codeforall.eggrecipes.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "recipeBook")
    private Set<User> userList = new HashSet<>();
    /*@OneToMany
    private List<Ingredient> ingredientList = new ArrayList<>();
     */
    private String name;
    private String instructions;
    @Column(name = "owner_id")
    private int ownerId;
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "photo_url")
    private String photoUrl;

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /*
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

     */

    /*
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

     */

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
