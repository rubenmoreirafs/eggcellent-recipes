package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.JpaintegrationTestHelper;
import com.codeforall.eggrecipes.persistence.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;


public class UserServiceImplTest extends JpaintegrationTestHelper {

	UserServiceImpl userService;

	@Before
	public void setup() {
		userService = new UserServiceImpl(emf);
	}

	@Test
	public void get() {

		String fakeName = em.find(User.class, 1).getUsername();

		String name = userService.get(1).getUsername();

		assertEquals(fakeName, name);


	}
}