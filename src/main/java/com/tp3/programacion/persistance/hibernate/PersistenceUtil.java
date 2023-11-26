package com.tp3.programacion.persistance.hibernate;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {

    /*
     * Name of persistence unit which MUST correlate to persistence-unit name in persistence.xml
     */
    private static final String PERSISTENCE_UNIT_NAME = "ScheduleModel";


    private static final EntityManagerFactory entityManagerFactory;
    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
            System.err.println("EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
