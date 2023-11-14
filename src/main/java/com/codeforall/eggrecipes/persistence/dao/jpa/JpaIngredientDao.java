package com.codeforall.eggrecipes.persistence.dao.jpa;

import com.codeforall.eggrecipes.persistence.dao.IngredientDao;
import com.codeforall.eggrecipes.persistence.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaIngredientDao implements IngredientDao {
	EntityManagerFactory emF;

	public JpaIngredientDao(EntityManagerFactory emF) {
		this.emF = emF;
	}

	@Override
	public List<Ingredient> findAll() {
	 return  null;	
	}

	@Override
	public Ingredient findById(Integer id) {
		EntityManager em =  emF.createEntityManager();
		try {
			return em.find(Ingredient.class, id);
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

	@Override
	public Ingredient saveOrUpdate(Ingredient modelObject) {
		EntityManager em = emF.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(modelObject);
			tx.commit();
			return modelObject;
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Integer id) {

	}
}
