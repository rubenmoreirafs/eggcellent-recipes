package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    @Transactional
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
    @Transactional
    @Override
    public Recipe addRecipeToRecipeBook(Integer userId, Recipe recipe) {
        User user = userDao.findById(userId);
        user.getRecipeBook().add(recipe);
        userDao.saveOrUpdate(user);
        return recipe;
    }
    @Transactional
    @Override
    public User saveOrUpdate(User user) {
        return userDao.saveOrUpdate(user);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void deleteRecipeFromBook(int userId, int recipeId) {
        userDao.removeRecipeFromBook(userId, recipeId);
    }

    @Transactional
    @Override
    public void deleteRecipe(int recipeId) {

    }

    public UserDao getUserdao() {
        return userDao;
    }

    @Autowired
    public void setUserdao(UserDao userdao) {
        this.userDao = userdao;
    }
}
