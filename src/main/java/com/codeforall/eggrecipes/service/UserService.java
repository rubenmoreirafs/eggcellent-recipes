package com.codeforall.eggrecipes.service;

import com.codeforall.eggrecipes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserService {
    EntityManagerFactory entityManagerFactory;

    public UserService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public User getUserById(int id) {
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

}
