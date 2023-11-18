package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class JpaRecipeDao implements RecipeDao {

	EntityManagerFactory emF;

	public JpaRecipeDao(EntityManagerFactory emF) {
		this.emF = emF;
	}

	@Override
	public List<Recipe> findAll() {
		EntityManager em = emF.createEntityManager();
		CriteriaQuery<Recipe> criteriaQuery = em.getCriteriaBuilder().createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	// Gets all public recipes from user
	@Override
	public List<Recipe> getAllPublicRecipes(Integer userId) {
		EntityManager em = emF.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);

		criteriaQuery.where(cb.and(
				cb.equal(root.get("isPrivate"), 0),
				( cb.equal(root.get("ownerId"), userId))));

		TypedQuery<Recipe> qry = em.createQuery(criteriaQuery);

		return qry.getResultList();
	}

	@Override
	public Recipe findById(Integer id) {
		EntityManager em = emF.createEntityManager();
		try {
			return em.find(Recipe.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Recipe saveOrUpdate(Recipe modelObject) {
		EntityManager em = emF.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Hibernate.initialize(em.merge(modelObject));
			tx.commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return modelObject;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emF.createEntityManager();

		try {
			Recipe recipe = em.find(Recipe.class, id);

			if (!recipe.isPrivate()) return;

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(recipe);
			tx.commit();
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}


	@Override
	public List<Ingredient> getIngredientList(Integer id) {
		EntityManager em = emF.createEntityManager();
		try {
			Recipe recipe = Optional.ofNullable(em.find(Recipe.class, id))
					.orElseThrow(() -> new IllegalArgumentException("Recipe doesn't exist"));

			return recipe.getIngredientList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}


	@Override
	public void saveOrUpdateIngredientToRecipe(Integer recipeId, Integer ingredientId) {
		EntityManager em = emF.createEntityManager();
		try {
			Recipe recipe = em.find(Recipe.class, recipeId);
			Ingredient ingredient = em.find(Ingredient.class, ingredientId);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			//Hibernate.initialize()
			recipe.getIngredientList().add(ingredient);
			//em.merge(recipe);
//			recipe.addIngredient(ingredient);
			tx.commit();
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

	@Override
	public void deleteIngredient(int recipeId, int ingredientId) {
		EntityManager em = emF.createEntityManager();

		try {
			Recipe recipe =  em.find(Recipe.class, recipeId);
			Ingredient ingredient = em.find(Ingredient.class, ingredientId);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			recipe.removeIngredient(ingredient);
			em.merge(ingredient);
			tx.commit();

		} finally {
			if(em != null) {
				em.close();
			}
		}
	}
}
