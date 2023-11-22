package com.codeforall.eggrecipes.controller.rest;

import com.codeforall.eggrecipes.command.IngredientDto;
import com.codeforall.eggrecipes.converters.IngredientDtoToIngredient;
import com.codeforall.eggrecipes.converters.IngredientToIngredientDto;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.service.IngredientService;
import com.codeforall.eggrecipes.service.RecipeService;
import com.codeforall.eggrecipes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ingredient")
public class RestIngredientController {

	private UserService userService;

	private RecipeService recipeService;

	private IngredientService ingredientService;

	private IngredientToIngredientDto ingredientToIngredientDto;

	private IngredientDtoToIngredient ingredientDtoToIngredient;


	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Autowired
	public void setIngredientService(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@Autowired
	public void setIngredientToIngredientDto(IngredientToIngredientDto ingredientToIngredientDto) {
		this.ingredientToIngredientDto = ingredientToIngredientDto;
	}

	@Autowired
	public void setIngredientDtoToIngredient(IngredientDtoToIngredient ingredientDtoToIngredient) {
		this.ingredientDtoToIngredient = ingredientDtoToIngredient;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<IngredientDto> showIngredient (@PathVariable Integer id) {
		Ingredient ingredient = ingredientService.get(id);

		IngredientDto ingredientDto = ingredientToIngredientDto.convert(ingredient);

		return new ResponseEntity<>(ingredientDto, HttpStatus.OK);
	}
}
