package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.model.Recipe;
import com.codeforall.eggrecipes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class UserServiceImpl implements UserService {
    EntityManagerFactory entityManagerFactory;

    public UserServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public User get(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user;

        try {
            user = entityManager.find(User.class, id);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return user;
    }

    @Override
    public Set<Recipe> getRecipeBook(int id) {
        return null;
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
