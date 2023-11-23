package com.codeforall.eggrecipes.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IngredientDto {

	private Integer id;
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
