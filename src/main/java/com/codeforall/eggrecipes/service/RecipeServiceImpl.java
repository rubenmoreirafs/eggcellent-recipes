package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class RecipeServiceImpl implements RecipeService {
    EntityManagerFactory entityManagerFactory;

    public RecipeServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Recipe get(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Recipe.class, id);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Ingredient> getIngredientList(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Recipe recipe = Optional.ofNullable(entityManager.find(Recipe.class, id))
                    .orElseThrow(() -> new IllegalArgumentException("Recipe doesn't exist"));

            return recipe.getIngredientList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
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
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Recipe recipe =  entityManager.find(Recipe.class, recipeId);
            Ingredient ingredient = entityManager.find(Ingredient.class, ingredientId);
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            recipe.removeIngredient(ingredient);
            entityManager.merge(ingredient);
            tx.commit();

        } finally {
            if(entityManager != null) {
                entityManager.close();
            }
        }
    }
}

