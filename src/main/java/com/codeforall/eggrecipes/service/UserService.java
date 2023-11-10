package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import java.util.Set;

public interface UserService {

    public User get(int id);

    public Set<Recipe> getRecipeBook(int id);

    public User saveOrUpdate(User user);

    public void delete(int id);

    public void deleteRecipe(int userId, int recipeId);



}
