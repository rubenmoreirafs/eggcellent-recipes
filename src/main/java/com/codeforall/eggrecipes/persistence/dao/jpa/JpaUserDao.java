package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class JpaUserDao implements UserDao {

	EntityManagerFactory emF;

	public JpaUserDao(EntityManagerFactory emF){
		this.emF = emF;
	}


	// Finds every user in the DB
	@Override
	public List<User> findAll() {
		EntityManager em = emF.createEntityManager();
		CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		return em.createQuery(criteriaQuery).getResultList();

	}

	// Finds user by id on the DB
	@Override
	public User findById(Integer id) {
		EntityManager em = emF.createEntityManager();
		try {
			return em.find(User.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// Inserts or Updates User in the DB
	@Override
	public User saveOrUpdate(User modelObject) {
		EntityManager em = emF.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(modelObject);
			tx.commit();
			return modelObject;
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

	// Deletes user from the DB
	@Override
	public void delete(Integer id) {
		EntityManager em = emF.createEntityManager();
		try {
			User user = em.find(User.class, id);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(user);
			tx.commit();
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

	// Gets all private recipes from user
	@Override
	public List<Recipe> getAllPrivateRecipes(Integer userId) {
		EntityManager em = emF.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);
		criteriaQuery.where(cb.and(cb.equal(root.get("isPrivate"), 0),(cb.equal(root.get("ownerId"), userId))));
		TypedQuery<Recipe> qry = em.createQuery(criteriaQuery);

		return qry.getResultList();

	}

	// Gets all public recipes from user
	@Override
	public List<Recipe> getAllPublicRecipes(Integer userId) {
		EntityManager em = emF.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
		Root<Recipe> root = criteriaQuery.from(Recipe.class);
		criteriaQuery.where(cb.and(cb.equal(root.get("isPrivate"), 1),( cb.equal(root.get("ownerId"), userId))));
		TypedQuery<Recipe> qry = em.createQuery(criteriaQuery);

		return qry.getResultList();
	}

	// Returns the recipe book of the user that is requesting
	@Override
	public Set<Recipe> getRecipeBook(Integer userId) {
		EntityManager em = emF.createEntityManager();
		try {
			User user = Optional.ofNullable(em.find(User.class, userId))
					.orElseThrow(() -> new IllegalArgumentException("User does not exist"));

			return user.getRecipeBook();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// Adds a recipe to the recipe book of the user requesting
	@Override
	public Recipe addRecipeToRecipeBook(Integer userId, Integer recipeId) {
		EntityManager em = emF.createEntityManager();
		User user;
		Recipe recipe;
		try {
			user = em.find(User.class, userId);
			recipe = em.find(Recipe.class, recipeId);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			user.getRecipeBook().add(recipe);
			tx.commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return recipe;
	}

	// deletes a recipe from the user's recipe book on the object
	// and on the DB
	@Override
	public void deleteRecipe(Integer userId, Integer recipeId) {
		EntityManager em = emF.createEntityManager();
		try{
			User user = em.find(User.class, userId);
			Recipe recipe = em.find(Recipe.class, recipeId);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			user.removeRecipe(recipe);
			em.remove(recipe);
			tx.commit();
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}
}
