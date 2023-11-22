package com.codeforall.eggrecipes.converters;

import com.codeforall.eggrecipes.command.IngredientDto;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientDtoToIngredient implements Converter<IngredientDto, Ingredient> {

	private IngredientService ingredientService;

	@Autowired
	public void setIngredientService(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@Override
	public Ingredient convert(IngredientDto ingredientDto) {
		Ingredient ingredient = (ingredientDto.getId() != null ? ingredientService.get(ingredientDto.getId()) : new Ingredient());

		ingredient.setName(ingredientDto.getName());


		return ingredient;
	}
}
