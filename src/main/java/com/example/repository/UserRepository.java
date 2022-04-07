package com.example.repository;

import com.example.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(User user) {
        em.persist(user);
        return user.getUserId();
    }

    public User find(Long userId) {
        return em.find(User.class, userId);
    }
}
