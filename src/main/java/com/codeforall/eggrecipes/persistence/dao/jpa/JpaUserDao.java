package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.dao.UserDao;
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
import java.util.Set;

@Repository
public class JpaUserDao implements UserDao {

	@PersistenceContext
	EntityManager em;


	// Finds every user in the DB
	@Override
	public List<User> findAll() {
		CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		return em.createQuery(criteriaQuery).getResultList();

	}

	// Finds user by id on the DB
	@Override
	public User findById(Integer id) {
			User user = em.find(User.class, id);
			Hibernate.initialize(user);
			return user;
	}

	// Inserts or Updates User in the DB
	@Override
	public User saveOrUpdate(User modelObject) {
		em.merge(modelObject);
		return modelObject;
	}

	// Deletes user from the DB
	@Override
	public void delete(Integer id) {

		User user = em.find(User.class, id);
		em.remove(user);
	}

	// Gets all private recipes from user
	@Override
	public List<Recipe> getAllPrivateRecipes(Integer userId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);

		criteriaQuery.where(cb.and(
				cb.equal(root.get("isPrivate"), 1),
				(cb.equal(root.get("ownerId"), userId))));

		TypedQuery<Recipe> qry = em.createQuery(criteriaQuery);

		return qry.getResultList();

	}

	// Returns the recipe book of the user that is requesting
	@Override
	public Set<Recipe> getRecipeBook(Integer userId) {
		User user = Optional.ofNullable(em.find(User.class, userId))
				.orElseThrow(() -> new IllegalArgumentException("User does not exist"));
		Hibernate.initialize(user.getRecipeBook());
		return user.getRecipeBook();
	}

	// Adds a recipe to the recipe book of the user requesting
	@Override
	public Recipe addRecipeToRecipeBook(Integer userId, Integer recipeId) {
		User user;
		Recipe recipe;
		user = em.find(User.class, userId);
		recipe = em.find(Recipe.class, recipeId);
		user.getRecipeBook().add(recipe);
		return recipe;
	}

	// deletes a recipe from the user's recipe book on the object
	// and on the DB
	@Override
	public void removeRecipeFromBook(Integer userId, Integer recipeId) {
		User user = em.find(User.class, userId);
		Recipe recipe = em.find(Recipe.class, recipeId);
		user.removeRecipe(recipe);
	}
}
