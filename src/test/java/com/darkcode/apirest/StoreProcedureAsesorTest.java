package com.darkcode.apirest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class StoreProcedureAsesorTest {

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;

    @BeforeClass
    public static void init(){
        factory = Persistence.createEntityManagerFactory("db-epi");
        entityManager = factory.createEntityManager();
    }

    @Test
    public void findAsesorNames(){
        StoredProcedureQuery findAsesorProcedure = entityManager.createNamedStoredProcedureQuery("findAsesors");

        findAsesorProcedure.getResultList();
    }
}
