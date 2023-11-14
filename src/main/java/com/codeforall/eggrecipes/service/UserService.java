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

    List<Recipe> getAllPublicRecipes(Integer userId);

    Recipe addRecipeToRecipeBook(Integer userId, Integer recipeId);
    public User saveOrUpdate(User user);

    public void delete(int id);

    public void deleteRecipe(int userId, int recipeId);



}
