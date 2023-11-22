package com.codeforall.eggrecipes.converters;

import com.codeforall.eggrecipes.command.IngredientDto;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientDto extends AbstractConverter<Ingredient, IngredientDto> {


	@Override
	public IngredientDto convert(Ingredient ingredient) {

		IngredientDto ingredientDto = new IngredientDto();
		ingredientDto.setId(ingredient.getId());
		ingredientDto.setName(ingredient.getName());

		return ingredientDto;
	}
}
