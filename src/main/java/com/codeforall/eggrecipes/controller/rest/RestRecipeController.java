package com.codeforall.eggrecipes.controller.rest;

import com.codeforall.eggrecipes.command.IngredientDto;
import com.codeforall.eggrecipes.command.RecipeDto;
import com.codeforall.eggrecipes.command.UserDto;
import com.codeforall.eggrecipes.converters.IngredientDtoToIngredient;
import com.codeforall.eggrecipes.converters.IngredientToIngredientDto;
import com.codeforall.eggrecipes.converters.RecipeDtoToRecipe;
import com.codeforall.eggrecipes.converters.RecipeToRecipeDto;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import com.codeforall.eggrecipes.persistence.model.Recipe;
import com.codeforall.eggrecipes.persistence.model.User;
import com.codeforall.eggrecipes.service.RecipeService;
import com.codeforall.eggrecipes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/recipe")
public class RestRecipeController {

	private UserService userService;

	private RecipeService recipeService;

	private RecipeDtoToRecipe recipeDtoToRecipe;

	private RecipeToRecipeDto recipeToRecipeDto;

	private IngredientDtoToIngredient ingredientDtoToIngredient;

	private IngredientToIngredientDto ingredientToIngredientDto;

	@Autowired
	public void setIngredientDtoToIngredient(IngredientDtoToIngredient ingredientDtoToIngredient) {
		this.ingredientDtoToIngredient = ingredientDtoToIngredient;
	}

	@Autowired
	public void setIngredientToIngredientDto(IngredientToIngredientDto ingredientToIngredientDto) {
		this.ingredientToIngredientDto = ingredientToIngredientDto;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Autowired
	public void setRecipeDtoToRecipe(RecipeDtoToRecipe recipeDtoToRecipe) {
		this.recipeDtoToRecipe = recipeDtoToRecipe;
	}

	@Autowired
	public void setRecipeToRecipeDto(RecipeToRecipeDto recipeToRecipeDto) {
		this.recipeToRecipeDto = recipeToRecipeDto;
	}


	// Method to get a specific recipe
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<RecipeDto> showRecipe(@PathVariable Integer id) {
		Recipe recipe = recipeService.get(id);

		RecipeDto recipeDto = recipeToRecipeDto.convert(recipe);

		return new ResponseEntity<>(recipeDto, HttpStatus.OK);
	}

	// Method to get the list of all recipes in the db
	@RequestMapping(method = RequestMethod.GET, path = {"/list", ""})
	public ResponseEntity<List<RecipeDto>> listRecipes() {

		List<RecipeDto> recipeDtos = recipeService.findAll().stream()
				.map(recipe -> recipeToRecipeDto.convert(recipe))
				.collect(Collectors.toList());

		return new ResponseEntity<>(recipeDtos, HttpStatus.OK);
	}
	// Method to get the list of all public recipes in the db
	@RequestMapping(method = RequestMethod.GET, path = {"/publiclist",})
	public ResponseEntity<List<RecipeDto>> listAllPublicRecipes() {

		List<RecipeDto> recipeDtos = recipeService.getAllPublicRecipes().stream()
				.map(recipe -> recipeToRecipeDto.convert(recipe))
				.collect(Collectors.toList());

		return new ResponseEntity<>(recipeDtos, HttpStatus.OK);
	}

	// Method to get the list of all ingredients of a specific recipe
	@RequestMapping(method = RequestMethod.GET, path = {"/{id}/ingredientlist",})
	public ResponseEntity<List<IngredientDto>> listAllIngredients(@PathVariable Integer id) {

		List<IngredientDto> ingredientDtos = recipeService.getIngredientList(id).stream()
				.map(ingredient -> ingredientToIngredientDto.convert(ingredient))
				.collect(Collectors.toList());

		return new ResponseEntity<>(ingredientDtos, HttpStatus.OK);
	}

	// Method to add a recipe

	@RequestMapping(method = RequestMethod.POST, path = {"/", ""})
	public ResponseEntity<?> addRecipe(@Valid @RequestBody RecipeDto recipeDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

		if (bindingResult.hasErrors() || recipeDto.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(recipeDto.getOwnerId() == null) {
			recipeDto.setOwnerId(1);
		}

		Recipe savedRecipe = recipeService.saveOrUpdate(recipeDtoToRecipe.convert(recipeDto));

		// get help from the framework building the path for the newly created resource
		UriComponents uriComponents = uriComponentsBuilder.path("/api/recipe/" + savedRecipe.getId()).build();

		// set headers with the created path
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}





	// Method to add ingredients of a recipe
// this is already mapped by 	addrecipetorecipebook
	@RequestMapping(method = RequestMethod.POST, path = "/{rid}/ingredient")
	public ResponseEntity<?> addIngredientToIngredientList(@PathVariable Integer rid, @Valid @RequestBody IngredientDto ingredientDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

		if (bindingResult.hasErrors() || ingredientDto.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

			Ingredient ingredient = ingredientDtoToIngredient.convert(ingredientDto);
			ingredient.setRecipe(recipeService.get(rid));
			recipeService.saveOrUpdateIngredientToRecipe(rid, ingredient);
			UriComponents uriIngredient = uriComponentsBuilder.path("/api/recipe/" + rid + "/ingredient/" + ingredient.getId()).build();
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(uriIngredient.toUri());
			return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}


	// Method to edit an already existing recipe

	@RequestMapping(method = RequestMethod.PUT, path = "/{rid}/user/{uid}")
	public ResponseEntity<RecipeDto> editRecipe(@Valid @RequestBody RecipeDto recipeDto, BindingResult bindingResult, @PathVariable Integer rid, @PathVariable Integer uid) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


		if (userService.get(uid) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (recipeDto.getId() != null && !recipeDto.getId().equals(rid)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (recipeService.get(uid) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		recipeDto.setId(rid);
		recipeService.saveOrUpdate(recipeDtoToRecipe.convert(recipeDto));

		return new ResponseEntity<>(HttpStatus.OK);
	}




	// Method to delete a recipe
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<RecipeDto> deleteRecipe(@PathVariable Integer id) {


		recipeService.deleteRecipe(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);


	}

	// Method to delete an ingredient from a recipe
	@RequestMapping(method = RequestMethod.DELETE, path = "/{rid}/{iid}")
	public ResponseEntity<RecipeDto> deleteIngredientFromRecipe(@PathVariable Integer rid, @PathVariable Integer iid) {

		recipeService.deleteIngredient(rid, iid);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);


	}

}
