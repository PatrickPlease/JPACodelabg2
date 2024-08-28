package org.example.daos;

import org.example.entities.Person;
import org.example.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonDAO implements IDAO<Person> {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    @Override
    public Person getById(Integer id) {
        try (EntityManager em = emf.createEntityManager()){
            return em.find(Person.class, id);
        }
    }

    @Override
    public Set<Person> getAll() {
        try (EntityManager em = emf.createEntityManager()){
            TypedQuery<Person> query = em.createQuery("SELECT u FROM Person u", Person.class);
            List<Person> personList = query.getResultList();
            return personList.stream().collect(Collectors.toSet());
        }
    }

    @Override
    public void create(Person user) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public void update(Person user) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Person user) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }
}
