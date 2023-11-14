package com.codeforall.eggrecipes.persistence.dao;

import com.codeforall.eggrecipes.persistence.model.Model;

import java.util.List;

public interface Dao<T extends Model> {


	// Get a list of all the objects
	List<T> findAll();

	// Find object by id
	T findById(Integer id);


	// Insert or Update object
	T saveOrUpdate(T modelObject);

	// Delete object
	void delete(Integer id);
}
