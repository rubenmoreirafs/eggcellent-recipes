package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.JpaintegrationTestHelper;
import com.codeforall.eggrecipes.persistence.dao.UserDao;
import com.codeforall.eggrecipes.persistence.dao.jpa.JpaUserDao;
import com.codeforall.eggrecipes.persistence.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;


public class UserServiceImplTest extends JpaintegrationTestHelper {

	UserDao userDao;

	@Before
	public void setup() {
		userDao = new JpaUserDao(emf);
	}

	@Test
	public void get() {

		String fakeName = em.find(User.class, 1).getUsername();

		String name = userDao.findById(1).getUsername();

		assertEquals(fakeName, name);

	}
}