package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaIngredientDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaRecipeDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {
	private IngredientServiceImpl ingredientService;
	private IngredientDao ingredientDao;

	@Before
	public void setUp() {
		ingredientService = new IngredientServiceImpl();
		ingredientDao = mock(JpaIngredientDao.class);
		ingredientService.setIngredientDao(ingredientDao);
	}

	@Test
	public void get() {
		int fakeId = 999;

		Ingredient fakeIngredient = mock(Ingredient.class);

		when(ingredientDao.findById(fakeId)).thenReturn(fakeIngredient);

		ingredientService.get(fakeId);

		verify(ingredientDao).findById(fakeId);
	}

	@Test
	public void saveOrUpdate() {
		Ingredient fakeIngredient = mock(Ingredient.class);

		when(ingredientDao.saveOrUpdate(fakeIngredient)).thenReturn(fakeIngredient);


		ingredientService.saveOrUpdate(fakeIngredient);

		verify(ingredientDao).saveOrUpdate(fakeIngredient);
	}
}