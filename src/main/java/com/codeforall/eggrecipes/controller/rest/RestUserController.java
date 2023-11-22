package com.codeforall.eggrecipes.controller.rest;


import com.codeforall.eggrecipes.command.RecipeDto;
import com.codeforall.eggrecipes.command.UserDto;
import com.codeforall.eggrecipes.converters.RecipeDtoToRecipe;
import com.codeforall.eggrecipes.converters.RecipeToRecipeDto;
import com.codeforall.eggrecipes.converters.UserDtoToUser;
import com.codeforall.eggrecipes.converters.UserToUserDto;
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
@RequestMapping("/api/user")
public class RestUserController {


	private UserService userService;

	private RecipeService recipeService;

	private UserToUserDto userToUserDto;

	private UserDtoToUser userDtoToUser;

	private RecipeToRecipeDto recipeToRecipeDto;

	private RecipeDtoToRecipe recipeDtoToRecipe;

	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Autowired
	public void setRecipeToRecipeDto(RecipeToRecipeDto recipeToRecipeDto) {
		this.recipeToRecipeDto = recipeToRecipeDto;
	}

	@Autowired
	public void setRecipeDtoToRecipe(RecipeDtoToRecipe recipeDtoToRecipe) {
		this.recipeDtoToRecipe = recipeDtoToRecipe;
	}

	@Autowired
	public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
		this.userDtoToUser = userDtoToUser;
	}

	@Autowired
	public void setUserToUserDto(UserToUserDto userToUserDto) {
		this.userToUserDto = userToUserDto;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// Method to get an individual user

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<UserDto> showCustomer(@PathVariable Integer id) {
		User user = userService.get(id);

		UserDto userDto = userToUserDto.convert(user);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}


	// Method to get the list of all users

	@RequestMapping(method = RequestMethod.GET, path = {"/", ""})
	public ResponseEntity<List<UserDto>> listUsers() {

		List<UserDto> userDtos = userService.findAll().stream()
				.map(user -> userToUserDto.convert(user))
				.collect(Collectors.toList());

		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}

	// method to get the list of all public recipes
	@RequestMapping(method = RequestMethod.GET, path = {"/{id}/publiclist",})
	public ResponseEntity<List<RecipeDto>> listPublicRecipes(@PathVariable Integer id) {

		List<RecipeDto> recipeDtos = userService.getRecipes(id).stream()
				.map(recipe -> recipeToRecipeDto.convert(recipe))
				.collect(Collectors.toList());

		return new ResponseEntity<>(recipeDtos, HttpStatus.OK);
	}
	// method to get the list of all private recipes
	@RequestMapping(method = RequestMethod.GET, path = {"/{id}/privatelist",})
	public ResponseEntity<List<RecipeDto>> listPrivateRecipes(@PathVariable Integer id) {

		List<RecipeDto> recipeDtos = userService.getAllPrivateRecipes(id).stream()
				.map(recipe -> recipeToRecipeDto.convert(recipe))
				.collect(Collectors.toList());

		return new ResponseEntity<>(recipeDtos, HttpStatus.OK);
	}

	// Method to persist a new user

	@RequestMapping(method = RequestMethod.POST, path = {"/", ""})
	public ResponseEntity<?> addCustomer(@Valid @RequestBody UserDto userDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

		if (bindingResult.hasErrors() || userDto.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User savedUser = userService.saveOrUpdate(userDtoToUser.convert(userDto));

		// get help from the framework building the path for the newly created resource
		UriComponents uriComponents = uriComponentsBuilder.path("/api/user/" + savedUser.getId()).build();

		// set headers with the created path
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	// Method to add a recipe that is on the db to the user

	@RequestMapping(method = RequestMethod.POST, path = "/{uid}/recipe")
	public ResponseEntity<?> addRecipeToRecipeBook(@PathVariable Integer uid, @Valid @RequestBody RecipeDto recipeDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

		if (bindingResult.hasErrors() || recipeDto.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

			Recipe recipe = recipeDtoToRecipe.convert(recipeDto);
			recipe.setOwnerId(uid);
			userService.addRecipeToRecipeBook(uid, recipe);
			UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + uid + "/recipe/" + recipe.getId()).build();
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(uriComponents.toUri());
			return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}

	// Method to edit an already existing recipe

	@RequestMapping(method = RequestMethod.PUT, path = "/{uid}/recipe/{rid}")
	public ResponseEntity<RecipeDto> editRecipe(@Valid @RequestBody RecipeDto recipeDto, BindingResult bindingResult, @PathVariable Integer uid, @PathVariable Integer rid) {

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




	// Method to edit an already existing user

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<UserDto> editUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult, @PathVariable Integer id) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (userDto.getId() != null && !userDto.getId().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (userService.get(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		userDto.setId(id);

		userService.saveOrUpdate(userDtoToUser.convert(userDto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Method to delete a user
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<UserDto> deleteCustomer(@PathVariable Integer id) {


		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);


	}

	// Method to delete a recipe from a user recipebook
	@RequestMapping(method = RequestMethod.DELETE, path = "/{uid}/{rid}")
	public ResponseEntity<RecipeDto> deleteCustomer(@PathVariable Integer uid, @PathVariable Integer rid) {

		userService.deleteRecipeFromBook(uid, rid);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);


	}
}
