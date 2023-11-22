package com.codeforall.eggrecipes.converters;

import com.codeforall.eggrecipes.command.UserDto;
import com.codeforall.eggrecipes.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverter<User, UserDto> {


	@Override
	public UserDto convert(User user) {

		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());

		return userDto;
	}
}
