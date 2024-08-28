package org.example.daos;

import org.example.entities.Student;
import org.example.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDAO implements IDAO<Student> {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    @Override
    public Student getById(Integer id) {
        try (EntityManager em = emf.createEntityManager()){
            return em.find(Student.class, id);
        }
    }

    @Override
    public Set<Student> getAll() {
        try (EntityManager em = emf.createEntityManager()){
            TypedQuery<Student> query = em.createQuery("SELECT u FROM Student u", Student.class);
            List<Student> studentList = query.getResultList();
            return studentList.stream().collect(Collectors.toSet());
        }
    }

    @Override
    public void create(Student student) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();

        }
    }

    @Override
    public void update(Student student) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Student student) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }
    }
}
