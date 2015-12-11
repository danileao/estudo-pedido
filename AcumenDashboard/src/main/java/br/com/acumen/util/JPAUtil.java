/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acumen.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe utilitária para obtenção do EntityManager no sistema.
 *
 * @author Mozart
 */
public final class JPAUtil {

    private static final String PERSISTENCE_UNIT = "MozartPU";
    private static final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();
    private static EntityManagerFactory entityManagerFactory;

    /**
     * Retorna uma instância do EntityManager.
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        EntityManager entityManager = threadEntityManager.get();

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
            threadEntityManager.set(entityManager);
        }

        return entityManager;
    }

    /**
     * 
     */
    public static void closeEntityManager() {
        EntityManager em = threadEntityManager.get();
        if (em != null) {
            EntityTransaction transaction = em.getTransaction();
            if (transaction.isActive()) {
                transaction.commit();
            }
            em.close();
            threadEntityManager.set(null);
        }
    }
}
