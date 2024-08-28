package org.example.daos;

import org.example.entities.Course;
import org.example.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseDAO implements IDAO<Course> {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    @Override
    public Course getById(Integer id) {
        try (EntityManager em = emf.createEntityManager()){
            return em.find(Course.class, id);
        }
    }

    @Override
    public Set<Course> getAll() {
        try (EntityManager em = emf.createEntityManager()){
            TypedQuery<Course> query = em.createQuery("SELECT u FROM Course u", Course.class);
            List<Course> courseList = query.getResultList();
            return courseList.stream().collect(Collectors.toSet());
        }
    }

    @Override
    public void create(Course course) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();

        }
    }

    @Override
    public void update(Course course) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Course course) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }
    }
}
