package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Service
public class IngredientServiceImpl implements IngredientService {
	private IngredientDao ingredientDao;

	public IngredientServiceImpl() {

	}

	@Override
	public Ingredient get(Integer id) {
		return ingredientDao.findById(id);
	}
	@Transactional
	@Override
	public Ingredient saveOrUpdate(Ingredient ingredient) {
		return ingredientDao.saveOrUpdate(ingredient);
	}

	public IngredientDao getIngredientDao() {
		return ingredientDao;
	}
	@Autowired
	public void setIngredientDao(IngredientDao ingredientDao) {
		this.ingredientDao = ingredientDao;
	}
}
