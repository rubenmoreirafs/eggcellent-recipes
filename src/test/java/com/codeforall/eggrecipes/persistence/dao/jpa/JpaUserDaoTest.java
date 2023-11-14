package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.JpaintegrationTestHelper;
import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class JpaUserDaoTest extends JpaintegrationTestHelper {

	private UserDao userDao;

	@Before
	void setup(){
		userDao = new JpaUserDao(emf);
	}

	@Test
	public void findAll() {
	}

	@Test
	public void findById() {
		String fakeName = em.find(User.class, 1).getUsername();

		String name = userDao.findById(1).getUsername();

		assertEquals(fakeName, name);
	}

	@Test
	void saveOrUpdate() {
	}

	@Test
	public void delete() {
	}

	@Test
	public void getAllPrivateRecipes() {
	}

	@Test
	public void getAllPublicRecipes() {
	}

	@Test
	public void getRecipeBook() {
	}

	@Test
	public void addRecipeToRecipeBook() {
	}

	@Test
	public void deleteRecipe() {
	}
}