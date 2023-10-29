package com.codeforall.eggrecipes.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class JPABootstrap {
    private EntityManagerFactory emf;

    public EntityManagerFactory start() {
        emf = Persistence.createEntityManagerFactory("test");
        return emf;
    }

    public void stop() {
        emf.close();
    }
}
