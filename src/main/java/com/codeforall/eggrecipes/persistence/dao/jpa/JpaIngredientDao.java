package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaIngredientDao implements IngredientDao {

	@PersistenceContext
	protected EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}


	@Override
	public List<Ingredient> findAll() {
	 return  null;	
	}

	@Override
	public Ingredient findById(Integer id) {
			return em.find(Ingredient.class, id);
	}

	@Override
	public Ingredient saveOrUpdate(Ingredient modelObject) {
		return em.merge(modelObject);
	}

	@Override
	public void delete(Integer id) {

	}
}
