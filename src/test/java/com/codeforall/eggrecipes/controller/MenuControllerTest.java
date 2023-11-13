package com.codeforall.eggrecipes.controller;

import com.codeforall.eggrecipes.persistence.JpaintegrationTestHelper;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuControllerTest extends JpaintegrationTestHelper {

	private MenuController menuController;
	private UserServiceImpl userService;

	@Before
	public void setup() {
		userService = mock(UserServiceImpl.class);
		menuController = new MenuController();
	}


	@Test
	public void getNameById() {
		menuController.setUserService(userService);
		int fakeId = 1;
		User fakeUser = new User();
		fakeUser.setUsername("ruben");
		when(userService.get(fakeId)).thenReturn(fakeUser);

		String name = menuController.getNameById(fakeId).getUsername();

		verify(userService).get(fakeId);
		assertEquals(fakeUser.getUsername(), name);
	}
}