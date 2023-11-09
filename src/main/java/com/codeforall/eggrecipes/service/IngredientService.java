package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.persistence.model.Ingredient;

public interface IngredientService {
	public Ingredient get(Integer id);
	public Ingredient saveOrUpdate(Ingredient ingredient);
	public void delete (Integer id);


}
