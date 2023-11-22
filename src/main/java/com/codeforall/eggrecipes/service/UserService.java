package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    public User get(int id);

    public List<User> findAll();

    public Set<Recipe> getRecipes(int id);

    List<Recipe> getAllPrivateRecipes(Integer userId);

    public Recipe addRecipeToRecipeBook(Integer userId, Recipe recipe);
    public User saveOrUpdate(User user);

    public void delete(int id);

    public void deleteRecipeFromBook(int userId, int recipeId);

    public void deleteRecipe(int recipeId);


}
