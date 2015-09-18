/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ansty
 */
public class test {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam-preparation_JPA2PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Student());
        em.getTransaction().commit();
    }

}
