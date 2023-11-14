package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class IngredientServiceImpl implements IngredientService {

	private IngredientDao ingredientDao;


	@Override
	public Ingredient get(Integer id) {
		return ingredientDao.findById(id);
	}

	@Override
	public Ingredient saveOrUpdate(Ingredient ingredient) {
		return ingredientDao.saveOrUpdate(ingredient);
	}

	public IngredientDao getIngredientDao() {
		return ingredientDao;
	}

	public void setIngredientDao(IngredientDao ingredientDao) {
		this.ingredientDao = ingredientDao;
	}
}
