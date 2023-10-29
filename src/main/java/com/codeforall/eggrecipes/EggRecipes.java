package com.codeforall.eggrecipes;

import com.codeforall.eggrecipes.model.User;
import com.codeforall.eggrecipes.persistence.JPABootstrap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EggRecipes {
    public static void main(String[] args) {
        JPABootstrap jpa = new JPABootstrap();
        EntityManagerFactory emf = jpa.start();
        User user = new User();

        EntityManager em = emf.createEntityManager();

        try {
            user = em.find(User.class, 1);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        System.out.println(user.getUsername());

        jpa.stop();
    }
}
