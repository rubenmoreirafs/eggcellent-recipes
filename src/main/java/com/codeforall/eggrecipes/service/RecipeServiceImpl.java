package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.model.Ingredient;
import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RecipeServiceImpl implements RecipeService {
    EntityManagerFactory entityManagerFactory;

    public RecipeServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Recipe get(int id) {
        return null;
    }

    @Override
    public List<Ingredient> getIngredientList(int id) {
        return null;
    }

    @Override
    public Recipe saveOrUpdate(int userId, int recipeId) {
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

    }
}

