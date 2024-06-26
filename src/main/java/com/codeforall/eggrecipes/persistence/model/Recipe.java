package com.codeforall.eggrecipes.persistence.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipe")
public class Recipe extends AbstractModel{

    @ManyToMany(
            mappedBy = "recipeBook"
    )
    private Set<User> userList = new HashSet<>();
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "recipe",
            fetch = FetchType.EAGER
    )
    private List<Ingredient> ingredientList = new ArrayList<>();

    private String name;



    @Column(
            name = "is_private"
    )
    private Boolean isPrivate;
    private String instructions;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "photo_url")
    private String photoUrl;


    public Ingredient addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
        return ingredient;
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredientList.remove(ingredient);
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public String getName() {
        return name;
    }

    public Boolean isPrivate() {
        return isPrivate;
    }


    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }


    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
