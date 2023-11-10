package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;

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
    public Recipe saveOrUpdate(Recipe recipe) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(recipe);
            tx.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return recipe;
    }
    @Override
    public void addIngredientToRecipe(int recipeId, int ingredientId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Recipe recipe = entityManager.find(Recipe.class, recipeId);
            Ingredient ingredient = entityManager.find(Ingredient.class, ingredientId);
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            recipe.addIngredient(ingredient);
            entityManager.merge(recipe);
            tx.commit();
        } finally {
             if(entityManager != null) {
                 entityManager.close();
             }
        }
    }

    @Override
    public void deleteIngredient(int recipeId, int ingredientId) {

    }

    @Override
    public void delete(int id) {

    }
}

