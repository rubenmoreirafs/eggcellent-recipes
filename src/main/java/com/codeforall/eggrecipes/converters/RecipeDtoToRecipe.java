package com.codeforall.eggrecipes.converters;

import com.codeforall.eggrecipes.command.RecipeDto;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeDtoToRecipe implements Converter<RecipeDto, Recipe> {

	RecipeService recipeService;

	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public Recipe convert(RecipeDto recipeDto) {
		Recipe recipe = (recipeDto.getId() != null ? recipeService.get(recipeDto.getId()) : new Recipe());

		recipe.setId(recipeDto.getId());
		recipe.setName(recipeDto.getName());
		recipe.setInstructions(recipeDto.getInstructions());
		recipe.setCreationDate(recipeDto.getCreationDate());
		recipe.setOwnerId(recipeDto.getOwnerId());
		recipe.setPhotoUrl(recipeDto.getPhotoUrl());
		recipe.setPrivate(recipeDto.getPrivate());
		recipe.setPrepTime(recipeDto.getPrepTime());
		return recipe;
	}
}
