package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class IngredientServiceImpl implements IngredientService {
	EntityManagerFactory entityManagerFactory;

	public IngredientServiceImpl(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}
	@Override
	public Ingredient get(Integer id) {
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		try {
			return entityManager.find(Ingredient.class, id);
		} finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public Ingredient saveOrUpdate(Ingredient ingredient) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			try {
				EntityTransaction tx = entityManager.getTransaction();
				tx.begin();
				entityManager.merge(ingredient);
				tx.commit();
				return ingredient;
			} finally {
				if(entityManager != null) {
					entityManager.close();
				}
			}
		}


}
