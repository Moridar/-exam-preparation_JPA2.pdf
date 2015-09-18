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
public class facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam-preparation_JPA2PU");
    EntityManager em = emf.createEntityManager();

    public void addStudent() {
        em.getTransaction().begin();
        em.persist(new Student());
        em.getTransaction().commit();
    }
    public void addStudent(Student s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    public void editStudent(Student s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    
    public Student findStudent(String name){
        return (Student) em.createQuery("SELECT s FROM Student s WHERE s.firstName = '" + name + "'").getSingleResult();
    }

    public Student findStudent(int id){
        return (Student) em.createQuery("SELECT s FROM Student s WHERE s.id = " + id).getSingleResult();
    }

    public static void main(String[] args) {
        facade f = new facade();
//        Student s = new Student();
//        f.addStudent(s);
        Student s = f.findStudent(1);
        s.setFirstName("Bobbie");
        f.editStudent(s);
        System.out.println(f.findStudent("Bobbie"));

    }
}
