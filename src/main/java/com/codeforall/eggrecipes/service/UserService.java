package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;

import java.util.Set;

public interface UserService {

    public User get(int id);

    public Set<Recipe> getRecipeBook(int id);

    public User SaveOrUpdate(User user);

    public void Delete(int id);

}
