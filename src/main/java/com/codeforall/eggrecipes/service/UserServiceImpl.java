package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User get(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Set<Recipe> getRecipes(int id) {
        return userDao.getRecipeBook(id);
    }

    @Override
    public List<Recipe> getAllPrivateRecipes(Integer userId) {
        return userDao.getAllPrivateRecipes(userId);
    }

    @Override
    public Recipe addRecipeToRecipeBook(Integer userId, Integer recipeId) {
        return userDao.addRecipeToRecipeBook(userId, recipeId);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void deleteRecipeFromBook(int userId, int recipeId) {
        userDao.removeRecipeFromBook(userId, recipeId);
    }

    @Override
    public void deleteRecipe(int recipeId) {

    }

    public UserDao getUserdao() {
        return userDao;
    }

    public void setUserdao(UserDao userdao) {
        this.userDao = userdao;
    }
}
