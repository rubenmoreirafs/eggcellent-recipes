package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Set;

public class UserServiceImpl implements UserService {
    EntityManagerFactory entityManagerFactory;

    public UserServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public User get(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user;

        try {
            user = entityManager.find(User.class, id);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return user;
    }

    @Override
    public Set<Recipe> getRecipeBook(int id) {
        return null;
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    public Recipe addRecipe(int userId, int recipeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user;
        Recipe recipe;
        try {
            user = entityManager.find(User.class, userId);
            recipe = entityManager.find(Recipe.class, recipeId);
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            user.getRecipeBook().add(recipe);
            tx.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return recipe;
    }
    @Override
    public void delete(int id) {
        return;
    }

    public void deleteRecipe(int userId, int recipeID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            User user = entityManager.find(User.class, userId);
            Recipe recipe = entityManager.find(Recipe.class, recipeID);
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            user.removeRecipe(recipe);
            entityManager.remove(recipe);
            tx.commit();
        } finally {
            if(entityManager != null) {
                entityManager.close();
            }
        }
    }



}
