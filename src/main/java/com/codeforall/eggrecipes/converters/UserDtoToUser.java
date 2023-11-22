package com.codeforall.eggrecipes.converters;

import com.codeforall.eggrecipes.command.UserDto;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User convert(UserDto userDto) {

		User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());

		return user;
	}
}
