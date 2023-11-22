package com.codeforall.eggrecipes.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	private Integer id;

	@NotNull(message = "Username is mandatory")
	@NotBlank(message = "Username is mandatory")
	@Size(min = 3, max = 64)
	private String username;

	@NotNull(message = "Password is mandatory")
	@NotBlank(message= "Password is mandatory")
	@Size(min = 3, max = 64)
	private String password;


	@Email
	@NotBlank(message = "Email is mandatory")
	private String email;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

