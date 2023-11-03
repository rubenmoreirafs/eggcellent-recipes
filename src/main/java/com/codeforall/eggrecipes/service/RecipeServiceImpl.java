package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class RecipeService {
    EntityManagerFactory entityManagerFactory;

    public RecipeService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createRecipe(int userId, int recipeId) {
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
    }
}

