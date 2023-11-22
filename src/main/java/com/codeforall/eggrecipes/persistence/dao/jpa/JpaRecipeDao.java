package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaRecipeDao implements RecipeDao {

	@PersistenceContext
	EntityManager em;


	@Override
	public List<Recipe> findAll() {
		CriteriaQuery<Recipe> criteriaQuery = em.getCriteriaBuilder().createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);
		 List<Recipe> recipes = em.createQuery(criteriaQuery).getResultList();
		 Hibernate.initialize(recipes);
		 return recipes;

	}

	// Gets all public recipes from user
	@Override
	public List<Recipe> getAllPublicRecipes() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);

		criteriaQuery.where(cb.and(
				cb.equal(root.get("isPrivate"), 0)));

		TypedQuery<Recipe> qry = em.createQuery(criteriaQuery);

		return qry.getResultList();
	}

	@Override
	public Recipe findById(Integer id) {
			return em.find(Recipe.class, id);
	}

	@Override
	public Recipe saveOrUpdate(Recipe modelObject) {
			Hibernate.initialize(em.merge(modelObject));
		return modelObject;
	}

	@Override
	public void delete(Integer id) {
			Recipe recipe = em.find(Recipe.class, id);

			if (!recipe.isPrivate()) return;

			em.remove(recipe);
	}


	@Override
	public List<Ingredient> getIngredientList(Integer id) {
			Recipe recipe = Optional.ofNullable(em.find(Recipe.class, id))
					.orElseThrow(() -> new IllegalArgumentException("Recipe doesn't exist"));

			return recipe.getIngredientList();
	}


	@Override
	public void saveOrUpdateIngredientToRecipe(Integer recipeId, Integer ingredientId) {
			Recipe recipe = em.find(Recipe.class, recipeId);
			Ingredient ingredient = em.find(Ingredient.class, ingredientId);
			EntityTransaction tx = em.getTransaction();
			recipe.getIngredientList().add(ingredient);
	}

	@Override
	public void deleteIngredient(int recipeId, int ingredientId) {
			Recipe recipe =  em.find(Recipe.class, recipeId);
			Ingredient ingredient = em.find(Ingredient.class, ingredientId);
			recipe.removeIngredient(ingredient);
			em.merge(ingredient);

	}
}
