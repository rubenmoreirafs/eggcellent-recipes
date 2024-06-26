package com.codeforall.eggrecipes.command;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class RecipeDto {

	private Integer id;

	@NotNull (message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 64)
	private String name;
	@NotNull (message = "Access setting is mandatory")
	private Boolean isPrivate;
	@NotNull (message = "Instructions is mandatory")
	@NotBlank(message = "INstructions is mandatory")
	private String instructions;


	private Integer ownerId;

	@JsonFormat
	private Date creationDate;

	@NotNull (message = "Prep time is mandatory")
	private Integer prepTime;

	private String photoUrl;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPrivate() {
		return isPrivate;
	}

	public void setPrivate(Boolean aPrivate) {
		isPrivate = aPrivate;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
