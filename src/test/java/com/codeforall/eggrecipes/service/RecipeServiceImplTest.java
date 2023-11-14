package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.dao.RecipeDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaRecipeDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaUserDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	RecipeDao recipeDao;

	@Before
	public void setUp() {
		recipeService = new RecipeServiceImpl();
		recipeDao = mock(JpaRecipeDao.class);
		recipeService.setRecipeDao(recipeDao);
	}

	@Test
	public void get() {
		int fakeId = 999;
		Recipe fakeRecipe = mock(Recipe.class);

		when(recipeDao.findById(fakeId)).thenReturn(fakeRecipe);

		recipeService.get(fakeId);

		verify(recipeDao).findById(fakeId);
	}

	@Test
	public void findAll() {

		when(recipeDao.findAll()).thenReturn(null);

		recipeService.findAll();

		verify(recipeDao).findAll();

	}

	@Test
	public void getIngredientList() {

		int fakeId = 999;
		List<Ingredient> fakeList = null;

		when(recipeDao.getIngredientList(fakeId)).thenReturn(fakeList);

		recipeService.getIngredientList(fakeId);

		verify(recipeDao).getIngredientList(fakeId);

	}

	@Test
	public void saveOrUpdate() {
		Recipe fakeRecipe = mock(Recipe.class);

		when(recipeDao.saveOrUpdate(fakeRecipe)).thenReturn(fakeRecipe);

		recipeService.saveOrUpdate(fakeRecipe);


		verify(recipeDao).saveOrUpdate(fakeRecipe);

	}

	@Test
	public void saveOrUpdateIngredientToRecipe() {
		int fakeRecipeId = 999;
		int fakeIngredientId = 999;

		recipeService.saveOrUpdateIngredientToRecipe(fakeRecipeId,fakeIngredientId);

		verify(recipeDao).saveOrUpdateIngredientToRecipe(fakeRecipeId,fakeIngredientId);
	}

	@Test
	public void deleteIngredient() {
		int fakeRecipeId = 999;
		int fakeIngredientId = 999;

		recipeService.deleteIngredient(fakeRecipeId, fakeIngredientId);

		verify(recipeDao).deleteIngredient(fakeRecipeId,fakeIngredientId);
	}
}