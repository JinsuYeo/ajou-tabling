package com.example.demo.repository;

import com.example.demo.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public Long save(User user) {

        em.persist(user);
        return user.getId();
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public User findByEmail(String email) {
        return (User) em.createQuery("select u from User u where u.email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }
}
