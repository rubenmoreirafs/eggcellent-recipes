package com.codeforall.eggrecipes.converters;

import com.codeforall.eggrecipes.command.RecipeDto;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeDto extends AbstractConverter<Recipe, RecipeDto> {


	@Override
	public RecipeDto convert(Recipe recipe) {

		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setId((recipe.getId()));
		recipeDto.setName(recipe.getName());
		recipeDto.setOwnerId(recipe.getOwnerId());
		recipeDto.setInstructions(recipe.getInstructions());
		recipeDto.setCreationDate(recipe.getCreationDate());
		recipeDto.setPhotoUrl(recipe.getPhotoUrl());
		recipeDto.setPrivate(recipe.getPrivate());
		recipeDto.setPrepTime(recipe.getPrepTime());

		return recipeDto;
	}
}
