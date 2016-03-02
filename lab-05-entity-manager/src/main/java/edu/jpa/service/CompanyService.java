package edu.jpa.service;

import edu.jpa.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 23.02.15
 */
public class CompanyService {
    private static EntityManagerFactory emf = null;
    static {
        emf = Persistence.createEntityManagerFactory("persistenceUnits.lab05.EntityManager"); // create EntityManagerFactory instance here
        init();
    }

    public Company getCompany(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Company res = em.find(Company.class, id);
        em.getTransaction().rollback();

        return res;
    }

    public void saveCompany(Company company) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
        em.close();
    }

    private static void init() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Company newCompany = new Company();
        newCompany.setName("Microsoft");
        em.persist(newCompany);
        em.getTransaction().commit();
        em.close();
    }

    public void close(){
        emf.close();
    }
}
