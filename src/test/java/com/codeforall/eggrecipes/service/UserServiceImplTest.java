package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.JpaintegrationTestHelper;
import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaUserDao;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class UserServiceImplTest  {

	UserServiceImpl userService;
	UserDao userDao;

	@Before
	public void setup() {
		userService = new UserServiceImpl();
		userDao = mock(JpaUserDao.class);
		userService.setUserdao(userDao);
	}

	@Test
	public void get() {
		int fakeId = 999;
		User fakeUser = mock(User.class);
		fakeUser.setUsername("ruben");
		when(userDao.findById(fakeId)).thenReturn(fakeUser);

		userService.get(fakeId);

		verify(userDao).findById(fakeId);

	}

	@Test
	public void findAll() {
		List<User> fakeList = null;
		when(userDao.findAll()).thenReturn(fakeList);

		userService.findAll();

		verify(userDao).findAll();
	}

	@Test
	public void getRecipes() {
		int fakeId = 999;
		Set<Recipe> fakeList = null;
		when(userDao.getRecipeBook(fakeId)).thenReturn(fakeList);

		userService.getRecipes(fakeId);

		verify(userDao).getRecipeBook(fakeId);
	}

	@Test
	public void getAllPrivateRecipes() {
		int fakeId = 999;
		List<Recipe> fakeList = null;
		when(userDao.getAllPrivateRecipes(fakeId)).thenReturn(fakeList);

		userService.getAllPrivateRecipes(fakeId);

		verify(userDao).getAllPrivateRecipes(fakeId);
	}

	@Test
	public void getAllPublicRecipes() {
		int fakeId = 999;
		List<Recipe> fakeList = null;
		when(userDao.getAllPublicRecipes(fakeId)).thenReturn(fakeList);

		userService.getAllPublicRecipes(fakeId);

		verify(userDao).getAllPublicRecipes(fakeId);
	}

	@Test
	public void addRecipeToRecipeBook() {
		int fakeUserId = 999;
		int fakeRecipeId = 999;

		Recipe recipe = mock(Recipe.class);

		when(userDao.addRecipeToRecipeBook(fakeUserId,fakeRecipeId)).thenReturn(recipe);

		userService.addRecipeToRecipeBook(fakeUserId,fakeRecipeId);

		verify(userDao).addRecipeToRecipeBook(fakeUserId,fakeRecipeId);

	}

	@Test
	public void saveOrUpdate() {
		User fakeUser = mock(User.class);

		when(userDao.saveOrUpdate(fakeUser)).thenReturn(fakeUser);

		userService.saveOrUpdate(fakeUser);

		verify(userDao).saveOrUpdate(fakeUser);
	}

	@Test
	public void delete() {
		int fakeId = 999;

		userService.delete(fakeId);

		verify(userDao).delete(fakeId);

	}

	@Test
	public void deleteRecipe() {
		int fakeUserId = 999;
		int fakeRecipeId = 999;

		userService.deleteRecipe(fakeUserId,fakeRecipeId);

		verify(userDao).deleteRecipe(fakeUserId,fakeRecipeId);
	}
}